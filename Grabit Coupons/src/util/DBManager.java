package util;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

import classes.*;

@SuppressWarnings("deprecation")
public class DBManager {
	/* This method realize a massive insertion to the database with
	 * testing purpose. */
	public void insertionAndQueries(){
		//Objects to insert into the DB
		//Customers
		Customer customer = new Customer("pedro@gmail.com", "blabla", "pedro",
									 "Pérez", 50, 7);
		Customer customer2 = new Customer("pablo@gmail.com", "n4p0l3s!", "Pablo Emilio",
				 "Escobar Gaviria", 200, 0);
		Customer customer3 = new Customer("sednanref2004@gmail.com", "12345", "Luis",
				 "Fernandes", 400, 0);
		Customer customer4 = new Customer("donatorolo93@gmail.com", "12345", "Donato",
				 "Rolo", 200, 0);
		Customer customer5 = new Customer("andrea@gmail.com", "sldka", "Andrea",
				 "Chacón", 0, 0);
		//Companies
		Company comp1 = new Company("contacto@casio.com.ve", "babyG", "Casio Venezuela",
				"J-123125", "Los Dos Caminos", "0212-7530800", 300000);
		Company comp2 = new Company("polar@polar.com.ve", "polarcita", "Empresas Polar",
									"J-123123", "Altamira", "0212-3863456", 2000000);
		Company comp3 = new Company("contacto@plazas.com.ve", "portuguesinhos", "Automercados Plaza's",
				"J-123124", "Los Ruices", "0212-3843436", 400000);
		//Dates
		Date date1 = new Date(2014 - 1900,11,15);
		Date date2 = new Date(2015 - 1900,11,15);
		Date date3 = new Date(2014 - 1900,3,17);
		Date date4 = new Date(2015 - 1900,3,17);
		Date date5 = new Date(2014 - 1900,11,25);
		//Sales
		Sale sale1 = new Sale("Relojes Baratos", 100.00, 79.99, date1, date2, 
							  "Relojes desde 100Bs con 20% de descuento.");
		Sale sale2 = new Sale("Descuento en Ron Santa Teresa en Automercados Plaza's", 
								700.00, 500.99, date1, date2, 
				  				"Ahorre Bs 100 por cada botella que compre de Ron Santa " +
								"Teresa en Automercados Plaza's.");
		Sale sale3 = new Sale("2x1 en productos de Chocolates el Rey", 
				200.00, 99.99, date3, date4, 
  				"¡Por cada producto de Chocolates el rey que adquiera en alguno de " +
				"nuestros automercados, podrá llevarse otro igual!");
		Sale sale4 = new Sale("Solera Verde en 50% de descuento!", 
				700.00, 350.00, date3, date4, 
  				"Compre la caja de botellas de solera verde a mitad de precio" +
				" siempre y cuando presente la compra de este cupón.");
		//Categories
		Category cat1 = new Category("Relojes");
		Category cat2 = new Category("Bebidas");
		Category cat3 = new Category("Licores");
		Category cat4 = new Category("Refrescos");
		Category cat5 = new Category("Comidas");
		Category cat6 = new Category("Chocolates");
		//PayTypes
		PayType pt1 = new PayType("CreditCard");
		PayType pt2 = new PayType("Virtual Money");
		//Coupons
		Coupon coup1 = new Coupon("pedro@gmail.com", date1, date1, date1, 1, pt2, "1111222233334444",
								customer, sale1);
		Coupon coup2 = new Coupon("maria@gmail.com", date1, date2, date2, 2, pt2, "1111222233334444",
				customer, sale2);
		Coupon coup3 = new Coupon("donatorolo93@gmail.com", date2, date2, date2, 3, pt1, "1111222233334446",
				customer3, sale2);
		Coupon coup4 = new Coupon("sednanref2004@gmail.com", date3, date3, date5, 4, pt1, "1111222233334447",
				customer4, sale4);
		//Credit Cards
		CreditCard card1 = new CreditCard("1111222233334444", customer);
		CreditCard card2 = new CreditCard("1111222233334445", customer);
		CreditCard card3 = new CreditCard("1111222233334446", customer3);
		CreditCard card4 = new CreditCard("1111222233334447", customer4);
		CreditCard card5 = new CreditCard("1111222233334448", customer5);
		//Links
		SaleLink link1 = new SaleLink("www.casio.com.ve/reloj1", sale1);
		SaleLink link2 = new SaleLink("www.plazas.com.ve/ron/santa_teresa", sale2);
		SaleLink link3 = new SaleLink("www.plazas.com.ve/chocolate/el_rey_especial", sale3);
		SaleLink link4 = new SaleLink("www.polar.com.ve/cerveza/solera", sale4);
		SaleLink link5 = new SaleLink("www.polar.com/cerveza/solera_verde", sale4);
		//SaleDates
		SaleDate saled1 = new SaleDate(date1);
		SaleDate saled2 = new SaleDate(date2);
		//Pictures
		SalePicture pic1 = new SalePicture("/1/1.jpg");
		SalePicture pic2 = new SalePicture("/2/1.jpg");
		SalePicture pic3 = new SalePicture("/3/1.jpg");
		SalePicture pic4 = new SalePicture("/4/1.jpg");
		SalePicture pic5 = new SalePicture("/4/2.jpg");
		
		/*Sets to ensure relationships.*/
		Set<Category> catSet2 = new HashSet<Category>();
		Set<Category> catSet5 = new HashSet<Category>();
		Set<Sale> offSales1 = new HashSet<Sale>();
		Set<Sale> offSales2 = new HashSet<Sale>();
		Set<Sale> offSales3 = new HashSet<Sale>();
		Set<Customer> friends1 = new HashSet<Customer>();
		Set<Customer> friends2 = new HashSet<Customer>();
		Set<Customer> friends3 = new HashSet<Customer>();
		Set<Customer> friends4 = new HashSet<Customer>();
		Set<CreditCard>credCardSet1 = new HashSet<CreditCard>();
		Set<CreditCard>credCardSet3 = new HashSet<CreditCard>();
		Set<CreditCard>credCardSet4 = new HashSet<CreditCard>();
		Set<CreditCard>credCardSet5 = new HashSet<CreditCard>();
		Set<Sale> catSales1 = new HashSet<Sale>();
		Set<Sale> catSales3 = new HashSet<Sale>();
		Set<Sale> catSales6 = new HashSet<Sale>();
		Set<SaleLink>linkSet1 = new HashSet<SaleLink>();
		Set<SaleLink>linkSet2 = new HashSet<SaleLink>();
		Set<SaleLink>linkSet3 = new HashSet<SaleLink>();
		Set<SaleLink>linkSet4 = new HashSet<SaleLink>();
		Set<SalePicture>picSet1 = new HashSet<SalePicture>();
		Set<SalePicture>picSet2 = new HashSet<SalePicture>();
		Set<SalePicture>picSet3 = new HashSet<SalePicture>();
		Set<SalePicture>picSet4 = new HashSet<SalePicture>();
		/*Relationship between categories and sub-categories*/
		cat1.setSuperCategory(cat1);
		cat2.setSuperCategory(cat2);
		cat3.setSuperCategory(cat2);
		cat4.setSuperCategory(cat2);
		cat5.setSuperCategory(cat5);
		cat6.setSuperCategory(cat6);
		catSet2.add(cat3);
		catSet2.add(cat4);
		catSet5.add(cat6);
		cat2.setSubCategories(catSet2);
		cat5.setSubCategories(catSet5);
		/*Relationship between a company and a sale.*/
		sale1.setCompany(comp1);
		sale2.setCompany(comp3);
		sale3.setCompany(comp3);
		sale4.setCompany(comp2);
		offSales1.add(sale1);
		offSales2.add(sale2);
		offSales2.add(sale3);
		offSales3.add(sale4);
		comp1.setOfferedSales(offSales1);
		comp3.setOfferedSales(offSales2);
		comp2.setOfferedSales(offSales3);
		/*Friendship between customers.*/
		friends1.add(customer2);
		friends1.add(customer3);
		friends2.add(customer);
		friends3.add(customer);
		friends3.add(customer4);
		friends4.add(customer3);
		customer.setFriends(friends1);
		customer2.setFriends(friends2);
		customer3.setFriends(friends3);
		customer4.setFriends(friends4);
		/*Credit Card and Customer relationship*/
		credCardSet1.add(card1);
		credCardSet1.add(card2);
		credCardSet3.add(card3);
		credCardSet4.add(card4);
		credCardSet5.add(card5);
		customer.setCreditCards(credCardSet1);
		customer3.setCreditCards(credCardSet3);
		customer4.setCreditCards(credCardSet4);
		customer5.setCreditCards(credCardSet5);
		/*Relationship between category and sale*/
		sale1.setCategory(cat1);
		sale2.setCategory(cat3);
		sale3.setCategory(cat6);
		sale4.setCategory(cat3);
		catSales1.add(sale1);
		catSales3.add(sale2);
		catSales3.add(sale4);
		catSales6.add(sale3);
		cat1.setCategorySales(catSales1);
		cat3.setCategorySales(catSales3);
		cat6.setCategorySales(catSales6);
		/*Relation between the link and the sale*/
		link1.setSale(sale1);
		link2.setSale(sale2);
		link3.setSale(sale3);
		link4.setSale(sale4);
		link5.setSale(sale4);
		linkSet1.add(link1);
		linkSet2.add(link2);
		linkSet3.add(link3);
		linkSet4.add(link4);
		linkSet4.add(link5);
		sale1.setLinks(linkSet1);
		sale2.setLinks(linkSet2);
		sale3.setLinks(linkSet3);
		sale4.setLinks(linkSet4);
		/*Relation betw1een dates and sale*/
		//There are no dates here because there are not sales with dates
		/*Relation between sale and pictures*/
		pic1.setSale(sale1);
		pic2.setSale(sale2);
		pic3.setSale(sale3);
		pic4.setSale(sale4);
		pic5.setSale(sale4);
		picSet1.add(pic1);
		picSet2.add(pic2);
		picSet3.add(pic3);
		picSet4.add(pic4);
		picSet4.add(pic5);
		sale1.setPictures(picSet1);
		sale2.setPictures(picSet2);
		sale3.setPictures(picSet3);
		sale4.setPictures(picSet4);
		
		

		//Transaction starts
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(pt1);
			session.save(pt2);
			session.save(cat1);
			session.save(cat2);
			session.save(cat3);
			session.save(cat4);
			session.save(cat5);
			session.save(cat6);
			session.save(card1);
			session.save(card2);
			session.save(card3);
			session.save(card4);
			session.save(card5);
			session.save(link1);
			session.save(link2);
			session.save(link3);
			session.save(link4);
			session.save(link5);
			session.save(customer);
			session.save(customer2);
			session.save(customer3);
			session.save(customer4);
			session.save(customer5);
			session.save(comp1);
			session.save(comp2);
			session.save(comp3);
			session.save(sale1);
			session.save(sale2);
			session.save(sale3);
			session.save(sale4);
			session.save(coup1);
			session.save(coup2);
			session.save(coup3);
			session.save(coup4);
			session.save(saled1);
			session.save(saled2);
			session.save(pic1);
			session.save(pic2);
			session.save(pic3);
			session.save(pic4);
			session.save(pic5);
			
			/*Query section*/
			QueryManager queryManager = new QueryManager();
			System.out.println("=======================   QUERY   1   =======================");
			queryManager.query1(session);
			System.out.println("=======================   QUERY   2   =======================");
			queryManager.query2(session);
			System.out.println("=======================   QUERY   3   =======================");
			queryManager.query3(session);
			
			session.getTransaction().commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		sessionFactory.close();
	}
}
