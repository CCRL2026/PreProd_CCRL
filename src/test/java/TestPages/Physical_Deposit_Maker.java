package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import Utillity.DataBaseUtility;
import Utillity.ExcelUtils;

public class Physical_Deposit_Maker {

	// private static final String Commodity_Code = null;
	WebDriver driver;
	WebDriverWait Wait;
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ENWR_Creation.xlsx";
	static String sheet = "Physical_Deposit_Maker";
	static int dataRow = 1; // second row of data
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static ExcelUtils excel = new ExcelUtils(path, sheet);
	/*
	 * String Internal_Ref = "53406"; // 53267; String OTP_Auth = "674841"; //
	 * 557332; int Tare_Weight_value = 200; String assaying_type = "Self Verified";
	 * String Weight_bridge = "Abhishek"; String Weight_bridge_Receipt = "12343";
	 * public static String Sample = "46202556"; public static int lot_No =
	 * 46202554; public String dispatch_Number = "RDW6225032511181520"; int
	 * Assayring_Referance_Id = 406202507; static String WeighbridgeNetWeight =
	 * "1190"; String EstimatedValueAtDeposit = "5000"; String MoistureAtDeposit =
	 * "6"; String Rate_of_Storage_Charges = "6"; String Per_UOM = "5"; String
	 * Godown_No = "A"; String Stack_No = "B"; String Lot_No = "c"; String
	 * PanCard_No = "BPTPT5612N"; String DepositerName = "Abhishek Thasal"; String
	 * L1 = "Room No 102"; String L2 = "Jarimari Mandir Road"; String L3 =
	 * "Umelman"; String City_Name = "Vasai"; String PinCode = "401202"; int
	 * shelflife = 179; String Bag_Total =
	 * RP_Deposite_Request_Agriculture_Maker.bags; static int Bags = 100;
	 */
	String Internal_Ref;// = excel.getInternal_Ref_py(dataRow);//"53429";
	String OTP_Auth;// =excel.getOTP_Auth_py(dataRow);// "886612";
	int Tare_Weight_value = excel.getTare_Weight_value_py(dataRow);
	String assaying_type = excel.getassaying_type_py(dataRow);
	String Weight_bridge = excel.getWeight_bridge_py(dataRow);
	String Weight_bridge_Receipt = excel.getWeight_bridge_Receipt_py(dataRow);
	public static String Sample = excel.getSample_py(dataRow);
	public static String lot_No = excel.getlot_No_py(dataRow);
	public String dispatch_Number = excel.getdispatch_Number_py(dataRow);
	int Assayring_Referance_Id = excel.getAssayring_Referance_Id_py(dataRow);
	static String WeighbridgeNetWeight = excel.getWeighbridgeNetWeighte_py(dataRow);
	String EstimatedValueAtDeposit = excel.getEstimatedValueAtDeposit_py(dataRow);
	String MoistureAtDeposit = excel.getMoistureAtDeposit_py(dataRow);
	String Rate_of_Storage_Charges = excel.getRate_of_Storage_Charges_py(dataRow);
	String Per_UOM = excel.getPer_UOM_py(dataRow);
	String Godown_No = excel.getGodown_No_py(dataRow);
	String Stack_No = excel.getStack_No_py(dataRow);
	String Lot_No = excel.getLot_No_py(dataRow);
	String PanCard_No = excel.getPanCard_No_py(dataRow);
	String DepositerName = excel.getDepositerName_py(dataRow);
	String L1 = excel.getL1_py(dataRow);
	String L2 = excel.getL2_py(dataRow);
	String L3 = excel.getL3_py(dataRow);
	String City_Name = excel.getCity_Name_py(dataRow);
	String PinCode = excel.getPinCode_py(dataRow);
	int shelflife = excel.getshelflife_py(dataRow);
	public static String Bag_Total = excel.getBag_Total_py(dataRow);
	static int Bags = excel.getBags_py(dataRow);
	String Variety_Code = "999 - Cotton Bales";
	int j = 3;
	int i;
//	int k = j * i;

