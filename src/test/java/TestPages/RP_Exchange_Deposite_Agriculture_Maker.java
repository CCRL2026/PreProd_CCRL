package TestPages;

import java.time.Duration;

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

public class RP_Exchange_Deposite_Agriculture_Maker {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ENWR_Creation.xlsx";
	static String sheet = "RP_Exchange_Deposite_Agricultur";
	static int dataRow = 1; // second row of data
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	/*
	 * public String Commodity_Segment = "01 - Agriculture"; public static String
	 * Deposite = "5555502"; public String Client_ID = "100673000000011"; public
	 * static String WSP_ID = "9999996"; public static String WH_ID = "1000421";
	 * public String Deposit_Type = "Exchange"; public static String Commodity_Code
	 * = "15"; public static String bags = "700"; public String Bag_Size = "1.70";
	 * public String Bag_Type = "BALES"; public String Qty_UOM = "QUINTAL"; public
	 * String Bag_UOM = "QUINTAL"; public String exchange_Code = "11";
	 */

	public String Commodity_Segment = excel.getCommoditySegment_Ex(dataRow);
	public static String Deposite = excel.getDeposite_ex(dataRow);
	public String Client_ID = excel.getClientID_ex(dataRow);
	public String WSP_ID = excel.getWspID_ex(dataRow);
	public static String WH_ID = excel.getWhID_ex(dataRow);
	public String Deposit_Type = excel.getDepositType_ex(dataRow);
	public static String Commodity_Code = excel.getCommodityCode_ex(dataRow);
	public static String bags = excel.getBags_ex(dataRow);
	public static float Bag_Size = excel.getBagSize_ex(dataRow);
	public String Bag_Type = excel.getBagType_ex(dataRow);
	public String Qty_UOM = excel.getQtyUOM_ex(dataRow);
	public String Bag_UOM = excel.getBagUOM_ex(dataRow);
	public String exchange_Code = excel.getexchange_Code(dataRow);

