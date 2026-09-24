package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;
import com.code.HibernateProject1.entity.Users;

public class UpdateUsers {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create aconstructor with arg sessionFactory
	public UpdateUsers(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction
		session.beginTransaction();
		//Have one id
		int updateid = 3;
		//gety the object from the category with id updateid
		Users users = session.get(Users.class, updateid);
		//check the existence of the object of updateid
		if(users == null) {
			System.out.println("Users with id"+updateid+"not found");
			return;
		}
		//show the current object values
		System.out.println(users.toString());
		//set the new value
		users.setEmail("tghosh@example");
		//update the object
		session.merge(users);
		//to update into the table
		session.getTransaction().commit();
		//close the session
		session.close();//detached
		
		System.out.println("User is updated successfully");
	}

}
