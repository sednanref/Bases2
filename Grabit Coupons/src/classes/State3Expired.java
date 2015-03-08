package classes;

import java.util.Date;

public class State3Expired implements State{
	
	public void doAction(Sale sale, Date todayDate) {
		if(todayDate.before(sale.getExpeditionDate())){
			sale.setState(new State1Waiting());
			sale.setVersion(sale.getVersion()+1);
			System.out.println("La promoción " + sale.getID() +
								" vuelve a estar en espera después de " + 
								" haber estado vencida.");
			System.out.println("La promoción ahora está en su versión: "+
								sale.getVersion() + ".");
		}
	}

}
