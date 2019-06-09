package com.bussiness.myDAO;

import java.util.List;

import com.companies.Company;

public interface MyCompanyDAO {
	int addCompany(Company company);
	Company getCompany(int id);
	List<Company> getCompaiesBySize(int size);
	boolean deleteCompany(int id);
	List<Company> getAllCompanies();
	boolean updateCompany(int id, int no_of_employee);
	List<Company> sortCompany(String criteria); 

}
