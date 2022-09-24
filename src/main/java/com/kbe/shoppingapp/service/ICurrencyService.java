package com.kbe.shoppingapp.service;
  
import com.kbe.shoppingapp.model.Currency;
import java.util.List;
import org.springframework.stereotype.Service;
  
@Service
public interface ICurrencyService {
  
    // Save operation
    Currency create(Currency currency);
  
    // Read operation
    List<Currency> readAll();

    Currency readById(String currencyId);
  
    // Update operation
    Currency update(Currency currency, String currencyId);

    void deleteAll();

    Currency readByIsoCode(String isoCode);

    void deleteByIsoCode(String isoCode);
}