import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import classes.User;
import classes.Customer;
import classes.Company;

import java.util.*;


@SuppressWarnings("deprecation")
public class Main {

		public static void main(String[] args){
			//Usuarios a añadir a la base de datos
			Customer customer = new Customer("pedro@gmail.com", "blabla", "pedro",
										 "Pérez", 50, 7);
			Customer customer2 = new Customer("pablo@gmail.com", "n4p0l3s!", "Pablo Emilio",
					 "Escobar Gaviria", 200, 0);
			Customer customer3 = new Customer("chepa@gmail.com", "sldka", "Chepa",
					 "Candela", 0, 0);
			Company comp = new Company("polar@polar.com.ve", "polarcita", "Empresas Polar",
										"J-123123", "sabrá Dios dónde", "0212-3863456", 2000000);


			
			//Inicio de la transacción
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();


			session.save(customer);
			session.save(customer2);
			session.save(customer3);
			session.save(comp);
			
			
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
		}
}
