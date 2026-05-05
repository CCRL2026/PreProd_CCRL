package TestPages;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class Transfer_Request_RP_Maker {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Transfer.xlsx";
	static String sheet = "Transfer_Request";
	static int dataRow = 1; // second row of data
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	
	/*
	public static String Instr_Slip_No = "3456790";
	int WSP_ID = 9999996;
	int WH_ID = 1000421;
	int Commodity_Code = 1;
	Long Client_ID = 100673000000011L;
	Long targetClient_Id = 120733340001420L;
	Long ENWR = 110001023032L;
	int Bags = 100;
	String TransferReason = "GIFT";
*/

	public static String Instr_Slip_No = excel.getInstr_Slip_No(dataRow);
	int WSP_ID =excel.getWSP_ID(dataRow);
	int WH_ID = excel.getWH_ID(dataRow);
	int Commodity_Code =excel.getCommodity_Code(dataRow);
	long Client_ID =excel.getClient_ID_Transfer(dataRow);
	long targetClient_Id =excel.gettargetClient_Id_Transfer(dataRow);
	long ENWR =excel.getENWR_Transfer(dataRow);
	int Bags =excel.getBags_Transfer(dataRow);
	String TransferReason = excel.getTransferReason(dataRow);
	
	
	
	public Transfer_Request_RP_Maker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Bttn;

	@FindBy(xpath = "//a[@ui-sref='Transactions.Transfer']")
	WebElement Transfer_Bttn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Bttn;

	@FindBy(xpath = "//input[@name='Instr_Slip_No']")
	WebElement Instr_Slip_No_Txt;

	@FindBy(xpath = "//input[@id='Request_Date']")
	WebElement Request_Date;

	@FindBy(xpath = "//td[@class='today active start-date active end-date available']")
	WebElement today_active;

	@FindBy(xpath = "//td[@class='today weekend active start-date active end-date available']")
	WebElement WeekEnd_Date;

	@FindBy(xpath = "//input[@id='Execution_Date']")
	WebElement Execution_Date;

	@FindBy(xpath = "//button[@data-id='WspMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Wsp_Bttn;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement Wsp_Txt;

	@FindBy(xpath = "//button[@data-id='WhMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement WH_Bttn;

	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement WH_Txt;
	
	//Commodity Segment

	@FindBy(xpath = "//button[@data-id='CommodityMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Commodity_Bttn;

	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement Commodity_Txt;

	@FindBy(xpath = "//button[@data-id='ClientMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Client_Bttn;

	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement Client_Txt;

	@FindBy(xpath = "//input[@name='targetClient']")
	WebElement targetClient_Txt;

	@FindBy(xpath = "//button[@id='TransctionStmt']")
	WebElement TransctionStmt;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Search...']")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@ng-click='vm.GetDetails()']//i[@class='icon-magnifier']")
	WebElement Search_Bttn;

	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select_Bttn;

	@FindBy(xpath = "//input[@name='no_of_bags']")
	WebElement no_of_bags;

	@FindBy(xpath = "//button[@data-id='TransferReasonSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement TransferReason_Bttn;

	@FindBy(xpath = "(//input[@type='text'])[24]")
	WebElement TransferReason_Txt;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement Verify_Bttn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Bttn;

	public void Transfer_Request_Maker() {

		Transaction_Bttn.click();

		Transfer_Bttn.click();

		New_Bttn.click();

		if (Instr_Slip_No.matches("^[a-zA-Z0-9]{0,7}$")) {
			// Instr_Slip_No_Txt.click();
			Instr_Slip_No_Txt.sendKeys(Instr_Slip_No);
		} else {
			System.out.println("Invalid Instr_Slip_No Number");
		}

		Request_Date.click();
		DayOfWeek today = LocalDateTime.now().getDayOfWeek();
		if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY) {
			// Click on Weekend date button
			WebElement weekendButton = Wait.until(ExpectedConditions.elementToBeClickable(WeekEnd_Date));
			weekendButton.click();
			System.out.println("Weekend button clicked");
		} else {
			// Click on Today date button
			WebElement todayButton = Wait.until(ExpectedConditions.elementToBeClickable(today_active));
			todayButton.click();
			System.out.println("Today date button clicked");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Execution_Date.click();
		if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY) {
			// Click on Weekend date button
			WebElement weekendButton = Wait.until(ExpectedConditions.elementToBeClickable(WeekEnd_Date));
			weekendButton.click();
			System.out.println("Weekend button clicked");
		} else {
			// Click on Today date button
			WebElement Today = driver
					.findElement(By.xpath("//td[@class='today active start-date active end-date in-range available']"));
			WebElement todayButton = Wait.until(ExpectedConditions.elementToBeClickable(Today));
			todayButton.click();
			System.out.println("Today date button clicked");

			Wsp_Bttn.click();
			Wsp_Txt.sendKeys(String.valueOf(WSP_ID));
			Wsp_Txt.sendKeys(Keys.ENTER);

			WH_Bttn.click();
			WH_Txt.sendKeys(String.valueOf(WH_ID));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			WebElement Ac = driver.findElement(By.xpath("//li[@class='active']//a"));
			Ac.sendKeys(Keys.ENTER);

			
			
			Commodity_Bttn.click();
			Commodity_Txt.sendKeys(String.valueOf(Commodity_Code));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			WebElement Com = driver.findElement(By.xpath("//li[@class='active']//a"));
			Com.sendKeys(Keys.ENTER);

			Client_Bttn.click();
			Client_Txt.sendKeys(String.valueOf(Client_ID));
			Client_Txt.sendKeys(Keys.ENTER);

			targetClient_Txt.sendKeys(String.valueOf(targetClient_Id));

			TransctionStmt.click();

			Search_Txt.sendKeys(String.valueOf(ENWR));

			Search_Bttn.click();

			Select_Bttn.click();

			no_of_bags.sendKeys(String.valueOf(Bags));

			TransferReason_Bttn.click();

			TransferReason_Txt.sendKeys(TransferReason);
			TransferReason_Txt.sendKeys(Keys.ENTER);

			if (Verify_Bttn.isDisplayed() && Verify_Bttn.isEnabled()) {
				Verify_Bttn.click();
			} else {
				System.out.println("Verify_Bttn is not Visible");
			}
			if (Save_Bttn.isDisplayed() && Save_Bttn.isEnabled()) {
				Save_Bttn.click();
			} else {
				System.out.println("Save_Bttn is not Visible");
			}

		}
	}

}
