package TestPages;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class Deposit_Confirm_WH_Maker {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Deposit_Confirm_WH_Maker(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Transactions'])[1]")
	WebElement Transaction_Btn;

	@FindBy(xpath = "//span[normalize-space()='Deposit Confirm WH']")
	WebElement Deposit_Confirm_WH_btn;

	@FindBy(xpath = "//a[normalize-space()='Pending for Deposit Confirm']")
	WebElement PendingforDeposit;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_btn;

	@FindBy(xpath = "(//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED'])[1]")
	WebElement Warehouse_id;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement Warehouse_id_Txt;

	@FindBy(xpath = "//input[@name='location']")
	WebElement Deposite_ID;

	@FindBy(xpath = "//input[@ng-class=\"{'edited':vm.CreateDepositWspWh.sample_id}\"]")
	WebElement Sample_id_txt;

	@FindBy(xpath = "(//button[normalize-space()='Search'])[1]")
	WebElement Search_btn;

	@FindBy(xpath = "(//button[normalize-space()='Select'])[1]")
	WebElement Select_btn;

	@FindBy(xpath = "//input[@name='shelflife']")
	WebElement shelflife_txt;

	@FindBy(xpath = "//a[normalize-space()='Lot Details']")
	WebElement Lot_Details;

	@FindBy(xpath = "//a[normalize-space()='View Report']")
	WebElement View_Report;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Records_Not_Found_popup;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement Verify_btn;

	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement save_btn;

	public void Deposit_Confirm_WH() {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
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
			Wait.until(ExpectedConditions.elementToBeClickable(New_btn)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", New_btn);
		} catch (NoSuchElementException e) {
			System.out.println("New_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_btn: " + e.getMessage());
		}
		try {
			if (RP_Deposite_Request_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id)).click();
				Warehouse_id_Txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.WH_ID));
				Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Warehouse_id click...");
			js.executeScript("arguments[0].click();", Warehouse_id);
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.WH_ID + "';",
					Warehouse_id_Txt);
			js.executeScript("arguments[0].click();", Warehouse_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Warehouse_id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Warehouse_id: " + e.getMessage());
		}
		try {
			if (RP_Deposite_Request_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{7}$")) {
				Deposite_ID.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite));
			} else {
				System.out.println("Invalid Deposit_Type. Please enter exactly 20 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposite_ID click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite + "';",
					Warehouse_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Deposite_ID not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposite_ID: " + e.getMessage());
		}
		// Sample_id_txt.sendKeys(String.valueOf(RP_Deposite_Request_Maker.Deposite));

		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Select_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Select_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Select_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_btn: " + e.getMessage());
		}

		// shelflife_txt.sendKeys("300");

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
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for : " + e.getMessage());
		}

		try {
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

		System.out.println("--------------------WareHouse_Confirmation_Checker is Done-------------------------");
	}

	public void Exchange_Deposit_Confirm_WH() {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
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
			New_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", New_btn);
		} catch (NoSuchElementException e) {
			System.out.println("New_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_btn: " + e.getMessage());
		}

		try {
			if (RP_Exchange_Deposite_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
				Warehouse_id.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt))
						.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.WH_ID));
				Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Warehouse_id click...");
			js.executeScript("arguments[0].click();", Warehouse_id);
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.WH_ID + "';",
					Warehouse_id_Txt);
			js.executeScript("arguments[0].click();", Warehouse_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Warehouse_id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Warehouse_id: " + e.getMessage());
		}
		try {
			if (RP_Exchange_Deposite_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{7}$")) {
				Deposite_ID.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite));
			} else {
				System.out.println("Invalid Deposite. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "';",
					Warehouse_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Select_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Select_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Select_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_btn: " + e.getMessage());
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

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
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for : " + e.getMessage());
		}

		try {
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

		System.out.println(
				"--------------------Exchange_WareHouse_Confirmation_Checker is Done-------------------------");

	}

	public void Exchange_Non_Agriculture_Deposit_Confirm_WH() {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
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
			New_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", New_btn);
		} catch (NoSuchElementException e) {
			System.out.println("New_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_btn: " + e.getMessage());
		}
		try {
			if (Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt))
						.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID));
				Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt)).sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Warehouse_id click...");
			js.executeScript("arguments[0].click();", Warehouse_id);
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID + "';",
					Warehouse_id_Txt);
			js.executeScript("arguments[0].click();", Warehouse_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Warehouse_id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Warehouse_id: " + e.getMessage());
		}
		try {
			if (Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{7}$")) {
				Deposite_ID.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite));
			} else {
				System.out.println("Invalid Deposite. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "';",
					Warehouse_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Select_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Select_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Select_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_btn: " + e.getMessage());
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
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
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for : " + e.getMessage());
		}

		try {
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

	}

	public void Deposit_Confirm_WH_Agriculture_Multiple_GSL_Maker() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
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

			Wait.until(ExpectedConditions.elementToBeClickable(Records_Not_Found_popup)).click();
		} /*
			 * catch (ElementClickInterceptedException e) { System.out.
			 * println("Normal click failed, trying  Records_Not_Found_popup click...");
			 * js.executeScript("arguments[0].click();", Records_Not_Found_popup); }
			 */ catch (NoSuchElementException e) {
			System.out.println("Records_Not_Found_popup not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Records_Not_Found_popup: " + e.getMessage());
		}

		for (int i = 1; i <= DashBoard_WareHouse_Checker.totalBags; i++) {
			Thread.sleep(2000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(New_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", New_btn);
			} catch (NoSuchElementException e) {
				System.out.println("New_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for New_btn: " + e.getMessage());
			}
			Thread.sleep(1000);
			try {
				if (RP_Deposite_Request_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id)).click();
					Warehouse_id_Txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.WH_ID));
					Thread.sleep(1000);
					Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt)).sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Warehouse_id click...");
				js.executeScript("arguments[0].click();", Warehouse_id);
				js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.WH_ID + "';",
						Warehouse_id_Txt);
				js.executeScript("arguments[0].click();", Warehouse_id_Txt);
			} catch (NoSuchElementException e) {
				System.out.println("Warehouse_id not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Warehouse_id: " + e.getMessage());
			}
			try {
				if (RP_Deposite_Request_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{7}$")) {
					Deposite_ID.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite));
				} else {
					System.out.println("Invalid Deposit_Type. Please enter exactly 20 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Deposite_ID click...");
				js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite + "';",
						Warehouse_id_Txt);
			} catch (NoSuchElementException e) {
				System.out.println("Deposite_ID not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Deposite_ID: " + e.getMessage());
			}
			try {
				Sample_id_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite + i));
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Sample_id_txt click...");
				js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite + i + "';",
						Sample_id_txt);
			} catch (NoSuchElementException e) {
				System.out.println("Sample_id_txt not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Sample_id_txt: " + e.getMessage());
			}
			try {
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Select_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Select_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Select_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Select_btn: " + e.getMessage());
			}

			// shelflife_txt.sendKeys("300");

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
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for : " + e.getMessage());
			}

			try {
				if (save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
					Thread.sleep(1000);
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for save_btn: " + e.getMessage());
			}
			Thread.sleep(3000);
		}

	}

	public void Exchange_Deposit_Confirm_WH_Agriculture_Multiple_GSL() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
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
		for (int i = 1; i <= DashBoard_WareHouse_Checker.totalBags; i++) {
			Thread.sleep(3000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(New_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", New_btn);
			} catch (NoSuchElementException e) {
				System.out.println("New_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for New_btn: " + e.getMessage());
			}
			Thread.sleep(2000);
			try {
				if (RP_Exchange_Deposite_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt))
							.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.WH_ID));
					Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt)).sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Warehouse_id click...");
				js.executeScript("arguments[0].click();", Warehouse_id);
				js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.WH_ID + "';",
						Warehouse_id_Txt);
				js.executeScript("arguments[0].click();", Warehouse_id_Txt);
			} catch (NoSuchElementException e) {
				System.out.println("Warehouse_id not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Warehouse_id: " + e.getMessage());
			}
			try {
				if (RP_Exchange_Deposite_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{7}$")) {
					Deposite_ID.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite));
				} else {
					System.out.println("Invalid Deposite. Please enter exactly 7 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "';",
						Warehouse_id_Txt);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

			try {

				Sample_id_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite + i));
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + i + "';",
						Warehouse_id_Txt);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}

			Thread.sleep(2000);
			try {

				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Select_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Select_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Select_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Select_btn: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Lot_Details)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Lot_Details);
			} catch (NoSuchElementException e) {
				System.out.println("Lot_Details not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Lot_Details: " + e.getMessage());
			}

			// js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			try {
				Wait.until(ExpectedConditions.elementToBeClickable(View_Report)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", View_Report);
			} catch (NoSuchElementException e) {
				System.out.println("View_Report not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for View_Report: " + e.getMessage());
			}
			try {
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for : " + e.getMessage());
			}

			try {
				if (save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
					Thread.sleep(3000);
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for save_btn: " + e.getMessage());
			}
			Thread.sleep(3000);
		}

	}

	public void Exchange_Deposit_Confirm_WH_Non_Agriculture_Multiple_GSL() throws InterruptedException {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
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
		for (int i = 1; i <= Exchange_Non_Agri_WareHouse.totalBags; i++) {
			Thread.sleep(3000);
			try {
				New_btn.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", New_btn);
			} catch (NoSuchElementException e) {
				System.out.println("New_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for New_btn: " + e.getMessage());
			}
			Thread.sleep(2000);
			try {
				if (Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
					Warehouse_id.click();
					Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt))
							.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID));
					Wait.until(ExpectedConditions.elementToBeClickable(Warehouse_id_Txt)).sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Warehouse_id click...");
				js.executeScript("arguments[0].click();", Warehouse_id);
				js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID + "';",
						Warehouse_id_Txt);
				js.executeScript("arguments[0].click();", Warehouse_id_Txt);
			} catch (NoSuchElementException e) {
				System.out.println("Warehouse_id not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Warehouse_id: " + e.getMessage());
			}
			Thread.sleep(1000);
			try {
				if (Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{7}$")) {
					Deposite_ID.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite));
				} else {
					System.out.println("Invalid Deposite. Please enter exactly 7 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript(
						"arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "';",
						Warehouse_id_Txt);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			Thread.sleep(1000);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			try {
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			WebElement Select_btn = driver.findElement(
					By.xpath("(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]"));
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Select_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Select_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Select_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Select_btn: " + e.getMessage());
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

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
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for : " + e.getMessage());
			}

			try {
				if (save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for save_btn: " + e.getMessage());
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		}
	}

	public void Deposit_Confirm_Pending_CR118() throws InterruptedException {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
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
		Thread.sleep(1000);

		if (PendingforDeposit.isDisplayed()) {

			PendingforDeposit.click();
		} else {
			System.out.println("Pending for Deposit Confirm is not visible");
		}
		Thread.sleep(1000);
	}

}
