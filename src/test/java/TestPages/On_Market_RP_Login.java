package TestPages;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
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

public class On_Market_RP_Login {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ON_Market.xlsx";
	static String sheet = "OnMarket";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	String PayinType = excel.getPayinType(dataRow);
	int Instr_Slip_No = excel.getInstr_Slip_On_Market(dataRow);
	int WSP_Id = excel.getWSP_Id_On_Market(dataRow);
	int WH_Id = excel.getWH_Id_On_Market(dataRow);
	int Commodity = excel.getCommodity_On_Market(dataRow);
	long Client_Id = excel.getClient_Id_On_Market(dataRow);
	int UCC_Id = excel.getUCC_Id_On_Market(dataRow);
	long TM_Id = excel.getTM_Id(dataRow);
	String CM_Id = excel.getCM_Id(dataRow);
	long Settlement_No = excel.getSettlement_No(dataRow);
	long ENWR_No = excel.getENWR_No(dataRow);
	int no_of_bags_On_Market=excel.getno_of_bags_On_Market(dataRow);
	int deliveryunit =excel.getdeliveryunit_On_Market(dataRow);

	public On_Market_RP_Login(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for On_Market_RP_Login creation
	// process-------------
	// a[@class='auto ng-scope']//span[@class='title
	// ng-binding'][normalize-space()='Transactions']
	// span[normalize-space()='Transactions']
	// a[@class='auto ng-scope']//span[@class='title
	// ng-binding'][normalize-space()='Transactions']
	// (//span[@class='title ng-binding'][normalize-space()='Transactions'])[1]
	@FindBy(xpath = "//a[@class='auto ng-scope']//span[@class='title ng-binding'][normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "//span[normalize-space()='OnMarket']")
	WebElement OnMarket_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//select[@placeholder='mm']")
	WebElement PayinType_Drop;

	@FindBy(xpath = "//input[@name='Instr_Slip_No']")
	WebElement Instr_Slip_No_txt;

	@FindBy(xpath = "//input[@id='Request_Date']")
	WebElement Request_Date_btn;

	@FindBy(xpath = "//td[@class='today active start-date active end-date in-range available']")
	WebElement Today_dates;
	// (//td[@class='today weekend active start-date active end-date available'])[1]
	// td[@class='today weekend active start-date active end-date available']
	@FindBy(xpath = "//td[@class='today weekend active start-date active end-date available']")
	WebElement WeekEnd_Date;

	@FindBy(xpath = "//button[@data-id='WspMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement WSP_Id_btn;

	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement WSP_Id_txt;

	@FindBy(xpath = "//button[@data-id='WhMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement WH_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement WH_Id_txt;

	@FindBy(xpath = "//button[@data-id='CommodityMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Commodity_Btn;

	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement Commodity_Txt;

	@FindBy(xpath = "//button[@data-id='ClientMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Client_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement Client_Id_Txt;

	@FindBy(xpath = "//button[@data-id='ucc']")
	WebElement UCC_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement UCC_Id_txt;

	@FindBy(xpath = "//button[@data-id='tm_IdCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement TM_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[15]")
	WebElement TM_Id_Txt;

	@FindBy(xpath = "//button[@data-id='cm_IdCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement CM_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[17]")
	WebElement CM_Id_Txt;

	@FindBy(xpath = "(//button[@id='TransctionStlmt'])[1]")
	WebElement TransctionStlmt;

	@FindBy(xpath = "(//input[@placeholder='Search...'])[1]")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@ng-click='vm.GetDetails()']")
	WebElement Search_Btn;

	@FindBy(xpath = "(//button[normalize-space()='Select'])[1]")
	WebElement Select_Btn;
	
	@FindBy(xpath="//button[@data-id='deliveryunitSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement deliveryunitSelectionCombobox_btn;
	
	@FindBy(xpath="(//input[@type='text'])[28]")
	WebElement deliveryunitSelectionCombobox_Txt;
	
	@FindBy(xpath="//button[@id='TransctionStmt']")
	WebElement TransctionStmt;

	@FindBy(xpath="(//button[normalize-space()='Select'])[1]")
	WebElement Select_ENWR;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement OK_ENWR;
	
	@FindBy(xpath="//input[@ng-model='personalDetailQP.prev_no_of_bags']")
	WebElement prev_no_of_bags;
	
	@FindBy(xpath="//input[@name='no_of_bags']")
	WebElement no_of_bags_txt;
	
	@FindBy(xpath = "//button[@button-busy='vm.saving']")
	WebElement Saving_Btn;
	

	public void On_Market() throws InterruptedException {
		// Thread.sleep(2000);
		try {
			// if (Transaction_Btn.isDisplayed()) {
			Transaction_Btn.click();
			// Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
			/*
			 * } else { System.out.println("Transaction_Btn is not visible"); }
			 */
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			// if (OnMarket_Btn.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(OnMarket_Btn)).click();
			/*
			 * } else { System.out.println("OnMarket_Btn is not visible"); }
			 */
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying OnMarket_Btn click...");
			js.executeScript("arguments[0].click();", OnMarket_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("OnMarket_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for OnMarket_Btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			// if (New_Btn.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(New_Btn)).click();
			/*
			 * } else { System.out.println("New_Btn is not visible"); }
			 */
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying New_Btn click...");
			js.executeScript("arguments[0].click();", New_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("New_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_Btn: " + e.getMessage());
		}
		Select Pay = new Select(PayinType_Drop);
		Pay.selectByVisibleText(PayinType);

		Instr_Slip_No_txt.click();
		Instr_Slip_No_txt.sendKeys(String.valueOf(Instr_Slip_No));

		Request_Date_btn.click();

		DayOfWeek today = LocalDateTime.now().getDayOfWeek();

		if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY) {
			// Click on Weekend date button
			WebElement weekendButton = Wait.until(ExpectedConditions.elementToBeClickable(WeekEnd_Date));
			weekendButton.click();
			System.out.println("Weekend button clicked");
		} else {
			// Click on Today date button
			WebElement todayButton = Wait.until(ExpectedConditions.elementToBeClickable(Today_dates));
			todayButton.click();
			System.out.println("Today date button clicked");
		}
		try {
			if (String.valueOf(WSP_Id).matches("^[0-9]{0,7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_Id_btn)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_Id_txt)).sendKeys(String.valueOf(WSP_Id));
				Thread.sleep(1000);
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_Id_txt)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid WSP_ID. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", WSP_Id_btn);
			js.executeScript("arguments[0].value='" + WSP_Id + "';", WSP_Id_txt);
			js.executeScript("arguments[0].click();", WSP_Id_txt);
			// WSP_ID_txt.click();
		} catch (NoSuchElementException e) {
			System.out.println("WSP_ID_btn not found: " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Unexpected error for WSP_ID_btn: " + e.getMessage());
		}
		try {
			if (String.valueOf(WH_Id).matches("^[0-9]{7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(WH_Id_Btn)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(WH_Id_txt)).sendKeys(String.valueOf(WH_Id));
				Thread.sleep(1000);
				Wait.until(ExpectedConditions.elementToBeClickable(WH_Id_txt)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid WH_ID. Please enter  7 alphanumeric characters.");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript WH_ID_Btn click...");
			WebElement WH_ID_JAVA = driver.findElement(
					By.xpath("(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[3]"));
			js.executeScript("arguments[0].scrollIntoView(true)", WH_ID_JAVA);
			js.executeScript("arguments[0].click();", WH_Id_Btn);
			js.executeScript("arguments[0].value='" + WH_Id + "';", WH_Id_txt);
			js.executeScript("arguments[0].click();", WH_Id_txt);
			// AC.click();
		} catch (NoSuchElementException e) {
			System.out.println("WH_ID_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WH_ID_Btn: " + e.getMessage());
		}
		Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Btn)).click();
		Commodity_Txt.sendKeys(String.valueOf(Commodity));
		Thread.sleep(1000);
		Commodity_Txt.sendKeys(Keys.ENTER);

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Client_Id_Btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Client_Id_Txt)).sendKeys(String.valueOf(Client_Id));
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(Client_Id_Txt)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Client_Id_Btn click...");
			// js.executeScript("arguments[0].scrollIntoView(true)", Client_Id_Btn);
			js.executeScript("arguments[0].click();", Client_Id_Btn);
			js.executeScript("arguments[0].value='" + Client_Id + "';", Client_Id_Txt);
			js.executeScript("arguments[0].click();", Client_Id_Txt);
			// AC.click();
		} catch (NoSuchElementException e) {
			System.out.println("WH_ID_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WH_ID_Btn: " + e.getMessage());
		}

		UCC_Id_Btn.click();
		UCC_Id_txt.sendKeys(String.valueOf(UCC_Id));
		Thread.sleep(1000);
		UCC_Id_txt.sendKeys(Keys.ENTER);

		TM_Id_Btn.click();
		TM_Id_Txt.sendKeys(String.valueOf(TM_Id));
		Thread.sleep(1000);
		TM_Id_Txt.sendKeys(Keys.ENTER);

		CM_Id_Btn.click();
		CM_Id_Txt.sendKeys(String.valueOf(CM_Id));
		Thread.sleep(1000);
		CM_Id_Txt.sendKeys(Keys.ENTER);

		TransctionStlmt.click();
		Thread.sleep(1000);
		try {
			Search_Txt.sendKeys(String.valueOf(Settlement_No));
			Thread.sleep(1000);
			Search_Btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying  Search_Txt click...");
			// js.executeScript("arguments[0].scrollIntoView(true)", Client_Id_Btn);
			// js.executeScript("arguments[0].click();", Client_Id_Btn);
			js.executeScript("arguments[0].value='" + Settlement_No + "';", Search_Txt);
			js.executeScript("arguments[0].click();", Search_Btn);
			// AC.click();
		} catch (NoSuchElementException e) {
			System.out.println("Search_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Txt: " + e.getMessage());
		}
		try {
			Select_Btn.click();
			Thread.sleep(1000);
			Select_Btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying  Select_Btn click...");
			js.executeScript("arguments[0].click();", Select_Btn);
			js.executeScript("arguments[0].click();", Select_Btn);

		} catch (NoSuchElementException e) {
			System.out.println("Select_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_Btn: " + e.getMessage());
		}
		
		try {
			deliveryunitSelectionCombobox_btn.click();
			deliveryunitSelectionCombobox_Txt.sendKeys(String.valueOf(deliveryunit));
			Thread.sleep(1000);
			deliveryunitSelectionCombobox_Txt.sendKeys(Keys.ENTER);
		}catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying  deliveryunitSelectionCombobox_btn click...");
			// js.executeScript("arguments[0].scrollIntoView(true)", Client_Id_Btn);
			 js.executeScript("arguments[0].click();", deliveryunitSelectionCombobox_btn);
			js.executeScript("arguments[0].value='" + deliveryunit + "';", deliveryunitSelectionCombobox_Txt);
			js.executeScript("arguments[0].click();", deliveryunitSelectionCombobox_Txt);
			// AC.click();
		} catch (NoSuchElementException e) {
			System.out.println("Search_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Txt: " + e.getMessage());
		}
		
		
		Thread.sleep(2000);
		TransctionStmt.click();
		Thread.sleep(1000);
		try {
		Search_Txt.sendKeys(String.valueOf(ENWR_No));
		Thread.sleep(1000);
		Search_Btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying  Search_Txt click...");
			js.executeScript("arguments[0].value='" + ENWR_No + "';", Search_Txt);
			js.executeScript("arguments[0].click();", Search_Btn);

		} catch (NoSuchElementException e) {
			System.out.println("Search_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Txt: " + e.getMessage());
		}
		Thread.sleep(2000);
		//Select_ENWR.click();
		try {
			Select_ENWR.sendKeys(Keys.ENTER);
			//Select_ENWR.click();
			/*
			 * Thread.sleep(1000); Select_ENWR.sendKeys(Keys.ENTER);
			 */
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying  Select_ENWR click...");
			js.executeScript("arguments[0].click();", Select_ENWR);
			//js.executeScript("arguments[0].click();", Select_ENWR);

		} catch (NoSuchElementException e) {
			System.out.println("Select_ENWR not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_ENWR: " + e.getMessage());
		}
		Thread.sleep(1000);
		Wait.until(ExpectedConditions.elementToBeClickable(OK_ENWR)).click();
		
		/*
		 * String prev_no_Bag=prev_no_of_bags.getText();
		 * System.out.println("prev_no_Bag is:"+prev_no_Bag);
		 */
		
		//no_of_bags_txt.sendKeys(prev_no_Bag);
		Wait.until(ExpectedConditions.elementToBeClickable(no_of_bags_txt)).sendKeys(String.valueOf(no_of_bags_On_Market));
		Thread.sleep(2000);
		try {
			if (Saving_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Saving_Btn)).click();
			} else {
				System.out.println("Saving_Btn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Saving_Btn click...");
			js.executeScript("arguments[0].click();", Saving_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Saving_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Saving_Btn: " + e.getMessage());
		}

	}
}
