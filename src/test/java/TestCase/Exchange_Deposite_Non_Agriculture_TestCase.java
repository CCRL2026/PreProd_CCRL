package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.DashBoard_WareHouse_Checker;
import TestPages.Deposit_Confirm_WH_Checker;
import TestPages.Deposit_Confirm_WH_Maker;
import TestPages.Deposite_Assayer_Checker;
import TestPages.Deposite_Assayer_Maker;
import TestPages.Exchange_Deposite_Request_Non_Agriculture_Maker;
import TestPages.Exchange_Non_Agri_WareHouse;
import TestPages.LoginPages;
import TestPages.RP_Deposite_Request_Checker;
import TestPages.ScreenShort;

public class Exchange_Deposite_Non_Agriculture_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("ENWR_Generation for Exchange_Non_Agriculture");

	//@Test
	void Exchange_Deposite_Request_Non_Agriculture_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Deposite_Non_Agriculturet_Maker start");
			Exchange_Deposite_Request_Non_Agriculture_Maker Depo = new Exchange_Deposite_Request_Non_Agriculture_Maker(
					driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Depo.Non_Agriculture_Exchange_Deposite_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Exchange_Deposite_Non_Agriculturet_Maker is success full");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Exchange_Deposite_Non_Agriculturet_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void RP_Deposite_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Deposite_Non_Agriculture_Checker is start");
			RP_Deposite_Request_Checker Dash = new RP_Deposite_Request_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			Dash.Exchange_Deposite_Request_Non_Agriculture_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+"Exchange_Deposite_Non_Agriculture_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Exchange_Deposite_Non_Agriculture_Checker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	@Test
	void DashBoard_WareHouse_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Physical_Deposit_Request_Checker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user71", "121@test");
			// Login.PortalLogin("wsp9997115", "pratap", "121@test");
			// Login.PortalLogin("wsp9996059", "user102", "121@test");
			Exchange_Non_Agri_WareHouse WSP_CH = new Exchange_Non_Agri_WareHouse(driver, Wait);
			WSP_CH.Exchange_Non_Agriculture_Physical();
			test.log(LogStatus.PASS,test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Exchange_Non_Agriculture_Physical_Deposit_Request_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Exchange_Non_Agriculture_Physical_Deposit_Request_Checker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void DashBoard_WareHouse_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Physical_Deposit_Request_Checker is start");
			DashBoard_WareHouse_Checker WSP_CH = new DashBoard_WareHouse_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user72", "121@test");
			// Login.PortalLogin("wsp9997115", "pratap", "121@test");
			// Login.PortalLogin("wsp9996059", "user102", "121@test");
			WSP_CH.Exchange_Non_Agriculture_Physical_Deposit_Request_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+"Exchange_Non_Agriculture_Physical_Deposit_Request_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Exchange_Non_Agriculture_Physical_Deposit_Request_Checker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
	// @Test
	void Deposite_Assayer_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Deposite_Assayer_Maker is start");
			Deposite_Assayer_Maker Assayer = new Deposite_Assayer_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("Assayer01", "user1", "121@test");
			Assayer.Exchange_Non_Agriculture_Deposit_Assayer();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+"Exchange_Non_Agriculture_Deposite_Assayer_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Exchange_Non_Agriculture_Deposite_Assayer_Maker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
	// @Test(retryAnalyzer = Utillity.RetryTest.class)
	void Deposite_Assayer_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Deposite_Assayer_Checker is start");
			Deposite_Assayer_Checker Assayer = new Deposite_Assayer_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("Assayer01", "user2", "121@test");
			Assayer.Exchange_Non_Agriculture_Deposit_Assayer();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+"Exchange_Non_Agriculture_Deposite_Assayer_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Exchange_Non_Agriculture_Deposite_Assayer_Checker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Deposit_Confirm_WH_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Deposit_Confirm_WH_Maker is start");
			Deposit_Confirm_WH_Maker Confirn_Maker = new Deposit_Confirm_WH_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			// Login.PortalLogin("wsp9999996", "user71", "Test@123");
			// Login.PortalLogin("wsp9997115", "bhanu", "121@test");
			Login.PortalLogin("wsp9996059", "user102", "121@test");
			Confirn_Maker.Exchange_Non_Agriculture_Deposit_Confirm_WH();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+"Exchange_Non_Agriculture_Deposit_Confirm_WH_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Exchange_Non_Agriculture_Deposit_Confirm_WH_Maker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Deposit_Confirm_WH_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Deposit_Confirm_WH_Checker is start");
			Deposit_Confirm_WH_Checker Confirm = new Deposit_Confirm_WH_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			// Login.PortalLogin("wsp9999996", "user72", "Test@123");
			// Login.PortalLogin("wsp9997115", "pratap", "121@test");
			Login.PortalLogin("wsp9996059", "user101", "121@test");
			Confirm.Exchange_Non_Agriculture_Deposit_Confirm_WH();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+"Exchange_Non_Agriculture_Deposit_Confirm_WH_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + " Exchange_Non_Agriculture_Deposit_Confirm_WH_Checker Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

}
