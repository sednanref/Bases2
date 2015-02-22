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
			Coupon coup = new Coupon("Pedro Pérez", date1, date1, date1, 1, "virtualMoney", "123",
									customer, sale1);
			CreditCard card1 = new CreditCard("1111222233334444", customer);
			CreditCard card2 = new CreditCard("1111222233334445", customer);
			CreditCard card3 = new CreditCard("1111222233334446", customer);
			SaleLink link1 = new SaleLink("relojes.com/reloj1", sale1);
			SaleDate saled1 = new SaleDate(date1);
			SaleDate saled2 = new SaleDate(date2);
			SalePicture pic1 = new SalePicture("/1/1.jpg");
			SalePicture pic2 = new SalePicture("/1/2.jpg");
			
			/*Sets to ensure relationships.*/
			Set<Category> catSet = new HashSet<Category>();
			Set<Sale> offSales = new HashSet<Sale>();
			offSales.add(sale1);
			Set<Customer> friends1 = new HashSet<Customer>();
			Set<Customer> friends2 = new HashSet<Customer>();
			Set<Customer> friends3 = new HashSet<Customer>();
			Set<Category> saleCat = new HashSet<Category>();
			Set<Sale> catSale = new HashSet<Sale>();
			Set<CreditCard>credCardSet = new HashSet<CreditCard>();
			Set<SaleLink>linkSet = new HashSet<SaleLink>();
			Set<SaleDate>saledSet = new HashSet<SaleDate>();
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
			friends1.add(customer2);
			friends1.add(customer3);
			friends2.add(customer);
			friends3.add(customer);
			customer.setFriends(friends1);
			customer2.setFriends(friends2);
			customer3.setFriends(friends3);
			/*Credit Card and Customer relationship*/
			credCardSet.add(card1);
			credCardSet.add(card2);
			credCardSet.add(card3);
			/*Relationship between category and sale*/
			catSale.add(sale1);
			saleCat.add(cat3);
			cat3.setCategorySales(catSale);
			sale1.setCategory(cat3);
			/*Relation between the link and the sale*/
			linkSet.add(link1);
			sale1.setLinks(linkSet);
			/*Relation between dates and sale*/
			saledSet.add(saled1);
			saledSet.add(saled2);
			saled1.setSales(catSale);
			saled2.setSales(catSale);
			sale1.setDates(saledSet);
			/*Relation between sale and pictures*/
			pic1.setSale(sale1);
			pic2.setSale(sale1);
			//Transaction starts
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(cat);
			session.save(cat2);
			session.save(cat3);
			session.save(card1);
			session.save(card2);
			session.save(card3);
			session.save(link1);
			session.save(customer);
			session.save(customer2);
			session.save(customer3);
			session.save(comp);
			session.save(sale1);
			session.save(coup);
			session.save(saled1);
			session.save(saled2);
			session.save(pic1);
			session.save(pic2);
			
			
			
			session.getTransaction().commit();
			//End of the transaction
			
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
