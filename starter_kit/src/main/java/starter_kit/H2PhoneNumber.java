package starter_kit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class H2PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String phoneNumber;
	
	private int userid;
	
	H2PhoneNumber(){
		
	}
	
	public H2PhoneNumber(String num, int userid) {
		this.phoneNumber = num;
		this.userid = userid;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}
