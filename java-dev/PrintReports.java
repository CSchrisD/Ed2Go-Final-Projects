import util.*;
import java.util.*;
import school.*;

public class PrintReports {
	public static void main(String[] args) {
		new PrintReports();
	}

	//initiate calls for multiple inputs in the class array list
	public PrintReports () {
		ArrayList<Displayable> allClasses = new ArrayList<Displayable>();
		Character userEntry = null;
		System.out.println("First You Need To Create A Classroom.");

		do {
			allClasses.add(enterClassroom());
			userEntry = KeyboardReader.getPromptedChar("Enter Another Classroom? (Y/N): ");
		} while (Character.toUpperCase(userEntry) == 'Y');

		report(allClasses);
	}

	//add information using the classroom constructor (room, teacher, and student list)
	//limit to class room numbers to 100 or greater
	 public Displayable enterClassroom () {
	 	int roomNum = 0;
	 	Character userEntry = null;

	 	do {
	 		roomNum = KeyboardReader.getPromptedInt("Enter Room Number: ");
	 		if (roomNum < 100) {
	 			System.out.println("Please enter a number greater than 100");
	 		}
	 	} while (roomNum < 100);

	 	System.out.println("Now You Need To Enter A Teacher For The Classroom.");
	 	Displayable teacher = enterTeacher();

	 	System.out.println("Now You Need To Add Students For The Classroom.");
	 	ArrayList<Displayable> students = new ArrayList<Displayable>();
	 	do {
	 	 	students.add(enterStudent());
	 	 	userEntry = KeyboardReader.getPromptedChar("Enter Another Student? (Y/N): ");
	 	 } while (Character.toUpperCase(userEntry) == 'Y');

	 	return new Classroom(roomNum, teacher, students);
	 }

	 //add teacher information to be returned
	 public Displayable enterTeacher () {
	 	String firstName = KeyboardReader.getPromptedString("Enter Teacher First Name: ");
	 	String lastName = KeyboardReader.getPromptedString("Enter Teacher Last Name: ");
	 	String subject = KeyboardReader.getPromptedString("Enter Subject Taught: ");
	 	return new Teacher(firstName, lastName, subject);
	 }

	 //add student information to be returned
	 //studen id must be greater than 0, and grade must be between 0-100
	  public Displayable enterStudent () {
	  	int studentID;
	  	int grade = 0;
	  	String firstName = KeyboardReader.getPromptedString("Enter Student First Name: ");
	 	String lastName = KeyboardReader.getPromptedString("Enter Student Last Name: ");

	 	do {
	  		studentID = KeyboardReader.getPromptedInt("Enter Student ID: ");
	  		if (studentID <= 0) {
				System.out.println("Please enter a number greater than 0");
	  		}
	  	} while (studentID <= 0);

	 	do {
	  		grade = KeyboardReader.getPromptedInt("Enter Student Final Grade: ");
	  		if (0 > grade) {
				System.out.println("Please enter a number greater than 0");
	  		} else if (grade > 100) {
	  			System.out.println("Please enter a number less than than 101");
	  		}
	  	} while (0 > grade || grade > 100);

	  	return new Student(firstName, lastName, studentID, grade);
	  }

	  //print all classes in individual sections with their
	  //related teacher and students
	 void report(ArrayList<Displayable> list) {
	 	for(int i = 0; i < list.size(); i++) {
	 		System.out.println("----------------------------------------------------------");
	 		Classroom curr = (Classroom) list.get(i);
	 		System.out.println(curr.display());
	 		System.out.println(curr.getTeacher().display());

	 		ArrayList<Displayable> studentList = curr.getStudents();
	 		for(int j = 0; j < studentList.size(); j++) {
	 			Student currStudent = (Student) studentList.get(j);
	 			System.out.println(currStudent.display());
	 		}
	 	}
	 	System.out.println("----------------------------------------------------------");
	 }
}