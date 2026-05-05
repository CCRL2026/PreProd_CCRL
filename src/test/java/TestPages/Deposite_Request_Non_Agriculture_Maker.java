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
import org.testng.Assert;

public class Deposite_Request_Non_Agriculture_Maker {
	WebDriver driver;
	WebDriverWait Wait;

	public String Commodity_Segment = "02 - Non-Agriculture";
	public static String Deposite = "5244433";
	public String Quality_Stand = "BIS";
	public String Deposit_Type = "General";
	public static String WSP_ID = "9996059";
	public static String WH_ID = "5750013";
	public String Client_ID = "100673000000011";
	public static String Commodity_Code = "15";
	public static String bags = "700";
	public String Bag_Size = "1.7";
	public String Bag_Type = "BALES";
	public String Qty_UOM = "QUINTAL";
	public String Bag_UOM = "QUINTAL";

	public Deposite_Request_Non_Agriculture_Maker(WebDriver driver, WebDriverWait Wait) {

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

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement General_Deposit_Type;

	@FindBy(xpath = "//button[@data-id='qualitystdSelectionCombobox']")
	WebElement Quality_Stand_btn;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement Quality_Stand_txt;

	@FindBy(xpath = "//button[@data-id='WspMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement WSP_ID_btn;

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement WSP_ID_txt;

	@FindBy(xpath = "//label[text()='WH Id']/following-sibling::div//button//span[text()='NOTHING SELECTED']")
	WebElement WH_ID_Btn;

	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement WH_ID_txt;


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

	@FindBy(xpath = "(//input[@type='text'])[25]")
	WebElement Bag_UOM_txt;

	@FindBy(xpath = "(//button[@data-id='bagSize'])[1]")
	WebElement Bag_Size_btn;

	@FindBy(xpath = "(//input[@type='text'])[26]")
	WebElement Bag_Size_Text;

	@FindBy(xpath = "(//button[@data-id='qtyuom']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement Qty_UOM_btn;

	@FindBy(xpath = "(//input[@type='text'])[27]")
	WebElement Qty_UOM_Text;

	@FindBy(xpath = "(//button[@data-id='BagTypeSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement Bag_Type_btn;

	@FindBy(xpath = "(//input[@type='text'])[29]")
	WebElement Bag_Type_Text;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']")
	WebElement verify_btn;

	@FindBy(css = ".btn.btn-primary.blue.ng-isolate-scope")
	WebElement save_btn;

	@FindBy(xpath = "//div[@class='btn-group bootstrap-select form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-not-empty ng-dirty ng-valid-parse ng-valid ng-valid-required open']//li[@class='active']//a")
	WebElement WH;


	public void Deposite_Request_Non_Agriculture() {

		// Transaction Button to be Click
		Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		// Deposit function to be Click
		Wait.until(ExpectedConditions.elementToBeClickable(Deposit_btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(New_Deposite_Req)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select Sa = new Select(Commodity_Segment_Code);
		Sa.selectByContainsVisibleText(Commodity_Segment);
		Assert.assertTrue(Commodity_Segment_Code.isDisplayed(), "Commodity_Segment_Code button not visible");
		Commodity_Segment_Ok_btn.click();
		if (Deposite.matches("^[a-zA-Z0-9]{7}$")) {
			Deposite_No.sendKeys(Keys.ENTER);
			Wait.until(ExpectedConditions.elementToBeClickable(Deposite_No)).sendKeys(String.valueOf(Deposite));
			Deposite_No.click();
		} else {
			System.out.println("Invalid Deposite. Please enter exactly 7 alphanumeric characters:");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select SB = new Select(Deposit_Type_option);
		SB.selectByContainsVisibleText(Deposit_Type);
		General_Deposit_Type.click();
		// } else {
		// System.out.println("Invalid Deposit_Type. Please enter exactly 20
		// alphanumeric characters:");

		// }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// if (Quality_Stand.matches("^[a-zA-Z0-9]{10}$")) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Quality_Stand_btn.click();
		Wait.until(ExpectedConditions.elementToBeClickable(Quality_Stand_txt)).sendKeys(Quality_Stand);
		Wait.until(ExpectedConditions.elementToBeClickable(Quality_Stand_txt)).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		try {
		if (WSP_ID.matches("^[a-zA-Z0-9]{7}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_btn)).click();
			// WSP_ID_btn.click();
			Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(String.valueOf(WSP_ID));
			WSP_ID_txt.sendKeys(Keys.ENTER);
			// Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_txt)).sendKeys(Keys.ENTER);
		}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			WebElement WSP_ID_JAVA = driver.findElement(
					By.xpath("(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", WSP_ID_JAVA);
			Wait.until(ExpectedConditions.elementToBeClickable(WSP_ID_JAVA)).sendKeys(String.valueOf(WSP_ID));
			WSP_ID_txt.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}

		try {
			if (WH_ID_Btn.isDisplayed() && WH_ID_Btn.isEnabled()) {
				if (WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_Btn)).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(String.valueOf(WH_ID));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(Keys.ENTER);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", WH_ID_txt);
					/*
					WH_ID_txt.sendKeys(Keys.ENTER);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					WH_ID_txt.sendKeys(Keys.ENTER);
					*/
				}
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			WebElement WH_ID_JAVA = driver.findElement(
					By.xpath("(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[3]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", WH_ID_JAVA);
			Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_txt)).sendKeys(String.valueOf(WH_ID));
			WH_ID_txt.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		try {
			if (Client_ID.matches("^[a-zA-Z0-9]{0,16}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Client_Id_Btn)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Client_ID_txt)).sendKeys(String.valueOf(Client_ID));
				Client_ID_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Client_ID. Please enter exactly 15 alphanumeric characters:");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element not clickable at the moment: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
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
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element not clickable at the moment: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		if (bags.matches("^[0-9]{0,5}$")) {
			no_of_bags.sendKeys(bags);
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
		if (Bag_Size.matches("^[0-9].{0,4}$")) {
			Bag_Size_btn.click();
			Bag_Size_Text.sendKeys(Bag_Size);
			Bag_Size_Text.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Bag_Size. Please enter exactly 4 alphanumeric characters:");

		}
		if (Qty_UOM.matches("^[a-zA-Z0-9]{0,8}$")) {
			Qty_UOM_btn.click();
			Qty_UOM_Text.sendKeys(Qty_UOM);
			Qty_UOM_Text.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Qty_UOM. Please enter exactly 3 alphanumeric characters:");

		}
		if (Bag_Type.matches("^[a-zA-Z0-9]{0,8}$")) {
			Bag_Type_btn.click();
			Bag_Type_Text.sendKeys(Bag_Type);
			Bag_Type_Text.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Bag_Type. Please enter exactly 3 alphanumeric characters:");

		}

		Wait.until(ExpectedConditions.elementToBeClickable(verify_btn)).sendKeys(Keys.ENTER);

		if (save_btn.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).sendKeys(Keys.ENTER);
		} else {
			System.out.println("We are unable to click the save button");
		}
	}

	}


