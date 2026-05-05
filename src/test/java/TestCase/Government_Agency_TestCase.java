package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import TestPages.BaseClass;
import TestPages.DashBoard_WareHouse_Checker;
import TestPages.Government_Agency_Deposite_Request_Maker;
import TestPages.LoginPages;
import TestPages.Physical_Deposit_Maker;
import TestPages.RP_Deposite_Request_Checker;
import TestPages.ScreenShort;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Government_Agency_TestCase extends BaseClass {
	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("ENWR_Generation for Government_Agency");

//@Test
	void Government_Agency_Deposite_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Government_Agency_Deposite_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			//Login.PortalLogin("RP-XYZ", "user119", "121@test");
			//Login.PortalLogin("RP-COUNTRYWIDE", "Bhanu1", "121@test");
			//Login.PortalLogin("RP-KML", "USER_A", "121@test");
			Government_Agency_Deposite_Request_Maker Depo = new Government_Agency_Deposite_Request_Maker(driver, Wait);
			Depo.Government_Agency_Deposite();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Government_Agency_Deposite_Request_Maker is success full");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Government_Agency_Deposite_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	//@Test
	void RP_Deposite_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Government_Agency_Deposite_Request_Checker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("RP-COUNTRYWIDE", "Bhanu2", "121@test");
			Login.PortalLogin("RP-Abhishek", "user52", "121@test");
			//Login.PortalLogin("RP-KML", "USER_B", "121@test");
			RP_Deposite_Request_Checker Dash = new RP_Deposite_Request_Checker(driver, Wait);
			Dash.Government_Agency_Deposite_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+ "Government_Agency_Deposite_Request_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Government_Agency_Deposite_Request_Checker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

//@Test
	void DashBord_WareHouse_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Government_Agency_WareHouse_Maker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9996059", "user102", "121@test");
			//Login.PortalLogin("WSP9999996", "Swarupv", "121@test");
			//Login.PortalLogin("wsp9997115", "bhanu", "test@123");
			Login.PortalLogin("WSP9999996", "user71", "121@test");
			Physical_Deposit_Maker WSP = new Physical_Deposit_Maker(driver, Wait);
			WSP.Government_Agency_Deposite_Transaction();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+ "Government_Agency_WareHouse_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + " Government_Agency_WareHouse_Maker Test failed: " + e.getMessage());
		}
			Report.endTest(test);
			Report.flush();
		
	}
	@Test
	void DashBoard_WareHouse_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Government_Agency_WareHouse_Checker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			 //Login.PortalLogin("wsp9999996", "user72", "121@test");
			//Login.PortalLogin("wsp9996059", "user101", "121@test");
			//Login.PortalLogin("wsp9997115", "pratap", "121@test");
			Login.PortalLogin("WSP9999996", "user72", "121@test");
			DashBoard_WareHouse_Checker WSP_CH = new DashBoard_WareHouse_Checker(driver, Wait);
			WSP_CH.Government_Agency_Deposite_Transaction_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+"Government_Agency_WareHouse_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + " Government_Agency_WareHouse_Checker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
	// @AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
