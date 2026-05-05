
package TestPages;

import java.io.IOException;
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

public class Government_Agency_Deposite_Request_Maker {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ENWR_Creation.xlsx";
	static String sheet = "Government_Agency_Deposite";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	/*
	 * public static String Deposite = "3244049"; // 382444017; public String
	 * Quality_Stand = "NAFED"; public String Commodity_Segment =
	 * "01 - Agriculture"; String Scheme = "PSS"; String Crop_Year = "2025"; String
	 * Crop_Season = "RABI"; public String Deposit_Type = "Government Agency";
	 * public String Client_ID = "100673001212128"; public static String WH_ID =
	 * "5750013"; public static String WSP_ID = "9996059"; public static String bags
	 * = "100"; // for Government Agency bag size should be 100 bags limit public
	 * static String Commodity_Code = "13"; public String Bag_Size = "0.5"; public
	 * String Bag_Type = "JUTE"; public String Qty_UOM = "QUINTAL"; public String
	 * Bag_UOM = "QUINTAL";
	 */

	public static String Deposite = excel.getDeposite_GA(dataRow);
	public String Quality_Stand = excel.getQuality_Stand_GA(dataRow);
	public String Commodity_Segment = excel.getCommodity_Segment_GA(dataRow);
	String Scheme = excel.getScheme_GA(dataRow);
	String Crop_Year = excel.getCrop_Year_GA(dataRow);
	String Crop_Season = excel.getCrop_Season_GA(dataRow);
	public String Deposit_Type = excel.getDeposit_Type_GA(dataRow);
	public String Client_ID = excel.getClient_ID_GA(dataRow);
	public static String WH_ID = excel.getWH_ID_GA(dataRow);
	public static String WSP_ID = excel.getWSP_ID_GA(dataRow);
	public static String bags = excel.getbags_GA(dataRow);// for Government Agency bag size should be 100 bags limit
	public static String Commodity_Code = excel.getCommodity_Code_GA(dataRow);
	public float Bag_Size = excel.getBag_Size_GA(dataRow);
	public String Bag_Type = excel.getBag_Type_GA(dataRow);
	public String Qty_UOM = excel.getQty_UOM_GA(dataRow);
	public String Bag_UOM = excel.getBag_UOM_GA(dataRow);

	public Government_Agency_Deposite_Request_Maker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	// @FindBy(xpath = "//span[normalize-space()='Transactions']")
	@FindBy(xpath = "(//a[@class='auto ng-scope'])[3]")
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

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement General_Deposit_Type;
	// button[data-id='qualitystdSelectionCombobox'] span[class='filter-option
	// pull-left']
	// button[@data-id='qualitystdSelectionCombobox']
	// (//span[@class='filter-option pull-left'][normalize-space()='NOTHING
	// SELECTED'])[1]
	@FindBy(css = "button[data-id='qualitystdSelectionCombobox'] span[class='filter-option pull-left']")
	WebElement Quality_Stand_btn;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement Quality_Stand_txt;

