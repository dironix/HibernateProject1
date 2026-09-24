package com.code.HibernateProject1.crud;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;

public class DeleteOrders {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create a constructor with arg sessionFactory
	public DeleteOrders(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//Have one id
		int deleteid = 3;
		//gety the object from the category with id deleteid
		Orders orders = session.get(Orders.class, deleteid);
		//check the existence of the object of deleteid
		if(orders == null) {
			System.out.println("Orders with id"+deleteid+"not found");
			return;
		}
		//show the current object values
		System.out.println(orders.toString());
		//remove the object
		session.remove(orders);
		//to update into the table
		session.getTransaction().commit();
		//close the session
		session.close();//detached
		
		System.out.println("order is deleted successfully");
	}

}
