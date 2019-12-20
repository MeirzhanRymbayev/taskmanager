package kz.attractor.lab56.taskmanager.service;

import kz.attractor.lab56.taskmanager.InitDatabase;
import kz.attractor.lab56.taskmanager.model.User;
import kz.attractor.lab56.taskmanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;


    public User register(User user) {
        user.setId(++InitDatabase.counter);
        return userRepository.save(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
