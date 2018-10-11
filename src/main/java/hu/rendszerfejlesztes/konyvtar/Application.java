package hu.rendszerfejlesztes.konyvtar;

import hu.rendszerfejlesztes.konyvtar.model.Customer;
import hu.rendszerfejlesztes.konyvtar.model.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "hu.rendszerfejlesztes.konyvtar")
@EnableJpaRepositories(basePackages = {"hu.rendszerfejlesztes.konyvtar.model.repositories"})
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return arg ->
            customerRepository.saveAll(Arrays.asList(
                    new Customer("Jack", "Bauer"),
                    new Customer("Chloe", "O'Brian"),
                    new Customer("Kim", "Bauer"),
                    new Customer("David", "Palmer"),
                    new Customer("Michelle", "Dessler")
                    )
            );
    }

}
