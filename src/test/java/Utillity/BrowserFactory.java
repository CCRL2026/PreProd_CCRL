package Utillity;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver initializeDriver(WebDriver driver, String browser, String URL) {

		 String projectPath = System.getProperty("user.dir");
		
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					projectPath+"\\Driver\\chromedriver.exe");

			 ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

			driver = new ChromeDriver(options);

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					projectPath+"\\Driver\\geckodriver.exe"); // Set
																															// path
																															// to
																															// geckodriver
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Users\\eclipse\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

			driver = new FirefoxDriver(options);

		} else {
			System.out.println("No valid browser provided: " + browser);

		}
		if (driver != null) {
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else {
			throw new RuntimeException("WebDriver initialization failed for browser: " + browser);
		}
		return driver;
	}

}
