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

public class CSVToJson {
	 private ObjectMapper mapper = new ObjectMapper();


	public Map translate(String payload){



				HashMap <String,String> obj = new HashMap<String,String>();
		String [] info = payload.split("\\|");

		try{
		String [] coordinates = info[10].split(",");

    	obj.put("transaction_id",info[0]);
    	obj.put("credit_card_type",info[1]);
    	obj.put("credit_card_number",info[2]);
    	obj.put("retailer_name",info[3]);
    	obj.put("amount",info[4]);
    	obj.put("street",info[5]);
    	obj.put("city",info[6]);
    	obj.put("zip",info[7]);
    	obj.put("state",info[8]);
    	obj.put("country",info[9]);
    	obj.put("latitude", coordinates[0]);
    	obj.put("longitude", coordinates[1]);
    	obj.put("timestamp",info[11]);
		} catch(Exception e){
			System.out.println("Missing data field");
		}
	        return obj;

	}
}
