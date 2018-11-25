package hu.rendszerfejlesztes.konyvtar.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hu.rendszerfejlesztes.konyvtar.exception.KonyvtarException;
import hu.rendszerfejlesztes.konyvtar.exception.UserExistsException;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto.UserDTO;
import hu.rendszerfejlesztes.konyvtar.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(getClass());

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

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> getUser(@RequestBody UserDTO userDTO) {
        log.info("Incoming login request.");
        ResponseEntity<?> response;

        try {
            response = ResponseEntity.ok(userService.loginUser(userDTO));
        } catch (KonyvtarException e) {
            response = ResponseEntity.badRequest().body(e.getMessage());
        }

        return response;
    }

    @GetMapping("/user")
    @ResponseBody
    public ResponseEntity<?> getUser(@RequestParam String username, HttpServletRequest request) {
        ResponseEntity<?> response;
        String authorization = request.getHeader("Authorization");

        if (authorization != null) {
            try {
                response = ResponseEntity.ok(userService.getUser(username, authorization));
            } catch (KonyvtarException e) {
                response = ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return response;
    }

}
