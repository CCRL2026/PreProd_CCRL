package TestPages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class ClientCmLinking_Verfication {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData.xlsx";
	static String sheet = "Physical_Deposit_Maker";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet); 
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ClientCmLinking_Verfication(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Masters']")
	WebElement Masters_btn;

	// span[normalize-space()='Client CM Linking']
	@FindBy(xpath = "//span[normalize-space()='Client CM Linking']")
	WebElement Client_CM_Linking_bttn;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement Search_txt;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Search_bttn;
	
	@FindBy(xpath="//button[normalize-space()='Actions']")
WebElement 	Actions_Bttn;
	
	@FindBy(xpath="//a[normalize-space()='Authorization']")
	WebElement Authorization_bttn;
	
	@FindBy(xpath="//label[normalize-space()='Verify']")
	WebElement Verify_CheckBox;
	
	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify Fields')]")
	WebElement Verify_Button;
	
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement Save_Button;
	
	public void Client_CM_Linking_Verfication() {
		
		Masters_btn.click();
		
		Client_CM_Linking_bttn.click();
		
		Search_txt.sendKeys(String.valueOf(ClientCmLinking_RP.Client_Id));
		
		Search_bttn.click();
		
		Actions_Bttn.click();
		
		Authorization_bttn.click();
		
		Verify_CheckBox.isSelected();
		
		try {
			if (Verify_Button.isEnabled()) {
				Verify_Button.click();
			} else {
				System.out.println("Verify_Button is not enable");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_Button click...");
			js.executeScript("arguments[0].click();", Verify_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

		try {
			if (Save_Button.isDisplayed()) {
				Save_Button.click();
			} else {
				System.out.println("Save_Button is not Visible ");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
	}
	
}
