import org.hibernate.*;
import org.hibernate.cfg.*;

//import classes.User;
import classes.*;
import java.util.*;


@SuppressWarnings("deprecation")
public class Main {

		public static void main(String[] args){
			//Objects to insert into the DB
			Customer customer = new Customer("pedro@gmail.com", "blabla", "pedro",
										 "Pérez", 50, 7);
			Customer customer2 = new Customer("pablo@gmail.com", "n4p0l3s!", "Pablo Emilio",
					 "Escobar Gaviria", 200, 0);
			Customer customer3 = new Customer("chepa@gmail.com", "sldka", "Chepa",
					 "Candela", 0, 0);
			Company comp = new Company("polar@polar.com.ve", "polarcita", "Empresas Polar",
										"J-123123", "sabrá Dios dónde", "0212-3863456", 2000000);
			Date date1 = new Date(2014 - 1900,11,15);
			Date date2 = new Date(2015 - 1900,11,15);
			Sale sale1 = new Sale("Relojes Baratos", 100.00, 79.99, date1, date2, 
								  "Relojes desde 100Bs con 20% de descuento.");
			Category cat = new Category("Caballeros");
			Category cat2 = new Category("Relojes");
			Category cat3 = new Category("Navajas");
			Set<Category> catSet = new HashSet<Category>();
			Set<Sale> offSales = new HashSet<Sale>();
			offSales.add(sale1);
			/*Relationship between categories and sub-categories*/
			cat.setSuperCategory(cat);
			cat2.setSuperCategory(cat);
			cat3.setSuperCategory(cat);
			catSet.add(cat2);
			catSet.add(cat3);
			cat.setSubCategories(catSet);
			/*Relationship between a company and a sale.*/
			comp.setOfferedSales(offSales);
			sale1.setCompany(comp);
			/*Friendship between customers.*/
			
			
			//Inicio de la transacción
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(cat);
			session.save(cat2);
			session.save(cat3);
			session.save(customer);
			session.save(customer2);
			session.save(customer3);
			session.save(comp);
			session.save(sale1);
			
			
			
			session.getTransaction().commit();
			
			
//			String q = "from Category c left join c.subCategories";
//			
//			Transaction transaction = null;
//	        try{
//	        	transaction = session.beginTransaction();
//	        
//	        	Query query =
//	    				session.createQuery(q);
//	    		
//	    		//Guardando en la lista todas las tuplas recibidas en el query	
//	    		List cs = query.list(); 
//
//	    		//Iterando sobre todas las tuplas almacenadas en la lista
//	        	for (Iterator iterator = cs.iterator(); iterator.hasNext();) {
//	        		Object c = iterator.next(); 
//	        		System.out.print("First Name: " + c);  
//	        	}
//	        	transaction.commit();
//	        } catch (HibernateException e) {
//	        	if (transaction!=null) transaction.rollback();
//	        	e.printStackTrace(); 
//	        } finally {
//	        	session.close(); 
//	        }
	        session.close();
			sessionFactory.close();
		}
}
