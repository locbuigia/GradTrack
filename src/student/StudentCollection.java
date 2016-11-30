package student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.Student;
import data.StudentDB;

/**
 * A class for the collection of students.
 * @author Nico Tandyo
 *
 */
public class StudentCollection {
private static StudentDB mStudentDB;
	
	/**
	 * Return a list of students with the matching name. 
	 * @param theName client to look for
	 * @return a list of clients that match
	 */
	public static List<Student> search(String theName) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
				return mStudentDB.getStudents(theName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Return a list of students with the matching GPA. 
	 * @param theGpa
	 * @return a list of students with matching GPA
	 */
	public static List<Student> searchByGPA(double theGpa) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
				return mStudentDB.getStudentsGpa(theGpa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Return a list of students with the matching salary. 
	 * If theMinSalary = 0, search student with salary more than theMaxSalary
	 * If theMaxSalary = 0, search student with salary less than theMinSalary
	 * @param theMinSalary
	 * @param theMaxSalary
	 * @return a list of students with matching salary
	 */
	public static List<Student> searchBySalary(int theMinSalary, int theMaxSalary) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
				return mStudentDB.getStudentsSalary(theMinSalary, theMaxSalary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Return a list of students with the matching major. 
	 * @param theMajor
	 * @return a list of students with matching major
	 */
	public static List<Student> searchByMajor(String theMajor) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
				return mStudentDB.getStudentsMajor(theMajor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Return a list of students with the matching degree. 
	 * @param theDegree
	 * @return a list of students with matching degree
	 */
	public static List<Student> searchByDegree(String theDegree) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
				return mStudentDB.getStudentsMajor(theDegree);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Return a list of students with the matching intern. 
	 * @param theInternship name as a string
	 * @return a list of students with matching intern
	 */
	public static List<Student> searchByInternship(String theInternship) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
				return mStudentDB.getStudentsIntern(theInternship);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Return a list of students with the matching job. 
	 * @param theJob name as a string
	 * @return a list of students with matching intern
	 */
	public static List<Student> searchByJob(String theJob) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
				return mStudentDB.getStudentsJob(theJob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Modify the particular column of the student with the given data can only modify email. 
	 * @param theStudent student to modify
	 * @param theColumn the field in the table to modify
	 * @param theData the value for the field
	 * @return true or false
	 */
	public static boolean updateStudent(Student theStudent, String theColumn, Object theData) {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		String message = mStudentDB.updateStudent(theStudent, theColumn, theData);
		if (message.startsWith("Error updating student: ")) {
			return false;
		}
		return true;
	}
	/**
	 * Adds a new client to the data. 
	 * @param theStudent
	 * @return true or false
	 */
	public static boolean addStudent(Student theStudent) {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		
		String message = mStudentDB.addStudent(theStudent);
		if (message.startsWith("Error adding student:")) {
			return false;
		}
		return true;
	}
	/**
	 * 
	 * Return all students in the list, null otherwise. 
	 * @return a list of students
	 */
	public static List<Student> showAll() {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
			return mStudentDB.getStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}