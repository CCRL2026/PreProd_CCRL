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

public class TM_Margin_DePledge_Request {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Depledge.xlsx";
	static String sheet = "TM De-Pledge Request";
	static int dataRow = 1; // row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	static long TM_Client_Id_DePledge = excel.getTM_Client_Id_DePledge(dataRow);
	static String TM_DePledge_Request_No = excel.getTM_DePledge_Request_No(dataRow);
	long ENWR_DePledge = excel.getTM_ENWR_DePledge(dataRow);
	long CM_Client_Id_DePledgeinTM = excel.CM_Client_Id_DePledgeinTM(dataRow);

	public TM_Margin_DePledge_Request(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	@FindBy(xpath = "//span[normalize-space()='TM De-Pledge Request']")
	WebElement TM_DePledge_Request_Btn;
	
	@FindBy(xpath="//span[normalize-space()='CM De-Pledge Request']")
	WebElement CM_DePledge_Request_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//input[@name='client_id']")
	WebElement client_id_Txt;

	@FindBy(xpath = "//input[@name='Pledge_Sequence_No']")
	WebElement Pledge_Sequence_No_txt;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Search_Btn;

	@FindBy(xpath = "(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]")
	WebElement Select_Btn;

	@FindBy(xpath = "//input[@name='pledge_Req_No']")
	WebElement pledge_Req_No_Txt;

	@FindBy(xpath = "//button[@id='TransctionStmt']")
	WebElement TransctionStmt_Btn;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Search...']")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@ng-click='vm.GetDetails()']")
	WebElement Search_ENW_Btn;

	@FindBy(xpath = "(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]")
	WebElement Select_ENW_Btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Btn;

	public void TM_Margin_DePledge_Request_Maker() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Margin_Pledge_Btn click...");
			js.executeScript("arguments[0].click();", Margin_Pledge_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Margin_Pledge_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Margin_Pledge_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(TM_DePledge_Request_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,TM_DePledge_Request_Btn trying JavaScript  click...");
			js.executeScript("arguments[0].click();", TM_DePledge_Request_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("TM_DePledge_Request_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for TM_DePledge_Request_Btn: " + e.getMessage());
		}

		New_Btn.click();

		try {
			if (String.valueOf(CM_Client_Id_DePledgeinTM).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(client_id_Txt))
						.sendKeys(String.valueOf(CM_Client_Id_DePledgeinTM));
			} else {
				System.out.println("Invalid TM_Client_Id_DePledge. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,TM_Client_Id_DePledge trying JavaScript  click...");
			js.executeScript("arguments[0].value='" + CM_Client_Id_DePledgeinTM + "';", client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("TM_Client_Id_DePledge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for TM_Client_Id_DePledge: " + e.getMessage());
		}

		try {
			if (String.valueOf(CC_Margin_DePledge_Request.Pledge_Sequence_No).matches("^[0-9]{0,4}$")) {
				Pledge_Sequence_No_txt.sendKeys(String.valueOf(CC_Margin_DePledge_Request.Pledge_Sequence_No));
			} else {
				System.out.println("Invalid Pledge_Sequence_No. Please enter 4 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Pledge_Sequence_No JavaScript click...");
			js.executeScript("arguments[0].value='" + CC_Margin_DePledge_Request.Pledge_Sequence_No + "';",
					client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("client_id_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for client_id_Txt: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Select_Btn)).click();
		Thread.sleep(1000);

		Wait.until(ExpectedConditions.elementToBeClickable(pledge_Req_No_Txt)).sendKeys(TM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(TransctionStmt_Btn)).click();

		try {
			if (String.valueOf(Margin_Pledge_Request.ENWR).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt)).sendKeys(String.valueOf(ENWR_DePledge));
			} else {
				System.out.println("Invalid Deposite. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_Txt click...");
			js.executeScript("arguments[0].value='" + ENWR_DePledge + "';", Search_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Txt: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_ENW_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Select_ENW_Btn)).click();

		Thread.sleep(2000);

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

	public void Pledgor_TM_Margin_DePledge_Request_Maker() throws InterruptedException {
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Margin_Pledge_Btn click...");
			js.executeScript("arguments[0].click();", Margin_Pledge_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Margin_Pledge_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Margin_Pledge_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(CM_DePledge_Request_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,TM_DePledge_Request_Btn trying JavaScript  click...");
			js.executeScript("arguments[0].click();", CM_DePledge_Request_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("TM_DePledge_Request_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for TM_DePledge_Request_Btn: " + e.getMessage());
		}

		New_Btn.click();

		try {
			if (String.valueOf(CM_Client_Id_DePledgeinTM).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(client_id_Txt))
						.sendKeys(String.valueOf(CM_Client_Id_DePledgeinTM));
			} else {
				System.out.println("Invalid TM_Client_Id_DePledge. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,TM_Client_Id_DePledge trying JavaScript  click...");
			js.executeScript("arguments[0].value='" + CM_Client_Id_DePledgeinTM + "';", client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("TM_Client_Id_DePledge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for TM_Client_Id_DePledge: " + e.getMessage());
		}

		try {
			if (String.valueOf(CM_Margin_DePledge_Request.Pledge_Sequence_NoinCM).matches("^[0-9]{0,4}$")) {
				Pledge_Sequence_No_txt.sendKeys(String.valueOf(CM_Margin_DePledge_Request.Pledge_Sequence_NoinCM));
			} else {
				System.out.println("Invalid Pledge_Sequence_No. Please enter 4 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Pledge_Sequence_No JavaScript click...");
			js.executeScript("arguments[0].value='" + CM_Margin_DePledge_Request.Pledge_Sequence_NoinCM + "';",
					client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("client_id_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for client_id_Txt: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Select_Btn)).click();
		Thread.sleep(1000);

		Wait.until(ExpectedConditions.elementToBeClickable(pledge_Req_No_Txt)).sendKeys(TM_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(TransctionStmt_Btn)).click();

		try {
			if (String.valueOf(Margin_Pledge_Request.ENWR).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt)).sendKeys(String.valueOf(ENWR_DePledge));
			} else {
				System.out.println("Invalid Deposite. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_Txt click...");
			js.executeScript("arguments[0].value='" + ENWR_DePledge + "';", Search_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Txt: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_ENW_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Select_ENW_Btn)).click();

		Thread.sleep(2000);

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
