package hu.rendszerfejlesztes.konyvtar.rest;

import hu.rendszerfejlesztes.konyvtar.exception.KonyvtarException;
import hu.rendszerfejlesztes.konyvtar.exception.UserExistsException;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.Token;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto.UserDTO;
import hu.rendszerfejlesztes.konyvtar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    @ResponseBody
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDto) {
        log.info("Incoming UserRegistration request.");
        ResponseEntity<?> response;
        try {
            response = ResponseEntity.ok(userService.saveUser(userDto));
        } catch (UserExistsException e) {
            response = ResponseEntity.badRequest().body(e.getMessage());
        }

        return response;
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public ResponseEntity<?> getUser(@RequestBody UserDTO userDTO) {
        log.info("Incoming login request.");
        ResponseEntity<?> response;

        try {
            response = ResponseEntity.ok(userService.getUser(userDTO));
        } catch (KonyvtarException e) {
            response = ResponseEntity.badRequest().body(e.getMessage());
        }

        return response;
    }


}
