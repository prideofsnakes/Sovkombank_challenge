package h2db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ru.hilariousstartups.soap.gen.Gender;
import ru.hilariousstartups.soap.gen.User;

@Entity
public class H2User {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private String firstName;
	  private String lastName;

	  protected H2User() {}

	  public H2User(String firstName, String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	  }

	  @Override
	  public String toString() {
	    return String.format(
	        "H2User[id=%d, firstName='%s', lastName='%s']",
	        id, firstName, lastName);
	  }

	  public Long getId() {
	    return id;
	  }

	  public String getFirstName() {
	    return firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }
}
