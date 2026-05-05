package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utillity.DataBaseUtility;
import Utillity.ExcelUtils;

public class pledgee_Creation {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\PlageData.xlsx";
	static String sheet = "PladgeRequest";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	String Pledge_Seq_No;
	public static int Pledge_Confirm_code = excel.getPledge_Confirm_code(dataRow);

	public pledgee_Creation(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		// this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for Pledge creation process-------------
	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "//span[@class='title ng-binding'][normalize-space()='Pledge Creation Confirmation']")
	WebElement Pledge_Creation_Confirmation;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New;

	@FindBy(xpath = "//input[@name='client_id']")
	WebElement client_id_Text;

	@FindBy(xpath = "//input[@name='pledge_Seq_No']")
	WebElement pledge_Seq_No;

	@FindBy(xpath = "//input[@name='Pledge_Confirm_No']")
	WebElement Pledge_Confirm_No;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Search;

	@FindBy(xpath = "(//input[@name='pledge_value1'])[2]")
	WebElement Pledge_Value;
	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select;

	@FindBy(xpath = "//button[@ng-show='!PledgeCreationConfirm.$invalid']")
	WebElement Verify;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save;

	/*-----------------------------------WebElement Declaration End ------------------------------------------------------------------*/
	public void Pledge_Creation() throws InterruptedException {

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

		// TODO Auto-generated method stub
		Transaction_Btn.click();
		Assert.assertTrue(Transaction_Btn.isDisplayed(), "Transaction button not visible");

		Pledge_Creation_Confirmation.click();
		Assert.assertTrue(Pledge_Creation_Confirmation.isDisplayed(),
				"Pledge_Creation_Confirmation button not visible");

		New.click();
		Assert.assertTrue(New.isDisplayed(), "New button not visible");

		client_id_Text.sendKeys(String.valueOf(Pledge_Creation.Client_ID));
		Assert.assertTrue(client_id_Text.isDisplayed(), "client_id text box is  not visible");

		pledge_Seq_No.sendKeys(Pledge_Seq_No);
		// Assert.assertTrue(pledge_Seq_No.isDisplayed(), "pledge_Seq_No text box not
		// visible");

		Search.click();
		Assert.assertTrue(Search.isDisplayed(), "Search button not visible");
		Thread.sleep(2000);
		Select.click();
		Assert.assertTrue(Select.isDisplayed(), "Select button not visible");

		Pledge_Confirm_No.click();
		Pledge_Confirm_No.sendKeys(String.valueOf(Pledge_Confirm_code));
		Assert.assertTrue(Pledge_Confirm_No.isDisplayed(), "Pledge_Confirm_No text box not visible");

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		// Pledge_Value.sendKeys(String.valueOf(Pledge_Creation.pledge_value));

		Verify.click();
		Assert.assertTrue(Verify.isDisplayed(), "Verify button not visible");

		Save.click();
		Assert.assertTrue(Save.isDisplayed(), "Save button not visible");
	}

}
