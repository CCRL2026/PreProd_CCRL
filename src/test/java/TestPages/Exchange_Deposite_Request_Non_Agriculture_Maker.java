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

public class Exchange_Deposite_Request_Non_Agriculture_Maker {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ENWR_Creation.xlsx";
	static String sheet = "Exchange_Deposite_Non_Agricult";
	static int dataRow = 1; // second row of data
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	/*
	 * public String Commodity_Segment = "02 - Non-Agriculture"; public static
	 * String Deposite = "5244478"; public String Deposit_Type = "Exchange"; public
	 * String exchange_Code = "11"; public static String WSP_ID = "9999996"; public
	 * static String WH_ID = "1000421"; public String Client_ID = "100673000000011";
	 * public static String Commodity_Code = "1003"; public String symbol = "ZINC";
	 * public static String No_of_Bundle = "10"; public static String
	 * Pieces_Per_Bundle = "10"; public String Qty_UOM = "MT"; public static String
	 * NQuantity = "50"; String Bag_Type = "Bundle";
	 */

	public String Commodity_Segment = excel.getCommoditySegment_Ex_Non(dataRow);
	public static String Deposite = excel.getDeposite_ex_Non(dataRow);
	public String Deposit_Type = excel.getDepositType_ex_Non(dataRow);
	public String exchange_Code = excel.getexchange_Code_Non(dataRow);
	public String WSP_ID = excel.getWspID_ex_Non(dataRow);
	public static String WH_ID = excel.getWhID_ex_Non(dataRow);
	public String Client_ID = excel.getClientID_ex_Non(dataRow);
	public static String Commodity_Code = excel.getCommodityCode_ex_Non(dataRow);
	public String symbol = excel.getsymbol_ex_Non(dataRow);
	public static String No_of_Bundle = excel.getNo_of_Bundle_ex_Non(dataRow);
	public static String Pieces_Per_Bundle = excel.getPieces_Per_Bundle_ex_Non(dataRow);
	public String Qty_UOM = excel.getQtyUOM_ex_Non(dataRow);
	public static String NQuantity = excel.getNQuantity_ex_Non(dataRow);
	public String Bag_Type = excel.getBag_Type_ex_Non(dataRow);

