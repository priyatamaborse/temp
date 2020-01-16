package June19.Spring_15july;

import java.beans.PropertyEditorSupport;

public class StudentIdEditor extends PropertyEditorSupport {

	
	public void setAsText(String text) throws IllegalArgumentException {
	
			String s1 = text.substring(0, 3);
			String s2 = text.substring(4);
		
			StudentID studentID = new StudentID(s1, Integer.parseInt(s2));
			this.setValue(studentID);
		


	}


}
