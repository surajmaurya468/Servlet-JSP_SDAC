package com.pojo;

public class Book {
	private int isbn;
	private String name,publisher,author;
	public Book() {
		// TODO Auto-generated constructor stub
		isbn=0;
		name=publisher=author=null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return isbn+ "\t" +name+ "\t" +publisher+ "\t" +author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
