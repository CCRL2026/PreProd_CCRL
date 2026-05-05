package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

import Utillity.DataBaseUtility;

public class Extension_Of_ENWR_Request_Checker {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	String DRN_No;

	public Extension_Of_ENWR_Request_Checker(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transactions_Btn;

	@FindBy(xpath = "//span[normalize-space()='Extension Of Validity Request']")
	WebElement Extension_Of_Validity_Request_Btn;

	@FindBy(xpath = "//span[normalize-space()='Extension Of Validity Wsp/Wh']")
	WebElement Extension_Of_Validity_Wsp_Btn;
	
	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Extension Of Validity Assayer']")
	WebElement Extension_Of_Validity_Assayer_Btn;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Search_Btn;

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement Actions_Btn;

	@FindBy(xpath = "//a[normalize-space()='Authorized']")
	WebElement Authorized_Btn;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement scroll;

	@FindBy(xpath = "//label[normalize-space()='Authorize']")
	WebElement Authorize_Chebox;

	@FindBy(xpath = "//button[@button-busy='vm.saving']")
	WebElement Save_Btn;

	public void Extension_Of_ENWR_Checker() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Transactions_Btn)).click();

		Extension_Of_Validity_Request_Btn.click();
		// Wait.until(ExpectedConditions.elementToBeClickable(Extension_Of_Validity_Request_Btn)).click();

		Search_Txt.sendKeys(Extension_Of_ENWR_Request.Instr_Slip_No);

		Search_Btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();

		Authorized_Btn.click();

		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(1000);
		try {
			if (Authorize_Chebox.isDisplayed()) {

				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chebox)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chebox click...");
			js.executeScript("arguments[0].click();", Authorize_Chebox);
		} catch (NoSuchElementException e) {
			System.out.println("verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for verify_btn: " + e.getMessage());
		}

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

	public void Extension_Of_ENWR_Request_Warehouse_Checker() throws InterruptedException {
		System.out.println("DRN No is "+Extension_Of_ENWR_Request.ENWR);
		
		try {
			Connection conn = DataBaseUtility.getConnection();

			String Input =
					"SELECT dt.DRN FROM deposit_txn dt JOIN deposit_txn_wh dwh ON dt.id = dwh.deposit_txn_id JOIN deposit_wh_lotdet dlot"
					+ " ON dwh.id = dlot.Deposit_Wh_Txn_id WHERE dlot.WR_no like ?";
			PreparedStatement DRN_No_Id = conn.prepareStatement(Input);
			DRN_No_Id.setString(1, "%" + Extension_Of_ENWR_Request.ENWR + "%");
			ResultSet rs1 = DRN_No_Id.executeQuery();
			if (rs1.next()) {
				DRN_No = rs1.getString("DRN");
				System.out.println("DRN is print: " + DRN_No);
				
				rs1.close();
				DRN_No_Id.close();
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Wait.until(ExpectedConditions.elementToBeClickable(Transactions_Btn)).click();

		
		Thread.sleep(1000);
		//Extension_Of_Validity_Wsp_Btn.click();
		Wait.until(ExpectedConditions.elementToBeClickable(Extension_Of_Validity_Wsp_Btn)).click();
		// Wait.until(ExpectedConditions.elementToBeClickable(Extension_Of_Validity_Request_Btn)).click();

		Search_Txt.sendKeys(DRN_No);

		Search_Btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();

		Authorized_Btn.click();

		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(1000);
		try {
			if (Authorize_Chebox.isDisplayed()) {

				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chebox)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chebox click...");
			js.executeScript("arguments[0].click();", Authorize_Chebox);
		} catch (NoSuchElementException e) {
			System.out.println("verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for verify_btn: " + e.getMessage());
		}

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


	public void Extension_Of_Validity_Assayer() throws InterruptedException {
		
		Wait.until(ExpectedConditions.elementToBeClickable(Transactions_Btn)).click();

		Extension_Of_Validity_Assayer_Btn.click();
		
		
		Search_Txt.sendKeys("4555516");

		Search_Btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();

		Authorized_Btn.click();

		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(1000);
		try {
			if (Authorize_Chebox.isDisplayed()) {

				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chebox)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chebox click...");
			js.executeScript("arguments[0].click();", Authorize_Chebox);
		} catch (NoSuchElementException e) {
			System.out.println("verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for verify_btn: " + e.getMessage());
		}

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

	public void Extension_Of_Validity_Confirm_Checker() throws InterruptedException {
		try {
			Connection conn = DataBaseUtility.getConnection();

			String Input = "SELECT dt.DRN FROM deposit_txn dt JOIN deposit_txn_wh dwh ON dt.id = dwh.deposit_txn_id JOIN deposit_wh_lotdet dlot   ON dwh.id = dlot.Deposit_Wh_Txn_id WHERE dlot.WR_no like ?";
			PreparedStatement DRN_No_Id = conn.prepareStatement(Input);
			DRN_No_Id.setString(1, "%" + Extension_Of_ENWR_Request.ENWR + "%");
			ResultSet rs1 = DRN_No_Id.executeQuery();
			if (rs1.next()) {
				DRN_No = rs1.getString("DRN");
				System.out.println("DRN is print: " + DRN_No);
				
				rs1.close();
				DRN_No_Id.close();
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Wait.until(ExpectedConditions.elementToBeClickable(Transactions_Btn)).click();

		Thread.sleep(1000);
		Extension_Of_Validity_Assayer_Btn.click();
		
		
		Search_Txt.sendKeys(DRN_No);

		Search_Btn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(Actions_Btn)).click();

		Authorized_Btn.click();

		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(1000);
		try {
			if (Authorize_Chebox.isDisplayed()) {

				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chebox)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chebox click...");
			js.executeScript("arguments[0].click();", Authorize_Chebox);
		} catch (NoSuchElementException e) {
			System.out.println("verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for verify_btn: " + e.getMessage());
		}

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
