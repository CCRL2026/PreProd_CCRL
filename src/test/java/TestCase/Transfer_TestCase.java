package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.LoginPages;



@Listeners(Utillity.TestNGListeners.class)
public class Transfer_TestCase  extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Transfer Report");
	@Test
	void Transfer_Request() throws IOException {
		try {
			test.log(LogStatus.INFO, "Transfer_Request is start");
			LoginPages Login = new LoginPages(driver, Wait);
		//	Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			
			Login.PortalLogin("RP-UATTEST", "user1", "121@test");
			
			TestPages.Transfer_Request_RP_Maker Trf = new TestPages.Transfer_Request_RP_Maker(driver, Wait);
			try {
			Trf.Transfer_Request_Maker();
			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("Error occurred while running Exchange_Non_Agriculture_Physical_Multiple_GSL: " + e.getMessage());
			}
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Transfer_Request is success full");
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
	//@Test
	void Transfer_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Transfer_Request_Checker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			Login.PortalLogin("RP-UATTEST", "user2", "121@test");
			TestPages.Transfer_Request_RP_Checker Trf = new TestPages.Transfer_Request_RP_Checker(driver, Wait);
			Trf.Transfer_Request_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Transfer_Request_Checker is success full");
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
	//@Test
	void Transfer_Warehouse_Approval_Request() throws IOException {
		try {
			test.log(LogStatus.INFO, "Transfer_Warehouse_Approval_Maker is start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("wsp9999996", "user71", "121@test");
			Login.PortalLogin("WSP8888999", "user2", "121@test");
			TestPages.Transfer_Warehouse_Approval_Maker Trf = new TestPages.Transfer_Warehouse_Approval_Maker(driver, Wait);
			Trf.Transfer_Warehouse_Approval_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Transfer_Warehouse_Approval_Maker is success full");
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
//	@Test
		void Transfer_Warehouse_Approval_Checker() throws IOException {
			try {
				test.log(LogStatus.INFO, "Transfer_Warehouse_Approval_Checker is start");
				LoginPages Login = new LoginPages(driver, Wait);
				//Login.PortalLogin("wsp9999996", "user72", "121@test");
				Login.PortalLogin("WSP8888999", "user3", "121@test");
				TestPages.Transfer_Request_RP_Checker Trf = new TestPages.Transfer_Request_RP_Checker(driver, Wait);
				Trf.Transfer_Warehouse_Approval_Checker();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "Transfer_Warehouse_Approval_Checker is success full");
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
	
}
