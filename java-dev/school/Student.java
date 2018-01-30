package school;
import util.Displayable;

public class Student extends Person implements Displayable {
	
	//private fields
	private int studentId;
	private int studentGrade;

	//empty constructor
	public Student () {}

	//non-empty constructor
	public Student (String fn, String ln, int id, int grade) {
		setFirstName(fn);
		setLastName(ln);
		setStudentID(id);
		setStudentGrade(grade);
	}

	//set student ID
	public void setStudentID (int sId) {
		studentId = sId;
	}

	//set student grade
	public void setStudentGrade (int sg) {
		studentGrade = sg;
	}

	//get student ID
	public int getStudentID () {
		return studentId;
	}

	//get student grade
	public int getStudentGrade () {
		return studentGrade;
	}

	@Override
	public String display () {
		return "Studnet ID: " + studentId + " 	" + getFullName() 
			+ " 	Final Grade: " + studentGrade;
	}
}