package restWS.main;

public class PhoneNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4515115742871646913L;
	
	PhoneNotFoundException(Long id) {
		    super("Could not find employee " + id);
	}
}
