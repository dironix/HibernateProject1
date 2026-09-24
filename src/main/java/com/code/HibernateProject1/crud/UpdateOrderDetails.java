package com.code.HibernateProject1.crud;

import org.hibernate.Session;


import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.OrderDetails;


public class UpdateOrderDetails {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create a constructor with arg sessionFactory
	public UpdateOrderDetails(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//Have one id
		int updateid = 1;
		//gety the object from order details with id updateid
		OrderDetails orderDetails = session.get(OrderDetails.class, updateid);
		//check the existence of the object of updateid
		if(orderDetails== null) {
			System.out.println("Order Details with id"+updateid+"not found");
			return;
		}
		//show the current object values
		System.out.println(orderDetails.toString());
		//set the new value
		orderDetails.setUnitPrice(350.00);
		//update the object
		session.merge(orderDetails);
		//to update into the table
		session.getTransaction().commit();
		//close the session
		session.close();//detached
		
		System.out.println("Order Details is updated successfully");
	}

}
