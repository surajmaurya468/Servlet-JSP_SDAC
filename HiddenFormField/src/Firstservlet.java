

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet1")
public class Firstservlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer =response.getWriter();
		String n=request.getParameter("uname");
		writer.print("Welcome "+n);
		writer.print("<form method='post' action='SecoundServlet'>");
		writer.print("<input type='hidden' value='Passing Value Through Hidden Form Field' name='hidden'>");
		writer.print("<input type='submit'");
		writer.print("</form>");
		writer.close();

		
		
		
	
	}

}
