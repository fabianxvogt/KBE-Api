package com.kbe.shoppingapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document
public class ShoppingCart {

  @Transient
  public static final String SEQUENCE_NAME = "cart";


  // ID hinzufügen, um shopping cart für jeden User individuell zu gestalten
  private @Id String cartID;
  private String userID;
  private List<CartItem> productsInCart = new ArrayList<CartItem>();
  private float totalAmount;


  ShoppingCart() {
  }

  ShoppingCart(User user){
    this.userID = user.getEmail();
    productsInCart = new ArrayList<CartItem>();
    totalAmount = 0f;
  }

  public void addToCart(Product p) {
    CartItem ci = new CartItem(p);
    this.productsInCart.add(ci);
  }

/*
  public void showCart() {

  }

  public void removeFromCart(Product toBeRemoved) {
    Integer quantity = productsInCart.get(toBeRemoved.getId());
    if (productsInCart.containsKey(productsInCart.getId()))
      productsInCart.put(p.getId(), quantity + 1);
    else
      productsInCart.put(p.getId(), 1);
    getTotalAmount();
  }

public double getTotalAmount() {
  double total;
  Iterator pIC = productsInCart.entrySet().iterator();
  while (pIC.hasNext()) {
      HashMap.Entry pair = (HashMap.Entry)pIC.next();
       double productPrice = pair.getKey().getPrice();
       productPrice * pair.getValue() = productPrice;
      pIC.remove(); // avoids a ConcurrentModificationException
  }
  for (Map.Entry<String, Integer> entry : productsInCart.entrySet()) {
      entry.getKey().
  }
  
}

  
   * @Override
   * public boolean equals(Object o) {
   * 
   * if (this == o)
   * return true;
   * if (!(o instanceof Product))
   * return false;
   * Product p = (Product) o;
   * return Objects.equals(this.id, p.id) && Objects.equals(this.name, p.name);
   * }
   * 
   * 
   * @Override
   * public String toString() {
   * return "Component{" +
   * "id=" + this.id + ", " +
   * "name='" + this.name + "\'," +
   * "componentTypeId=" + this.componentTypeId +
   * "}";
   * }
   */

}