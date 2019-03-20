package CRUDstudentDatabaseMariaDB;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addStudentList")
public class AddStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		String id,firstName, lastName, streetAddress, postCode, postOffice;
		id = request.getParameter("id");
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		streetAddress = request.getParameter("streetAddress");
		postCode = request.getParameter("postCode");
		postOffice = request.getParameter("postOffice");
		if(id.isEmpty()||firstName.isEmpty()
				||lastName.isEmpty()
				||streetAddress.isEmpty() || postCode.isEmpty()
				|| postOffice.isEmpty()) {
			request.setAttribute("studentList", studentList);
			//Forwarding the request back to the JSP page
			request.getRequestDispatcher("addStudentList.jsp").forward(request, response);
			
		}
		
		Student student = new Student(Integer.parseInt(id),firstName,lastName,streetAddress,postCode,postOffice );
		
		try {
			System.out.println("=== LISTING ALL Students ===");
			
			//Creating a DAO object for accessing the data
			StudentDAO studentDAO = new StudentDAO();
			studentList.add(studentDAO.insertStudent(student));
			
	
			}
		
		 catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println(ex.getMessage());
		}
		
		request.setAttribute("studentList", studentList);
		//Forwarding the request back to the JSP page
		request.getRequestDispatcher("studentList.jsp").forward(request, response);
		
		}
		
	}


