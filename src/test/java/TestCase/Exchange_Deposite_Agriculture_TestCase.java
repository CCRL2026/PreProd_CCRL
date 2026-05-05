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
import TestPages.LoginPages;
import TestPages.Physical_Deposit_Maker;
import TestPages.RP_Deposite_Request_Checker;
import TestPages.RP_Exchange_Deposite_Agriculture_Maker;
import TestPages.ScreenShort;

public class Exchange_Deposite_Agriculture_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis()+".html",
			true);
	ExtentTest test = Report.startTest("ENWR_Generation for Exchange_Deposite");

//@Test
	void RP_Exchange_Deposite_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "RP_Exchange_Deposite_Request_Maker start");
			RP_Exchange_Deposite_Agriculture_Maker Exch = new RP_Exchange_Deposite_Agriculture_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-abhishek", "user51", "121@test");
			// Login.PortalLogin("RP-KUNVARJI", "PRAKASH", "121@test");
			 Login.PortalLogin("RP-KUNVARJI", "PreProd_Abhi", "121@test");
		Exch.Exchange_Deposite_Request();
		test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
				+ "RP_Exchange_Deposite_Request_Maker is success full");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
		Log.Logout();
	} catch (Exception e) {
		test.log(LogStatus.FAIL,
				test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Test failed");
	}

		Report.endTest(test);
		Report.flush();
	}
//@Test
	void RP_Deposite_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "RP_Deposite_Request_Checker is start");
			RP_Deposite_Request_Checker Dash = new RP_Deposite_Request_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			// Login.PortalLogin("RP-KUNVARJI", "ANIRUDDH", "121@test");
			 Login.PortalLogin("RP-KUNVARJI", "PRAKASH", "121@test");
		Dash.Exchange_Deposite_Deposite_Request();
		test.log(LogStatus.PASS, "RP_Deposite_Request_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

//@Test
	void DashBord_WareHouse_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "DashBord_WareHouse_Maker is start");
			Physical_Deposit_Maker WSP = new Physical_Deposit_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9997115", "bhanu", "121@test");
			//Login.PortalLogin("wsp9999996", "user71", "121@test");
			Login.PortalLogin("WSP6656413", "admin", "121@test");
			WSP.Exchange_Deposite_Transaction();
			test.log(LogStatus.PASS, "DashBord_WareHouse_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
//@Test
	void DashBoard_WareHouse_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "DashBoard_WareHouse_Checker is start");
			DashBoard_WareHouse_Checker WSP_CH = new DashBoard_WareHouse_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9999996", "user72", "121@test");
			Login.PortalLogin("WSP6656413", "CCRL", "121@test");
			//Login.PortalLogin("wsp9997115", "pratap", "121@test");
			WSP_CH.Exchange_Deposite_Transaction();
			test.log(LogStatus.PASS, "DashBoard_WareHouse_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();

	}
//@Test
	void Deposite_Assayer_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposite_Assayer_Maker is start");
			Deposite_Assayer_Maker Assayer = new Deposite_Assayer_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("Asyr-3338084", "user1", "121@test");
			//Login.PortalLogin("Asyr-2905202", "bhanu1", "121@test");
			Login.PortalLogin("ASYR-7000016", "Arpit1234", "121@test");
			Assayer.Exchange_Deposit_Assayer();
			test.log(LogStatus.PASS, "Deposite_Assayer_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();

	}
//@Test
	void Deposite_Assayer_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposite_Assayer_Checker is start");
			Deposite_Assayer_Checker Assayer = new Deposite_Assayer_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("Asyr-3338084", "user2", "121@test");
			//Login.PortalLogin("Asyr-2905202", "bhanu2", "121@test");
			Login.PortalLogin("ASYR-7000016", "Aditya1234", "121@test");
			Assayer.Exchange_Deposite_Assayer();
			test.log(LogStatus.PASS, "Deposite_Assayer_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();

	}
@Test
	void Deposit_Confirm_WH_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposit_Confirm_WH_Maker is start");
			Deposit_Confirm_WH_Maker Confirn_Maker = new Deposit_Confirm_WH_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9999996", "user71", "121@test");
			//Login.PortalLogin("wsp9997115", "bhanu", "121@test");
			Login.PortalLogin("WSP6656413", "admin", "121@test");   
			Confirn_Maker.Exchange_Deposit_Confirm_WH();
			test.log(LogStatus.PASS, "Deposit_Confirm_WH_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();

	}
//@Test
	void Deposit_Confirm_WH_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposit_Confirm_WH_Checker is start");
			Deposit_Confirm_WH_Checker Confirm = new Deposit_Confirm_WH_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user72", "121@test");
			//Login.PortalLogin("wsp9997115", "pratap", "121@test");
			Confirm.Exchange_Deposit_Confirm_WH();
			test.log(LogStatus.PASS, "Deposit_Confirm_WH_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	}


