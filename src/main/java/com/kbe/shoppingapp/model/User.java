package com.kbe.shoppingapp.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class User {

  @Transient
  public static final String SEQUENCE_NAME = "user";

  private @Id String id;
  private String email;
  private String password; // TODO: Hash
  private String firstName;
  private String lastName;

  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public User() {}  

  public User(String email, String password, String firstName, String lastName) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  @Override
  public String toString() {
    return "User{" + 
      "id=" + this.id + ", " + 
      "email=" + this.email + ", " + 
      "password='" + this.password + "\'" +
      "firstName=" + this.firstName + "\'" +
      "lastName=" + this.lastName + "\'" +
    "}";
  }
}