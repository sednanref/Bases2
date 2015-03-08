package classes;
import java.util.Date;

/* State:
•  Define an interface to relate the behavior of a Sale with it state.
*/

public interface State {
   public void doAction(Sale sale, Date todayDate);
}