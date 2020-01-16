package June19.Spring_15july;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void createEmployee(EmployeeDTO employee) {
		
		System.out.println("EmployeeServiceImpl createEmployee()");
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		
		System.out.println("EmployeeServiceImpl deleteEmployee()");
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		
		System.out.println("EmployeeServiceImpl updateEmployee()");
		
	}

	@Override
	public EmployeeDTO getEmployeeById(Integer employeeId) {
		
		if(true)
		{
			throw new EmployeeNotFoundException();
		}
		return new EmployeeDTO();
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {

		return new ArrayList<EmployeeDTO>();
	}

}
