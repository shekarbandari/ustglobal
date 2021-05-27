package com.ust.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.pms.model.Cart;
import com.ust.pms.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	

	public void deleteCart(Cart Cart) {

		cartRepository.delete(Cart);
	}

	public void updateCart(Cart Cart) {

		cartRepository.save(Cart);
	}

	public void saveCart(Cart Cart) {

		cartRepository.save(Cart);
	}

	public List<Cart> getCartDetails() {
		return (List<Cart>) cartRepository.findAll();
	}

	public Cart getCart(int CartId) {
		Optional<Cart> Cart = cartRepository.findById(CartId);
		return Cart.get();
	}

	public boolean isCartExist(int CartId) {

		return cartRepository.existsById(CartId);
	}

	public void deleteCartById(int cartId) {

		cartRepository.deleteById(cartId);
	}
	
}
