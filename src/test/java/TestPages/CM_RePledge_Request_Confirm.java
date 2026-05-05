package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class CM_RePledge_Request_Confirm {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\Margin_Pledge.xlsx";
	static String sheet = "CM_RePledge_Request";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	// public int ce_cc_id_Release = excel.getce_cc_id_Pay_Out_Release(dataRow); //

	long CC_Client_Id = excel.getCC_Client_Id(dataRow); // 180000110000033L;
	String Margin_Pledge_Sequence_No = excel.getMargin_Pledge_Sequence_No(dataRow);
	boolean found = false;

//100673000019391
	public CM_RePledge_Request_Confirm(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// --------------for Request for CM_RePledge_Request_Confirm creation
	// process-------------//

	@FindBy(xpath = "//span[normalize-space()='Margin Pledge']")
	WebElement Margin_Pledge_Btn;

	@FindBy(xpath = "//span[normalize-space()='CM Re-Pledge Request Confirm']")
	WebElement CM_RePledge_Request_Confirm_Btn;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Btn;

	@FindBy(xpath = "//input[@name='client_id']")
	WebElement client_id_Txt;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Search_Btn;

	@FindBy(xpath = "(//button[@class='btn btn-default btn-xs'][normalize-space()='Select'])[1]")
	WebElement Select_Btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save_Btn;

	public void CM_RePledge_Request_Confirm_Maker() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Margin_Pledge_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Margin_Pledge_Btn click...");
			js.executeScript("arguments[0].click();", Margin_Pledge_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Margin_Pledge_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Margin_Pledge_Btn: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(CM_RePledge_Request_Confirm_Btn)).click();

		New_Btn.click();

		try {
			if (String.valueOf(CC_Client_Id).matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(client_id_Txt))
						.sendKeys(String.valueOf(CC_Client_Id));
			} else {
				System.out.println("Invalid Deposite. Please enter 15 numeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript client_id_Txt click...");
			js.executeScript("arguments[0].value='" + CC_Client_Id + "';", client_id_Txt);
		} catch (NoSuchElementException e) {
			System.out.println("client_id_Txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for client_id_Txt: " + e.getMessage());
		}

		Search_Btn.click();

		// String xpath = "//div[contains(text(),'" + value +
		// "')]/following::div[@class='ui-grid-cell-contents ng-scope'][1]";
		// driver.findElement(By.xpath(xpath)).click();

		// WebElement Value
		// =driver.findElement(By.xpath("//div[contains(text(),'"+Margin_Pledge_Sequence_No+"')]/preceding::div[@class='ui-grid-cell-contents
		// ng-scope'][1]"));

		// Value.click();

		while (true) {
			
			List<WebElement> valueElements = driver
					.findElements(By.xpath("//div[contains(text(),'" + Margin_Pledge_Sequence_No + "')]"));
			if (valueElements.contains(valueElements)) {
				if (valueElements.size() > 0) {
					// Value found, click the button in the same row/div

					WebElement button = driver
							.findElement(By.xpath("//div[contains(text(),'" + Margin_Pledge_Sequence_No
									+ "')]/preceding::div[@class='ui-grid-cell-contents ng-scope'][1]"));

					button.click();
					System.out.println("✅ Clicked on Select button for value: " + Margin_Pledge_Sequence_No);
					found = true;
					break;
				}
			} else {
				// If value not found, check if 'Next' button is enabled
				List<WebElement> nextButtons = driver
						.findElements(By.xpath("(//div[@class='last-triangle next-triangle'])[1]"));

				if (nextButtons.size() > 0 && nextButtons.get(0).isEnabled()) {
					nextButtons.get(0).click();
					try {
						if (valueElements.size() > 0) {
							// Value found, click the button in the same row/div

							WebElement button = driver
									.findElement(By.xpath("//div[contains(text(),'" +Margin_Pledge_Sequence_No
											+ "')]/preceding::div[@class='ui-grid-cell-contents ng-scope'][1]"));

							button.click();
							System.out.println("✅ Clicked on Select button for value: " +Margin_Pledge_Sequence_No);
							found = true;
							break;
						}
						} catch (Exception e) {
							System.out.println("Unexpected error for valueElements: " + e.getMessage());
						}
					System.out.println("➡️ Moved to next page...");
					Thread.sleep(2000); // Wait for next page data to load
				} else {
					System.out.println("❌ Value " + Margin_Pledge_Sequence_No + " not found in any page.");
					break;
				}
			}
		}

		if (!found) {
			System.out.println("⚠️ Target value " + Margin_Pledge_Sequence_No + " was not found in the table.");
		}

		// Select_Btn.click();
		Thread.sleep(2000);

		try {
			if (Save_Btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Btn)).click();
			} else {
				System.out.println("We are unable to click the Save_Btn button");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_Btn click...");
			js.executeScript("arguments[0].click();", Save_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Btn: " + e.getMessage());
		}

	}

}
