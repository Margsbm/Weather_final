package il.ac.hit.weather.data.service;

import org.json.JSONException;

public class _RunService {

	
		// TODO Auto-generated method stub
  /**
 * @param Location object 
 * @return Weather data object
 * @throws JSONException
 * @throws Exception
 */
public WeatherData runWeatherService(Location loc) throws JSONException, Exception{
		
		 WeatherDataServiceFactory run = WeatherDataServiceFactory.getInstance();
		
		 
		 String url = WeatherDataServiceFactory.OPEN_WEATHER_MAP;
		 @SuppressWarnings("static-access")
		 IWeatherDataService service= run.getWeatherData(url+loc.getCity()+","+loc.getCountry());
		 
		 WeatherData data = service.getWeatherData(loc);
		 System.out.println(data.toString());
		return data;
		 
			 
		 
  }

}
