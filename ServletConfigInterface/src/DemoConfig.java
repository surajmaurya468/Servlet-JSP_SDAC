

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoContext
 */
public class DemoConfig extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter printWriter=response.getWriter();

		ServletConfig config=getServletConfig();//showing that getServletConfig() is nnot a method .
		String driver1=config.getInitParameter("JDBC");
		String driver2=config.getInitParameter("SQL");

		
		printWriter.print("After Feching details from web.xml page we Get ");
		printWriter.print(driver1+"    "+driver2);
		
		
	}

}
