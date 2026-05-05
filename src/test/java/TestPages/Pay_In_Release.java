package TestPages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class Pay_In_Release {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\PayIn_PayOut.xlsx";
	static String sheet = "Pay_In_Release";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	public int ce_cc_id_Release = excel.getce_cc_id_Pay_Out_Release(dataRow); // 11;
	public long Settelment_No_Release = excel.getSettelment_No_Pay_Out_Release(dataRow); // 43562789027L;
	public String commodity_Master_Id_Release = excel.getcommodity_Master_Id_Pay_Out_Release(dataRow); // "All";

	public Pay_In_Release(WebDriver driver, WebDriverWait Wait) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Depledge_Request creation process-------------
	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transactions_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='PayIn Release']")
	WebElement PayIn_Release_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//select[@name='value']")
	WebElement CE_CC_ID_Btn;

	@FindBy(xpath = "//button[@id='TransctionStlmt']")
	WebElement TransctionStlmt_Btn;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@class='btn default']")
	WebElement Search_Btn;

	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select_Btn;

	@FindBy(xpath = "//select[@name='commoitity_Master_Id']")
	WebElement commodity_Master_Id_Btn;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement Commodity_Pay_In_Txt;

	@FindBy(xpath = "(//a[@class='ng-binding ng-scope'])[1]")
	WebElement Commodity_Pay_In_Option;

	@FindBy(xpath = "//input[@id='uploaderSIGN']")
	WebElement uploaderSIGN_Btn;

	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope' and @type='submit']")
	WebElement Start_Process_Btn;

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Ok_btn;
	
	@FindBy(xpath = "(//button[@class='btn btn-default btn-xs ng-isolate-scope'][normalize-space()='Download'])[1]")
	WebElement Download_Btn;


	public void Pay_In_Release_Request() throws InterruptedException {

		Transactions_Btn.click();

		PayIn_Release_Btn.click();

		New_Btn.click();

		Select SK = new Select(CE_CC_ID_Btn);
		SK.selectByContainsVisibleText(String.valueOf(ce_cc_id_Release));

		TransctionStlmt_Btn.click();

		Search_Txt.sendKeys(String.valueOf(Settelment_No_Release));
		Thread.sleep(1000);
		Search_Btn.click();
		Thread.sleep(1000);
		Select_Btn.click();
		Thread.sleep(1000);
		Select SL = new Select(commodity_Master_Id_Btn);
		SL.selectByContainsVisibleText(commodity_Master_Id_Release);

		// uploaderSIGN_Btn.click();

		try {
			// WebElement hiddenInput = driver.findElement(By.cssSelector("#files"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploaderSIGN_Btn);
			uploaderSIGN_Btn.sendKeys("C:\\Users\\abhishekyt\\Desktop\\payRealease.csv");
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("❌ uploaderSIGN_Btn upload failed: " + e.getMessage());
		}

		try {
			if (Start_Process_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Start_Process_Btn)).click();
			} else {
				System.out.println("We are unable to click the Start_Process_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Start_Process_Btn click...");
			js.executeScript("arguments[0].click();", Start_Process_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Start_Process_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Start_Process_Btn: " + e.getMessage());
		}
		try {
			if (Ok_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Ok_btn)).click();
			} else {
				System.out.println("We are unable to click the Ok_btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Ok_btn click...");
			js.executeScript("arguments[0].click();", Ok_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Ok_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Ok_btn: " + e.getMessage());
		}

		Thread.sleep(1000);
		try {
			if (Download_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Download_Btn)).click();
			} else {
				System.out.println("We are unable to click the Download_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Download_Btn click...");
			js.executeScript("arguments[0].click();", Download_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Download_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Download_Btn: " + e.getMessage());
		}
		
		
	}

}
