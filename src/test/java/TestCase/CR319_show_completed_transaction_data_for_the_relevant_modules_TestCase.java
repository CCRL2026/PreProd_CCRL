package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.DePledge_Confirm_By_Pledgee;
import TestPages.LoginPages;
import TestPages.Pledge_Creation_WareHouse;

//@Listeners(Utillity.TestNGListeners.class)
public class CR319_show_completed_transaction_data_for_the_relevant_modules_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\CR319_19_Dec"
			+ System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("CR319-show completed transaction data");

	//@Test
	void Pledge_Creation_Confirmation_CR319() throws IOException, InterruptedException {
		/* LogEntries logs = driver.manage().logs().get(LogType.BROWSER); */
		try {
			test.log(LogStatus.INFO, "Pledge_Creation_Confirmation_CR319 is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("WSP9999996", "user71", "121@test");
			Pledge_Creation_WareHouse CR319 = new Pledge_Creation_WareHouse(driver, Wait);
			CR319.Pledge_Creation_Confirmation_CR319();

			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation_Confirmation_CR319 is successfull");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Test failed for Pledge_Creation_Confirmation_CR319: " + e.getMessage());
			LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
			logs.getAll();	
		}
		Report.endTest(test);
		Report.flush();
	}

	 @Test
	void Depledge_Confirm_by_Pledgee_CR319() throws IOException {
		try {
			test.log(LogStatus.INFO, "Depledge_Confirm_by_Pledgee_CR319 is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("WSP9999996", "user71", "121@test");
			DePledge_Confirm_By_Pledgee CR319 = new DePledge_Confirm_By_Pledgee(driver, Wait);
			CR319.Depledge_Confirm_by_Pledgee_CR319();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Depledge_Confirm_by_Pledgee_CR319 is successfull");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Test failed for Depledge_Confirm_by_Pledgee_CR319" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

}
