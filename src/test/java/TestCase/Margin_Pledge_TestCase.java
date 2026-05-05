package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.LoginPages;

public class Margin_Pledge_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"+ System.currentTimeMillis()+".html",
			true);
	ExtentTest test = Report.startTest("Margin_Pledge_TestCase Report");
/*******************************************Margin_Pledge_Request*******************************************************/
	//@Test
	void Margin_Pledge() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Margin_Pledge start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Margin_Pledge creation  start");
			TestPages.Margin_Pledge_Request Margin = new TestPages.Margin_Pledge_Request(driver, Wait);
			Margin.Margin_Pledge_Request_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Margin_Pledge is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Margin_Pledge Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	
	
	//@Test
	void Margin_Pledge_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Margin_Pledge_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Margin_Pledge_Checker creation  start");
			TestPages.Margin_Pledge_Checker Margin = new TestPages.Margin_Pledge_Checker(driver, Wait);
			Margin.Margin_Pledge_Request_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Margin_Pledge_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Margin_Pledge_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	/****************************************Margin_Pledge_Request_Approval****************************************/
	//@Test
	void Margin_Pledge_Request_Approval() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Margin_Pledge_Request_Confirm start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("Wsp9999996", "user71", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Margin_Pledge_Request_Confirm creation  start");
			TestPages.Margin_Pledge_Request_Approval Margin = new TestPages.Margin_Pledge_Request_Approval(driver, Wait);
			Margin.Margin_Pledge_Request_Approval_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Margin_Pledge_Request_Confirm is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Request_Confirm  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Margin_Pledge_Request_Confirm Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	
	//@Test
	void Margin_Pledge_Request_Approval_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Margin_Pledge_Request_Confirm_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("Wsp9999996", "user72", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Margin_Pledge_Request_Confirm_Checker creation  start");
			TestPages.Margin_Pledge_Checker Margin = new TestPages.Margin_Pledge_Checker(driver, Wait);
			Margin.Margin_Pledge_Request_Approval_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Margin_Pledge_Request_Confirm_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Request_Confirm_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "Margin_Pledge_Request_Confirm_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	/*********************************************Margin_Pledge_Request_Confirm*************************************/
	
	//@Test
	void Margin_Pledge_Request_Confirm_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Margin_Pledge_Request_Confirm_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Margin_Pledge_Request_Confirm_Maker creation  start");
			TestPages.Margin_Pledge_Request_Confirm Margin = new TestPages.Margin_Pledge_Request_Confirm(driver, Wait);
			Margin.Margin_Pledge_Request_Confirm_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Margin_Pledge_Request_Confirm_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Request_Confirm_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "Margin_Pledge_Request_Confirm_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	
	//@Test
	void Margin_Pledge_Request_Confirm_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Margin_Pledge_Request_Confirm_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Margin_Pledge_Request_Confirm_Checker creation  start");
			TestPages.Margin_Pledge_Checker Margin = new TestPages.Margin_Pledge_Checker(driver, Wait);
			Margin.Margin_Pledge_Request_Confirm_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Margin_Pledge_Request_Confirm_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Request_Confirm_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "Margin_Pledge_Request_Confirm_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	
	/*********************************************TM_RePledge_Request*************************************/
//	@Test
	void TM_RePledge_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for TM_RePledge_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "TM_RePledge_Request_Maker creation  start");
			TestPages.TM_RePledge_Request Margin = new TestPages.TM_RePledge_Request(driver, Wait);
			Margin.TM_RePledge_Request_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "TM_RePledge_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Margin_Pledge_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for TM_RePledge_Request_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "TM_RePledge_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	//@Test
	void TM_RePledge_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for TM_RePledge_Request_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			Login.PortalLogin("rp-xyz", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "TM_RePledge_Request_Checker creation  start");
			TestPages.Margin_Pledge_Checker Margin = new TestPages.Margin_Pledge_Checker(driver, Wait);
			Margin.TM_RePledge_Request_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "TM_RePledge_Request_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for TM_RePledge_Request_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for TM_RePledge_Request_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "TM_RePledge_Request_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	/**************************************************TM_RePledge_Request_Confirm*********************************/
	
	//@Test
		void TM_RePledge_Request_Confirm_Maker() throws IOException {
			try {
				test.log(LogStatus.INFO, "Login for TM_RePledge_Request_Confirm_Maker start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-Abhishek", "user51", "121@test");
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
				test.log(LogStatus.INFO, "TM_RePledge_Request_Confirm_Maker creation  start");
				TestPages.TM_RePledge_Request_Confirm Margin = new TestPages.TM_RePledge_Request_Confirm(driver, Wait);
				Margin.TM_RePledge_Request_Confirm_Maker();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "TM_RePledge_Request_Confirm_Maker is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				test.log(LogStatus.INFO, "LogOut for TM_RePledge_Request_Checker  Start");
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
				test.log(LogStatus.INFO, "LogOut for TM_RePledge_Request_Confirm_Maker  END");
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "TM_RePledge_Request_Confirm_Maker Test failed");
			}
			Report.endTest(test);
			Report.flush();
		}
	//@Test
		void TM_RePledge_Request_Confirm_Checker() throws IOException {
			try {
				test.log(LogStatus.INFO, "Login for TM_RePledge_Request_Confirm_Checker start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-Abhishek", "user52", "121@test");
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
				test.log(LogStatus.INFO, "TM_RePledge_Request_Confirm_Checker creation  start");
				TestPages.Margin_Pledge_Checker Margin = new TestPages.Margin_Pledge_Checker(driver, Wait);
				Margin.TM_RePledge_Request_Confirm_Checker();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "TM_RePledge_Request_Confirm_Checker is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				test.log(LogStatus.INFO, "LogOut for TM_RePledge_Request_Confirm_Checker  Start");
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
				test.log(LogStatus.INFO, "LogOut for TM_RePledge_Request_Confirm_Checker  END");
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "TM_RePledge_Request_Confirm_Checker Test failed");
			}
			Report.endTest(test);
			Report.flush();
		}
		/******************************************************CM Re-Pledge Request ***************************/
		//@Test
				void CM_RePledge_Request_Maker() throws IOException {
					try {
						test.log(LogStatus.INFO, "Login for CM_RePledge_Request_Maker start");
						LoginPages Login = new LoginPages(driver, Wait);
						Login.PortalLogin("rp-Abhishek", "user51", "121@test");
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
						test.log(LogStatus.INFO, "CM_RePledge_Request_Maker creation  start");
						TestPages.CM_RePledge_Request Margin = new TestPages.CM_RePledge_Request(driver, Wait);
						Margin.CM_RePledge_Request_Maker();
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
								+ "CM_RePledge_Request_Maker is success full");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						test.log(LogStatus.INFO, "LogOut for CM_RePledge_Request_Maker  Start");
						TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
						Log.Logout();
						test.log(LogStatus.INFO, "LogOut for CM_RePledge_Request_Maker  END");
					} catch (Exception e) {
						test.log(LogStatus.FAIL,
								test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CM_RePledge_Request_Maker Test failed");
					}
					Report.endTest(test);
					Report.flush();
				}
		
				//@Test
				void CM_RePledge_Request_Checker() throws IOException {
					try {
						test.log(LogStatus.INFO, "Login for CM_RePledge_Request_Checker start");
						LoginPages Login = new LoginPages(driver, Wait);
						//Login.PortalLogin("rp-Abhishek", "user52", "121@test");
						Login.PortalLogin("rp-KML", "user2", "121@test");
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
						test.log(LogStatus.INFO, "CM_RePledge_Request_Checker creation  start");
						TestPages.Margin_Pledge_Checker Margin = new TestPages.Margin_Pledge_Checker(driver, Wait);
						Margin.CM_RePledge_Request_Checker();
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
								+ "CM_RePledge_Request_Checker is success full");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						test.log(LogStatus.INFO, "LogOut for CM_RePledge_Request_Checker  Start");
						TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
						Log.Logout();
						test.log(LogStatus.INFO, "LogOut for CM_RePledge_Request_Checker  END");
					} catch (Exception e) {
						test.log(LogStatus.FAIL,
								test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CM_RePledge_Request_Checker Test failed");
					}
					Report.endTest(test);
					Report.flush();
				}
				
				/***********************************CC Re-Pledge Request Confirm********************************/
				@Test
				void CM_RePledge_Request_Confirm_Maker() throws IOException {
					try {
						test.log(LogStatus.INFO, "Login for CC_RePledge_Request_Confirm_Maker start");
						LoginPages Login = new LoginPages(driver, Wait);
						Login.PortalLogin("CC8880013", "user1", "121@test");
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
						test.log(LogStatus.INFO, "CC_RePledge_Request_Confirm_Maker creation  start");
						TestPages.CM_RePledge_Request_Confirm Margin = new TestPages.CM_RePledge_Request_Confirm(driver, Wait);
						try {
						Margin.CM_RePledge_Request_Confirm_Maker();
						}catch (Exception e) {
							System.out.println(e.getMessage());
						}
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
								+ "CC_RePledge_Request_Confirm_Maker is success full");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						test.log(LogStatus.INFO, "LogOut for CC_RePledge_Request_Confirm_Maker  Start");
						TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
						Log.Logout();
						test.log(LogStatus.INFO, "LogOut for CC_RePledge_Request_Confirm_Maker  END");
					} catch (Exception e) {
						test.log(LogStatus.FAIL,
								test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CC_RePledge_Request_Confirm_Maker Test failed");
					}
					Report.endTest(test);
					Report.flush();
				}
		
				//@Test
				void CM_RePledge_Request_Confirm_Checker() throws IOException {
					try {
						test.log(LogStatus.INFO, "Login for CC_RePledge_Request_Confirm_Checker start");
						LoginPages Login = new LoginPages(driver, Wait);
						Login.PortalLogin("CC8880013", "user2", "test@121");
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
						test.log(LogStatus.INFO, "CC_RePledge_Request_Confirm_Checker creation  start");
						TestPages.Margin_Pledge_Checker Margin = new TestPages.Margin_Pledge_Checker(driver, Wait);
						Margin.CM_RePledge_Request_Confirm_Checker();
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
								+ "CC_RePledge_Request_Confirm_Checker is success full");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						test.log(LogStatus.INFO, "LogOut for CC_RePledge_Request_Confirm_Checker  Start");
						TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
						Log.Logout();
						test.log(LogStatus.INFO, "LogOut for CC_RePledge_Request_Confirm_Checker  END");
					} catch (Exception e) {
						test.log(LogStatus.FAIL,
								test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CM_RePledge_Request_Confirm_Checker Test failed");
					}
					Report.endTest(test);
					Report.flush();
				}
				
				
}  
