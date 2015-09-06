package il.ac.hit.weather.data.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import il.ac.hit.weather.data.service.IWeatherDataService;
import il.ac.hit.weather.data.service.Location;
import il.ac.hit.weather.data.service.WeatherData;
import il.ac.hit.weather.data.service.WeatherDataServiceException;
import il.ac.hit.weather.data.service.WeatherDataServiceFactory;

public class WeatherDataServiceGetCurrentDataTest {
	
	WeatherDataServiceFactory run = WeatherDataServiceFactory.getInstance();
	Location location = new Location();
	WeatherData weatherData = new WeatherData();
	
	
	@Before
	public void setUp() throws Exception {
		location.setCity("Holon");
		location.setCountry("IL");
		//location.setCity("");
		//location.setCountry("");
		
			
	}
		

	@After
	public void tearDown() throws Exception {
	run = null;
	location = null;
	}

	/*@Test
	public void testWeatherDataServiceGetCurrentData() {
		fail("Not yet implemented");
	}
    */
	@Test
	public void testGetWeatherData() throws WeatherDataServiceException, JSONException, IOException {

	 try
	{
		
		 IWeatherDataService service= WeatherDataServiceFactory.getWeatherData(WeatherDataServiceFactory.OPEN_WEATHER_MAP+location.getCity()+","+location.getCountry());
		 WeatherData data = service.getWeatherData(location);
		 
			assertEquals("Holon", data.getCity());
			assertEquals("IL", data.getCountry());
			assertEquals("34.77", data.getCoord1());
			assertEquals("Error: Not found city", data.getCodMessage());
	} catch (WeatherDataServiceException e){
		
	}
	
	//	fail("Not yet implemented");
	}

}
