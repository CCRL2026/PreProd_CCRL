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
import Utillity.ExcelUtils;

public class Margin_Pledge_Request_Confirm {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Pledge.xlsx";
	static String sheet = "Pay_In_Release";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	// Variable Declaration
	String OTP_Auth;

	public Margin_Pledge_Request_Confirm(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Margin_Pledge_Request_Confirm creation
	// process-------------

	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	// a[@ui-sref='MarginPledges.marginpledgeApproval']
	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Margin Pledge Request Confirm']")
	WebElement Margin_Pledge_Request_Confirm_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//input[@name='client_id']")
	WebElement client_id_Txt;

	@FindBy(xpath = "//input[@name='commodity']")
	WebElement commodity_Txt;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Search_Btn;

	@FindBy(xpath = "(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]")
	WebElement Select_Btn;

	@FindBy(xpath = "//input[@name='auth_code']")
	WebElement auth_code_Txt;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit_Btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Btn;

	public void Margin_Pledge_Request_Confirm_Maker() throws InterruptedException {

		Margin_Pledge_Btn.click();

		Margin_Pledge_Request_Confirm_Btn.click();

		New_Btn.click();

		try {
			if (String.valueOf(Margin_Pledge_Request.Client_Id).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(client_id_Txt))
						.sendKeys(String.valueOf(Margin_Pledge_Request.Client_Id));
			} else {
				System.out.println("Invalid Deposite. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript client_id_Txt click...");
			js.executeScript("arguments[0].value='" + Margin_Pledge_Request.Client_Id + "';", client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("client_id_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for client_id_Txt: " + e.getMessage());
		}

		// commodity_Txt.sendKeys(String.valueOf(commodity));

		Search_Btn.click();

		Select_Btn.click();
		Thread.sleep(1000);

		try {
			Connection conn = DataBaseUtility.getConnection();

			String query_OTP = "SELECT a.auth_code FROM auth_code_generation a JOIN margin_pledge_request d ON a.ref_id = d.Id WHERE a.tran_type like '%MR' and d.Pledge_Req_No  like ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + Margin_Pledge_Request.Margin_pledge_Req_No + "%"); // bind the variable to query

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

		// auth_code_Txt.sendKeys(String.valueOf(OTP_Auth));
		Wait.until(ExpectedConditions.elementToBeClickable(auth_code_Txt)).sendKeys(String.valueOf(OTP_Auth));

		Wait.until(ExpectedConditions.elementToBeClickable(Submit_Btn)).click();
		Thread.sleep(1000);
		try {
			if (Save_Btn.isDisplayed()) {
				Save_Btn.click();
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

}
