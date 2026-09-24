package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.OrderDetails;
import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;


public class CreateOrderDetails {
	//create a session factory
	private SessionFactory sessionFactory;
	//create constructor with arg sessionfactory
	public CreateOrderDetails(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		////start the transaction to work with the session object
		session.beginTransaction();
		//set the id of users to assign the orderDetails
		int ordersid = 2;
		//set the id of product to assign the orderDetails
		int productid = 2;		
		
		//get the  object from the category with ordersid
		Orders orders = session.get(Orders.class, ordersid);
		//check the existence of the category with ordersid
		if(orders == null) {
			System.out.println("Orders with id"+ordersid+"not found");
			return;
		}
		
		//get the  object from the category with productid
		Product product = session.get(Product.class, productid);		
		//check the existence of the category with productid
		if(product == null) {
			System.out.println("Product with id"+productid+"not found");
			return;
		}
		//show the current object value
		System.out.println(orders.toString());
		
		//show the current object value
		System.out.println(product.toString());
		
		//create the OrderDetails object
		OrderDetails orderDetails = new OrderDetails(1, 300.00, orders, product);
		//save object
		session.persist(orderDetails);
		
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		//close the session
		session.close();
		//give a message to user
		System.out.println("Order Details is created successfully");
		
	}
	

}
