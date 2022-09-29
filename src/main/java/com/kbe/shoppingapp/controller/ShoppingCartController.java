package com.kbe.shoppingapp.controller;
import java.util.List;

import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.model.ShoppingCart;
import com.kbe.shoppingapp.service.IShoppingCartService;
import com.kbe.shoppingapp.utils.SequenceGeneratorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "*")
@RestController
class ShoppingCartController {

  @Autowired
  private IShoppingCartService shoppingCartService;


  @GetMapping("/cart")
  public List<ShoppingCart> getShoppingCartItems() {
    return (List<ShoppingCart>) this.shoppingCartService.readAll();
  }

  @GetMapping("/cart/{id}")
  public ShoppingCart getShoppingCartById(
    @PathVariable("id") String id
  ) {
    ShoppingCart shoppingCart = (ShoppingCart) this.shoppingCartService.readById(id);
    return shoppingCart;
  }

  @PostMapping("/cart")
  ShoppingCart insertShoppingCart(@RequestBody ShoppingCart shoppingCart) {
    //category.setId(sequenceGeneratorService.generateSequence(Category.SEQUENCE_NAME));
    return this.shoppingCartService.create(shoppingCart);
  }

  @PatchMapping("/cart/{id}")
  public ShoppingCart updateShoppingCart(@PathVariable("id") String id, @RequestBody ShoppingCart shoppingCart, @RequestBody Product p) {
    return this.shoppingCartService.update(shoppingCart, id, p);
  }

  @DeleteMapping("/cart/{id}")
  public String deleteCategory(@PathVariable("id") String id) {
    this.shoppingCartService.deleteById(id);

    return "deleted shopping cart from user: " + id;
  }

  @DeleteMapping("/cart")
  public String deleteAllShoppingCarts() {
    this.shoppingCartService.deleteAll();

    return "deleted all category";
  }
}