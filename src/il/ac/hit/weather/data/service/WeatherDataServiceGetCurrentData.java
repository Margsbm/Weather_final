package il.ac.hit.weather.data.service;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataServiceGetCurrentData implements IWeatherDataService{
  
	WeatherData weatherData = new WeatherData();
	Location location = new Location();
	  static JsonReader jreader = new JsonReader();
	 private String url;  
	   
			public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

			/**
			 * returning WeatherData object
			 */
			public WeatherDataServiceGetCurrentData() {
		super();
		// TODO Auto-generated constructor stub
	}

			@Override
			public WeatherData getWeatherData(Location location)
					throws WeatherDataServiceException, JSONException, IOException {
	         WeatherData weatherData = new WeatherData();
		    	
		    	JSONObject json = jreader.readJsonFromUrl(url);
		    	if(json.get("cod").toString().equalsIgnoreCase("404")){
		    		weatherData.setCod(json.get("cod").toString());
		    		weatherData.setCodMessage(json.get("message").toString());
		    	}else{
		    	 weatherData.setCoord1(json.getJSONObject("coord").get("lon").toString());
		    	 weatherData.setCoord2(json.getJSONObject("coord").get("lat").toString()); 
		    	 
		    	 String str = json.get("weather").toString();
		    	// System.out.println(str.substring(1, str.length()-1));
		    	 JSONObject jsonStr = new JSONObject(str.substring(1, str.length()-1));
		    	 
		    	 weatherData.setWeather_general_desc(jsonStr.get("main").toString()); 
		    	 weatherData.setWeather_desc(jsonStr.get("description").toString()); 
		    	 weatherData.setAvg_current_temp(json.getJSONObject("main").get("temp").toString()); 
		    	 weatherData.setAvg_max_temp(json.getJSONObject("main").get("temp_max").toString());  
		    	 weatherData.setAvg_min_temp(json.getJSONObject("main").get("temp_min").toString());
		    	 weatherData.setPressure(json.getJSONObject("main").get("pressure").toString());
		    	 weatherData.setHumidity(json.getJSONObject("main").get("humidity").toString()); 
		    	 weatherData.setWind_speed(json.getJSONObject("wind").get("speed").toString()); 
		    	 weatherData.setClouds_percent(json.getJSONObject("clouds").get("all").toString());  
		    	 weatherData.setCity(json.get("name").toString());  
		    	 weatherData.setCountry(json.getJSONObject("sys").get("country").toString());  
		    	
		    		
		    	}
		    	
				return weatherData;
			   
			 
			}      
	
}
