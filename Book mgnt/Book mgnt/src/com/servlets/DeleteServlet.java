package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.pojo.Book;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteBook")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer =response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("link.html");
		dispatcher.include(request, response);
		writer.println("<hr>");
		writer.println("<br>");
		writer.println("<br>");
		
		
		String is = request.getParameter("isbn");
		int isbn = Integer.parseInt(is);
		
		BookDAO dao = new BookDAOImpl();
		Book book = new Book();
	
		book.setIsbn(isbn);
		
		int r =dao.deleteBook(book);
		writer.println("<html>");
		writer.println("<body>");

		if(r > 0)
		{
			writer.println("Record deleted ");

		}
		else
		{
			writer.println("not deleted");

		}
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

}
