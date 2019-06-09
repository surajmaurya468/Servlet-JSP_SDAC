package com;
import java.sql.*;
public class Model {
	private String pname;
	private int price;
	String c;
	int d;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void connectivityDb() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aahana", "root", "suraj");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select *from student");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "   " + rs.getString(3));
		}
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, 1000);
		ps.setString(2, "hsgdu");
		ps.setString(3, "Banglore");
		int a = ps.executeUpdate();
		System.out.println(a + " rows affected");

	}
}


/*

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aahana", "root", "suraj");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select *from student");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "   " + rs.getString(3));
		}
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, 1000);
		ps.setString(2, "shreya");
		ps.setString(3, "Anuska");
		int a = ps.executeUpdate();
		System.out.println(a + " rows affected");



*/