package com.niit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int quantity;
	private float grandTotal;
	@OneToOne(cascade = CascadeType.PERSIST)
	private CreateUser user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", fetch = FetchType.EAGER)
	private List<CartItem> cartitem = new ArrayList<CartItem>();// one cart
																	// has a
																	// list of
																	// many
																	// cartItems​

	public List<CartItem> getCartItems() {
		return cartitem;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartitem = cartItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public CreateUser getUser() {
		return user;
	}

	public void setUser(CreateUser user) {
		this.user = user;
	}

	public List<CartItem> getCartitem() {
		return cartitem;
	}

	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}

	
}
