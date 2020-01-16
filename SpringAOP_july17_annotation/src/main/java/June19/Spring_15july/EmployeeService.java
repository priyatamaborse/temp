package June19.Spring_15july;

import java.util.List;

public interface EmployeeService {

	public EmployeeDTO getEmployeeById(Integer employeeId);
	 
    public List<EmployeeDTO> getAllEmployee();
 
	public void createEmployee(EmployeeDTO employee);
	 
    public void deleteEmployee(Integer employeeId);
 
    public void updateEmployee(EmployeeDTO employee);
	
}
