package model;

public class Person {
	
	
	PersonName name;
	String phone;
	String email;
	
	
	
	public PersonName getName() {
		return name;
	}
	public void setName(PersonName name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
}
