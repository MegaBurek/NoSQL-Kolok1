package covid.models;

import org.springframework.data.annotation.Id;

public class Address {
	
	@Id
	private String id;
	
	private String city;
	
	private String street;
	
	private String streetNumber;
	
	public Address() {
		
	}

	
	public Address(String city, String street, String streetNumber) {
		super();
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}


	
}
