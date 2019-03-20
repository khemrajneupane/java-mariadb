package CRUDstudentDatabaseMariaDB;

import java.util.ArrayList;

public class StudentListProgram {

	public static void main(String[] args) {
		try {
			System.out.println("=== LISTING ALL Students ===");
			
			// 1. Create a DAO object for accessing the data
			StudentDAO studentDAO = new StudentDAO();
			
			// 2. Get a list of all movies
			ArrayList<Student> studentlist = studentDAO.getAllStudents();
			
			for (Student student : studentlist) {
				System.out.println(student.getId() + " " + student.getFirstName() + " " + student.getLastName() +" "+student.getStreetAddress()+" "+student.getPostOffice()+" "+student.getPostOffice());		
			}	
			
		
		} catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println("=== System error message (for the developer's eyes only) === \n" + ex.getMessage());
		}

	}

}
