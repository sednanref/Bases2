package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class Main {



		public static void main(String[] args){
			User usuario = new User();
			//User usuario2 = new User();
			
			usuario.seteMail("pedroperez@gmail.com");
			usuario.setPassword("olakasehaha");
			usuario.setName("Pedro");
			usuario.setLastName("Pérez");
			usuario.setVirtualMoney(0);
			usuario.seteMailFrequency(7);
			
			Company comp = new Company();
			
			comp.seteMail("polar@polar.com");
			comp.setName("Alimentos Polar");
			comp.setAddress("sabrá dios");
			comp.setRIF("J-23489328");
			comp.setTelephoneNumber("555-55-55");
			comp.setCustomersNumber(27000000);
			
			//@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(usuario);
			session.save(comp);
			
			
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
		}
}
