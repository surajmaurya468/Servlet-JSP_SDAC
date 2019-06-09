import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import com.bussiness.myfile.impl.MyCompDAOImpl;
import com.compaines.io.MyInput;
import com.companies.Company;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. add company \n2. display all company \n3. update company \n4. find company "
				+ "\n5. delete company \n6. get company by size	\n7. sort company");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i;
		MyCompDAOImpl impl = new MyCompDAOImpl();
		MyInput input = new MyInput();
		Company company = new Company();
		List<Company> list;

		try {
			i = Integer.parseInt(reader.readLine());
			switch (i) {
			case 1: {
				company = input.getCompanyInfo();
				int j = impl.addCompany(company);
				if (j == 1) {
					System.out.println("inserted");
				} else
					System.out.println("not inserted");
				break;
			}
			case 2: {
				list = impl.getAllCompanies();
				for (Company c : list) {
					input.printCompanyInfo(c);
				}
				break;
			}
			case 3: {
				System.out.println("Enter Company ID and Total Employee");

				Boolean b = impl.updateCompany(Integer.parseInt(reader.readLine()),
						Integer.parseInt(reader.readLine()));
				if (b) {
					System.out.println("updated");
				} else
					System.out.println("not updated");
				break;
			}
			case 4: {
				System.out.println("Enter Company ID");
				company = impl.getCompany(Integer.parseInt(reader.readLine()));

				input.printCompanyInfo(company);
				break;
			}
			case 5: {
				System.out.println("Enter Company ID");
				Boolean val = impl.deleteCompany(Integer.parseInt(reader.readLine()));
				if (val=true) {
					System.out.println("deleted successfully");
				} else
					System.out.println("not deleted");
				break;
			}
			case 6: {
				System.out.println("Enter Number of Employee to be find");
				list = impl.getCompaiesBySize(Integer.parseInt(reader.readLine()));
				for (Company c : list) {
					input.printCompanyInfo(c);
				}
				break;
			}
			case 7: {
				System.out.println("Enter criteria i.e Column name");
				list = impl.sortCompany(reader.readLine());
				for (Company c : list) {
					input.printCompanyInfo(c);
				}
				break;
			}
			default: {
				System.out.println("Enter proper value");
			}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
