package com.companies;

public class Company{
	
	private String company_name;
	private int company_id;
	private int num_of_employee;
	
	public int getNum_of_employee() {
		return num_of_employee;
	}

	public void setNum_of_employee(int num_of_employee) {
		this.num_of_employee = num_of_employee;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}


	Address company_address;
	
	public Address getCompany_address() {
		return company_address;
	}

	public void setCompany_address(Address company_address) {
		this.company_address = company_address;
	}

	public Company() {
		// TODO Auto-generated constructor stub
		int id=0;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Company Name"+getCompany_name()+"Company ID"+getCompany_id()+"Toatal Emp"+getNum_of_employee();
	}

}
