package com.studentproject.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentproject.bean.StudentBean;
import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;

@WebServlet("/StudentDetailsrv")
public class StudentDetailsrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentDetailsrv() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String sroll=request.getParameter("roll");
		
		int roll=Integer.parseInt(sroll.trim());
		
		
		StudentDao dao=new StudentDaoImpl();
		
		StudentBean sbean=dao.getStudentDetails(roll);
		
		if(sbean != null){
			
			pw.print("<body bgcolor='yellow'>");
			
			pw.print("<h2>Roll is :"+sbean.getRoll()+"</h2>");
			pw.print("<h2>Name is :"+sbean.getName()+"</h2>");
			pw.print("<h2>Marks is :"+sbean.getMarks()+"</h2>");
			
			
			pw.print("</body>");
			
		}
		else
			pw.print("<h1>Record Does not exist <a href='index.html'>TryAgain</a></h1>");
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
