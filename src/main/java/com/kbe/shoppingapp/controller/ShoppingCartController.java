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
  public List<ShoppingCart> getCartItems() {
    return (List<ShoppingCart>) this.shoppingCartService.readAll();
  }

  @GetMapping("/category/{id}")
  public ShoppingCart getCategoryById(
    @PathVariable("id") String id
  ) {
    ShoppingCart shoppingCart = (ShoppingCart) this.shoppingCartService.readById(id);
    return shoppingCart;
  }

  @PostMapping("/category")
  ShoppingCart insertCategory(@RequestBody ShoppingCart shoppingCart) {
    //category.setId(sequenceGeneratorService.generateSequence(Category.SEQUENCE_NAME));
    return this.shoppingCartService.create(shoppingCart);
  }

  @PatchMapping("/category/{id}")
  public ShoppingCart updateShoppingCart(@PathVariable("id") String id, @RequestBody ShoppingCart shoppingCart) {
    return this.shoppingCartService.update(shoppingCart, id);
  }

  @DeleteMapping("/category/{id}")
  public String deleteCategory(@PathVariable("id") String id) {
    this.shoppingCartService.deleteById(id);

    return "deleted category: " + id;
  }

  @DeleteMapping("/category")
  public String deleteAllCategorys() {
    this.shoppingCartService.deleteAll();

    return "deleted all category";
  }
}