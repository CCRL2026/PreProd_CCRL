package TestPages;

import java.time.Duration;
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

public class Depledge_Request_Authoriz {
	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Depledge_Request_Authoriz(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='auto ng-scope']//span[@class='title ng-binding'][normalize-space()='Transactions']")
	WebElement Transaction_btn;

	@FindBy(xpath = "//span[normalize-space()='Depledge Request']")
	WebElement Depledge_Request_button;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Depledge Confirm By Pledgee']")
	WebElement Depledge_Confirm_By_Pledgee_Button;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_Button;
	//button[normalize-space()='Actions']
	@FindBy(xpath = "(//button[normalize-space()='Actions'])[1]")
	WebElement Actions;

	@FindBy(xpath = "//a[normalize-space()='Authorize']")
	WebElement Authorize;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement Scroll;

	@FindBy(xpath = "//label[normalize-space()='Authorize']")
	WebElement Authorize_CheckBox;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save_Button;

	public void Depledge_Request_Checker() throws InterruptedException {

		Transaction_btn.click();

		Depledge_Request_button.click();

		Search.sendKeys(String.valueOf(Depledge_Request.pledge_Seq_No));

		submit_Button.click();

		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Actions click...");
			js.executeScript("arguments[0].click();", Actions);
		} catch (NoSuchElementException e) {
			System.out.println("Actions not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize click...");
			js.executeScript("arguments[0].click();", Authorize);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Scroll.sendKeys(Keys.PAGE_DOWN);
		Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		try {
			if (Authorize_CheckBox.isDisplayed()) {
				Authorize_CheckBox.click();
			} else {
				System.out.println("Authorize_CheckBox is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_CheckBox click...");
			js.executeScript("arguments[0].click();", Authorize_CheckBox);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized: " + e.getMessage());
		} finally {
			Authorize_CheckBox.click();
		}

		if (save_Button.isDisplayed() && save_Button.isEnabled()) {
			save_Button.click();
		} else {
			System.out.println("save_Button is not Visible");
		}

	}

	public void DePledge_Confirm_By_Pledgee_Checker() throws InterruptedException {

		Transaction_btn.click();

		Depledge_Confirm_By_Pledgee_Button.click();

		Search.sendKeys(String.valueOf(Depledge_Request.pledge_Seq_No));

		submit_Button.click();
		Thread.sleep(1000);
		try {
			//Wait.until(ExpectedConditions.elementToBeClickable(Actions)).click();
			Actions.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Actions click...");
			js.executeScript("arguments[0].click();", Actions);
		} catch (NoSuchElementException e) {
			System.out.println("Actions not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize click...");
			js.executeScript("arguments[0].click();", Authorize);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Scroll.sendKeys(Keys.PAGE_DOWN);
		Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		try {
			if (Authorize_CheckBox.isDisplayed()) {
				Authorize_CheckBox.click();
			} else {
				System.out.println("Authorize_CheckBox is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_CheckBox click...");
			js.executeScript("arguments[0].click();", Authorize_CheckBox);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized: " + e.getMessage());
		} finally {
			Authorize_CheckBox.click();
		}

		if (save_Button.isDisplayed() && save_Button.isEnabled()) {
			save_Button.click();
		} else {
			System.out.println("save_Button is not Visible");
		}
	}
}
