package CRUDstudentDatabaseMariaDB;


import java.util.Scanner;

import CRUDstudentDatabaseMariaDB.StudentDAO;

public class DeletebyIdofStudent {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter id to delete");
		int id = input.nextInt();
		input.close();
		try {
			
		StudentDAO sdo = new StudentDAO();
		sdo.deleteStudentByID(id);
		System.out.println("Deleted Successfully: "+ id);
		
		} catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println(ex.getMessage());
		}
	
}
}