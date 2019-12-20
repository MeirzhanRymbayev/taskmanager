package kz.attractor.lab56.taskmanager.service;

import kz.attractor.lab56.taskmanager.model.User;
import kz.attractor.lab56.taskmanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<User> optUser = userRepository.getByEmail(username);

        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("Not found!");
        }

        return optUser.get();
    }

}