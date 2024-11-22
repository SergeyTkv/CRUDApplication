package ru.javamentor.crudapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.javamentor.crudapplication.model.User;

import java.util.Arrays;
import java.util.List;

@Configuration
public class UserConfig {

    public class CarConfig {
        @Bean
        public List<User> users() {
            return Arrays.asList(
                    new User("Toyota", "Camry", 2023),
                    new User("Honda", "Civic", 2022),
                    new User("Ford", "Mustang", 2024),
                    new User("BMW", "3 Series", 2023),
                    new User("Tesla", "Model 3", 2022)
            );
        }
    }
}
