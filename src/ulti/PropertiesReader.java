package ulti;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesReader {
	ResourceBundle rs;
	Locale loca = null;
	public PropertiesReader() {
		
	}
	
	public void setlocale(Locale loca) {
		this.loca = loca;
		if(loca != null)
			rs = ResourceBundle.getBundle("title", loca);
		else
			rs = ResourceBundle.getBundle("title");
	}
	
	public String getString(String key) {
		String value = rs.getString(key);
		return value;
	}
	
	public static void main(String[] args) {
		PropertiesReader pr = new PropertiesReader();
		pr.setlocale(null);
		System.out.println(pr.getString("index.home"));
		
		pr.setlocale(new Locale("vi", "VN"));
		System.out.println(pr.getString("index.home"));
	}
}
