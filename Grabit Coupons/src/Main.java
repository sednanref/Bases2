import org.hibernate.*;
import util.*;


public class Main {

		public static void main(String[] args){
			DBManager dbmanager = new DBManager();
			dbmanager.insertionAndQueries();
		
			
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
