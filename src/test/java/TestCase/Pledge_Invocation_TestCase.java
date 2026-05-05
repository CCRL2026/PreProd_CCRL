package TestCase;
import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.Pledge_Invocation;
import TestPages.Pledge_Invocation_Request_Authorized;
import TestPages.LoginPages;

public class Pledge_Invocation_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
			+ System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("Pledge_Invocation Report");

//	 @Test
	void Pledge_Invocation() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledge_Invocation start");
			LoginPages Login = new LoginPages(driver, Wait);
			 Login.PortalLogin("rp-UCOBANK", "panvel1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledge_Invocation creation is start");
			Pledge_Invocation Pledge = new Pledge_Invocation(driver, Wait);
			Pledge.Pledge_Invocation_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledge_Invocation  is Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledge_Invocation is END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Pledge_Invocation Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	 @Test
	void Pledge_Invocation_Request_Authorized() throws IOException {
		try {
			test.log(LogStatus.INFO, "Logion for Pledge_Invocation Authorized start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-UCOBANK", "panvel1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledge_Invocation Authorized start");
			Pledge_Invocation_Request_Authorized Exch = new Pledge_Invocation_Request_Authorized(driver,
					Wait);
			Exch.Pledge_Invocation_Authorized();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Invocation Authorized is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledge_Invocation Authorized start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledge_Invocation Authorized END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Invocation Authorized Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
 

}
