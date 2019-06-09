package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class pojo {
	private String uname;
	private int pass;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public void connect()throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","suraj");
	PreparedStatement ps=con.prepareStatement("insert into suraj values(?,?)");
	ps.setString(1, "Suraj");
	ps.setInt(2, 10000);
	int i=ps.executeUpdate();
	
	System.out.println(i+ " Your data is successfully uploaded.....");
	}
}
