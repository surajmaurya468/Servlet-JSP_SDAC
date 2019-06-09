package com.compaines.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.companies.Address;
import com.companies.Company;

public class MyInput {

	public Company getCompanyInfo() {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		Company c = null;
		Address a = null;

		try {
			c = new Company();
			a = new Address();
			
			System.out.println("Enter company name,id,no_of_emp");
			c.setCompany_name(buffer.readLine());
			c.setCompany_id(Integer.parseInt(buffer.readLine()));
			c.setNum_of_employee(Integer.parseInt(buffer.readLine()));
			
			System.out.println("Enter company address");
			a.setCity(buffer.readLine());
			a.setState(buffer.readLine());
			a.setPincode(Integer.parseInt(buffer.readLine()));
			
			c.setCompany_address(a);
			
			return c;


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void printCompanyInfo(Company company) {

		
		System.out.print("Name:-"+company.getCompany_name());
		System.out.print("\tID:-"+company.getCompany_id());
		System.out.print("\tTotal Emp:-"+company.getNum_of_employee());
		System.out.print("\tCity:-"+company.getCompany_address().getCity());
		System.out.print("\tState:-"+company.getCompany_address().getState());
		System.out.println("\tPINCODE:-"+company.getCompany_address().getPincode());
	}

}
