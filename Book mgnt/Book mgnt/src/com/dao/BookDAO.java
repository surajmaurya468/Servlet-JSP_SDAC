package com.dao;

import java.util.List;

import com.pojo.Book;


public interface BookDAO {
	int addBook(Book book);
	List<Book>displyaAllbooks();
	List<Book>findbook(Book book);
	int deleteBook(Book book);
	int updateBook(Book book);
}
