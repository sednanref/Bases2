import org.hibernate.*;
import org.hibernate.cfg.*;
import classes.*;
import java.util.*;
import util.HibernateUtil;


@SuppressWarnings("deprecation")
public class Main {

		public static void main(String[] args){
			
			insertion();
			query1();
			
		}
		public static void insertion(){
			//Objects to insert into the DB
			Customer customer = new Customer("pedro@gmail.com", "blabla", "pedro",
										 "Pérez", 50, 7);
			Customer customer2 = new Customer("pablo@gmail.com", "n4p0l3s!", "Pablo Emilio",
					 "Escobar Gaviria", 200, 0);
			Customer customer3 = new Customer("chepa@gmail.com", "sldka", "Chepa",
					 "Candela", 0, 0);
			Company comp = new Company("polar@polar.com.ve", "polarcita", "Empresas Polar",
										"J-123123", "sabrá Dios dónde", "0212-3863456", 2000000);
			Company comp2 = new Company("contacto@plazas.com.ve", "portuguesinhos", "Automercados Plaza's",
					"J-123124", "Los Ruices", "0212-3843436", 400000);
			Date date1 = new Date(2014 - 1900,11,15);
			Date date2 = new Date(2015 - 1900,11,15);
			Sale sale1 = new Sale("Relojes Baratos", 100.00, 79.99, date1, date2, 
								  "Relojes desde 100Bs con 20% de descuento.");
			Sale sale2 = new Sale("Descuento en Ron Santa Teresa en Automercados Plaza's", 
									700.00, 500.99, date1, date2, 
					  				"Ahorre Bs 100 por cada botella que compre de Ron Santa " +
									"Teresa en Automercados Plaza's.");
			Category cat = new Category("Caballeros");
			Category cat2 = new Category("Relojes");
			Category cat3 = new Category("Navajas");
			PayType pt1 = new PayType("CreditCard");
			PayType pt2 = new PayType("Virtual Money");
			Coupon coup = new Coupon("Pedro Pérez", date1, date1, date1, 1, pt2, "123",
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
			Set<Sale> offSales2 = new HashSet<Sale>();
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
			offSales.add(sale1);
			offSales2.add(sale2);
			comp.setOfferedSales(offSales);
			sale1.setCompany(comp);
			comp2.setOfferedSales(offSales2);
			sale2.setCompany(comp2);
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
			cat2.setCategorySales(offSales2);
			sale2.setCategory(cat2);
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
			/*Relation between sale and pictures*/
			coup.setPayType(pt1);
			//Transaction starts
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(pt1);
			session.save(pt2);
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
			session.save(comp2);
			session.save(sale2);
			session.save(coup);
			session.save(saled1);
			session.save(saled2);
			session.save(pic1);
			session.save(pic2);
						
			session.getTransaction().commit();
	        session.close();
			//sessionFactory.close();
		}
		
		public static void query1(){
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
	    	try{
	    		transaction = session.beginTransaction();
	    		
	    		// To get total row count.
	    		Long count = (Long) session.createQuery("select count(*) from PayType").uniqueResult();
	    		
	    		System.out.println("Total Count: " + count );
	    		transaction.commit();
	    	}catch (HibernateException e) {
	    		if (transaction!=null) transaction.rollback();
	    		e.printStackTrace(); 
	    	}finally {
	    		session.close(); 
	    	}
		}
}
