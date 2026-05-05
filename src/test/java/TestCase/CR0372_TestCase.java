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

public class CR0372_TestCase extends BaseClass {

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

}
