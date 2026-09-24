package com.code.HibernateProject1.crud;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.OrderDetails;
import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;

public class ReadOrderDetails {
	//create a sessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public ReadOrderDetails(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//session object using the SessionFactory object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction to work with the session object
		session.beginTransaction();
		//show all the object details from the product
		List<OrderDetails> orderDetailss = session.createQuery("from OrderDetails").getResultList();
		for(OrderDetails orderDetails:orderDetailss) {
			System.out.println(orderDetails.toString());
		}
		//close the session
		session.close();//detached
	}

}
