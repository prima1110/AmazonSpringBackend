package com.example.AmazonMini.controllers;

import com.example.AmazonMini.DataResponse;
import com.example.AmazonMini.models.User;
import com.example.AmazonMini.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@CrossOrigin
@RestController
public class Usercontroller {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers()
    {
        var dataResponse = new DataResponse(userService.getUsers(),"All Users");
        return new ResponseEntity(dataResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/users/signup",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addUser(@RequestBody User user)
    {
        String bcryptPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(bcryptPass);
        userService.addUser(user);
        return new ResponseEntity(user,HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteAUser(@PathVariable("id") String id)
    {
        userService.deleteUser(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/users/signin", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity signInUser(@RequestBody User user)
    {
        var dataResponse = userService.signInUser(user.getEmail());
        if(BCrypt.checkpw(user.getPassword(), dataResponse.getPassword()))
        {
            return new ResponseEntity(dataResponse, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("Enter Correct Password", HttpStatus.FORBIDDEN);
        }
    }
}
