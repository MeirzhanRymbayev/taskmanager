package kz.attractor.lab56.taskmanager;

import kz.attractor.lab56.taskmanager.model.Task;
import kz.attractor.lab56.taskmanager.model.User;
import kz.attractor.lab56.taskmanager.repository.UserRepository;
import kz.attractor.lab56.taskmanager.service.TaskService;
import kz.attractor.lab56.taskmanager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@Configuration
@AllArgsConstructor
public class InitDatabase {

    private UserService userService;
    private UserRepository userRepository;
    private TaskService taskService;
    private PasswordEncoder encoder;


    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {
            generateUsers();

            final List<User> users = (List<User>) userRepository.findAll();
            final Random random = new Random();
            taskService.deleteAll();
            taskService.generate(Task.builder().title("Make the shelter").description("Make it sturdy").date(LocalDateTime.now().minusDays(1)).user(users.get(random.nextInt(users.size()))).status(Task.Status.NEW).build());
            taskService.generate(Task.builder().title("Repair the shelter").description("Make it safe and cozy.").date(LocalDateTime.now().plusDays(1)).user(users.get(random.nextInt(users.size()))).status(Task.Status.IN_PROGRESS).build());
            taskService.generate(Task.builder().title("Gather some firewood").description("To keep the fireplace running").date(LocalDateTime.now().plusDays(1)).user(users.get(random.nextInt(users.size()))).status(Task.Status.DONE).build());
            taskService.generate(Task.builder().title("Winter is coming!").description("Survive the winter!").date(LocalDateTime.now().plusDays(1)).user(users.get(random.nextInt(users.size()))).status(Task.Status.DONE).build());
        };
    }

    private void generateUsers() {
        userService.deleteAll();

        User user1 = new User();
        user1.setLogin("Chingiz");
        user1.setEmail("test@test");
        user1.setPassword(encoder.encode("test"));
        userService.register(user1);

        User user2 = new User();
        user2.setLogin("Anuar");
        user2.setEmail("guest@test");
        user2.setPassword(encoder.encode("guest"));
        userService.register(user2);

        User user3 = new User();
        user3.setLogin("Timur");
        user3.setEmail("admin@test");
        user3.setPassword(encoder.encode("admin"));
        userService.register(user3);
    }


}
