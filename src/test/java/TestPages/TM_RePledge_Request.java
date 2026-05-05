package TestPages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class TM_RePledge_Request {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Pledge.xlsx";
	static String sheet = "TM_RePledge_Request";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	// public int ce_cc_id_Release = excel.getce_cc_id_Pay_Out_Release(dataRow); //
	// 11;
	//public static String Margin_pledge_Req_No = "67676767";
	long TM_Client_Id = excel.getTM_Client_Id(dataRow); //100673000099997L;
	static String TM_pledge_Req_No= excel.getTM_pledge_Req_No(dataRow); //"abhi121";
	//static long ENWR = 110000005360L;

	public TM_RePledge_Request(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Margin_Pledge_Request creation
	// process-------------

	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='TM Re-Pledge Request']")
	WebElement TM_RePledge_Request_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//input[@name='client_id']")
	WebElement client_id_Txt;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement Search_Btn;
	
	@FindBy(xpath="(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]")
	WebElement Select_Btn;
	
	@FindBy(xpath="//input[@name='pledge_Req_No']")
	WebElement pledge_Req_No_Txt;
	
	@FindBy(xpath="//button[@id='TransctionStmt']")
	WebElement TransctionStmt_Btn;
	
	@FindBy(xpath="//div[@class='modal-body']//input[@placeholder='Search...']")
	WebElement Search_Txt;
	
	@FindBy(xpath="//button[@ng-click='vm.GetDetails()']")
	WebElement Search_ENW_Btn;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement Save_Btn;
	
	

	public void TM_RePledge_Request_Maker() throws InterruptedException {

		Margin_Pledge_Btn.click();

		TM_RePledge_Request_Btn.click();

		New_Btn.click();

		try {
			if (String.valueOf(TM_Client_Id).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(client_id_Txt)).sendKeys(String.valueOf(TM_Client_Id));
			} else {
				System.out.println("Invalid Deposite. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript client_id_Txt click...");
			js.executeScript("arguments[0].value='" + TM_Client_Id + "';", client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("client_id_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for client_id_Txt: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Select_Btn)).click();
		Thread.sleep(1000);
		
		Wait.until(ExpectedConditions.elementToBeClickable(pledge_Req_No_Txt)).sendKeys(TM_pledge_Req_No);
		
		
		Wait.until(ExpectedConditions.elementToBeClickable(TransctionStmt_Btn)).click();
		
		try {
			if (String.valueOf(Margin_Pledge_Request.ENWR).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt)).sendKeys(String.valueOf(Margin_Pledge_Request.ENWR));
			} else {
				System.out.println("Invalid Deposite. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_Txt click...");
			js.executeScript("arguments[0].value='" + Margin_Pledge_Request.ENWR + "';", Search_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Txt: " + e.getMessage());
		}

		Search_ENW_Btn.click();
		
		Select_Btn.click();
		
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
