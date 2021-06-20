package testProject1;

public class Employee {
	private String name;
	private int salary;
	private Address address;
	
	public Employee() {
		System.out.println("Default constructor");
	}
	
	public Employee(String name, int salary, Address address) {
		super();
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public void display() {
		System.out.println("Employee [name=" + name + ", salary=" + salary + "]");
		System.out.println(address.toString());
	}
	
}
