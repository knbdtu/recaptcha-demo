package com.ril.ajio.recaptchademo.service;

import com.ril.ajio.recaptchademo.model.User;

import java.util.List;

public interface IUserService {

    public String createUser(User user);

    public List<User> getAllUsers();
}
