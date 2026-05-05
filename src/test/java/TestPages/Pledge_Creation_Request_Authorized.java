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


public class Pledge_Creation_Request_Authorized {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// public int pledge_Req_Number= 234567;

	public Pledge_Creation_Request_Authorized(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Pledge creation process-------------
	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;
	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Pledge Creation'])[1]")
	WebElement Pledge_Creation_tab;
	@FindBy(xpath = "//span[normalize-space()='Pledge Creation Approval']")
	WebElement Pledge_Creation_Approval;
	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Pledge Creation Confirmation']")
	WebElement Pledge_Creation_Confirmation;
	@FindBy(xpath = "(//input[@placeholder='Search...'])[1]")
	WebElement Search_Button;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement submit;
	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement Actions;
	@FindBy(xpath = "(//a[normalize-space()='Authorize'])[1]")
	WebElement Authorize;
	@FindBy(xpath = "//input[@type='text' and @ng-model='vm.PledgeCreation.pledge_Req_No' and @ng-name='pledge_Req_No']")
	WebElement Pledged;
	@FindBy(xpath = "//input[@name='status']")
	WebElement status;
	@FindBy(xpath = "//label[normalize-space()='Authorized']")
	WebElement Authorized;
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement Scroll;
	@FindBy(xpath = "(//button[@button-busy='vm.saving'])[1]")
	WebElement Save_Button;

	public void Pledge_Creation_Authorized() {

		Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Pledge_Creation_tab)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Button))
				.sendKeys(String.valueOf(Pledge_Creation.pledge_Req_Number));

		Wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
		
		Wait.until(ExpectedConditions.elementToBeClickable(Actions)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize)).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Scroll.sendKeys(Keys.PAGE_DOWN);
		Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		try {
		if (Authorized.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized)).click();
		} else {
			System.out.println("Authorized CheckBox is not Visible");
		}
		}catch(ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Authorized);
		}catch (NoSuchElementException e) {
			System.out.println("Authorized not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized: " + e.getMessage());
		}finally {
			Authorized.click();
		}
		try {
			if (Save_Button.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Button)).click();
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

	public void Pledge_Creation_WareHouse_Approval() {

		Transaction_Btn.click();

		Pledge_Creation_Approval.click();

		Search_Button.sendKeys(String.valueOf(Pledge_Creation.pledge_Req_Number));

		submit.click();

		Actions.click();

		if (Authorize.isDisplayed()) {
			Authorize.click();
		} else {
			System.out.println("Authorize Button is not Visible");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Scroll.sendKeys(Keys.PAGE_DOWN);
		Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		try {
		if (Authorized.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized)).click();
		} else {
			System.out.println("Authorized CheckBox is not Visible");
		}
		}catch(ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Authorized);
		}catch (NoSuchElementException e) {
			System.out.println("Authorized not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized: " + e.getMessage());
		}finally {
			Authorized.click();
		}

		if (Save_Button.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(Save_Button)).click();
			// Assert.assertTrue(Save_Button.isDisplayed(), "saving button not visible");
		} else {
			System.out.println("Save_Button is not Visible");
		}

	}

	public void pledgee_Creation_Auth() throws InterruptedException {

		Transaction_Btn.click();

		Pledge_Creation_Confirmation.click();

		Search_Button.sendKeys(String.valueOf(pledgee_Creation.Pledge_Confirm_code));

		submit.click();

		Actions.click();
		Thread.sleep(1000);
		Wait.until(ExpectedConditions.elementToBeClickable(Authorize)).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Scroll.sendKeys(Keys.PAGE_DOWN);
		Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		try {
		if (Authorized.isDisplayed()) {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized)).click();
		} else {
			System.out.println("Authorized CheckBox is not Visible");
		}
		}catch(ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorized click...");
			js.executeScript("arguments[0].click();", Authorized);
		}catch (NoSuchElementException e) {
			System.out.println("Authorized not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized: " + e.getMessage());
		}finally {
			Authorized.click();
		}

		if (Save_Button.isDisplayed()) {
			Save_Button.click();
			// Assert.assertTrue(Save_Button.isDisplayed(), "saving button not visible");
		} else {
			System.out.println("Save_Button is not Visible");
		}
	}

}
