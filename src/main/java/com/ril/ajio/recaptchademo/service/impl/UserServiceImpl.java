package com.ril.ajio.recaptchademo.service.impl;

import com.ril.ajio.recaptchademo.model.User;
import com.ril.ajio.recaptchademo.repository.UserRepository;
import com.ril.ajio.recaptchademo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        String userId= userRepository.save(user).getId();
        return userId;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= userRepository.findAll();
        return users;
    }
}
