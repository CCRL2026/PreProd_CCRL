package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
//import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.DataBaseUtility;

public class RP_Deposite_Request_Checker {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	String Document = "PAN CARD (I)";
	String OTP_Auth;

	public RP_Deposite_Request_Checker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Bttn_Xpath;

	@FindBy(xpath = "//span[normalize-space()='Deposit Request']")
	WebElement Deposit;

	@FindBy(xpath = "//body/div[@class='page-container']/div[@class='page-sidebar-wrapper ng-scope']/div[@class='page-sidebar navbar-collapse collapse ng-scope']/ul[@class='page-sidebar-menu ng-scope']/li[2]/a[1]")
	WebElement Client;

	@FindBy(xpath = "//span[normalize-space()='Account Opening']")
	WebElement Account_Opening;
	
	@FindBy(xpath = "//span[normalize-space()='Masters']")
	WebElement Masters_btn;
	
	@FindBy(xpath = "//span[normalize-space()='TM CM Linking']")
	WebElement TM_CM_Linking_bttn;

	@FindBy(xpath = "//span[normalize-space()='Client CM Linking']")
	WebElement Client_CM_Linking_bttn;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_TextBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_btn;

	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select_CA;

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement caret;

	@FindBy(xpath = "(//a[normalize-space()='Authorize'])[1]")
	WebElement Authorize_Exch;
	
	@FindBy(xpath="//a[normalize-space()='Authorized']")
	WebElement Authorized_TM_CM_Linking;

	@FindBy(xpath = "//body/ul[@class='dropdown-menu']/li[2]/a[1]")
	WebElement Authorize_CA;

	@FindBy(xpath = "//input[contains(@class, 'form-control') and @name='auth_code']")
	WebElement Auth_Code;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit_CA;

	@FindBy(xpath = "//a[normalize-space()='Authorize']")
	WebElement Authorize_btn;

	@FindBy(css = "label[for='EditDeposit_Checked'] span[class='box'")
	WebElement Authorize_page;
	@FindBy(xpath = "//label[normalize-space()='Authorize']")
	WebElement Authorizee_pag_GA;

	@FindBy(xpath="(//span[@class='box'])[4]")
	WebElement Authorize_page_TM_CM;
	
	@FindBy(xpath = "//label[@for='EditClient_Checked']//span[@class='box']")
	WebElement Authorizee_CA;

	// "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	@FindBy(xpath = "//button[contains(@class, 'btn') and contains(@class, 'blue')]//span[text()='Verify']")
	WebElement Verify_btn;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement Verify_CA;

	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope']")
	WebElement Save_btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_CA;

	@FindBy(xpath = "//select[@id='IncomeRangeSelectionCombobox']")
	WebElement Document_Type;

	@FindBy(xpath = "//button[@ng-click='vm.uploaderClick();']")
	WebElement uploadElement;

	@FindBy(xpath = "//a[normalize-space()='Authorized Signatories']")
	WebElement Signatories;

	@FindBy(xpath = "//input[@name='contact_No']")
	WebElement contact_No;
	
	@FindBy(xpath = "//a[normalize-space()='Nominee Detail']")
	WebElement Nominee_Detail_Tab;

	@FindBy(xpath = "//button[@id='Authperson14001']")
	WebElement upload_Auth;

	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope']")
	WebElement Sub_CA;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement scroll;

