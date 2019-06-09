package com.bussiness.myfile.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bussiness.myDAO.MyCompanyDAO;
import com.companies.Address;
import com.companies.Company;

public class MyCompDAOImpl implements MyCompanyDAO {

	
	public int addCompany(Company company) {
		// TODO Auto-generated method stub

		String sql = "insert into nseit values(?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			getMyConnection().setAutoCommit(false);
			ps = getMyConnection().prepareStatement(sql);

			ps.setString(1, company.getCompany_name());
			ps.setInt(2, company.getCompany_id());
			ps.setInt(3, company.getNum_of_employee());
			ps.setString(4, company.getCompany_address().getCity());
			ps.setString(5, company.getCompany_address().getState());
			ps.setInt(6, company.getCompany_address().getPincode());

			int val = ps.executeUpdate();
			getMyConnection().commit();
			if (val > 0) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	public Company getCompany(int id1) {
		// TODO Auto-generated method stub

		PreparedStatement statement;
		Company company = null;
		try {
			String sql = "select * from nseit where c_id=?";
			statement = getMyConnection().prepareStatement(sql);
			statement.setInt(1, id1);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("c_id");
				String name = rs.getString("c_name");
				int totemp = rs.getInt("c_totemp");
				String city = rs.getString("c_city");
				String state = rs.getString("c_state");
				int pincode = rs.getInt("c_pincode");

				company = new Company();
				Address address = new Address();

				company.setCompany_id(id);
				company.setCompany_name(name);
				company.setNum_of_employee(totemp);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				company.setCompany_address(address);
			}
			return company;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
	public List<Company> getCompaiesBySize(int size) {
		// TODO Auto-generated method stub
		List<Company> list = null;
		try {
			String sql = "select * from NSEIT where c_totemp >= ?";
			PreparedStatement statement = getMyConnection().prepareStatement(sql);
			statement.setInt(1, size);
			ResultSet rs = statement.executeQuery();

			list = new ArrayList<Company>();
			while (rs.next()) {
				int id = rs.getInt("c_id");
				String name = rs.getString("c_name");
				int totemp = rs.getInt("c_totemp");
				String city = rs.getString("c_city");
				String state = rs.getString("c_state");
				int pincode = rs.getInt("c_pincode");

				Company company = new Company();
				Address address = new Address();

				company.setCompany_id(id);
				company.setCompany_name(name);
				company.setNum_of_employee(totemp);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				company.setCompany_address(address);
				list.add(company);

			}

			return list;
		} catch (Exception exception) {

		}
		return null;
	}

	@Override
	public boolean deleteCompany(int id) {
		// TODO Auto-generated method stub
		try {
			getMyConnection().setAutoCommit(false);
			String sql = "delete from nseit where c_id= ?";
			PreparedStatement ps = getMyConnection().prepareStatement(sql);
			ps.setInt(1, id);

			boolean val = ps.execute();
			getMyConnection().commit();
			if (val) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		List<Company> list = null;
		try {
			String sql = "select * from nseit";
			Statement statement = getMyConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);

			list = new ArrayList<Company>();
			while (rs.next()) {

				String name = rs.getString("c_name");
				int id = rs.getInt("c_id");
				int totemp = rs.getInt("c_totemp");
				String city = rs.getString("c_city");
				String state = rs.getString("c_state");
				int pincode = rs.getInt("c_pincode");

				Company company = new Company();
				Address address = new Address();

				company.setCompany_name(name);
				company.setCompany_id(id);
				company.setNum_of_employee(totemp);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				company.setCompany_address(address);
				list.add(company);

			}

		} catch (Exception exception) {

		}
		return list;
	}

	
	public boolean updateCompany(int id, int no_of_employee) {
		// TODO Auto-generated method stub

		try {
			getMyConnection().setAutoCommit(false);
			String sql1 = "update nseit set c_totemp= ? where c_id= ?";
			PreparedStatement ps = getMyConnection().prepareStatement(sql1);

			ps.setInt(1, no_of_employee);
			ps.setInt(2, id);

			int val = ps.executeUpdate();

			getMyConnection().commit();

			if (val > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Company> sortCompany(String criteria) {
		// TODO Auto-generated method stub
		List<Company> list = null;
		try {
			String sql = "select * from nseit order by ";
			String sql1=sql.concat(criteria);
			
			PreparedStatement statement = getMyConnection().prepareStatement(sql1);
			//statement.setInt(1, Integer.parseInt(criteria));
			ResultSet rs = statement.executeQuery();

			list = new ArrayList<Company>();

			while (rs.next()) {
				int id = rs.getInt("c_id");
				String name = rs.getString("c_name");
				int totemp = rs.getInt("c_totemp");
				String city = rs.getString("c_city");
				String state = rs.getString("c_state");
				int pincode = rs.getInt("c_pincode");

				Company company = new Company();
				Address address = new Address();

				company.setCompany_id(id);
				company.setCompany_name(name);
				company.setNum_of_employee(totemp);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				company.setCompany_address(address);
				list.add(company);

			}
			return list;
		} catch (Exception exception) {

		}
		return null;
	}

	public Connection getMyConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			// return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

}
