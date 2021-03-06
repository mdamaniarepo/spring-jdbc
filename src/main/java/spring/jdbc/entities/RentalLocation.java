package spring.jdbc.entities;

public class RentalLocation {

	private Integer rentalLocationId;

	private String name;

	private String address1;

	private String address2;

	private String city;

	private String state;

	private String postalCode;

	public Integer getRentalLocationId() {
		return rentalLocationId;
	}

	public void setRentalLocationId(Integer rentalLocationId) {
		this.rentalLocationId = rentalLocationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "RentalLocation [rentalLocationId=" + rentalLocationId + ", name=" + name + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + "]";
	}
	
	

}
