package TestPages;

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

public class Settlement_Master_CC_Login {

	WebDriver driver;
	WebDriverWait Wait;

	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ON_Market.xlsx";
	static String sheet = "Settlement";
	static int dataRow = 3; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	String ExchangeMaster = excel.getExchangeMaster(dataRow);
	int Settlement_Type = excel.getSettlement_Type(dataRow);
	static int settlement_No = excel.getsettlement_No(dataRow);
	int settlement_Year = excel.getsettlement_Year(dataRow);
	String commodity = excel.getcommodity(dataRow);
	 String SYMBOL =excel.getSYMBOL(dataRow);
	String expectedDay =excel.getexpectedDay(dataRow);//"30-11-2025";
	String trade_Day =excel.gettrade_Day(dataRow);//"15-10-2025";
	String PostExpiry_Validity_Day =excel.getPostExpiry_Validity_Date(dataRow);  //"30-11-2025"; 
	String Delivery_Marking_Day =excel.getDelivery_Marking(dataRow);  //"23-10-2025"; 
	String pay_In_date =excel.getpay_In_date(dataRow);  //"30-11-2025"; 
	int pay_In_Date_hr = excel.getpay_In_Date_hr(dataRow);
	int pay_In_Date_mn = excel.getpay_In_Date_mn(dataRow);
	String pay_out_date =excel.getpay_out_date(dataRow); //"30-11-2025";
	int pay_out_Date_hr = excel.getpay_out_Date_hr(dataRow);
	int pay_out_Date_mn = excel.getpay_out_Date_mn(dataRow);
	String early_pay_In_date =excel.getearly_pay_In_date(dataRow);//"15-10-2025"; 
	int early_pay_In_Date_hr = excel.getearly_pay_In_Date_hr(dataRow);
	int early_pay_In_Date_mn = excel.getearly_pay_In_Date_mn(dataRow);
	String early_Payin_End_date =excel.getearly_Payin_End_date(dataRow); // "15-10-2025"; 
	int early_Payin_End_Date_hr = excel.getearly_Payin_End_Date_hr(dataRow);
	int early_Payin_End_Date_mn = excel.getearly_Payin_End_Date_mn(dataRow);
   
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Settlement_Master_CC_Login(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Depledge_Request creation process-------------
	@FindBy(xpath = "(//span[normalize-space()='Masters'])[1]")
	WebElement Masters_Btn;

	@FindBy(xpath = "//a[@ui-sref='Masters.Settlement']//span[@class='title ng-binding'][normalize-space()='Settlement']")
	WebElement Settlement_Btn;

	@FindBy(xpath = "(//button[normalize-space()='New'])[1]")
	WebElement New_btn;

	@FindBy(xpath = "//button[@data-id='ExchangeMasterCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement ExchangeMasterCombobox_btn;
	// div[@class='btn-group bootstrap-select form-control ng-pristine ng-untouched
	// ng-empty ng-invalid ng-invalid-required dropup open']//input[@type='text']

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement ExchangeMasterCombobox_txt;

	@FindBy(xpath = "(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement Settlement_Type_Btn;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement Settlement_Type_Txt;

	@FindBy(xpath = "(//input[@name='settlement_No'])[1]")
	WebElement settlement_No_txt;

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Settlement_pop_Up;

	@FindBy(xpath = "(//input[@name='settlement_Year'])[1]")
	WebElement settlement_Year_txt;

	@FindBy(xpath = "(//button[normalize-space()='Add Commodity Contract'])[1]")
	WebElement Add_Commodity;

	@FindBy(xpath = "//button[@data-id='CommodityMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement COMM_CODE_NAME_btn;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement COMM_CODE_NAME_Txt;
	
	@FindBy(xpath="//button[@class='btn dropdown-toggle btn-default']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement SYMBOL_Btn;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement SYMBOL_Txt;
	
	@FindBy(xpath="//li[@class='active']//a[@class='ng-binding ng-scope']")
	WebElement SYMBOL_active;
	
	@FindBy(xpath = "(//input[@id='expiry_Date'])[1]")
	WebElement expiry_Date_txt;

	@FindBy(xpath = "(//input[@id='trade_Start_Date'])[1]")
	WebElement trade_Start_Date_txt;

	@FindBy(xpath = "//td[@class='today active start-date active end-date available']")
	WebElement today_active;

	@FindBy(xpath = "//select[@name='pay_In_Date_hr']")
	WebElement pay_In_Date_hr_s;

	@FindBy(xpath = "//select[@name='pay_In_Date_mn']")
	WebElement pay_In_Date_mn_s;

	@FindBy(xpath = "//select[@name='pay_Out_Date_hr']")
	WebElement pay_Out_Date_hr_s;

	@FindBy(xpath = "//select[@name='pay_Out_Date_mn']")
	WebElement pay_Out_Date_mn_s;

	@FindBy(xpath = "//select[@name='early_pay_In_Date_hr']")
	WebElement early_pay_In_Date_hr_s;

	@FindBy(xpath = "//select[@name='early_pay_In_Date_mn']")
	WebElement early_pay_In_Date_mn_s;

	@FindBy(xpath = "//select[@name='early_Payin_End_Date_hr']")
	WebElement early_Payin_End_Date_hr_s;

	@FindBy(xpath = "//select[@name='early_Payin_End_Date_mn']")
	WebElement early_Payin_End_Date_mn_s;

	@FindBy(xpath = "(//button[normalize-space()='Add To Settelment Details'])[1]")
	WebElement Add_To_Settelment_Details_btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_btn;

	public void Settlement_Master() throws InterruptedException {
		//Thread.sleep(2000);
		try {
			//Masters_Btn.click();
			Wait.until(ExpectedConditions.elementToBeClickable(Masters_Btn)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Masters_Btn click...");
			js.executeScript("arguments[0].click();", Masters_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Masters_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Masters_Btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {

			Wait.until(ExpectedConditions.elementToBeClickable(Settlement_Btn)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Settlement_Btn click...");
			js.executeScript("arguments[0].click();", Settlement_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Settlement_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Settlement_Btn: " + e.getMessage());
		}
		Wait.until(ExpectedConditions.elementToBeClickable(New_btn)).click();
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(ExchangeMasterCombobox_btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(ExchangeMasterCombobox_txt)).sendKeys(ExchangeMaster);
			System.out.println("ExchangeMaster is :" + ExchangeMaster);
			Thread.sleep(1000);
			ExchangeMasterCombobox_txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying ExchangeMasterCombobox_btn click...");
			js.executeScript("arguments[0].click();", ExchangeMasterCombobox_btn);
			js.executeScript("arguments[0].value='" + ExchangeMaster + "';", ExchangeMasterCombobox_txt);
			js.executeScript("arguments[0].click();", ExchangeMasterCombobox_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Settlement_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Settlement_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Settlement_Type_Btn)).click();
			Settlement_Type_Txt.sendKeys(String.valueOf(Settlement_Type));
			Thread.sleep(1000);
			Settlement_Type_Txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Settlement_Type_Txt click...");
			js.executeScript("arguments[0].click();", Settlement_Type_Btn);
			js.executeScript("arguments[0].value='" + Settlement_Type + "';", Settlement_Type_Txt);
			js.executeScript("arguments[0].click();", Settlement_Type_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Settlement_Type_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Settlement_Type_Txt: " + e.getMessage());
		}

		settlement_No_txt.click();
		settlement_No_txt.sendKeys(String.valueOf(settlement_No));

		/*
		 * try { Settlement_pop_Up.click(); } catch (Exception e) {
		 * 
		 * System.out.println("Settlement_pop_Up is not visible"); }
		 */

		settlement_Year_txt.click();
		settlement_Year_txt.sendKeys(String.valueOf(settlement_Year));

		Add_Commodity.click();
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(COMM_CODE_NAME_btn)).click();
			COMM_CODE_NAME_Txt.sendKeys(commodity);
			Thread.sleep(1000);
			COMM_CODE_NAME_Txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying COMM_CODE_NAME_btn click...");
			js.executeScript("arguments[0].click();", COMM_CODE_NAME_btn);
			js.executeScript("arguments[0].value='" + commodity + "';", COMM_CODE_NAME_Txt);
			js.executeScript("arguments[0].click();", COMM_CODE_NAME_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("COMM_CODE_NAME_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for COMM_CODE_NAME_Txt: " + e.getMessage());
		}
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(SYMBOL_Btn)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(SYMBOL_Txt)).sendKeys(SYMBOL);
			Wait.until(ExpectedConditions.elementToBeClickable(SYMBOL_active)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying SYMBOL_Btn click...");
			js.executeScript("arguments[0].click();", SYMBOL_Btn);
			js.executeScript("arguments[0].value='" + SYMBOL + "';", SYMBOL_Txt);
			js.executeScript("arguments[0].click();", SYMBOL_active);
		} catch (NoSuchElementException e) {
			System.out.println("SYMBOL_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for SYMBOL_Btn: " + e.getMessage());
		}
		
		Thread.sleep(1000);
		// Open the calendar expiry_Date
		WebElement expiry_Date = driver.findElement(By.xpath("//input[@id='expiry_Date']"));
		expiry_Date.click();
		expiry_Date.sendKeys(expectedDay);
		//expiry_Date.sendKeys(Keys.ENTER);

		// Open the calendar trade_Start_Date
		WebElement trade_Start_Date = driver.findElement(By.xpath(" //input[@id='trade_Start_Date']"));
		trade_Start_Date.click();
		trade_Start_Date.sendKeys(trade_Day);
		Thread.sleep(2000);

		// Open the calendar delivery_Marking_Date
		WebElement delivery_Marking_dateField = driver
				.findElement(By.xpath("(//input[@id='delivery_Marking_Date'])[1]"));
		delivery_Marking_dateField.click();
		delivery_Marking_dateField.sendKeys(PostExpiry_Validity_Day);
		Thread.sleep(1000);
		delivery_Marking_dateField.sendKeys(Keys.ENTER);

		// Open the calendar delivery_Marking_Date
		WebElement delivery_Date = driver.findElement(By.xpath("(//input[@id='delivery_Marking_Date'])[2]"));
		delivery_Date.click();
		delivery_Date.sendKeys(Delivery_Marking_Day);
		Thread.sleep(1000);
		delivery_Date.sendKeys(Keys.ENTER);

		// Select the calendar pay_In_Date
		WebElement pay_In_Date = driver.findElement(By.xpath("//input[@id='pay_In_Date']"));
		pay_In_Date.click();
		pay_In_Date.sendKeys(pay_In_date);
		Thread.sleep(1000);
		pay_In_Date.sendKeys(Keys.ENTER);

		WebElement Pay_In_Hr = driver.findElement(By.xpath("(//select[@name='pay_In_Date_hr'])[1]"));
		Select Sa = new Select(Pay_In_Hr);
		Sa.selectByContainsVisibleText(String.valueOf(pay_In_Date_hr));

		WebElement pay_In_MM = driver.findElement(By.xpath("(//select[@name='pay_In_Date_mn'])[1]"));
		Select Sb = new Select(pay_In_MM);
		Sb.selectByContainsVisibleText(String.valueOf(String.valueOf(pay_In_Date_mn)));

		// Select the calendar pay_Out_Date
		WebElement pay_Out_Date = driver.findElement(By.xpath("//input[@id='pay_Out_Date']"));
		pay_Out_Date.click();
		pay_Out_Date.sendKeys(pay_out_date);
		Thread.sleep(1000);
		pay_Out_Date.sendKeys(Keys.ENTER);

		WebElement pay_Out_Date_hr = driver.findElement(By.xpath("//select[@name='pay_Out_Date_hr']"));
		Select SC = new Select(pay_Out_Date_hr);
		SC.selectByContainsVisibleText(String.valueOf(pay_out_Date_hr));

		WebElement pay_Out_Date_mn = driver.findElement(By.xpath("//select[@name='pay_Out_Date_mn']"));
		Select SD = new Select(pay_Out_Date_mn);
		SD.selectByContainsVisibleText(String.valueOf(String.valueOf(pay_out_Date_mn)));

		// Select the calendar early_Payin_Start_Date 
		WebElement early_Payin_Start_Date = driver.findElement(By.xpath("(//input[@id='early_Payin_Start_Date'])[1]"));
		early_Payin_Start_Date.click();
		early_Payin_Start_Date.sendKeys(early_pay_In_date);
		early_Payin_Start_Date.sendKeys(Keys.ENTER);

		WebElement early_pay_In_Date_hr_V = driver.findElement(By.xpath("//select[@name='early_pay_In_Date_hr']"));
		Select SE = new Select(early_pay_In_Date_hr_V);
		SE.selectByContainsVisibleText(String.valueOf(early_pay_In_Date_hr));
		//System.out.print("ssf is :"+early_pay_In_Date_hr);
		
		WebElement early_pay_In_Date = driver.findElement(By.xpath("//select[@name='early_pay_In_Date_mn']"));
		Select SF = new Select(early_pay_In_Date);
		SF.selectByContainsVisibleText(String.valueOf(String.valueOf(early_pay_In_Date_mn)));
		
		// Select early_Payin_End_Date
		WebElement early_Payin_End_Date = driver.findElement(By.xpath("(//input[@id='early_Payin_End_Date'])[1]"));
		early_Payin_End_Date.click();
		early_Payin_End_Date.sendKeys(early_Payin_End_date);
		Thread.sleep(1000);
		early_Payin_End_Date.sendKeys(Keys.ENTER);
		
		WebElement early_Payin_End_Date_hr_V = driver.findElement(By.xpath("//select[@name='early_Payin_End_Date_hr']"));
		Select SI = new Select(early_Payin_End_Date_hr_V);
		SI.selectByContainsVisibleText(String.valueOf(early_Payin_End_Date_hr));

		WebElement early_Payin_End_Date1 = driver.findElement(By.xpath("//select[@name='early_Payin_End_Date_mn']"));
		Select SJ = new Select(early_Payin_End_Date1);
		SJ.selectByContainsVisibleText(String.valueOf(String.valueOf(early_Payin_End_Date_mn)));

		Wait.until(ExpectedConditions.elementToBeClickable(Add_To_Settelment_Details_btn)).click();

		try {
			if (Save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			} else {
				System.out.println("Save_btn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Save_btn click...");
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}

	}

}
