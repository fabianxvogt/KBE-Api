package com.kbe.shoppingapp.controller;

import com.kbe.shoppingapp.model.Price;
import com.kbe.shoppingapp.service.IPriceService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
class PriceController {

  @Autowired
  private IPriceService priceService;

  @GetMapping("/price/product/{productId}")
  public Price getPrice(
    @PathVariable("productId") String productId,
    @RequestParam(value = "currency") String currencyIso
  ) {
    return (Price) this.priceService.calculatePriceForProduct(productId, currencyIso);
  }

  @GetMapping("/price/cart/{cartId}")
  public Price getPriceForShopping(
    @PathVariable("cartId") String componentId,
    @RequestParam(value = "currency") String currencyIso
  ) {
    return (Price) this.priceService.calculatePriceForProduct(componentId, currencyIso);
  }


  /* 
  @GetMapping("/prices/{id}")
  public Price getPriceById(@PathVariable("id") String id) {
    return (Price) this.priceService.readById(id);
  }

  @PostMapping("/prices")
  Price insertPrice(@RequestBody Price price) {
    //price.setI(sequenceGeneratorService.generateSequence(Price.SEQUENCE_NAME));
    return this.priceService.create(price);
  }

  @PutMapping("/prices/{id}")
  public Price updatePrice(@PathVariable("id") String id, @RequestBody Price price) {
    return this.priceService.update(price, id);
  }

  @DeleteMapping("/prices/{id}")
  public String deletePrice(@PathVariable("id") String id) {
    this.priceService.deleteById(id);

    return "deleted price: " + id;
  }

  @DeleteMapping("/prices")
  public String deleteAllPrices() {
    this.priceService.deleteAll();

    return "deleted all prices";
  }
  */
}