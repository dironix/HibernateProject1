package com.code.HibernateProject1.crud;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Product;

public class ReadProduct {
	//create a sessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public ReadProduct(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//session object using the SessionFactory object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction to work with the session object
		session.beginTransaction();
		//show all the object from the product
		List<Product> products = session.createQuery("from Product").getResultList();
		for(Product product:products) {
			System.out.println(product.toString());
		}
		//close the session
		session.close();//detached
	}

}
