package com.kbe.shoppingapp.controller;

import com.kbe.shoppingapp.exception.EmailAlreadyExistsException;
import com.kbe.shoppingapp.model.User;
import com.kbe.shoppingapp.service.IUserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping("/user/signup")
  public User signUp(
    @RequestBody User user
  ) throws EmailAlreadyExistsException {
    return (User) this.userService.signUp(user);
  }

  @PostMapping("/user/signin")
  public User signIn(
    @RequestBody User user
  ) throws Exception {
    return (User) this.userService.signIn(user.getEmail(), user.getPassword());
  }
  @GetMapping("/user")
  public List<User> getUsers() {
    return (List<User>) this.userService.readAll();
  }
  
}