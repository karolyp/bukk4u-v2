package hu.rendszerfejlesztes.konyvtar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import hu.rendszerfejlesztes.konyvtar.exception.UserExistsException;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.Role;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.User;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto.UserDTO;
import hu.rendszerfejlesztes.konyvtar.model.repository.UserRepository;
import hu.rendszerfejlesztes.konyvtar.utils.BCrypt;
import lombok.extern.slf4j.Slf4j;

@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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

}
