package org.jsp.HibernateDemoMaven;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your phone number to print details");
		long  phone = sc.nextLong();
		String qry = "select u from User u where u.phone=?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q =s.createQuery(qry);
		q.setParameter(1,phone);
		
		List<User> users = q.getResultList();
		if(users.size()>0) {
			for(User u :users) {
				System.out.println("id "+u.getId());
				System.out.println("name "+ u.getName());
				System.out.println("age "+u.getAge());
				System.out.println("phone "+u.getPhone());
			}
		}
		else {
			System.out.println("no user found with the phone "+phone);
		}

	}

}
