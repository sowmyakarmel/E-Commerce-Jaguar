package com.niit.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Category;
import com.niit.model.Product;


@Transactional
@Repository("proDao")
public class ProductDaoImplementation implements ProductDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		   this.sessionFactory = sessionFactory;
		}

	public boolean addProduct(Product product)
	{
				
		// TOO Auto-generated method stub
		System.out.println("I am in add product Dao");
		try {
			sessionFactory.getCurrentSession().save(product);
			
			return true;
		} catch (Exception e) {
			// TODO:handle exception
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Product",Product.class).getResultList();
	}
	
	@SuppressWarnings("unused")
	public Product get(int id) 
	{
		return sessionFactory.getCurrentSession().createQuery("From Product where productId=:id",Product.class).setParameter("id", id).getSingleResult();
	}



	public boolean update(Product product)
	{
	System.out.println("Product price::::::::::::::::::" + product.getProductPrice());
	// TODO Auto-generated method stub
	

	try {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}
	catch (Exception e) {
		System.out.println("Exception in ProductDao:::::::" + e);
		return false;
	}
}

@SuppressWarnings({ "deprecation", "rawtypes"})
public boolean delete (int id) {
	System.out.println("i am in delete code");
	
	try {
		 sessionFactory.getCurrentSession().createQuery("From Product where productId=:id",Product.class).setParameter("id", id).getSingleResult();
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		return false;
	}
}
@SuppressWarnings({"deprecation","unchecked","rawtypes"})
public List<Product> getCatProducts(Integer id) {
	// TODO Auto-generated method stub
	
	System.out.println("in product impl "+id);
	Session session= sessionFactory.getCurrentSession();
	try {
		Query q=session.createQuery("from Product where CATEGORY_CATEGORYID=:Id");

		q.setParameter("Id", id);
		return q.getResultList();
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
}



}