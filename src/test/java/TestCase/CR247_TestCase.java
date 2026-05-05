package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.Exports_Reports;
import TestPages.LoginPages;

public class CR247_TestCase extends BaseClass {
	
	
	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport_CR247_"
			+ System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("CR247");

	//@Test
	void CR247_TestCase1() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR247_TestCase1 is  start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-abhishek", "user51", "121@test");
			Exports_Reports Test_Case1 = new Exports_Reports(driver, Wait);
			Test_Case1.CR247_TestCase1();
			test.log(LogStatus.PASS,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase1 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase1 is failed :"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}
	
	//@Test
		void CR247_Test_Case2() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_Test_Case2 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-abhishek", "user51", "121@test");
				Exports_Reports Test_Case2 = new Exports_Reports(driver, Wait);
				Test_Case2.CR247_Test_Case2();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case2 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case2 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void CR247_Test_Case3() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_Test_Case3 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-abhishek", "user51", "121@test");
				Exports_Reports Test_Case3 = new Exports_Reports(driver, Wait);
				Test_Case3.CR247_Test_Case3();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case3 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case3 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
	//	@Test
		void CR247_Test_Case4() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_Test_Case4 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-abhishek", "user51", "121@test");
				Exports_Reports Test_Case4 = new Exports_Reports(driver, Wait);
				Test_Case4.CR247_Test_Case4();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case4 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case4 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void CR247_TestCase5() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_TestCase5 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-abhishek", "user51", "121@test");
				Exports_Reports Test_Case5 = new Exports_Reports(driver, Wait);
				Test_Case5.CR247_TestCase5();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase5 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase5 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void CR247_TestCase6() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_TestCase6 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-abhishek", "user51", "121@test");
				Exports_Reports Test_Case6 = new Exports_Reports(driver, Wait);
				Test_Case6.CR247_TestCase6();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase6 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase6 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
	//	@Test
		void CR247_TestCase7() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_TestCase7 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case7 = new Exports_Reports(driver, Wait);
				Test_Case7.CR247_TestCase7();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase7 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase7 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void CR247_TestCase8() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_TestCase8 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case8 = new Exports_Reports(driver, Wait);
				Test_Case8.CR247_TestCase8();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase8 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_TestCase8 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void CR247_TestCase9() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_TestCase9 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case9 = new Exports_Reports(driver, Wait);
				Test_Case9.CR247_TestCase9();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case9 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case9 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
	//	@Test
		void CR247_TestCase10() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_TestCase10 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case10 = new Exports_Reports(driver, Wait);
				Test_Case10.CR247_TestCase10();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case10 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case10 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
	//	@Test
		void CR247_Test_Case11() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_Test_Case11 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case11 = new Exports_Reports(driver, Wait);
				Test_Case11.CR247_Test_Case11();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case11 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case11 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void CR247_TestCase12() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR247_TestCase12 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case12 = new Exports_Reports(driver, Wait);
				Test_Case12.CR247_TestCase12();
				test.log(LogStatus.PASS,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case12 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR247_Test_Case12 is failed :"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		


}
