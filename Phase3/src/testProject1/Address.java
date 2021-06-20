package testProject1;

public class Address {
	private String city;
	private String country;
	
	public Address() {
		System.out.println("Default constructor");
	}

	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}
	
}
