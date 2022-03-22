package com.day27.proj1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

import com.day27.proj2.user;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(user.class)
				.buildSessionFactory();
		
Session session = factory.getCurrentSession();

try {

//
session.beginTransaction();
//
List<user> u = session.createQuery("from user where name = 'jawad'").getResultList();

for(user temp:u)
{
	System.out.println(temp);
}


//session.createQuery("update user set email = 'a@g.com'").executeUpdate();


//session.createQuery("delete user where name = 'usa'").executeUpdate();


}

finally {
	session.close();
	factory.close();
}

}

}