	@FindBy(xpath = "(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement Scheme_btn;

	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement Scheme_Text;

	@FindBy(xpath = "//button[@data-id='cropSeasonSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Crop_Season_btn;

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement Crop_Season_Text;

	@FindBy(xpath = "//button[@data-id='cropYearSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Crop_Years;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement Years_List;

	@FindBy(xpath = "//button[@data-id='WspMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement WSP_ID_btn;

	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement WSP_ID_txt;
//(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[2]
	@FindBy(xpath = "//label[normalize-space()='WH Id']/following-sibling::div//button//span[text()='NOTHING SELECTED']")
	WebElement WH_ID_Btn;

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement WH_ID_txt;

	@FindBy(xpath = "(//span[@class='box'])[1]")
	WebElement Negotiable_eceipt_Required;

	@FindBy(xpath = "//label[normalize-space()='Assaying Required']")
	WebElement Assaying_Required;

	@FindBy(xpath = "(//button[@data-id='ClientMasterSelectionCombobox'])[1]")
	WebElement Client_Id_Btn;
	// button[@data-id='ClientMasterSelectionCombobox']//span[@class='filter-option
	// pull-left'][normalize-space()='NOTHING SELECTED']
	// (//button[@data-id='ClientMasterSelectionCombobox'])[1]
	// (//span[@class='filter-option pull-left'][normalize-space()='NOTHING
	// SELECTED'])[3]
	@FindBy(xpath = "(//input[@type='text'])[17]")
	WebElement Client_ID_txt;

	@FindBy(xpath = "//button[@data-id='CommodityMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Commodity_Code_btn;

	@FindBy(xpath = "(//input[@type='text'])[21]")
	WebElement Commodity_Code_txt;

	@FindBy(xpath = "(//input[@name='no_of_bags'])[1]")
	WebElement no_of_bags;

	@FindBy(xpath = "//button[@data-id='baguom']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Bag_UOM_btn;

	@FindBy(xpath = "(//input[@type='text'])[27]")
	WebElement Bag_UOM_txt;

	@FindBy(xpath = "//button[@data-id='bagSize']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Bag_Size_btn;

	@FindBy(xpath = "(//input[@type='text'])[28]")
	WebElement Bag_Size_Text;

	@FindBy(xpath = "(//button[@data-id='qtyuom'])[1]")
	WebElement Qty_UOM_btn;

	@FindBy(xpath = "(//input[@type='text'])[29]")
	WebElement Qty_UOM_Text;

	@FindBy(xpath = "(//button[@data-id='BagTypeSelectionCombobox'])[1]")
	WebElement Bag_Type_btn;

	@FindBy(xpath = "(//input[@type='text'])[31]")
	WebElement Bag_Type_Text;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']")
	WebElement verify_btn;

	@FindBy(css = ".btn.btn-primary.blue.ng-isolate-scope")
	WebElement save_btn;

	@FindBy(xpath = "//div[@class='btn-group bootstrap-select form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-not-empty ng-dirty ng-valid-parse ng-valid ng-valid-required open']//li[@class='active']//a")
	WebElement WH;

	public void Government_Agency_Deposite() throws IOException {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}

		// Deposit function to be Click

		Wait.until(ExpectedConditions.elementToBeClickable(Deposit_btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(New_Deposite_Req)).click();

		// if (Commodity_Segment.matches("^[a-zA-Z0-9]{20}$")) {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select Sa = new Select(Commodity_Segment_Code);
		Sa.selectByContainsVisibleText(Commodity_Segment);

		Commodity_Segment_Ok_btn.click();

		if (Deposite.matches("^[a-zA-Z0-9]{7}$")) {
			Deposite_No.sendKeys(Keys.ENTER);
			Wait.until(ExpectedConditions.elementToBeClickable(Deposite_No)).sendKeys(String.valueOf(Deposite));
			Deposite_No.click();
		} else {
			System.out.println("Invalid Deposite. Please enter exactly 7 alphanumeric characters:");
		}

		// Deposit_Type DropDown
		// if (Deposit_Type.matches("^[a-zA-Z0-9]{20}$")) {
		Select SB = new Select(Deposit_Type_option);
		SB.selectByContainsVisibleText(Deposit_Type);

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// if (Quality_Stand.matches("^[a-zA-Z0-9]{0,10}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Quality_Stand_btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Quality_Stand_txt)).sendKeys(Quality_Stand);
			Quality_Stand_txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Quality_Stand_btn click...");
			js.executeScript("arguments[0].click();", Quality_Stand_btn);
			js.executeScript("arguments[0].value='" + Quality_Stand + "';", Quality_Stand_txt);
			js.executeScript("arguments[0].click();", Quality_Stand_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Quality_Stand_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Quality_Stand_btn: " + e.getMessage());
		}

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// if (Scheme.matches("^[a-zA-Z0-9]{10}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Scheme_btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Scheme_Text)).sendKeys(Scheme);
			Scheme_Text.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Quality_Stand_btn click...");
			js.executeScript("arguments[0].click();", Scheme_btn);
			js.executeScript("arguments[0].value='" + Scheme + "';", Scheme_Text);
			js.executeScript("arguments[0].click();", Scheme_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Scheme_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Scheme_btn: " + e.getMessage());
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// if (Crop_Year.matches("^[a-zA-Z0-9]{10}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Crop_Years)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Years_List)).sendKeys(Crop_Year);
			Years_List.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Quality_Stand_btn click...");
			js.executeScript("arguments[0].click();", Crop_Years);
			js.executeScript("arguments[0].value='" + Crop_Year + "';", Years_List);
			js.executeScript("arguments[0].click();", Years_List);
		} catch (NoSuchElementException e) {
			System.out.println("Years_List not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Years_List: " + e.getMessage());
		}
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// if (Crop_Season.matches("^[a-zA-Z0-9]{10}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Crop_Season_btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Crop_Season_Text)).sendKeys(Crop_Season);
			Crop_Season_Text.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Quality_Stand_btn click...");
			js.executeScript("arguments[0].click();", Crop_Season_btn);
			js.executeScript("arguments[0].value='" + Crop_Season + "';", Crop_Season_Text);
			js.executeScript("arguments[0].click();", Crop_Season_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Crop_Season_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Crop_Season_Text: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			if (WSP_ID.matches("^[a-zA-Z0-9]{7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_btn)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(String.valueOf(WSP_ID));
				WSP_ID_txt.sendKeys(Keys.ENTER);

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
		try {
			if (WH_ID_Btn.isDisplayed()) {
				if (WH_ID.matches("^[a-zA-Z0-9]{0,7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_Btn)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(String.valueOf(WH_ID));
					/* System.out.println("WH_ID is :" + WH_ID); */
					Thread.sleep(1000);
					/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(Keys.ENTER);
					// Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_Btn)).click();
				} else {
					System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
				}
			} else {
				System.out.println("WH_ID Button is visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("WH_ID_Btn not found: " + e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("WH_ID_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WH_ID_Btn: " + e.getMessage());
			e.printStackTrace();
		}
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		if (Client_Id_Btn.isDisplayed()) {
			if (Client_ID.matches("^[a-zA-Z0-9]{0,15}$")) {
				Client_Id_Btn.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Client_ID_txt)).sendKeys(String.valueOf(Client_ID));
				Client_ID_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Client_ID. Please enter exactly 15 alphanumeric characters:");
			}
		}

		if (Commodity_Code.matches("^[a-zA-Z0-9]{0,3}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Code_btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Code_txt))
					.sendKeys(String.valueOf(Commodity_Code));
			Commodity_Code_txt.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Commodity_Code. Please enter exactly 3 alphanumeric characters:");
		}

		if (bags.matches("^[0-9]{0,5}$")) {
			// bags = Integer.parseInt(input);
			no_of_bags.sendKeys(String.valueOf(bags));
		} else {
			System.out.println("Invalid bags. Please enter exactly 5 digits (numbers only):");
		}

		if (Bag_UOM.length() <= 50) {
			Bag_UOM_btn.click();
			Bag_UOM_txt.sendKeys(Bag_UOM);
			Bag_UOM_txt.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Bag_UOM. Please enter exactly 3 alphanumeric characters:");
		}

		if (String.valueOf(Bag_Size).matches("^[0-9].{0,5}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Bag_Size_btn)).click();
			System.out.println("Bag_Size is :" + Bag_Size);
			Bag_Size_Text.sendKeys(String.valueOf(Bag_Size));
			Wait.until(ExpectedConditions.elementToBeClickable(Bag_Size_Text)).sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Bag_Size. Please enter exactly 3 alphanumeric characters:");
		}

		if (Qty_UOM.matches("^[a-zA-Z0-9]{0,8}$")) {
			Qty_UOM_btn.sendKeys(Keys.ENTER);
			Qty_UOM_Text.sendKeys(Qty_UOM);
			Qty_UOM_Text.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Qty_UOM. Please enter exactly 8 alphanumeric characters:");
		}

		if (Bag_Type.matches("^[a-zA-Z0-9]{0,8}$")) {
			Bag_Type_btn.sendKeys(Keys.ENTER);
			Bag_Type_Text.sendKeys(Bag_Type);
			Bag_Type_Text.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Bag_Type. Please enter exactly 8 alphanumeric characters:");
		}

		try {
			if (verify_btn.isDisplayed()) {
				verify_btn.sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Commodity_Code_btn click...");
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
			System.out.println("Commodity_Code not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Commodity_Code: " + e.getMessage());
		}

	}
}
