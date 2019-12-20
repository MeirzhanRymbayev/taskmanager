package kz.attractor.lab56.taskmanager.service;

import kz.attractor.lab56.taskmanager.dto.UserDto;
import kz.attractor.lab56.taskmanager.model.User;
import kz.attractor.lab56.taskmanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UserService {

    public static long counter;
    private UserRepository userRepository;


    public User register(User user) {
        user.setId(++counter);
        return userRepository.save(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<UserDto> findAll() {
        var iter = userRepository.findAll();
        return StreamSupport.stream(iter.spliterator(), true)
                .map(u -> UserDto.builder()
                        .id(u.getId())
                        .login(u.getLogin())
                        .email(u.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

}
