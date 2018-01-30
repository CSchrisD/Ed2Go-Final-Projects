package school;
import util.Displayable;

public class Teacher extends Person implements Displayable {
	
	//private fields
	private String subject;

	//empty constructor
	public Teacher () {}

	//non-empty constructor
	public Teacher (String fn, String ln, String sub) {
		setFirstName(fn);
		setLastName(ln);
		setSubject(sub);
	}

	//set subject
	public void setSubject (String sub) {
		subject = sub;
	}

	//get subject
	public String getSubject () {
		return subject;
	}

	@Override
	public String display () {
		return getFullName() + " teaches " + subject; 
	}
}