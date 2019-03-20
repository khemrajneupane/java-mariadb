package CRUDstudentDatabaseMariaDB;

public class StudentInsertProgram {

	public static void main(String[] args) {
		try {
			System.out.println("===  Inserting a student row by student id (DAO version) ===");

			// 1. Create a DAO object for accessing the data
			StudentDAO studentDAO = new StudentDAO();

			studentDAO.insertStudent(new Student());

		} catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println("=== System error message (for the developer's eyes only) === \n" + ex.getMessage());
		}

	}

}
