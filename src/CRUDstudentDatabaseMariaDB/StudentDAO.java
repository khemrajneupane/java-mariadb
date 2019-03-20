package CRUDstudentDatabaseMariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
	private final String username;
	private final String password;
	private final String databaseURL;

	public StudentDAO() throws Exception {
		username = ConnectionParameters.username;
		password = ConnectionParameters.password;
		databaseURL = ConnectionParameters.databaseURL;
		
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private Connection openConnection() throws SQLException {
		Connection dbConnection = DriverManager.getConnection(databaseURL, username, password);
		return dbConnection;
	}

	private void closeConnection(Connection dbConnection) throws SQLException {
		if (dbConnection != null) {
			dbConnection.close();
		}
	}

	public ArrayList<Student> getAllStudents() throws SQLException {
		ArrayList<Student> studentlist = new ArrayList<Student>();
		Connection dbConnection = null;

		try {
			dbConnection = openConnection();

			String sqlText = "SELECT id, firstName, lastName, streetAddress, postCode, postOffice FROM Student";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);

			ResultSet resultSet = preparedStatement.executeQuery();
			boolean rowFound = false;
			int id = -1;
			while (resultSet.next()) {
				rowFound = true;
				id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String streetAddress = resultSet.getString("streetAddress");
				String postCode = resultSet.getString("postCode");
				String postOffice = resultSet.getString("postOffice");

				studentlist.add(new Student(id, firstName, lastName, streetAddress, postCode, postOffice));
			}
			if (rowFound == false) {
				System.out.println("Unknown student id " + "(" + id + ")");
			}
			return studentlist;

		} catch (SQLException sqle) {
			throw sqle;

		} finally {
			closeConnection(dbConnection);
		}
	}

	// Method getStudentById
	public Student getStudentByID(int id) throws SQLException {
		Connection dbConnection = null;
		Student studentList = null;

		try {
			dbConnection = openConnection();

			String sqlText = "SELECT id, firstName, lastName, streetAddress, postCode, postOffice FROM Student WHERE id = ?";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			
			boolean foundRow = false;
			while (resultSet.next()) {
				foundRow = true;
				int idNum = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String streetAddress = resultSet.getString("streetAddress");
				String postCode = resultSet.getString("postCode");
				String postOffice = resultSet.getString("postOffice");

				studentList = new Student(idNum, firstName, lastName, streetAddress, postCode, postOffice);

			}
			if (foundRow == false) {

				System.out.println("Unknown student id " + "(" + id + ")");

			}

			return studentList;

		} catch (SQLException sqle) {
			throw sqle;

		} finally {
			closeConnection(dbConnection);
		}

	}

	// Insert method
	public Student insertStudent(Student student) {

		String username = ConnectionParameters.username;
		String password = ConnectionParameters.password;
		String databaseURL = ConnectionParameters.databaseURL;
		Connection dbConnection = null;
		

		try {
			dbConnection = DriverManager.getConnection(databaseURL, username, password);

			String sqlText = "INSERT INTO Student (id, firstName, lastName, streetAddress, postCode, postOffice) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setString(4, student.getStreetAddress());
			preparedStatement.setString(5, student.getPostCode());
			preparedStatement.setString(6, student.getPostOffice());

			preparedStatement.executeUpdate();

			System.out.println("The student is succesfully inserted.");

		} catch (SQLException sqle) {

			//checking, if the problem is primary key violation 
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("Cannot insert the student. " + "The student id (" + student.getId() + ") is already in use.");
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
		return student;
	}
	
	// Method delete student by id
	public void deleteStudentByID(int id) throws SQLException {
		Connection dbConnection = null;
	//Student student = new Student();
	//id = student.getId();
	
		try {
			
			dbConnection = openConnection();
			Student studentWithId = new Student();
			studentWithId = getStudentByID(id);
			int checkedId=studentWithId.getId();
			
			if(checkedId>0) {
				String sqlText = "DELETE FROM Student WHERE id = ?";
				PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				System.out.println("The student is succesfully deleted.");
				getAllStudents();
				}

			}
			

		 catch (SQLException sqle) {
				if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
					System.out.println("Cannot delete the student. " + "The student id (" + id + ") .");
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
		
	}
	

}
