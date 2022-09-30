package com.kbe.shoppingapp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.model.Price;
import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.repository.CurrencyRepository;
import com.kbe.shoppingapp.repository.PriceRepository;
import com.kbe.shoppingapp.repository.ProductRepository;
import com.kbe.shoppingapp.service.CurrencyService;
import com.kbe.shoppingapp.service.PriceService;
import com.kbe.shoppingapp.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTests {


    @Mock
    private ProductRepository productRepository;
    @Mock
    private PriceRepository priceRepository;
    @Mock
    private CurrencyRepository currencyRepository;

    
    @InjectMocks
    private PriceService priceService;
    @InjectMocks
    private CurrencyService currencyService;
    @InjectMocks
    private ProductService productService;


    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    // JUnit test for calculateTotalUsdPrice method
    @DisplayName("JUnit test for saveEmployee method")
    @Test //Normalfall
    public void calculateTotalUsdPrice(){
        //setup
        Currency euro = new Currency("EUR", 0.89f);
        euro.setIsoCode("EUR");
        currencyService.create(euro);

        String componentIdA = "123A";
        List<String> componentIds = new ArrayList<>();
        componentIds.add(componentIdA);
      
        Product productA = new Product("Produkt A", "Dies ist ein Test-Produkt vom Typ A", 50.99f, "img-URL A", "category1", componentIds); 


        productService.create(productA);

        //actual test
        assertEquals(45.3811f, priceService.calculateTotalUsdPrice(productA.getId()));
    }

     // JUnit test for calculateTotalUsdPrice method
     @DisplayName("JUnit test for saveEmployee method")
     @Test //Fehlerfall
     public void calculateTotalUsdPriceWrong(){
        //setup
        Currency euro = new Currency("EUR", 0.89f);
        euro.setIsoCode("EUR");
        currencyService.create(euro);

        String componentIdA = "123A";
        List<String> componentIds = new ArrayList<>();
        componentIds.add(componentIdA);
      
        Product productA = new Product("Produkt A", "Dies ist ein Test-Produkt vom Typ A", 50.99f, "img-URL A", "category1", componentIds); 


        productService.create(productA);

 
         //actual test
         assertNotEquals(45f, priceService.calculateTotalUsdPrice(productA.getId()));
     }

     // JUnit test for calculateTotalUsdPrice method
     @DisplayName("JUnit test for saveEmployee method")
     @Test //Normalfall
     public void calculatePriceForProduct(){
        //setup
        Currency euro = new Currency("EUR", 0.89f);
        euro.setIsoCode("EUR");
        currencyService.create(euro);

        String componentIdA = "123A";
        List<String> componentIds = new ArrayList<>();
        componentIds.add(componentIdA);
      
        Product productA = new Product("Produkt A", "Dies ist ein Test-Produkt vom Typ A", 50.99f, "img-URL A", "category1", componentIds); 

        Price price = new Price(productA.getPrice(), euro.getIsoCode(), componentIdA);

        productService.create(productA);

 
         //actual test
         assertEquals(price, priceService.calculatePriceForProduct(productA.getId(), euro.getIsoCode()));
     }

     // JUnit test for calculateTotalUsdPrice method
     @DisplayName("JUnit test for saveEmployee method")
     @Test //Fehlerfall
     public void calculatePriceForProductWrong(){
        //setup
        Currency euro = new Currency("EUR", 0.89f);
        Currency madeUp = new Currency("madeUp", 999f);
        euro.setIsoCode("EUR");
        currencyService.create(euro);

        String componentIdA = "123A";
        List<String> componentIds = new ArrayList<>();
        componentIds.add(componentIdA);
      
        Product productA = new Product("Produkt A", "Dies ist ein Test-Produkt vom Typ A", 50.99f, "img-URL A", "category1", componentIds); 

        Price price = new Price(productA.getPrice(), madeUp.getIsoCode(), componentIdA);

        productService.create(productA);

 
         //actual test
         assertNotEquals(price, priceService.calculatePriceForProduct(productA.getId(), euro.getIsoCode()));
     }

}
