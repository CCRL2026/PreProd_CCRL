 package TestPages;

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

public class Extension_Of_ENWR_Request_Warehouse {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Extension_Of_ENWR_Request_Warehouse(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transactions_Btn;

	@FindBy(xpath = "//span[normalize-space()='Extension Of Validity Wsp/Wh']")
	WebElement Extension_Of_Validity_Wsp_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//button[@data-id='EnwrSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement EnwrSelectionCombobox_Btn;
	

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement EnwrSelectionCombobox_Txt;
	
	@FindBy(xpath="//li[@class='active']//a")
	WebElement active_Btn;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit_Btn;

	@FindBy(xpath = "//a[normalize-space()='Lot Details']")
	WebElement Lot_Details_Btn;

	@FindBy(xpath = "//a[normalize-space()='Insurance Details']")
	WebElement Insurance_Details_Btn;

	@FindBy(xpath = "//a[normalize-space()='Verification']")
	WebElement Verification_Btn;

	@FindBy(xpath = "//a[normalize-space()='Depositor Detail']")
	WebElement Depositor_Detail_Btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Btn;

	public void Extension_Of_ENWR_Request_Warehouse_Maker() throws InterruptedException {

		Transactions_Btn.click();

		Extension_Of_Validity_Wsp_Btn.click();
		//Wait.until(ExpectedConditions.elementToBeClickable(Extension_Of_Validity_Wsp_Btn)).click();

		New_Btn.click();

		EnwrSelectionCombobox_Btn.click();

		EnwrSelectionCombobox_Txt.sendKeys(String.valueOf(Extension_Of_ENWR_Request.ENWR));
	//	EnwrSelectionCombobox_Txt.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		active_Btn.sendKeys(Keys.ENTER);

		Submit_Btn.click();

		Thread.sleep(1000);

		Lot_Details_Btn.click();

		Insurance_Details_Btn.click();

		Verification_Btn.click();

		Depositor_Detail_Btn.click();

		try {
			if (Save_Btn.isDisplayed()) {
				Save_Btn.click();
			} else {
				System.out.println("We are unable to click the save button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

	}

	public void Extension_Of_Validity_Confirm_Maker() throws InterruptedException {
		Transactions_Btn.click();

		Extension_Of_Validity_Wsp_Btn.click();
		//Wait.until(ExpectedConditions.elementToBeClickable(Extension_Of_Validity_Wsp_Btn)).click();

		New_Btn.click();

		EnwrSelectionCombobox_Btn.click();

		EnwrSelectionCombobox_Txt.sendKeys(String.valueOf(Extension_Of_ENWR_Request.ENWR));
	//	EnwrSelectionCombobox_Txt.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		active_Btn.sendKeys(Keys.ENTER);

		Submit_Btn.click();

		Thread.sleep(1000);

		Lot_Details_Btn.click();

		Insurance_Details_Btn.click();

		Verification_Btn.click();

		Depositor_Detail_Btn.click();

		try {
			if (Save_Btn.isDisplayed()) {
				Save_Btn.click();
			} else {
				System.out.println("We are unable to click the save button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
		
	}

}
