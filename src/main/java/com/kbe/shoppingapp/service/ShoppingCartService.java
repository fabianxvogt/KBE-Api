package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Product;
import com.kbe.shoppingapp.model.ShoppingCart;
import com.kbe.shoppingapp.repository.ShoppingCartRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService implements IShoppingCartService {

	@Autowired
	private final ShoppingCartRepository shoppingCartRepository;

	public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.shoppingCartRepository.deleteAll();
	}

	// Save operation
	@Override
	public ShoppingCart create(ShoppingCart ShoppingCart)
	{
		return this.shoppingCartRepository.save(ShoppingCart);
	}
	
	// Read operation
	@Override 
	public List<ShoppingCart> readAll()
	{
		return (List<ShoppingCart>) this.shoppingCartRepository.findAll();
	}

	// Read operation
	@Override 
	public ShoppingCart readById(String userMail)
	{
		return this.shoppingCartRepository.findById(userMail).get();
	}

	// Update operation
	@Override
	public ShoppingCart update(ShoppingCart shoppingCart, String userMail, Product p) {
		ShoppingCart _shoppingCart = this.shoppingCartRepository.findById(userMail).get();
		_shoppingCart.addToCart(p);
		return this.shoppingCartRepository.save(_shoppingCart);
	}

	// Delete operation
	@Override
	public void deleteById(String userMail)
	{
		this.shoppingCartRepository.deleteById(userMail);
	}

	@Override
	public void deleteAll()
	{
		this.shoppingCartRepository.deleteAll();
	}

}