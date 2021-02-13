package si.goranferbisek.addressbook;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
    	if (sessionFactory == null) {
    		try {   	    
	    	    sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    	    
	    	    return sessionFactory;	    	
	    	 } catch (Exception e) {
	    		 System.out.println("Hibernate Failed to build the session.");
	    		 e.printStackTrace();
	    	 }	
    	}
    	
    	return sessionFactory;
    }
}