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
 * Servlet implementation class AddServlet
 */
@WebServlet("/addBook")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("link.html");
		dispatcher.include(request, response);
		writer.println("<hr>");
		writer.println("<br>");
		writer.println("<br>");
		String isn=request.getParameter("isbn");
		int isbn=Integer.parseInt(isn);
		String bname=request.getParameter("bname");
		String publisher=request.getParameter("publisher");
		String author=request.getParameter("author");
	
		//PersonDAO  dao =new PersonDAOImpl();
		BookDAO dao = new BookDAOImpl();
		Book book = new Book();
		//Person person =new Person();
		book.setIsbn(isbn);
		book.setName(bname);
		book.setPublisher(publisher);
		book.setAuthor(author);
		
		int r =dao.addBook(book);
		writer.println("<html>");
		writer.println("<body>");

		if(r > 0)
		{
			writer.println("Record added ");

		}
		else
		{
			writer.println("not added");

		}
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		
	}

}
