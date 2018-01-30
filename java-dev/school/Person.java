package school;
import util.Displayable;

public abstract class Person {
	
	//private fields
	private String firstName;
	private String lastName;

	//empty constructor
	public Person () {}

	//set first name
	public void setFirstName(String fn) {
		firstName = fn;
	}

	//set last name
	public void setLastName(String ln) {
		lastName = ln;
	}

	//get first name
	public String getFirstName() {
		return firstName;
	}

	//get last name
	public String getLastName() {
		return lastName;
	}

	//get full name
	public String getFullName() {
		return firstName + " " + lastName;
	}

}