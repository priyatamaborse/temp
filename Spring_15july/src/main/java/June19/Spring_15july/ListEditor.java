package June19.Spring_15july;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;

public class ListEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
	
		String []str=text.split(",");
		List<String> stringList= Arrays.asList(str);
		this.setValue(stringList);
	}

}
