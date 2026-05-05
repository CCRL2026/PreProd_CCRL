package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import Utillity.DataBaseUtility;

public class Transfer_Warehouse_Approval_Maker {

	WebDriver driver;
	WebDriverWait Wait;
	String DRN_Number;

	public Transfer_Warehouse_Approval_Maker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Bttn;

	@FindBy(xpath = "//html[@lang='en']")
	WebElement Main_Scroll;
	// (//span[normalize-space()='Transfer Warehouse Approval'])[1]
	// a[ui-sref='Transactions.TransferWhApproval'] span[class='title ng-binding']
	@FindBy(css = "//span[normalize-space()='Transfer Warehouse Approval']")
	WebElement Transfer_Warehouse_Approval_Bttn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Bttn;

	@FindBy(xpath = "//input[@name='drn1']")
	WebElement DRN_No;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit_Bttn;
	// label[@for='Charges_recovered']//span[@class='box']
	@FindBy(xpath = "(//span[@class='box'])[1]")
	WebElement Charges_recovered;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Bttn;

	public void Transfer_Warehouse_Approval_Request() {

		Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 800);");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		/*
		 * Main_Scroll.sendKeys(Keys.PAGE_DOWN); Main_Scroll.sendKeys(Keys.PAGE_DOWN);
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		 * 
		 * //js.executeScript("arguments[0].scrollIntoView()", Main_Scroll);
		 */ js.executeScript("arguments[0].scrollIntoView(true);", Transfer_Warehouse_Approval_Bttn);
		try {
			if (Transfer_Warehouse_Approval_Bttn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Transfer_Warehouse_Approval_Bttn))
						.sendKeys(Keys.ENTER);
				// Transfer_Warehouse_Approval_Bttn.click();
			} else {
				System.out.println("Transfer_Warehouse_Approval_Bttn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transfer_Warehouse_Approval_Bttn click...");
			js.executeScript("arguments[0].click();", Transfer_Warehouse_Approval_Bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Transfer_Warehouse_Approval_Bttn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transfer_Warehouse_Approval_Bttn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(New_Bttn)).click();

		try {
			Connection conn = DataBaseUtility.getConnection();

			String query_DRN = "select Id from transfer_txn where TXN_Type='WR' and Instr_Slip_No LIKE ? order by id desc;";
			PreparedStatement stmt = conn.prepareStatement(query_DRN);
			stmt.setString(1, "%" + Transfer_Request_RP_Maker.Instr_Slip_No + "%"); // bind the variable to query

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				DRN_Number = rs.getString("ID");
				System.out.println("DRN_NO is : " + DRN_Number);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// DRN_No.click();
		if (DRN_Number.matches("^[a-zA-Z0-9]{0,7}$")) {
			Wait.until(ExpectedConditions.elementToBeClickable(DRN_No)).sendKeys(DRN_Number);
		} else {
			System.out.println("DRN_Number is Invalid");
		}
		Submit_Bttn.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		try {
			if (Charges_recovered.isDisplayed() && Charges_recovered.isEnabled()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Charges_recovered)).click();
				// Charges_recovered.click();
			} else {
				System.out.println("Charges_recovered is not Visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Charges_recovered);
		} catch (NoSuchElementException e) {
			System.out.println("Charges_recovered not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Charges_recovered: " + e.getMessage());
		} finally {
			Wait.until(ExpectedConditions.elementToBeClickable(Charges_recovered)).click();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		try {
			if (Save_Bttn.isDisplayed() && Save_Bttn.isEnabled()) {
				Save_Bttn.click();
			} else {
				System.out.println("Save_Bttn is not Visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_Bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Bttn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Bttn: " + e.getMessage());
		}

	}
}
