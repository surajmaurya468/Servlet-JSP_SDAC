package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Book;


public class BookDAOImpl implements BookDAO {

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int rec = 0;
		try {
			Connection connection = getConnection();
			String SQL = "insert into Book values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setInt(1, book.getIsbn());
			statement.setString(2, book.getName());
			statement.setString(3, book.getPublisher());
			statement.setString(4, book.getAuthor());
			rec = statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rec;
	}
	

	public static Connection getConnection()
	{
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
			System.out.println("got connection");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
		
	}


	@Override
	public List<Book> displyaAllbooks() {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		
		String SQL="select * from Book";
		try {
			Statement statement = getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(SQL);
			
			while(resultSet.next())
			{
				int isbn=resultSet.getInt(1);
				String bname=resultSet.getString(2);
				String publisher=resultSet.getString(3);
				String author=resultSet.getString(4);
				
				//Person person =new Person();
				Book book = new Book();
				book.setIsbn(isbn);
				book.setName(bname);
				book.setPublisher(publisher);
				book.setAuthor(author);
				
				list.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<Book> findbook(Book book) {
		// TODO Auto-generated method stub
		//Book book = new Book();
		List<Book> foundlist = new ArrayList<Book>();
		Connection connection = getConnection();
		String SQL="select * from Book where isbn = ?";
		try {
			System.out.println("in find book");
//			Statement statement = getConnection().createStatement();
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setInt(1, book.getIsbn());
			System.out.println(book.getIsbn());
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				int isbn=resultSet.getInt(1);
				String bname=resultSet.getString(2);
				String publisher=resultSet.getString(3);
				String author=resultSet.getString(4);
				
				//Person person =new Person();
				Book book1 = new Book();
				book1.setIsbn(isbn);
				book1.setName(bname);
				book1.setPublisher(publisher);
				book1.setAuthor(author);
				
				foundlist.add(book1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundlist;
	}


	@Override
	public int deleteBook(Book book) {
		// TODO Auto-generated method stub
		int delete = 0;
		try {
			Connection connection = getConnection();
			String SQL = "delete from Book where isbn = ?";
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setInt(1, book.getIsbn());

			delete = statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}


	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		int update = 0;
		try {
			Connection connection = getConnection();
			String SQL = "update Book set name=?, publisher=?, author=? where isbn=?";
			PreparedStatement statement = connection.prepareStatement(SQL);
			statement.setString(1, book.getName());
			statement.setString(2, book.getPublisher());
			statement.setString(3, book.getAuthor());
			statement.setInt(4, book.getIsbn());
			update = statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

}
