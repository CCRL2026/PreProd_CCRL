package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestPages.BaseClass;
import TestPages.LoginPages;

public class Pledge_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
			+ System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("Pledge_Creation Report");

	// @Test
	void Pledge_Creation() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledge_Creation start");
			LoginPages Login = new LoginPages(driver, Wait);
			// Login.PortalLogin("RP-KML", "user_A", "121@test");
			 Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			// Login.PortalLogin("wsp9999996", "user71", "121@test");
			//Login.PortalLogin("RP-KUNVARJI", "PreProd_Abhi", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledge_Creation creation  start");
			TestPages.Pledge_Creation Pledge = new TestPages.Pledge_Creation(driver, Wait);
			Pledge.Pledge_Creation_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation Authorized Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation Authorized END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Pledge_Creation Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Pledge_Creation_Request_Authorized() throws IOException {
		try {
			test.log(LogStatus.INFO, "Logion for Pledge_Creation Authorized start");
			LoginPages Login = new LoginPages(driver, Wait);
			// Login.PortalLogin("RP-KML", "user_B", "121@test");
			// Login.PortalLogin("wsp9999996", "user72", "121@test");
			 Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			//Login.PortalLogin("RP-KUNVARJI", "PRAKASH", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledge_Creation Authorized start");
			TestPages.Pledge_Creation_Request_Authorized Exch = new TestPages.Pledge_Creation_Request_Authorized(driver,
					Wait);
			Exch.Pledge_Creation_Authorized();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation Authorized is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation Authorized start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation Authorized END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation Authorized Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// Data Base Connection Required
	// @Test
	void Pledge_Creation_WareHouse() throws IOException {
		try {
			// Data Base Connection Requred
			test.log(LogStatus.INFO, "Logion for Pledge_Creation WareHouse start");
			LoginPages Login = new LoginPages(driver, Wait);
			// Login.PortalLogin("wsp9996059", "user101", "121@test");
			Login.PortalLogin("wsp9999996", "user71", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledge_Creation WareHouse start");
			TestPages.Pledge_Creation_WareHouse Exch = new TestPages.Pledge_Creation_WareHouse(driver, Wait);
			Exch.Pledge_Creation_WareHouse_Approval();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation WareHouse is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation WareHouse start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation WareHouse END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation_WareHouse Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Pledge_Creation_WareHouse_Authorized() throws IOException {
		try {
			test.log(LogStatus.INFO, "Logion for Pledge_Creation WareHouse Authorized start");
			LoginPages Login = new LoginPages(driver, Wait);
			// Login.PortalLogin("wsp9996059", "user102", "121@test");
			Login.PortalLogin("wsp9999996", "user72", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledge_Creation WareHouse Authorized start");
			TestPages.Pledge_Creation_Request_Authorized Exch = new TestPages.Pledge_Creation_Request_Authorized(driver,
					Wait);
			Exch.Pledge_Creation_WareHouse_Approval();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation WareHouse is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation WareHouse Authorized start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledge_Creation WareHouse Authorized END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation WareHouse Authorized Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void pledgee_Creation() throws IOException {
		try {
			test.log(LogStatus.INFO, "Logion for pledgee_Creation start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-UCOBANK", "panvel1", "121@test");
			// Login.PortalLogin("rp-bhanu", "sarthak", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "pledgee_Creation start");
			TestPages.pledgee_Creation Exch = new TestPages.pledgee_Creation(driver, Wait);
			Exch.Pledge_Creation();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "pledgee_Creation is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for pledgee_Creation start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for pledgee_Creation END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "pledgee_Creation Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	@Test
	void pledgee_Creation_Authorized() throws IOException {
		try {
			test.log(LogStatus.INFO, "Logion for pledgee_Creation_Authorized start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-UCOBANK", "panvel2", "121@test");
			// Login.PortalLogin("rp-bhanu", "sarthakp", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "pledgee_Creation_Authorized start");
			TestPages.Pledge_Creation_Request_Authorized Exch = new TestPages.Pledge_Creation_Request_Authorized(driver,
					Wait);
			Exch.pledgee_Creation_Auth();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "pledgee_Creation_Authorized is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for pledgee_Creation_Authorized start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for pledgee_Creation_Authorized  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "pledgee_Creation_Authorized Test failed");
		}

		Report.endTest(test);
		Report.flush();
	}

}
