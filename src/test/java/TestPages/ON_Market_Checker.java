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

public class ON_Market_Checker {
	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ON_Market_Checker(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Depledge_Request creation process-------------
	@FindBy(xpath = "//span[normalize-space()='Masters']")
	WebElement Masters_Btn;

	@FindBy(xpath = "//a[@ui-sref='Masters.Settlement']//span[@class='title ng-binding'][normalize-space()='Settlement']")
	WebElement Settlement_Btn;

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "//span[normalize-space()='OnMarket']")
	WebElement OnMarket_Btn;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Search_btn;

	@FindBy(xpath = "(//button[@class='btn btn-xs btn-primary blue dropdown-toggle'][normalize-space()='Actions'])[1]")
	WebElement Actions_btn;

	@FindBy(xpath = "//body/ul[@class='dropdown-menu']/li[2]/a[1]")
	WebElement Authorize_btn;

	@FindBy(xpath = "//label[normalize-space()='Authorized']")
	WebElement Authorized_chk;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_btn;

	public void Settlement_Master_Checker() throws InterruptedException {

		try {
			//if (Masters_Btn.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(Masters_Btn)).click();
				/*
				 * } else { System.out.println("Masters_Btn is not visible"); }
				 */
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
			//if (Settlement_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Settlement_Btn)).click();
				/*
				 * } else { System.out.println("Settlement_Btn is not visible"); }
				 */
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Settlement_Btn click...");
			js.executeScript("arguments[0].click();", Settlement_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Settlement_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Settlement_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Search_txt)).sendKeys(String.valueOf(Settlement_Master_CC_Login.settlement_No));

		try {
		Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		Thread.sleep(1000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_btn click...");
			js.executeScript("arguments[0].click();", Actions_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_chk)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Authorized_chk click...");
			js.executeScript("arguments[0].click();", Authorized_chk);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_chk not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_chk: " + e.getMessage());
		}

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

	public void On_Market_Checker() throws InterruptedException {

		try {

			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
			
		}
		Thread.sleep(2000);
		try {

			Wait.until(ExpectedConditions.elementToBeClickable(OnMarket_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying OnMarket_Btn click...");
			js.executeScript("arguments[0].click();", OnMarket_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("OnMarket_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for OnMarket_Btn: " + e.getMessage());
		}

		Search_txt.sendKeys(String.valueOf(Settlement_Master_CC_Login.settlement_No));

		Search_btn.click();
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Actions_btn click...");
			js.executeScript("arguments[0].click();", Actions_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_chk)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Authorized_chk click...");
			js.executeScript("arguments[0].click();", Authorized_chk);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_chk not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_chk: " + e.getMessage());
		}

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
