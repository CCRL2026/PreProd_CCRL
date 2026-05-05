package TestPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPages {

	WebDriver driver;
	WebDriverWait Wait;

	public LoginPages(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Entity id']")
	WebElement Entity;
	@FindBy(xpath = "//input[@placeholder='User name or email']")
	WebElement User;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement Password;
	@FindBy(xpath = "(//button[normalize-space()='Log in'])[1]")
	WebElement LoginButton;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement Authentication_POPUP_Xpath;

	// @Test(dataProvider = "abhishek", dataProviderClass = excelDataProvider.class)
	public void PortalLogin(String entity, String user, String passWord) {

		Entity.sendKeys(entity);

		User.sendKeys(user);

		Password.sendKeys(passWord);

		LoginButton.sendKeys(Keys.ENTER);
		// LoginButton.sendKeys(Keys.ENTER);
		
		

		try {
			if (Authentication_POPUP_Xpath.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authentication_POPUP_Xpath)).sendKeys(Keys.ENTER);
				LoginButton.click();
				// Wait.until(ExpectedConditions.elementToBeClickable(Authentication_POPUP_Xpath)).sendKeys(Keys.ENTER);

				Wait.until(ExpectedConditions.elementToBeClickable(Authentication_POPUP_Xpath)).sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			System.out.println("Unexpected error for Authentication_POPUP_Xpath: " + e.getMessage());
		}

	}

}
