package TestPages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class Margin_Pledge_Request {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Pledge.xlsx";
	static String sheet = "Margin_Pledge_Request";
	static int dataRow = 8; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	public static String Margin_pledge_Req_No = excel.getMargin_pledge_Req_No(dataRow);// "Margin1";
	static long Client_Id = excel.getClient_Id_Margin_Pledge_Request(dataRow);// 155000010000027L;
	String ucc_Id = excel.getucc_Id_Margin_Pledge_Request(dataRow);// "PR269MARGin";
	String tm_Id = excel.gettm_Id_Margin_Pledge_Request(dataRow);// "TM23213";
	String cm_Id = excel.getcm_Id_Margin_Pledge_Request(dataRow);// "CM23213";
	String ceccId = excel.getceccId_Margin_Pledge_Request(dataRow);// "11";
	int WHID = excel.getWHID_Margin_Pledge_Request(dataRow);// 1000421;
	String CommoditySeg = excel.getCommoditySeg_Margin_Pledge_Request(dataRow);// "Agricultural";
	int Commodity = excel.getCommodity_Margin_Pledge_Request(dataRow);// 15;
	static long ENWR = excel.get_ENWR_Margin_Pledge_Request(dataRow);// 110000005360L;
	int no_of_bags = excel.getno_of_bags_Margin_Pledge_Request(dataRow);// 50;
//100673000019391

	public Margin_Pledge_Request(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Margin_Pledge_Request creation
	// process-------------//

	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Margin Pledge Request']")
	WebElement Margin_Pledge_Request_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//input[@name='pledge_Req_No']")
	WebElement Margin_pledge_Req_No_txt;

	@FindBy(xpath = "//input[@name='execution_Date']")
	WebElement execution_Date_btn;

	@FindBy(xpath = "//td[@class='today active start-date active end-date in-range available']")
	WebElement Today_date;

	@FindBy(xpath = "//button[@id='s']")
	WebElement CLIENT_PICK_LIST_Btn;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Search...']")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@ng-click='vm.GetDetails()']")
	WebElement Search_Btn;

	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select_Btn;

	@FindBy(xpath = "//button[@data-id='ucc']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement ucc_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[14]")
	WebElement ucc_Id_Txt;

	@FindBy(xpath = "//button[@data-id='tm_IdCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement tm_IdCombobox_Btn;

	@FindBy(xpath = "(//input[@type='text'])[16]")
	WebElement tm_IdCombobox_Txt;

	@FindBy(xpath = "//button[@data-id='cm_IdCombobox']")
	WebElement cm_IdCombobox_Btn;

	@FindBy(xpath = "(//input[@type='text'])[18]")
	WebElement cm_IdCombobox_Txt;

	@FindBy(xpath = "//button[@data-id='ceccIdCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement ceccIdCombobox_Btn;

	@FindBy(xpath = "(//input[@type='text'])[20]")
	WebElement ceccIdCombobox_Txt;

	@FindBy(xpath = "//button[@data-id='WhMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement WhMasterSelection_Btn;

	@FindBy(xpath = "(//input[@type='text'])[23]")
	WebElement WhMasterSelection_Txt;

	@FindBy(xpath = "//button[@data-id='CommoditySegSelectionCombobox']//span[@class='filter-option pull-left']")
	WebElement CommoditySegSelectionCombobox_btn;

	@FindBy(xpath = "(//input[@type='text'])[30]")
	WebElement CommoditySegSelectionCombobox_Txt;

	@FindBy(xpath = "//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Commodity_Btn;

	@FindBy(xpath = "(//input[@type='text'])[31]")
	WebElement Commodity_Txt;

	@FindBy(xpath = "//input[@id='eff_Start_date']")
	WebElement eff_Start_date_Btn;

	@FindBy(xpath = "//button[@id='TransctionStmt']")
	WebElement TransctionStmt_Btn;

	@FindBy(xpath = "//input[@name='no_of_bags']")
	WebElement no_of_bags_Txt;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Btn;

	public void Margin_Pledge_Request_Maker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Request_Btn)).click();

		New_Btn.click();

		Margin_pledge_Req_No_txt.sendKeys(Margin_pledge_Req_No);

		Wait.until(ExpectedConditions.elementToBeClickable(execution_Date_btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Today_date)).click();

		CLIENT_PICK_LIST_Btn.click();

		Search_Txt.sendKeys(String.valueOf(Client_Id));

		Search_Btn.click();

		Select_Btn.click();

		try {

			ucc_Id_Btn.click();
			ucc_Id_Txt.sendKeys(ucc_Id);
			Thread.sleep(1000);
			ucc_Id_Txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", ucc_Id_Btn);
			js.executeScript("arguments[0].value='" + ucc_Id + "';", ucc_Id_Txt);
			js.executeScript("arguments[0].click();", ucc_Id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Deposite_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposite_No: " + e.getMessage());
		}

		try {

			tm_IdCombobox_Btn.click();
			Wait.until(ExpectedConditions.elementToBeClickable(tm_IdCombobox_Txt)).sendKeys(tm_Id);
			Thread.sleep(1000);
			tm_IdCombobox_Txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, tm_Id JavaScript click...");
			js.executeScript("arguments[0].click();", tm_IdCombobox_Btn);
			js.executeScript("arguments[0].value='" + tm_Id + "';", tm_IdCombobox_Txt);
			js.executeScript("arguments[0].click();", tm_IdCombobox_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("tm_Id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for tm_Id: " + e.getMessage());
		}

		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(cm_IdCombobox_Btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(cm_IdCombobox_Txt)).sendKeys(cm_Id);
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(cm_IdCombobox_Txt)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, cm_IdCombobox_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", cm_IdCombobox_Btn);
			js.executeScript("arguments[0].value='" + cm_Id + "';", cm_IdCombobox_Txt);
			js.executeScript("arguments[0].click();", cm_IdCombobox_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("cm_IdCombobox_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for cm_IdCombobox_Btn: " + e.getMessage());
		}
		try {
			ceccIdCombobox_Btn.click();
			Wait.until(ExpectedConditions.elementToBeClickable(ceccIdCombobox_Txt)).sendKeys(ceccId);
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(ceccIdCombobox_Txt)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, ceccIdCombobox_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", ceccIdCombobox_Btn);
			js.executeScript("arguments[0].value='" + ceccId + "';", ceccIdCombobox_Txt);
			js.executeScript("arguments[0].click();", ceccIdCombobox_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("ceccIdCombobox_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for ceccIdCombobox_Btn: " + e.getMessage());
		}

		try {
			WhMasterSelection_Btn.click();
			Wait.until(ExpectedConditions.elementToBeClickable(WhMasterSelection_Txt)).sendKeys(String.valueOf(WHID));
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(WhMasterSelection_Txt)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, WhMasterSelection_Btn JavaScript click...");
			js.executeScript("arguments[0].click();", WhMasterSelection_Btn);
			js.executeScript("arguments[0].value='" + WHID + "';", WhMasterSelection_Btn);
			js.executeScript("arguments[0].click();", WhMasterSelection_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("WhMasterSelection_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WhMasterSelection_Btn: " + e.getMessage());
		}
		try {

			CommoditySegSelectionCombobox_btn.click();
			Wait.until(ExpectedConditions.elementToBeClickable(CommoditySegSelectionCombobox_Txt)).sendKeys(CommoditySeg);
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(CommoditySegSelectionCombobox_Txt)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, CommoditySegSelectionCombobox_btn JavaScript click...");
			js.executeScript("arguments[0].click();", CommoditySegSelectionCombobox_btn);
			js.executeScript("arguments[0].value='" + CommoditySeg + "';", CommoditySegSelectionCombobox_Txt);
			js.executeScript("arguments[0].click();", CommoditySegSelectionCombobox_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Deposite_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposite_No: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Btn)).click();
		Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Txt)).sendKeys(String.valueOf(Commodity));
		Thread.sleep(1000);
		Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Txt)).sendKeys(Keys.ENTER);

		eff_Start_date_Btn.click();
		Today_date.click();

		TransctionStmt_Btn.click();

		Search_Txt.sendKeys(String.valueOf(ENWR));

		Search_Btn.click();

		Select_Btn.click();
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(no_of_bags_Txt)).sendKeys(String.valueOf(no_of_bags));

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
