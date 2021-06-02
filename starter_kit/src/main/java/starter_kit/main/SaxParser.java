package starter_kit.main;

import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {
	
	private HashMap<String, String> userMap = new HashMap<String, String>();
	
	public HashMap <String, String> parseUser(HttpResponse response) throws Exception {
		
	    try {

	    SAXParserFactory factory = SAXParserFactory.newInstance();
	    SAXParser saxParser = factory.newSAXParser();
	    
	    DefaultHandler handler = new DefaultHandler() {
	    	
	    boolean firstName = false;
	    boolean lastName = false;
	    
	    public void startElement(String uri, String localName,String qName,
	                Attributes attributes) throws SAXException {
	    	
    	

	        if (qName.equalsIgnoreCase("ns2:firstName")) {
	        	firstName = true;
	        }
	        
	        if (qName.equalsIgnoreCase("ns2:lastName")) {
	        	lastName = true;
	        }
	        
	        
	    }


	    public void characters(char ch[], int start, int length) throws SAXException {

	    	

	        if (firstName) {
	        	userMap.put("firstName", new String(ch, start, length));
	        	System.out.println(new String(ch, start, length));
	        	firstName = false;
	        }
	        
	        if (lastName) {
	        	userMap.put("lastName", new String(ch, start, length));
	        	System.out.println(new String(ch, start, length));
	        	lastName = false;
	        }
	        
	        
	    }
	    
	    
	     };

	       saxParser.parse(response.getEntity().getContent(), handler);
	       

	     } catch (Exception e) {
	    	 throw e;
	     }
	    return userMap;
	   }
}
