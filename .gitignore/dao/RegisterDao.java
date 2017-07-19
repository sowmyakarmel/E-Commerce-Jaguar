
package com.niit.dao;

import com.niit.model.Cart;
import com.niit.model.CreateUser;

public interface RegisterDao
{
	void addData(CreateUser createuser);
	void createuserUpdate(CreateUser createuser);
	CreateUser getUser(int id);
	CreateUser getEmail(String email);
}
