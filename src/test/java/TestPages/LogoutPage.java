package TestPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

	WebDriver driver;
	WebDriverWait Wait;

	public LogoutPage(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//span[@class='username username-hide-on-mobile ng-binding'])[1]")
	WebElement logout;

	@FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
	WebElement Logout_Bttn;
	@FindBy(xpath = "(//h3[normalize-space()='Welcome!'])[1]")
	WebElement AB;

	public void Logout() {
		// AB.getText();

		//System.out.println(AB.getText());
		// System.out.println(D););

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Wait.until(ExpectedConditions.elementToBeClickable(logout)).click();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Wait.until(ExpectedConditions.elementToBeClickable(Logout_Bttn)).click();

	}

}
