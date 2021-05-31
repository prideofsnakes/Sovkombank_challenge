package h2db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ru.hilariousstartups.soap.gen.Gender;
import ru.hilariousstartups.soap.gen.User;

@Entity
public class H2User extends User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	H2User(){
		super();
	}
	
	private String firstName;
	private String lastName;
	private String sex;
	
	public H2User(String fname, String lname, Gender gender) {
		super();
		this.sex = (gender.equals(Gender.MALE) ? "M" : "F");
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
	 
	 public String getSex() {
		 return this.sex;
	 }
}
