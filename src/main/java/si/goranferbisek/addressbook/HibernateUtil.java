package si.goranferbisek.addressbook;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry standardRegistry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
    	if (sessionFactory == null) {
    		try {	    	    
    			standardRegistry = new StandardServiceRegistryBuilder().configure().build();
    			
    			sessionFactory = new MetadataSources(standardRegistry)
    					//.addAnnotatedClass(Person.class)
    					.buildMetadata()
    					.buildSessionFactory();
    			
	    	    return sessionFactory;	    	
	    	 } catch (Exception e) {
	    		 System.err.println("Initial SessionFactory creation failed");
	    		 e.printStackTrace();
	    		 throw new ExceptionInInitializerError(e);
	    	 }	
    	}
    	
    	return sessionFactory;
    }
    
    public static void shutdown() {
        if (standardRegistry != null) {
            StandardServiceRegistryBuilder.destroy(standardRegistry);
        }
    }
}