package com.yash;

import java.beans.PropertyEditorSupport;

public class StudentIdEditor extends PropertyEditorSupport{

	public void setAsText(String text) {

		String  s1 = text.substring(0,3);
		String  s2 = text.substring(4);

		StudentId student = new StudentId(s1,Integer.parseInt(s2));
		this.setValue(student);
	}
}
