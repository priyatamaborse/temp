package June19.Spring_15july;

public class EmployeeDTO {

	Integer empId;
	String ename;
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(Integer empId, String ename) {
		
		super();
		this.empId = empId;
		this.ename = ename;
	}
	public Integer getEmpId() {
		
		return empId;
	}
	public void setEmpId(Integer empId) {
		
		this.empId = empId;
	}
	public String getEname() {
		
		return ename;
	}
	public void setEname(String ename) {
		
		this.ename = ename;
	}
	
	
	
}
