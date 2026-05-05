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
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class Pledge_Creation {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\PlageData.xlsx";
	static String sheet = "PladgeRequest";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	String Agricultural2="Non_Agricultural";
	String Agricultural1="Agricultural";
	public static int pledge_Req_Number = excel.getpledge_Req_Number(dataRow);
	public static String Client_ID =excel.getClient_ID(dataRow);
	public int WH_id =excel.getWH_id(dataRow);
	public static int Commodity = excel.getCommodity(dataRow);
	String pledgee_Client = excel.getpledgee_Client(dataRow);
	String ENWR = excel.getENWR(dataRow);
	int Bags =excel.getBagsp(dataRow);
	static int pledge_value=excel.getpledge_value(dataRow);
	String ifsc_Code = excel.getifsc_Code(dataRow);
	String Commodity_Segment = excel.getCommodity_Segment(dataRow);

	public Pledge_Creation(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Pledge creation process-------------
	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Pledge Creation'])[1]")
	WebElement Pledge_Creation;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Button;

	@FindBy(xpath = "//input[@ng-name='pledge_Req_No']")
	WebElement pledge_Req_No;

	@FindBy(xpath = "//input[@id='Request_Date']")
	WebElement Request_Date;

	@FindBy(xpath = "(//td[@class='today active start-date active end-date available'])[1]")
	WebElement Request_Date_Active;

	@FindBy(xpath = "//input[@id='Execution_Date']")
	WebElement Execution_Date;

	@FindBy(xpath = "(//td[@class='today active start-date active end-date in-range available'])[1]")
	WebElement Execution_Date_Active;

	@FindBy(xpath = "//button[@data-id='ClientMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Client_id;

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement Client_id_Text;

	@FindBy(xpath = "(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[5]")
	WebElement WH_ID;

	@FindBy(xpath = "(//input[@type='text'])[19]")
	WebElement WH_ID_Text;
	
	
	//(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[5]
	//button[@data-id='CommodityMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']
	
	
	@FindBy(xpath="//span[@class='filter-option pull-left'][normalize-space()='Agricultural']")
	WebElement Commodity_Segment_Btn;
	
	@FindBy(xpath="//span[@class='text'][normalize-space()='Agricultural']")
	WebElement Agricultural_Btn;
	
	@FindBy(xpath="//span[normalize-space()='Non-Agricultural']")
	WebElement Non_Agricultural_Btn;
	
	
	@FindBy(xpath = "(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[5]")
	WebElement Commodity_Code;

	@FindBy(xpath = "(//input[@type='text'])[26]")
	WebElement Commodity_text;

	@FindBy(xpath = "(//input[@id='eff_Start_date'])[1]")
	WebElement eff_Start_date;

	@FindBy(xpath = "(//td[@class='today active start-date active end-date in-range available'])[1]")
	WebElement eff_Start_date_Active;

	@FindBy(xpath = "//input[@type='text' and @name='pledgee_Client_Id' and @ng-model='vm.PledgeCreation.Input_Client_Id' and @ng-blur='getClientCode($event)' and @ng-required='isnotinterReq' and @ng-disabled='DisableEdit']")
	WebElement pledgee_Client_Id;

	@FindBy(xpath = "//input[@name='ifsc_Code']")
	WebElement ifsc_Text;

	@FindBy(xpath = "(//button[normalize-space()='...'])[1]")
	WebElement Receipt_list;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Search...']")
	WebElement Search_Text;

	@FindBy(xpath = "//button[@ng-click='vm.GetDetails()']//i[@class='icon-magnifier']")
	WebElement Search_Button;

	@FindBy(xpath = "(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]")
	WebElement Select_Button;

	@FindBy(xpath = "(//input[@name='no_of_bags'])[1]")
	WebElement Bag_no;

	@FindBy(xpath = "(//input[@name='pledge_value'])[2]")
	WebElement pledge_value_txt;

	@FindBy(xpath = "(//input[@name='remark'])[1]")
	WebElement Remark;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement Verify_Button;

	@FindBy(xpath = "//button[@button-busy='vm.saving']")
	WebElement Save_Button;

	public void Pledge_Creation_Request() throws InterruptedException {
		
		Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		// Assert.assertTrue(Transaction_Btn.isDisplayed(), "Transaction button not
		// visible");

		Wait.until(ExpectedConditions.elementToBeClickable(Pledge_Creation)).click();
		// Assert.assertTrue(Pledge_Creation.isDisplayed(), "Pledge_Creation button not
		// visible");

		New_Button.click();
		// Assert.assertTrue(New_Button.isDisplayed(), "New button not visible");

		try {
			if (String.valueOf(pledge_Req_Number).matches("^[a-zA-Z0-9]{0,15}$")) {
				pledge_Req_No.sendKeys(String.valueOf(pledge_Req_Number));
			} else {
				System.out.println("pledge_Req_Number is Invalid");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying pledge_Req_No JavaScript click...");
			js.executeScript("arguments[0].click();", pledge_Req_No);
			js.executeScript("arguments[0].value='" + pledge_Req_Number + "';", pledge_Req_No);
			// js.executeScript("arguments[0].click();", Deposite_No);
		} catch (NoSuchElementException e) {
			System.out.println("pledge_Req_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for pledge_Req_No: " + e.getMessage());
		}
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(Request_Date)).click();
		
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(Request_Date_Active)).click();
		
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(Execution_Date)).click();
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(Execution_Date_Active)).click();

		// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try {
			if (Client_id.isDisplayed()) {
				if (String.valueOf(Client_ID).matches("^[a-zA-Z0-9]{0,16}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(Client_id)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(Client_id_Text))
							.sendKeys(String.valueOf(Client_ID));
					Client_id_Text.sendKeys(Keys.ENTER);
				} else {
					System.out.println("Client_id_Text is not visible");
				}
			} else {
				System.out.println("Client_ID is Invalid");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Client_id JavaScript click...");
			js.executeScript("arguments[0].click();", Client_id);
			js.executeScript("arguments[0].value='" + Client_ID + "';", Client_id_Text);
			js.executeScript("arguments[0].click();", Client_id_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Client_id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Client_id: " + e.getMessage());
		}
		try {
			if (WH_ID.isDisplayed()) {
				if (String.valueOf(WH_id).matches("^[a-zA-Z0-9]{7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(WH_ID_Text)).sendKeys(String.valueOf(WH_id));
					WH_ID_Text.sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters");
				}
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Client_id JavaScript click...");
			js.executeScript("arguments[0].click();", Client_id);
			js.executeScript("arguments[0].value='" + Client_ID + "';", Client_id_Text);
			js.executeScript("arguments[0].click();", Client_id_Text);
		} catch (NoSuchElementException e) {
			System.out.println("pledge_Req_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for pledge_Req_No: " + e.getMessage());
		}
		// js.executeScript("arguments[0].scrollIntoView(true);", Commodity_Code);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Segment_Btn)).click();
		
		if(Commodity_Segment.equals(Agricultural1)) {
			Wait.until(ExpectedConditions.elementToBeClickable(Agricultural_Btn)).click();
			
		}else if(Commodity_Segment.equals(Agricultural2)){
			Wait.until(ExpectedConditions.elementToBeClickable(Non_Agricultural_Btn)).click();
		}else {
			System.out.println("Commodity_Segment is not valid");
		}
		
		
		try {
			if (String.valueOf(Commodity).matches("^[0-9]{0,4}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Commodity_Code)).click();
				Wait.until(ExpectedConditions.visibilityOf(Commodity_text)).sendKeys(String.valueOf(Commodity));
						//(Commodity_text)).sendKeys(String.valueOf(Commodity));
				System.out.println("Commodity code is :"+Commodity);
				WebElement Active =driver.findElement(By.xpath("//div[@class='btn-group bootstrap-select form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required dropup open']//li[@class='active']//a"));
				Wait.until(ExpectedConditions.visibilityOf(Active)).click();
				//Wait.until(ExpectedConditions.visibilityOf(Commodity_text)).sendKeys(Keys.ENTER);
				//Wait.until(ExpectedConditions.elementToBeClickable(Commodity_text)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Commodity_Code. Please enter exactly 4 alphanumeric characters");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Commodity_Code JavaScript click...");
			js.executeScript("arguments[0].click();", Commodity_Code);
			js.executeScript("arguments[0].value='" + Commodity + "';", Commodity_text);
			js.executeScript("arguments[0].click();", Commodity_text);
		} catch (NoSuchElementException e) {
			System.out.println("Commodity_Code not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Commodity_Code: " + e.getMessage());
		} /*finally {
			System.out.println("Commodity_Code should be click");
			js.executeScript("arguments[0].click();", Commodity_Code);
			js.executeScript("arguments[0].value='" + Commodity + "';", Commodity_text);
			js.executeScript("arguments[0].click();", Commodity_text);
		}*/

		eff_Start_date.click();

		eff_Start_date_Active.click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		if (String.valueOf(pledgee_Client).matches("^[a-zA-Z0-9]{0,15}$")) {
			pledgee_Client_Id.sendKeys(String.valueOf(pledgee_Client));
		} else {
			System.out.println(" Invalid pledgee_Client. Please enter exactly 15 alphanumeric characters");
		}

		if (ifsc_Text.isDisplayed()) {
			ifsc_Text.sendKeys(ifsc_Code);
		} else {
			System.out.println("ifsc_Text is not visible");
		}

		Receipt_list.click();

		try {
			if (String.valueOf(ENWR).matches("^[a-zA-Z0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_Text)).sendKeys(String.valueOf(ENWR));
				System.out.println("ENWR value is :"+ENWR);
			} else {
				System.out.println("Invalid Commodity_Code. Please enter 15 numeric characters");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Search_Text JavaScript click...");
			js.executeScript("arguments[0].value='" + ENWR + "';", Search_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Search_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_Text: " + e.getMessage());
		}

		Search_Button.click();
		
	Thread.sleep(4000);
		Wait.until(ExpectedConditions.elementToBeClickable(Select_Button)).click();
		try {
			if (String.valueOf(Bags).matches("^[0-9]{0,4}$")) {
				Bag_no.sendKeys(String.valueOf(Bags));
			} else {
				System.out.println("Invalid Bag_no. Please enter 4 numeric characters");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Bag_no JavaScript click...");
			js.executeScript("arguments[0].value='" + Bags + "';", Bag_no);
		} catch (NoSuchElementException e) {
			System.out.println("Bag_no not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Bag_no:" + e.getMessage());
		}

		pledge_value_txt.sendKeys(String.valueOf(pledge_value));

		Wait.until(ExpectedConditions.elementToBeClickable(Remark)).sendKeys("Done");
		
		try {
			if (Verify_Button.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_Button)).click();
			} else {
				System.out.println("Verify_Button is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Verify_Button JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_Button);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_Button not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_Button: " + e.getMessage());
		}
		try {
			if (Save_Button.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Button)).click();
			} else {
				System.out.println("Save_Button is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Save_Button JavaScript click...");
			js.executeScript("arguments[0].click();", Save_Button);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Button not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Button: " + e.getMessage());
		}

	}

	

}
