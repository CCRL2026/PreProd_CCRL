package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.Extension_Of_ENWR_Request;
import TestPages.LoginPages;

public class Extension_Of_ENWR_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport_Extension_Of_ENWR_"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Extension_Of_ENWR for General");

	 @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_ENWR_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_ENWR_Request_Maker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test"); // Abhishek
			// Login.PortalLogin("RP-XYZ", "user119", "121@test"); //Adwait
			// Login.PortalLogin("RP-KML", "USER_A", "121@test"); //Akshay

			Extension_Of_ENWR_Request Depo = new Extension_Of_ENWR_Request(driver, Wait);
			Depo.Extension_Of_ENWR_Request_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Maker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_ENWR_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_ENWR_Request_Checker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user52", "121@test"); // Abhishek
			// Login.PortalLogin("RP-XYZ", "user119", "121@test"); //Adwait
			// Login.PortalLogin("RP-KML", "USER_A", "121@test"); //Akshay

			TestPages.Extension_Of_ENWR_Request_Checker Depo = new TestPages.Extension_Of_ENWR_Request_Checker(driver,
					Wait);
			Depo.Extension_Of_ENWR_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Checker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_ENWR_Request_Warehouse_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_ENWR_Request_Warehouse_Maker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user71", "121@test"); // Abhishek
			// Login.PortalLogin("RP-XYZ", "user119", "121@test"); //Adwait
			// Login.PortalLogin("RP-KML", "USER_A", "121@test"); //Akshay

			TestPages.Extension_Of_ENWR_Request_Warehouse Depo = new TestPages.Extension_Of_ENWR_Request_Warehouse(
					driver, Wait);
			Depo.Extension_Of_ENWR_Request_Warehouse_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Warehouse_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Warehouse_Maker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_ENWR_Request_Warehouse_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_ENWR_Request_Warehouse_Checker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user72", "121@test"); // Abhishek
			// Login.PortalLogin("RP-XYZ", "user119", "121@test"); //Adwait
			// Login.PortalLogin("RP-KML", "USER_A", "121@test"); //Akshay
			TestPages.Extension_Of_ENWR_Request_Checker Depo = new TestPages.Extension_Of_ENWR_Request_Checker(driver,
					Wait);
			Depo.Extension_Of_ENWR_Request_Warehouse_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Warehouse_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_ENWR_Request_Warehouse_Checker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_Validity_Assayer_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_Validity_Assayer_Maker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("Asyr-3338084", "user1", "121@test");
			// Login.PortalLogin("Assayer01", "user1", "121@test");
			TestPages.Extension_Of_Validity_Assayer_Maker Depo = new TestPages.Extension_Of_Validity_Assayer_Maker(
					driver, Wait);
			Depo.Extension_Of_Validity_Assayer();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Assayer_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Assayer_Maker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	//@Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_Validity_Assayer_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_Validity_Assayer_Checker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("Asyr-3338084", "user2", "121@test");
			// Login.PortalLogin("Assayer01", "user1", "121@test");
			TestPages.Extension_Of_ENWR_Request_Checker Depo = new TestPages.Extension_Of_ENWR_Request_Checker(driver,
					Wait);
			Depo.Extension_Of_Validity_Assayer();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Assayer_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Assayer_Checker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_Validity_Confirm_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_Validity_Confirm_Maker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user71", "121@test"); // Abhishek

			TestPages.Extension_Of_ENWR_Request_Warehouse Depo = new TestPages.Extension_Of_ENWR_Request_Warehouse(
					driver, Wait);
			Depo.Extension_Of_Validity_Confirm_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Confirm_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Confirm_Maker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Extension_Of_Validity_Confirm_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Extension_Of_Validity_Confirm_Checker is start");

			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user72", "121@test"); // Abhishek

			TestPages.Extension_Of_ENWR_Request_Checker Depo = new TestPages.Extension_Of_ENWR_Request_Checker(driver,
					Wait);
			Depo.Extension_Of_Validity_Confirm_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Confirm_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Extension_Of_Validity_Confirm_Checker is  failed:" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

}
