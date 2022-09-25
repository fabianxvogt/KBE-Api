package com.kbe.shoppingapp.model;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class ShoppingCart {

  @Transient
  public static final String SEQUENCE_NAME = "shoppingCart";

  //ID hinzufügen, um shopping cart für jeden User individuell zu gestalten
  private @Id String userMail;
  private List<Product> prodcutsInCart; 
  private double totalAmount;
  
  
  ShoppingCart() {}

  ShoppingCart(List<Product> productsInCart, User user) {

    this.prodcutsInCart = productsInCart;
    this.totalAmount = 0;
    this.userMail = user.getEmail();
  }

  public void addToCart(Product p) {
    this.prodcutsInCart.add(p);
    getTotalAmount();
}
public void showCart() {
    ListIterator<Product> iterator = prodcutsInCart.listIterator();
    while(iterator.hasNext()) {
        Product p = iterator.next();
        System.out.println(p);
    }
    getTotalAmount();
}
public void removeFromCart(Product toBeRemoved) {
    ListIterator<Product> iterator = prodcutsInCart.listIterator();
    while(iterator.hasNext()) {
        Product p = iterator.next();
        if (p.getId().equals(toBeRemoved.getId())) {
            this.prodcutsInCart.remove(toBeRemoved);
            break;
        }
    }
    getTotalAmount();
}
public double getTotalAmount() {
    ListIterator<Product> iterator = prodcutsInCart.listIterator();
    this.totalAmount = 0;
    while(iterator.hasNext()) {
        Product p = iterator.next();
        this.totalAmount = this.totalAmount + (p.getPrice());
    }
    return this.totalAmount;
}

/* 
  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Product))
      return false;
      Product p = (Product) o;
    return Objects.equals(this.id, p.id) && Objects.equals(this.name, p.name);
  }


  @Override
  public String toString() {
    return "Component{" + 
      "id=" + this.id + ", " + 
      "name='" + this.name + "\'," +
      "componentTypeId=" + this.componentTypeId + 
    "}";
  }
  */
  
}