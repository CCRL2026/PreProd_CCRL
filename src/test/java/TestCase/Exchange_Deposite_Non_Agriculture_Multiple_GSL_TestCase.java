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

public class Exchange_Deposite_Non_Agriculture_Multiple_GSL_TestCase extends BaseClass {
	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
			+ " Exchange_Deposite_Non_Agri_GSL" + +System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("ENWR_Generation for Exchange_Non_Agriculture");

	@Test
	void Exchange_Deposite_Request_Non_Agriculture_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Deposite_Non_Agriculturet_Maker start");

			LoginPages Login = new LoginPages(driver, Wait);
			// Login.PortalLogin("RP-KML", "user_A", "121@test");
			// Login.PortalLogin("RP-UATTEST", "user1", "121@test");// Lakshuman Sir
			// Login.PortalLogin("RP-COUNTRYWIDE", "Bhanu1", "121@test");//Bhanu
			Login.PortalLogin("rp-Abhishek", "user51", "121@test"); // Abhishek

			Exchange_Deposite_Request_Non_Agriculture_Maker Depo = new Exchange_Deposite_Request_Non_Agriculture_Maker(
					driver, Wait);
			Depo.Non_Agriculture_Exchange_Deposite_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Exchange_Deposite_Non_Agriculturet_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage());
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
			//Login.PortalLogin("RP-KML", "user_B", "121@test");
			// Login.PortalLogin("RP-UATTEST", "user2", "121@test");
			 Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			// Login.PortalLogin("RP-COUNTRYWIDE", "Bhanu2", "121@test");
			Dash.Exchange_Deposite_Request_Non_Agriculture_Checker();
			test.log(LogStatus.PASS, "Exchange_Deposite_Non_Agriculture_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// Database

	// @Test
	void DashBoard_WareHouse_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Physical_Deposit_Request_Maker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9999996", "user1", "121@test");
			// Login.PortalLogin("WSP8888999", "user3", "121@test");
			// Login.PortalLogin("WSP8888999", "user2", "121@test");
			 Login.PortalLogin("wsp9999996", "user71", "121@test");
			// Login.PortalLogin("wsp9996059", "user102", "121@test");
			// Login.PortalLogin("WSP9997115", "Bhanu", "121@test");
			try {
				Exchange_Non_Agri_WareHouse WSP_CH = new Exchange_Non_Agri_WareHouse(driver, Wait);
				WSP_CH.Exchange_Non_Agriculture_Physical_Multiple_GSL();
				System.out.println("Function executed successfully");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error occurred while running Exchange_Non_Agriculture_Physical_Multiple_GSL: "
						+ e.getMessage());
			}
			test.log(LogStatus.PASS, "Exchange_Non_Agriculture_Physical_Deposit_Request_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
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
			Login.PortalLogin("wsp9999996", "user2", "121@test");
			// Login.PortalLogin("WSP8888999", "user2", "121@test");
			// Login.PortalLogin("wsp9999996", "user72", "121@test");
			// Login.PortalLogin("wsp9997115", "pratap", "121@test");
			// Login.PortalLogin("wsp9996059", "user101", "121@test");
			// Login.PortalLogin("WSP9996059", "user112", "121@test");
			WSP_CH.Exchange_Deposit_Non_Agriculture_Multiple_GSL_Checker();
			test.log(LogStatus.PASS, "Exchange_Non_Agriculture_Physical_Deposit_Request_Checker is successfull");
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
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Deposite_Assayer_Maker is start");
			Deposite_Assayer_Maker Assayer = new Deposite_Assayer_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("Asyr-3338084", "user1", "121@test");
			// Login.PortalLogin("ASYR-2905202", "Bhanu1", "121@best");
			// Login.PortalLogin("ASYR-8889999", "user1", "121@test"); //Lakshuman
			// Login.PortalLogin("Assayer01", "user1", "121@test");
			Assayer.Exchange_Deposit_Assayer_Non_Agriculture_Multiple_GSL();
			test.log(LogStatus.PASS, "Exchange_Non_Agriculture_Deposite_Assayer_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
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
			// Login.PortalLogin("Assayer01", "user2", "121@test");
			// Login.PortalLogin("ASYR-2905202", "Bhanu2", "121@test");
			Login.PortalLogin("Asyr-3338084", "user2", "121@test");
			Assayer.Exchange_Deposite_Assayer_Non_Agriculture_Multiple_GSL();
			test.log(LogStatus.PASS, "Exchange_Non_Agriculture_Deposite_Assayer_Checker is successfull");
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
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Deposit_Confirm_WH_Maker is start");
			Deposit_Confirm_WH_Maker Confirn_Maker = new Deposit_Confirm_WH_Maker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user1", "121@test");
			// Login.PortalLogin("WSP8888999", "user2", "121@test");
			// Login.PortalLogin("wsp9999996", "user71", "Test@123");
			// Login.PortalLogin("wsp9997115", "bhanu", "121@test");
			// Login.PortalLogin("wsp9996059", "user102", "121@test");
			// Login.PortalLogin("WSP9996059", "user111", "121@test");
			Confirn_Maker.Exchange_Deposit_Confirm_WH_Non_Agriculture_Multiple_GSL();
			test.log(LogStatus.PASS, "Exchange_Non_Agriculture_Deposit_Confirm_WH_Maker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

//	 @Test
	void Deposit_Confirm_WH_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Exchange_Non_Agriculture_Deposit_Confirm_WH_Checker is start");
			Deposit_Confirm_WH_Checker Confirm = new Deposit_Confirm_WH_Checker(driver, Wait);
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("wsp9999996", "user2", "121@test");
			// Login.PortalLogin("WSP8888999", "user3", "121@test");
			// Login.PortalLogin("wsp9999996", "user72", "Test@123");
			// Login.PortalLogin("wsp9997115", "pratap", "121@test");
			// Login.PortalLogin("wsp9996059", "user101", "121@test");
			// Login.PortalLogin("WSP9996059", "user112", "121@test");
			Confirm.Exchange_Deposit_Confirm_WH_Non_Agriculture_Multiple_GSL();
			test.log(LogStatus.PASS, "Exchange_Non_Agriculture_Deposit_Confirm_WH_Checker is successfull");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(ScreenShort.CaptureScreen(driver)) + "Test failed: " + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
}