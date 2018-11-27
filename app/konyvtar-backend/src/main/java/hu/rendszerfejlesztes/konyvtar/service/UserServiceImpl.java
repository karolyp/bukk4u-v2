package hu.rendszerfejlesztes.konyvtar.service;


import java.util.Date;
import java.util.UUID;

import hu.rendszerfejlesztes.konyvtar.exception.InvalidTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import hu.rendszerfejlesztes.konyvtar.exception.KonyvtarException;
import hu.rendszerfejlesztes.konyvtar.exception.UserExistsException;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.Role;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.Token;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.User;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto.UserDTO;
import hu.rendszerfejlesztes.konyvtar.model.repository.TokenRepository;
import hu.rendszerfejlesztes.konyvtar.model.repository.UserRepository;
import hu.rendszerfejlesztes.konyvtar.utils.BCrypt;

@Service
public class UserServiceImpl implements UserService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String USER_NOT_EXISTS = "Ilyen felhasználó nem létezik!";
    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository,
                           TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDto) throws UserExistsException {
        if (userRepository.findOneByUsername(userDto.getUsername()) == null) {
            User user = new User();
            user.setActive(true);
            user.setRole(Role.USER);
            user.setUsername(userDto.getUsername());
            user.setbCryptHash(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt()));
            return userRepository.save(user).toDto();
        } else {
            throw new UserExistsException("User already exists in the database!");
        }
    }

    @Override
    public Token loginUser(UserDTO userDTO) throws KonyvtarException {
        User u = userRepository.findOneByUsername(userDTO.getUsername());
        if (u != null) {
            if (BCrypt.checkpw(userDTO.getPassword(), u.getbCryptHash())) {
                if (u.isActive()) {
                    if (u.getToken() != null) {
                        u.getToken().setExpiresAt(new Date());
                        u.getToken().setTokenUuid(UUID.randomUUID());
                    } else {
                        Token t = new Token();
                        t.setExpiresAt(new Date());
                        t.setTokenUuid(UUID.randomUUID());
                        u.setToken(t);
                    }
                    userRepository.save(u);
                    return u.getToken();
                } else {
                    throw new KonyvtarException("A hozzáférést felfüggesztették.");
                }
            } else {
                throw new KonyvtarException("A jelszó helytelen.");

            }
        } else {
            throw new KonyvtarException(USER_NOT_EXISTS);
        }
    }

    @Override
    public UserDTO getUser(String username, String token) throws KonyvtarException {
        User user = userRepository.findOneByUsername(username);
        if (user != null && user.getToken() != null) {
            if (user.getToken().getTokenUuid().toString().equals(token)) {
                return user.toDto();
            } else {
                throw new InvalidTokenException("Nem megfelelo token.");
            }
        } else {
            throw new KonyvtarException("Felhasználó/token nem található.");
        }
    }

}
