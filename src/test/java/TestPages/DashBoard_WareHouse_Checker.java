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

import Utillity.ExcelUtils;

public class DashBoard_WareHouse_Checker {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ENWR_Creation.xlsx";
	static String sheet = "Physical_Deposit_Maker";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	String Bag_Total = excel.getBag_Total_py(dataRow);
	static int totalBags = excel.gettotalBags(dataRow);
	int updated_Bags;
	int j = 3;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public DashBoard_WareHouse_Checker(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Transactions'])[1]")
	WebElement Transaction_btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Deposit Government Agency']")
	WebElement Deposit_Government_Agency;

	@FindBy(xpath = "//span[normalize-space()='Physical Deposit']")
	WebElement Physical_Deposite;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Search_btn;

	@FindBy(xpath = "//span[@class='caret']")
	WebElement caret;

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement Actions;

	@FindBy(xpath = "(//a[normalize-space()='Authorize'])[1]")
	WebElement Authorize_btn;

	@FindBy(xpath = "(//input[@id='a'])[4]")
	WebElement no_of_bags;

	@FindBy(xpath = "//div[@ng-show='vm.enableforcheckerrecheck != false']//input[@id='a']")
	WebElement Gove_no_of_bags;

	@FindBy(xpath = "//input[@id='webbridge']")
	WebElement Weighbridge_Net_Weight;

	@FindBy(xpath = "//a[normalize-space()='Lot Details']")
	WebElement Lot_Details;

	@FindBy(xpath = "//input[@ng-class=\"{'edited':LotDetails.no_of_bag}\"]")
	WebElement no_of_bag;

	@FindBy(xpath = "//input[@name='no_of_bag' and @ng-model='LotDetails.no_of_bag']")
	WebElement no_of_bag_Non_Agri;

	@FindBy(xpath = "//input[@class='form-control input-ltr ng-pristine ng-empty ng-invalid ng-invalid-required ng-valid-maxlength ng-touched']")
	WebElement Sample_id;

	@FindBy(xpath = "//a[normalize-space()='Verification']")
	WebElement Verification_manu;

	@FindBy(xpath = "//a[normalize-space()='Depositor Detail']")
	WebElement Depositor_Detail_manu;

	@FindBy(xpath = "//label[normalize-space()='Deposit Assayer']")
	WebElement Deposit_Assayer_CheckBox;

	@FindBy(xpath = "//label[normalize-space()='Deposit Confirm']")
	WebElement Deposit_Confirm_CheckBox;

	@FindBy(xpath = "(//span[@class='box'])[26]")
	WebElement Authorize_check_box;

	@FindBy(xpath = "(//label[normalize-space()='Authorize'])[1]")
	WebElement Gove_Authorize_check_box;

	// @FindBy(xpath = "(//span[@class='box'])[32]")
	// WebElement Gove_Authorize_check_box;

	// @FindBy(css = "label[for='EditDeposit_Checked'] span[class='inc']")
	// WebElement Gove_Authorize_check_box;
	@FindBy(xpath = "//button[@class='btn btn-default'][normalize-space()='Cancel']")
	WebElement Cancel_btn;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']")
	WebElement Verify_btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save_btn;

	@FindBy(xpath = "(//input[@name='QTY'])[1]")
	WebElement Quantity_text;
	@FindBy(xpath = "(//a[@class='nav-link ng-binding'][normalize-space()='Lot Details'])[2]")
	WebElement Lot_GA;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Number_Of_Bags_PopUp;

	public void Transaction() {

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
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
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
			caret.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}
		try {
			no_of_bags.sendKeys(RP_Deposite_Request_Agriculture_Maker.bags);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.bags + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bags: " + e.getMessage());
		}
		try {
			Weighbridge_Net_Weight.sendKeys(Physical_Deposit_Maker.WeighbridgeNetWeight);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weighbridge_Net_Weight click...");
			js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.WeighbridgeNetWeight + "';",
					Weighbridge_Net_Weight);
		} catch (NoSuchElementException e) {
			System.out.println("Weighbridge_Net_Weight not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weighbridge_Net_Weight: " + e.getMessage());
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
			no_of_bag.sendKeys(RP_Deposite_Request_Agriculture_Maker.bags);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bag click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.bags + "';", no_of_bag);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bag not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bag: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Wait.until(ExpectedConditions.elementToBeClickable(no_of_bag)).sendKeys(Keys.TAB);
		// Sample_id.sendKeys(String.valueOf(DashBord_WareHouse_Maker.Sample));
		try {
			Verification_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_manu click...");
			js.executeScript("arguments[0].click();", Verification_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_manu: " + e.getMessage());
		}
		try {
			Depositor_Detail_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail_manu click...");
			js.executeScript("arguments[0].click();", Depositor_Detail_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail_manu: " + e.getMessage());
		}

		try {
			if (Authorize_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Authorize_check_box);
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
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
		System.out.println("--------------------WareHouse Checker is Done-------------------------");

	}

	public void Deposit_Maker_Multiple_GSL_Checker() throws InterruptedException {
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
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
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
			caret.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		try {
			no_of_bags.sendKeys(RP_Deposite_Request_Agriculture_Maker.bags);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.bags + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bags: " + e.getMessage());
		}
		try {
			Weighbridge_Net_Weight.sendKeys(Physical_Deposit_Maker.WeighbridgeNetWeight);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weighbridge_Net_Weight click...");
			js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.WeighbridgeNetWeight + "';",
					Weighbridge_Net_Weight);
		} catch (NoSuchElementException e) {
			System.out.println("Weighbridge_Net_Weight not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weighbridge_Net_Weight: " + e.getMessage());
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
		/*
		 * WebElement remainingBagsElement = driver
		 * .findElement(By.xpath("//div[@class='row ng-scope']//div[@class='col-sm-2']")
		 * ); // Adjust ID int remainingBags =
		 * Integer.parseInt(remainingBagsElement.getText());
		 * System.out.println("Befor For Loop remainingBags:"+
		 * remainingBagsElement.getText()); no_of_bag.sendKeys(Keys.TAB);
		 * driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS); try {
		 * WebElement avgBagButton =
		 * driver.findElement(By.xpath("//button[@class='confirm']")); if
		 * (avgBagButton.isDisplayed() && avgBagButton.isEnabled()) {
		 * avgBagButton.click(); System.out.println("Clicked AvgBag button."); } } catch
		 * (NoSuchElementException e) { System.out.println("AvgBag not found: " +
		 * e.getMessage()); } catch (Exception e) {
		 * System.out.println("Unexpected error for AvgBag: " + e.getMessage()); }
		 * driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS); int
		 * PresentBag= Integer.parseInt(remainingBagsElement.getText());
		 * System.out.println("PresentBag is :"+PresentBag);
		 * 
		 * for (int i = 3; i <=bagField. ; i += 3) { //
		 * System.out.println("Value of i: " + i); if( PresentBag==0) { try { WebElement
		 * bagField = driver.findElement(By.xpath("(//input[@name='no_of_bag'])[" + i +
		 * "]")); driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //
		 * Wait until bag field is clickable
		 * Wait.until(ExpectedConditions.elementToBeClickable(bagField)).sendKeys(String
		 * .valueOf(Physical_Deposit_Maker.Bags));
		 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // Press TAB
		 * after entering value
		 * Wait.until(ExpectedConditions.elementToBeClickable(bagField)).sendKeys(Keys.
		 * TAB);
		 * 
		 * // Optional wait or sleep can be added here if needed // Thread.sleep(500);
		 * 
		 * try { WebElement avgBagButton =
		 * driver.findElement(By.xpath("//button[@class='confirm']")); if
		 * (avgBagButton.isDisplayed() && avgBagButton.isEnabled()) {
		 * avgBagButton.click(); System.out.println("Clicked AvgBag button."); } } catch
		 * (NoSuchElementException e) { System.out.println("AvgBag not found: " +
		 * e.getMessage()); } catch (Exception e) {
		 * System.out.println("Unexpected error for AvgBag: " + e.getMessage()); }
		 * 
		 * } catch (Exception e) { System.out.println("Error at index " + i + ": " +
		 * e.getMessage()); } driver.manage().timeouts().implicitlyWait(60,
		 * TimeUnit.SECONDS);
		 * 
		 * //updated_Bags= Integer.parseInt(remainingBagsElement.getText());
		 * System.out.println("After ForLoop remainingBags:"+PresentBag); //break; }
		 * //break; }
		 */
		// int i=1;
		// int j = 3;
		// for( i=1; i <= totalBags; i += 3) {
		for (int i = 1; i <= totalBags; i++) {
			System.out.println("value of i:" + totalBags);
			int k = i * j;
			System.out.println("value of i:" + i);
			WebElement bagField = driver.findElement(By.xpath("(//input[@name='no_of_bag'])[" + k + "]"));
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(bagField))
					.sendKeys(String.valueOf(Physical_Deposit_Maker.Bags));
			// Incremented input value
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(bagField)).sendKeys(Keys.TAB);
			Thread.sleep(2000);
			try {
				WebElement AvgBag = driver.findElement(By.xpath("//button[@class='confirm']"));
				AvgBag.click();
			} catch (NoSuchElementException e) {
				System.out.println("AvgBag not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for AvgBag: " + e.getMessage());
			}

		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Verification_manu)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_manu click...");
			js.executeScript("arguments[0].click();", Verification_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_manu: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Depositor_Detail_manu)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail_manu click...");
			js.executeScript("arguments[0].click();", Depositor_Detail_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail_manu: " + e.getMessage());
		}

		try {
			if (Authorize_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Authorize_check_box);
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
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
	}

	public void Exchange_Deposite_Transaction() throws InterruptedException {

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
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
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
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
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
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}
		try {
			no_of_bags.sendKeys(RP_Exchange_Deposite_Agriculture_Maker.bags);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.bags + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bags: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Weighbridge_Net_Weight.sendKeys(Physical_Deposit_Maker.WeighbridgeNetWeight);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weighbridge_Net_Weight click...");
			js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.WeighbridgeNetWeight + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("Weighbridge_Net_Weight not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weighbridge_Net_Weight: " + e.getMessage());
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
			no_of_bag.sendKeys(RP_Exchange_Deposite_Agriculture_Maker.bags);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.bags + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bags: " + e.getMessage());
		}

		// Sample_id.sendKeys(String.valueOf(DashBord_WareHouse_Maker.Sample));

		try {
			Verification_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_manu click...");
			js.executeScript("arguments[0].click();", Verification_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_manu: " + e.getMessage());
		}
		try {
			Depositor_Detail_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail_manu click...");
			js.executeScript("arguments[0].click();", Depositor_Detail_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail_manu: " + e.getMessage());
		}

		try {
			if (Authorize_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Authorize_check_box);
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
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
		System.out.println("--------------------Exchange_Deposite_WareHouse Checker is Done-------------------------");

	}

	public void Exchange_Deposit_Multiple_GSL_Checker() throws InterruptedException {
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
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
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
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			caret.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		try {
			no_of_bags.sendKeys(RP_Exchange_Deposite_Agriculture_Maker.bags);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.bags + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bags: " + e.getMessage());
		}
		try {
			Weighbridge_Net_Weight.sendKeys(Physical_Deposit_Maker.WeighbridgeNetWeight);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weighbridge_Net_Weight click...");
			js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.WeighbridgeNetWeight + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("Weighbridge_Net_Weight not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weighbridge_Net_Weight: " + e.getMessage());
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

		for (int i = 1; i <= totalBags; i++) {
			System.out.println("value of i:" + totalBags);
			int k = i * j;
			System.out.println("value of i:" + i);
			WebElement bagField = driver.findElement(By.xpath("(//input[@name='no_of_bag'])[" + k + "]"));
			Thread.sleep(2000);
			Wait.until(ExpectedConditions.elementToBeClickable(bagField))
					.sendKeys(String.valueOf(Physical_Deposit_Maker.Bags));
			// Incremented input value
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(bagField)).sendKeys(Keys.TAB);
			try {
				WebElement AvgBag = driver.findElement(By.xpath("//button[@class='confirm']"));
				AvgBag.click();
			} catch (NoSuchElementException e) {
				System.out.println("AvgBag not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for AvgBag: " + e.getMessage());
			}
		}
		try {
			Verification_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_manu click...");
			js.executeScript("arguments[0].click();", Verification_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_manu: " + e.getMessage());
		}
		try {
			Depositor_Detail_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail_manu click...");
			js.executeScript("arguments[0].click();", Depositor_Detail_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail_manu: " + e.getMessage());
		}

		try {
			if (Authorize_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Authorize_check_box);
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
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
	}

	public void Government_Agency_Deposite_Transaction_Checker() {

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
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Government_Agency)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Government_Agency);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_WH_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_WH_btn: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(Government_Agency_Deposite_Request_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_txt click...");
			js.executeScript("arguments[0].value='" + Government_Agency_Deposite_Request_Maker.Deposite + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		try {
			Search_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			caret.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}
		try {
			Gove_no_of_bags.sendKeys(String.valueOf(Government_Agency_Deposite_Request_Maker.bags));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + Government_Agency_Deposite_Request_Maker.bags + "';",
					Gove_no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("Gove_no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Gove_no_of_bags: " + e.getMessage());
		}
		try {
			Weighbridge_Net_Weight.sendKeys(Physical_Deposit_Maker.WeighbridgeNetWeight);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.WeighbridgeNetWeight + "';",
					Weighbridge_Net_Weight);
		} catch (NoSuchElementException e) {
			System.out.println("Weighbridge_Net_Weight not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weighbridge_Net_Weight: " + e.getMessage());
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

		// no_of_bag.sendKeys("100");

		// Sample_id.sendKeys(String.valueOf(DashBord_WareHouse_Maker.Sample));
		try {
			Verification_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_manu click...");
			js.executeScript("arguments[0].click();", Verification_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_manu: " + e.getMessage());
		}
		try {
			Depositor_Detail_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail_manu click...");
			js.executeScript("arguments[0].click();", Depositor_Detail_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail_manu: " + e.getMessage());
		}
		try {
			Deposit_Assayer_CheckBox.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer_CheckBox click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer_CheckBox);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer_CheckBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer_CheckBox: " + e.getMessage());
		}
		try {
			Deposit_Confirm_CheckBox.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Confirm_CheckBox click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm_CheckBox);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm_CheckBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm_CheckBox: " + e.getMessage());
		}

		try {
			// (//a[@class='nav-link ng-binding'][normalize-space()='Lot Details'])[2]

			Lot_GA.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Lot_GA click...");
			js.executeScript("arguments[0].click();", Lot_GA);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_GA not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_GA: " + e.getMessage());
		}

		// js.executeScript("arguments[0].scrollIntoView(false);",
		// Gove_Authorize_check_box);
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// Gove_Authorize_check_box);
		// js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block:
		// 'center'});", Gove_Authorize_check_box);
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		try {
			if (Gove_Authorize_check_box.isDisplayed()) {
				Gove_Authorize_check_box.click();
			} else {
				System.out.println("Gove_Authorize_check_box is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Gove_Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Gove_Authorize_check_box);
		} catch (NoSuchElementException e) {
			System.out.println("Gove_Authorize_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Gove_Authorize_check_box: " + e.getMessage());
		}
		/*
		 * js.executeScript("arguments[0].scrollIntoView(true);", Verify_btn); try { if
		 * (Verify_btn.isDisplayed()) {
		 * Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click(); } }
		 * catch (ElementClickInterceptedException e) { System.out.
		 * println("Normal click failed, trying JavaScript Verify_btn click...");
		 * js.executeScript("arguments[0].click();", Verify_btn); } catch
		 * (NoSuchElementException e) { System.out.println("Verify_btn not found: " +
		 * e.getMessage()); } catch (Exception e) {
		 * System.out.println("Unexpected error for Verify_btn: " + e.getMessage()); }
		 */
		try {
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
		System.out.println("--------------------Government_Agency_Deposite_Transaction Checker is Done-------------------------");

	}

	public void Exchange_Non_Agriculture_Physical_Deposit_Request_Checker() {

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
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
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
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
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
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		no_of_bags.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.No_of_Bundle));

		Weighbridge_Net_Weight.sendKeys(Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity);

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
			no_of_bag_Non_Agri.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.No_of_Bundle));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bag_Non_Agri click...");
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.No_of_Bundle + "';", no_of_bag_Non_Agri);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bag_Non_Agri not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bag_Non_Agri: " + e.getMessage());
		}
		try {
			Quantity_text.sendKeys(Exchange_Non_Agri_WareHouse.Quantity);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Quantity_text click...");
			js.executeScript("arguments[0].value='" + Exchange_Non_Agri_WareHouse.Quantity + "';", Quantity_text);
		} catch (NoSuchElementException e) {
			System.out.println("Quantity_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Quantity_text: " + e.getMessage());
		}

		// Sample_id.sendKeys(String.valueOf(DashBord_WareHouse_Maker.Sample));

		try {
			if (Depositor_Detail_manu.isDisplayed()) {
				Depositor_Detail_manu.click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Depositor_Detail_manu);
			Depositor_Detail_manu.click();
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail_manu : " + e.getMessage());
		}

		try {
			if (Authorize_check_box.isDisplayed()) {

				Authorize_check_box.click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Authorize_check_box);
			Authorize_check_box.click();
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_check_box not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_check_box : " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Verify_btn.click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Verify_btn);
			Verify_btn.click();
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn : " + e.getMessage());
		}
		try {
			if (save_btn.isDisplayed()) {
				save_btn.click();

			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save_btn);
			save_btn.click();
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}
		System.out.println("--------------------Exchange_Non_Agriculture_Physical_Deposit_Request Checker is Done-------------------------");

	}

	public void Exchange_Deposit_Non_Agriculture_Multiple_GSL_Checker() {
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
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
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
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			caret.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript caret click...");
			js.executeScript("arguments[0].click();", caret);
		} catch (NoSuchElementException e) {
			System.out.println("caret not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for caret: " + e.getMessage());
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_btn click...");
			js.executeScript("arguments[0].click();", Authorize_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_btn: " + e.getMessage());
		}

		try {
			no_of_bags.sendKeys(Exchange_Deposite_Request_Non_Agriculture_Maker.No_of_Bundle);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bags click...");
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.No_of_Bundle + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bags not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bags: " + e.getMessage());
		}
		try {
			Weighbridge_Net_Weight.sendKeys(Exchange_Non_Agri_WareHouse.Weight_bridge_Receipt);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weighbridge_Net_Weight click...");
			js.executeScript("arguments[0].value='" + Exchange_Non_Agri_WareHouse.Weight_bridge_Receipt + "';", no_of_bags);
		} catch (NoSuchElementException e) {
			System.out.println("Weighbridge_Net_Weight not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weighbridge_Net_Weight: " + e.getMessage());
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

		for (int i = 1; i <= Exchange_Non_Agri_WareHouse.totalBags; i++) {
			/*for (int j = 3; j <= totalBags; j += 3) {*/

				 int k = j * i;
				WebElement bagField = driver.findElement(By.xpath("(//input[@name='no_of_bag'])[" + k + "]"));
				System.out.println("value of J:" + j);
				try {

					Wait.until(ExpectedConditions.elementToBeClickable(bagField))
							.sendKeys(String.valueOf(Exchange_Non_Agri_WareHouse.No_Of_Bundles)); // Incremented input value
					// Wait.until(ExpectedConditions.elementToBeClickable(bagField)).sendKeys(Keys.TAB);
				} catch (NoSuchElementException e) {
					System.out.println("bagField not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for bagField: " + e.getMessage());
				}
				try {
					WebElement AvgBag = driver.findElement(By.xpath("//button[@class='confirm']"));
					AvgBag.click();
				} catch (NoSuchElementException e) {
					System.out.println("Verification_manu not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for Verification_manu: " + e.getMessage());
				}
				// Wait.until(ExpectedConditions.elementToBeClickable(bagField)).sendKeys(Keys.TAB);
				/*
				 * WebElement SampleID_text =
				 * driver.findElement(By.xpath("(//input[@name='sample_Id'])[i]")); String SID =
				 * SampleID_text.getText(); System.out.println(SID);
				 */
				WebElement QTY = driver.findElement(By.xpath("(//input[@name='QTY'])[" + i + "]"));
				try {
					QTY.sendKeys(Exchange_Non_Agri_WareHouse.Quantity);
				} catch (NoSuchElementException e) {
					System.out.println("bagField not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for bagField: " + e.getMessage());
				}
				
			}
		
		try {
			Verification_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_manu click...");
			js.executeScript("arguments[0].click();", Verification_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_manu: " + e.getMessage());
		}
		try {
			Depositor_Detail_manu.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail_manu click...");
			js.executeScript("arguments[0].click();", Depositor_Detail_manu);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail_manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail_manu: " + e.getMessage());
		}

		try {
			if (Authorize_check_box.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_check_box)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_check_box click...");
			js.executeScript("arguments[0].click();", Authorize_check_box);
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
			if (save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

	}

}
