package TestPages;

import java.time.Duration;
/*import java.io.File;
import java.time.Duration;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;*/
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class CM_Master_File_Upload {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData.xlsx";
	static String sheet = "Physical_Deposit_Maker";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public CM_Master_File_Upload(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Imports']")
	WebElement Imports_btn;

	@FindBy(css = "a[ui-sref='Imports.CMUpload'] span[class='title ng-binding']")
	WebElement CM_Master_Upload_bttn;
	// input[@id='files' and @name='files']\
	// input[contains(@accept,'spreadsheetml') or contains(@accept,'ms-excel')]

	@FindBy(xpath = "//input[contains(@accept,'spreadsheetml') or contains(@accept,'ms-excel')]")
	WebElement Upload_files;
	@FindBy(xpath = "//span[normalize-space()='CM Master File Upload']")
	WebElement CM_Master_File_Upload_txt;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement Are_you_sure_popup;

	@FindBy(xpath = "//div[@class='sweet-alert hideSweetAlert']")
	WebElement Success_txt;

	public void CM_Master_File_Upload_CC() throws InterruptedException {

		/*
		 * Wait.until(ExpectedConditions.elementToBeClickable(Imports_btn)).click();
		 * 
		 * Wait.until(ExpectedConditions.elementToBeClickable(CM_Master_Upload_bttn)).
		 * click(); driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		 * System.out.println(CM_Master_File_Upload_txt.getText()); try { //
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		 * Upload_files.sendKeys(
		 * "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData\\CM_Matser.xlsx"
		 * ); driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		 * System.out.println("✅ File uploaded successfully");
		 * 
		 * } catch (Exception e) { System.out.println("File uploaded:" +
		 * e.getMessage()); } try { if (Are_you_sure_popup.isDisplayed()) {
		 * //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 * Wait.until(ExpectedConditions.elementToBeClickable(Are_you_sure_popup)).click
		 * (); // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		 * System.out.println(" Are_you_sure_popup  is selected"); } else {
		 * System.out.println(" Are_you_sure_popup  not selected"); } } catch (Exception
		 * e) { System.out.println("File uploaded:" + e.getMessage()); }
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 * 
		 * // String Complete //
		 * =Wait.until(ExpectedConditions.elementToBeClickable(Success_txt)).getText();
		 * // System.out.println(Complete);
		 */
		// 1. Click Import
		Wait.until(ExpectedConditions.elementToBeClickable(Imports_btn)).click();

		// 2. Click Master Upload
		Wait.until(ExpectedConditions.elementToBeClickable(CM_Master_Upload_bttn)).click();

		// 3. Verify Upload Text is visible
		System.out.println(Wait.until(ExpectedConditions.visibilityOf(CM_Master_File_Upload_txt)).getText());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// 4. Upload File
		/*
		 * try { // Wait.until(ExpectedConditions.presenceOfElementLocated(By.
		 * id("//input[contains(@accept,'spreadsheetml') or contains(@accept,'ms-excel')]"
		 * ))); // locator for <input type="file"> Upload_files.sendKeys(
		 * "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData\\CM_Matser.xlsx"
		 * ); System.out.println("✅ File uploaded successfully"); } catch (Exception e)
		 * { System.out.println("❌ File upload failed: " + e.getMessage()); }
		 */
		try {
			WebElement hiddenInput = driver.findElement(By.cssSelector("#files"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", hiddenInput);
			hiddenInput.sendKeys("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData\\CM_Matser.xlsx");
		} catch (Exception e) {
			System.out.println("❌ hiddenInput upload failed: " + e.getMessage());
		}
		Thread.sleep(3000);

		/*
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		 */
		// 5. Handle "Are you sure" popup
		try {
			WebElement popupBtn = Wait.until(ExpectedConditions.elementToBeClickable(Are_you_sure_popup));
			Wait.until(ExpectedConditions.elementToBeClickable(popupBtn)).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			System.out.println("✅ Are_you_sure_popup is selected");
		} catch (TimeoutException e) {
			System.out.println("❌ Are_you_sure_popup  failed: " + e.getMessage());
			//System.out.println("⚠️ Are_you_sure_popup not found within wait time");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		System.out.println(CM_Master_File_Upload_txt.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

	}
}
