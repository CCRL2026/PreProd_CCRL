package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.Client_Account_opening_For_RP;
import TestPages.LoginPages;
import TestPages.RP_Deposite_Request_Checker;

public class ClientAccountOpening_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Client Account Opening for REPOSITORY");
	
	//@Test
	  void Clientclientid_Account_opening_For_REPOSITORY_Maker () throws IOException {
		try {
			test.log(LogStatus.INFO, "Client Account Opening for REPOSITORY start");
		  LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Client_Account_opening_For_RP Client = new Client_Account_opening_For_RP(driver,Wait);
			Client.Client_Account_opening();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Client Account Opening for REPOSITORY is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Test failed"+e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
	@Test
	void Clientclientid_Account_opening_For_REPOSITORY_Checker () throws IOException {
		try {
			test.log(LogStatus.INFO, "Client Account Opening for REPOSITORY start");
		  LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			RP_Deposite_Request_Checker Client = new RP_Deposite_Request_Checker(driver,Wait);
			Client.Client_Account_opening_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Client Account Opening for REPOSITORY is success full");
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
}
