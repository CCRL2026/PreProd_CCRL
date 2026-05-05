package TestPages;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utillity.ExcelUtils;

public class Deposite_Assayer_Maker {

	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ENWR_Creation.xlsx";
	static String sheet = "Deposite_Assayer_Maker";
	static int dataRow = 1; // second row of data
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	String Assayring_Referance = excel.getAssayring_Referance(dataRow);
	String shelflife = excel.getshelflife(dataRow);
	String Grade_Desig_type = excel.getGrade_Desig_type(dataRow);
	String Remark_Value = excel.getRemark_Value(dataRow);
	String NABLCertificateRefNum = excel.getNABLCertificateRefNum(dataRow);
	String Address_Value = excel.getAddress_Value(dataRow);
	boolean found = false;

	public Deposite_Assayer_Maker(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='Transactions']")
	WebElement Transaction_Btn;

	@FindBy(xpath = "//span[normalize-space()='Deposit Assayer']")
	WebElement Deposit_Assayer;

	@FindBy(xpath = "//a[normalize-space()='Pending for Deposit Assayer']")
	WebElement PendingforDepositAssayer;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_btn;

	@FindBy(xpath = "//button[@class='btn dropdown-toggle btn-default']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement WareHouse_Id_btn;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement WareHouse_Id_txt;

	@FindBy(css = "input[name='sampleId'][type='text']")
	WebElement SampleId_txt;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement Search_btn;

	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement Select_btn;

	@FindBy(xpath = "//input[@ng-model='vm.DepositAssayer.arn'][1]")
	WebElement Assayring_Referance_No;

	@FindBy(xpath = "//input[@id='AssayingDate']")
	WebElement AssayingDate;

	@FindBy(xpath = "//div[@class='calendar left single']//tr[1]//th[3]")
	WebElement Calander;

	@FindBy(xpath = "//div[@class='calendar left single']//select[@class='monthselect']")
	WebElement monthselect;

	@FindBy(xpath = "//div[@class='calendar left single']//select[@class='yearselect']")
	WebElement yearselect;

	@FindBy(xpath = "//td[@class='today active start-date active end-date available']")
	WebElement Today_dates;
	// (//td[@class='today weekend active start-date active end-date available'])[1]
	// td[@class='today weekend active start-date active end-date available']
	@FindBy(xpath = "//td[@class='today weekend active start-date active end-date available']")
	WebElement WeekEnd_Date;

	@FindBy(xpath = "//input[@id='shelflife']")
	WebElement shelflife_count;

	@FindBy(xpath = "//a[normalize-space()='Goods Quality']")
	WebElement Goods_Quality_Manu;

	@FindBy(xpath = "(//select[@id='ddlcommodityMaster'])[1]")
	WebElement Grade_Desig;
	/**************************************
	 * QP Details for Cotton Bales for GA // Start
	 ************************************************************/
	@FindBy(xpath = "//select[@name='qual_conducted_view']")
	WebElement Pre_Qualification_Txt;
	@FindBy(xpath = "(//input[@name='name'])[1]")
	WebElement STAPLE_LENGTH;
	@FindBy(xpath = "(//input[@name='name'])[2]")
	WebElement TRASH_CONTENT;
	@FindBy(xpath = "(//input[@name='name'])[3]")
	WebElement MOISTURE_BY_MASS;

	/*
	 * @FindBy(xpath = "(//input[@name='name'])[4]") WebElement Address4;
	 * 
	 * @FindBy(xpath = "(//input[@name='name'])[5]") WebElement Address5;
	 * 
	 * @FindBy(xpath = "(//input[@name='name'])[6]") WebElement Address6;
	 */
	@FindBy(xpath = "(//input[@name='name'])[7]")
	WebElement IMMATURE_SHRIVELED_AND_BROKEN_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[8]")
	WebElement WEEVILED_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[9]")
	WebElement ADMIXTURE;
	@FindBy(xpath = "(//input[@name='name'])[10]")
	WebElement DAMAGED_IMMATURE_WEEVILLED;
	@FindBy(xpath = "(//input[@name='name'])[11]")
	WebElement FOREIGN_MATTER_ORGANIC;
	@FindBy(xpath = "(//input[@name='name'])[12]")
	WebElement FOREIGN_MATTER_INORGANIC;
	@FindBy(xpath = "(//input[@name='name'])[13]")
	WebElement OTHER_EDIBLE_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[14]")
	WebElement PERCENTAGE_OF_BULBS_BY_WEIGHT;
	@FindBy(xpath = "(//input[@name='name'])[15]")
	WebElement MOISTURE;
	@FindBy(xpath = "(//input[@name='name'])[16]")
	WebElement FOREIGN_MATTER;
	@FindBy(xpath = "(//input[@name='name'])[17]")
	WebElement MOISTURE_CONTENT;
	@FindBy(xpath = "(//input[@name='name'])[18]")
	WebElement SLIGHTLY_DAMAGED_TOUCHED_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[19]")
	WebElement FOREIGN_MATTER_BY_WT;
	@FindBy(xpath = "(//input[@name='name'])[20]")
	WebElement MOISTURE_BY_WT_Max;
	@FindBy(xpath = "(//input[@name='name'])[21]")
	WebElement ADMIXTURE_OTHER_EDIBLE_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[22]")
	WebElement WEEVILLED_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[23]")
	WebElement DAMAGED_IMMATURE_SHRIVELED_GRAINS;
	@FindBy(xpath = "//label[normalize-space()='Deposit Confirm']")
	WebElement Deposit_Confirm;

	// ----- Assayer QP for Chana---------------------
	@FindBy(xpath = "(//select[@id='ddlcommodityMaster'])[1]")
	WebElement Grade_CHANA_WHOLE;

	@FindBy(xpath = "(//select[@name='qual_conducted_view'])[1]")
	WebElement Pre_Qualification;

	@FindBy(xpath = "(//input[@id='Address'])[1]")
	WebElement OTHER_FOOD_GRAINS_CHAN;

	@FindBy(xpath = "(//input[@id='Address'])[2]")
	WebElement DAMAGED_GRAINS_CHAN;

	@FindBy(xpath = "(//input[@id='Address'])[3]")
	WebElement IMMATURE_SHRIVELED_AND_BROKEN_GRAINS_Chan;

	@FindBy(xpath = "(//input[@id='Address'])[4]")
	WebElement WEEVILED_GRAINS_Chan;

	@FindBy(xpath = "(//input[@id='Address'])[5]")
	WebElement ADMIXTURE_Chan;

	@FindBy(xpath = "(//input[@id='Address'])[6]")
	WebElement FOREIGN_MATTER_chan;

	@FindBy(xpath = "(//input[@id='Address'])[2]")
	WebElement OTHER_FOOD_GRAINS_CHANA;

	@FindBy(xpath = "(//input[@id='Address'])[3]")
	WebElement DAMAGED_GRAINS_CHANA;

	@FindBy(xpath = "(//input[@id='Address'])[4]")
	WebElement IMMATURE_SHRIVELED_AND_BROKEN_GRAINS_Chana;

	@FindBy(xpath = "(//input[@id='Address'])[5]")
	WebElement WEEVILED_GRAINS_Chana;

	@FindBy(xpath = "(//input[@id='Address'])[6]")
	WebElement ADMIXTURE_Chana;

	@FindBy(xpath = "(//input[@id='Address'])[7]")
	WebElement FOREIGN_MATTER_chana;

	@FindBy(xpath = "(//input[@id='Address'])[8]")
	WebElement MOISTURE_CONTENT_Chana;

	@FindBy(xpath = "(//input[@id='Address'])[9]")
	WebElement SLIGHTLY_DAMAGED_TOUCHED_GRAINS_Chana;

//***************************QP details for ARHAR /TUR (RED GRAM) WHOLE Start**********************************************
	@FindBy(xpath = "(//select[@id='ddlcommodityMaster'])[1]")
	WebElement Grade_ARHAR;

	@FindBy(xpath = "(//select[@name='qual_conducted_view'])[1]")
	WebElement Pre_Qualification_ARHAR;

	@FindBy(xpath = "(//input[@id='Address'])[2]")
	WebElement FOREIGN_MATTER_ARHAR;

	@FindBy(xpath = "(//input[@id='Address'])[3]")
	WebElement ADMIXTURE_ARHAR;

	@FindBy(xpath = "(//input[@id='Address'])[4]")
	WebElement DAMAGED_PULSES;

	@FindBy(xpath = "(//input[@id='Address'])[5]")
	WebElement SLIGHTLY_DAMAGED_PULSES;

	@FindBy(xpath = "(//input[@id='Address'])[6]")
	WebElement IMMATURE_AND_SHRIVELLED_PULSES;

	@FindBy(xpath = "(//input[@id='Address'])[7]")
	WebElement WEEVILLED_PULSES;

	@FindBy(xpath = "(//input[@id='Address'])[8]")
	WebElement MOISTURE_ARHAR;

	// ***************************QP details for SOYABEAN Start*********************
	@FindBy(xpath = "//select[contains(@class, 'form-control') and @ng-model='vm.DepositAssayer.commodityDesignation']")
	WebElement Grade_SOYABEAN;

	@FindBy(xpath = "//select[contains(@class, 'form-control') and @ng-model='vm.DepositAssayer.qual_conducted']")
	WebElement Pre_Qualification_SOYABEAN;

	@FindBy(xpath = "(//input[@id='Address'])[2]")
	WebElement MOISTURE_CONTENT_SOYABEAN;

	@FindBy(xpath = "(//input[@id='Address'])[3]")
	WebElement FOREIGN_MATTER_IMPURITIES;

	@FindBy(xpath = "(//input[@id='Address'])[4]")
	WebElement SHRIVELLED_IMMATURE_BEANS_DISCOLOURED;

	@FindBy(xpath = "(//input[@id='Address'])[5]")
	WebElement DAMAGED_AND_WEEVILLED_BEANS;

	@FindBy(xpath = "(//input[@id='Address'])[6]")
	WebElement MECHANICALLY_DAMAGED_BEANS;

	/*********************** Assayer QP for WHEAT ************************/
	@FindBy(xpath = "//select[@name='qual_conducted_view']")
	WebElement Pre_Qualification_WHEAT;

	@FindBy(xpath = "//input[@id='Address']")
	WebElement FOREIGN_MATTER_Percentage;

	@FindBy(xpath = "(//input[@id='Address'])[1]")
	WebElement FOREIGN_MATTER_BY_WEIGHT;

	@FindBy(xpath = "(//input[@id='Address'])[2]")
	WebElement OTHER_FOOD_GRAINS;

	@FindBy(xpath = "(//input[@id='Address'])[3]")
	WebElement OTHER_WHEATS;

	@FindBy(xpath = "(//input[@id='Address'])[4]")
	WebElement DAMAGED_GRAINS;

	@FindBy(xpath = "(//input[@id='Address'])[5]")
	WebElement SLIGHTLY_DAMAGED_GRAINS;

	@FindBy(xpath = "(//input[@id='Address'])[6]")
	WebElement IMMATURE_SHRIVELED_AND_BROKEN_GRAINS_WHEAT;

	@FindBy(xpath = "(//input[@id='Address'])[7]")
	WebElement WEEVILED_GRAINS_WHEAT;

	@FindBy(xpath = "(//input[@id='Address'])[8]")
	WebElement MOISTURE_WHEAT;

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement Confirm_Ok;

	@FindBy(xpath = "(//input[@id='Address'])[1]")
	WebElement STAPLE_SPAN_LENGTH_Ex;

	@FindBy(xpath = "(//input[@id='Address'])[2]")
	WebElement MICRONAIRE_EX;

	@FindBy(xpath = "(//input[@id='Address'])[3]")
	WebElement TRASH_ex;

	@FindBy(xpath = "(//input[@id='Address'])[4]")
	WebElement TENSILE_STRENGTH_EX;

	/*
	 * @FindBy(xpath="(//input[@id='Address'])[5]") WebElement
	 */

	@FindBy(xpath = "(//input[@id='Address'])[1]")
	WebElement Address1;

	@FindBy(xpath = "(//input[@id='Address'])[2]")
	WebElement Address2;

	@FindBy(xpath = "(//input[@id='Address'])[3]")
	WebElement Address3;

	@FindBy(xpath = "(//input[@id='Address'])[4]")
	WebElement Address4;

	@FindBy(xpath = "(//input[@id='Address'])[5]")
	WebElement Address5;

	@FindBy(xpath = "(//input[@id='Address'])[6]")
	WebElement Address6;

	@FindBy(xpath = "(//input[@id='Address'])[7]")
	WebElement Address7;

	@FindBy(xpath = "(//input[@id='Address'])[8]")
	WebElement Address8;

	@FindBy(xpath = "(//input[@id='Address'])[9]")
	WebElement Address9;
	@FindBy(xpath = "(//input[@id='Address'])[10]")
	WebElement Address10;

	@FindBy(xpath = "//select[@ng-model='Commodity.qp_Value']")
	WebElement GINNING_PATTERN_ROLLER_GINNED_COTTON;

	@FindBy(xpath = "//select[@name='qp_Value']")
	WebElement CARBITOL_Drop;

	@FindBy(xpath = "(//select[@ng-disabled='IsVisible'])[2]")
	WebElement SOLUBILITY_Drop;
	@FindBy(xpath = "(//select[@ng-disabled='IsVisible'])[3]")
	WebElement ETHYL_Drop;
	@FindBy(xpath = "(//input[@id='Address'])[5]")
	WebElement MOISTURE_BY_MASS_EX;

	@FindBy(xpath = "(//input[@id='Address'])[6]")
	WebElement REFLECTANCE_RD_VALUE_EX;

	@FindBy(xpath = "(//input[@id='Address'])[7]")
	WebElement YELLOWNESS_B_VALUE_EX;

	@FindBy(xpath = "//input[@name='ARef_No' and @ng-model='vm.DepositAssayer.arn' and @maxlength='150'][2]")
	WebElement COA_No;
	@FindBy(xpath = "//input[@name='remark']")
	WebElement remark;

	@FindBy(xpath = "//input[@id='NABLCertificateDate']")
	WebElement NABLCertificateDate;

	@FindBy(xpath = "//input[@name='NABLCertificateRefNo']")
	WebElement NABLCertificateRefNo;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement scroll;

	@FindBy(xpath = "(//input[@id='Address'])[1]")
	WebElement Address;
	@FindBy(xpath = "(//a[normalize-space()='Upload Assaying Report'])[1]")
	WebElement Upload_Assaying_Report;

	@FindBy(xpath = "//button[@ng-show='!AssayerForm.$invalid']")
	WebElement Verify_btn;

	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope']")
	WebElement Save_btn;

	public void Deposit_Assayer() {

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
			New_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript New_btn click...");
			js.executeScript("arguments[0].click();", New_btn);
		} catch (NoSuchElementException e) {
			System.out.println("New_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_btn: " + e.getMessage());
		}
		try {
			if (RP_Deposite_Request_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(WareHouse_Id_btn)).click();
				WareHouse_Id_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.WH_ID));
				WareHouse_Id_txt.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript WareHouse_Id_btn click...");
			js.executeScript("arguments[0].click();", WareHouse_Id_btn);
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.WH_ID + "';",
					WareHouse_Id_txt);
			js.executeScript("arguments[0].click();", WareHouse_Id_txt);
		} catch (NoSuchElementException e) {
			System.out.println("WareHouse_Id_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WareHouse_Id_btn: " + e.getMessage());
		}

		// Select SA = new Select(WareHouse_Id_txt);
		// SA.selectByContainsVisibleText("5750013");
		try {
			if (Physical_Deposit_Maker.Sample.matches("^[a-zA-Z0-9]{0,50}$")) {
				SampleId_txt.sendKeys(String.valueOf(Physical_Deposit_Maker.Sample));
			} else {
				System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");

			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript SampleId_txt click...");
			js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.Sample + "';", SampleId_txt);

		} catch (NoSuchElementException e) {
			System.out.println("SampleId_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for SampleId_txt: " + e.getMessage());
		}
		try {
			Search_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Select_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Select_btn click...");
			js.executeScript("arguments[0].click();", Select_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Select_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_btn: " + e.getMessage());
		}
		// String.valueOf(Assayring_Referance)
		try {
			if (Assayring_Referance.matches("^[a-zA-Z0-9]{0,20}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No))
						.sendKeys(String.valueOf(Assayring_Referance));
				Assayring_Referance_No.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Assayring_Referance. Please enter exactly 20 alphanumeric characters:");

			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Assayring_Referance_No click...");
			js.executeScript("arguments[0].value='" + Assayring_Referance + "';", Assayring_Referance_No);
			js.executeScript("arguments[0].click();", Assayring_Referance_No);
		} catch (NoSuchElementException e) {
			System.out.println("Assayring_Referance_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", AssayingDate);
		try {
			AssayingDate.click();
			Wait.until(ExpectedConditions.elementToBeClickable(Calander)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Today_dates)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", AssayingDate);
			js.executeScript("arguments[0].click();", Calander);
			js.executeScript("arguments[0].click();", Today_dates);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		/*
		 * String Month_Present = monthselect.getText();
		 * System.out.println(Month_Present); String Year_Present =yearselect.getText();
		 * System.out.println(Year_Present);
		 *
		 * Select Month =new Select(monthselect);
		 *
		 * Select Year =new Select(yearselect);
		 *
		 * LocalDateTime Live = LocalDateTime.now();
		 *
		 * while(Live.equals(Month)&& Live.equals(Year)) {
		 *
		 * Today_dates.click();
		 *
		 * }
		 */
		try {
			if (String.valueOf(shelflife).matches("^[0-9]{0,5}$")) {
				shelflife_count.sendKeys(shelflife);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript shelflife_count click...");
			js.executeScript("arguments[0].value='" + shelflife + "';", shelflife_count);
		} catch (NoSuchElementException e) {
			System.out.println("shelflife_count not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for shelflife_count: " + e.getMessage());
		}
		try {
			Goods_Quality_Manu.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Goods_Quality_Manu click...");
			js.executeScript("arguments[0].click();", Goods_Quality_Manu);
		} catch (NoSuchElementException e) {
			System.out.println("Goods_Quality_Manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Goods_Quality_Manu: " + e.getMessage());
		}

		try {
			Grade_Desig.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Grade_Desig click...");
			js.executeScript("arguments[0].click();", Grade_Desig);
		} catch (NoSuchElementException e) {
			System.out.println("Grade_Desig not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Grade_Desig: " + e.getMessage());
		}
		int choice = Integer.parseInt(RP_Deposite_Request_Agriculture_Maker.Commodity_Code);

		// Step 4: Use switch to process selection

		switch (choice) {
		case 15:
			System.out.println("You selected: Cotton");
			Select Grade = new Select(Grade_Desig);
			Grade.selectByVisibleText("GENERAL");
			Grade_Desig.click();
			Select Pre_Qualification = new Select(Pre_Qualification_Txt);
			Pre_Qualification.selectByIndex(1);
			/*
			 * System.out.println("You selected: Cotton"); Select GradeCotton = new
			 * Select(Grade_Desig); GradeCotton.selectByVisibleText("GENERAL");
			 * Grade_Desig.click();
			 */

			Address1.sendKeys(String.valueOf(28));
			Address2.sendKeys(String.valueOf(4));
			Address3.sendKeys(String.valueOf(4));
			Address4.sendKeys(String.valueOf(28));
			Select S = new Select(GINNING_PATTERN_ROLLER_GINNED_COTTON);
			S.selectByIndex(1);
			Address5.sendKeys(String.valueOf(7));
			Address6.sendKeys(String.valueOf(80));
			Address7.sendKeys(String.valueOf(8));
			break;
		case 49:
			System.out.println("You selected: Arhar");
			Select Grade_DE = new Select(Grade_ARHAR);
			Grade_DE.selectByVisibleText("GENERAL"); // Grade_CHANA_WHOLE.click();

			Select Qualification_AH = new Select(Pre_Qualification_ARHAR);
			Qualification_AH.selectByContainsVisibleText("Qualified");

			Address1.sendKeys("2");
			Address2.sendKeys("3");
			Address3.sendKeys("3");
			Address4.sendKeys("4");
			Address5.sendKeys("3");
			Address6.sendKeys("4");
			Address7.sendKeys("12");

			break;
		case 6:
			System.out.println("You selected: CHANA ");
			Select Grade_CHANA = new Select(Grade_CHANA_WHOLE);
			Grade_CHANA.selectByVisibleText("GENERAL"); // Grade_CHANA_WHOLE.click();

			Select Qualification = new Select(Pre_Qualification_Txt);
			Qualification.selectByContainsVisibleText("Qualified");

			Address1.sendKeys("3");

			Address2.sendKeys("4");

			Address3.sendKeys("6");

			Address4.sendKeys("4");

			Address5.sendKeys("2");

			Address6.sendKeys("1");

			Address7.sendKeys("14");

			Address8.sendKeys("4");

			break;
		case 13:
			System.out.println("You selected: Soyabean");
			Select SOYABEAN_Grade = new Select(Grade_SOYABEAN);
			SOYABEAN_Grade.selectByVisibleText("NAFED FAQ");

			Select Qualification_SOYABEAN = new Select(Pre_Qualification_SOYABEAN);
			Qualification_SOYABEAN.selectByContainsVisibleText("Qualified");

			Address1.sendKeys("12");
			Address2.sendKeys("2");
			Address3.sendKeys("5");
			Address4.sendKeys("3");
			Address5.sendKeys("15");

			break;
		case 1:
			System.out.println("You selected: WHEAT");
			Select WHEAT_Grade = new Select(Grade_Desig);
			WHEAT_Grade.selectByVisibleText("GRADE I");

			Select Qualification_WHEAT = new Select(Pre_Qualification_WHEAT);
			Qualification_WHEAT.selectByContainsVisibleText("Qualified");

			Address1.sendKeys("4");
			Address2.sendKeys("8");
			Address3.sendKeys("20");
			Address4.sendKeys("5");
			Address5.sendKeys("10");
			Address6.sendKeys("10");
			Address7.sendKeys("5");
			Address8.sendKeys("12");
			break;
		default:
			System.out.println("Invalid selection!");
		}
		try {
			if (Upload_Assaying_Report.isDisplayed()) {
				Upload_Assaying_Report.click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Upload_Assaying_Report click...");
			js.executeScript("arguments[0].click();", Upload_Assaying_Report);
		} catch (NoSuchElementException e) {
			System.out.println("Upload_Assaying_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Upload_Assaying_Report: " + e.getMessage());
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
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}

	}

	public void Exchange_Deposit_Assayer() {

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
			New_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript New_btn click...");
			js.executeScript("arguments[0].click();", New_btn);
		} catch (NoSuchElementException e) {
			System.out.println("New_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(WareHouse_Id_btn)).click();
			WareHouse_Id_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.WH_ID));
			WareHouse_Id_txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript WareHouse_Id_btn click...");
			js.executeScript("arguments[0].click();", WareHouse_Id_btn);
			js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.WH_ID + "';",
					WareHouse_Id_txt);
			js.executeScript("arguments[0].click();", WareHouse_Id_txt);
		} catch (NoSuchElementException e) {
			System.out.println("WareHouse_Id_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WareHouse_Id_btn: " + e.getMessage());
		}
		try {
			// if
			// (String.valueOf(Physical_Deposit_Maker.Sample).matches("^[a-zA-Z0-9]{50}$"))
			// {
			SampleId_txt.sendKeys(String.valueOf(Physical_Deposit_Maker.Sample));
			// }
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript SampleId_txt click...");
			js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.Sample + "';", SampleId_txt);
		} catch (NoSuchElementException e) {
			System.out.println("SampleId_txt not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for SampleId_txt: " + e.getMessage());
		}

		try {
			Search_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Search_btn click...");
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Select_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Select_btn click...");
			js.executeScript("arguments[0].click();", Select_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Select_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_btn: " + e.getMessage());
		}
		// String.valueOf(Assayring_Referance)
		try {
			if (Assayring_Referance.matches("^[a-zA-Z0-9]{0,20}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No))
						.sendKeys(String.valueOf(Assayring_Referance));
				Assayring_Referance_No.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Assayring_Referance. Please enter exactly 20 alphanumeric characters:");

			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Assayring_Referance_No click...");
			js.executeScript("arguments[0].value='" + Assayring_Referance + "';", Assayring_Referance_No);
			js.executeScript("arguments[0].click();", Assayring_Referance_No);
		} catch (NoSuchElementException e) {
			System.out.println("Assayring_Referance_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", AssayingDate);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(AssayingDate)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(Calander)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(WeekEnd_Date)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", AssayingDate);
			js.executeScript("arguments[0].click();", Calander);
			js.executeScript("arguments[0].click();", WeekEnd_Date);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		/*
		 * String Month_Present = monthselect.getText();
		 * System.out.println(Month_Present); String Year_Present =yearselect.getText();
		 * System.out.println(Year_Present);
		 *
		 * Select Month =new Select(monthselect);
		 *
		 * Select Year =new Select(yearselect);
		 *
		 * LocalDateTime Live = LocalDateTime.now();
		 *
		 * while(Live.equals(Month)&& Live.equals(Year)) {
		 *
		 * Today_dates.click();
		 *
		 * }
		 */
		try {
			if (String.valueOf(shelflife).matches("^[0-9]{0,5}$")) {
				shelflife_count.sendKeys(shelflife);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript shelflife_count click...");
			js.executeScript("arguments[0].value='" + shelflife + "';", shelflife_count);
		} catch (NoSuchElementException e) {
			System.out.println("shelflife_count not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for shelflife_count: " + e.getMessage());
		}
		try {
			Goods_Quality_Manu.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Goods_Quality_Manu click...");
			js.executeScript("arguments[0].click();", Goods_Quality_Manu);
		} catch (NoSuchElementException e) {
			System.out.println("Goods_Quality_Manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Goods_Quality_Manu: " + e.getMessage());
		}

		try {
			Grade_Desig.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Grade_Desig click...");
			js.executeScript("arguments[0].click();", Grade_Desig);
		} catch (NoSuchElementException e) {
			System.out.println("Grade_Desig not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Grade_Desig: " + e.getMessage());
		}

		int choice = Integer.parseInt(RP_Exchange_Deposite_Agriculture_Maker.Commodity_Code);

		// Step 4: Use switch to process selection

		switch (choice) {
		case 15:
			System.out.println("You selected: Cotton");
			Select GradeCotton = new Select(Grade_Desig);
			GradeCotton.selectByVisibleText("GENERAL");
			Grade_Desig.click();

			Address1.sendKeys(String.valueOf(28));
			Address2.sendKeys(String.valueOf(4));
			Address3.sendKeys(String.valueOf(4));
			Address4.sendKeys(String.valueOf(28));
			Select S = new Select(GINNING_PATTERN_ROLLER_GINNED_COTTON);
			S.selectByIndex(1);

			Address5.sendKeys(String.valueOf(7));
			Address6.sendKeys(String.valueOf(80));
			Address7.sendKeys(String.valueOf(8));

			break;
		case 49:
			System.out.println("You selected: Arhar");
			Select Grade_DE = new Select(Grade_ARHAR);
			Grade_DE.selectByVisibleText("NAFED FAQ"); // Grade_CHANA_WHOLE.click();

			Select Qualification_AH = new Select(Pre_Qualification_ARHAR);
			Qualification_AH.selectByContainsVisibleText("Qualified");

			Address1.sendKeys("2");
			Address2.sendKeys("3");
			Address3.sendKeys("3");
			Address4.sendKeys("4");
			Address5.sendKeys("3");
			Address6.sendKeys("4");
			Address7.sendKeys("12");

			break;
		case 6:
			System.out.println("You selected: CHANA ");
			Select Grade_CHANA = new Select(Grade_CHANA_WHOLE);
			Grade_CHANA.selectByVisibleText("NAFED FAQ"); // Grade_CHANA_WHOLE.click();

			Select Qualification = new Select(Pre_Qualification_Txt);
			Qualification.selectByContainsVisibleText("Qualified");

			Address1.sendKeys("3");

			Address2.sendKeys("4");

			Address3.sendKeys("6");

			Address4.sendKeys("4");

			Address5.sendKeys("2");

			Address6.sendKeys("1");

			Address7.sendKeys("14");

			Address8.sendKeys("4");

			break;
		case 13:
			System.out.println("You selected: Soyabean");
			Select SOYABEAN_Grade = new Select(Grade_SOYABEAN);
			SOYABEAN_Grade.selectByVisibleText("NAFED FAQ");

			Select Qualification_SOYABEAN = new Select(Pre_Qualification_SOYABEAN);
			Qualification_SOYABEAN.selectByContainsVisibleText("Qualified");

			Address1.sendKeys("12");
			Address2.sendKeys("2");
			Address3.sendKeys("5");
			Address4.sendKeys("3");
			Address5.sendKeys("15");

			break;
		default:
			System.out.println("Invalid selection!");
		}

		try {
			Upload_Assaying_Report.click();
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView(true);", Upload_Assaying_Report);
			js.executeScript("arguments[0].click();", Upload_Assaying_Report);
		} catch (NoSuchElementException e) {
			System.out.println("Upload_Assaying_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Upload_Assaying_Report: " + e.getMessage());
		}

		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView(true);", Verify_btn);
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn : " + e.getMessage());
		}

		try {
			if (Save_btn.isDisplayed()) {
				Save_btn.sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn : " + e.getMessage());
		}

	}

	public void Exchange_Non_Agriculture_Deposit_Assayer() {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println(" Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn : " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer : " + e.getMessage());
		}
		try {
			New_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", New_btn);
		} catch (NoSuchElementException e) {
			System.out.println("New_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for New_btn : " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(WareHouse_Id_btn)).click();
			WareHouse_Id_txt.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID));
			WareHouse_Id_txt.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			// js.executeScript("arguments[0].scrollIntoView(true);", WareHouse_Id_btn);
			js.executeScript("arguments[0].click();", WareHouse_Id_btn);
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID + "';",
					WareHouse_Id_txt);
			js.executeScript("arguments[0].click();", WareHouse_Id_txt);
		} catch (NoSuchElementException e) {
			System.out.println("WareHouse_Id_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for WareHouse_Id_btn: " + e.getMessage());
		}
		/*
		 * try {
		 * SampleId_txt.sendKeys(String.valueOf(Exchange_Non_Agri_WareHouse.Sample)); }
		 * catch (ElementClickInterceptedException e) {
		 * System.out.println("Normal click failed, trying JavaScript click...");
		 * js.executeScript("arguments[0].value='" + Exchange_Non_Agri_WareHouse.Sample
		 * + "';", SampleId_txt); } catch (NoSuchElementException e) {
		 * System.out.println("SampleId_txt not found: " + e.getMessage()); } catch
		 * (Exception e) { System.out.println("Unexpected error for SampleId_txt : " +
		 * e.getMessage()); }
		 */
		try {
			Search_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].scrollIntoView(true);", Search_btn);
			js.executeScript("arguments[0].click();", Search_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Search_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Search_btn: " + e.getMessage());
		}
		try {
			Select_btn.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].scrollIntoView(true);", Select_btn);
			js.executeScript("arguments[0].click();", Select_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Select_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Select_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(COA_No)).click();
			Wait.until(ExpectedConditions.elementToBeClickable(COA_No)).sendKeys(String.valueOf(Assayring_Referance));
			Assayring_Referance_No.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			// js.executeScript("arguments[0].scrollIntoView(true);",
			// Assayring_Referance_No);
			js.executeScript("arguments[0].click();", COA_No);
			js.executeScript("arguments[0].value='" + Assayring_Referance + "';", COA_No);
			js.executeScript("arguments[0].click();", COA_No);

		} catch (NoSuchElementException e) {
			System.out.println("Assayring_Referance_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
		}
		try {
			AssayingDate.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].scrollIntoView(true);", AssayingDate);
			js.executeScript("arguments[0].click();", AssayingDate);
		} catch (NoSuchElementException e) {
			System.out.println("AssayingDate not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for AssayingDate: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Calander)).click();
			Today_dates.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].scrollIntoView(true);", Calander);
			js.executeScript("arguments[0].click();", Calander);
			js.executeScript("arguments[0].scrollIntoView(true);", Today_dates);
			js.executeScript("arguments[0].click();", Today_dates);
		} catch (NoSuchElementException e) {
			System.out.println("Calander not found:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Calander: " + e.getMessage());
		}
		try {
			shelflife_count.sendKeys(shelflife);
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + shelflife + "';", Assayring_Referance_No);
		} catch (NoSuchElementException e) {
			System.out.println("shelflife_count not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for shelflife_count: " + e.getMessage());
		}
		try {
			Goods_Quality_Manu.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView(true);", Goods_Quality_Manu);
			js.executeScript("arguments[0].click();", Goods_Quality_Manu);
		} catch (NoSuchElementException e) {
			System.out.println("Goods_Quality_Manu not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Goods_Quality_Manu: " + e.getMessage());
		}

		int choice = Integer.parseInt(Exchange_Deposite_Request_Non_Agriculture_Maker.Commodity_Code);
		// Step 4: Use switch to process selection
		switch (choice) {
		case 1003:
			System.out.println("You selected: ZINC");
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Grade_Desig)).click();
				Select Grade = new Select(Grade_Desig);
				Grade.selectByVisibleText(Grade_Desig_type);
				Grade_Desig.click();
			} catch (ElementClickInterceptedException e) {
				// js.executeScript("arguments[0].scrollIntoView(true);", Grade_Desig);
				js.executeScript("arguments[0].click();", Grade_Desig);
				Select Grade = new Select(Grade_Desig);
				Grade.selectByVisibleText("GENERAL");
				// js.executeScript("arguments[0].scrollIntoView(true);", Grade_Desig);
				js.executeScript("arguments[0].click();", Grade_Desig);
			} catch (NoSuchElementException e) {
				System.out.println("Grade_Desig not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Grade_Desig: " + e.getMessage());
			}
			try {
				remark.sendKeys(Remark_Value);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].scrollIntoView(true);", remark);
				js.executeScript("arguments[0].click();", remark);
				js.executeScript("arguments[0].value='" + Assayring_Referance + "';", remark);
				// js.executeScript("arguments[0].click();", Assayring_Referance_No);
			} catch (NoSuchElementException e) {
				System.out.println("remark not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for remark: " + e.getMessage());
			}
			try {
				NABLCertificateDate.click();
			} catch (ElementClickInterceptedException e) {
				js.executeScript("arguments[0].scrollIntoView(true);", NABLCertificateDate);
				js.executeScript("arguments[0].click();", NABLCertificateDate);
			} catch (NoSuchElementException e) {
				System.out.println("NABLCertificateDate not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for NABLCertificateDate: " + e.getMessage());
			}
			try {
				Today_dates.click();
			} catch (ElementClickInterceptedException e) {
				js.executeScript("arguments[0].scrollIntoView(true);", Today_dates);
				js.executeScript("arguments[0].click();", Today_dates);
			} catch (NoSuchElementException e) {
				System.out.println("Today_dates not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Today_dates: " + e.getMessage());
			}
			try {
				NABLCertificateRefNo.sendKeys(NABLCertificateRefNum);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].scrollIntoView(true);", NABLCertificateRefNo);
				js.executeScript("arguments[0].click();", NABLCertificateRefNo);
				js.executeScript("arguments[0].value='" + NABLCertificateRefNum + "';", NABLCertificateRefNo);
				// js.executeScript("arguments[0].click();", Assayring_Referance_No);
			} catch (NoSuchElementException e) {
				System.out.println("NABLCertificateRefNo not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for NABLCertificateRefNo: " + e.getMessage());
			}
			try {
				Address1.sendKeys(Address_Value);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].scrollIntoView(true);", Address);
				js.executeScript("arguments[0].click();", Address);
				js.executeScript("arguments[0].value='" + Address_Value + "';", Address);
				// js.executeScript("arguments[0].click();", Assayring_Referance_No);
			} catch (NoSuchElementException e) {
				System.out.println("Address not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Address: " + e.getMessage());
			}
			break;
		default:
			System.out.println("Invalid selection!");
		}
		try {
			Upload_Assaying_Report.click();
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView(true);", Upload_Assaying_Report);
			js.executeScript("arguments[0].click();", Upload_Assaying_Report);
		} catch (NoSuchElementException e) {
			System.out.println("Upload_Assaying_Report not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Upload_Assaying_Report: " + e.getMessage());
		}

		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView(true);", Verify_btn);
			js.executeScript("arguments[0].click();", Verify_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn : " + e.getMessage());
		}

		try {
			if (Save_btn.isDisplayed()) {
				Save_btn.sendKeys(Keys.ENTER);
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			js.executeScript("arguments[0].click();", Save_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn : " + e.getMessage());
		}

	}

	public void Deposit_Assayer_Agriculture_Multiple_GSL_Maker() throws InterruptedException {

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
				Wait.until(ExpectedConditions.elementToBeClickable(New_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript New_btn click...");
				js.executeScript("arguments[0].click();", New_btn);
			} catch (NoSuchElementException e) {
				System.out.println("New_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for New_btn: " + e.getMessage());
			}
			// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(2000);
			try {
				if (RP_Deposite_Request_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{0,7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(WareHouse_Id_btn)).click();
					WareHouse_Id_txt.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.WH_ID));
					Thread.sleep(1000);
					WareHouse_Id_txt.sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript WareHouse_Id_btn click...");
				js.executeScript("arguments[0].click();", WareHouse_Id_btn);
				js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.WH_ID + "';",
						WareHouse_Id_txt);
				js.executeScript("arguments[0].click();", WareHouse_Id_txt);
			} catch (NoSuchElementException e) {
				System.out.println("WareHouse_Id_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for WareHouse_Id_btn: " + e.getMessage());
			}

			// Select SA = new Select(WareHouse_Id_txt);
			// SA.selectByContainsVisibleText("5750013");

			try {
				if (RP_Deposite_Request_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{0,50}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(SampleId_txt))
							.sendKeys(String.valueOf(RP_Deposite_Request_Agriculture_Maker.Deposite + i));
				} else {
					System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");

				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript SampleId_txt click...");
				js.executeScript("arguments[0].value='" + Physical_Deposit_Maker.Sample + "';", SampleId_txt);

			} catch (NoSuchElementException e) {
				System.out.println("SampleId_txt not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for SampleId_txt: " + e.getMessage());
			}
			/*
			 * try { if(Confirm_Ok.isDisplayed()) { Confirm_Ok.click(); } else {
			 * System.out.println("Confirm_Ok is not visible"); } } catch (Exception e) {
			 * System.out.println("Unexpected error for Confirm_Ok: " + e.getMessage()); }
			 */

			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_btn click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			} finally {
				System.out.println("Search_btn is click");
				Wait.until(ExpectedConditions.elementToBeClickable(Search_btn)).sendKeys(Keys.ENTER);
			}

			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Select_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Select_btn click...");
				js.executeScript("arguments[0].click();", Select_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Select_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Select_btn: " + e.getMessage());
			}
			// String.valueOf(Assayring_Referance)
			try {
				if (Assayring_Referance.matches("^[a-zA-Z0-9]{0,20}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No))
							.sendKeys(String.valueOf(Assayring_Referance + i));
					Assayring_Referance_No.sendKeys(Keys.ENTER);
					System.out.println("Assayring_Referance no:" + Assayring_Referance + i);
				} else {
					System.out.println("Invalid Assayring_Referance. Please enter exactly 20 alphanumeric characters:");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Assayring_Referance_No click...");
				js.executeScript("arguments[0].value='" + Assayring_Referance + "';", Assayring_Referance_No);
				js.executeScript("arguments[0].click();", Assayring_Referance_No);
			} catch (NoSuchElementException e) {
				System.out.println("Assayring_Referance_No not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", AssayingDate);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(AssayingDate)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Calander)).click();
				// Wait.until(ExpectedConditions.elementToBeClickable(Today_dates)).click();
				// Wait.until(ExpectedConditions.elementToBeClickable(WeekEnd_Date)).click();
				DayOfWeek today = LocalDateTime.now().getDayOfWeek();

				if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY) {
					// Click on Weekend date button
					WebElement weekendButton = Wait.until(ExpectedConditions.elementToBeClickable(WeekEnd_Date));
					weekendButton.click();
					System.out.println("Weekend button clicked");
				} else {
					// Click on Today date button
					WebElement todayButton = Wait.until(ExpectedConditions.elementToBeClickable(Today_dates));
					todayButton.click();
					System.out.println("Today date button clicked");
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", AssayingDate);
				js.executeScript("arguments[0].click();", Calander);
				js.executeScript("arguments[0].click();", Today_dates);
			} catch (NoSuchElementException e) {
				System.out.println("Element not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			/*
			 * String Month_Present = monthselect.getText();
			 * System.out.println(Month_Present); String Year_Present =yearselect.getText();
			 * System.out.println(Year_Present);
			 *
			 * Select Month =new Select(monthselect);
			 *
			 * Select Year =new Select(yearselect);
			 *
			 * LocalDateTime Live = LocalDateTime.now();
			 *
			 * while(Live.equals(Month)&& Live.equals(Year)) {
			 *
			 * Today_dates.click();
			 *
			 * }
			 */
			try {
				if (String.valueOf(shelflife).matches("^[0-9]{0,5}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(shelflife_count)).sendKeys(shelflife);
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript shelflife_count click...");
				js.executeScript("arguments[0].value='" + shelflife + "';", shelflife_count);
			} catch (NoSuchElementException e) {
				System.out.println("shelflife_count not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for shelflife_count: " + e.getMessage());
			}
			try {
				Goods_Quality_Manu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Goods_Quality_Manu click...");
				js.executeScript("arguments[0].click();", Goods_Quality_Manu);
			} catch (NoSuchElementException e) {
				System.out.println("Goods_Quality_Manu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Goods_Quality_Manu: " + e.getMessage());
			}

			try {
				Grade_Desig.click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Grade_Desig click...");
				js.executeScript("arguments[0].click();", Grade_Desig);
			} catch (NoSuchElementException e) {
				System.out.println("Grade_Desig not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Grade_Desig: " + e.getMessage());
			}
			int choice = Integer.parseInt(RP_Deposite_Request_Agriculture_Maker.Commodity_Code);

			// Step 4: Use switch to process selection

			switch (choice) {
			case 15:
				System.out.println("You selected: Cotton");
				Select Grade = new Select(Grade_Desig);
				Grade.selectByVisibleText("GENERAL");
				Grade_Desig.click();
				Select Pre_Qualification = new Select(Pre_Qualification_Txt);
				Pre_Qualification.selectByIndex(1);

				Address1.sendKeys("5");
				Address2.sendKeys("7");
				Address3.sendKeys("12");
				Address4.sendKeys("17");
				Address5.sendKeys("22");
				Address6.sendKeys("27");
				Address7.sendKeys("32");
				Select S = new Select(GINNING_PATTERN_ROLLER_GINNED_COTTON);
				S.selectByIndex(2);
				Address8.sendKeys("42");

				break;

			case 947:
				System.out.println("You selected: MENTHA Oil");
				Select MENTHA = new Select(Grade_Desig);
				MENTHA.selectByVisibleText("GENERAL");
				Grade_Desig.click();
				/*
				 * Select Pre_Qualification = new Select(Pre_Qualification_Txt);
				 * Pre_Qualification.selectByIndex(1);
				 */

				Address1.sendKeys("-36");
				/*
				 * Address2.sendKeys("7"); Address3.sendKeys("12"); Address4.sendKeys("17");
				 * Address5.sendKeys("22"); Address6.sendKeys("27"); Address7.sendKeys("32");
				 * Select Sd = new Select(GINNING_PATTERN_ROLLER_GINNED_COTTON);
				 * Sd.selectByIndex(2); Address8.sendKeys("42");
				 */
				Address10.sendKeys("1.42");

				break;
			case 49:
				System.out.println("You selected: Arhar");
				Select Grade_DE = new Select(Grade_ARHAR);
				Grade_DE.selectByVisibleText("NAFED FAQ"); // Grade_CHANA_WHOLE.click();

				Select Qualification_AH = new Select(Pre_Qualification_ARHAR);
				Qualification_AH.selectByContainsVisibleText("Qualified");

				Address1.sendKeys("2");
				Address2.sendKeys("3");
				Address3.sendKeys("3");
				Address4.sendKeys("4");
				Address5.sendKeys("3");
				Address6.sendKeys("4");
				Address7.sendKeys("12");

				break;
			case 6:
				System.out.println("You selected: CHANA ");
				Select Grade_CHANA = new Select(Grade_CHANA_WHOLE);
				Grade_CHANA.selectByVisibleText("SPECIAL"); // Grade_CHANA_WHOLE.click();

				Select Qualification = new Select(Pre_Qualification_Txt);
				Qualification.selectByContainsVisibleText("Qualified");

				Address1.sendKeys("3");

				Address2.sendKeys("4");

				Address3.sendKeys("0.75");

				Address4.sendKeys("0.25");

				Address5.sendKeys("2");

				Address6.sendKeys("5");

				break;
			case 13:
				System.out.println("You selected: Soyabean");
				Select SOYABEAN_Grade = new Select(Grade_SOYABEAN);
				SOYABEAN_Grade.selectByVisibleText("NAFED FAQ");

				Select Qualification_SOYABEAN = new Select(Pre_Qualification_SOYABEAN);
				Qualification_SOYABEAN.selectByContainsVisibleText("Qualified");

				Address1.sendKeys("12");
				Address2.sendKeys("2");
				Address3.sendKeys("5");
				Address4.sendKeys("3");
				Address5.sendKeys("15");

				break;
			case 1:
				System.out.println("You selected: WHEAT");
				Select WHEAT_Grade = new Select(Grade_Desig);
				WHEAT_Grade.selectByVisibleText("GRADE I");

				Select Qualification_WHEAT = new Select(Pre_Qualification_WHEAT);
				Qualification_WHEAT.selectByContainsVisibleText("Qualified");

				Address1.sendKeys("4");
				Address2.sendKeys("8");
				Address3.sendKeys("20");
				Address4.sendKeys("5");
				Address5.sendKeys("10");
				Address6.sendKeys("10");
				Address7.sendKeys("5");
				Address8.sendKeys("12");
				break;
			default:
				System.out.println("Invalid selection!");
			}

			try {
				if (Upload_Assaying_Report.isDisplayed()) {
					Upload_Assaying_Report.click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Upload_Assaying_Report click...");
				js.executeScript("arguments[0].click();", Upload_Assaying_Report);
			} catch (NoSuchElementException e) {
				System.out.println("Upload_Assaying_Report not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Upload_Assaying_Report: " + e.getMessage());
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			try {
				if (Save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Save_btn click...");
				js.executeScript("arguments[0].click();", Save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Save_btn: " + e.getMessage());
			}
			Thread.sleep(3000);
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		}

	}

	public void Exchange_Deposit_Assayer_Agriculture_Multiple_GSL() throws InterruptedException {
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
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(New_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript New_btn click...");
				js.executeScript("arguments[0].click();", New_btn);
			} catch (NoSuchElementException e) {
				System.out.println("New_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for New_btn: " + e.getMessage());
			}
			Thread.sleep(2000);
			try {
				if (RP_Exchange_Deposite_Agriculture_Maker.WH_ID.matches("^[a-zA-Z0-9]{7}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(WareHouse_Id_btn)).click();
					WareHouse_Id_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.WH_ID));
					WareHouse_Id_txt.sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid WH_ID. Please enter exactly 7 alphanumeric characters:");
				}

			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript WareHouse_Id_btn click...");
				js.executeScript("arguments[0].click();", WareHouse_Id_btn);
				js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.WH_ID + "';",
						WareHouse_Id_txt);
				js.executeScript("arguments[0].click();", WareHouse_Id_txt);
			} catch (NoSuchElementException e) {
				System.out.println("WareHouse_Id_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for WareHouse_Id_btn: " + e.getMessage());
			}

			// Select SA = new Select(WareHouse_Id_txt);
			// SA.selectByContainsVisibleText("5750013");

			try {
				if (RP_Exchange_Deposite_Agriculture_Maker.Deposite.matches("^[a-zA-Z0-9]{0,50}$")) {

					// 020220260
					// SampleId_txt.sendKeys("020220260" + i);
					SampleId_txt.sendKeys(String.valueOf(RP_Exchange_Deposite_Agriculture_Maker.Deposite + i));
				} else {
					System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");

				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript SampleId_txt click...");
				js.executeScript("arguments[0].value='" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + i + "';",
						SampleId_txt);

			} catch (NoSuchElementException e) {
				System.out.println("SampleId_txt not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for SampleId_txt: " + e.getMessage());
			}
			try {
				Search_btn.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Search_btn click...");
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
			try {
				Select_btn.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Select_btn click...");
				js.executeScript("arguments[0].click();", Select_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Select_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Select_btn: " + e.getMessage());
			}
			// String.valueOf(Assayring_Referance)
			try {
				if (Assayring_Referance.matches("^[a-zA-Z0-9]{0,20}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No)).click();
					Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No))
							.sendKeys(String.valueOf(Assayring_Referance + i));
					Assayring_Referance_No.sendKeys(Keys.ENTER);
				} else {
					System.out.println("Invalid Assayring_Referance. Please enter exactly 20 alphanumeric characters:");

				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Assayring_Referance_No click...");
				js.executeScript("arguments[0].value='" + Assayring_Referance + "';", Assayring_Referance_No);
				js.executeScript("arguments[0].click();", Assayring_Referance_No);
			} catch (NoSuchElementException e) {
				System.out.println("Assayring_Referance_No not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", AssayingDate);
			try {
				AssayingDate.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Calander)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(Today_dates)).click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", AssayingDate);
				js.executeScript("arguments[0].click();", Calander);
				js.executeScript("arguments[0].click();", Today_dates);
			} catch (NoSuchElementException e) {
				System.out.println("Element not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
			/*
			 * String Month_Present = monthselect.getText();
			 * System.out.println(Month_Present); String Year_Present =yearselect.getText();
			 * System.out.println(Year_Present);
			 *
			 * Select Month =new Select(monthselect);
			 *
			 * Select Year =new Select(yearselect);
			 *
			 * LocalDateTime Live = LocalDateTime.now();
			 *
			 * while(Live.equals(Month)&& Live.equals(Year)) {
			 *
			 * Today_dates.click();
			 *
			 * }
			 */
			try {
				if (String.valueOf(shelflife).matches("^[0-9]{0,5}$")) {
					shelflife_count.sendKeys(shelflife);
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript shelflife_count click...");
				js.executeScript("arguments[0].value='" + shelflife + "';", shelflife_count);
			} catch (NoSuchElementException e) {
				System.out.println("shelflife_count not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for shelflife_count: " + e.getMessage());
			}
			try {
				Goods_Quality_Manu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Goods_Quality_Manu click...");
				js.executeScript("arguments[0].click();", Goods_Quality_Manu);
			} catch (NoSuchElementException e) {
				System.out.println("Goods_Quality_Manu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Goods_Quality_Manu: " + e.getMessage());
			}

			try {
				Grade_Desig.click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Grade_Desig click...");
				js.executeScript("arguments[0].click();", Grade_Desig);
			} catch (NoSuchElementException e) {
				System.out.println("Grade_Desig not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Grade_Desig: " + e.getMessage());
			}
			int choice = Integer.parseInt(RP_Exchange_Deposite_Agriculture_Maker.Commodity_Code);

			// Step 4: Use switch to process selection

			switch (choice) {
			case 15:
				System.out.println("You selected: Cotton");
				Select Grade = new Select(Grade_Desig);
				Grade.selectByVisibleText("GENERAL");
				Grade_Desig.click();

				Address1.sendKeys(String.valueOf(28));
				Address2.sendKeys(String.valueOf(4));
				Address3.sendKeys(String.valueOf(4));
				Address4.sendKeys(String.valueOf(28));
				Select S = new Select(GINNING_PATTERN_ROLLER_GINNED_COTTON);
				S.selectByIndex(1);

				Address5.sendKeys(String.valueOf(7));
				Address6.sendKeys(String.valueOf(80));
				Address7.sendKeys(String.valueOf(8));

				/*
				 * //PreProd Data Address1.sendKeys(String.valueOf(28));
				 * Address2.sendKeys(String.valueOf(4)); Address3.sendKeys(String.valueOf(28));
				 * Address4.sendKeys(String.valueOf(4)); Address5.sendKeys(String.valueOf(73));
				 * Address6.sendKeys(String.valueOf(1)); Address7.sendKeys(String.valueOf(9));
				 * Select S = new Select(GINNING_PATTERN_ROLLER_GINNED_COTTON);
				 * S.selectByIndex(1);
				 */
				break;
			case 49:
				System.out.println("You selected: Arhar");
				Select Grade_DE = new Select(Grade_ARHAR);
				Grade_DE.selectByVisibleText("NAFED FAQ"); // Grade_CHANA_WHOLE.click();

				Select Qualification_AH = new Select(Pre_Qualification_ARHAR);
				Qualification_AH.selectByContainsVisibleText("Qualified");

				FOREIGN_MATTER_ARHAR.sendKeys("2");
				ADMIXTURE_ARHAR.sendKeys("3");
				DAMAGED_PULSES.sendKeys("3");
				SLIGHTLY_DAMAGED_PULSES.sendKeys("4");
				IMMATURE_AND_SHRIVELLED_PULSES.sendKeys("3");
				WEEVILLED_PULSES.sendKeys("4");
				MOISTURE_ARHAR.sendKeys("12");

				break;

			case 947:
				System.out.println("You selected: MENTHA Oil");
				Select MENTHA = new Select(Grade_Desig);
				MENTHA.selectByVisibleText("GENERAL");
				Grade_Desig.click();
				/*
				 * Select Pre_Qualification = new Select(Pre_Qualification_Txt);
				 * Pre_Qualification.selectByIndex(1);
				 */

				Address1.sendKeys("67");
				Address2.sendKeys("2");
				Select Sd = new Select(CARBITOL_Drop);
				Sd.selectByIndex(2);
				Address3.sendKeys("1");
				Address4.sendKeys("-36");
				Address5.sendKeys("0.8");
				Select SO = new Select(SOLUBILITY_Drop);
				SO.selectByIndex(1);
				Select ET = new Select(ETHYL_Drop);
				ET.selectByIndex(1);
				Address6.sendKeys("65");
				Address7.sendKeys("1.42");

				break;
			case 6:
				System.out.println("You selected: CHANA ");
				Select Grade_CHANA = new Select(Grade_CHANA_WHOLE);
				Grade_CHANA.selectByVisibleText("NAFED FAQ"); // Grade_CHANA_WHOLE.click();

				Select Qualification = new Select(Pre_Qualification_Txt);
				Qualification.selectByContainsVisibleText("Qualified");

				OTHER_FOOD_GRAINS_CHANA.sendKeys("3");

				DAMAGED_GRAINS_CHANA.sendKeys("4");

				IMMATURE_SHRIVELED_AND_BROKEN_GRAINS_Chana.sendKeys("6");

				WEEVILED_GRAINS_Chana.sendKeys("4");

				ADMIXTURE_Chana.sendKeys("2");

				FOREIGN_MATTER_chana.sendKeys("1");

				MOISTURE_CONTENT_Chana.sendKeys("14");

				SLIGHTLY_DAMAGED_TOUCHED_GRAINS_Chana.sendKeys("4");

				break;
			case 13:
				System.out.println("You selected: Soyabean");
				Select SOYABEAN_Grade = new Select(Grade_SOYABEAN);
				SOYABEAN_Grade.selectByVisibleText("NAFED FAQ");

				Select Qualification_SOYABEAN = new Select(Pre_Qualification_SOYABEAN);
				Qualification_SOYABEAN.selectByContainsVisibleText("Qualified");

				MOISTURE_CONTENT_SOYABEAN.sendKeys("12");
				FOREIGN_MATTER_IMPURITIES.sendKeys("2");
				SHRIVELLED_IMMATURE_BEANS_DISCOLOURED.sendKeys("5");
				DAMAGED_AND_WEEVILLED_BEANS.sendKeys("3");
				MECHANICALLY_DAMAGED_BEANS.sendKeys("15");

				break;
			default:
				System.out.println("Invalid selection!");
			}

			try {
				if (Upload_Assaying_Report.isDisplayed()) {
					Upload_Assaying_Report.click();
				}
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Upload_Assaying_Report click...");
				js.executeScript("arguments[0].click();", Upload_Assaying_Report);
			} catch (NoSuchElementException e) {
				System.out.println("Upload_Assaying_Report not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Upload_Assaying_Report: " + e.getMessage());
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
				js.executeScript("arguments[0].click();", Save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Save_btn: " + e.getMessage());
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}

	}

	public void Exchange_Deposit_Assayer_Non_Agriculture_Multiple_GSL() throws InterruptedException {
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Transaction_Btn trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println(" Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn : " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Deposit_Assayer trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer : " + e.getMessage());
		}
		for (int i = 0; i <= Exchange_Non_Agri_WareHouse.totalBags; i++) {
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(New_btn)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].click();", New_btn);
			} catch (NoSuchElementException e) {
				System.out.println("New_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for New_btn : " + e.getMessage());
			}
			Thread.sleep(1000);
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(WareHouse_Id_btn)).click();
				WareHouse_Id_txt.sendKeys(String.valueOf(Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID));
				WareHouse_Id_txt.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				// js.executeScript("arguments[0].scrollIntoView(true);", WareHouse_Id_btn);
				js.executeScript("arguments[0].click();", WareHouse_Id_btn);
				js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.WH_ID + "';",
						WareHouse_Id_txt);
				js.executeScript("arguments[0].click();", WareHouse_Id_txt);
			} catch (NoSuchElementException e) {
				System.out.println("WareHouse_Id_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for WareHouse_Id_btn: " + e.getMessage());
			}
			/*
			 * try { SampleId_txt.sendKeys(String.valueOf(Exchange_Non_Agri_WareHouse.Sample
			 * +i)); } catch (ElementClickInterceptedException e) {
			 * System.out.println("Normal click failed, trying JavaScript click...");
			 * js.executeScript("arguments[0].value='" + Exchange_Non_Agri_WareHouse.Sample
			 * + "';", SampleId_txt); } catch (NoSuchElementException e) {
			 * System.out.println("SampleId_txt not found: " + e.getMessage()); } catch
			 * (Exception e) { System.out.println("Unexpected error for SampleId_txt : " +
			 * e.getMessage()); }
			 */
			try {
				Search_btn.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].scrollIntoView(true);", Search_btn);
				js.executeScript("arguments[0].click();", Search_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Search_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Search_btn: " + e.getMessage());
			}
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

				List<WebElement> valueElements = driver.findElements(By.xpath(
						"//div[contains(text(),'" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "')]"));
				if (valueElements.contains(valueElements)) {
					System.out.println("Step One");
					if (valueElements.size() > 0) {
						// Value found, click the button in the same row/div

						WebElement button = driver.findElement(By.xpath(
								"//div[contains(text(),'" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite
										+ "')]/preceding::div[@class='ui-grid-cell-contents ng-scope'][1]"));

						button.click();
						System.out.println("✅ Clicked on Select button for value: "
								+ Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite);
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

								WebElement button = driver.findElement(By.xpath("//div[contains(text(),'"
										+ Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite
										+ "')]/preceding::div[@class='ui-grid-cell-contents ng-scope'][1]"));

								button.click();
								System.out.println("✅ Clicked on Select button for value: "
										+ Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite);
								found = true;
								break;
							}
						} catch (Exception e) {
							System.out.println("Unexpected error for valueElements: " + e.getMessage());
						}
						System.out.println("➡️ Moved to next page...");
						Thread.sleep(2000); // Wait for next page data to load
					} else {
						System.out.println("❌ Value " + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite
								+ " not found in any page.");
						break;
					}
				}
			}

			if (!found) {
				System.out.println("⚠️ Target value " + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite
						+ " was not found in the table.");
			}

			/*
			 * try { Select_btn.sendKeys(Keys.ENTER); } catch
			 * (ElementClickInterceptedException e) {
			 * System.out.println("Normal click failed, trying JavaScript click...");
			 * js.executeScript("arguments[0].scrollIntoView(true);", Select_btn);
			 * js.executeScript("arguments[0].click();", Select_btn); } catch
			 * (NoSuchElementException e) { System.out.println("Select_btn not found: " +
			 * e.getMessage()); } catch (Exception e) {
			 * System.out.println("Unexpected error for Select_btn: " + e.getMessage()); }
			 */
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(COA_No)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(COA_No))
						.sendKeys(String.valueOf(Assayring_Referance + i));
				Assayring_Referance_No.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				// js.executeScript("arguments[0].scrollIntoView(true);",
				// Assayring_Referance_No);
				js.executeScript("arguments[0].click();", COA_No);
				js.executeScript("arguments[0].value='" + Assayring_Referance + i + "';", COA_No);
				js.executeScript("arguments[0].click();", COA_No);

			} catch (NoSuchElementException e) {
				System.out.println("Assayring_Referance_No not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
			}
			try {
				AssayingDate.click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].scrollIntoView(true);", AssayingDate);
				js.executeScript("arguments[0].click();", AssayingDate);
			} catch (NoSuchElementException e) {
				System.out.println("AssayingDate not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for AssayingDate: " + e.getMessage());
			}
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Calander)).click();
				Today_dates.click();
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript click...");
				js.executeScript("arguments[0].scrollIntoView(true);", Calander);
				js.executeScript("arguments[0].click();", Calander);
				js.executeScript("arguments[0].scrollIntoView(true);", Today_dates);
				js.executeScript("arguments[0].click();", Today_dates);
			} catch (NoSuchElementException e) {
				System.out.println("Calander not found:" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Calander: " + e.getMessage());
			}
			try {
				shelflife_count.sendKeys(shelflife);
			} catch (ElementClickInterceptedException e) {
				js.executeScript("arguments[0].value='" + shelflife + "';", Assayring_Referance_No);
			} catch (NoSuchElementException e) {
				System.out.println("shelflife_count not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for shelflife_count: " + e.getMessage());
			}
			try {
				Goods_Quality_Manu.sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				js.executeScript("arguments[0].scrollIntoView(true);", Goods_Quality_Manu);
				js.executeScript("arguments[0].click();", Goods_Quality_Manu);
			} catch (NoSuchElementException e) {
				System.out.println("Goods_Quality_Manu not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Goods_Quality_Manu: " + e.getMessage());
			}

			int choice = Integer.parseInt(Exchange_Deposite_Request_Non_Agriculture_Maker.Commodity_Code);
			// Step 4: Use switch to process selection
			switch (choice) {
			case 1003:
				System.out.println("You selected: ZINC");
				try {
					Wait.until(ExpectedConditions.elementToBeClickable(Grade_Desig)).click();
					Select Grade = new Select(Grade_Desig);
					Grade.selectByVisibleText(Grade_Desig_type);
					Grade_Desig.click();
				} catch (ElementClickInterceptedException e) {
					// js.executeScript("arguments[0].scrollIntoView(true);", Grade_Desig);
					js.executeScript("arguments[0].click();", Grade_Desig);
					Select Grade = new Select(Grade_Desig);
					Grade.selectByVisibleText("GENERAL");
					// js.executeScript("arguments[0].scrollIntoView(true);", Grade_Desig);
					js.executeScript("arguments[0].click();", Grade_Desig);
				} catch (NoSuchElementException e) {
					System.out.println("Grade_Desig not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for Grade_Desig: " + e.getMessage());
				}
				try {
					remark.sendKeys(Remark_Value);
				} catch (ElementClickInterceptedException e) {
					System.out.println("Normal click failed, trying JavaScript click...");
					js.executeScript("arguments[0].scrollIntoView(true);", remark);
					js.executeScript("arguments[0].click();", remark);
					js.executeScript("arguments[0].value='" + Assayring_Referance + "';", remark);
					// js.executeScript("arguments[0].click();", Assayring_Referance_No);
				} catch (NoSuchElementException e) {
					System.out.println("remark not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for remark: " + e.getMessage());
				}
				try {
					NABLCertificateDate.click();
				} catch (ElementClickInterceptedException e) {
					js.executeScript("arguments[0].scrollIntoView(true);", NABLCertificateDate);
					js.executeScript("arguments[0].click();", NABLCertificateDate);
				} catch (NoSuchElementException e) {
					System.out.println("NABLCertificateDate not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for NABLCertificateDate: " + e.getMessage());
				}
				try {
					Today_dates.click();
				} catch (ElementClickInterceptedException e) {
					js.executeScript("arguments[0].scrollIntoView(true);", Today_dates);
					js.executeScript("arguments[0].click();", Today_dates);
				} catch (NoSuchElementException e) {
					System.out.println("Today_dates not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for Today_dates: " + e.getMessage());
				}
				try {
					NABLCertificateRefNo.sendKeys(NABLCertificateRefNum);
				} catch (ElementClickInterceptedException e) {
					System.out.println("Normal click failed, trying JavaScript click...");
					js.executeScript("arguments[0].scrollIntoView(true);", NABLCertificateRefNo);
					js.executeScript("arguments[0].click();", NABLCertificateRefNo);
					js.executeScript("arguments[0].value='" + NABLCertificateRefNum + "';", NABLCertificateRefNo);
					// js.executeScript("arguments[0].click();", Assayring_Referance_No);
				} catch (NoSuchElementException e) {
					System.out.println("NABLCertificateRefNo not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for NABLCertificateRefNo: " + e.getMessage());
				}
				try {
					Address.sendKeys(Address_Value);
				} catch (ElementClickInterceptedException e) {
					System.out.println("Normal click failed, trying JavaScript click...");
					js.executeScript("arguments[0].scrollIntoView(true);", Address);
					js.executeScript("arguments[0].click();", Address);
					js.executeScript("arguments[0].value='" + Address_Value + "';", Address);
					// js.executeScript("arguments[0].click();", Assayring_Referance_No);
				} catch (NoSuchElementException e) {
					System.out.println("Address not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for Address: " + e.getMessage());

				}

				break;
			case 1001:
				System.out.println("You selected: ALUMINUM");
				try {
					Wait.until(ExpectedConditions.elementToBeClickable(Grade_Desig)).click();
					Select Grade = new Select(Grade_Desig);
					Grade.selectByVisibleText(Grade_Desig_type);
					Grade_Desig.click();
				} catch (ElementClickInterceptedException e) {
					// js.executeScript("arguments[0].scrollIntoView(true);", Grade_Desig);
					js.executeScript("arguments[0].click();", Grade_Desig);
					Select Grade = new Select(Grade_Desig);
					Grade.selectByVisibleText("GENERAL");
					// js.executeScript("arguments[0].scrollIntoView(true);", Grade_Desig);
					js.executeScript("arguments[0].click();", Grade_Desig);
				} catch (NoSuchElementException e) {
					System.out.println("Grade_Desig not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for Grade_Desig: " + e.getMessage());
				}
				try {
					remark.sendKeys(Remark_Value);
				} catch (ElementClickInterceptedException e) {
					System.out.println("Normal click failed, trying JavaScript click...");
					js.executeScript("arguments[0].scrollIntoView(true);", remark);
					js.executeScript("arguments[0].click();", remark);
					js.executeScript("arguments[0].value='" + Assayring_Referance + "';", remark);
					// js.executeScript("arguments[0].click();", Assayring_Referance_No);
				} catch (NoSuchElementException e) {
					System.out.println("remark not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for remark: " + e.getMessage());
				}
				try {
					NABLCertificateDate.click();
				} catch (ElementClickInterceptedException e) {
					js.executeScript("arguments[0].scrollIntoView(true);", NABLCertificateDate);
					js.executeScript("arguments[0].click();", NABLCertificateDate);
				} catch (NoSuchElementException e) {
					System.out.println("NABLCertificateDate not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for NABLCertificateDate: " + e.getMessage());
				}
				try {
					Today_dates.click();
				} catch (ElementClickInterceptedException e) {
					js.executeScript("arguments[0].scrollIntoView(true);", Today_dates);
					js.executeScript("arguments[0].click();", Today_dates);
				} catch (NoSuchElementException e) {
					System.out.println("Today_dates not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for Today_dates: " + e.getMessage());
				}
				try {
					NABLCertificateRefNo.sendKeys(NABLCertificateRefNum);
				} catch (ElementClickInterceptedException e) {
					System.out.println("Normal click failed, trying JavaScript click...");
					js.executeScript("arguments[0].scrollIntoView(true);", NABLCertificateRefNo);
					js.executeScript("arguments[0].click();", NABLCertificateRefNo);
					js.executeScript("arguments[0].value='" + NABLCertificateRefNum + "';", NABLCertificateRefNo);
					// js.executeScript("arguments[0].click();", Assayring_Referance_No);
				} catch (NoSuchElementException e) {
					System.out.println("NABLCertificateRefNo not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for NABLCertificateRefNo: " + e.getMessage());
				}
				try {
					Address.sendKeys(Address_Value);
				} catch (ElementClickInterceptedException e) {
					System.out.println("Normal click failed, trying JavaScript click...");
					js.executeScript("arguments[0].scrollIntoView(true);", Address);
					js.executeScript("arguments[0].click();", Address);
					js.executeScript("arguments[0].value='" + Address_Value + "';", Address);
					// js.executeScript("arguments[0].click();", Assayring_Referance_No);
				} catch (NoSuchElementException e) {
					System.out.println("Address not found: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected error for Address: " + e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid selection!");
			}
			try {
				Upload_Assaying_Report.click();
			} catch (ElementClickInterceptedException e) {
				js.executeScript("arguments[0].scrollIntoView(true);", Upload_Assaying_Report);
				js.executeScript("arguments[0].click();", Upload_Assaying_Report);
			} catch (NoSuchElementException e) {
				System.out.println("Upload_Assaying_Report not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Upload_Assaying_Report: " + e.getMessage());
			}

			try {
				if (Verify_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).sendKeys(Keys.ENTER);
				}
			} catch (ElementClickInterceptedException e) {
				js.executeScript("arguments[0].scrollIntoView(true);", Verify_btn);
				js.executeScript("arguments[0].click();", Verify_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Verify_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Verify_btn : " + e.getMessage());
			}

			try {
				if (Save_btn.isDisplayed()) {
					Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).sendKeys(Keys.ENTER);
				}
			} catch (ElementClickInterceptedException e) {
				js.executeScript("arguments[0].scrollIntoView(true);", Save_btn);
				js.executeScript("arguments[0].click();", Save_btn);
			} catch (NoSuchElementException e) {
				System.out.println("Save_btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Save_btn : " + e.getMessage());
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void Deposit_Assayer_Pending_CR318() throws InterruptedException {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Btn)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Transaction_Btn trying JavaScript click...");
			js.executeScript("arguments[0].click();", Transaction_Btn);
		} catch (NoSuchElementException e) {
			System.out.println(" Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn : " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Deposit_Assayer)).click();

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, Deposit_Assayer trying JavaScript click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer : " + e.getMessage());
		}

		Thread.sleep(1000);

		if (PendingforDepositAssayer.isDisplayed()) {

			PendingforDepositAssayer.click();
		} else {
			System.out.println("Pending for Deposit Confirm is not visible");
		}
		Thread.sleep(1000);

	}

}
