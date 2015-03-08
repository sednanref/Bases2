package classes;

import java.util.Date;

public class State2Active implements State{

	public void doAction(Sale sale, Date todayDate) {
		
		if(todayDate.after(sale.getExpirationDate())){
			sale.setState(new State3Expired());
			System.out.println("El período de vigencia de la promoción " + 
								sale.getID() + " ha culminado, la promoción" +
							    "está vencida.");
		}
		
	}

}
