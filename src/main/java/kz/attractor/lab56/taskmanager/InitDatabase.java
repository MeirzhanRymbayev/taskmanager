package kz.attractor.lab56.taskmanager;

import kz.attractor.lab56.taskmanager.model.User;
import kz.attractor.lab56.taskmanager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;


@Configuration
@AllArgsConstructor
public class InitDatabase {


    public static long counter;
    private UserService userService;
    private PasswordEncoder encoder;


    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {
            userService.deleteAll();

            User user1 = new User();
            user1.setId(++counter);
            user1.setLogin("Chingiz");
            user1.setEmail("test@test");
            user1.setPassword(encoder.encode("test"));
//            user1.setRole("GUEST");
            userService.register(user1);

            User user2 = new User();
            user2.setId(++counter);
            user2.setLogin("Anuar");
            user2.setEmail("guest@test");
            user2.setPassword(encoder.encode("guest"));
//            user2.setRole("ADMIN");
            userService.register(user2);

            User user3 = new User();
            user3.setId(++counter);
            user3.setLogin("Timur");
            user3.setEmail("admin@test");
            user3.setPassword(encoder.encode("admin"));
//            user3.setRole("READER");
            userService.register(user3);

        };
    }


}
