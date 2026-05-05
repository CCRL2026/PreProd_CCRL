package TestPages;


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

public class Transfer_Request_RP_Checker {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Transfer_Request_RP_Checker(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Bttn;

	@FindBy(xpath = "//a[@ui-sref='Transactions.Transfer']")
	WebElement Transfer_Bttn;

	
	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Transfer Warehouse Approval'])[1]")
	WebElement Transfer_Warehouse_Approval_Bttn;

	@FindBy(xpath = "//html[@class='ng-scope']")
	WebElement ScrollBy;
	@FindBy(xpath="//html[@lang='en']")
	WebElement Main_Scroll;
	
	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_Txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Search_Bttn;

	@FindBy(xpath = "(//button[@class='btn btn-xs btn-primary blue dropdown-toggle'][normalize-space()='Actions'])[1]")
	WebElement Actions_Bttn;

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement Actions_WSP_Bttn;
	
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement Scroll;

	@FindBy(xpath = "(//span[@class='box'])[2]")
	WebElement Return_to_Maker_Chk;

	@FindBy(xpath = "(//lable[normalize-space()='Return to Maker'])[1]")
	WebElement Return_to_Maker_txt;

	@FindBy(xpath = "//a[@class='ng-scope'][normalize-space()='Authorize']")
	WebElement Authorize_Bttn;

	@FindBy(xpath = "(//a[normalize-space()='Authorize'])[1]")
	WebElement Authorize_WSP_Bttn;
	//(//span[@class='box'])[8]
	//label[normalize-space()='Authorize']
	@FindBy(xpath = "(//span[@class='box'])[8]")
	WebElement Authorize_Chk;

	@FindBy(xpath = "//button[@button-busy='vm.saving']")
	WebElement Save_Bttn;

	public void Transfer_Request_Checker() {

		Transaction_Bttn.click();

		Transfer_Bttn.click();

		Search_Txt.sendKeys(Transfer_Request_RP_Maker.Instr_Slip_No);

		Search_Bttn.click();

		Wait.until(ExpectedConditions.elementToBeClickable(Actions_Bttn)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Bttn)).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Scroll.sendKeys(Keys.PAGE_DOWN);
		Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));

		try {
			if (Authorize_Chk.isDisplayed() && Authorize_Chk.isEnabled()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chk)).click();
			} else {
				System.out.println("Authorize_Chk is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Authorize_Chk);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized: " + e.getMessage());
		} /* finally { 
				Authorize_Chk.click(); 
				}*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		try {
			if (Save_Bttn.isDisplayed() && Save_Bttn.isEnabled()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_Bttn)).sendKeys(Keys.RETURN);
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
		}/*finally { 
			Wait.until(ExpectedConditions.elementToBeClickable(Save_Bttn)).click();
			}*/

	}

	public void Transfer_Warehouse_Approval_Checker() {

		Transaction_Bttn.click();
		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 Actions actions = new Actions(driver);
		 actions.sendKeys(Keys.PAGE_DOWN).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		js.executeScript("arguments[0].scrollIntoView(true);", Transfer_Warehouse_Approval_Bttn);
		*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Main_Scroll.sendKeys(Keys.PAGE_DOWN);
		//Main_Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		try {
			if (Transfer_Warehouse_Approval_Bttn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Transfer_Warehouse_Approval_Bttn)).click();
			} else {
				System.out.println("Transfer_Warehouse_Approval_Bttn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Transfer_Warehouse_Approval_Bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Charges_recovered not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Charges_recovered: " + e.getMessage());
		}

		Search_Txt.sendKeys(Transfer_Request_RP_Maker.Instr_Slip_No);

		Wait.until(ExpectedConditions.elementToBeClickable(Search_Bttn)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Wait.until(ExpectedConditions.elementToBeClickable(Actions_WSP_Bttn)).click();

		try {
			if (Authorize_WSP_Bttn.isDisplayed()) {
				// Wait.until(ExpectedConditions.elementToBeClickable(Authorize_WSP_Bttn)).click();
				Authorize_WSP_Bttn.click();
			} else {
				System.out.println("Authorize_WSP_Bttn is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_WSP_Bttn click...");
			js.executeScript("arguments[0].click();", Authorize_WSP_Bttn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorize_WSP_Bttn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorize_WSP_Bttn: " + e.getMessage());
		} finally {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorize_WSP_Bttn)).click();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Scroll.sendKeys(Keys.PAGE_DOWN);
		Scroll.sendKeys(Keys.PAGE_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		try {
			if (Return_to_Maker_Chk.isDisplayed()) {
				Return_to_Maker_Chk.click();
			} else {
				System.out.println("Return_to_Maker Check box is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Return_to_Maker_Chk click...");
			js.executeScript("arguments[0].click();", Return_to_Maker_Chk);
		} catch (NoSuchElementException e) {
			System.out.println("Return_to_Maker_Chk not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Return_to_Maker_Chk: " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		try {
			if (Return_to_Maker_txt.isDisplayed()) {
				Return_to_Maker_txt.click();
			} else {
				System.out.println("Return_to_Maker Text is unclick");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Return_to_Maker_txt click...");
			js.executeScript("arguments[0].click();", Return_to_Maker_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Return_to_Maker_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Return_to_Maker_txt: " + e.getMessage());
		}

		try {
			if (Authorize_Chk.isDisplayed() && Authorize_Chk.isEnabled()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorize_Chk)).click();
			} else {
				System.out.println("Authorize_Chk is not visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorize_Chk click...");
			js.executeScript("arguments[0].click();", Authorize_Chk);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized: " + e.getMessage());
		} /*
			 * finally { Authorize_Chk.click(); }
			 */
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
