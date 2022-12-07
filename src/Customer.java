import java.io.Serializable;

public class Customer implements Serializable {

	private String customerID;
	private String firstName;
	private String lastName;
	
	public Customer(String customerID, String firstName, String lastName) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//getters
	public String getCustomerID() {
		return customerID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer ID - %s , First Name - %s , Last Name - %s\n", customerID, firstName, lastName);
	}
	
	
}
