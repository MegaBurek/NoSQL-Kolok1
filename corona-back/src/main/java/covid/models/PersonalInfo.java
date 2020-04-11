package covid.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class PersonalInfo {
	
	@Id
	private String id;

	private String name;
	
	private String surname;
	
	private String jmbg;
	
	private String lbo;
	
	private String phoneNumber;
	
//	@DBRef
	private Address address;
	
	
	public PersonalInfo() {
		
	}
	
	public PersonalInfo(String name, String surname, String jmbg, String lbo, String phoneNumber, Address address) {
		super();
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.lbo = lbo;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getLbo() {
		return lbo;
	}

	public void setLbo(String lbo) {
		this.lbo = lbo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