	public Physical_Deposit_Maker(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// Physical Deposit WebElement
	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Transactions'])[1]")
	WebElement Transaction_btn;
	@FindBy(xpath = "//span[normalize-space()='Physical Deposit']")
	WebElement Physical_Deposite;
	@FindBy(xpath = "(//a[@ui-sref='Transactions.Depositgoverment'])[1]")
	WebElement Depositgoverment;

	@FindBy(xpath = "//a[normalize-space()='Pending for Physical Deposit']")
	WebElement PendingforPhysical;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement Physical_New_Req;
	@FindBy(xpath = "(//input[@name='drn1'])[1]")
	WebElement Internal_Ref_No;
	@FindBy(xpath = "//input[@name='auth_code']")
	WebElement Auth_Code;
	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Submit'])[1]")
	WebElement Submit_btn;
	@FindBy(xpath = "//span[@class='check']")
	WebElement Accept_check;
	// button[@ng-disabled='submitShow']
	// button[@type='submit' and @ng-disabled='submitShow' and
	// normalize-space(text())='Submit']
	@FindBy(xpath = "//button[@type='submit' and @ng-disabled='submitShow' and normalize-space(text())='Submit']")
	WebElement submit_btn;
	@FindBy(xpath = "//input[@name='Tare_Weight']")
	WebElement Tare_Weight;
	@FindBy(xpath = "//button[@data-id='VarietyMasterSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Variety_Code_bttn;
	// (//div[@class='bs-searchbox'])[3]
	// select[@id='VarietyMasterSelectionCombobox']
	// (//input[@type='text'])[25]

	@FindBy(xpath = "(//input[@type='text'])[25]")
	WebElement Variety_Code_Text;
	// input[@name='dispatch_id' and @ng-model='vm.CreateDepositWspWh.dispatch_id']
	@FindBy(xpath = "(//input[contains(@class, 'form-control') and @ng-model='vm.CreateDepositWspWh.dispatch_id'])[1]")
	WebElement dispatch_id_GA;
	@FindBy(xpath = "//input[@name='dispatch_id' and @ng-model='vm.CreateDepositWspWh.dispatch_id']")
	// input[contains(@class, 'form-control') and @name='dispatch_id' and
	// @ng-disabled='IsDisabletxt'][1]")
	WebElement dispatch_id;
	@FindBy(xpath = "//select[@name='assaying_type']")
	WebElement assaying_type_Text;
	@FindBy(xpath = "//input[@name='WeighbridgeName']")
	WebElement Weight_bridge_text;
	@FindBy(xpath = "//input[@id='notinalquant']")
	WebElement Notional_Quantity;
	@FindBy(xpath = "//input[@name='WeighbridgeReceipt']")
	WebElement Weight_bridge_Receipt_text;
	@FindBy(xpath = "//input[@id='webbridge']")
	WebElement web_bridge;
	@FindBy(xpath = "//div[@class='col-sm-4']//input[@name='EstimatedValue']")
	WebElement Estimated;
	@FindBy(xpath = "//input[@id='per']")
	WebElement Moisture;
	@FindBy(xpath = "//input[@placeholder='Per Month']")
	WebElement Rate_of_Storage;
	@FindBy(xpath = "(//input[@name='StorageChargesperuom'])[1]")
	WebElement Per_UOM_Text;
	@FindBy(xpath = "//a[normalize-space()='Lot Details']")
	WebElement Lot;
	@FindBy(xpath = "//input[@name='godown']")
	WebElement Godown;
	@FindBy(xpath = "//input[@name='stack_no']")
	WebElement Stack_No_Text;
	@FindBy(xpath = "//input[@name='lot_no']")
	WebElement lot_no_Text;
	@FindBy(xpath = "//input[@ng-class=\"{'edited':LotDetails.no_of_bag}\"]")
	WebElement no_of_bag;
	@FindBy(xpath = "//input[@name='sample_Id']")
	WebElement sample_Id;

	// ----------- Multiple GSL Elements-------------------------
	@FindBy(xpath = "(//div[@class='col-sm-2'])[7]")
	WebElement Remaining_No_Of_Bags;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Lots_Confirmation;
	@FindBy(xpath = "//div[@class='row ng-scope']//div[@class='col-sm-2']")
	WebElement remainingBagsElement;
	@FindBy(xpath = "//button[@type='button' and @class='btn btn-info' and @ng-click='vm.addLotDetails()']")
	WebElement Add_Button;
	// ---------------------------Multiple GSL Elements
	// Ends-----------------------------
	@FindBy(xpath = "(//a[normalize-space()='General'])[1]")
	WebElement General_Manue;
	@FindBy(xpath = "//span[normalize-space()='Deposit Government Agency']")
	WebElement Deposit_Government_Agency;
	@FindBy(xpath = "(//a[normalize-space()='Verification'])[1]")
	WebElement Verification_page;
	@FindBy(xpath = "//a[normalize-space()='Depositor Detail']")
	WebElement Depositor_Detail;
	@FindBy(xpath = "//input[@name='depositordtl']")
	WebElement PAN_No;
	@FindBy(css = "input[name='DName']")
	WebElement Depositer;
	@FindBy(xpath = "//input[@id='Address']")
	WebElement Line_No_1;
	@FindBy(xpath = "//input[@name='Address2']")
	WebElement Line_No_2;
	@FindBy(xpath = "//input[@name='Address3']")
	WebElement Line_No_3;
	@FindBy(xpath = "//input[@name='Address5']")
	WebElement City;
	@FindBy(xpath = "//input[@name='PerPIN']")
	WebElement PinCode_Text;
	@FindBy(xpath = "input[name='State']")
	WebElement State;
	@FindBy(xpath = "(//button[normalize-space()='Ok'])[1]")
	WebElement Variety_Code_Pop_Up;
	@FindBy(xpath = "//button[@class='btn btn-danger ng-hide']")
	WebElement Verify_btn;
	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope']")
	WebElement Save_btn;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Number_Of_Bags_PopUp;

	// Deposit Assayer WebElement
	@FindBy(xpath = "//label[normalize-space()='Deposit Assayer']")
	WebElement Deposit_Assayer_CheckBox;
	@FindBy(xpath = "//input[@name='arn' and @ng-model='vm.DepositAssayer.arn']")
	WebElement Assayring_Referance_No;
	@FindBy(xpath = "(//input[@id='AssayingDate'])[1]")
	WebElement AssayingDate;
	@FindBy(xpath = "//div[@class='calendar left single']//tr[1]//th[3]")
	WebElement Calander;
	@FindBy(xpath = "//div[@class='calendar left single']//select[@class='monthselect']")
	WebElement monthselect;
	@FindBy(xpath = "//div[@class='calendar left single']//select[@class='yearselect']")
	WebElement yearselect;
	@FindBy(xpath = "(//td[@class='today active start-date active end-date in-range available'])[1]")
	WebElement Today_dates;
	@FindBy(xpath = "//input[@id='shelflife']")
	WebElement shelflife_count;
	@FindBy(xpath = "(//a[normalize-space()='Goods Quality'])[1]")
	WebElement Goods_Quality_Manu;
	@FindBy(xpath = "//select[@id='ddlcommodityMaster']")
	WebElement Grade_Desig;
	/**************************************
	 * QP Details for Cotton Bales for GA // Start
	 ************************************************************/
	@FindBy(xpath = "//select[@name='qual_conducted_view']")
	WebElement Pre_Qualification_Txt;
	@FindBy(xpath = "(//input[@name='name'])[4]")
	WebElement OTHER_FOOD_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[5]")
	WebElement DAMAGED_GRAINS;
	@FindBy(xpath = "(//input[@name='name'])[6]")
	WebElement SLIGHTLY_DAMAGED_GRAINS;
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
	@FindBy(xpath = "//select[@name='ddlcommodityMaster']")
	WebElement Grade_CHANA_WHOLE;

	@FindBy(xpath = "(//select[@name='qual_conducted_view'])[1]")
	WebElement Pre_Qualification;

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

	// ***************************QP details for SOYABEAN
	// Start**********************************************
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

	@FindBy(xpath = "//div[@class='col-sm-4']//input[@id='a']")
	WebElement Bag;

	@FindBy(xpath="//button[normalize-space()='Ok']")
	WebElement Records_Not_Found_popup;
	
	@FindBy(xpath = "(//a[@class='nav-link ng-binding'][normalize-space()='Lot Details'])[2]")
	WebElement Lots;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement Altert;

	public void General_Physical_Deposit_Maker() throws InterruptedException {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Id from deposit_txn where DRN like ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + RP_Deposite_Request_Agriculture_Maker.Deposite + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Internal_Ref = rs1.getString("Id");
				System.out.println("Internal_Ref print: " + Internal_Ref);
			}

			String query_OTP = "SELECT a.auth_code " + "FROM auth_code_generation a "
					+ "JOIN deposit_txn d ON a.ref_id = d.Id " + "WHERE d.DRN LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + RP_Deposite_Request_Agriculture_Maker.Deposite + "%"); // bind the variable to query

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_Deposite click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_Deposite not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_Deposite: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_New_Req)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_New_Req click...");
			js.executeScript("arguments[0].click();", Physical_New_Req);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_New_Req not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_New_Req: " + e.getMessage());
		}
		try {
			if (Internal_Ref.matches("^[0-9]{5}$")) {
				Internal_Ref_No.sendKeys(Internal_Ref);
				Internal_Ref_No.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Internal_Ref. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Internal_Ref_No click...");
			js.executeScript("arguments[0].value='" + Internal_Ref + "';", Internal_Ref_No);
			js.executeScript("arguments[0].click();", Internal_Ref_No);
		} catch (NoSuchElementException e) {
			System.out.println("Internal_Ref_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Internal_Ref_No: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			if (OTP_Auth.matches("^[0-9]{6}$")) {
				Auth_Code.sendKeys(OTP_Auth);
			} else {
				System.out.println("Invalid OTP_Auth. Please enter exactly 6 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Auth_Code click...");
			js.executeScript("arguments[0].value='" + OTP_Auth + "';", Auth_Code);
			js.executeScript("arguments[0].click();", Auth_Code);
		} catch (NoSuchElementException e) {
			System.out.println("Auth_Code not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Auth_Code: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Submit_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", Submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Submit_btn: " + e.getMessage());
		}
		try {
			Accept_check.isSelected();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", Accept_check);
		} catch (NoSuchElementException e) {
			System.out.println("Accept_check not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Accept_check: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Tare_Weight))
					.sendKeys(String.valueOf(Tare_Weight_value));

		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Tare_Weight click...");
			js.executeScript("arguments[0].value='" + Tare_Weight_value + "';", Tare_Weight);
		} catch (NoSuchElementException e) {
			System.out.println("Tare_Weight not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Tare_Weight: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(assaying_type_Text)).sendKeys(assaying_type);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript assaying_type_Text click...");
			js.executeScript("arguments[0].value='" + assaying_type + "';", assaying_type_Text);
		} catch (NoSuchElementException e) {
			System.out.println("assaying_type_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for assaying_type_Text: " + e.getMessage());
		}

		try {
			if (Weight_bridge.matches("^[a-zA-Z0-9]{0,100}$")) {
				Weight_bridge_text.sendKeys(Weight_bridge);
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 15 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weight_bridge_text click...");
			js.executeScript("arguments[0].value='" + Weight_bridge + "';", Weight_bridge_text);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_text: " + e.getMessage());
		}
		try {
			if (Weight_bridge_Receipt.matches("^[a-zA-Z0-9]{0,50}$")) {
				Weight_bridge_Receipt_text.sendKeys(Weight_bridge_Receipt);
				// int Quantity = Notional_Quantity.getText();
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 50 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weight_bridge_Receipt_text click...");
			js.executeScript("arguments[0].value='" + Weight_bridge_Receipt + "';", Weight_bridge_Receipt_text);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_Receipt_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_Receipt_text: " + e.getMessage());
		}
		try {
			if (WeighbridgeNetWeight.matches("^[0-9]{0,15}$")) {
				web_bridge.sendKeys(WeighbridgeNetWeight);
			} else {
				System.out.println("Invalid WeighbridgeNetWeight. Please enter exactly 19 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript web_bridge click...");
			js.executeScript("arguments[0].value='" + WeighbridgeNetWeight + "';", web_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("web_bridge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for web_bridge: " + e.getMessage());
		}
		try {
			if (EstimatedValueAtDeposit.matches("^[0-9]{0,15}$")) {
				Estimated.sendKeys(EstimatedValueAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Estimated click...");
			js.executeScript("arguments[0].value='" + EstimatedValueAtDeposit + "';", Estimated);
		} catch (NoSuchElementException e) {
			System.out.println("Estimated not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Estimated: " + e.getMessage());
		}
		try {
			if (MoistureAtDeposit.matches("^[0-9]{0,18}$")) {
				Moisture.sendKeys(MoistureAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Moisture click...");
			js.executeScript("arguments[0].value='" + MoistureAtDeposit + "';", Moisture);
		} catch (NoSuchElementException e) {
			System.out.println("Moisture not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Moisture: " + e.getMessage());
		}
		try {
			if (Rate_of_Storage_Charges.matches("^[0-9]{0,15}$")) {
				Rate_of_Storage.sendKeys(Rate_of_Storage_Charges);
			} else {
				System.out.println("Invalid Rate_of_Storage_Charges. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Rate_of_Storage click...");
			js.executeScript("arguments[0].value='" + Rate_of_Storage_Charges + "';", Rate_of_Storage);
		} catch (NoSuchElementException e) {
			System.out.println("Rate_of_Storage not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Rate_of_Storage: " + e.getMessage());
		}
		try {
			if (Per_UOM.matches("^[a-zA-Z0-9]{0,40}$")) {
				Per_UOM_Text.sendKeys(Per_UOM);
			} else {
				System.out.println("Invalid Per_UOM. Please enter exactly 40 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Per_UOM_Text click...");
			js.executeScript("arguments[0].value='" + Per_UOM + "';", Per_UOM_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Per_UOM_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Per_UOM_Text: " + e.getMessage());
		}
		try {
			Lot.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Lot click...");
			js.executeScript("arguments[0].click();", Lot);
		} catch (NoSuchElementException e) {
			System.out.println("Lot not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot: " + e.getMessage());
		}
		try {
			if (Godown_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				Godown.sendKeys(Godown_No);
			} else {
				System.out.println("Invalid Godown_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Godown click...");
			js.executeScript("arguments[0].value='" + Godown_No + "';", Godown);
		} catch (NoSuchElementException e) {
			System.out.println("Godown not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Godown: " + e.getMessage());
		}
		try {
			if (Stack_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				Stack_No_Text.sendKeys(Stack_No);
			} else {
				System.out.println("Invalid Stack_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Stack_No_Text click...");
			js.executeScript("arguments[0].value='" + Stack_No + "';", Stack_No_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Stack_No_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Stack_No_Text: " + e.getMessage());
		}
		try {
			if (Lot_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				lot_no_Text.sendKeys(Lot_No);
			} else {
				System.out.println("Invalid Lot_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript lot_no_Text click...");
			js.executeScript("arguments[0].value='" + Lot_No + "';", lot_no_Text);
		} catch (NoSuchElementException e) {
			System.out.println("lot_no_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for lot_no_Text: " + e.getMessage());
		}
		try {
			if (RP_Deposite_Request_Agriculture_Maker.bags.matches("^[0-9]{0,5}$")) {
				no_of_bag.sendKeys(RP_Deposite_Request_Agriculture_Maker.bags);
			} else {
				System.out.println("Invalid bags. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bag click...");
			js.executeScript("arguments[0].value='" + RP_Deposite_Request_Agriculture_Maker.bags + "';", no_of_bag);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bag not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bag: " + e.getMessage());
		}

		try {
			if (Sample.matches("^[a-zA-Z0-9]{0,50}$")) {
				sample_Id.sendKeys(String.valueOf(Sample));
			} else {
				System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript sample_Id click...");
			js.executeScript("arguments[0].value='" + Sample + "';", sample_Id);
		} catch (NoSuchElementException e) {
			System.out.println("sample_Id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for sample_Id: " + e.getMessage());
		}
		try {
			Verification_page.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_page click...");
			js.executeScript("arguments[0].click();", Verification_page);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_page: " + e.getMessage());
		}
		try {
			Depositor_Detail.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail click...");
			js.executeScript("arguments[0].click();", Depositor_Detail);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail: " + e.getMessage());
		}
		try {
			if (PanCard_No.matches("^[a-zA-Z0-9]{0,10}$")) {
				PAN_No.click();
				PAN_No.sendKeys(PanCard_No);
			} else {
				System.out.println("Invalid PanCard_No. Please enter exactly 10 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript PAN_No click...");
			js.executeScript("arguments[0].click();", PAN_No);
			js.executeScript("arguments[0].value='" + PanCard_No + "';", PAN_No);
		} catch (NoSuchElementException e) {
			System.out.println("PAN_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for PAN_No: " + e.getMessage());
		}
		try {
			if (DepositerName.matches("^[a-zA-Z0-9]{0,15}$")) {
				Depositer.click();
				Depositer.sendKeys(DepositerName);
			} else {
				System.out.println("Invalid DepositerName. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositer click...");
			js.executeScript("arguments[0].click();", Depositer);
			js.executeScript("arguments[0].value='" + DepositerName + "';", Depositer);
		} catch (NoSuchElementException e) {
			System.out.println("Depositer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositer: " + e.getMessage());
		}
		try {
			if (L1.matches("^[a-zA-Z0-9]{0,33}$")) {
				Line_No_1.click();
				Line_No_1.sendKeys(L1);
			} else {
				System.out.println("Invalid L1. Please enter exactly 33 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Line_No_1 click...");
			js.executeScript("arguments[0].click();", Line_No_1);
			js.executeScript("arguments[0].value='" + L1 + "';", Line_No_1);
		} catch (NoSuchElementException e) {
			System.out.println("Line_No_1 not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Line_No_1: " + e.getMessage());
		}
		try {
			if (L2.matches("^[a-zA-Z0-9]{0,33}$")) {
				Line_No_2.click();
				Line_No_2.sendKeys(L2);
			} else {
				System.out.println("Invalid L2. Please enter exactly 33 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Line_No_2 click...");
			js.executeScript("arguments[0].click();", Line_No_2);
			js.executeScript("arguments[0].value='" + L2 + "';", Line_No_2);
		} catch (NoSuchElementException e) {
			System.out.println("Line_No_2 not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Line_No_2: " + e.getMessage());
		}
		try {
			if (L3.matches("^[a-zA-Z0-9]{0,33}$")) {
				Line_No_3.click();
				Line_No_3.sendKeys(L3);
			} else {
				System.out.println("Invalid L3. Please enter exactly 33 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Line_No_3 click...");
			js.executeScript("arguments[0].click();", Line_No_3);
			js.executeScript("arguments[0].value='" + L3 + "';", Line_No_3);
		} catch (NoSuchElementException e) {
			System.out.println("Line_No_3 not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Line_No_3: " + e.getMessage());
		}
		try {
			if (City_Name.matches("^[a-zA-Z0-9]{0,33}$")) {
				City.sendKeys(City_Name);
			} else {
				System.out.println("Invalid City_Name. Please enter exactly 33 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript City click...");
			js.executeScript("arguments[0].value='" + City_Name + "';", City);
		} catch (NoSuchElementException e) {
			System.out.println("City not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for City: " + e.getMessage());
		}
		try {
			if (PinCode.matches("^[0-9]{0,6}$")) {
				PinCode_Text.sendKeys(PinCode);
				PinCode_Text.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid PinCode. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Line_No_3 click...");
			js.executeScript("arguments[0].click();", PinCode_Text);
			js.executeScript("arguments[0].value='" + PinCode + "';", PinCode_Text);
		} catch (NoSuchElementException e) {
			System.out.println("PinCode_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for PinCode_Text: " + e.getMessage());
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
		System.out.println("--------------------WareHouse Maker is Done-------------------------");

	}

	public void General_Physical_Deposit_Maker_Multiple_GSL() throws InterruptedException {
		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Id from deposit_txn where DRN like ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + RP_Deposite_Request_Agriculture_Maker.Deposite + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Internal_Ref = rs1.getString("Id");
				System.out.println("Internal_Ref print: " + Internal_Ref);
			}

			String query_OTP = "SELECT a.auth_code " + "FROM auth_code_generation a "
					+ "JOIN deposit_txn d ON a.ref_id = d.Id " + "WHERE d.DRN LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + RP_Deposite_Request_Agriculture_Maker.Deposite + "%"); // bind the variable to query

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_Deposite click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_Deposite not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_Deposite: " + e.getMessage());
		}
		try {
			
			Wait.until(ExpectedConditions.elementToBeClickable(Records_Not_Found_popup)).click();;
		}catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying  Records_Not_Found_popup click...");
			js.executeScript("arguments[0].click();", Records_Not_Found_popup);
		} catch (NoSuchElementException e) {
			System.out.println("Records_Not_Found_popup not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Records_Not_Found_popup: " + e.getMessage());
		}
		
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_New_Req)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_New_Req click...");
			js.executeScript("arguments[0].click();", Physical_New_Req);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_New_Req not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_New_Req: " + e.getMessage());
		}
		try {
			if (Internal_Ref.matches("^[0-9]{5}$")) {
				Internal_Ref_No.sendKeys(String.valueOf(Internal_Ref));
				Internal_Ref_No.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Internal_Ref. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Internal_Ref_No click...");
			js.executeScript("arguments[0].value='" + Internal_Ref + "';", Internal_Ref_No);
			js.executeScript("arguments[0].click();", Internal_Ref_No);
		} catch (NoSuchElementException e) {
			System.out.println("Internal_Ref_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Internal_Ref_No: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			if (OTP_Auth.matches("^[0-9]{6}$")) {
				Auth_Code.sendKeys(String.valueOf(OTP_Auth));
			} else {
				System.out.println("Invalid OTP_Auth. Please enter exactly 6 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Auth_Code click...");
			js.executeScript("arguments[0].value='" + OTP_Auth + "';", Auth_Code);
			js.executeScript("arguments[0].click();", Auth_Code);
		} catch (NoSuchElementException e) {
			System.out.println("Deposite_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposite_No: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Wait.until(ExpectedConditions.elementToBeClickable(Submit_btn)).click();

		try {
			Accept_check.isSelected();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", Accept_check);
		} catch (NoSuchElementException e) {
			System.out.println("Accept_check not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Accept_check: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(submit_btn)).click();

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Tare_Weight)).sendKeys("200");
		} catch (Exception e) {
			System.out.println(" Tare_Weight Element not found");
		}
		// Wait.until(ExpectedConditions.elementToBeClickable(assaying_type_Text)).sendKeys(assaying_type);
		try {
			Select Sa = new Select(assaying_type_Text);
			Sa.selectByContainsVisibleText(assaying_type);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(assaying_type_Text)).sendKeys(assaying_type);
		} catch (NoSuchElementException e) {
			System.out.println("assaying_type_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for assaying_type_Text: " + e.getMessage());
		}
		try {
			if (Weight_bridge.matches("^[a-zA-Z0-9]{0,100}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_text)).sendKeys(Weight_bridge);
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 15 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_text)).sendKeys(Weight_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_text: " + e.getMessage());
		}
		try {
			if (Weight_bridge_Receipt.matches("^[a-zA-Z0-9]{0,50}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_Receipt_text))
						.sendKeys(Weight_bridge_Receipt);
				// int Quantity = Notional_Quantity.getText();
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 50 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Weight_bridge_Receipt + "';", Weight_bridge_Receipt_text);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_Receipt_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_Receipt_text: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			if (WeighbridgeNetWeight.matches("^[0-9]{0,15}$")) {

				String numStr = String.valueOf(WeighbridgeNetWeight);

				for (char ch : numStr.toCharArray()) {
					Wait.until(ExpectedConditions.elementToBeClickable(web_bridge)).sendKeys(String.valueOf(ch));
					Thread.sleep(200); // optional delay to mimic human typig
				}
			}
			/*
			 * Wait.until(ExpectedConditions.elementToBeClickable(web_bridge)).sendKeys(
			 * WeighbridgeNetWeight); Thread.sleep(2000); web_bridge.clear();
			 * Thread.sleep(3000);
			 * Wait.until(ExpectedConditions.elementToBeClickable(web_bridge)).sendKeys(
			 * WeighbridgeNetWeight); } else { System.out.
			 * println("Invalid WeighbridgeNetWeight. Please enter exactly 19 digits (numbers only):"
			 * ); }
			 */
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + WeighbridgeNetWeight + "';", web_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("web_bridge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for web_bridge: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			if (EstimatedValueAtDeposit.matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Estimated)).sendKeys(EstimatedValueAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + EstimatedValueAtDeposit + "';", Estimated);
		} catch (NoSuchElementException e) {
			System.out.println("Estimated not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Estimated: " + e.getMessage());
		}
		try {
			if (MoistureAtDeposit.matches("^[0-9]{0,18}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Moisture)).sendKeys(MoistureAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + MoistureAtDeposit + "';", Moisture);
		} catch (NoSuchElementException e) {
			System.out.println("Moisture not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Moisture: " + e.getMessage());
		}
		try {
			if (Rate_of_Storage_Charges.matches("^[0-9]{0,15}$")) {
				Rate_of_Storage.sendKeys(Rate_of_Storage_Charges);
			} else {
				System.out.println("Invalid Rate_of_Storage_Charges. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Rate_of_Storage_Charges + "';", Rate_of_Storage);
		} catch (NoSuchElementException e) {
			System.out.println("Rate_of_Storage not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Rate_of_Storage: " + e.getMessage());
		}
		try {
			if (Per_UOM.matches("^[a-zA-Z0-9]{0,40}$")) {
				Per_UOM_Text.sendKeys(Per_UOM);
			} else {
				System.out.println("Invalid Per_UOM. Please enter exactly 40 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Per_UOM + "';", Rate_of_Storage);
		} catch (NoSuchElementException e) {
			System.out.println("Per_UOM_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Per_UOM_Text: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Lot)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Lot click...");
			js.executeScript("arguments[0].click();", Lot);
		} catch (NoSuchElementException e) {
			System.out.println("Lot not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot : " + e.getMessage());
		}
		// js.executeScript("arguments[0].scrollIntoView()", Add_Button);
		WebElement remainingBagsElement = driver
				.findElement(By.xpath("//div[@class='row ng-scope']//div[@class='col-sm-2']")); // Adjust ID
		int remainingBags = Integer.parseInt(remainingBagsElement.getText());
		System.out.println("remainingBags is :" + remainingBags);
		int noOfBags = Integer.parseInt(Bag_Total);
		System.out.println("noOfBags is :" + noOfBags);
		try {
			if (remainingBags != noOfBags) {
				for (int i = 1; i <= remainingBags; i++) {
					System.out.println("remainingBags is for:" + remainingBags);
					driver.findElement(By.xpath("(//input[@name='godown'])[" + i + "]")).sendKeys("Godown " + i);

					WebElement stack_no = driver.findElement(By.xpath("(//input[@name='stack_no'])[" + i + "]"));
					Wait.until(ExpectedConditions.elementToBeClickable(stack_no)).sendKeys("stack_no" + i);

					WebElement lot_no = driver.findElement(By.xpath("(//input[@name='lot_no'])[" + i + "]"));
					Wait.until(ExpectedConditions.elementToBeClickable(lot_no)).sendKeys("Lot " + i);

					/*
					 * try { if (Number_Of_Bags_PopUp.isDisplayed()) {
					 * Wait.until(ExpectedConditions.elementToBeClickable(Number_Of_Bags_PopUp)).
					 * click(); } } catch (NoSuchElementException e) {
					 * System.out.println(" Number_Of_Bags_PopUp Element is not visible");
					 * 
					 * } catch (Exception e) {
					 * System.out.println(" Number_Of_Bags_PopUp Element not found"); }
					 */
					int k = j * i;
					WebElement NO_Bag = driver.findElement(By.xpath("(//input[@name='no_of_bag'])[" + k + "]"));
					NO_Bag.sendKeys(String.valueOf(Bags));
					NO_Bag.clear();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					NO_Bag.sendKeys(String.valueOf(Bags));

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
					Wait.until(ExpectedConditions.elementToBeClickable(sample_Id)).sendKeys(Keys.TAB);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

					WebElement sample_Id = driver.findElement(By.xpath("(//input[@name='sample_Id'])[" + i + "]"));
					Wait.until(ExpectedConditions.elementToBeClickable(sample_Id))
							.sendKeys(RP_Deposite_Request_Agriculture_Maker.Deposite + i);
					/*
					 * // Wait for Quantity field to auto-fill by backend WebElement quantityField =
					 * driver.findElement(By.xpath("//input[@name='QTY']"));
					 * 
					 * // Wait until quantity field has a non-empty value
					 * Wait.until(ExpectedConditions.attributeToBeNotEmpty(quantityField, "value"));
					 * 
					 * // Fetch the auto-filled value String autoFilledQuantity =
					 * quantityField.getAttribute("value");
					 * System.out.println("Auto-filled Quantity is: " + autoFilledQuantity);
					 */

					try {
						if (Number_Of_Bags_PopUp.isDisplayed()) {
							Wait.until(ExpectedConditions.elementToBeClickable(Number_Of_Bags_PopUp)).click();
						}
					} catch (NoSuchElementException e) {
						System.out.println(" Number_Of_Bags_PopUp Element is not visible");

					} catch (Exception e) {
						System.out.println(" Number_Of_Bags_PopUp Element not found");
					}

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					if (i < remainingBags) {
						try {
							if (Add_Button.isDisplayed() && Add_Button.isEnabled()) {
								try {
									if (Add_Button.isDisplayed()) {
										Add_Button.click();
										Wait.until(ExpectedConditions.elementToBeClickable(Lots_Confirmation)).click();
										Add_Button.click();
									}
								} catch (ElementClickInterceptedException e) {
									System.out.println(
											"Normal click failed, trying JavaScript Add_Button_before click...");
									js.executeScript("arguments[0].click();", Add_Button);
								} catch (NoSuchElementException e) {
									System.out.println("Add_Button_before not found: " + e.getMessage());
								} catch (Exception e) {
									System.out.println("Unexpected error for Add_Button_before: " + e.getMessage());
								}
								try {
									if (Lots_Confirmation.isDisplayed()) {
										Wait.until(ExpectedConditions.elementToBeClickable(Lots_Confirmation)).click();
									}
								} catch (NoSuchElementException e) {
									System.out.println("Lots_Confirmation is not visible");
								} catch (Exception e) {
									System.out.println("Lots_Confirmation not found error");
								}
								Add_Button.click();
							}

						} catch (ElementClickInterceptedException e) {
							System.out.println("Normal click failed, trying JavaScript Lots_Confirmation click...");
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
									Verification_page);
							Wait.until(ExpectedConditions.elementToBeClickable(Verification_page)).click();

						} catch (NoSuchElementException e) {
							System.out.println("Element not found: " + e.getMessage());
						} catch (Exception e) {
							System.out.println("Unexpected error: " + e.getMessage());
						}
						if (Add_Button.isDisplayed() && !Add_Button.isEnabled()) {
							System.out.println("Add button is not ready.");
							break;
						}
					}
					if (Add_Button.isDisplayed() && !Add_Button.isEnabled()) {
						System.out.println("Add button is not ready.");
						break;
					}
				}
				remainingBagsElement.getText();
			} else {
				System.out.println("loop is not working");
			}
		} catch (Exception e) {
			System.out.println("Unexpected error for loop: " + e.getMessage());
		}

		try {
			if (Verification_page.isDisplayed()) {
				js.executeScript("arguments[0].scrollIntoView()", Verification_page);
				Wait.until(ExpectedConditions.elementToBeClickable(Verification_page)).sendKeys(Keys.ENTER);
				// Verification_page.click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verify_btn click...");
			js.executeScript("arguments[0].click();", Verification_page);

		} catch (NoSuchElementException e) {
			System.out.println("Verification_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_page: " + e.getMessage());
		}
		Depositor_Detail.sendKeys(Keys.ENTER);
		if (PanCard_No.matches("^[a-zA-Z0-9]{0,10}$")) {
			PAN_No.click();
			PAN_No.sendKeys(PanCard_No);
		} else {
			System.out.println("Invalid PanCard_No. Please enter exactly 10 digits (numbers only):");

		}
		if (DepositerName.matches("^[a-zA-Z0-9]{0,15}$")) {
			Depositer.click();
			Depositer.sendKeys(DepositerName);
			// Depositer.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid DepositerName. Please enter exactly 15 digits (numbers only):");

		}
		if (L1.matches("^[a-zA-Z0-9]{0,33}$")) {
			Line_No_1.click();
			Line_No_1.sendKeys(L1);
		} else {
			System.out.println("Invalid L1. Please enter exactly 33 digits (numbers only):");

		}
		if (L2.matches("^[a-zA-Z0-9]{0,33}$")) {
			Line_No_2.click();
			Line_No_2.sendKeys(L2);
		} else {
			System.out.println("Invalid L2. Please enter exactly 33 digits (numbers only):");

		}
		if (L3.matches("^[a-zA-Z0-9]{0,33}$")) {
			Line_No_3.click();
			Line_No_3.sendKeys(L3);
		} else {
			System.out.println("Invalid L3. Please enter exactly 33 digits (numbers only):");

		}
		if (City_Name.matches("^[a-zA-Z0-9]{0,33}$")) {
			City.sendKeys(City_Name);
		} else {
			System.out.println("Invalid City_Name. Please enter exactly 15 digits (numbers only):");

		}
		if (PinCode.matches("^[0-9]{0,6}$")) {
			PinCode_Text.sendKeys(PinCode);
			PinCode_Text.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid PinCode. Please enter exactly 15 digits (numbers only):");

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

		System.out.println("--------------------General_Multiple_GSL Maker is Done-------------------------");

	}

	public void Exchange_Deposite_Transaction() throws InterruptedException {
		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Id from deposit_txn where DRN like ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Internal_Ref = rs1.getString("Id");
				System.out.println("Internal_Ref print: " + Internal_Ref);
			}

			String query_OTP = "SELECT a.auth_code " + "FROM auth_code_generation a "
					+ "JOIN deposit_txn d ON a.ref_id = d.Id " + "WHERE d.DRN LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "%"); // bind the variable to
																							// query

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_Deposite click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_Deposite not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_Deposite: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_New_Req)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_New_Req click...");
			js.executeScript("arguments[0].click();", Physical_New_Req);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_New_Req not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_New_Req: " + e.getMessage());
		}
		try {
			if (Internal_Ref.matches("^[0-9]{5}$")) {
				Internal_Ref_No.sendKeys(Internal_Ref);
				Internal_Ref_No.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Internal_Ref. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Internal_Ref_No click...");
			js.executeScript("arguments[0].value='" + Internal_Ref + "';", Internal_Ref_No);
			js.executeScript("arguments[0].click();", Internal_Ref_No);
		} catch (NoSuchElementException e) {
			System.out.println("Internal_Ref_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Internal_Ref_No: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			if (OTP_Auth.matches("^[0-9]{6}$")) {
				Auth_Code.sendKeys(OTP_Auth);
			} else {
				System.out.println("Invalid OTP_Auth. Please enter exactly 6 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Auth_Code click...");
			js.executeScript("arguments[0].value='" + OTP_Auth + "';", Auth_Code);
			js.executeScript("arguments[0].click();", Auth_Code);
		} catch (NoSuchElementException e) {
			System.out.println("Deposite_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposite_No: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Submit_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", Submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Submit_btn: " + e.getMessage());
		}
		try {
			Accept_check.isSelected();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", Accept_check);
		} catch (NoSuchElementException e) {
			System.out.println("Accept_check not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Accept_check: " + e.getMessage());
		}
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		/*
		 * Wait.until(ExpectedConditions.elementToBeClickable(Bag)).click();
		 * Wait.until(ExpectedConditions.elementToBeClickable(Bag)).clear();
		 * Wait.until(ExpectedConditions.elementToBeClickable(Bag)).sendKeys("10");
		 */
		// Wait.until(ExpectedConditions.elementToBeClickable(Altert)).click();
		Thread.sleep(2000);
		try {
			Variety_Code_bttn.click();
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Variety_Code);
			// Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Variety_Code_Text.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_bttn)).click();
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Variety_Code);
			Thread.sleep(2000);
			Variety_Code_Text.click();
		} catch (NoSuchElementException e) {
			System.out.println("Variety_Code_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Variety_Code_Text: " + e.getMessage());
		}

		// assaying_type_Text.sendKeys(assaying_type);
		try {
			Select Sa = new Select(assaying_type_Text);
			Sa.selectByContainsVisibleText(assaying_type);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(assaying_type_Text)).sendKeys(assaying_type);
		} catch (NoSuchElementException e) {
			System.out.println("assaying_type_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for assaying_type_Text: " + e.getMessage());
		}

		if (Weight_bridge.matches("^[a-zA-Z0-9]{0,100}$")) {
			Weight_bridge_text.sendKeys(Weight_bridge);
		} else {
			System.out.println("Invalid Weight_bridge. Please enter exactly 15 alphanumeric characters:");

		}
		if (Weight_bridge_Receipt.matches("^[a-zA-Z0-9]{0,50}$")) {
			Weight_bridge_Receipt_text.sendKeys(Weight_bridge_Receipt);
			// int Quantity = Notional_Quantity.getText();
		} else {
			System.out.println("Invalid Weight_bridge. Please enter exactly 50 alphanumeric characters:");

		}

		if (WeighbridgeNetWeight.matches("^[0-9]{0,19}$")) {
			String numStr = String.valueOf(WeighbridgeNetWeight);

			for (char ch : numStr.toCharArray()) {
				Wait.until(ExpectedConditions.elementToBeClickable(web_bridge)).sendKeys(String.valueOf(ch));
				Thread.sleep(200); // optional delay to mimic human typig
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		if (EstimatedValueAtDeposit.matches("^[0-9]{0,15}$")) {
			Estimated.sendKeys(EstimatedValueAtDeposit);
		} else {
			System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 15 digits (numbers only):");

		}
		if (MoistureAtDeposit.matches("^[0-9]{0,18}$")) {
			Moisture.sendKeys(MoistureAtDeposit);
		} else {
			System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 18 digits (numbers only):");

		}
		if (Rate_of_Storage_Charges.matches("^[0-9]{0,15}$")) {
			Rate_of_Storage.sendKeys(Rate_of_Storage_Charges);
		} else {
			System.out.println("Invalid Rate_of_Storage_Charges. Please enter exactly 18 digits (numbers only):");

		}
		if (Per_UOM.matches("^[a-zA-Z0-9]{0,40}$")) {
			Per_UOM_Text.sendKeys(Per_UOM);
		} else {
			System.out.println("Invalid Per_UOM. Please enter exactly 40 digits (numbers only):");

		}

		Lot.click();
		String total_bag = String.valueOf(no_of_bag.getText());
		System.out.println("total number of bags" + total_bag);
		String Remaining_No = String.valueOf(Remaining_No_Of_Bags.getText());
		System.out.println("Remaining_No number of bags" + Remaining_No);
		if (total_bag == Remaining_No) {
			System.out.println("its both are not same ");
		}

		if (Godown_No.matches("^[a-zA-Z0-9]{0,15}$")) {
			Godown.sendKeys(Godown_No);
		} else {
			System.out.println("Invalid Godown_No. Please enter exactly 15 digits (numbers only):");

		}
		if (Stack_No.matches("^[a-zA-Z0-9]{0,15}$")) {
			Stack_No_Text.sendKeys(Stack_No);
		} else {
			System.out.println("Invalid Stack_No. Please enter exactly 15 digits (numbers only):");

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if (Lot_No.matches("^[a-zA-Z0-9]{0,15}$")) {
			lot_no_Text.sendKeys(Lot_No);
		} else {
			System.out.println("Invalid Lot_No. Please enter exactly 15 digits (numbers only):");

		}
		if (RP_Exchange_Deposite_Agriculture_Maker.bags.matches("^[0-9]{0,5}$")) {
			no_of_bag.sendKeys(RP_Exchange_Deposite_Agriculture_Maker.bags);
		} else {
			System.out.println("Invalid bags. Please enter exactly 5 digits (numbers only):");

		}

		if (Sample.matches("^[a-zA-Z0-9]{0,50}$")) {
			sample_Id.sendKeys(String.valueOf(Sample));
		} else {
			System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");

		}
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		 * Wait.until(ExpectedConditions.elementToBeClickable(Lots_Confirmation)).click(
		 * );
		 *
		 * Wait.until(ExpectedConditions.elementToBeClickable(Add_Button)).sendKeys(Keys
		 * .ENTER);
		 *
		 * Godown_Second.sendKeys("B"); Stack_No_Second.sendKeys("B");
		 * lot_no_Second.sendKeys("B"); no_of_bag_Second.sendKeys("100");
		 *
		 * String SampleID = Sample + 1;
		 *
		 * sample_Id_Second.sendKeys(String.valueOf(SampleID));
		 *
		 */
		Verification_page.sendKeys(Keys.ENTER);

		Depositor_Detail.sendKeys(Keys.ENTER);
		if (PanCard_No.matches("^[a-zA-Z0-9]{0,10}$")) {
			PAN_No.click();
			PAN_No.sendKeys(PanCard_No);
			PAN_No.sendKeys(Keys.TAB);
		} else {
			System.out.println("Invalid PanCard_No. Please enter exactly 10 digits (numbers only):");

		}
		/*
		 * Wait = new WebDriverWait(driver, Duration.ofSeconds(10)); if
		 * (L1.matches("^[a-zA-Z0-9]{0,33}$")) { Line_No_1.click();
		 * Line_No_1.sendKeys(L1); } else { System.out.
		 * println("Invalid L1. Please enter exactly 33 digits (numbers only):");
		 *
		 * } if (L2.matches("^[a-zA-Z0-9]{0,33}$")) { Line_No_2.click();
		 * Line_No_2.sendKeys(L2); } else { System.out.
		 * println("Invalid L2. Please enter exactly 33 digits (numbers only):");
		 *
		 * } if (L3.matches("^[a-zA-Z0-9]{0,33}$")) { Line_No_3.click();
		 * Line_No_3.sendKeys(L3); } else { System.out.
		 * println("Invalid L3. Please enter exactly 33 digits (numbers only):");
		 *
		 * } if (City_Name.matches("^[a-zA-Z0-9]{0,33}$")) { City.sendKeys(City_Name); }
		 * else { System.out.
		 * println("Invalid City_Name. Please enter exactly 33 digits (numbers only):");
		 *
		 * } if (PinCode.matches("^[0-9]{0,11}$")) { PinCode_Text.sendKeys(PinCode);
		 * PinCode_Text.sendKeys(Keys.ENTER); PinCode_Text.sendKeys(Keys.ENTER); } else
		 * { System.out.
		 * println("Invalid PinCode. Please enter exactly 11 digits (numbers only):");
		 *
		 * } // State.click(); //
		 * Wait.until(ExpectedConditions.textToBePresentInElementValue(State, //
		 * "Maharashtra"));
		 *
		 *
		 * Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Pop_Up)).
		 * click();
		 *
		 * General_Manue.click();
		 *
		 * if(Variety_Code.isDisplayed()) { ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].click();", Variety_Code);
		 * //Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code)).click();
		 * Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).
		 * sendKeys("999-Cotton Bales");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * System.out.println("coming form last page Variety_Code Is  clicking"); }else
		 * { System.out.println("Variety_Code After Address Is not clicking"); }
		 */

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
		System.out.println("-------------------- Exchange_Deposite WareHouse Maker is Done-------------------------");

	}

	public void Exchange_Deposite_Transaction_Multiple_GSL() throws InterruptedException {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Id from deposit_txn where DRN like ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Internal_Ref = rs1.getString("Id");
				System.out.println("Internal_Ref print: " + Internal_Ref);
			}
			String query_OTP = "SELECT a.auth_code " + "FROM auth_code_generation a "
					+ "JOIN deposit_txn d ON a.ref_id = d.Id " + "WHERE d.DRN LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + RP_Exchange_Deposite_Agriculture_Maker.Deposite + "%"); // bind the variable

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);
				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_Deposite click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_Deposite not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_Deposite: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_New_Req)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_New_Req click...");
			js.executeScript("arguments[0].click();", Physical_New_Req);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_New_Req not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_New_Req: " + e.getMessage());
		}
		try {
			if (Internal_Ref.matches("^[0-9]{5}$")) {
				Internal_Ref_No.sendKeys(String.valueOf(Internal_Ref));
				Internal_Ref_No.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid Internal_Ref. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Internal_Ref_No click...");
			js.executeScript("arguments[0].value='" + Internal_Ref + "';", Internal_Ref_No);
			js.executeScript("arguments[0].click();", Internal_Ref_No);
		} catch (NoSuchElementException e) {
			System.out.println("Internal_Ref_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Internal_Ref_No: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			if (OTP_Auth.matches("^[0-9]{6}$")) {
				Auth_Code.sendKeys(String.valueOf(OTP_Auth));
			} else {
				System.out.println("Invalid OTP_Auth. Please enter exactly 6 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Auth_Code click...");
			js.executeScript("arguments[0].value='" + OTP_Auth + "';", Auth_Code);
			js.executeScript("arguments[0].click();", Auth_Code);
		} catch (NoSuchElementException e) {
			System.out.println("Deposite_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposite_No: " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Submit_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", Submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Submit_btn: " + e.getMessage());
		}
		try {
			Accept_check.isSelected();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", Accept_check);
		} catch (NoSuchElementException e) {
			System.out.println("Accept_check not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Accept_check: " + e.getMessage());
		}
		Thread.sleep(4000);
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Submit_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}

		/*
		 * Wait.until(ExpectedConditions.elementToBeClickable(Bag)).click();
		 * Wait.until(ExpectedConditions.elementToBeClickable(Bag)).clear();
		 * Wait.until(ExpectedConditions.elementToBeClickable(Bag)).sendKeys("10");
		 */
		// Wait.until(ExpectedConditions.elementToBeClickable(Altert)).click();

		Thread.sleep(5000);
		try {
			Variety_Code_bttn.click();
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Variety_Code);
			// Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Variety_Code_Text.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_bttn)).click();
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Variety_Code);
			Thread.sleep(2000);
			Variety_Code_Text.click();
		} catch (NoSuchElementException e) {
			System.out.println("Variety_Code_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Variety_Code_Text: " + e.getMessage());
		}

		// assaying_type_Text.sendKeys(assaying_type);
		try {
			Select Sa = new Select(assaying_type_Text);
			Sa.selectByContainsVisibleText(assaying_type);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(assaying_type_Text)).sendKeys(assaying_type);
		} catch (NoSuchElementException e) {
			System.out.println("assaying_type_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for assaying_type_Text: " + e.getMessage());
		}
		try {
			if (Weight_bridge.matches("^[a-zA-Z0-9]{0,100}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_text)).sendKeys(Weight_bridge);
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 15 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_text)).sendKeys(Weight_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_text: " + e.getMessage());
		}
		try {
			if (Weight_bridge_Receipt.matches("^[a-zA-Z0-9]{0,50}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_Receipt_text))
						.sendKeys(Weight_bridge_Receipt);
				// int Quantity = Notional_Quantity.getText();
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 50 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Weight_bridge_Receipt + "';", Weight_bridge_Receipt_text);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_Receipt_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_Receipt_text: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			if (WeighbridgeNetWeight.matches("^[0-9]{0,19}$")) {

				String numStr = String.valueOf(WeighbridgeNetWeight);

				for (char ch : numStr.toCharArray()) {
					Wait.until(ExpectedConditions.elementToBeClickable(web_bridge)).sendKeys(String.valueOf(ch));
					Thread.sleep(200); // optional delay to mimic human typig
				}

			}
			/*
			 * Wait.until(ExpectedConditions.elementToBeClickable(web_bridge)).sendKeys(
			 * WeighbridgeNetWeight);
			 * 
			 * web_bridge.clear(); Thread.sleep(3000);
			 * Wait.until(ExpectedConditions.elementToBeClickable(web_bridge)).sendKeys(
			 * WeighbridgeNetWeight); } else { System.out.
			 * println("Invalid WeighbridgeNetWeight. Please enter exactly 19 digits (numbers only):"
			 * ); }
			 */
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + WeighbridgeNetWeight + "';", web_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("web_bridge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for web_bridge: " + e.getMessage());
		}
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		try {
			if (EstimatedValueAtDeposit.matches("^[0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Estimated)).sendKeys(EstimatedValueAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + EstimatedValueAtDeposit + "';", Estimated);
		} catch (NoSuchElementException e) {
			System.out.println("Estimated not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Estimated: " + e.getMessage());
		}
		try {
			if (MoistureAtDeposit.matches("^[0-9]{0,18}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Moisture)).sendKeys(MoistureAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + MoistureAtDeposit + "';", Moisture);
		} catch (NoSuchElementException e) {
			System.out.println("Moisture not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Moisture: " + e.getMessage());
		}
		try {
			if (Rate_of_Storage_Charges.matches("^[0-9]{0,15}$")) {
				Rate_of_Storage.sendKeys(Rate_of_Storage_Charges);
			} else {
				System.out.println("Invalid Rate_of_Storage_Charges. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Rate_of_Storage_Charges + "';", Rate_of_Storage);
		} catch (NoSuchElementException e) {
			System.out.println("Rate_of_Storage not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Rate_of_Storage: " + e.getMessage());
		}
		try {
			if (Per_UOM.matches("^[a-zA-Z0-9]{0,40}$")) {
				Per_UOM_Text.sendKeys(Per_UOM);
			} else {
				System.out.println("Invalid Per_UOM. Please enter exactly 40 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Per_UOM + "';", Rate_of_Storage);
		} catch (NoSuchElementException e) {
			System.out.println("Per_UOM_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Per_UOM_Text: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Lot)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Lot click...");
			js.executeScript("arguments[0].click();", Lot);
		} catch (NoSuchElementException e) {
			System.out.println("Lot not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot : " + e.getMessage());
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Add_Button);
		WebElement remainingBagsElement = driver.findElement(By.xpath("(//div[@class='col-sm-2'])[7]")); // Adjust ID
		int remainingBags = Integer.parseInt(remainingBagsElement.getText());
		System.out.println("remainingBags is: " + remainingBags);
		int noOfBags = Integer.parseInt(Bag_Total);
		System.out.println("noOfBags is :" + noOfBags);
		if (remainingBags != noOfBags) {
			for (int i = 1; i <= remainingBags; i++) {
				System.out.println("remainingBags is for:" + remainingBags);

				driver.findElement(By.xpath("(//input[@name='godown'])[" + i + "]")).sendKeys("Godown " + i);

				WebElement stack_no = driver.findElement(By.xpath("(//input[@name='stack_no'])[" + i + "]"));
				Wait.until(ExpectedConditions.elementToBeClickable(stack_no)).sendKeys("stack_no" + i);

				WebElement lot_no = driver.findElement(By.xpath("(//input[@name='lot_no'])[" + i + "]"));
				Wait.until(ExpectedConditions.elementToBeClickable(lot_no)).sendKeys("Lot " + i);

				try {
					if (Number_Of_Bags_PopUp.isDisplayed()) {
						Wait.until(ExpectedConditions.elementToBeClickable(Number_Of_Bags_PopUp)).click();
					}
				} catch (NoSuchElementException e) {
					System.out.println(" Number_Of_Bags_PopUp Element is not visible");

				} catch (Exception e) {
					System.out.println(" Number_Of_Bags_PopUp Element not found");
				}
				int k = j * i;
				WebElement NO_Bag = driver.findElement(By.xpath("(//input[@name='no_of_bag'])[" + k + "]"));
				Wait.until(ExpectedConditions.elementToBeClickable(NO_Bag)).sendKeys(String.valueOf(Bags));
				/*
				 * Thread.sleep(2000); NO_Bag.clear(); NO_Bag.sendKeys(String.valueOf(Bags));
				 * 
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				 */
				Wait.until(ExpectedConditions.elementToBeClickable(sample_Id)).sendKeys(Keys.TAB);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				WebElement sample_Id = driver.findElement(By.xpath("(//input[@name='sample_Id'])[" + i + "]"));
				Wait.until(ExpectedConditions.elementToBeClickable(sample_Id))
						.sendKeys(RP_Exchange_Deposite_Agriculture_Maker.Deposite + i);
				/*
				 * // Wait for Quantity field to auto-fill by backend WebElement quantityField =
				 * driver.findElement(By.xpath("//input[@name='QTY']"));
				 * 
				 * // Wait until quantity field has a non-empty value
				 * Wait.until(ExpectedConditions.attributeToBeNotEmpty(quantityField, "value"));
				 * 
				 * // Fetch the auto-filled value String autoFilledQuantity =
				 * quantityField.getAttribute("value");
				 * System.out.println("Auto-filled Quantity is: " + autoFilledQuantity);
				 */
				try {
					if (Number_Of_Bags_PopUp.isDisplayed()) {
						Wait.until(ExpectedConditions.elementToBeClickable(Number_Of_Bags_PopUp)).click();
					}
				} catch (NoSuchElementException e) {
					System.out.println(" Number_Of_Bags_PopUp Element is not visible");

				} catch (Exception e) {
					System.out.println(" Number_Of_Bags_PopUp Element not found");
				}

				// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

				if (i < remainingBags) {
					try {
						if (Add_Button.isDisplayed() && Add_Button.isEnabled()) {
							try {
								if (Add_Button.isDisplayed()) {
									Wait.until(ExpectedConditions.elementToBeClickable(Add_Button)).click();

									try {
										Wait.until(ExpectedConditions.elementToBeClickable(Lots_Confirmation)).click();
									} catch (ElementClickInterceptedException e) {
										System.out.println(
												"Normal click failed, trying JavaScript Lots_Confirmation click...");
										js.executeScript("arguments[0].click();", Lots_Confirmation);
									} catch (NoSuchElementException e) {
										System.out.println("Lots_Confirmation not found: " + e.getMessage());
									} catch (Exception e) {
										System.out.println("Unexpected error for Lots_Confirmation: " + e.getMessage());
									}
									Wait.until(ExpectedConditions.elementToBeClickable(Add_Button)).click();

								}
							} catch (ElementClickInterceptedException e) {
								System.out.println("Normal click failed, trying JavaScript Add_Button click...");
								js.executeScript("arguments[0].click();", Add_Button);
							} catch (NoSuchElementException e) {
								System.out.println("Add_Button_before not found: " + e.getMessage());
							} catch (Exception e) {
								System.out.println("Unexpected error for Add_Button_before: " + e.getMessage());
							}
							try {
								if (Number_Of_Bags_PopUp.isDisplayed()) {

									Wait.until(ExpectedConditions.elementToBeClickable(Number_Of_Bags_PopUp)).click();
								}
							} catch (NoSuchElementException e) {
								System.out.println(" Number_Of_Bags_PopUp Element is not visible");

							} catch (Exception e) {
								System.out.println(" Number_Of_Bags_PopUp Element not found");
							}
							try {
								if (Lots_Confirmation.isDisplayed()) {
									Wait.until(ExpectedConditions.elementToBeClickable(Lots_Confirmation)).click();
								}
							} catch (NoSuchElementException e) {
								System.out.println("Lots_Confirmation is not visible");
							} catch (Exception e) {
								System.out.println("Lots_Confirmation not found error");
							}
							Add_Button.click();
						}

					} catch (ElementClickInterceptedException e) {
						System.out.println("Normal click failed, trying JavaScript Lots_Confirmation click...");
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								Verification_page);
						Verification_page.click();

					} catch (NoSuchElementException e) {
						System.out.println("Element not found: " + e.getMessage());
					} catch (Exception e) {
						System.out.println("Unexpected error: " + e.getMessage());
					}
					if (Add_Button.isDisplayed() && !Add_Button.isEnabled()) {
						System.out.println("Add button is not ready.");
						break;
					}
				}
				if (Add_Button.isDisplayed() && !Add_Button.isEnabled()) {
					System.out.println("Add button is not ready.");
					break;
				}
			}

		} else {
			System.out.println("loop is not working");
		}

		try {
			if (Verification_page.isDisplayed()) {
				js.executeScript("arguments[0].scrollIntoView()", Verification_page);
				// Wait.until(ExpectedConditions.elementToBeClickable(Verification_page)).sendKeys(Keys.ENTER);
				Verification_page.click();
				System.out.println("Verification_page button is visible");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", Verification_page);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		Depositor_Detail.sendKeys(Keys.ENTER);
		if (PanCard_No.matches("^[a-zA-Z0-9]{0,10}$")) {
			PAN_No.click();
			PAN_No.sendKeys(PanCard_No);
			PAN_No.sendKeys(Keys.TAB);
		} else {
			System.out.println("Invalid PanCard_No. Please enter exactly 10 digits (numbers only):");

		}

		Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (L1.matches("^[a-zA-Z0-9]{0,33}$")) {
			Line_No_1.click();
			Line_No_1.sendKeys(L1);
		} else {
			System.out.println("Invalid L1. Please enter exactly 15 digits (numbers only):");

		}
		if (L2.matches("^[a-zA-Z0-9]{0,33}$")) {
			Line_No_2.click();
			Line_No_2.sendKeys(L2);
		} else {
			System.out.println("Invalid L2. Please enter exactly 15 digits (numbers only):");

		}
		if (L3.matches("^[a-zA-Z0-9]{0,33}$")) {
			Line_No_3.click();
			Line_No_3.sendKeys(L3);
		} else {
			System.out.println("Invalid L3. Please enter exactly 15 digits (numbers only):");

		}
		if (City_Name.matches("^[a-zA-Z0-9]{0,33}$")) {
			City.sendKeys(City_Name);
		} else {
			System.out.println("Invalid City_Name. Please enter exactly 15 digits (numbers only):");

		}
		if (PinCode.matches("^[0-9]{0,11}$")) {
			PinCode_Text.sendKeys(PinCode);
			PinCode_Text.sendKeys(Keys.ENTER);
			PinCode_Text.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid PinCode. Please enter exactly 15 digits (numbers only):");

		}
		// State.click();
		// Wait.until(ExpectedConditions.textToBePresentInElementValue(State,
		// "Maharashtra"));
		/*
		 *
		 * Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Pop_Up)).
		 * click();
		 *
		 * General_Manue.click();
		 *
		 * if(Variety_Code.isDisplayed()) { ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].click();", Variety_Code);
		 * //Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code)).click();
		 * Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).
		 * sendKeys("999-Cotton Bales");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * System.out.println("coming form last page Variety_Code Is  clicking"); }else
		 * { System.out.println("Variety_Code After Address Is not clicking"); }
		 */

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
		System.out.println(
				"-------------------- Exchange_Deposite_Transaction_Multiple_GSL  Maker is Done-------------------------");

	}

	public void Government_Agency_Deposite_Transaction() {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Id from deposit_txn where DRN like ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + Government_Agency_Deposite_Request_Maker.Deposite + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Internal_Ref = rs1.getString("Id");
				System.out.println("Internal_Ref print: " + Internal_Ref);
			}

			String query_OTP = "SELECT a.auth_code " + "FROM auth_code_generation a "
					+ "JOIN deposit_txn d ON a.ref_id = d.Id " + "WHERE d.DRN LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + Government_Agency_Deposite_Request_Maker.Deposite + "%"); // bind the variable to //
																								// query

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				OTP_Auth = rs.getString("auth_Code");
				System.out.println("OTP: " + OTP_Auth);

				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Depositgoverment)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_Deposite click...");
			js.executeScript("arguments[0].click();", Depositgoverment);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_Deposite not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_Deposite: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_New_Req)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_New_Req click...");
			js.executeScript("arguments[0].click();", Physical_New_Req);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_New_Req not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_New_Req: " + e.getMessage());
		}
		// try {
		if (Internal_Ref.matches("^[0-9]{5}$")) {
			// Internal_Ref_No.click();
			Wait.until(ExpectedConditions.elementToBeClickable(Internal_Ref_No)).sendKeys(String.valueOf(Internal_Ref));
			System.out.println("Internal_Ref no is:" + Internal_Ref);
			Internal_Ref_No.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Invalid Internal_Ref. Please enter exactly 5 digits (numbers only):");
		}
		/*
		 * } catch (ElementClickInterceptedException e) { System.out.
		 * println("Normal click failed, trying JavaScript Internal_Ref_No click...");
		 * js.executeScript("arguments[0].value='" + Internal_Ref + "';",
		 * Internal_Ref_No); js.executeScript("arguments[0].click();", Internal_Ref_No);
		 * } catch (NoSuchElementException e) {
		 * System.out.println("Internal_Ref_No not found: " + e.getMessage()); } catch
		 * (Exception e) { System.out.println("Unexpected error for Internal_Ref_No: " +
		 * e.getMessage()); }
		 */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		if (OTP_Auth.matches("^[0-9]{6}$")) {
			Auth_Code.sendKeys(String.valueOf(OTP_Auth));
		} else {
			System.out.println("Invalid OTP_Auth. Please enter exactly 6 digits (numbers only):");
		}
		Wait.until(ExpectedConditions.elementToBeClickable(Submit_btn)).click();

		// Wait.until(ExpectedConditions.elementToBeClickable(Accept_check)).isSelected();

		Accept_check.isSelected();

		// submit_btn.click();
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", submit_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		} /*
			 * finally { System.out.println("submit_btn should be click");
			 * submit_btn.click(); }
			 */
		try {
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			if (dispatch_id_GA.isDisplayed()) {
				// Wait.until(ExpectedConditions.elementToBeClickable(dispatch_id_GA)).click();
				Wait.until(ExpectedConditions.elementToBeClickable(dispatch_id_GA)).click();
				Thread.sleep(1000);
				Wait.until(ExpectedConditions.elementToBeClickable(dispatch_id_GA))
						.sendKeys(String.valueOf(dispatch_Number));
				Thread.sleep(1000);
				Wait.until(ExpectedConditions.elementToBeClickable(dispatch_id_GA)).click();
				// Wait.until(ExpectedConditions.elementToBeClickable(dispatch_id)).sendKeys(String.valueOf(dispatch_Number));
				System.out.println(dispatch_Number);
			} else {
				System.out.println("dispatch_id is:" + dispatch_Number);
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript dispatch_id click...");
			js.executeScript("arguments[0].click();", dispatch_id);
			js.executeScript("arguments[0].value='" + dispatch_Number + "';", dispatch_id);
		} catch (NoSuchElementException e) {
			System.out.println("dispatch_id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for dispatch_id: " + e.getMessage());
		}
		/*
		 * Tare_Weight.sendKeys("100"); Tare_Weight.sendKeys(Keys.TAB);
		 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 * 
		 * Wait.until(driver -> { WebElement quantity = driver.findElement(By
		 * .xpath("//button[@data-id='qualitystdSelectionCombobox']//span[@class='filter-option pull-left']"
		 * )); String value = quantity.getAttribute("value"); return value != null &&
		 * !value.trim().isEmpty(); // Wait until value is populated });
		 */
		Select Sa = new Select(assaying_type_Text);
		Sa.selectByContainsVisibleText(assaying_type);

		// assaying_type.sendKeys("Self Verified");
		try {
			if (Weight_bridge.matches("^[a-zA-Z0-9]{0,100}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_text)).sendKeys(Weight_bridge);
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 15 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weight_bridge_text click...");
			js.executeScript("arguments[0].value='" + Weight_bridge + "';", Weight_bridge_text);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_text: " + e.getMessage());
		}
		try {
			if (Weight_bridge_Receipt.matches("^[a-zA-Z0-9]{0,50}$")) {
				Weight_bridge_Receipt_text.sendKeys(Weight_bridge_Receipt);
				// int Quantity = Notional_Quantity.getText();
			} else {
				System.out.println("Invalid Weight_bridge. Please enter exactly 50 alphanumeric characters:");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Weight_bridge_Receipt_text click...");
			js.executeScript("arguments[0].value='" + Weight_bridge_Receipt + "';", Weight_bridge_Receipt_text);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_Receipt_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_Receipt_text: " + e.getMessage());
		}
		// String.valueOf(Bridge)

		// String Bridge = Government_Agency_Deposite_Request_Maker.bags;// 2;
		try {
			if (WeighbridgeNetWeight.matches("^[0-9]{0,19}$")) {
				web_bridge.sendKeys(WeighbridgeNetWeight);
			} else {
				System.out.println("Invalid WeighbridgeNetWeight. Please enter exactly 19 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript web_bridge click...");
			js.executeScript("arguments[0].value='" + WeighbridgeNetWeight + "';", web_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("web_bridge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for web_bridge: " + e.getMessage());
		}
		try {
			if (EstimatedValueAtDeposit.matches("^[0-9]{0,15}$")) {
				Estimated.sendKeys(EstimatedValueAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Estimated click...");
			js.executeScript("arguments[0].value='" + EstimatedValueAtDeposit + "';", Estimated);
		} catch (NoSuchElementException e) {
			System.out.println("Estimated not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Estimated: " + e.getMessage());
		}
		try {
			if (MoistureAtDeposit.matches("^[0-9]{0,18}$")) {
				Moisture.sendKeys(MoistureAtDeposit);
			} else {
				System.out.println("Invalid EstimatedValueAtDeposit. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Moisture click...");
			js.executeScript("arguments[0].value='" + MoistureAtDeposit + "';", Moisture);
		} catch (NoSuchElementException e) {
			System.out.println("Moisture not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Moisture: " + e.getMessage());
		}
		try {
			if (Rate_of_Storage_Charges.matches("^[0-9]{0,15}$")) {
				Rate_of_Storage.sendKeys(Rate_of_Storage_Charges);
			} else {
				System.out.println("Invalid Rate_of_Storage_Charges. Please enter exactly 18 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Rate_of_Storage click...");
			js.executeScript("arguments[0].value='" + Rate_of_Storage_Charges + "';", Rate_of_Storage);
		} catch (NoSuchElementException e) {
			System.out.println("Rate_of_Storage not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Rate_of_Storage: " + e.getMessage());
		}
		try {
			if (Per_UOM.matches("^[a-zA-Z0-9]{0,40}$")) {
				Per_UOM_Text.sendKeys(Per_UOM);
			} else {
				System.out.println("Invalid Per_UOM. Please enter exactly 40 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Per_UOM_Text click...");
			js.executeScript("arguments[0].value='" + Per_UOM + "';", Per_UOM_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Per_UOM_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Per_UOM_Text: " + e.getMessage());
		}
		try {
			Lot.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Lot click...");
			js.executeScript("arguments[0].click();", Lot);
		} catch (NoSuchElementException e) {
			System.out.println("Lot not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot: " + e.getMessage());
		}
		try {
			if (Godown_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				Godown.sendKeys(Godown_No);
			} else {
				System.out.println("Invalid Godown_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Godown click...");
			js.executeScript("arguments[0].value='" + Godown_No + "';", Godown);
		} catch (NoSuchElementException e) {
			System.out.println("Godown not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Godown: " + e.getMessage());
		}
		try {
			if (Stack_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				Stack_No_Text.sendKeys(Stack_No);
			} else {
				System.out.println("Invalid Stack_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Stack_No_Text click...");
			js.executeScript("arguments[0].value='" + Stack_No + "';", Stack_No_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Stack_No_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Stack_No_Text: " + e.getMessage());
		}
		try {
			if (Lot_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				lot_no_Text.sendKeys(Lot_No);
			} else {
				System.out.println("Invalid Lot_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript lot_no_Text click...");
			js.executeScript("arguments[0].value='" + Lot_No + "';", lot_no_Text);
		} catch (NoSuchElementException e) {
			System.out.println("lot_no_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for lot_no_Text: " + e.getMessage());
		}
		try {
			if (Government_Agency_Deposite_Request_Maker.bags.matches("^[0-9]{0,5}$")) {
				no_of_bag.sendKeys(String.valueOf(Government_Agency_Deposite_Request_Maker.bags));
			} else {
				System.out.println("Invalid bags. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript no_of_bag click...");
			js.executeScript("arguments[0].value='" + Government_Agency_Deposite_Request_Maker.bags + "';", no_of_bag);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bag not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bag: " + e.getMessage());
		}
		try {
			if (Sample.matches("^[a-zA-Z0-9]{0,50}$")) {
				sample_Id.sendKeys(String.valueOf(Sample));
			} else {
				System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript sample_Id click...");
			js.executeScript("arguments[0].value='" + Sample + "';", sample_Id);
		} catch (NoSuchElementException e) {
			System.out.println("sample_Id not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for sample_Id: " + e.getMessage());
		}
		try {
			Verification_page.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Verification_page click...");
			js.executeScript("arguments[0].click();", Verification_page);
		} catch (NoSuchElementException e) {
			System.out.println("Verification_page not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verification_page: " + e.getMessage());
		}
		try {
			Depositor_Detail.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositor_Detail click...");
			js.executeScript("arguments[0].click();", Depositor_Detail);
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail: " + e.getMessage());
		}
		try {
			if (PanCard_No.matches("^[a-zA-Z0-9]{0,10}$")) {
				PAN_No.click();
				PAN_No.sendKeys(PanCard_No);
			} else {
				System.out.println("Invalid PanCard_No. Please enter exactly 10 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript PAN_No click...");
			js.executeScript("arguments[0].click();", PAN_No);
			js.executeScript("arguments[0].value='" + PanCard_No + "';", PAN_No);
		} catch (NoSuchElementException e) {
			System.out.println("PAN_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for PAN_No: " + e.getMessage());
		}
		try {
			if (DepositerName.matches("^[a-zA-Z0-9]{0,15}$")) {
				Depositer.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Depositer)).sendKeys(DepositerName);
				// Depositer.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid DepositerName. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Depositer click...");
			js.executeScript("arguments[0].click();", Depositer);
			js.executeScript("arguments[0].value='" + DepositerName + "';", Depositer);
		} catch (NoSuchElementException e) {
			System.out.println("Depositer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositer: " + e.getMessage());
		}
		try {
			if (L1.matches("^[a-zA-Z0-9]{0,33}$")) {
				Line_No_1.click();
				Line_No_1.sendKeys(L1);
			} else {
				System.out.println("Invalid L1. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Line_No_1 click...");
			js.executeScript("arguments[0].click();", Line_No_1);
			js.executeScript("arguments[0].value='" + L1 + "';", Line_No_1);
		} catch (NoSuchElementException e) {
			System.out.println("Line_No_1 not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Line_No_1: " + e.getMessage());
		}
		try {
			if (L2.matches("^[a-zA-Z0-9]{0,33}$")) {
				Line_No_2.click();
				Line_No_2.sendKeys(L2);
			} else {
				System.out.println("Invalid L2. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Line_No_2 click...");
			js.executeScript("arguments[0].click();", Line_No_2);
			js.executeScript("arguments[0].value='" + L2 + "';", Line_No_2);
		} catch (NoSuchElementException e) {
			System.out.println("Line_No_2 not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Line_No_2: " + e.getMessage());
		}
		try {
			if (L3.matches("^[a-zA-Z0-9]{0,33}$")) {
				Line_No_3.click();
				Line_No_3.sendKeys(L3);
			} else {
				System.out.println("Invalid L3. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Line_No_3 click...");
			js.executeScript("arguments[0].click();", Line_No_3);
			js.executeScript("arguments[0].value='" + L3 + "';", Line_No_3);
		} catch (NoSuchElementException e) {
			System.out.println("Line_No_3 not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Line_No_3: " + e.getMessage());
		}
		try {
			if (City_Name.matches("^[a-zA-Z0-9]{0,33}$")) {
				City.sendKeys(City_Name);
			} else {
				System.out.println("Invalid City_Name. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript City click...");
			js.executeScript("arguments[0].value='" + City_Name + "';", City);
		} catch (NoSuchElementException e) {
			System.out.println("City not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for City: " + e.getMessage());
		}
		try {
			if (PinCode.matches("^[0-9]{0,11}$")) {
				PinCode_Text.sendKeys(PinCode);
				PinCode_Text.sendKeys(Keys.ENTER);
				PinCode_Text.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid PinCode. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript PinCode_Text click...");
			js.executeScript("arguments[0].value='" + L3 + "';", PinCode_Text);
			js.executeScript("arguments[0].click();", PinCode_Text);
			js.executeScript("arguments[0].click();", PinCode_Text);
		} catch (NoSuchElementException e) {
			System.out.println("PinCode_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for PinCode_Text: " + e.getMessage());
		}

		// State.click();
		// Wait.until(ExpectedConditions.textToBePresentInElementValue(State,
		// "Maharashtra"));

		// --------- Deposit Assayer WebElement ---------------
		try {
			Deposit_Assayer_CheckBox.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Assayer_CheckBox click...");
			js.executeScript("arguments[0].click();", Deposit_Assayer_CheckBox);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Assayer_CheckBox not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Assayer_CheckBox: " + e.getMessage());
		}
		try {
			if (Assayring_Referance_No.isDisplayed()) {
				if (String.valueOf(Assayring_Referance_Id).matches("^[a-zA-Z0-9]{0,8}$")) {
					Wait.until(ExpectedConditions.elementToBeClickable(Assayring_Referance_No))
							.sendKeys(String.valueOf(Assayring_Referance_Id));
					System.out.println("Assayring_Referance_No is:" + Assayring_Referance_Id);
				}
			} else {
				System.out.println("System ou put:" + Assayring_Referance_Id);

			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Assayring_Referance_No click...");
			js.executeScript("arguments[0].value='" + Assayring_Referance_Id + "';", Assayring_Referance_No);
		} catch (NoSuchElementException e) {
			System.out.println("Assayring_Referance_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
		}

		Wait.until(ExpectedConditions.elementToBeClickable(AssayingDate)).click();

		// AssayingDate.click();

		Wait.until(ExpectedConditions.elementToBeClickable(Calander)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Today_dates)).click();

		try {
			if (String.valueOf(shelflife).matches("^[0-9]{0,5}$")) {
				shelflife_count.sendKeys(String.valueOf(shelflife));
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Assayring_Referance_No click...");
			js.executeScript("arguments[0].value='" + Assayring_Referance_Id + "';", Assayring_Referance_No);
		} catch (NoSuchElementException e) {
			System.out.println("Assayring_Referance_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Assayring_Referance_No: " + e.getMessage());
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
		int choice = Integer.parseInt(Government_Agency_Deposite_Request_Maker.Commodity_Code);
		// Step 4: Use switch to process selection
		switch (choice) {
		case 15:
			System.out.println("You selected: Cotton");
			Select Grade = new Select(Grade_Desig);
			Grade.selectByVisibleText("GENERAL");
			Grade_Desig.click();

			Select Pre_Qualification = new Select(Pre_Qualification_Txt);
			Pre_Qualification.selectByIndex(1);

			OTHER_FOOD_GRAINS.sendKeys("3");
			DAMAGED_GRAINS.sendKeys("2");
			SLIGHTLY_DAMAGED_GRAINS.sendKeys("3");
			IMMATURE_SHRIVELED_AND_BROKEN_GRAINS.sendKeys("12");
			WEEVILED_GRAINS.sendKeys("3");
			ADMIXTURE.sendKeys("2");
			DAMAGED_IMMATURE_WEEVILLED.sendKeys("4");
			FOREIGN_MATTER_ORGANIC.sendKeys("0.6");
			FOREIGN_MATTER_INORGANIC.sendKeys("0.2");
			OTHER_EDIBLE_GRAINS.sendKeys("3");
			PERCENTAGE_OF_BULBS_BY_WEIGHT.sendKeys("5");
			MOISTURE.sendKeys("8");
			FOREIGN_MATTER.sendKeys("1");
			MOISTURE_CONTENT.sendKeys("10");
			SLIGHTLY_DAMAGED_TOUCHED_GRAINS.sendKeys("4");
			FOREIGN_MATTER_BY_WT.sendKeys("3");
			MOISTURE_BY_WT_Max.sendKeys("14");
			ADMIXTURE_OTHER_EDIBLE_GRAINS.sendKeys("4");
			WEEVILLED_GRAINS.sendKeys("9");
			DAMAGED_IMMATURE_SHRIVELED_GRAINS.sendKeys("8");
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
		case 6:
			System.out.println("You selected: CHANA ");
			// Grade_CHANA_WHOLE.click();
			Select Grade_CHANA = new Select(Grade_CHANA_WHOLE);
			Grade_CHANA.selectByVisibleText("NAFED FAQ");
			// Grade_CHANA_WHOLE.click();

			Select Qualification = new Select(Pre_Qualification_Txt);
			Qualification.selectByContainsVisibleText("Qualified");

			OTHER_FOOD_GRAINS_CHANA.sendKeys("3");

			DAMAGED_GRAINS_CHANA.sendKeys("3");

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
		// -----------------Deposit Confirm WebElement------------
		try {
			Deposit_Confirm.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Deposit_Confirm click...");
			js.executeScript("arguments[0].click();", Deposit_Confirm);
		} catch (NoSuchElementException e) {
			System.out.println("Deposit_Confirm not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Deposit_Confirm: " + e.getMessage());
		}

		Lots.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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

		System.out.println(
				"-------------------- Government_Agency_Deposite_Transaction WareHouse Maker is Done-------------------------");

	}

	public void Physical_Deposit_Pending_CR118() throws InterruptedException {

		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_btn)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Transaction_btn);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
		}
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Physical_Deposite)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Physical_Deposite click...");
			js.executeScript("arguments[0].click();", Physical_Deposite);
		} catch (NoSuchElementException e) {
			System.out.println("Physical_Deposite not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Physical_Deposite: " + e.getMessage());
		}

		// PendingforPledgeCreation_link.getAttribute(null);
		Thread.sleep(1000);

		if (PendingforPhysical.isDisplayed()) {

			PendingforPhysical.click();
		} else {
			System.out.println("Pending for Physical Deposit is not visible");
		}
		Thread.sleep(1000);
	}
}
