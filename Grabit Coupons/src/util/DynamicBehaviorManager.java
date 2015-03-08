package util;

import java.util.Date;

import org.hibernate.Session;

import classes.Sale;
@SuppressWarnings("deprecation")
public class DynamicBehaviorManager {
	
	 public static void updateSales(Session session, Sale sale1, Sale sale2){
		   
			/* State Change
			- If the date provided to the doAction is before 
			  the expedition date of the sale, it will turn the state
			  to "waiting".
			- If the date provided to the doAction is between the 
			  expedition and expiration dates of the sale, it will 
			  turn the state to "active".
			- If the date provided to the doAction is after the
			  expiration date of the sale, it will turn the state to
			  "expired".
	  	    */
	   
		 	System.out.println("=========================================");
		 	System.out.println("=========DYNAMIC BEHAVIOR ON SALE========");
		 	System.out.println("=========================================");
			//Dates to test the states of the sale.
			Date date1 = new Date(2014 - 1900,11,11); //	11/12/2014
			Date date2 = new Date(2015 - 1900,4,11);  //	11/05/2015
			//Date date3 = new Date(2014 - 1900,3,17);  //	17/04/2014
			//Date date4 = new Date(2014 - 1900,4,17);  //	17/05/2015
			//Dates that are supposed to be the "current" dates.
			Date todayDate1 = new Date(2014 - 1900,10,11); //	11/11/2014
			Date todayDate2 = new Date(2015 - 1900,1,11);  //	11/02/2015
			Date todayDate3 = new Date(2015 - 1900,3,17);  //	17/04/2015
			Date todayDate4 = new Date(2015 - 1900,6,17);  //	17/07/2015
			//updating the dates of the sale.
		    sale1.setExpeditionDate(date1);
		    sale1.setExpirationDate(date2);
		    	//test with a date that is 1 month before the expedition date
		    	//of the sale. The sale should not change it state.
		    sale1.doAction(todayDate1); //This date keeps the sale waiting.	
		    	//Now the "todayDate" is between the expedition and expiration
		    	//dates, the sale is now active.
		    sale1.doAction(todayDate2); //This date makes the sale active.
		    	//This doesn't change the state of the sale, because the today
		    	//date is still between the interval of dates of the sale.
		    sale1.doAction(todayDate3); //This date doesn't change the state of the sale.
		    	//This date change the state of the sale because it is now expired.
		    sale1.doAction(todayDate4); //This date doesn't change the state of the sale.
		    sale1.doAction(todayDate1); //This date keeps the sale waiting.		
		  //Seteando el rendimiento del empleado 2 a 100
		 /*   emp2.setPerformance(100);
		    emp2.doAction();
		 */  
		    session.save(sale1);
		    	

	      /*  session.getTransaction().commit();
	        session.close();
	        sessionFactory.close();*/
 
	 }
}
