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

public class RP_Margin_DePledge_Request {
	
	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Depledge.xlsx";
	static String sheet = "RP_Margin_DePledge_Request";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	long TM_Client_Id_DePledge = excel.getTM_Client_Id_DePledgeinRP(dataRow); // 180000110000033L;
	public static  int RP_Pledge_Sequence_No = excel.getRP_Pledge_Sequence_No(dataRow);
	static String RP_DePledge_Request_No = excel.getRP_DePledge_Request_No(dataRow);
	long RP_ENWR_DePledge = excel.getRP_ENWR_DePledge(dataRow);
	static long  RP_Client_Id_DePledge =  excel.getRP_Client_Id_DePledge(dataRow);

	public RP_Margin_DePledge_Request(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	@FindBy(xpath = "//span[normalize-space()='TM De-Pledge Request']")
	WebElement TM_DePledge_Request_Btn;

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

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Btn;

	public void RP_Margin_DePledge_Request_Maker() throws InterruptedException {

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

		//Wait.until(ExpectedConditions.elementToBeClickable(TM_DePledge_Request_Btn)).click();
		TM_DePledge_Request_Btn.click();
		New_Btn.click();

		try {
			if (String.valueOf(TM_Client_Id_DePledge).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(client_id_Txt))
						.sendKeys(String.valueOf(TM_Client_Id_DePledge));
			} else {
				System.out.println("Invalid CC_Client_Id_DePledge. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript client_id_Txt click...");
			js.executeScript("arguments[0].value='" + TM_Client_Id_DePledge + "';", client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("client_id_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for client_id_Txt: " + e.getMessage());
		}
		try {
			if (String.valueOf(RP_Pledge_Sequence_No).matches("^[0-9]{0,4}$")) {
				Pledge_Sequence_No_txt.sendKeys(String.valueOf(RP_Pledge_Sequence_No));
			} else {
				System.out.println("Invalid Pledge_Sequence_No. Please enter 3 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Pledge_Sequence_No_txt JavaScript  click...");
			js.executeScript("arguments[0].value='" + RP_Pledge_Sequence_No + "';", Pledge_Sequence_No_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Pledge_Sequence_No_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for client_id_Txt: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Select_Btn)).click();
		Thread.sleep(1000);

		Wait.until(ExpectedConditions.elementToBeClickable(pledge_Req_No_Txt)).sendKeys(RP_DePledge_Request_No);

		Wait.until(ExpectedConditions.elementToBeClickable(TransctionStmt_Btn)).click();

		try {
			if (String.valueOf(Margin_Pledge_Request.ENWR).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_Txt)).sendKeys(String.valueOf(RP_ENWR_DePledge));
			} else {
				System.out.println("Invalid Deposite. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_Txt click...");
			js.executeScript("arguments[0].value='" + RP_ENWR_DePledge + "';", Search_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Txt: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_ENW_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Select_Btn)).click();
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
