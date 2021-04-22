package com.example.AmazonMini.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User,String> {

    User getUserByEmail(String email);
}
