package classes;

import java.util.Date;

public class State3Expired implements State{
	
	public void doAction(Sale sale, Date todayDate) {
		if(todayDate.before(sale.getExpeditionDate())){
			sale.setState(new State1Waiting());
			System.out.println("La promoción " + sale.getID() +
								" vuelve a estar en espera después de " + 
								" haber estado vencida.");
		}
	}

}
