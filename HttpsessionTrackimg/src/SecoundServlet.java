

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecoundServlet")
public class SecoundServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter writer=response.getWriter();
		HttpSession session=request.getSession(false);
		String d=(String)session.getAttribute("Suraj");
		writer.print("Welcome "+d);
		
	
	
	}

}
