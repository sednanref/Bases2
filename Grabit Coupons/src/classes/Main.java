package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class Main {



		public static void main(String[] args){
			User usuario = new User("luis@gmail.com", "7530804", "Luis");
			Customer customer = new Customer("pedro@gmail.com", "blabla", "pedro",
										 "Pérez", 50, 7);
			Company comp = new Company("polar@polar.com.ve", "polarcita", "Empresas Polar",
										"J-123123", "sabrá Dios dónde", "0212-3863456", 2000000);
		
			//@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(usuario);
			session.save(customer);
			session.save(comp);
			
			
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
		}
}
