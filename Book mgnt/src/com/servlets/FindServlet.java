package com.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FindServlet
 */
@WebServlet("/findBook")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String is = request.getParameter("isbn");
		int isbn = Integer.parseInt(is);
		
		BookDAO dao = new BookDAOImpl();
		Book book = new Book();
	
		book.setIsbn(isbn);
		
		List<Book> foundlist = dao.findbook(book);
		
		request.setAttribute("f", foundlist);
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("foundBook.jsp");
		dispatcher.forward(request, response);

	}

}
