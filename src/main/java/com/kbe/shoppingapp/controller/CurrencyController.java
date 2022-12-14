package com.kbe.shoppingapp.controller;
import java.util.List;

import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.service.ICurrencyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
class CurrencyController {

  @Autowired
  private ICurrencyService currencyService;

  @GetMapping("/currencies")
  public List<Currency> getCurrencies() {
    return (List<Currency>) this.currencyService.readAll();
  }

  @GetMapping("/currencies/{isoCode}")
  public Currency getCurrencyById(
    @PathVariable("id") String isoCode) {
    return (Currency) this.currencyService.readById(isoCode);
  }
  /*
  @GetMapping("/currencies/{isoCode}")
  public Currency getCurrencyByIsoCode(
    @PathVariable("isoCode") String isoCode) {
    return (Currency) this.currencyService.readByIsoCode(isoCode);
  }
 */
  @PostMapping("/currencies")
  Currency insertCurrency(@RequestBody Currency currency) {
    //currency.setId(sequenceGeneratorService.generateSequence(Currency.SEQUENCE_NAME));
    return this.currencyService.create(currency);
  }

  @PatchMapping("/currencies/{isoCode}")
  public Currency updateCurrency(@PathVariable("isoCode") String isoCode, @RequestBody Currency currency) {
    return this.currencyService.update(currency, isoCode);
  }

  @DeleteMapping("/currencies/{isoCode}")
  public String deleteCurrency(@PathVariable("isoCode") String isoCode) {
    this.currencyService.deleteByIsoCode(isoCode);

    return "deleted currency: " + isoCode;
  }

  @DeleteMapping("/currencies")
  public String deleteAllCurrencies() {
    this.currencyService.deleteAll();

    return "deleted all currencies";
  }
}