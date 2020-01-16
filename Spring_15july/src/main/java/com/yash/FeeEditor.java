package com.yash;

import java.beans.PropertyEditorSupport;

public class FeeEditor extends PropertyEditorSupport{
	
	public void setAsText(String text) {
		
		String str[] = text.split(",");
		
		Fee fee = new Fee(Double.parseDouble(str[0]),Double.parseDouble(str[1]));
		this.setValue(fee);
	}

}
