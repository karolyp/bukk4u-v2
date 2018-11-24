package hu.rendszerfejlesztes.konyvtar;

import hu.rendszerfejlesztes.konyvtar.model.entity.auth.Role;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.User;
import hu.rendszerfejlesztes.konyvtar.model.repository.UserRepository;
import hu.rendszerfejlesztes.konyvtar.utils.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KonyvtarApplication {

    public static void main(String[] args) {
        SpringApplication.run(KonyvtarApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository repository) {
        return arsg -> {
           User u = new User();
           u.setUsername("admin");
           u.setActive(true);
           u.setbCryptHash(BCrypt.hashpw("admin", BCrypt.gensalt()));
           u.setRole(Role.ADMIN);
//           repository.save(u);
        };
    }

}
