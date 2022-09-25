
package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.model.Price;
import com.kbe.shoppingapp.repository.ProductRepository;
import com.kbe.shoppingapp.repository.CurrencyRepository;
import com.kbe.shoppingapp.repository.PriceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements IPriceService {

	@Autowired
	private final ProductRepository productRepository;
	private final PriceRepository priceRepository;
	private final CurrencyRepository currencyRepository;

	public PriceService(PriceRepository priceRepository, ProductRepository productRepository, CurrencyRepository currencyRepository) {
		this.priceRepository = priceRepository;
		this.productRepository = productRepository;
		this.currencyRepository = currencyRepository;
		this.priceRepository.deleteAll();
	}

	private Float calculateTotalUsdPrice(String productId) {
		try {
			Product product = this.productRepository.findById(productId).get();
			Float total = 0.f;
			if (product.getPrice() == null) {
				for (String childId : product.getComponentIds()) {
					total += calculateTotalUsdPrice(childId);
				}
				return total;
			} else {
				return product.getPrice();
			}
		} catch (Exception e) {
			return 0.f;
		}
	}

	@Override
	public Price calculatePriceForProduct(String productId, String currencyIso) {
		Currency currency = this.currencyRepository.findById(currencyIso).get();
		Float totalPrice = calculateTotalUsdPrice(productId) * currency.getUsdConversionRate();
		return new Price(totalPrice, currency.getIsoCode(), productId);
	}

	
	/* 
	CRUD operation are propably not needed for the price endpoint. Prices are 
	calculated on demand and not stored on the DB.

	// Save operation
	@Override
	public Price create(Price Price)
	{
		return this.priceRepository.save(Price);
	}

	// Read operation
	@Override 
	public List<Price> readAll()
	{
		return (List<Price>) this.priceRepository.findAll();
	}

	// Read operation
	@Override 
	public Price readById(String componentId)
	{
		return this.priceRepository.findById(componentId).get();
	}
	
	// Update operation
	@Override
	public Price update(Price component, Long componentId) {
		Price _component = this.priceRepository.findById(componentId).get();

		//_component.setName(component.getName());
				
		return this.priceRepository.save(_component);
	}

	// Delete operation
	@Override
	public void deleteById(Long PriceId)
	{
		this.priceRepository.deleteById(PriceId);
	}

	@Override
	public void deleteAll()
	{
		this.priceRepository.deleteAll();
	}
	*/


}