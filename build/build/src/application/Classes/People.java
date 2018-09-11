package application.Classes;

import application.Global;

public class People {
	private int id;
	private String lastName;
	private String firstName;
	private String phone;
	private String city;
	private String postalCode;
	private String address;
	
	public People() {
		this.id = 0;
		this.lastName = "";
		this.firstName = "";
		this.phone="";
		this.city = "";
		this.postalCode="";
		this.address="";
	}
	public People(int id, String lastName, String firstName, String phone, String city, String postalCode, String address) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
		this.city = city;
		this.postalCode = postalCode;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addPeople() {
		People lastPeople = new People();
		int id = 0;
		
		if (Global.peoples.size() != 0) {
			lastPeople = Global.peoples.get(Global.peoples.size() - 1);
			id = lastPeople.getId() + 1;
		}

		People x = new People(id, this.lastName, this.firstName, this.phone, this.city, this.postalCode, this.address);
		Global.peoples.add(x);
	}
	
	public void deletePeople(String x) {
		for( People people : Global.peoples ) {
			if(x.equals(Integer.toString(people.getId()))) {
				Global.peoples.remove(people);
				break;
			}
		}
	}
}
