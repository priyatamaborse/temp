package June19.July9_1;

public class Address {
	
	
	private Integer pincode;
	
	private String area;

	
	public Address(Integer pincode, String area) {
		
		System.out.println("Address 2 argrs cons");
		
		this.pincode = pincode;
		this.area = area;
	}



	public void showAddress(){
		
		System.out.println("Address.showAddress()");
		
		System.out.println("pincode \t" +pincode);
		
		System.out.println("area \t" +area);
		
		
	}
	
	

}
