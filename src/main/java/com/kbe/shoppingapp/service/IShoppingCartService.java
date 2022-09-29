package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.ShoppingCart;
import com.kbe.shoppingapp.model.Product;

import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface IShoppingCartService {
  
    // Save operation
    ShoppingCart create(ShoppingCart shoppingCart);
  
    // Read operation
    List<ShoppingCart> readAll();

    ShoppingCart readById(String userMail);
  
    // Update operation
    ShoppingCart update(ShoppingCart shoppingCart, String userMail, Product p);
  
    // Delete operation
    void deleteById(String productId);

    void deleteAll();

}