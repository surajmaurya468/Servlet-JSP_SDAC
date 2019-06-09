

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter=response.getWriter();
		printWriter.println("hieee I m running Servlet in my pC....yeah.....");
		
		String a=request.getParameter("name");
		String b=request.getParameter("pass");
		printWriter.println("user name is :"+a+"     "+"User password is :"+b);
		
		
		if(b.equals("shraddha"))
		{
			printWriter.println("password is correct so i m forwarding your request  by usin.....");	
			response.sendRedirect("index.jsp");
			
		}
		else{
			
			printWriter.println("Example to understand Requset Dispatche's forward and include methods");

			printWriter.println("password is incorrect.....");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);

			
			
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
