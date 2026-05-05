package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	 Properties Prop;
	 String ProjectPath = System.getProperty("user.dir");

	public PropertiesFile() {

		File src = new File(ProjectPath+"/src/test/java/Config/Configration.Properties");


		try {
			InputStream input = new FileInputStream(src);
			Prop = new Properties();
			Prop.load(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public String getBrowser() {

		return Prop.getProperty("browser");
	}

	public String getURL() {

		return Prop.getProperty("URL");
	}
	/*public int getDeposite_No() {

		return Integer.parseInt(Prop.getProperty("Deposite_No"));



	}*/

}
