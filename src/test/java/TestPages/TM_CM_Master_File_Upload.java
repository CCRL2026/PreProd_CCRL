package TestPages;


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

public class TM_CM_Master_File_Upload {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData.xlsx";
	static String sheet = "Physical_Deposit_Maker";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public TM_CM_Master_File_Upload(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Imports']")
	WebElement Imports_btn;

	@FindBy(xpath = "//span[normalize-space()='TM CM Master Upload']")
	WebElement TM_CM_Master_Upload_bttn;

	@FindBy(xpath = "(//input[@id='files'])[1]")
	WebElement Upload_files;
	@FindBy(xpath = "//span[normalize-space()='CM Master File Upload']")
	WebElement CM_Master_File_Upload_txt;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement Are_you_sure_popup;

	public void TM_CM_Master_File_Upload_CC() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Imports_btn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(TM_CM_Master_Upload_bttn)).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		//System.out.println(CM_Master_File_Upload_txt.getText());

		/*
		 * try {
		 * Wait.until(ExpectedConditions.elementToBeClickable(Upload_files)).sendKeys(
		 * "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData\\TM_CM_Master.xlsx"
		 * ); System.out.println("✅ File uploaded successfully"); } catch (Exception e)
		 * { System.out.println("File uploaded:"+e.getMessage()); } Thread.sleep(3000);
		 * else { System.out.println(" File uploaded not selected"); }
		 * 
		 * Wait.until(ExpectedConditions.elementToBeClickable(Are_you_sure_popup)).click
		 * ();
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		 */
		
		try {
			WebElement hiddenInput = driver.findElement(By.cssSelector("#files"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", hiddenInput);
			hiddenInput.sendKeys("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\TestData\\TM_CM_Master.xlsx");
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("❌ hiddenInput upload failed: " + e.getMessage());
		}
		
		// 5. Handle "Are you sure" popup
		try {
			WebElement popupBtn = Wait.until(ExpectedConditions.elementToBeClickable(Are_you_sure_popup));
			Wait.until(ExpectedConditions.elementToBeClickable(popupBtn)).click();
			Thread.sleep(3000);
			System.out.println("✅ Are_you_sure_popup is selected");
			
		} catch (TimeoutException e) {
			System.out.println("❌ Are_you_sure_popup  failed: " + e.getMessage());
			//System.out.println("⚠️ Are_you_sure_popup not found within wait time");
		}
		
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		 * System.out.println(CM_Master_File_Upload_txt.getText());
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		 */
		
		
		
		
	}

}
