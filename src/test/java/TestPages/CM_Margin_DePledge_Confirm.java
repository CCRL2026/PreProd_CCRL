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

public class CM_Margin_DePledge_Confirm {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Pledge.xlsx";
	static String sheet = "Margin_Pledge_Request";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	public CM_Margin_DePledge_Confirm(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;
	
	@FindBy(xpath="(//span[@class='title ng-binding'][normalize-space()='CC De-Pledge Confirm'])[1]")
	WebElement CC_DePledge_Confirm_Btn;
	
	@FindBy(xpath="//button[normalize-space()='New']")
	WebElement New_Btn;
	
	@FindBy(xpath="//input[@name='client_id']")
	WebElement client_id_Txt;
	
	@FindBy(xpath="//input[@name='Pledge_Sequence_No']")
	WebElement Pledge_Sequence_No_Txt;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement Search_Btn;
	
	@FindBy(xpath="(//button[normalize-space()='Select'])[1]")
	WebElement Select_Btn;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement Save_Btn;
	
	

	public void Pledgor_CM_Margin_DePledge_Request_Confirm_Maker() throws InterruptedException {
		
		Margin_Pledge_Btn.click();
		
		CC_DePledge_Confirm_Btn.click();
		
		New_Btn.click();
		
		client_id_Txt.sendKeys(String.valueOf(CM_Margin_DePledge_Request.CM_Client_Id_DePledge));
		
		Pledge_Sequence_No_Txt.sendKeys(String.valueOf(CM_Margin_DePledge_Request.Pledge_Sequence_NoinCM));
		
		Search_Btn.click();
		
		Select_Btn.click();
		
		
		Thread.sleep(2000);
		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			
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
