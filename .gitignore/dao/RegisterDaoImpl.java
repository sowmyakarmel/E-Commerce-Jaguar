package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CreateUser;
@Transactional
@Repository("regDao")
public class RegisterDaoImpl implements RegisterDao {
	SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(CreateUser createuser) {
		 sessionFactory.getCurrentSession().save(createuser);
		
	}

	@Override
	public void createuserUpdate(CreateUser createuser) {
	try{
		sessionFactory.getCurrentSession().update(createuser);
	}catch (Exception e)
	{
		System.out.println(e);
	}
	}
	

	public CreateUser getUser(int id) {
		try{
			return sessionFactory.getCurrentSession().createQuery("from CreateUser where userid=:id",CreateUser.class).setParameter("id", id).getSingleResult();
		}catch(Exception e){
			//TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	@SuppressWarnings("deprecation")
	public CreateUser getEmail(String email) {
	 try{
		return sessionFactory.getCurrentSession().createQuery("From CreateUser where email=:email ",CreateUser.class).setParameter("email", email).getSingleResult();
			

		} catch (Exception e) {
			return null;
		}
	}

}