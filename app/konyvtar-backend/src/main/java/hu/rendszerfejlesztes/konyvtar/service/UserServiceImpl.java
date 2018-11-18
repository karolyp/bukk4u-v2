package hu.rendszerfejlesztes.konyvtar.service;


import java.util.Date;
import java.util.UUID;

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

	private final Logger log = LoggerFactory.getLogger(getClass());
	
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
    public Token getUser(UserDTO userDTO) throws KonyvtarException {
        User u = userRepository.findOneByUsername(userDTO.getUsername());
        if (u != null) {
            if (BCrypt.checkpw(userDTO.getPassword(), u.getBCryptHash())) {
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
            throw new KonyvtarException("Ilyen felhasználó nem létezik!");
        }
    }


}
