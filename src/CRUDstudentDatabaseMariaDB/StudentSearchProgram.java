package CRUDstudentDatabaseMariaDB;

public class StudentSearchProgram {

	public static void main(String[] args) {
		try {
			System.out.println("===  Retrieving a student row by student id (DAO version) ===");
			
			// 1. Create a DAO object for accessing the data
			StudentDAO studentDAO = new StudentDAO();
			
			Student studentId = studentDAO.getStudentByID(4);//Mock up id.
			System.out.print(studentId.getId()+", "+studentId.getFirstName()+" "+ studentId.getLastName()+", "+studentId.getStreetAddress()+", "+studentId.getPostCode()+" "+studentId.getPostOffice());
		
		} catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println("=== System error message (for the developer's eyes only) === \n" + ex.getMessage());
		}

	}

}
