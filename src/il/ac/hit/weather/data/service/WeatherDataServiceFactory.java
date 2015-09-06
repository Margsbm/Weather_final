package il.ac.hit.weather.data.service;

public class WeatherDataServiceFactory  {
	
	static final String OPEN_WEATHER_MAP = "http://api.openweathermap.org/data/2.5/weather?q=";
	
	
	 private static WeatherDataServiceFactory weatherDataFactory = new WeatherDataServiceFactory( );
	 private  WeatherDataServiceFactory() {}
	    public static WeatherDataServiceFactory getInstance( ) {
	    
	        return weatherDataFactory;
	     }
	  
	    public static  IWeatherDataService getWeatherData(String url){
	    	if(url.contains(OPEN_WEATHER_MAP)){
	    		try{
	    		 WeatherDataServiceGetCurrentData wd = new WeatherDataServiceGetCurrentData();
	    		 wd.setUrl(url);
	            return wd ;
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	         }
			return null;
	    }

}
