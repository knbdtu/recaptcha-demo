package com.ril.ajio.recaptchademo.service;

import com.ril.ajio.recaptchademo.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public String createUser(User user);

    public List<User> getAllUsers();

    Optional<User> getOneUser(String userId);
}
