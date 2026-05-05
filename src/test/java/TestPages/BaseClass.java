package TestPages;

import java.time.Duration;

//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import Config.PropertiesFile;
import Utillity.BrowserFactory;

public class BaseClass {
	public WebDriver driver = null;

	public PropertiesFile Conf = new PropertiesFile();
	Duration timeout = Duration.ofSeconds(30);
	public WebDriverWait Wait = new WebDriverWait(driver, timeout);

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.initializeDriver(driver, Conf.getBrowser(), Conf.getURL());
	}
}
