package com.example.AmazonMini.services;

import com.example.AmazonMini.models.User;
import com.example.AmazonMini.models.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public void addUser(User user)
    {
        repo.insert(user);
    }

    public List<User> getUsers()
    {
        return repo.findAll();
    }

    public void deleteUser(String id)
    {
        repo.deleteById(id);
    }

    public Optional<User> getAUser(String id)
    {
        return repo.findById(id);
    }

    public User signInUser(String email)
    {
        return repo.getUserByEmail(email);
    }
}
