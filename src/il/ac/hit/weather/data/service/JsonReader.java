package il.ac.hit.weather.data.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.SocketException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

  private static String readAll(Reader rd) throws IOException {
	

    StringBuilder sb = new StringBuilder();
    int cp;
    try{
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    System.out.println(sb.toString());
    return sb.toString();
    }catch(Exception e){
    	
    	e.printStackTrace();
    	
    	//return  errorMessage;
    }
	return null;
	
  }

  public JSONObject readJsonFromUrl(String url) throws IOException, JSONException,SocketException{
	  
	  InputStream is = new URL(url).openStream();
	  JSONObject json = null;
	  try {
     
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      
      String jsonText = readAll(rd);
       json = new JSONObject(jsonText);
      return json;
    }catch (Exception e){
    	 e.printStackTrace();
    	 
    } finally {
     
    	 is.close();
    }
	return json;
  }

 
}