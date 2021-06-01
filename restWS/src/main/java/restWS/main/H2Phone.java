package restWS.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class H2Phone {
	H2Phone(){}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String phone;
	private long userid;
	
	H2Phone(String phone, long userid) {
		this.phone = phone;
		this.userid = userid;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public long getUserId() {
		return this.userid;
	}
}
