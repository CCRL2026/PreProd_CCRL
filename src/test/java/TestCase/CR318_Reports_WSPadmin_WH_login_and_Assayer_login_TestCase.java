package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.Deposit_Confirm_WH_Maker;
import TestPages.Deposite_Assayer_Maker;
import TestPages.LoginPages;
import TestPages.Physical_Deposit_Maker;
import TestPages.Pledge_Creation_WareHouse;
import TestPages.Withdrawal_Confirm_WSP_Maker;

@Listeners(Utillity.TestNGListeners.class)
public class CR318_Reports_WSPadmin_WH_login_and_Assayer_login_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\CR318_24_Dec"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("CR318:Reports WSPadmin WH login and Assayer login");
	
	@Test
	  void Pledge_Creation_WareHouse_CR318 () throws IOException {
		try {
			test.log(LogStatus.INFO, "Pledge_Creation_WareHouse_CR318 is start");
		  LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Login.PortalLogin("WSP9999996", "user71", "121@test");
			Pledge_Creation_WareHouse CR118 = new Pledge_Creation_WareHouse(driver,Wait);
			CR118.Pledge_Creation_WareHouse_Approval_C118();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation_WareHouse_CR318 is successfull");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Test failed for Pledge_Creation_WareHouse_CR318: "+e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	} 

//	@Test
	  void Physical_Deposit_Pending_CR318 () throws IOException {
		try {
			test.log(LogStatus.INFO, "Physical_Deposit_Pending_CR318 is  start");
		  LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Login.PortalLogin("WSP9999996", "user71", "121@test");
			Physical_Deposit_Maker CR118 = new Physical_Deposit_Maker(driver,Wait);
			CR118.Physical_Deposit_Pending_CR118();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Physical_Deposit_Pending_CR318 is successfull");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Test failed for Physical_Deposit_Pending_CR318: "+e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	} 
	
	//@Test
	  void Withdrawal_Confirm_Pending_CR318 () throws IOException {
		try {
			test.log(LogStatus.INFO, "Withdrawal_Confirm_Pending_CR318 is start");
		  LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Login.PortalLogin("WSP9999996", "user71", "121@test");
			Withdrawal_Confirm_WSP_Maker CR118 = new Withdrawal_Confirm_WSP_Maker(driver,Wait);
			CR118.Withdrawal_Confirm_Pending_CR118();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Withdrawal_Confirm_Pending_CR318 is successfull");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Test failed for Withdrawal_Confirm_Pending_CR318: "+e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	} 
	  
	//@Test
	  void Deposit_Confirm_Pending_CR318 () throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposit_Confirm_Pending_CR318 is start");
		  LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Login.PortalLogin("WSP9999996", "user71", "121@test");
			Deposit_Confirm_WH_Maker CR118 = new Deposit_Confirm_WH_Maker(driver,Wait);
			CR118.Deposit_Confirm_Pending_CR118();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Deposit_Confirm_Pending_CR318 is successfull");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Test failed for Deposit_Confirm_Pending_CR318: "+e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	} 
	
//	@Test
	  void Deposit_Assayer_Pending_CR318 () throws IOException {
		try {
			test.log(LogStatus.INFO, "Deposit_Assayer_Pending_CR318 is start");
		  LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user51", "121@test");
		  Login.PortalLogin("Asyr-3338084", "user1", "121@test");
			
			Deposite_Assayer_Maker CR118 = new Deposite_Assayer_Maker(driver,Wait);
			CR118.Deposit_Assayer_Pending_CR318();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Deposit_Assayer_Pending_CR318 is successfull");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Test failed for Deposit_Assayer_Pending_CR318:"+e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	} 
}
