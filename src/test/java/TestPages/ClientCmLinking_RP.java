package TestPages;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class ClientCmLinking_RP {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TM_CM_Linking.xlsx";
	static String sheet = "ClientCmLinking_RP";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	int RequestNo = excel.getRequestNo_ClientCmLinking(dataRow);
	int UCC_ID = excel.getUCC_ID(dataRow);
	static long Client_Id = excel.getClient_Id_ClientCmLinking(dataRow);
	String  TMID = excel.getTMID_ClientCmLinking(dataRow);
	int CeCcID =excel.getCeCcID_ClientCmLinking(dataRow);
	/*
	int RequestNo = 1111;
	int UCC_ID =100110;
			long Client_Id = 100673000090921L;
					String  TMID =TM0521;
	
	*/
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ClientCmLinking_RP(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//span[normalize-space()='Masters'])[1]")
	WebElement Masters_btn;
	// span[normalize-space()='Client CM Linking']
	@FindBy(xpath = "//span[normalize-space()='Client CM Linking']")
	WebElement Client_CM_Linking_bttn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_bttn;

	@FindBy(xpath = "//input[@name='RequestNo']")
	WebElement RequestNo_txt;

	@FindBy(xpath = "//input[@id='Request_Date']")
	WebElement Request_Date_bttn;

	@FindBy(xpath = "(//td[@class='today active start-date active end-date in-range available'])[1]")
	WebElement Today_dates;
	// (//td[@class='today weekend active start-date active end-date available'])[1]
	// td[@class='today weekend active start-date active end-date available']
	@FindBy(xpath = "//td[@class='today weekend active start-date active end-date available']")
	WebElement WeekEnd_Date;

	@FindBy(xpath = "//button[@title='NOTHING SELECTED']")
	WebElement Client_Id_bttn;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement Client_Id_txt;

	@FindBy(xpath="//select[@id='CeCcId']")
	WebElement CeCcId_bttn;
	
	@FindBy(xpath = "//input[@name='ucc']")
	WebElement UCC_txt;

	@FindBy(xpath = "(//button[normalize-space()='...'])[1]")
	WebElement openPick_bttn;

	@FindBy(xpath = "//div[contains(@class,'modal-body')]//input[contains(@placeholder,'Search...')]")
	WebElement Search_txt;

	@FindBy(xpath = "//button[contains(@ng-click,'vm.GetDetails()')]")
	WebElement Search_bttn;

	@FindBy(xpath = "(//button[contains(@ng-click,'grid.appScope.selectItem(row.entity)')][normalize-space()='Select'])[1]")
	WebElement Select_bttn;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify Fields')]")
	WebElement Verify_Button;

	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement Save_Button;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement Yes_Popup;
	
	

	public void Client_Cm() throws InterruptedException {

		try {
			if (Masters_btn.isDisplayed()) {
				Thread.sleep(2000);
				Wait.until(ExpectedConditions.elementToBeClickable(Masters_btn)).click();
			} else {
				System.out.println("Masters_btn is not visible");
			}

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Masters_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}

		Client_CM_Linking_bttn.click();

		New_bttn.click();

		RequestNo_txt.sendKeys(String.valueOf(RequestNo));

		Wait.until(ExpectedConditions.elementToBeClickable(Request_Date_bttn)).click();

		DayOfWeek today = LocalDateTime.now().getDayOfWeek();
		if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY) {
			// Click on Weekend date button
			WebElement weekendButton = Wait.until(ExpectedConditions.elementToBeClickable(WeekEnd_Date));
			Wait.until(ExpectedConditions.elementToBeClickable(weekendButton)).click();
			System.out.println("Weekend button clicked");
		} else {
			// Click on Today date button
			WebElement todayButton = Wait.until(ExpectedConditions.elementToBeClickable(Today_dates));
			Wait.until(ExpectedConditions.elementToBeClickable(todayButton)).click();
			System.out.println("Today date button clicked");
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Client_Id_bttn)).click();
		Thread.sleep(2000);
		Client_Id_txt.sendKeys(String.valueOf(Client_Id));
		Client_Id_txt.sendKeys(Keys.ENTER);

		//CeCcId_bttn.click();
		
		
		Select CECC = new Select(CeCcId_bttn);
		CECC.selectByContainsVisibleText(String.valueOf(CeCcID));
		//CECC.deSelectByContainsVisibleText(String.valueOf(CeCcID));
		
		UCC_txt.sendKeys(String.valueOf(UCC_ID));

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(openPick_bttn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", openPick_bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		

		Search_txt.sendKeys(String.valueOf(TMID));

		Search_bttn.click();

		Select_bttn.click();

		try {
			if (Verify_Button.isEnabled()) {
				Verify_Button.click();
			} else {
				System.out.println("Verify_Button is not enable");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_Button click...");
			js.executeScript("arguments[0].click();", Verify_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

		try {
			if (Save_Button.isDisplayed()) {
				Save_Button.click();
			} else {
				System.out.println("Save_Button is not Visible ");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
		
		try {
			if (Yes_Popup.isDisplayed()) {
				Yes_Popup.click();
			} else {
				System.out.println("Save_Button is not Visible ");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Yes_Popup);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

	}

}
