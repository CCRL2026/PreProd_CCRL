package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.DataBaseUtility;

public class Margin_Pledge_Checker {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String OTP_Auth;

	public Margin_Pledge_Checker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Margin_Pledge_Checker creation
	// process-------------

	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Margin Pledge Request']")
	WebElement Margin_Pledge_Request_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Margin Pledge Request Approval']")
	WebElement Margin_Pledge_Request_Approval_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Margin Pledge Request Confirm']")
	WebElement Margin_Pledge_Request_Confirm_Btn;

	@FindBy(xpath = "//span[normalize-space()='TM Re-Pledge Request']")
	WebElement TM_RePledge_Request_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='TM Re-Pledge Request Confirm']")
	WebElement TM_RePledge_Request_Confirm_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='CM Re-Pledge Request']")
	WebElement CM_RePledge_Request_Btn;

	@FindBy(xpath = "//span[normalize-space()='CM Re-Pledge Request Confirm']")
	WebElement CM_RePledge_Request_Confirm_Btn;

	@FindBy(xpath = "//span[normalize-space()='CC De-Pledge Request']")
	WebElement CC_DePledge_Request_Btn;

	@FindBy(xpath = "//span[normalize-space()='CM De-Pledge Request']")
	WebElement CM_DePledge_Request_Btn;

	@FindBy(xpath = "//span[normalize-space()='TM De-Pledge Request']")
	WebElement TM_DePledge_Request_Btn;

	@FindBy(xpath = "//span[normalize-space()='CC De-Pledge Request']")
	WebElement CC_DePledge_Request_Btn_1;

	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='CC De-Pledge Confirm'])[1]")
	WebElement CC_DePledge_Confirm_Btn;

	@FindBy(xpath = "//span[normalize-space()='CM De-Pledge Confirm']")
	WebElement CM_DePledge_Confirm_Btn;

	@FindBy(xpath="//span[normalize-space()='TM De-Pledge Confirm']")
	WebElement TM_DePledge_Confirm_Btn;
	
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement scroll;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Search_Btn;

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement Actions_Btn;

	@FindBy(xpath = "//input[@name='auth_code']")
	WebElement auth_code_Txt;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit_Btn;

	@FindBy(xpath = "//a[normalize-space()='Authorize']")
	WebElement Authorize_Btn;

	@FindBy(xpath = "//label[normalize-space()='Authorize']")
	WebElement Authorize_Chek;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Btn;

	public void Margin_Pledge_Request_Checker() throws InterruptedException {

		Margin_Pledge_Btn.click();

		Margin_Pledge_Request_Btn.click();

		Search_Txt.sendKeys(Margin_Pledge_Request.Margin_pledge_Req_No);

		Search_Btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void Margin_Pledge_Request_Approval_Checker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Request_Approval_Btn)).click();

		Search_Txt.sendKeys(Margin_Pledge_Request.Margin_pledge_Req_No);

		Search_Btn.click();
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_Btn click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			} else {
				System.out.println("We are unable to click the Save_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void Margin_Pledge_Request_Confirm_Checker() throws InterruptedException {

		Margin_Pledge_Btn.click();

		Margin_Pledge_Request_Confirm_Btn.click();

		Search_Txt.sendKeys(Margin_Pledge_Request.Margin_pledge_Req_No);

		Search_Btn.click();
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_Btn click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void TM_RePledge_Request_Checker() throws InterruptedException {

		Margin_Pledge_Btn.click();

		TM_RePledge_Request_Btn.click();

		Search_Txt.sendKeys(TM_RePledge_Request.TM_pledge_Req_No);

		Search_Btn.click();
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_Btn click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		// SELECT a.auth_code FROM auth_code_generation a JOIN tm_repledge d ON a.ref_id
		// = d.Id WHERE a.tran_type like '%TR' and d.Request_No like'%abhi121%' ;

		try {
			Connection conn = DataBaseUtility.getConnection();

			String query_OTP = "SELECT a.auth_code FROM auth_code_generation a JOIN tm_repledge d ON a.ref_id = d.Id WHERE a.tran_type like '%TR' and  d.Request_No  like ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + TM_RePledge_Request.TM_pledge_Req_No + "%"); // bind the variable to query

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Wait.until(ExpectedConditions.elementToBeClickable(auth_code_Txt)).sendKeys(String.valueOf(OTP_Auth));

		Wait.until(ExpectedConditions.elementToBeClickable(Submit_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			} else {
				System.out.println("We are unable to click the Authorize_Chek CheckBox");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			} else {
				System.out.println("We are unable to click the Save_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}
	}

	public void TM_RePledge_Request_Confirm_Checker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(TM_RePledge_Request_Confirm_Btn)).click();

		Search_Txt.sendKeys(TM_RePledge_Request.TM_pledge_Req_No);
		Thread.sleep(1000);
		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_Btn click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(1000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			} else {
				System.out.println("We are unable to click the Authorize_Chek CheckBox");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			} else {
				System.out.println("We are unable to click the Save_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void CM_RePledge_Request_Checker() throws InterruptedException {

		Margin_Pledge_Btn.click();

		CM_RePledge_Request_Btn.click();

		Search_Txt.sendKeys(CM_RePledge_Request.CM_pledge_Req_No);
		Thread.sleep(1000);
		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_Btn click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		try {
			Connection conn = DataBaseUtility.getConnection();

			String query_OTP = "SELECT a.auth_code FROM auth_code_generation a JOIN cm_repledge d ON a.ref_id = d.Id WHERE a.tran_type like '%CR' and  d.Request_No  like ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + CM_RePledge_Request.CM_pledge_Req_No + "%"); // bind the variable to query

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Wait.until(ExpectedConditions.elementToBeClickable(auth_code_Txt)).sendKeys(String.valueOf(OTP_Auth));

		Wait.until(ExpectedConditions.elementToBeClickable(Submit_Btn)).click();
		Thread.sleep(1000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			} else {
				System.out.println("We are unable to click the Authorize_Chek CheckBox");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			} else {
				System.out.println("We are unable to click the Save_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void CM_RePledge_Request_Confirm_Checker() throws InterruptedException {

		Margin_Pledge_Btn.click();

		CM_RePledge_Request_Confirm_Btn.click();

		Search_Txt.sendKeys(CM_RePledge_Request.CM_pledge_Req_No);
		// Search_Txt.sendKeys("CMReplgRequMkr");
		Thread.sleep(1000);
		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_Btn click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			} else {
				System.out.println("We are unable to click the Authorize_Chek CheckBox");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			} else {
				System.out.println("We are unable to click the Save_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void CC_Margin_DePledge_Request_Checker() throws InterruptedException {
		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(CC_DePledge_Request_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(CC_Margin_DePledge_Request.CC_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void CM_Margin_DePledge_Request_Checker() throws InterruptedException {
		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(CC_DePledge_Request_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(CM_Margin_DePledge_Request.CM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void TM_Margin_DePledge_Request_Checker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Thread.sleep(1000);
		TM_DePledge_Request_Btn.click();

		/*
		 * try { if (TM_DePledge_Request_Btn.isDisplayed()) {
		 * Wait.until(ExpectedConditions.elementToBeClickable(TM_DePledge_Request_Btn)).
		 * click(); } } catch (ElementClickInterceptedException e) { System.out.
		 * println("Normal click failed,TM_DePledge_Request_Btn trying JavaScript  click..."
		 * ); js.executeScript("arguments[0].click();", TM_DePledge_Request_Btn); }
		 * catch (NoSuchElementException e) {
		 * System.out.println("TM_DePledge_Request_Btn not found: " + e.getMessage()); }
		 * catch (Exception e) {
		 * System.out.println("Unexpected error for TM_DePledge_Request_Btn: " +
		 * e.getMessage()); }
		 */

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(TM_Margin_DePledge_Request.TM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void Pledgor_CC_Margin_DePledge_Request_Checker() {

	}

	public void Pledgor_CC_Margin_DePledge_Request_Confirm_Checker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(CC_DePledge_Confirm_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(CM_Margin_DePledge_Request.CM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void Pledgor_CM_Margin_DePledge_Request_Checker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(CC_DePledge_Request_Btn_1)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(CM_Margin_DePledge_Request.CM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void Pledgor_CM_Margin_DePledge_Request_Confirm_Checker() throws InterruptedException {
		
		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(CM_DePledge_Confirm_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(TM_Margin_DePledge_Request.TM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void Pledgor_TM_Margin_DePledge_Request_Checker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		 CM_DePledge_Request_Btn.click();

		/*try {
			if (CM_DePledge_Request_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(CM_DePledge_Request_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,CM_DePledge_Request_Btn trying JavaScript  click...");
			js.executeScript("arguments[0].click();", CM_DePledge_Request_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("CM_DePledge_Request_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for CM_DePledge_Request_Btn: " + e.getMessage());
		}*/

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(TM_Margin_DePledge_Request.TM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

	public void Pledgor_TM_Margin_DePledge_Request_Confirm_Checker() throws InterruptedException {
		
		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		TM_DePledge_Confirm_Btn.click();

		/*try {
			if (CM_DePledge_Request_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(CM_DePledge_Request_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,CM_DePledge_Request_Btn trying JavaScript  click...");
			js.executeScript("arguments[0].click();", CM_DePledge_Request_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("CM_DePledge_Request_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for CM_DePledge_Request_Btn: " + e.getMessage());
		}*/

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(RP_Margin_DePledge_Request.RP_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}


	}

	public void Pledgor_RP_Margin_DePledge_Request_() throws InterruptedException {
		

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		TM_DePledge_Request_Btn.click();

		/*try {
			if (CM_DePledge_Request_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(CM_DePledge_Request_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,CM_DePledge_Request_Btn trying JavaScript  click...");
			js.executeScript("arguments[0].click();", CM_DePledge_Request_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("CM_DePledge_Request_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for CM_DePledge_Request_Btn: " + e.getMessage());
		}*/

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt))
				.sendKeys(RP_Margin_DePledge_Request.RP_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Actions_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", Actions_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Btn)).click();

		Thread.sleep(2000);
		try {
			if (Authorize_Chek.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chek)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorize_Chek JavaScript Authorize_Chek click...");
			js.executeScript("arguments[0].click();", Authorize_Chek);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_Chek not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_Chek: " + e.getMessage());
		}

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Save_Btn JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}
		
	}

	

}
