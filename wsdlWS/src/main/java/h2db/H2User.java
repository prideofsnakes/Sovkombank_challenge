package h2db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ru.hilariousstartups.soap.gen.Gender;
import ru.hilariousstartups.soap.gen.User;

@Entity
public class H2User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	H2User(){}
	
	public H2User(String fname, String lname) {
//		this.gender = gender;
		this.firstName = fname;
		this.lastName = lname;
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
