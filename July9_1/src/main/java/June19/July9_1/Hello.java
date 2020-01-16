package June19.July9_1;

public class Hello {
	
	
	private Address address;
	private Student student;

	public void setStudent(Student student) {
		System.out.println("Hello.setStudent()");
		this.student = student;
	}

	public Hello(Address address) {
		System.out.println("Hello. address CI");
		this.address = address;
	}
	
	
	public void showHello(){
		
		System.out.println("Hello.showHello()");
		
		student.showStudent();
		address.showAddress();
	}
	

}
