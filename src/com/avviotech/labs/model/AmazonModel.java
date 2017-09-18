package com.avviotech.labs.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AmazonModel {
	
	public static String getCustomerProfileData(String access_token) {
		// verify that the access token belongs to us
		
		 String profile = "";
		 try {
			
			 Content c = Request.Get("https://api.amazon.com/auth/o2/tokeninfo?access_token=" + URLEncoder.encode(access_token, "UTF-8"))
			                   .execute()
			                   .returnContent();

			
			 c = Request.Get("https://api.amazon.com/user/profile")
			           .addHeader("Authorization", "bearer " + access_token)
			           .execute()
			           .returnContent();
			 
			 profile = c.asString();
			 //System.out.println(String.format("%s %s %s", m.get("name"), m.get("email"), m.get("user_id")));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return profile;
	}
}
