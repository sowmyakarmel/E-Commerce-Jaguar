package com.niit.dao;

import com.niit.model.Cart;

public interface CartDao {

	public boolean addCart(Cart cart);

	public boolean updateCart(Cart cart);

	public boolean resetCart(int id);

	Cart getCart(Integer id);
}