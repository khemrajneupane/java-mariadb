package CRUDstudentDatabaseMariaDB;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudentById
 */
@WebServlet("/deleteStudentById")
public class DeleteStudentById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String id = request.getParameter("id");
		 Student studentList = new Student();
		 int noId = 0;
	
		try {
			
			StudentDAO dao = new StudentDAO();
			studentList = dao.getStudentByID(Integer.parseInt(id));
			if(studentList != null) {
				dao.deleteStudentByID(Integer.parseInt(id));
			}else {
				//System.out.print(id+ "Id not found in the BD");
				noId = Integer.parseInt(id);
			}
			
		} catch (Exception ex) {
			//System.out.println("The database is temporarily unavailable. Please try again later. \n");
			//System.out.println(ex.getMessage());
		}
		request.setAttribute("noId", noId);
		request.setAttribute("studentList", studentList);
		//Forwarding the request back to the JSP page
		request.getRequestDispatcher("deleteStudentById.jsp").forward(request, response);
	}

}
