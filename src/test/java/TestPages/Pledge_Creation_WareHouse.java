package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
//import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utillity.DataBaseUtility;

public class Pledge_Creation_WareHouse {

	WebDriver driver;
	WebDriverWait Wait;
	boolean found = false;
	String Pledge_Seq_No;
	int yearselect_From = 2025;
	String monthselect_From = "Dec";
	int formDate = 10;

	int yearselect_To = 2025;
	String monthselect_To = "Dec";
	int To_Date = 2;

	public Pledge_Creation_WareHouse(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Pledge creation process-------------
	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "//span[normalize-space()='Pledge Creation Approval']")
	WebElement Pledge_Creation_Approval;

	@FindBy(xpath = "//a[normalize-space()='Pending for Pledge Creation Approval']")
	WebElement PendingforPledgeCreation_link;

	@FindBy(xpath = "(//button[normalize-space()='New'])[1]")
	WebElement New_Button;

	@FindBy(xpath = "(//input[@name='client_id'])[1]")
	WebElement client_id_Text;

	@FindBy(xpath = "(//input[@name='location'])[1]")
	WebElement location;

	@FindBy(xpath = "(//input[@name='commodity'])[1]")
	WebElement commodity_txt;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Search_Button;

	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select;

	@FindBy(xpath = "//button[@class='btn btn-primary blue']//span[contains(text(),'Verify')]")
	WebElement verify_button;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save_button;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement scroll;

	@FindBy(xpath = "//span[normalize-space()='Pledge Creation Confirmation Report']")
	WebElement Pledge_Creation_Confirmation_Report_txt;

	@FindBy(xpath = "//input[@id='fromDate']")
	WebElement From_txt;

	@FindBy(xpath = "//div[@class='calendar left single']//select[@class='yearselect']")
	WebElement yearselect_txt;

	@FindBy(xpath = "(//div[@class='calendar left single']//select[@class='yearselect'])[2]")
	WebElement yearselect_txt_To;

	@FindBy(xpath = "//div[@class='calendar left single']//select[@class='monthselect']")
	WebElement monthselect_txt;

	@FindBy(xpath = "(//div[@class='calendar left single']//select[@class='monthselect'])[2]")
	WebElement monthselect_txt_To;

	@FindBy(xpath = "//input[@id='toDate']")
	WebElement toDate_Txt;

	@FindBy(xpath = "//span[normalize-space()='Export']")
	WebElement Export_Btn;

	@FindBy(xpath="//input[@id='fromDate']")
	WebElement from;
	
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement PopUp_Btn;

	@FindBy(xpath = "//span[normalize-space()='Reports']")
	WebElement Reports_Btn;

	public void Pledge_Creation_WareHouse_Approval() throws InterruptedException {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Pledge_Seq_No from pledge_req where Pledge_Req_No like  ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + Pledge_Creation.pledge_Req_Number + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Pledge_Seq_No = rs1.getString("Pledge_Seq_No");
				System.out.println("Pledge_Seq_No print: " + Pledge_Seq_No);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Transaction_Btn.click();
		Assert.assertTrue(Transaction_Btn.isDisplayed(), "Transaction button not visible");

		Pledge_Creation_Approval.click();
		Assert.assertTrue(Pledge_Creation_Approval.isDisplayed(), "Pledge_Creation_Approval button not visible");

		New_Button.click();
		Assert.assertTrue(New_Button.isDisplayed(), "New button not visible");

		client_id_Text.sendKeys(String.valueOf(Pledge_Creation.Client_ID));
		Assert.assertTrue(client_id_Text.isDisplayed(), "client_id Text Box not visible");

		// location.sendKeys("Indore");
		Assert.assertTrue(location.isDisplayed(), "location Text Box not visible");

		/*
		 * int Com = Pledge_Creation.Commodity;
		 * 
		 * switch (Com) { case 1: commodity_txt.sendKeys("WHEAT");
		 * System.out.println("Processing WHEAT..."); break; case 15:
		 * commodity_txt.sendKeys("COTTON BALES");
		 * System.out.println("Processing COTTON BALES..."); break; case 100:
		 * commodity_txt.sendKeys("RUBBER"); System.out.println("Processing RUBBER...");
		 * break; case 13: commodity_txt.sendKeys("SOYABEAN");
		 * System.out.println("Processing SOYABEAN..."); break; default:
		 * System.out.println("Unknown commodity."); break; }
		 */
		Search_Button.click();
		// Wait.until(ExpectedConditions.elementToBeClickable(Search_Button)).click();

		scroll.sendKeys(Keys.PAGE_DOWN);
		scroll.sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(3000);
		while (true) {
			// Wait until table rows or data are loaded
			// (//div[@role='rowgroup'])[2]
			// div[@class='ui-grid-cell-contents ng-binding ng-scope']
			// Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='rowgroup'])[2]")));
			// Find all text elements that may contain the target value
			// WebElement DRN=driver
			// .findElement(By.xpath("//div[contains(text(),'"
			// +Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "')]"));

			List<WebElement> valueElements = driver
					.findElements(By.xpath("//div[contains(text(),'" + Pledge_Seq_No + "')]"));
			if (valueElements.contains(valueElements)) {
				System.out.println("Step One");
				if (valueElements.size() > 0) {
					// Value found, click the button in the same row/div

					WebElement button = driver.findElement(By.xpath("//div[contains(text(),'" + Pledge_Seq_No
							+ "')]/preceding::div[@class='ui-grid-cell-contents ng-scope'][1]"));

					button.click();
					System.out.println("✅ Clicked on Select button for value: " + Pledge_Seq_No);
					found = true;
					break;
				}
			} else {
				// If value not found, check if 'Next' button is enabled
				List<WebElement> nextButtons = driver
						.findElements(By.xpath("(//div[@class='last-triangle next-triangle'])[1]"));

				if (nextButtons.size() > 0 && nextButtons.get(0).isEnabled()) {
					System.out.println("Step two");
					nextButtons.get(0).click();
					try {
						if (valueElements.size() > 0) {
							// Value found, click the button in the same row/div

							WebElement button = driver.findElement(By.xpath("//div[contains(text(),'" + Pledge_Seq_No
									+ "')]/preceding::div[@class='ui-grid-cell-contents ng-scope'][1]"));

							button.click();
							System.out.println("✅ Clicked on Select button for value: " + Pledge_Seq_No);
							found = true;
							break;
						}
					} catch (Exception e) {
						System.out.println("Unexpected error for valueElements: " + e.getMessage());
					}
					System.out.println("➡️ Moved to next page...");
					Thread.sleep(2000); // Wait for next page data to load
				} else {
					System.out.println("❌ Value " + Pledge_Seq_No + " not found in any page.");
					break;
				}
			}
		}

		if (!found) {
			System.out.println("⚠️ Target value " + Pledge_Seq_No + " was not found in the table.");
		}

		// Select.click();
		// Wait.until(ExpectedConditions.elementToBeClickable(Select)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(verify_button)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(save_button)).click();
	}

