package io.pivotal.edu.spring.xd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import java.io.IOException;
import java.util.Map;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.integration.transformer.MessageTransformationException;

public class Translator {
	 private ObjectMapper mapper = new ObjectMapper();

		// Requested language.
	
	/**
	 *	Translate into the given language / dialect. 
	 */
	public Map translate(String payload){
	    	String [] info = payload.split("\\t");
	    	HashMap <String,String> obj = new HashMap<String,String>();
	    	obj.put("orderID",info[0]);
	    	obj.put("customerID",info[1]);
	    	obj.put("orderPlaced",info[3]);
	    	obj.put("orderShipped",info[4]);
	    	obj.put("orderType",info[7]);
	    	obj.put("orderWeight",info[9]);
	    	obj.put("addressLineOne",info[19]);
	    	obj.put("addressLineTwo",info[20]);
	    	obj.put("city",info[22]);
	    	obj.put("state",info[23]);
	    	obj.put("zipcode",info[24]);
	    	obj.put("country",info[25]);
	    	obj.put("phoneNumber",info[26]);
	    	obj.put("customerName",info[27]);
	    	obj.put("customerEmail",info[28]);
	    	obj.put("confirmationNumber",info[29]);
	        
	        return obj;
	     
	}
}