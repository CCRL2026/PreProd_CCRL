package TestPages;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class Deposite_Assayer_Checker {

	WebDriver driver;
	WebDriverWait Wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Deposite_Assayer_Checker(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Deposit Assayer'])[1]")
	WebElement Deposit_Assayer;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement Search_txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Search_btn;

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	WebElement Actions_btn;

	@FindBy(xpath = "//a[normalize-space()='Authorized']")
	WebElement Authorized_btn;
	
	@FindBy(xpath ="//body/ul[@class='dropdown-menu']/li[2]/a[1]")
	WebElement Authorized_GSLbtn;
	
	@FindBy(xpath = "(//a[normalize-space()='Goods Quality'])[1]")
	WebElement Goods_Quality_menu;

	@FindBy(xpath = "//a[normalize-space()='Upload Assaying Report']")
	WebElement Assaying_Report_Menu;

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement confirm_pop_up;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement Cancel_bttn;
	
	@FindBy(xpath="//div[@id='1762861625020-uiGrid-0008-menu-button']//i[@class='ui-grid-icon-angle-down']")
	WebElement Asscending_Btn;
	
	@FindBy(xpath="(//button[@type='button'])[1]")
	WebElement Assc_Sort_Btn;

	@FindBy(xpath = "//label[normalize-space()='Authorized']")
	WebElement Authorized_checkbox;
	
	@FindBy(xpath="(//span[@class='box'])[7]")
	WebElement Authorized_GSL;

	@FindBy(xpath = "(//span[contains(text(),'Verify')])[2]")
	WebElement Verify_btn;

	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope']")
	WebElement Save_btn;

	public void Deposit_Assayer() throws InterruptedException {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer: " + e.getMessage());
		}
		
			try {
				Search_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite ));
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_txt click...");
				js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite+"';",
						Search_txt);
			} catch (NoSuchElementException e) {
				System.out.println("Search_txt not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_txt: " + e.getMessage());
			}

			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_btn click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Actions_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Actions_btn click...");
				js.executeScript("arguments[0].click();", Actions_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Actions_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Authorized_btn click...");
				js.executeScript("arguments[0].click();", Authorized_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
			}
			try {
				Goods_Quality_menu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Goods_Quality_menu click...");
				js.executeScript("arguments[0].click();", Goods_Quality_menu);
			} catch (NoSuchElementException e) {
				System.out.println("Goods_Quality_menu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Goods_Quality_menu: " + e.getMessage());
			}

			Assaying_Report_Menu.sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_checkbox)).click();

			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Authorized_checkbox);
				// System.out.println("Element not clickable at the moment: " + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_checkbox not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_checkbox: " + e.getMessage());
			}

			try {
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Verify_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
			}
			try {
				if (Save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Save_btn click...");
				js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Save_btn: " + e.getMessage());
			}
		

	}

	public void Exchange_Deposite_Assayer() {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_txt click...");
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			if (Actions_btn.isDisplayed()) {
				Actions_btn.sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Actions_btn click...");
			js.executeScript("arguments[0].click();", Actions_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
		}
		try {
			if (Authorized_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorized_btn click...");
			js.executeScript("arguments[0].click();", Authorized_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
		}
		try {
			Goods_Quality_menu.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Goods_Quality_menu click...");
			js.executeScript("arguments[0].click();", Goods_Quality_menu);
		} catch (NoSuchElementException e) {
			System.out.println("Goods_Quality_menu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Goods_Quality_menu: " + e.getMessage());
		}
		try {
			Assaying_Report_Menu.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Assaying_Report_Menu click...");
			js.executeScript("arguments[0].click();", Assaying_Report_Menu);
		} catch (NoSuchElementException e) {
			System.out.println("Assaying_Report_Menu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Assaying_Report_Menu: " + e.getMessage());
		}
		try {
			if (Authorized_checkbox.isDisplayed()) {
				Authorized_checkbox.click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Authorized_checkbox);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_checkbox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_checkbox: " + e.getMessage());
		}

		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
		}
		try {
			if (Save_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}

	}

	public void Exchange_Non_Agriculture_Deposit_Assayer() {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer: " + e.getMessage());
		}
		try {
			Search_txt.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite));
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_txt click...");
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "';",
					Search_txt);
		} catch (NoSuchElementException e) {
			System.out.println("Search_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_txt: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Actions_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Actions_btn click...");
			js.executeScript("arguments[0].click();", Actions_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Actions_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorized_btn click...");
			js.executeScript("arguments[0].click();", Authorized_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
		}
		try {
			Goods_Quality_menu.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Goods_Quality_menu click...");
			js.executeScript("arguments[0].click();", Goods_Quality_menu);
		} catch (NoSuchElementException e) {
			System.out.println("Goods_Quality_menu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Goods_Quality_menu: " + e.getMessage());
		}
		try {
			Authorized_checkbox.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Authorized_checkbox click...");
			js.executeScript("arguments[0].click();", Authorized_checkbox);
		} catch (NoSuchElementException e) {
			System.out.println("Authorized_checkbox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Authorized_checkbox: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Save_btn click...");
			js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}

	}

	public void Deposit_Assayer_Agriculture_Multiple_GSL_Checker() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer: " + e.getMessage());
		}
		
		for (int i = 1; i <= DashBoard_WareHouse_Checker.totalBags; i++) {
			Thread.sleep(3000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_txt))
						.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite + i));
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_txt click...");
				js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.Deposite + i + "';",
						Search_txt);
			} catch (NoSuchElementException e) {
				System.out.println("Search_txt not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_txt: " + e.getMessage());
			}
			Thread.sleep(1000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_btn click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			/*
			 * Thread.sleep(1000); try {
			 * Wait.until(ExpectedConditions.elementToBeClickable(Asscending_Btn)).sendKeys(
			 * Keys.ENTER); //Asscending_Btn.click(); Assc_Sort_Btn.sendKeys(Keys.ENTER); }
			 * catch (Exception e) { System.out.println("Unexpected error for Search_btn: "
			 * + e.getMessage()); }
			 */
			Thread.sleep(2000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Actions_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Actions_btn click...");
				js.executeScript("arguments[0].click();", Actions_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Actions_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
			}
			Thread.sleep(1000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Authorized_btn click...");
				js.executeScript("arguments[0].click();", Authorized_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
			}
			try {
				Goods_Quality_menu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Goods_Quality_menu click...");
				js.executeScript("arguments[0].click();", Goods_Quality_menu);
			} catch (NoSuchElementException e) {
				System.out.println("Goods_Quality_menu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Goods_Quality_menu: " + e.getMessage());
			}
			try {
				Assaying_Report_Menu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Assaying_Report_Menu click...");
				js.executeScript("arguments[0].click();", Assaying_Report_Menu);
			} catch (NoSuchElementException e) {
				System.out.println("Assaying_Report_Menu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Assaying_Report_Menu: " + e.getMessage());
			}
			/*
			 * try { if (confirm_pop_up.isDisplayed()) {
			 * Wait.until(ExpectedConditions.elementToBeClickable(confirm_pop_up)).click();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 * Wait.until(ExpectedConditions.elementToBeClickable(Cancel_bttn)).click();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			 * 
			 * try {
			 * Wait.until(ExpectedConditions.elementToBeClickable(Actions_btn)).sendKeys(
			 * Keys.ENTER); } catch (ElementClickInterceptedException e) { System.out.
			 * println("Normal click failed, trying JavaScript Actions_btn click...");
			 * js.executeScript("arguments[0].click();", Actions_btn); } catch
			 * (NoSuchElementException e) { System.out.println("Actions_btn not found: " +
			 * e.getMessage()); } catch (Exception e) {
			 * System.out.println("Unexpected error for Actions_btn: " + e.getMessage()); }
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); try {
			 * Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
			 * } catch (ElementClickInterceptedException e) { System.out.
			 * println("Normal click failed, trying JavaScript Authorized_btn click...");
			 * js.executeScript("arguments[0].click();", Authorized_btn); } catch
			 * (NoSuchElementException e) { System.out.println("Authorized_btn not found: "
			 * + e.getMessage()); } catch (Exception e) {
			 * System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
			 * } try { Goods_Quality_menu.sendKeys(Keys.ENTER); } catch
			 * (ElementClickInterceptedException e) { System.out.
			 * println("Normal click failed, trying JavaScript Goods_Quality_menu click..."
			 * ); js.executeScript("arguments[0].click();", Goods_Quality_menu); } catch
			 * (NoSuchElementException e) {
			 * System.out.println("Goods_Quality_menu not found: " + e.getMessage()); }
			 * catch (Exception e) {
			 * System.out.println("Unexpected error for Goods_Quality_menu: " +
			 * e.getMessage()); } try {
			 * Wait.until(ExpectedConditions.elementToBeClickable(Assaying_Report_Menu)).
			 * sendKeys(Keys.ENTER); } catch (ElementClickInterceptedException e) {
			 * System.out.
			 * println("Normal click failed, trying JavaScript Assaying_Report_Menu click..."
			 * ); js.executeScript("arguments[0].click();", Assaying_Report_Menu); } catch
			 * (NoSuchElementException e) {
			 * System.out.println("Assaying_Report_Menu not found: " + e.getMessage()); }
			 * catch (Exception e) {
			 * System.out.println("Unexpected error for Assaying_Report_Menu: " +
			 * e.getMessage()); } break; } } catch (Exception e) {
			 * System.out.println("Unexpected error for confirm_pop_up: " + e.getMessage());
			 * }
			 */

			Thread.sleep(1000);
			
			try {if (Authorized_checkbox.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_checkbox)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Authorized_checkbox);
				// System.out.println("Element not clickable at the moment: " + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_checkbox not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_checkbox: " + e.getMessage());
			} /*
				 * finally { System.out.println("Authorized_checkbox should be click");
				 * Wait.until(ExpectedConditions.elementToBeClickable(Authorized_checkbox)).
				 * click(); }
				 */
			try {
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, Verify_btn JavaScript Verify_btn click...");
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Verify_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
			}
			try {
				if (Save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, Save_btn JavaScript Save_btn click...");
				js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Save_btn: " + e.getMessage());
			}
			Thread.sleep(3000);
			Search_txt.clear();
			// driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		}

	}

	public void Exchange_Deposite_Assayer_Agriculture_Multiple_GSL() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer: " + e.getMessage());
		}
		for (int i =1; i <= DashBoard_WareHouse_Checker.totalBags; i++) {
			Thread.sleep(2000);
			try {
				Search_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite + i));
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_txt click...");
				js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + i + "';",
						Search_txt);
			} catch (NoSuchElementException e) {
				System.out.println("Search_txt not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_txt: " + e.getMessage());
			}

			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_btn click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			Thread.sleep(2000);
			try {
				Actions_btn.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Actions_btn click...");
				js.executeScript("arguments[0].click();", Actions_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Actions_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Authorized_btn click...");
				js.executeScript("arguments[0].click();", Authorized_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
			}
			try {
				Goods_Quality_menu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Goods_Quality_menu click...");
				js.executeScript("arguments[0].click();", Goods_Quality_menu);
			} catch (NoSuchElementException e) {
				System.out.println("Goods_Quality_menu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Goods_Quality_menu: " + e.getMessage());
			}

			Assaying_Report_Menu.sendKeys(Keys.ENTER);

			try {
				if (confirm_pop_up.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(confirm_pop_up)).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					Wait.until(ExpectedConditions.elementToBeClickable(Cancel_bttn)).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

					try {
						Wait.until(ExpectedConditions.elementToBeClickable(Actions_btn)).sendKeys(Keys.ENTER);
					} catch (ElementClickInterceptedException e) {
						System.out.println("Normal click failed, trying JavaScript Actions_btn click...");
						js.executeScript("arguments[0].click();", Actions_btn);
					} catch (NoSuchElementException e) {
						System.out.println("Actions_btn not found: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					try {
						Wait.until(ExpectedConditions.elementToBeClickable(Authorized_btn)).click();
					} catch (ElementClickInterceptedException e) {
						System.out.println("Normal click failed, trying JavaScript Authorized_btn click...");
						js.executeScript("arguments[0].click();", Authorized_btn);
					} catch (NoSuchElementException e) {
						System.out.println("Authorized_btn not found: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
					}
					try {
						Goods_Quality_menu.sendKeys(Keys.ENTER);
					} catch (ElementClickInterceptedException e) {
						System.out.println("Normal click failed, trying JavaScript Goods_Quality_menu click...");
						js.executeScript("arguments[0].click();", Goods_Quality_menu);
					} catch (NoSuchElementException e) {
						System.out.println("Goods_Quality_menu not found: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("Unexpected error for Goods_Quality_menu: " + e.getMessage());
					}
					try {
						Wait.until(ExpectedConditions.elementToBeClickable(Assaying_Report_Menu)).sendKeys(Keys.ENTER);
					} catch (ElementClickInterceptedException e) {
						System.out.println("Normal click failed, trying JavaScript Assaying_Report_Menu click...");
						js.executeScript("arguments[0].click();", Assaying_Report_Menu);
					} catch (NoSuchElementException e) {
						System.out.println("Assaying_Report_Menu not found: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("Unexpected error for Assaying_Report_Menu: " + e.getMessage());
					}
					break;
				}
			} catch (Exception e) {
				System.out.println("Unexpected error for confirm_pop_up: " + e.getMessage());
			}
			Thread.sleep(2000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_checkbox)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Authorized_checkbox);
				// System.out.println("Element not clickable at the moment: " + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_checkbox not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_checkbox: " + e.getMessage());
			}

			try {
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Verify_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
			}
			try {
				if (Save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Save_btn click...");
				js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Save_btn: " + e.getMessage());
			}
			Thread.sleep(2000);
			Search_txt.clear();
		}
	}

	public void Exchange_Deposite_Assayer_Non_Agriculture_Multiple_GSL() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Btn click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer: " + e.getMessage());
		}
		for (int i =1 ; i < Exchange_Non_Agri_WareHouse.totalBags; i++) {
			try {
				Search_txt.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite));
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_txt click...");
				js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite  + "';",
						Search_txt);
			} catch (NoSuchElementException e) {
				System.out.println("Search_txt not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_txt: " + e.getMessage());
			}

			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_btn click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			
			WebElement Actions_btn = driver.findElement(By.xpath("(//button[normalize-space()='Actions'])["+i+"]"));
			try {
				Actions_btn.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Actions_btn click...");
				js.executeScript("arguments[0].click();", Actions_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Actions_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Actions_btn: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Authorized_GSLbtn)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Authorized_GSLbtn click...");
				js.executeScript("arguments[0].click();", Authorized_GSLbtn);
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_btn: " + e.getMessage());
			}
			try {
				Goods_Quality_menu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Goods_Quality_menu click...");
				js.executeScript("arguments[0].click();", Goods_Quality_menu);
			} catch (NoSuchElementException e) {
				System.out.println("Goods_Quality_menu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Goods_Quality_menu: " + e.getMessage());
			}

			Assaying_Report_Menu.sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			try {
				Authorized_checkbox.click();

			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				// WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Authorized_checkbox);
				// System.out.println("Element not clickable at the moment: " + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Authorized_checkbox not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Authorized_checkbox: " + e.getMessage());
			}

			try {
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Verify_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Verify_btn: " + e.getMessage());
			}
			try {
				if (Save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Save_btn click...");
				js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Save_btn: " + e.getMessage());
			}
			Thread.sleep(3000);
			Search_txt.clear();
		
		}

	}

}
