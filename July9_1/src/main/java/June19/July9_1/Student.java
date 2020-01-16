package June19.July9_1;

public class Student {
	
	private Integer studentId;
	
	private String studentName;

	public Student() {
		System.out.println("Student DC");
	}

	public void setStudentId(Integer studentId) {
		System.out.println("Student.setStudentId()");
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		System.out.println("Student.setStudentName()");
		this.studentName = studentName;
	}
	
	public void showStudent(){
		
		System.out.println("Student.showStudent()");
		
		System.out.println("studentId \t" +studentId);
		
		System.out.println("studentName \t" +studentName);
	}
	
	
}