	public RP_Exchange_Deposite_Agriculture_Maker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "//span[normalize-space()='Deposit Request']")
	WebElement Deposit_btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Deposite_Req;

	@FindBy(xpath = "//select[@id='CommoditySegmentSelectionCombobox']")
	WebElement Commodity_Segment_Code;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']")
	WebElement Commodity_Segment_Ok_btn;

	@FindBy(css = "input[name='DRN'][type='text']")
	WebElement Deposite_No;

	@FindBy(xpath = "//select[@id='Rp_Type ']")
	WebElement Deposit_Type_option;

	@FindBy(xpath = "(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement exchangeMaster;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement exchangeMaster_txt;
	// button[@data-id='WspMasterSelectionCombobox']//span[@class='filter-option
	// pull-left'][normalize-space()='NOTHING SELECTED']
	// (//button[@data-id='WspMasterSelectionCombobox'])[1]
	// label[text()='WSP Id']/following-sibling::div//button//span[text()='NOTHING
	// SELECTED']
	// button[@data-id='WspMasterSelectionCombobox']//span[@class='filter-option
	// pull-left'][normalize-space()='NOTHING SELECTED'][1]
	@FindBy(xpath = "//button[@data-id='WspMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'][1]")
	WebElement WSP_ID_btn;
	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement WSP_ID_txt;
	// label[text()='WH Id']/following-sibling::div//button//span[text()='NOTHING
	// SELECTED']
	@FindBy(xpath = "//label[text()='WH Id']/following-sibling::div//button//span[text()='NOTHING SELECTED']")
	WebElement WH_ID_Btn;

	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement WH_ID_txt;

	@FindBy(xpath = "(//span[@class='box'])[1]")
	WebElement Negotiable_eceipt_Required;

	@FindBy(xpath = "//label[normalize-space()='Assaying Required']")
	WebElement Assaying_Required;

	@FindBy(xpath = "//button[@data-id='ClientMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Client_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement Client_ID_txt;

	@FindBy(xpath = "(//button[@data-id='CommodityMasterSelectionCombobox'])[1]")
	WebElement Commodity_Code_btn;

	@FindBy(xpath = "(//input[@type='text'])[17]")
	WebElement Commodity_Code_txt;

	@FindBy(xpath = "(//input[@name='no_of_bags'])[1]")
	WebElement no_of_bags;

	@FindBy(xpath = "//button[@data-id='baguom']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Bag_UOM_btn;

	@FindBy(xpath = "(//input[@type='text'])[23]")
	WebElement Bag_UOM_txt;

	@FindBy(xpath = "(//button[@data-id='bagSize'])[1]")
	WebElement Bag_Size_btn;

	@FindBy(xpath = "(//input[@type='text'])[24]")
	WebElement Bag_Size_Text;

	@FindBy(xpath = "(//button[@data-id='qtyuom']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement Qty_UOM_btn;

	@FindBy(xpath = "(//input[@type='text'])[25]")
	WebElement Qty_UOM_Text;

	@FindBy(xpath = "(//button[@data-id='BagTypeSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement Bag_Type_btn;

	@FindBy(xpath = "(//input[@type='text'])[27]")
	WebElement Bag_Type_Text;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']")
	WebElement verify_btn;

	@FindBy(css = ".btn.btn-primary.blue.ng-isolate-scope")
	WebElement save_btn;

	@FindBy(xpath = "//div[@class='btn-group bootstrap-select form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-not-empty ng-dirty ng-valid-parse ng-valid ng-valid-required open']//li[@class='active']//a")
	WebElement WH;

	public void Exchange_Deposite_Request() {
		// Actions actions = new Actions(driver);

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Transaction Button to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		// Deposit function to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_btn: " + e.getMessage());
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(New_Deposite_Req)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", New_Deposite_Req);
		} catch (NoSuchElementException e) {
			System.out.println("New_Deposite_Req not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_Deposite_Req: " + e.getMessage());
		}
		// Commodity_Segment_Code
		// if (Commodity_Segment.matches("^[a-zA-Z0-9]{0,20}$")) {
		Select Sa = new Select(Commodity_Segment_Code);
		Sa.selectByContainsVisibleText(Commodity_Segment);

		// Commodity_Segment_Ok_btn
		try {
			Commodity_Segment_Ok_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Commodity_Segment_Ok_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Commodity_Segment_Ok_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Commodity_Segment_Ok_btn: " + e.getMessage());
		}
		try {
			if (Deposite.matches("^[a-zA-Z0-9]{0,10}$")) {
				Deposite_No.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Deposite_No)).sendKeys(Deposite);
				Deposite_No.click();
			} else {
				System.out.println("Invalid Deposite. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposite_No);
			js.executeScript("arguments[0].value='" + Deposite + "';", Deposite_No);
			js.executeScript("arguments[0].click();", Deposite_No);
		} catch (NoSuchElementException e) {
			System.out.println("Deposite_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposite_No: " + e.getMessage());
		}
		// Deposit_Type DropDown
		// if (Deposit_Type.matches("^[a-zA-Z0-9]{0-20}$")) {
		Deposit_Type_option.click();
		Select SB = new Select(Deposit_Type_option);
		SB.selectByContainsVisibleText(Deposit_Type);
		try {
			if (exchangeMaster.isDisplayed()) {
				if (exchange_Code.matches("^[0-9]{0,11}$")) {
					exchangeMaster.click();
					Wait.until(ExpectedConditions.elementToBeClickable(exchangeMaster_txt)).sendKeys(exchange_Code);
					exchangeMaster_txt.sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid exchange_Code. Please enter exactly 11 alphanumeric characters:");
				}
			} else {
				System.out.println("We are unable to click the exchangeMaster button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript exchangeMaster click...");
			js.executeScript("arguments[0].click();", exchangeMaster);
			js.executeScript("arguments[0].value='" + exchange_Code + "';", exchangeMaster_txt);
			js.executeScript("arguments[0].click();", exchangeMaster_txt);
		} catch (NoSuchElementException e) {
			System.out.println("exchangeMaster not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for exchangeMaster: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			if (WSP_ID.matches("^[a-zA-Z0-9]{7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_btn)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(String.valueOf(WSP_ID));
				Thread.sleep(1000);
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(Keys.ENTER);
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid WSP_ID. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", WSP_ID_btn);
			js.executeScript("arguments[0].value='" + WSP_ID + "';", WSP_ID_txt);
			js.executeScript("arguments[0].click();", WSP_ID_txt);
			// WSP_ID_txt.click();
		} catch (NoSuchElementException e) {
			System.out.println("WSP_ID_btn not found: " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Unexpected error for WSP_ID_btn: " + e.getMessage());
		}
		// WebElement AC =
		// driver.findElement(By.xpath("(//li[@class='active']//a)[2]"));
		try {
				if (WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_Btn)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(String.valueOf(WH_ID));
					Thread.sleep(1000);
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(Keys.ENTER);
					//Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(Keys.ENTER);
				}else {
					System.out.println("Invalid WH_ID. Please enter  7 alphanumeric characters.");
				}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript WH_ID_Btn click...");
			WebElement WH_ID_JAVA = driver.findElement(
					By.xpath("(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[3]"));
			js.executeScript("arguments[0].scrollIntoView(true)", WH_ID_JAVA);
			js.executeScript("arguments[0].click();", WH_ID_Btn);
			js.executeScript("arguments[0].value='" + WH_ID + "';", WH_ID_txt);
			js.executeScript("arguments[0].click();", WH_ID_txt);
			// AC.click();
		} catch (NoSuchElementException e) {
			System.out.println("WH_ID_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WH_ID_Btn: " + e.getMessage());
		}
	
		if (Negotiable_eceipt_Required.isDisplayed()) {
			Negotiable_eceipt_Required.click();
			Assaying_Required.isSelected();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Client_Id_Btn);
		try {
			if (Client_ID.matches("^[a-zA-Z0-9]{0,16}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Client_Id_Btn)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Client_ID_txt)).sendKeys(String.valueOf(Client_ID));
				Client_ID_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Client_ID. Please enter exactly 15 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Client_Id_Btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			js.executeScript("arguments[0].click();", Client_Id_Btn);
			js.executeScript("arguments[0].value='" + Client_ID + "';", Client_ID_txt);
			js.executeScript("arguments[0].click();", Client_ID_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Client_Id_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Client_Id_Btn: " + e.getMessage());
		}
		// 15-Catton Bales/111->Rabber
		try {
			if (Commodity_Code.matches("^[a-zA-Z0-9]{0,4}$")) {
				Commodity_Code_btn.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Code_txt)).sendKeys(Commodity_Code);
				Commodity_Code_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Commodity_Code. Please enter exactly 3 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Commodity_Code_btn click...");
			WebElement Commodity_Code_JAVA = driver
					.findElement(By.xpath("(//button[@data-id='CommodityMasterSelectionCombobox'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Commodity_Code_JAVA);
			Commodity_Code_txt.sendKeys(Commodity_Code);
			Commodity_Code_txt.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("Commodity_Code_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Commodity_Code_btn: " + e.getMessage());
		}
		try {
			if (bags.matches("^[0-9]{0,5}$")) {
				no_of_bags.sendKeys(bags);
			} else {
				System.out.println("Invalid bags. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + bags + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bags: " + e.getMessage());
		}
		try {
			if (Bag_UOM.length() <= 50) {
				Bag_UOM_btn.click();
				Bag_UOM_txt.sendKeys(Bag_UOM);
				Bag_UOM_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Bag_UOM. Please enter exactly 3 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Bag_UOM_btn click...");
			js.executeScript("arguments[0].click();", Bag_UOM_btn);
			js.executeScript("arguments[0].value='" + Bag_UOM + "';", Bag_UOM_txt);
			js.executeScript("arguments[0].click();", Bag_UOM_txt);

		} catch (NoSuchElementException e) {
			System.out.println("BagType not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for BagType: " + e.getMessage());
		}
		try {
			if (String.valueOf(Bag_Size).matches("^[0-9].{0,4}$")) {
				Bag_Size_btn.click();
				Thread.sleep(1000);
				Wait.until(ExpectedConditions.elementToBeClickable(Bag_Size_Text)).sendKeys(String.valueOf(Bag_Size));
				Thread.sleep(2000);
				Wait.until(ExpectedConditions.elementToBeClickable(Bag_Size_Text)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Bag_Size. Please enter exactly 4 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Bag_Size_btn click...");
			js.executeScript("arguments[0].click();", Bag_Size_btn);
			js.executeScript("arguments[0].value='" + Bag_Size + "';", Bag_Size_Text);
			js.executeScript("arguments[0].click();", Bag_Size_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Bag_Size_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Bag_Size_btn: " + e.getMessage());
		}
		try {
			if (Qty_UOM.matches("^[a-zA-Z0-9]{0,8}$")) {
				Qty_UOM_btn.click();
				Qty_UOM_Text.sendKeys(Qty_UOM);
				Qty_UOM_Text.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Qty_UOM. Please enter exactly 3 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Qty_UOM_btn click...");
			js.executeScript("arguments[0].click();", Qty_UOM_btn);
			js.executeScript("arguments[0].value='" + Qty_UOM + "';", Qty_UOM_Text);
			js.executeScript("arguments[0].click();", Qty_UOM_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Qty_UOM_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Qty_UOM_btn: " + e.getMessage());
		}
		try {
			if (Bag_Type.matches("^[a-zA-Z0-9]{0,8}$")) {
				Bag_Type_btn.click();
				Bag_Type_Text.sendKeys(Bag_Type);
				//Thread.sleep(1000);
				Wait.until(ExpectedConditions.elementToBeClickable(Bag_Type_Text)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Bag_Type. Please enter exactly 3 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Bag_Type_btn click...");
			js.executeScript("arguments[0].click();", Bag_Type_btn);
			js.executeScript("arguments[0].value='" + Bag_Type + "';", Bag_Type_Text);
			js.executeScript("arguments[0].click();", Bag_Type_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Bag_Type_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Bag_Type_btn: " + e.getMessage());
		}
		try {
			if (verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(verify_btn)).sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript verify_btn click...");
			js.executeScript("arguments[0].click();", verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for verify_btn: " + e.getMessage());
		}
		try {
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("We are unable to click the save button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
	}
}
