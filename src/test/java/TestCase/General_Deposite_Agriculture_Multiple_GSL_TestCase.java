package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.DashBoard_WareHouse_Checker;
import TestPages.Deposit_Confirm_WH_Maker;
import TestPages.Deposite_Assayer_Checker;
import TestPages.Deposite_Assayer_Maker;
import TestPages.LoginPages;
import TestPages.Physical_Deposit_Maker;
import TestPages.RP_Deposite_Request_Agriculture_Maker;
import TestPages.RP_Deposite_Request_Checker;
import TestPages.ScreenShort;

public class General_Deposite_Agriculture_Multiple_GSL_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("ENWR_Generation for General");

	 @Test(retryAnalyzer = Utillity.RetryTest.class)
	void RP_Deposite_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "General_Deposite_Agriculture_Multiple_GSL_Maker start");
			RP_Deposite_Request_Agriculture_Maker Depo = new RP_Deposite_Request_Agriculture_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user51", "121@test");  //Abhishek
			//Login.PortalLogin("RP-XYZ", "user119", "121@test");  //Adwait
			 //Login.PortalLogin("RP-KML", "USER_A", "121@test");   //Akshay
			//Login.PortalLogin("RP-COUNTRYWIDE", "Bhanu1", "121@test");//Bhanu
			Login.PortalLogin("RP-UATTEST", "user1", "121@test");//Lakshman
			Depo.General_Deposite_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "General_Deposite_Agriculture_Multiple_GSLt_Maker is success full");
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

	// @Test
	void RP_Deposite_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "General_Deposite_Agriculture_Multiple_GSL_Checker is start");
			RP_Deposite_Request_Checker Dash = new RP_Deposite_Request_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("RP-Abhishek", "user52", "121@test");
			//Login.PortalLogin("RP-XYZ", "user2", "121@test");
			//Login.PortalLogin("RP-KML", "user2", "121@test");
			Login.PortalLogin("RP-UATTEST", "user6", "121@test");
			//Login.PortalLogin("RP-COUNTRYWIDE", "Bhanu2", "121@test");//Bhanu
			Dash.Deposite_Request();
			test.log(LogStatus.PASS, "General_Deposite_Agriculture_Multiple_GSL_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
//Database Connection is required for Physical_Deposit_Maker
	// @Test
	void DashBord_WareHouse_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "DashBord_WareHouse_Agriculture_Multiple_GSL_Maker is start");
			Physical_Deposit_Maker WSP = new Physical_Deposit_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9999996", "user71", "121@test");
			//Login.PortalLogin("wsp9999996", "user1", "121@test");
			//Login.PortalLogin("WSP9996059", "user111", "121@test");
			Login.PortalLogin("WSP8888999", "user7", "121@test");
			//Login.PortalLogin("WSP9997115", "Bhanu", "121@Test");//bhanu
			WSP.General_Physical_Deposit_Maker_Multiple_GSL();
			test.log(LogStatus.PASS, "DashBord_WareHouse_Agriculture_Multiple_GSL_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

 //@Test(retryAnalyzer = Utillity.RetryTest.class)
	void DashBoard_WareHouse_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "DashBoard_WareHouse_Agriculture_Multiple_GSL_Checker is start");
			DashBoard_WareHouse_Checker WSP_CH = new DashBoard_WareHouse_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9999996", "user2", "121@test");
			// Login.PortalLogin("wsp9999996", "user72", "121@test");
			//Login.PortalLogin("WSP9996059", "user112", "121@test");
			Login.PortalLogin("WSP8888999", "user8", "121@test");
			//Login.PortalLogin("WSP9997115", "Pratap", "121@Test");//bhanu
			WSP_CH.Deposit_Maker_Multiple_GSL_Checker();
			test.log(LogStatus.PASS, "DashBoard_WareHouse_Agriculture_Multiple_GSL_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

// @Test
	void Deposite_Assayer_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposite_Assayer_Agriculture_Multiple_GSL_Maker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("Asyr-3338084", "user1", "121@test");
			Login.PortalLogin("ASYR-8889999", "user1", "121@test");
			//Login.PortalLogin("ASYR-2905202", "Bhanu1", "121@Test");//bhanu
			//Login.PortalLogin("ASYR-1002121", "user119", "121@test");
			 //Login.PortalLogin("Assayer01", "user4", "121@test");
			Deposite_Assayer_Maker Assayer = new Deposite_Assayer_Maker(driver, Wait);
			Assayer.Deposit_Assayer_Agriculture_Multiple_GSL_Maker();
			test.log(LogStatus.PASS, "Deposite_Assayer_Agriculture_Multiple_GSL_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Deposite_Assayer_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposite_Assayer_Agriculture_Multiple_GSL_Checker is start");
			Deposite_Assayer_Checker Assayer = new Deposite_Assayer_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("Asyr-3338084", "user2", "121@test");
			Login.PortalLogin("ASYR-8889999", "user2", "121@test");
			//Login.PortalLogin("ASYR-2905202", "Bhanu2", "121@test");//bhanu
			//Login.PortalLogin("ASYR-1002121", "user120", "121@test");
			//Login.PortalLogin("Assayer01", "user112", "121@test");
			// Login.PortalLogin("Assayer01", "user2", "121@test");
			Assayer.Deposit_Assayer_Agriculture_Multiple_GSL_Checker();
			test.log(LogStatus.PASS, "Deposite_Assayer_Agriculture_Multiple_GSL_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Deposit_Confirm_WH_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposit_Confirm_WH_Agriculture_Multiple_GSL_Maker is start");
			Deposit_Confirm_WH_Maker Confirn_Maker = new Deposit_Confirm_WH_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("WSP9996059", "user111", "121@test");
			//Login.PortalLogin("wsp9999996", "user71", "121@test");
			Login.PortalLogin("WSP8888999", "user7", "121@test");
			//Login.PortalLogin("WSP9997115", "Bhanu", "121@Test");//bhanu
			// Login.PortalLogin("wsp9996059", "user101", "121@test");
			//Login.PortalLogin("WSP-8843376", "user119", "121@test");
			Confirn_Maker.Deposit_Confirm_WH_Agriculture_Multiple_GSL_Maker();
			test.log(LogStatus.PASS, "Deposit_Confirm_WH_Agriculture_Multiple_GSL_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
	}

	//@Test
	void Deposit_Confirm_WH_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposit_Confirm_WH_Agriculture_Multiple_GSL_Checker is start");
			TestPages.Deposit_Confirm_WH_Checker Confirm = new TestPages.Deposit_Confirm_WH_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("WSP9996059", "user112", "121@test");
			Login.PortalLogin("WSP8888999", "user8", "121@test");
			//Login.PortalLogin("WSP9997115", "Pratap", "Mar@2026");//bhanu
			//Login.PortalLogin("wsp9999996", "user72", "121@test");
			// Login.PortalLogin("wsp9996059", "user102", "121@test");
			//Login.PortalLogin("WSP-8843376", "user120", "121@test");
			Confirm.Deposit_Confirm_WH_Agriculture_Multiple_GSL_Checker();
			test.log(LogStatus.PASS, "Deposit_Confirm_WH_Agriculture_Multiple_GSL_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

}
