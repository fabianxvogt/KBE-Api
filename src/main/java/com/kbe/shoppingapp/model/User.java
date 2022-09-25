package com.kbe.shoppingapp.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class User {

  @Transient
  public static final String SEQUENCE_NAME = "user";

  //private String id;
  private @Id String email;
  private String password; // TODO: Hash
  private String firstname;
  private String lastname;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  
  public User() {}  

  public User(String email, String password, String firstname, String lastname) {
    this.email = email;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
  }
  @Override
  public String toString() {
    return "User{" + 
      "email=" + this.email + ", " + 
      "password='" + this.password + "\'" +
      "firstname=" + this.firstname + "\'" +
      "lastname=" + this.lastname + "\'" +
    "}";
  }
}