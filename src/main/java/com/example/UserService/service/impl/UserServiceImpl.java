package com.example.UserService.service.impl;

import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        log.info("Create new User{}", user);

        User anotherUser = new User();
        anotherUser.setEmail(user.getEmail());
        // password encoding
        anotherUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        anotherUser.setFirstName(user.getFirstName());
        anotherUser.setLastName(user.getLastName());
        anotherUser.setRole(user.getRole());

        return userRepository.save(anotherUser);
    }

    @Override
    public User update(User user) {
        log.info("Update User{}", user);

        User anotherUser = new User();
        anotherUser.setEmail(user.getEmail());
        // password encoding
        anotherUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        anotherUser.setFirstName(user.getFirstName());
        anotherUser.setLastName(user.getLastName());
        anotherUser.setRole(user.getRole());

        return userRepository.save(anotherUser);
    }

    @Override
    public User getById(Long id) {
        log.info("Get User by id {}", id);
        return userRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete User bu id {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        log.info("Get all Users");
        return userRepository.findAll();
    }
}
