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

public class Margin_Pledge_Request_Approval {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Pledge.xlsx";
	static String sheet = "Pay_In_Release";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	
	public Margin_Pledge_Request_Approval(WebDriver driver, WebDriverWait Wait) {
		
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

//	 --------------for Request for Margin_Pledge_Request_Approval creation process-------------
	
	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	//a[@ui-sref='MarginPledges.marginpledgeApproval']
	@FindBy(xpath = "//span[normalize-space()='Margin Pledge Request Approval']")
	WebElement Margin_Pledge_Request_Approval_Btn;
	
	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;
	
	@FindBy(xpath="//input[@name='client_id']")
	WebElement client_id_Txt;
	
	@FindBy(xpath="//input[@name='commodity']")
	WebElement commodity_Txt;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement Search_Btn;
	
	@FindBy(xpath="(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]")
	WebElement Select_Btn;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement Save_Btn;
	
	
	public void Margin_Pledge_Request_Approval_Maker() throws InterruptedException {
		
		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();
		
		Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Request_Approval_Btn)).click();
		
		New_Btn.click();
		
		 client_id_Txt.sendKeys(String.valueOf(Margin_Pledge_Request.Client_Id)); 
		
		//commodity_Txt.sendKeys(String.valueOf(commodity));
		
		Search_Btn.click();
		
		Select_Btn.click();
		Thread.sleep(1000);
		
		
		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			} else {
				System.out.println("We are unable to click the Save_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}
		
	}
	
}
