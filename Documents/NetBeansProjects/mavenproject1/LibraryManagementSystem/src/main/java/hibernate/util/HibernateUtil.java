package hibernate.util;

import org.hibernate.cfg.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
  
	public static SessionFactory getSessionFactory() {
		
		
		//loads Configuration and Mapping
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		//build the session factory from the service registry
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		
		return sessionFactory;
	}
	
	
}
