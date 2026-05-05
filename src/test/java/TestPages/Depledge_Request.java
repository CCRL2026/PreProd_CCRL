package TestPages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class Depledge_Request {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\PlageData.xlsx";
	static String sheet = "DPlageRequest";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	
	
	public static Long Pledgor_Client_ID =  excel.getPledgor_Client_ID(dataRow);
	public static int pledge_Seq_No =  excel.getpledge_Seq_No_D(dataRow);
	String location =  excel.getlocation(dataRow);
	int commodity =  excel.getcommodity_d(dataRow);
	int Pledge_Closure_Request_No =  excel.getPledge_Closure_Request_No(dataRow);
	int no_of_bags = excel.getno_of_bags(dataRow);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Depledge_Request(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Depledge_Request creation process-------------
	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;
	@FindBy(xpath = "//span[normalize-space()='Depledge Request']")
	WebElement Depledge_Request;
	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Button;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Records_Not_Found;
	@FindBy(xpath = "//input[@name='client_id' and @ng-model='vm.CreatePledgeClosure.client_id']")
	WebElement Pledgor_Client_ID_txt;
	@FindBy(xpath = "//input[@name='pledge_Seq_No']")
	WebElement pledge_Seq_No_txt;
	@FindBy(xpath = "//input[@name='location']")
	WebElement location_txt;
	@FindBy(xpath = "//input[@name='commodity']")
	WebElement commodity_txt;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Search_txt;
	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select;
	@FindBy(xpath = "//input[@name='PCRN']")
	WebElement PCRN_txt;
	@FindBy(xpath = "(//input[@name='no_of_bags'])[2]")
	WebElement D_no_of_bags;
	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement verify_button;
	@FindBy(xpath="//button[@button-busy='vm.saving']")
	WebElement save_button;

	public void Depledge_Request_Maker() {
		
		Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		
		try {
			Records_Not_Found.click();
			
		}catch(Exception e) {
		
			System.out.println("Records_Not_Found button Not Visible first");
		}
		
		
		Wait.until(ExpectedConditions.elementToBeClickable(Depledge_Request)).click();
		
		try {
			Records_Not_Found.click();
			
		}catch(Exception e) {
		
			System.out.println("Records_Not_Found button Not Visible Second");
		}
		
		Wait.until(ExpectedConditions.elementToBeClickable(New_Button)).click();
		try {
			if (Pledgor_Client_ID_txt.isDisplayed()) {
				if (String.valueOf(Pledgor_Client_ID).matches("^[a-zA-Z0-9]{0,16}$")) {
		Pledgor_Client_ID_txt.sendKeys(String.valueOf(Pledgor_Client_ID));
				} else {
					System.out.println("Invalid Client_ID. Please enter exactly 15 alphanumeric characters:");
				}
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Client_Id_Btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			js.executeScript("arguments[0].value='" + Pledgor_Client_ID + "';", Pledgor_Client_ID_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Client_Id_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Client_Id_Btn: " + e.getMessage());
		}
		pledge_Seq_No_txt.sendKeys(String.valueOf(pledge_Seq_No));
		
		location_txt.sendKeys(location);
		
		//commodity_txt.sendKeys(String.valueOf(commodity));
		
		Search_txt.click();
		
		Select.click();
		
		PCRN_txt.sendKeys(String.valueOf(Pledge_Closure_Request_No));
		
		D_no_of_bags.sendKeys(String.valueOf(no_of_bags));
		
		if(verify_button.isDisplayed()) {
		verify_button.click();
		}else {
			System.out.println("verify_button is not visible");
		}
		
		if(save_button.isDisplayed()) {
		save_button.click();
		}else {
			System.out.println("save_button is not visible");
		}
	}

}
