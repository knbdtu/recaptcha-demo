package com.ril.ajio.recaptchademo.repository;

import com.ril.ajio.recaptchademo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
