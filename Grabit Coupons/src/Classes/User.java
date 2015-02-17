package Classes;
import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	private int id;
	@Column(name="NAME")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
