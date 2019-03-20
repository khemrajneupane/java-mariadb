package CRUDstudentDatabaseMariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class SimpleStudentInsertProgram {

	public static void main(String[] args) {
		String username = ConnectionParameters.username;			 
		String password = ConnectionParameters.password;
		String databaseURL = ConnectionParameters.databaseURL;
		Connection dbConnection = null;	
 
	
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter student data");
		System.out.print("Id: ");
		int id = input.nextInt();
		System.out.print("First name: ");
		String firstName = input.next();
		System.out.print("Last name: ");
		String lastName = input.next();
		System.out.print("Street: ");
		String streetAddress = input.next();
		System.out.print("Postcode: ");
		String postCode = input1.next();
		System.out.print("Post office: ");
		String postOffice = input1.next();
		

		
				
		try {
			dbConnection = DriverManager.getConnection(databaseURL, username, password);
							
			String sqlText = "INSERT INTO Student (id, firstName, lastName, streetAddress, postCode, postOffice) VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setString(4, streetAddress);
			preparedStatement.setString(5, postCode);
			preparedStatement.setString(6, postOffice);
			
			preparedStatement.executeUpdate();

			System.out.println("The student is succesfully inserted.");
			
		} catch (SQLException sqle) {
			
			// First, check if the problem is primary key violation (the error code is vendor-dependent)
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("Cannot insert the student. " +
			        "The student id (" + id + ") is already in use.");
			} else {
				System.out.println("===== Database error =====\n" + sqle.getMessage());
			}
			
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException sqle) {
					System.out.println("\nClose connection failed. \n" + sqle.getMessage());
				}
			}
		}
		//input.close();
		//input1.close();

	}

}
