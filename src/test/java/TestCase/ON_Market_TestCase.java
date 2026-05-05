package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.LoginPages;

public class ON_Market_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
			+ System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("ON Market Report");

	// @Test
	void Settlement_Master_CC_Login() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Settlement_Master start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("cc8880013", "user7", "121@test");
			Login.PortalLogin("CC8880002", "admin", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Settlement_Master creation  start");
			TestPages.Settlement_Master_CC_Login Pledge = new TestPages.Settlement_Master_CC_Login(driver, Wait);
			Pledge.Settlement_Master();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Settlement_Master is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation Authorized Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Settlement_Master Authorized END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Settlement_Master Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	//@Test
	void Settlement_Master_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Settlement_Master_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("cc8880013", "user2", "121@test");
			Login.PortalLogin("CC8880002", "Abhishek", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Settlement_Master_Checker creation  start");
			TestPages.ON_Market_Checker Pledge = new TestPages.ON_Market_Checker(driver, Wait);
			Pledge.Settlement_Master_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Settlement_Master_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Settlement_Master_Checker Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Settlement_Master_Checker Authorized END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Settlement_Master_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	@Test
	void On_Market_RP_Login() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for On_Market Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			 Login.PortalLogin("RP-KUNVARJI", "PRAKASH", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "On_Market Maker creation  start");
			TestPages.On_Market_RP_Login Market = new TestPages.On_Market_RP_Login(driver, Wait);
			try {
			Market.On_Market();
			}catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Error occurred while running On_Market: " + e.getMessage());
			}
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ " On_Market Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for On_Market Maker Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for On_Market Maker END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "On_Market Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void ON_Market_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for ON_Market_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "ON_Market_Checker creation  start");
			TestPages.ON_Market_Checker Market = new TestPages.ON_Market_Checker(driver, Wait);
			Market.On_Market_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "ON_Market_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for ON_Market_Checker Authorized Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for ON_Market_Checker Authorized END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "ON_Market_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
}
