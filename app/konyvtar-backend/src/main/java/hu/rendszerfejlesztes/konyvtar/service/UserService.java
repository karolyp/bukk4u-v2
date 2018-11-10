package hu.rendszerfejlesztes.konyvtar.service;

import hu.rendszerfejlesztes.konyvtar.exception.UserExistsException;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto.UserDTO;

public interface UserService {

    UserDTO saveUser(UserDTO user) throws UserExistsException;

}