	public Exchange_Deposite_Request_Non_Agriculture_Maker(WebDriver driver, WebDriverWait Wait) {

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
	@FindBy(xpath = "//label[text()='WSP Id']/following-sibling::div//button//span[text()='NOTHING SELECTED']")
	WebElement WSP_ID_btn;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement WSP_ID_txt;
	// (//span[@class='filter-option pull-left'][normalize-space()='NOTHING
	// SELECTED'])[1]
	// label[text()='WH Id']/following-sibling::div//button//span[text()='NOTHING
	// SELECTED']
	@FindBy(xpath = "// label[text()='WH Id']/following-sibling::div//button//span[text()='NOTHING SELECTED']")
	WebElement WH_ID_Btn;

	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement WH_ID_txt;
	@FindBy(xpath = "//div[@class='btn-group bootstrap-select form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-not-empty ng-dirty ng-valid-parse ng-valid ng-valid-required dropup open']//li[@class='active']//a]")
	WebElement WH_ID_Option;

	@FindBy(xpath = "//button[@data-id='ClientMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Client_Id_Btn;

	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement Client_ID_txt;

	@FindBy(xpath = "(//button[@data-id='CommodityMasterSelectionCombobox'])[1]")
	WebElement Commodity_Code_btn;

	@FindBy(xpath = "(//input[@type='text'])[17]")
	WebElement Commodity_Code_txt;
	// button[@data-id='symbolSelectionCombobox']//span[@class='filter-option
	// pull-left'][normalize-space()='NOTHING SELECTED']
	// (//span[@class='filter-option pull-left'][normalize-space()='NOTHING
	// SELECTED'])[2]
	@FindBy(xpath = "(//button[@data-id='symbolSelectionCombobox'])[1]")
	WebElement symbol_btn;

	@FindBy(xpath = "(//input[@type='text'])[19]")
	WebElement symbol_text;

	@FindBy(xpath = "//input[@name='no_of_bags']")
	WebElement No_of_Bundles;

	@FindBy(xpath = "(//input[@name='no_of_pieces'])[1]")
	WebElement No_Of_Pieces_Per_Bundle;

	@FindBy(xpath = "//button[@data-id='qtyuom']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement qtyuom;

	@FindBy(xpath = "(//input[@type='text'])[25]")
	WebElement qtyuom_text;

	@FindBy(xpath = "(//input[@id='Quant'])[1]")
	WebElement Notional_Quantity;

	// button[@data-id='BagTypeSelectionCombobox']//span[@class='filter-option
	// pull-left'][normalize-space()='NOTHING SELECTED']

	@FindBy(xpath = "//button[@data-id='BagTypeSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement BagType;

	@FindBy(xpath = "(//input[@type='text'])[27]")
	WebElement BagType_text;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']")
	WebElement verify_btn;

	@FindBy(xpath = "//li[@class='active']//a")
	WebElement WSP_active;

	@FindBy(css = ".btn.btn-primary.blue.ng-isolate-scope")
	WebElement save_btn;

	public void Non_Agriculture_Exchange_Deposite_Request() throws InterruptedException {

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
		// if (Commodity_Segment.matches("^[a-zA-Z0-9]{0-20}$")) {
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
			if (Deposite.matches("^[a-zA-Z0-9]{7}$")) {
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
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].click();", exchangeMaster);
			js.executeScript("arguments[0].value='" + exchange_Code + "';", exchangeMaster_txt);
			js.executeScript("arguments[0].click();", exchangeMaster_txt);
		} catch (NoSuchElementException e) {
			System.out.println("exchangeMaster not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for exchangeMaster: " + e.getMessage());
		}
		// String.valueOf() for Int to String
		try {
			if (WSP_ID.matches("^[a-zA-Z0-9]{7}$")) {
				WSP_ID_btn.click();
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(WSP_ID);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
				// Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(Keys.ENTER);
				WSP_active.sendKeys(Keys.ENTER);
				WSP_ID_txt.sendKeys(Keys.ENTER);
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
		try {
			if (WH_ID_Btn.isDisplayed()) {
				if (WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_Btn)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(String.valueOf(WH_ID));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(Keys.ENTER);
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(Keys.ENTER);
				}
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
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			if (Client_ID.matches("^[a-zA-Z0-9]{0,16}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Client_Id_Btn)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Client_ID_txt)).sendKeys(String.valueOf(Client_ID));
				Client_ID_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Client_ID. Please enter exactly 15 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Client_Id_Btn);
			js.executeScript("arguments[0].value='" + Client_ID + "';", Client_ID_txt);
			js.executeScript("arguments[0].click();", Client_ID_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		// 15-Catton Bales/111->Rabber
		//Thread.sleep(4000);
		try {
			if (Commodity_Code.matches("^[a-zA-Z0-9]{0,4}$")) {
				Commodity_Code_btn.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Code_txt)).sendKeys(Commodity_Code);
				Commodity_Code_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Commodity_Code. Please enter exactly 4 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Commodity_Code_btn click...");
			js.executeScript("arguments[0].click();", Commodity_Code_btn);
			js.executeScript("arguments[0].value='" + Commodity_Code + "';", Commodity_Code_txt);
			js.executeScript("arguments[0].click();", Commodity_Code_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Thread.sleep(3000);
		try {
			if (symbol_btn.isDisplayed() && symbol_btn.isEnabled()) {
				if (symbol.matches("^[a-zA-Z0-9]{0,10}$")) {
					symbol_btn.click();
					Thread.sleep(2000);
					Wait.until(ExpectedConditions.elementToBeClickable(symbol_text)).sendKeys(symbol);
					Thread.sleep(1000);
					symbol_text.sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid value of symbol");
				}
			} else {
				System.out.println("Symbol_btn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript symbol_btn click...");
			js.executeScript("arguments[0].click();", symbol_btn);
			js.executeScript("arguments[0].value='" + symbol + "';", symbol_text);
			js.executeScript("arguments[0].click();", symbol_text);

		} catch (NoSuchElementException e) {
			System.out.println("symbol_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for symbol_btn: " + e.getMessage());
		}

		try {
			if (No_of_Bundle.matches("^[0-9]{0,5}$")) {
				No_of_Bundles.sendKeys(No_of_Bundle);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript No_of_Bundles click...");
			js.executeScript("arguments[0].value='" + No_of_Bundle + "';", No_of_Bundles);
		} catch (NoSuchElementException e) {
			System.out.println("No_of_Bundles not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for  No_of_Bundles: " + e.getMessage());
		}
		/*
		 * try { if (Pieces_Per_Bundle.matches("^[0-9]{0,5}$")) {
		 * No_Of_Pieces_Per_Bundle.sendKeys(Pieces_Per_Bundle); } } catch
		 * (ElementClickInterceptedException e) { System.out.
		 * println("Normal click failed, trying JavaScript  No_Of_Pieces_Per_Bundle click..."
		 * ); js.executeScript("arguments[0].value='" + Pieces_Per_Bundle + "';",
		 * No_Of_Pieces_Per_Bundle); } catch (NoSuchElementException e) {
		 * System.out.println("No_Of_Pieces_Per_Bundle not found: " + e.getMessage()); }
		 * catch (Exception e) {
		 * System.out.println("Unexpected error for No_Of_Pieces_Per_Bundle: " +
		 * e.getMessage()); }
		 */
		try {
			if (Qty_UOM.matches("^[a-zA-Z0-9]{0,5}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(qtyuom)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(qtyuom_text)).sendKeys(Qty_UOM);
				qtyuom_text.sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript qtyuom click...");
			js.executeScript("arguments[0].click();", qtyuom);
			js.executeScript("arguments[0].value='" + Qty_UOM + "';", qtyuom_text);
			js.executeScript("arguments[0].click();", qtyuom_text);
		} catch (NoSuchElementException e) {
			System.out.println("qtyuom not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for qtyuom: " + e.getMessage());
		}
		try {
			if (NQuantity.matches("^[0-9]{0,5}$")) {
				Notional_Quantity.sendKeys(NQuantity);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Notional_Quantity click...");
			js.executeScript("arguments[0].value='" + NQuantity + "';", Notional_Quantity);
		} catch (NoSuchElementException e) {
			System.out.println("Notional_Quantity not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Notional_Quantity: " + e.getMessage());
		}

		try {
			if (Bag_Type.matches("^[a-zA-Z0-9]{0,6}$")) {
				BagType.click();
				Wait.until(ExpectedConditions.elementToBeClickable(BagType_text)).sendKeys(Bag_Type);
				BagType_text.sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript BagType click...");
			js.executeScript("arguments[0].click();", BagType);
			js.executeScript("arguments[0].value='" + Bag_Type + "';", BagType_text);
			js.executeScript("arguments[0].click();", BagType_text);

		} catch (NoSuchElementException e) {
			System.out.println("BagType not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for BagType: " + e.getMessage());
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
