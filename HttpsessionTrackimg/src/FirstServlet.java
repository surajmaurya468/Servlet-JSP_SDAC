

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter writer=response.getWriter();
	String n=request.getParameter("uname");
	writer.print("Welcome "+n);
	
	
	//now creating httpsession And assigning value to session
	HttpSession session=request.getSession();
	session.setAttribute("Suraj", "Shraddha");
	
	writer.print("<form method='post' action='SecoundServlet'>");
	writer.print("<input type='submit'>");

writer.close();	
	
	}

}
