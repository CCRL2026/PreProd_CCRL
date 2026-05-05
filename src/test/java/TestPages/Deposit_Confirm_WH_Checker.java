package TestPages;

/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utillity.DataBaseUtility;*/
import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Deposit_Confirm_WH_Checker {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	int GSL_Count=DashBoard_WareHouse_Checker.totalBags;
	
	public Deposit_Confirm_WH_Checker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='auto ng-scope']//span[@class='title ng-binding'][normalize-space()='Transactions']")
	WebElement Transaction_btn;

	@FindBy(xpath = "//span[normalize-space()='Deposit Confirm WH']")
	WebElement Deposit_Confirm_WH_btn;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_txt;

	@FindBy(xpath = "//i[@class='icon-magnifier']")
	WebElement Search_btn;
	//button[normalize-space()='Actions']
	//(//button[normalize-space()='Actions'])[1]
	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement Action_btn;
	// body/ul[@class='dropdown-menu']/li[2]/a[1]

	// a[normalize-space()='Authorize']
	@FindBy(xpath = "//a[normalize-space()='Authorize']")
	WebElement Authorized_btn;
	
	@FindBy(xpath = "// body/ul[@class='dropdown-menu']/li[2]/a[1]")
	WebElement Authorized_GSL_btn;
	
	@FindBy(xpath = "//body/ul[@class='dropdown-menu']/li[2]/a[1]")
			WebElement Authorized_Non_btn;
	

	@FindBy(xpath = "//a[normalize-space()='Lot Details']")
	WebElement Lot_Details;

	@FindBy(xpath = "//a[normalize-space()='View Report']")
	WebElement View_Report;

	@FindBy(xpath = "//label[normalize-space()='Authorized']")
	WebElement Authorized_check_box;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement Verify_btn;

	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	WebElement Save_btn;

	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope']")
	WebElement Save_btn2;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement Save_btn1;
	
	public void Deposit_Confirm_WH() {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Confirm_WH_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Confirm_WH_btn click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm_WH_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_txt click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		try {
			Search_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Action_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Action_btn click...");
			js.executeScript("arguments[0].click();", Action_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Action_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Action_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
		}
		try {
			Lot_Details.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Lot_Details click...");
			js.executeScript("arguments[0].click();", Lot_Details);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_Details not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Details: " + e.getMessage());
		}
		try {
			View_Report.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript View_Report click...");
			js.executeScript("arguments[0].click();", View_Report);
		} catch (NoSuchElementException e) {
			System.out.println("View_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for View_Report: " + e.getMessage());
		}
		try {
			if (Authorized_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Authorized_check_box);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_check_box: " + e.getMessage());
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
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}
		System.out.println("--------------------WareHouse_Confirmation_Maker is Done-------------------------");

	}

	public void Exchange_Deposit_Confirm_WH() {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Confirm_WH_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm_WH_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}

		try {
			Search_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		try {
			Search_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Action_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Action_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Action_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Action_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
		}
		try {
			Lot_Details.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Lot_Details JavaScript click...");
			js.executeScript("arguments[0].click();", Lot_Details);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_Details not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Details: " + e.getMessage());
		}
		try {
			View_Report.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, View_Report JavaScript click...");
			js.executeScript("arguments[0].click();", View_Report);
		} catch (NoSuchElementException e) {
			System.out.println("View_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for View_Report: " + e.getMessage());
		}
		try {
			if (Authorized_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorized_check_box JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_check_box);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_check_box: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Verify_btn JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
		}

		try {
			if (Save_btn2.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn2)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Save_btn2);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}

		System.out.println("-------------------Exchange_WareHouse_Confirmation_Checker is Done-------------------------");

	}

	public void Exchange_Non_Agriculture_Deposit_Confirm_WH() {
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Confirm_WH_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm_WH_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		try {
			Search_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Action_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Action_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Action_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Action_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
		}
		try {
			Lot_Details.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Lot_Details);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_Details not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Details: " + e.getMessage());
		}
		try {
			View_Report.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", View_Report);
		} catch (NoSuchElementException e) {
			System.out.println("View_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for View_Report: " + e.getMessage());
		}
		try {
			if (Authorized_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_check_box);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_check_box: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
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
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}
	}

	public void Deposit_Confirm_WH_Agriculture_Multiple_GSL_Checker() throws InterruptedException {
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Confirm_WH_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Confirm_WH_btn click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm_WH_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		for(int i=1;  i<=DashBoard_WareHouse_Checker.totalBags;  i++) {
			Thread.sleep(3000);
		try {
			Search_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite+i));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_txt click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite +i + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Search_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());	
		}
	
		/*
		 * Define FluentWait FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		 * .withTimeout(Duration.ofSeconds(60)) // Total wait time
		 * .pollingEvery(Duration.ofSeconds(2)) // Check every 2 seconds
		 * .ignoring(NoSuchElementException.class) // Ignore not found
		 * .ignoring(ElementClickInterceptedException.class); // Optional: ignore click
		 * issues
		 * 
		 * WebElement Action_btn = fluentWait.until(driver -> { WebElement Action_bttn =
		 * driver.findElement(By.xpath("(//button[normalize-space()='Actions'])[1]"));
		 * if (Action_bttn.isDisplayed() && Action_bttn.isEnabled()) { return
		 * Action_bttn; } return null; });
		 */
		Thread.sleep(3000);
		    try {
		    	Wait.until(ExpectedConditions.elementToBeClickable(Action_btn)).click();
		   // Wait.until(ExpectedConditions.elementToBeClickable(Action_btn)).click();
		    //System.out.println("Element clicked successfully.");
		}catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Action_btn click...");
			js.executeScript("arguments[0].click();", Action_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Action_btn not found: " + e.getMessage());
		} catch (TimeoutException e) {
		    System.out.println("Action_btn not clickable within timeout: " + e.getMessage());
		}
		
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		//WebElement Authorize_btn_GS = driver.findElement(By.xpath( "(//a[@class='ng-scope'][normalize-space()='Authorize'])["+GSL_Count +"]"));
		//System.out.println("Action_btn_GS value of i:"+GSL_Count);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
		}  catch (StaleElementReferenceException e) {
			//driver.navigate().refresh();
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
		}catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_btn);
		/*} catch (StaleElementReferenceException e) {
		    // Try again
		  //  WebElement Authorized_btn_GSL = driver.findElement(By.xpath("//button[@id='authorizedButton']"));
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn_GS)).click();*/
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_btn_GSL not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_btn_GSL: " + e.getMessage());
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		try {
			Lot_Details.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Lot_Details click...");
			js.executeScript("arguments[0].click();", Lot_Details);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_Details not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Details: " + e.getMessage());
		}
		try {
			View_Report.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript View_Report click...");
			js.executeScript("arguments[0].click();", View_Report);
		} catch (NoSuchElementException e) {
			System.out.println("View_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for View_Report: " + e.getMessage());
		}
		try {
			if (Authorized_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Authorized_check_box);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_check_box: " + e.getMessage());
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
			if (Save_btn1.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn1)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn1 click...");
			js.executeScript("arguments[0].click();", Save_btn1);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn1 not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn1: " + e.getMessage());
		} /*
			 * finally {
			 * Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click(); }
			 */
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(Search_txt)).clear();
		Thread.sleep(2000);
		}
	}

	public void Exchange_Deposit_Confirm_WH_Agriculture_Multiple_GSL() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Confirm_WH_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm_WH_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		for(int i=1;  i<=DashBoard_WareHouse_Checker.totalBags;  i++) {
			Thread.sleep(3000);
		try {
			Search_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite+i));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Search_txt JavaScript click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite +i+ "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Search_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Search_btn JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		Thread.sleep(4000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Action_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Action_btn JavaScript click...");
			js.executeScript("arguments[0].click();", Action_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Action_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Action_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorized_btn JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
		}
		try {
			Lot_Details.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Lot_Details JavaScript click...");
			js.executeScript("arguments[0].click();", Lot_Details);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_Details not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Details: " + e.getMessage());
		}
		try {
			View_Report.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, View_Report JavaScript click...");
			js.executeScript("arguments[0].click();", View_Report);
		} catch (NoSuchElementException e) {
			System.out.println("View_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for View_Report: " + e.getMessage());
		}
		try {
			if (Authorized_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Authorized_check_box JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_check_box);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_check_box: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Verify_btn JavaScript click...");
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
			System.out.println("Normal click failed, Save_btn JavaScript click...");
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(Search_txt)).clear();
		Thread.sleep(2000);
		
		}
	}

	public void Exchange_Deposit_Confirm_WH_Non_Agriculture_Multiple_GSL() throws InterruptedException {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_btn: " + e.getMessage());
		}
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Confirm_WH_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm_WH_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		for(int i=1;  i<=Exchange_Non_Agri_WareHouse.totalBags;  i++) {
			Thread.sleep(3000);
		try {
			Search_txt.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Search_txt click...");
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		try {
			Search_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying  Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		Thread.sleep(3000);
		WebElement Actions_btn = driver.findElement(By.xpath("(//button[@class='btn btn-xs btn-primary blue dropdown-toggle'][normalize-space()='Actions'])["+i+"]"));
		//WebElement Actions_btn = driver.findElement(By.xpath("(//button[normalize-space()='Actions'])["+i+"]"));
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Actions_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed,trying Actions_btn click...");
			js.executeScript("arguments[0].click();", Actions_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Action_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Action_btn: " + e.getMessage());
		}
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_GSL_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Authorized_GSL_btn click...");
			js.executeScript("arguments[0].click();", Authorized_GSL_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_GSL_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_GSL_btn: " + e.getMessage());
		}
		try {
			Lot_Details.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Lot_Details);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_Details not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Details: " + e.getMessage());
		}
		try {
			View_Report.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", View_Report);
		} catch (NoSuchElementException e) {
			System.out.println("View_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for View_Report: " + e.getMessage());
		}
		try {
			if (Authorized_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_check_box);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_check_box: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
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
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(Search_txt)).clear();
		Thread.sleep(2000);
		
		}

	}

}
