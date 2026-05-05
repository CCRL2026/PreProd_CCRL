package TestPages;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utillity.DataBaseUtility;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;*/
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


public class Pledge_Invocation {
	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Pledge_Invocation.xlsx";
	static String sheet = "Pledge_Invocation";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	long Pledgee_Client_ID = excel.getPledge_Invocation_CLIENT_ID(dataRow);  // 181818180000016l;
	int pledge_Sequence_No = excel.getPledge_Invocation_pledge_Sequence_No(dataRow);   // 3188;
	static String pledge_Inv_Req_No = excel.getpledge_Inv_Req_No(dataRow);  // "9898989898";
	int no_of_bags= excel.get_Pledge_Invocation_no_of_bags(dataRow);  //1000;
	
	public Pledge_Invocation(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}
	// --------------for Request for Pledge creation process-------------
		@FindBy(xpath = "//span[normalize-space()='Transactions']")
		WebElement Transaction_Btn;

		@FindBy(xpath = "(//span[normalize-space()='Pledge Invocation'])[1]")
		WebElement Pledge_Invocation_Btn;

		@FindBy(xpath = "//button[normalize-space()='New']")
		WebElement New_Button;

		@FindBy(xpath = "(//input[@name='client_id'])[1]")
		WebElement client_id_Text;

		@FindBy(xpath = "//input[@ng-class=\"{'edited':vm.PledgeInvocation.pledge_Sequence_No}\"]")
		WebElement pledge_Sequence_No_txt;

		@FindBy(xpath = "//button[normalize-space()='Search']")
		WebElement Search_Button;

		@FindBy(xpath = "//button[normalize-space()='Select']")
		WebElement Select;
		// @FindBy(xpath="(//button[normalize-space()='Select'])[1]")

		@FindBy(xpath = "//input[@name='pledge_Inv_Req_No']")
		WebElement pledge_Inv_Req_No_Txt;
		
		@FindBy(xpath="//div[@placeholder='dd-mm-yyyy']//input[@id='Request_Date']")
		WebElement Request_Date_txt;
		
		@FindBy(xpath="(//td[@class='today active start-date active end-date available'])[1]")
		WebElement Request_Date;
		
		@FindBy(xpath="//input[@id='Execution_Date']")
		WebElement Execution_Date_txt;
		
		@FindBy(xpath="(//td[@class='today active start-date active end-date available'])[2]")
		WebElement Execution_Date;
		
		@FindBy(xpath="//input[@name='pledge_Inv_Init_Date']")
		WebElement pledge_Inv_Init_Date_txt;
		
		@FindBy(xpath="(//td[@class='today active start-date active end-date available'])[2]")
		WebElement pledge_Inv_Init_Date;
		
		@FindBy(xpath="//input[@name='pledge_Closure_Date']")
		WebElement pledge_Closure_Date_txt;
		
		@FindBy(xpath="(//td[@class='today active start-date active end-date available'])[6]")
		WebElement pledge_Closure_Date;
		
		@FindBy(xpath="//input[@name='no_of_bags']")
		WebElement no_of_bags_txt;
		
		@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
		WebElement Verify_Button;

		@FindBy(xpath = "//button[@button-busy='vm.saving']")
		WebElement Save_Button;

		
		
		public void Pledge_Invocation_Request() throws InterruptedException {

			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();

			Wait.until(ExpectedConditions.elementToBeClickable(Pledge_Invocation_Btn)).click();

			New_Button.click();

			client_id_Text.sendKeys(String.valueOf(Pledgee_Client_ID));

			pledge_Sequence_No_txt.sendKeys(String.valueOf(pledge_Sequence_No));

			Search_Button.click();

			Wait.until(ExpectedConditions.elementToBeClickable(Select)).click();

			pledge_Inv_Req_No_Txt.sendKeys(pledge_Inv_Req_No);
			
			Request_Date_txt.click();
			
			Request_Date.click();
			Thread.sleep(2000);
			Execution_Date_txt.click();
			
			Execution_Date.click();
			Thread.sleep(2000);
			pledge_Inv_Init_Date_txt.click();
			
			pledge_Inv_Init_Date.click();
			Thread.sleep(2000);
			pledge_Closure_Date_txt.click();
			
			pledge_Closure_Date.click();
			
			no_of_bags_txt.sendKeys(String.valueOf(no_of_bags));
			
			
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
