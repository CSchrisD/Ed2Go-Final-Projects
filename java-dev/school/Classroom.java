package school;
import util.Displayable;
import java.util.*;

public class Classroom extends Person implements Displayable {

	//private fields
	private int roomNumber;
	private Displayable teacher;
	private ArrayList<Displayable> students; 

	//empty constructor
	public Classroom () {}

	//non-empty constructor
	public Classroom (int rn, Displayable teach, ArrayList<Displayable> s) {
		setRoomNumber(rn);
		setTeacher(teach);
		setStudents(s);
	}
	
	//set room number
	public void setRoomNumber (int rn) {
		roomNumber = rn;
	}

	//set teacher
	public void setTeacher (Displayable teach) {
		teacher = teach;
	}

	//add student
	public void setStudents (ArrayList<Displayable> s) {
		students = s;
	}

	//get room number
	public int getRoomNumber () {
		return roomNumber;
	}

	//get teacher
	public Displayable getTeacher () {
		return teacher;
	}

	//get students
	public ArrayList<Displayable> getStudents () {
		return students;
	}

	@Override
	public String display () {
		return  "Room Number: " + roomNumber;
	}

}