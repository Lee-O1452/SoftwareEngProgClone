
public class Customer {

	private int customerID;
	private String firstName;
	private String lastName;
	
	public Customer(int customerID, String firstName, String lastName) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	//getters
	public int getCustomerID() {
		return customerID;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	
	//setters
	public void setCustomerID() {
		customerID = customerID;
	}
	
	public void setfirstName() {
		firstName = firstName;
	}
	
	public void setlastName() {
		lastName = lastName;
	}
	
	
	@Override
	public String toString() {
		String ts = String.format("%d , %s , %s\n", customerID, firstName, lastName);
		return ts;
	}
	
	
}
