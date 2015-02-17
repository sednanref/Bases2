package Classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class Main {

		public static void main(String[] args){
			User usuario = new User();
			
			usuario.setName("Pedro");
			usuario.setId(1);
			
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(usuario);
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
		}
}
