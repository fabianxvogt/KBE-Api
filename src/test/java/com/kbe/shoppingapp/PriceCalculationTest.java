/*package com.kbe.shoppingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.repository.CurrencyRepository;
import com.kbe.shoppingapp.repository.PriceRepository;
import com.kbe.shoppingapp.repository.ProductRepository;
import com.kbe.shoppingapp.service.CurrencyService;
import com.kbe.shoppingapp.service.PriceService;
import com.kbe.shoppingapp.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class PriceCalculationTest {

    // JUnit test for calculateTotalUsdPrice method
    @DisplayName("JUnit test for USD Price Calculation method")
    @Test // Normalfall
    public void calculateTotalUsdPrice() throws IOException, InterruptedException {
        // setup
        Currency euro = new Currency("EUR", 0.89f);
        euro.setIsoCode("EUR");

        String componentIdA = "123A";
        String componentIdB = "123B";
        List<String> componentIds = new ArrayList<>();
        componentIds.add(componentIdA);
        componentIds.add(componentIdB);
        componentIds.add(componentIdA);
        componentIds.add(componentIdB);
        Product productA = new Product("Produkt A", "Dies ist ein Test-Produkt vom Typ A", 50.99f, "img-URL A",
                "category1", componentIds);
        productA.setId("ehhejf");
        Product productB = new Product("Produkt B", "Dies ist ein Test-Produkt vom Typ B", 50f, "img-URL B",
                "category1", componentIds);
        Product productC = new Product("Produkt C", "Dies ist ein Test-Produkt vom Typ C", 100f, "img-URL C",
                "category2", componentIds);
        Product productD = new Product("Produkt D", "Dies ist ein Test-Produkt vom Typ D", 32.99f, "img-URL D",
                "category2", componentIds);

        
        // Create a neat value object to hold the URL
        URL baseUrl = new URL("https://localhost:8080/");

        // create a client
        var client = HttpClient.newHttpClient();
        
        BodyPublisher productAbody = BodyPublishers.ofString("{id: 'asdasd', name: 'asdas'}");

        // create a request
        var requestPostProduct = HttpRequest.newBuilder(
                URI.create(baseUrl + "product"))
                .POST(productAbody)
                .header("accept", "application/json")
                .build();

        // use the client to send the request
        HttpResponse<String> response = client.send(requestPostProduct, BodyHandlers.ofString());

        // the response:
        System.out.println(response.body().toString());
    }

}
*/
