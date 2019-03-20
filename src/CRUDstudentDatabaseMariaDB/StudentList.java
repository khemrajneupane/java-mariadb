package CRUDstudentDatabaseMariaDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CRUDstudentDatabaseMariaDB.Student;
import CRUDstudentDatabaseMariaDB.StudentDAO;
/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/studentList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> studentList = null;
		
		

		try {
			System.out.println("=== LISTING ALL Students ===");
			
			// 1. Create a DAO object for accessing the data
			StudentDAO studentDAO = new StudentDAO();
			
			studentList = studentDAO.getAllStudents();
			

			}
		
		 catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println("=== System error message (for the developer's eyes only) === \n" + ex.getMessage());
		}

		request.setAttribute("studentList", studentList);
		

		// 4. Forward the request back to the JSP page
		request.getRequestDispatcher("studentList.jsp").forward(request, response);
	}

}
