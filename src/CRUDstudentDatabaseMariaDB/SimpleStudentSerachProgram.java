package CRUDstudentDatabaseMariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class SimpleStudentSerachProgram {

	public static void main(String[] args) {
		String username = ConnectionParameters.username;			 
		String password = ConnectionParameters.password;
		String databaseURL = ConnectionParameters.databaseURL;
		Connection dbConnection = null;	

		// This variable contains the year that will be used in the SQL query's search condition.
		Scanner input = new Scanner(System.in);
	
		System.out.print("Enter student id: ");
		int id = input.nextInt();
		
		
		
						
		try {
			// 1. Open a database connection 
	        //    MariaDB in HH: This does not work, if you have not opened an SSH tunnel to the server.
			dbConnection = DriverManager.getConnection(databaseURL, username, password);

			// 2. Define the SQL query text (NB! Exclamation mark is used as a place-holder for a parameter value)
			String sqlText = "SELECT id,firstName,lastName, streetAddress, postCode, postOffice FROM Student WHERE id = ?";

			// 3. Create a prepared statement based on the SQL query text
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			
			// 4. Set the query parameter value(s) based on the place-holder number(s)
			preparedStatement.setInt(1, id);
			
			// 5. Execute the SQL query with the statement object
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// 6. Iterate through the result set 
			//    NB! resultSet.next() moves the cursor to the next available row in the result set
			//        It returns false if there are no more rows.
			boolean rowFound = false;
			
			while (resultSet.next()) {
				rowFound = true;
				
				// 7. Each column value has to be retrieved separately as below
				int num = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String streetAddress = resultSet.getString("streetAddress");
				int postCode = resultSet.getInt("postCode");
				String postOffice = resultSet.getString("postOffice");

				System.out.println(num + ", " + firstName +" "+  lastName+", "+streetAddress +", "+ postCode+" "+postOffice );
			}

			if (rowFound == false) {
				System.out.println("Unknown student id " + "("+id+")");
			}
			
		} catch (SQLException sqle) {
			// If any JDBC operation fails, we display an error message here
			System.out.println("===== Database error =====\n" + sqle.getMessage());
			
		} finally {
			// 8. The database connection should be closed as soon as we don't need it anymore
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException sqle) {
					System.out.println("\nClose connection failed. \n" + sqle.getMessage());
				}
			}
		}
			input.close();
	}

}
