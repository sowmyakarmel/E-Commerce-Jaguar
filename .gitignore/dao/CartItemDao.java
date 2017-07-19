package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemDao {
	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> getAll(int id);

	public boolean deleteCartItem(CartItem cartItem);

	public CartItem getCartItem(int id);

	public boolean deleteAll(int cart_id);

	public CartItem getExistingCartItemCount(int productId, int cart_id);

	public boolean updateCartItem(CartItem cartItem);

}
