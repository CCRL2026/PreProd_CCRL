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

public class CR246_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport_CR246_"
			+ System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("CR246");

	//@Test
	void Test_Case1() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR246_TestCase1 is  start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			//Login.PortalLogin("", "admin", "121@test");
			Exports_Reports Test_Case1 = new Exports_Reports(driver, Wait);
			Test_Case1.CR246_TestCase1();
			test.log(LogStatus.PASS,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase1 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase1 failed :"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

//	@Test
	void Test_Case2() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR246_TestCase2 is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Exports_Reports Test_Case2 = new Exports_Reports(driver, Wait);
			Test_Case2.CR246_TestCase2();
			test.log(LogStatus.PASS,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase2 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase2 is failed"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	//@Test
	void Test_Case3() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR246_TestCase3 is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Exports_Reports Test_Case3 = new Exports_Reports(driver, Wait);
			Test_Case3.CR246_TestCase3();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "CR246_TestCase3 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			//TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			//Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase3 is failed"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	//@Test
	void Test_Case4() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR246_TestCase4 is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Exports_Reports Test_Case4 = new Exports_Reports(driver, Wait);
			Test_Case4.CR246_TestCase4();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "CR246_TestCase4 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase4 is failed"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	//@Test
	void Test_Case5() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR246_TestCase5 is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Exports_Reports Test_Case5 = new Exports_Reports(driver, Wait);
			Test_Case5.CR246_TestCase5();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "CR246_TestCase5 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase5 is failed"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	//@Test
	void Test_Case6() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR246_TestCase6 start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			Exports_Reports Test_Case6 = new Exports_Reports(driver, Wait);
			Test_Case6.CR246_TestCase6();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "CR246_TestCase6 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase6 failed"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	//@Test
	void Test_Case7() throws IOException {
		try {
			test.log(LogStatus.INFO, "CR246_TestCase7 is start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("", "admin", "121@test");
			Exports_Reports Test_Case7 = new Exports_Reports(driver, Wait);
			Test_Case7.CR246_TestCase7();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "CR246_TestCase7 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase7 is failed"
					+ e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	@Test
		void Test_Case8() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR246_TestCase8 is start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case8 = new Exports_Reports(driver, Wait);
				Test_Case8.CR246_Test_Case8();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "CR246_TestCase8 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase8 is failed"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
	//	@Test
		void Test_Case9() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR246_TestCase9 is start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case9 = new Exports_Reports(driver, Wait);
				Test_Case9.CR246_Test_Case9();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "CR246_TestCase9 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase9 is failed"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void Test_Case10() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR246_TestCase10 is start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case10 = new Exports_Reports(driver, Wait);
				Test_Case10.CR246_Test_Case10();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "CR246_TestCase10 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				//TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				//Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase10 is failed"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void Test_Case11() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR246_TestCase11 is start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case11 = new Exports_Reports(driver, Wait);
				Test_Case11.CR246_Test_Case11();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "CR246_TestCase11 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				//TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				//Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase11 is failed"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
		void Test_Case12() throws IOException {
			try {
				test.log(LogStatus.INFO, "CR246_TestCase12 is start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case12 = new Exports_Reports(driver, Wait);
				Test_Case12.CR246_Test_Case12();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "CR246_TestCase12 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "CR246_TestCase12 is failed"
						+ e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
}
