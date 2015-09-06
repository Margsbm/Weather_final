package il.ac.hit.weather.data.service;

public class Location {
	private String city;
	private String country;
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Location(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	
}
