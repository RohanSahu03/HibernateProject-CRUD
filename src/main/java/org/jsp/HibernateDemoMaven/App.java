package org.jsp.HibernateDemoMaven;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	User u = new User();
    	u.setName("john");
    	u.setAge(34);
    	u.setPhone(9295458);;
        System.out.println( "Hello World!" );
     
        Session s = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        s.save(u);
        
   Transaction t = s.beginTransaction();
        t.commit();
        System.out.println("user saved with id "+u.getId() );
    }
}