	public void Deposite_Request() throws InterruptedException {
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Transaction Button to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn_Xpath)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  Transaction_Bttn_Xpath click...");
			js.executeScript("arguments[0].click();", Transaction_Bttn_Xpath);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
		}
		// Deposit function to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit click...");
			js.executeScript("arguments[0].click();", Deposit);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit: " + e.getMessage());
		}
		try {
			Search_TextBox.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_TextBox click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite + "';",
					Search_TextBox);
		} catch (NoSuchElementException e) {
			System.out.println("Search_TextBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for  Search_TextBox: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// WebElement scroll = driver.findElement(By.xpath("//div[@role='dialog']"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		// Define FluentWait
		/*
		 * FluentWait<WebDriver> fluentWait = new
		 * FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)) // Total wait //
		 * time .pollingEvery(Duration.ofSeconds(2)) // Check every 2 seconds
		 * .ignoring(NoSuchElementException.class) // Ignore not found
		 * .ignoring(ElementClickInterceptedException.class); // Optional: ignore click
		 * issues
		 * 
		 * try { WebElement Authorize_page = fluentWait.until(driver -> { WebElement el
		 * = driver.findElement(By.
		 * cssSelector("label[for='EditDeposit_Checked'] span[class='box'")); if
		 * (el.isDisplayed() && el.isEnabled()) {
		 * //System.out.println("value of e1:"+el); return el;
		 * 
		 * } return null; });
		 */
			/*
			 * // Click the element after wait elementToClick.click();
			 * System.out.println("Element clicked successfully."); } catch
			 * (TimeoutException e) {
			 * System.out.println("Element not clickable within timeout: " +
			 * e.getMessage()); }
			 */
		
			Thread.sleep(3000);
			try {
			if (Authorize_page.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_page)).click();
				//Authorize_page.click();
			} else {
				System.out.println("Authorize_page is not clickable");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_page click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Authorize_page);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
		}
		try {
			if (Save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
		System.out.println("--------------------RP Checker is Done-------------------------");
	}

	public void Exchange_Deposite_Deposite_Request() throws InterruptedException {
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Transaction Button to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn_Xpath)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Bttn_Xpath);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
		}
		// Deposit function to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit: " + e.getMessage());
		}
		try {
			Search_TextBox.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_TextBox click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "';",
					Search_TextBox);
		} catch (NoSuchElementException e) {
			System.out.println("Search_TextBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for  Search_TextBox: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		Thread.sleep(1000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Exch)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		try {
			if (Authorizee_pag_GA.isDisplayed()) {
				// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				Wait.until(ExpectedConditions.elementToBeClickable(Authorizee_pag_GA)).click();
				// Authorize_page.click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Authorizee_pag_GA);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
		}
		try {
			if (Save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
		System.out.println(
				"--------------------Exchange_Deposite_Deposite_Request Checker is Done-------------------------");

	}

	public void Government_Agency_Deposite_Request() throws InterruptedException {
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Transaction Button to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn_Xpath)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Bttn_Xpath);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
		}
		// Deposit function to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit: " + e.getMessage());
		}
		try {
			Search_TextBox.sendKeys(String.valueOf(Government_Agency_Deposite_Request_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_TextBox click...");
			js.executeScript("arguments[0].value='" + Government_Agency_Deposite_Request_Maker.Deposite + "';",
					Search_TextBox);
		} catch (NoSuchElementException e) {
			System.out.println("Search_TextBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for  Search_TextBox: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		try {
			caret.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}
		try {
			Authorize_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// WebElement scroll = driver.findElement(By.xpath("//div[@role='dialog']"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		try {
			if (Authorizee_pag_GA.isDisplayed()) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				Wait.until(ExpectedConditions.elementToBeClickable(Authorizee_pag_GA)).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_page click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Authorize_page);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		} /*
			 * finally { System.out.println("Finally Run ");
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			 * Wait.until(ExpectedConditions.elementToBeClickable(Authorizee_pag_GA)).click(
			 * ); driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); }
			 */
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
		}
		try {
			if (Save_btn.isDisplayed()) {

				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();

			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
		System.out.println(
				"--------------------Government_Agency_Deposite_Request Checker is Done-------------------------");

	}

	public void Exchange_Deposite_Request_Non_Agriculture_Checker() throws InterruptedException {
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Transaction Button to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn_Xpath)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Bttn_Xpath);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
		}
		// Deposit function to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit: " + e.getMessage());
		}
		try {
			Search_TextBox.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_TextBox click...");
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "';",
					Search_TextBox);
		} catch (NoSuchElementException e) {
			System.out.println("Search_TextBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for  Search_TextBox: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// WebElement scroll = driver.findElement(By.xpath("//div[@role='dialog']"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Thread.sleep(3000);
		try {
			if (Authorize_page.isDisplayed()) {
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_page)).click();
				// Wait.until(ExpectedConditions.elementToBeClickable(Authorize_page)).sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			js.executeScript("arguments[0].click();", Authorize_page);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
		}
		try {
			if (Save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
		System.out.println(
				"--------------------Exchange_Deposite_Request_Non_Agriculture Checker is Done-------------------------");

	}

	public void Client_Account_opening_Checker() {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String query_OTP = "SELECT a.auth_Code FROM auth_code_generation a JOIN client d ON a.ref_id = d.Id WHERE d.Holder_Name like ? and a.tran_type =\"CL\";";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			// stmt.setString(1, "%" + Client_Account_opening_For_RP.clientid_Num + "%"); //
			// bind the variable to query
			stmt.setString(1, "%" + Client_Account_opening_For_RP.Client_holder_Name + "%"); // bind the variable to
																								// query
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Client)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Account_Opening)).click();

		Search_TextBox.sendKeys(String.valueOf(Client_Account_opening_For_RP.Client_holder_Name));

		submit_btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_CA)).click();

		Auth_Code.sendKeys(OTP_Auth);

		Submit_CA.click();

		Nominee_Detail_Tab.click();
		
		try {
			if (Authorizee_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorizee_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorizee_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}

		try {
			if (Verify_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}
		try {
			if (Save_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}

		Search_TextBox.sendKeys(Client_Account_opening_For_RP.Client_holder_Name);
		submit_btn.click();

		Select_CA.click();

		Select S = new Select(Document_Type);
		S.selectByContainsVisibleText(Document);

		uploadElement.sendKeys("C:\\Users\\abhishekyt\\Pictures\\249_margin Pledge request confirm.PNG");

		Signatories.click();

		contact_No.sendKeys(String.valueOf(Client_Account_opening_For_RP.mobile_NUmber));

		upload_Auth.sendKeys("C:\\Users\\abhishekyt\\Pictures\\photo.PNG");

		try {
			if (Sub_CA.isDisplayed()) {
				Sub_CA.click();
			} else {
				System.out.println("Submit_CA is not visible ");
			}
		} catch (Exception e) {
			System.out.println("Unexpected error for Sub_CA: " + e.getMessage());
		}

	}
	
	public void Account_opening_for_CM_checker() throws InterruptedException {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String query_OTP = "SELECT a.auth_Code FROM auth_code_generation a JOIN client d ON a.ref_id = d.Id WHERE d.Holder_Name like ? and a.tran_type =\"CL\";";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			// stmt.setString(1, "%" + Client_Account_opening_For_RP.clientid_Num + "%"); //
			// bind the variable to query
			stmt.setString(1, "%" + Client_Account_opening_For_RP.Client_holder_Name + "%"); // bind the variable to
																								// query
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Client)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Account_Opening)).click();

		Search_TextBox.sendKeys(String.valueOf(Client_Account_opening_For_RP.Client_holder_Name));

		submit_btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_CA)).click();

		Auth_Code.sendKeys(OTP_Auth);

		Submit_CA.click();

		Thread.sleep(3000);
		try {
			if (Authorizee_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorizee_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorizee_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}

		try {
			if (Verify_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}
		try {
			if (Save_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
	}
	
	public void Account_opening_for_TM_checker() throws InterruptedException {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String query_OTP = "SELECT a.auth_Code FROM auth_code_generation a JOIN client d ON a.ref_id = d.Id WHERE d.Holder_Name like ? and a.tran_type =\"CL\";";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			// stmt.setString(1, "%" + Client_Account_opening_For_RP.clientid_Num + "%"); //
			// bind the variable to query
			stmt.setString(1, "%" + Client_Account_opening_For_RP.Client_holder_Name + "%"); // bind the variable to
																								// query
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Wait.until(ExpectedConditions.elementToBeClickable(Client)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Account_Opening)).click();

		Search_TextBox.sendKeys(String.valueOf(Client_Account_opening_For_RP.Client_holder_Name));

		submit_btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_CA)).click();

		Auth_Code.sendKeys(OTP_Auth);

		Submit_CA.click();

		Thread.sleep(3000);
		try {
			if (Authorizee_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorizee_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorizee_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}

		try {
			if (Verify_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}
		try {
			if (Save_CA.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_CA)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_CA);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
	}
	
	public void TM_CM_Linking_RP_Checker() throws InterruptedException {
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Masters_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Masters_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
		}
		// Deposit function to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(TM_CM_Linking_bttn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", TM_CM_Linking_bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit: " + e.getMessage());
		}
		try {
			Search_TextBox.sendKeys(String.valueOf(TM_CM_Linking_RP.TM_ID));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_TextBox click...");
			js.executeScript("arguments[0].value='" + TM_CM_Linking_RP.TM_ID + "';",
					Search_TextBox);
		} catch (NoSuchElementException e) {
			System.out.println("Search_TextBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for  Search_TextBox: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_TM_CM_Linking)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorized_TM_CM_Linking);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// WebElement scroll = driver.findElement(By.xpath("//div[@role='dialog']"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		Thread.sleep(2000);
		try {
			if (Authorize_page_TM_CM.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_page_TM_CM)).click();
				// Wait.until(ExpectedConditions.elementToBeClickable(Authorize_page)).sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			js.executeScript("arguments[0].click();", Authorize_page);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}
		/*
		 * try { if (Verify_btn.isDisplayed()) {
		 * Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click(); } }
		 * catch (ElementClickInterceptedException e) { System.out.
		 * println("Normal click failed, trying JavaScript Verify_btn click...");
		 * js.executeScript("arguments[0].click();", Verify_btn); } catch
		 * (NoSuchElementException e) { System.out.println("Verify_btn not found: " +
		 * e.getMessage()); } catch (Exception e) {
		 * System.out.println("Unexpected error for Verify_btn: " + e.getMessage()); }
		 */
		try {
			if (Save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
		System.out.println(
				"--------------------TM_CM_Linking_RP_Checker Checker is Done-------------------------");

	}

	public void ClientCmLinking_RP_Checker() throws InterruptedException {
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Masters_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Masters_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
		}
		// Deposit function to be Click
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Client_CM_Linking_bttn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Client_CM_Linking_bttn click...");
			js.executeScript("arguments[0].click();", Client_CM_Linking_bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Client_CM_Linking_bttn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Client_CM_Linking_bttn: " + e.getMessage());
		}
		try {
			Search_TextBox.sendKeys(String.valueOf(TM_CM_Linking_RP.TM_ID));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_TextBox click...");
			js.executeScript("arguments[0].value='" + TM_CM_Linking_RP.TM_ID + "';",
					Search_TextBox);
		} catch (NoSuchElementException e) {
			System.out.println("Search_TextBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for  Search_TextBox: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(caret)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_TM_CM_Linking)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript  Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorized_TM_CM_Linking);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// WebElement scroll = driver.findElement(By.xpath("//div[@role='dialog']"));
		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		Thread.sleep(2000);
		try {
			if (Authorize_page_TM_CM.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_page_TM_CM)).click();
				// Wait.until(ExpectedConditions.elementToBeClickable(Authorize_page)).sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			js.executeScript("arguments[0].click();", Authorize_page);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_page: " + e.getMessage());
		}
		/*
		 * try { if (Verify_btn.isDisplayed()) {
		 * Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click(); } }
		 * catch (ElementClickInterceptedException e) { System.out.
		 * println("Normal click failed, trying JavaScript Verify_btn click...");
		 * js.executeScript("arguments[0].click();", Verify_btn); } catch
		 * (NoSuchElementException e) { System.out.println("Verify_btn not found: " +
		 * e.getMessage()); } catch (Exception e) {
		 * System.out.println("Unexpected error for Verify_btn: " + e.getMessage()); }
		 */
		try {
			if (Save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error Save_btn: " + e.getMessage());
		}
		System.out.println(
				"--------------------ClientCmLinking_RP_Checker Checker is Done-------------------------");

		
	}	
	
	
}
