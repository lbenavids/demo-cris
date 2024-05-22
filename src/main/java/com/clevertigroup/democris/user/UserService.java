package com.clevertigroup.democris.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        userRepository.findById(user.id())
                .orElseThrow(() -> new RuntimeException("there is not users with id %s".formatted(user.id())));

        return userRepository.save(user);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("there is not users with email %s".formatted(email)));

    }

}
