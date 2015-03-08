package classes;
import java.util.Date;
/*
 * 
 * */


public class State1Waiting implements State{
	public void doAction(Sale sale, Date todayDate) {
		if(todayDate.after(sale.getExpeditionDate()) &&
		   todayDate.before(sale.getExpirationDate())){
			sale.setState(new State2Active());
			System.out.println("El período de vigencia de la promoción " +
							  + sale.getID() + " ha comenzado.");
		}
	}
}
