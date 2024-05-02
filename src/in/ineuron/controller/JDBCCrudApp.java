package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefectory.StudentServiceFectory;

@WebServlet("/controller/*")
public class JDBCCrudApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IStudentService stdService=StudentServiceFectory.getStudentService();
		
		System.out.println("Request URL:: "+request.getRequestURI());
		System.out.println("Path Info :: "+request.getPathInfo());
		
		if(request.getRequestURI().endsWith("addform"))
				{
					String id=request.getParameter("sid");
					String name=request.getParameter("sname");
					String age=request.getParameter("sage");
					
					Student s=new Student();
					s.setId(Integer.parseInt(id));
					s.setName(name);
					s.setAge(Integer.parseInt(age));
					
					
					String status=stdService.addStudent(s);
					PrintWriter out = response.getWriter();

					if (status.equals("success")) {
						out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
					} else {
						out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
					}
					out.close();
					
				}
	}

}
