package TestPages;

import java.time.Duration;
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

public class Withdrawal_Function {

	WebDriver driver;
	WebDriverWait Wait;

	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Withdrawal.xlsx";
	static String sheet = "Withdrawal_Request";
	static int dataRow = 1; // second row of data
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	/*
	 * public static int Withdrawal_Request_No = 9996059; public static int WH_ID =
	 * 5750013; public long Client_ID = 100673000000011L; public static long ENWR =
	 * 110001018628l; String Commodity_Segment="Agricultural";
	 */
	public static int Withdrawal_Request_No = excel.getWithdrawal_Request_No(dataRow);
	public static int WH_ID = excel.getWH_ID_Withdrawal(dataRow);
	String Commodity_Segment = excel.getCommodity_Segment_Withdrawal(dataRow);
	int Commodity_Code = excel.getCommodity_Code_Withdrawal(dataRow);
	public long Client_ID = excel.getClient_ID_Withdrawal(dataRow);
	public static long ENWR = excel.getENWR_Withdrawal(dataRow);
	static int noOfBag = excel.getnoOfBag_Withdrawal(dataRow);

	public Withdrawal_Function(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[normalize-space()='Transactions'])[1]")
	WebElement Transaction_Btn;

	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Withdrawal Request'])[1]")
	WebElement Withdrawal_Request;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Button;

	@FindBy(xpath = "//input[@id='WithdrawalRequestNo'  and  @ng-disabled='vm.DisableEdit'][1]")
	WebElement WithdrawalRequestNo;

	@FindBy(xpath = "(//input[@placeholder='dd/mm/yyyy'])[1]")
	WebElement Date_Selecter;

	@FindBy(xpath = "(//td[@class='today active start-date active end-date available'])[1]")
	WebElement Date;

	@FindBy(xpath = "(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement WH_ID_With;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement WH_ID_With_Txt;

	@FindBy(xpath = "(//select[@id='commodity_segment'])[1]")
	WebElement Commodity_Segment_txt;

	@FindBy(xpath = "//button[@data-id='CommodityMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Commodity_Code_bttn;

	// @FindBy(xpath="//button[@data-id='CommodityMasterSelectionCombobox']//span[@class='filter-option
	// pull-left'][normalize-space()='NOTHING SELECTED']")

	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement Commodity_Code_Txt;

	@FindBy(xpath = "//button[@data-id='ClientMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Client_ID_With;

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement Client_ID_With_Txt;

	@FindBy(xpath = "(//button[normalize-space()='...'])[1]")
	WebElement Warehouse_Receipt_No;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Search...']")
	WebElement Search_ENWR_With;

	@FindBy(xpath = "(//button[@ng-click='vm.GetDetails()'])[1]")
	WebElement Search_Button;

	@FindBy(xpath = "(//button[normalize-space()='Select'])[1]")
	WebElement Select_ENWR_Button;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement Ok_bttn;

	@FindBy(xpath = "//input[@name='noOfBag']")
	WebElement noOfBag_txt;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement verify_bttn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Bttn;

	public void Withdrawal_Request_RP() throws InterruptedException {

		Transaction_Btn.click();

		Withdrawal_Request.click();

		New_Button.click();

		if (String.valueOf(Withdrawal_Request_No).matches("^[a-zA-Z0-9]{0,16}$")) {
			WithdrawalRequestNo.sendKeys(String.valueOf(Withdrawal_Request_No));
		} else {
			System.out.println("Invalid Withdrawal_Request_No ");
		}
		Date_Selecter.click();

		Date.click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		try {
			if (String.valueOf(WH_ID).matches("^[a-zA-Z0-9]{0,7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With_Txt)).sendKeys((String.valueOf(WH_ID)));
				// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				// WH_ID_With_Txt.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With_Txt)).sendKeys(Keys.ENTER);
				Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With_Txt)).sendKeys(Keys.ENTER);
				// Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With_Txt)).sendKeys(Keys.ENTER);
				// WH_ID_With_Txt.click();
			} else {
				System.out.println("Invalid WH_ID ");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript WH_ID_Btn click...");
			js.executeScript("arguments[0].click();", WH_ID_With);
			js.executeScript("arguments[0].value='" + WH_ID + "';", WH_ID_With_Txt);
			js.executeScript("arguments[0].click();", WH_ID_With_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("WH_ID_With_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WH_ID_With_Txt: " + e.getMessage());
		}
//		finally {
//			Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With)).click();
//			Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With_Txt)).sendKeys((String.valueOf(WH_ID)));
//			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With_Txt)).sendKeys(Keys.ENTER);
//			Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_With_Txt)).click();
//		}
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Select Se = new Select(Commodity_Segment_txt);
		Se.selectByContainsVisibleText(Commodity_Segment);

		if (String.valueOf(Commodity_Code).matches("^[a-zA-Z0-9]{0,7}$")) {
			Commodity_Code_bttn.click();
			Commodity_Code_Txt.sendKeys(String.valueOf(Commodity_Code));
			Commodity_Code_Txt.sendKeys(Keys.ENTER);
			// Assert.assertTrue(false, "Something went wrong");
		} else {
			System.out.println("Invalid Commodity_Code ");
		}

		if (String.valueOf(Client_ID).matches("^[a-zA-Z0-9]{0,15}$")) {
			Client_ID_With.click();
			Client_ID_With_Txt.sendKeys((String.valueOf(Client_ID)));
			Client_ID_With_Txt.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Client_ID ");
		}
		Warehouse_Receipt_No.click();

		if (String.valueOf(ENWR).matches("^[a-zA-Z0-9]{0,15}$")) {
			Search_ENWR_With.sendKeys((String.valueOf(ENWR)));
		} else {
			System.out.println("Invalid Client_ID ");
		}
		Search_Button.click();
		Thread.sleep(4000);

		Select_ENWR_Button.click();

		Ok_bttn.click();

		noOfBag_txt.sendKeys(String.valueOf(noOfBag));

		try {
			if (verify_bttn.isDisplayed() && verify_bttn.isEnabled()) {
				verify_bttn.click();
			} else {
				System.out.println("verify_bttn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript verify_bttn click...");
			js.executeScript("arguments[0].click();", verify_bttn);
		} catch (NoSuchElementException e) {
			System.out.println("verify_bttn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for verify_bttn: " + e.getMessage());
		}
		try {
			if (Save_Bttn.isDisplayed() && Save_Bttn.isEnabled()) {
				Save_Bttn.click();
			} else {
				System.out.println("Save_Bttn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Bttn click...");
			js.executeScript("arguments[0].click();", Save_Bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Bttn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Bttn: " + e.getMessage());
		}
	}
}
