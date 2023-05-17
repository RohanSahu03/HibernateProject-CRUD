package org.jsp.HibernateDemoMaven;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your id to delete the records");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		User u = s.get(User.class, id);
		if(u!=null) {
			s.delete(u);
			Transaction t = s.beginTransaction();
			t.commit();
			System.out.println("ur record is deleted");
		}
		else {
			System.out.println("invalid id");
		}

	}

}
