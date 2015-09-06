package il.ac.hit.weather.data.service;

import java.io.IOException;

import org.json.JSONException;

public interface IWeatherDataService {
  
//	WeatherData weatherData = new WeatherData();
//	Location location = new Location();
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException, JSONException, IOException;
	
}
