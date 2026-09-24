package com.code.HibernateProject1.crud;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Product;

public class UpdateProduct {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create a constructor with arg sessionFactory
	public UpdateProduct(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//Have one id
		int updateid = 1;
		//gety the object from the category with id updateid
		Product product = session.get(Product.class, updateid);
		//check the existence of the object of updateid
		if(product == null) {
			System.out.println("Product with id"+updateid+"not found");
			return;
		}
		//show the current object values
		System.out.println(product.toString());
		//set the new value
		product.setStockQuantity(6);
		//update the object
		session.merge(product);
		//to update into the table
		session.getTransaction().commit();
		//close the session
		session.close();//detached
		
		System.out.println("product is updated successfully");
	}

}