	public void Pledge_Creation_WareHouse_Approval_C118() throws InterruptedException {

		Transaction_Btn.click();
		Assert.assertTrue(Transaction_Btn.isDisplayed(), "Transaction button not visible");

		Pledge_Creation_Approval.click();
		Assert.assertTrue(Pledge_Creation_Approval.isDisplayed(), "Pledge_Creation_Approval button not visible");

		// PendingforPledgeCreation_link.getAttribute(null);
		Thread.sleep(1000);

		if (PendingforPledgeCreation_link.isDisplayed()) {

			PendingforPledgeCreation_link.click();
		} else {
			System.out.println("Pending for Pledge Creation Approval is not visible");
		}

	}

	public void Pledge_Creation_Confirmation_CR319() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Reports_Btn)).click();
		Assert.assertTrue(Reports_Btn.isDisplayed());	

		// check the menu list and verify 'Pledge Creation Confirmation' exists and is
		// immediately below 'eNWR/eNNWR Enquiry Report'
		// The exact structure depends on your DOM; below is a generic approach: find
		// list items under Reports
		/*
		 * List<WebElement> reportItems =
		 * driver.findElements(By.cssSelector("li[class='nav-item ng-scope open']"));
		 * List<String> names =
		 * reportItems.stream().map(WebElement::getText).map(String::trim)
		 * .collect(Collectors.toList()); Thread.sleep(2000); // debug print
		 * System.out.println("Reports list: " + names);
		 * 
		 * int indexOfEnquiry = names.indexOf("eNWR/eNNWR Enquiry Report");
		 */
		// Assert.assertTrue(indexOfEnquiry >= 0, "eNWR/eNNWR Enquiry Report must exist
		// in Reports");

		// check next item exists and is 'Pledge Creation Confirmation'
		// Assert.assertTrue(indexOfEnquiry + 1< names.size(), "'Pledge Creation
		// Confirmation' expected to be below enquiry report");
		// Assert.assertEquals(names.get(indexOfEnquiry + 1), "Pledge Creation
		// Confirmation",
		// "Pledge Creation Confirmation must be immediately below eNWR/eNNWR Enquiry
		// Report");


		String pledge =Pledge_Creation_Confirmation_Report_txt.getAttribute("textContent");
		System.out.println("value of text:"+pledge);
		Assert.assertEquals(pledge, "Pledge Creation Confirmation Report", "Pledge_Creation_Confirmation_Report_txt mismatch");
		
		if (Pledge_Creation_Confirmation_Report_txt.isDisplayed()) {

			Wait.until(ExpectedConditions.elementToBeClickable(Pledge_Creation_Confirmation_Report_txt)).click();
			Assert.assertTrue(Pledge_Creation_Confirmation_Report_txt.isDisplayed());
			//Assert.assertFalse(Pledge_Creation_Confirmation_Report_txt.isDisplayed(), "failes");
//assertTrue
		}
		Thread.sleep(2000);

		Wait.until(ExpectedConditions.elementToBeClickable(New_Button)).click();

		From_txt.click();

		Select A = new Select(yearselect_txt);
		A.selectByVisibleText(String.valueOf(yearselect_From));

		Select B = new Select(monthselect_txt);
		B.selectByVisibleText(String.valueOf(monthselect_From));

		WebElement From_Date = driver
				.findElement(By.xpath("//td[@class='available'][normalize-space()='" + formDate + "']"));

		From_Date.click();
		
		String F= From_txt.getText();
		
		System.out.println("Date of starrt :"+F);
		
		

		toDate_Txt.click();

		Select C = new Select(yearselect_txt_To);
		C.selectByVisibleText(String.valueOf(yearselect_To));

		Select D = new Select(monthselect_txt_To);
		D.selectByVisibleText(String.valueOf(monthselect_To));

		WebElement ToDate = driver
				.findElement(By.xpath("(//td[@class='available'][normalize-space()='" + To_Date + "'])[2]"));

		ToDate.click();

		System.out.println("Date of End :"+toDate_Txt.getText());
		
		 Wait.until(ExpectedConditions.elementToBeClickable(Export_Btn)).click();

		Thread.sleep(3000);

		 Wait.until(ExpectedConditions.elementToBeClickable(PopUp_Btn)).click();

	}
}
