package util;
import org.hibernate.*;
import classes.*;
import java.util.*;

public class QueryManager {
	
	/*This query return the whole information about a sale*/
	public void query1(Session session){
		// To get total row count.
		int id = 1;
		Sale sale = (Sale) session.createQuery("from Sale where ID="+id+"").uniqueResult();
		
		System.out.println("ID: " + sale.getID());
		System.out.println("Nombre: " + sale.getName());
		System.out.println("Precio Original: " + sale.getOriginalPrice());
		System.out.println("Precio Ofrecido: " + sale.getOfferedPrice());
		System.out.println("Fecha de Expedición: " + sale.getExpeditionDate());
		System.out.println("Fecha de Expiración: " + sale.getExpirationDate());
		System.out.println("Descripción: " + sale.getDescription());
		System.out.println("Empresa que la ofrece: " + sale.getCompany().getName());
		System.out.println("Categoría: " + sale.getCategory().getName());
		System.out.println("Links:" );
		Set<SaleLink> links = sale.getLinks();
		int i = 1;
		for(SaleLink link: links){
			System.out.println("	Link " + i + " : "+ link.getUrl());
		}
		System.out.println("Dates:" );
		Set<SaleDate> dates = sale.getDates();
		i = 1;
		for(SaleDate date: dates){
			System.out.println("	Date " + i + " : "+ date.getDate());
		}
		System.out.println("Pictures:" );
		Set<SalePicture> pictures = sale.getPictures();
		i = 1;
		for(SalePicture picture: pictures){
			System.out.println("	Picture " + i + " : "+ picture.getPath());
		}
		
	}
	
	/*This query provide the Virtual Money of a Customer*/
	public void query2(Session session){
		String eMail = "sednanref2004@gmail.com";
		int vm = (int) session.createQuery("select virtualMoney from Customer where eMail='"+eMail+"'").uniqueResult();
		System.out.println("El dinero virtual de " + eMail + " es: " +  vm);
	}
	
	/*This Query provide the sales offered by a company*/
	public void query3(Session session){
		String eMail = "contacto@plazas.com.ve";
		String query = "select name from Sale where company.eMail='"+eMail+"'";
		Query q = session.createQuery(query);
		List sales = q.list(); 
		int i = 1;
		
    	for (Iterator iterator = sales.iterator(); iterator.hasNext();) {
    		Sale sale = (Sale) iterator.next(); 
    		System.out.print("Promoción " + i + " : " + sale.getName()); 
    	}
	}
}
