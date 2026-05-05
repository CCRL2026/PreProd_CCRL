package TestPages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utillity.DataBaseUtility;
import Utillity.ExcelUtils;

public class Exchange_Non_Agri_WareHouse {

	// public static final String remainingBags = null;
	// public static final String noOfBags = null;
	WebDriver driver;
	WebDriverWait Wait;

	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ENWR_Creation.xlsx";
	static String sheet = "Exchange_Non_Agriculture_Physic";
	static int dataRow = 1; // second row of data
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	/*
	 * // String Deposite; String Id = "53369"; // 53267; String auth_Code =
	 * "556747"; // 557332; String Variety_Code_Value = "272 - ZINC-VARIETY 1";
	 * String assaying_type = "Self Verified"; String Weight_bridge = "Abhishek";
	 * String Weight_bridge_Receipt = "12343"; String EstimatedValue = "4000";
	 * String Lot_Heat_Cast_Batch_number = "30"; String Per_Month = "12"; String
	 * per_uom = "2"; public static String Sample = "46202557"; public static int
	 * lot_No = 46202558; static String Quantity ="5"; String NetWeightPerPackList
	 * ="1000"; String Godown_No = "A"; String Stack_No = "B"; String Lot_No = "c";
	 * String PanCard_No = "BPTPT5612N"; String DepositerName = "Abhishek Thasal";
	 * String L1 = "Room No 102"; String L2 = "Jarimari Mandir Road"; String L3 =
	 * "Umelman"; String City_Name = "Vasai"; String PinCode = "401202"; int
	 * shelflife = 179;
	 */

	String Internal_Ref;// = "698798";// = excel.getInternal_Ref_ex_py(dataRow);
	String OTP_Auth;// = "989888";// = excel.getOTP_Auth_ex_py(dataRow);
	String Variety_Code_Value = excel.getVariety_Code_Value_ex_py(dataRow);
	String assaying_type = excel.getassaying_type_ex_py(dataRow);
	String Weight_bridge = excel.getWeight_bridge_ex_py(dataRow);
	static String Weight_bridge_Receipt = excel.getWeight_bridge_Receipt_ex_py(dataRow);
	String EstimatedValue = excel.getEstimatedValue_ex_py(dataRow);
	String Lot_Heat_Cast_Batch_number = excel.getLot_Heat_Cast_Batch_number_ex_py(dataRow);
	String Per_Month = excel.getPer_Month_ex_py(dataRow);
	String per_uom = excel.getper_uom_ex_py(dataRow);
	static int No_Of_Bundles = excel.getNo_Of_Bundles_ex_py(dataRow);
	int pieces_per_bundles = excel.getpieces_per_bundle_ex_py(dataRow);
	public static String place_of_origin = excel.getSample_ex_py(dataRow);
	public static int lot_No = excel.getlot_No_ex_py(dataRow);
	static String Quantity = excel.getQuantity_ex_py(dataRow);
	String NetWeightPerPackList = excel.getNetWeightPerPackList_ex_py(dataRow);
	String Godown_No = excel.getGodown_No_ex_py(dataRow);
	String Stack_No = excel.getStack_No_ex_py(dataRow);
	String Lot_No = excel.getLot_No_ex_py(dataRow);
	String PanCard_No = excel.getPanCard_No_ex_py(dataRow);
	String DepositerName = excel.getDepositerName_ex_py(dataRow);
	String L1 = excel.getL1_ex_py(dataRow);
	String L2 = excel.getL2_ex_py(dataRow);
	String L3 = excel.getL3_ex_py(dataRow);
	String City_Name = excel.getCity_Name_ex_py(dataRow);
	String PinCode = excel.getPinCode_ex_py(dataRow);
	int shelflife = excel.getshelflife_ex_py(dataRow);
	int Bag_Total = excel.getBag_Total_ex_py(dataRow);
	static int totalBags = excel.gettotalBags(dataRow);
	int j = 3;

	public Exchange_Non_Agri_WareHouse(WebDriver driver, WebDriverWait Wait) {
		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);
	}

	// span[normalize-space()='Transactions']
	// (//span[@class='title ng-binding'][normalize-space()='Transactions'])[1]
	@FindBy(xpath = "//a[@class='auto ng-scope']//span[@class='title ng-binding'][normalize-space()='Transactions']")
	WebElement Transaction_Bttn_Xpath;
	@FindBy(xpath = "(//span[@class='title ng-binding'][normalize-space()='Transactions'])[1]")
	WebElement Transaction_btn;
	@FindBy(xpath = "//span[normalize-space()='Physical Deposit']")
	WebElement Physical_Deposite;
	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement Physical_New_Req;
	@FindBy(xpath = "(//input[@name='drn1'])[1]")
	WebElement Internal_Ref_No;
	@FindBy(xpath = "//input[@name='auth_code']")
	WebElement Auth_Code_Text;
	@FindBy(xpath = "//button[@class = 'btn btn-primary blue']")
	WebElement Submit_btn;
	@FindBy(xpath = "//span[@class='check']")
	WebElement Accept_check;
	@FindBy(xpath = "//button[@ng-disabled='submitShow']")
	WebElement submit_btn;
	@FindBy(xpath = "//input[@name='Tare_Weight']")
	WebElement Tare_Weight;
	@FindBy(xpath = "//button[contains(@class, 'dropdown-toggle') and @data-id='VarietyMasterSelectionCombobox']")
	WebElement Variety_Code;
	// (//div[@class='bs-searchbox'])[3]
	// select[@id='VarietyMasterSelectionCombobox']
	// (//input[@type='text'])[25]
	@FindBy(xpath = "(//input[@type='text'])[25]")
	WebElement Variety_Code_Text;
	@FindBy(xpath = "//input[contains(@class, 'form-control') and @name='dispatch_id' and  @ng-disabled='IsDisabletxt'][1]")
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
	WebElement web_bridge_Value;
	@FindBy(xpath = "//input[@name='EstimatedValue' and @ng-model='vm.CreateDepositWspWh.est_value_deposit']")
	WebElement EstimatedValue_text;
	@FindBy(xpath = "//button[@type='button' and @class='btn btn-info' and @ng-click='vm.addLotDetails()']")
	WebElement Add_Button;
	@FindBy(xpath = "//input[@name='place_of_origin']")
	WebElement place_of_origin_txt;
	@FindBy(xpath = "//input[@name='Lot_Heat_Cast_Batch_number']")
	WebElement Lot_Heat_Cast_Batch_number_text;
	@FindBy(xpath = "//input[@placeholder='Per Month']")
	WebElement Per_Month_text;
	@FindBy(xpath = "//input[@name='StorageChargesperuom']")
	WebElement peruom;
	@FindBy(xpath = "//a[normalize-space()='Lot Details']")
	WebElement Lot;
	@FindBy(xpath = "//input[@name='godown']")
	WebElement Godown;
	@FindBy(xpath = "//input[@name='stack_no']")
	WebElement Stack_No_Text;
	@FindBy(xpath = "//input[@name='lot_no']")
	WebElement lot_no_Text;
	@FindBy(xpath = "(//input[@name='no_of_bag'])[3]")
	WebElement no_of_bag;
	@FindBy(xpath = "//input[@ng-class=\"{'edited':LotDetails.NoOfPiecesPerBundle}\"]")
	WebElement NoOfPiecesPerBundle;
	@FindBy(xpath = "//input[@name='sample_Id']")
	WebElement sample_Id;
	@FindBy(xpath = "(//input[@name='QTY'])[1]")
	WebElement Quantity_text;
	@FindBy(xpath = "//input[@name='NetWeightPerPackList']")
	WebElement NetWeightPerPackList_text;
	@FindBy(xpath = "(//a[normalize-space()='Verification'])[1]")
	WebElement Verification_page;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement Lots_Confirmation;
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
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement InvalidNoofBundles;
	@FindBy(xpath = "(//button[normalize-space()='Ok'])[1]")
	WebElement Variety_Code_Pop_Up;
	@FindBy(xpath = "//button[@class='btn btn-danger ng-hide']")
	WebElement Verify_btn;
	@FindBy(xpath = "//button[@class='btn btn-primary blue ng-isolate-scope']")
	WebElement Save_btn;

	public void Exchange_Non_Agriculture_Physical() throws InterruptedException {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Id from deposit_txn where DRN like ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Internal_Ref = rs1.getString("Id");
				System.out.println("Internal_Ref print: " + Internal_Ref);
			}

			String query_OTP = "SELECT a.auth_code " + "FROM auth_code_generation a "
					+ "JOIN deposit_txn d ON a.ref_id = d.Id " + "WHERE d.DRN LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "%"); // bind the
																										// variable to
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
			Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn_Xpath)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Bttn_Xpath click...");
			js.executeScript("arguments[0].click();", Transaction_Bttn_Xpath);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
		}
		// Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn_Xpath)).click();
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
			if (Internal_Ref.matches("^[0-9]{0,5}$")) {
				Internal_Ref_No.sendKeys(String.valueOf(Internal_Ref));
				System.out.println("id is getting from DB:" + Internal_Ref);
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
				Auth_Code_Text.sendKeys(String.valueOf(OTP_Auth));
			} else {
				System.out.println("Invalid OTP_Auth. Please enter exactly 6 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Auth_Code click...");
			js.executeScript("arguments[0].value='" + OTP_Auth + "';", Auth_Code_Text);

		} catch (NoSuchElementException e) {
			System.out.println("Auth_Code_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Auth_Code_Text: " + e.getMessage());
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
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Accept_check);
		} catch (NoSuchElementException e) {
			System.out.println("Accept_check not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Accept_check: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", submit_btn);
			// Wait.until(ExpectedConditions.elementToBeClickable(submit_btn)).click();

		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		Thread.sleep(4000);
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code)).click();
			Thread.sleep(2000);
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Variety_Code_Value);
			Variety_Code_Text.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element not clickable at the moment: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}

		try {
			Select Sa = new Select(assaying_type_Text);
			Sa.selectByContainsVisibleText(assaying_type);
			// assaying_type_Text.sendKeys(assaying_type);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(assaying_type_Text)).sendKeys(assaying_type);
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
			Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_text)).sendKeys(Weight_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_text: " + e.getMessage());
		}

		try {
			if (Weight_bridge_Receipt.matches("^[a-zA-Z0-9]{0,50}$")) {
				Weight_bridge_Receipt_text.sendKeys(Weight_bridge_Receipt);
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

		try {
			if (Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity.matches("^[0-9]{0,19}$")) {
				web_bridge_Value.sendKeys(Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity);
				System.out.println("web_bridge_Value is :" + Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity);
			} else {
				System.out.println(
						" Wrong web_bridge_Value is :" + Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity);
				System.out.println("Invalid WeighbridgeNetWeight. Please enter exactly 19 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity + "';",
					web_bridge_Value);
		} catch (NoSuchElementException e) {
			System.out.println("web_bridge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for web_bridge: " + e.getMessage());
		}

		try {
			EstimatedValue_text.sendKeys(EstimatedValue);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(EstimatedValue_text)).sendKeys(EstimatedValue);

		} catch (NoSuchElementException e) {
			System.out.println("EstimatedValue_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for EstimatedValue_text: " + e.getMessage());
		}

		place_of_origin_txt.sendKeys(place_of_origin);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		try {
			Lot_Heat_Cast_Batch_number_text.sendKeys(Lot_Heat_Cast_Batch_number);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Lot_Heat_Cast_Batch_number_text))
					.sendKeys(Lot_Heat_Cast_Batch_number);

		} catch (NoSuchElementException e) {
			System.out.println("Lot_Heat_Cast_Batch_number_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Heat_Cast_Batch_number_text: " + e.getMessage());
		}

		try {
			Per_Month_text.sendKeys(Per_Month);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Per_Month_text)).sendKeys(Per_Month);

		} catch (NoSuchElementException e) {
			System.out.println("Per_Month_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Per_Month_text: " + e.getMessage());
		}

		try {
			peruom.sendKeys(per_uom);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(peruom)).sendKeys(per_uom);

		} catch (NoSuchElementException e) {
			System.out.println("peruom not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for peruom: " + e.getMessage());
		}
		Lot.click();

		try {
			if (Godown_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Godown)).sendKeys(Godown_No);
			} else {
				System.out.println("Invalid Godown_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Godown_No + "';", Godown);
			// Wait.until(ExpectedConditions.elementToBeClickable(Godown)).sendKeys(Godown_No);

		} catch (NoSuchElementException e) {
			System.out.println("Godown not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Godown: " + e.getMessage());
		}

		try {
			if (Stack_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Stack_No_Text)).sendKeys(Stack_No);
			} else {
				System.out.println("Invalid Stack_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Stack_No + "';", Stack_No_Text);
			// Wait.until(ExpectedConditions.elementToBeClickable(Stack_No_Text)).sendKeys(Stack_No);
		} catch (NoSuchElementException e) {
			System.out.println("Stack_No_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Stack_No_Text: " + e.getMessage());
		}

		try {
			if (Lot_No.matches("^[a-zA-Z0-9]{0,15}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(lot_no_Text)).sendKeys(Lot_No);
			} else {
				System.out.println("Invalid Lot_No. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(lot_no_Text)).sendKeys(Lot_No);

		} catch (NoSuchElementException e) {
			System.out.println("lot_no_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for lot_no_Text: " + e.getMessage());
		}

		try {
			// Exchange_Deposite_Request_Non_Agriculture_Maker.No_of_Bundle
			if (String.valueOf(No_Of_Bundles).matches("^[0-9]{0,5}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(no_of_bag)).sendKeys(String.valueOf(No_Of_Bundles));
			} else {
				System.out.println("Invalid bags. Please enter exactly 5 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript(
					"arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.No_of_Bundle + "';",
					no_of_bag);
		} catch (NoSuchElementException e) {
			System.out.println("no_of_bag not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for no_of_bag: " + e.getMessage());
		}

		/*
		 * try { // Exchange_Deposite_Request_Non_Agriculture_Maker.Pieces_Per_Bundles
		 * if (String.valueOf(pieces_per_bundles).matches("^[0-9]{0,5}$")) {
		 * NoOfPiecesPerBundle.sendKeys(String.valueOf(pieces_per_bundles)); } } catch
		 * (ElementClickInterceptedException e) { js.executeScript(
		 * "arguments[0].value='" +
		 * Exchange_Deposite_Request_Non_Agriculture_Maker.Pieces_Per_Bundle + "';",
		 * NoOfPiecesPerBundle); } catch (NoSuchElementException e) {
		 * System.out.println("NoOfPiecesPerBundle not found: " + e.getMessage()); }
		 * catch (Exception e) {
		 * System.out.println("Unexpected error for NoOfPiecesPerBundle: " +
		 * e.getMessage()); }
		 */

		/*
		 * try { if (Sample.matches("^[a-zA-Z0-9]{0,50}$")) {
		 * sample_Id.sendKeys(String.valueOf(Sample)); } else { System.out.
		 * println("Invalid Sample. Please enter exactly 50 digits (numbers only):"); }
		 * } catch (ElementClickInterceptedException e) {
		 * js.executeScript("arguments[0].value='" + Sample + "';", sample_Id); } catch
		 * (NoSuchElementException e) { System.out.println("sample_Id not found: " +
		 * e.getMessage()); } catch (Exception e) {
		 * System.out.println("Unexpected error for sample_Id: " + e.getMessage()); }
		 */

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		try {
			if (Quantity.matches("^[a-zA-Z0-9]{0,50}$")) {
				Wait.until(ExpectedConditions.elementToBeClickable(Quantity_text)).sendKeys(Quantity);
				System.out.println("Quantity_text is :" + Quantity);
			} else {
				System.out.println(" Wrong Quantity_text is :" + Quantity);
				System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Quantity + "';", Quantity_text);
		} catch (NoSuchElementException e) {
			System.out.println("Quantity_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Quantity_text: " + e.getMessage());
		}

		try {

			if (NetWeightPerPackList.matches("^[a-zA-Z0-9]{0,50}$")) {
				NetWeightPerPackList_text.sendKeys(String.valueOf(NetWeightPerPackList));
			} else {
				System.out.println("Invalid Sample. Please enter exactly 50 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(NetWeightPerPackList_text))
					.sendKeys(NetWeightPerPackList);
		} catch (NoSuchElementException e) {
			System.out.println("NetWeightPerPackList_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for NetWeightPerPackList_text: " + e.getMessage());
		}

		try {
			Depositor_Detail.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Depositor_Detail);
			Depositor_Detail.click();
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail: " + e.getMessage());
		}
		try {
			if (PanCard_No.matches("^[a-zA-Z0-9]{0,10}$")) {
				PAN_No.click();
				PAN_No.sendKeys(PanCard_No);
				PAN_No.sendKeys(Keys.TAB);
			} else {
				System.out.println("Invalid PanCard_No. Please enter exactly 10 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PAN_No);
			PAN_No.sendKeys(PanCard_No);
			PAN_No.sendKeys(Keys.TAB);
		} catch (NoSuchElementException e) {
			System.out.println("PAN_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for PAN_No: " + e.getMessage());
		}
		try {
			if (DepositerName.matches("^[a-zA-Z0-9]{0,15}$")) {
				Depositer.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Depositer)).sendKeys(DepositerName);
				Depositer.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid DepositerName. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Depositer);
			Depositer.sendKeys(DepositerName);
		} catch (NoSuchElementException e) {
			System.out.println("Depositer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositer: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Verify_btn);
			Verify_btn.click();
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn : " + e.getMessage());
		}
		try {
			if (Save_btn.isDisplayed()) {

				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			Save_btn.click();
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}

	}

	public void Exchange_Non_Agriculture_Physical_Multiple_GSL() throws InterruptedException {

		try {
			Connection conn = DataBaseUtility.getConnection();

			String Internal_Reference = "select Id from deposit_txn where DRN like ?";
			PreparedStatement Internal_Reference_Id = conn.prepareStatement(Internal_Reference);
			Internal_Reference_Id.setString(1, "%" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "%");
			ResultSet rs1 = Internal_Reference_Id.executeQuery();
			if (rs1.next()) {
				Internal_Ref = rs1.getString("Id");
				System.out.println("Internal_Ref print: " + Internal_Ref);
			}

			String query_OTP = "SELECT a.auth_code " + "FROM auth_code_generation a "
					+ "JOIN deposit_txn d ON a.ref_id = d.Id " + "WHERE d.DRN LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(query_OTP);
			stmt.setString(1, "%" + Exchange_Deposite_Request_Non_Agriculture_Maker.Deposite + "%"); // bind the
																										// variable to
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
			Transaction_Bttn_Xpath.click();
			// Wait.until(ExpectedConditions.elementToBeClickable(Transaction_Bttn_Xpath)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Transaction_Bttn_Xpath click...");
			js.executeScript("arguments[0].click();", Transaction_Bttn_Xpath);
		} catch (NoSuchElementException e) {
			System.out.println("Transaction_Bttn_Xpath not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Transaction_Bttn_Xpath: " + e.getMessage());
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
			if (String.valueOf(Internal_Ref).matches("^[0-9]{5}$")) {
				Internal_Ref_No.sendKeys(String.valueOf(Internal_Ref));

				System.out.println("id is getting from DB:" + Internal_Ref);

				Internal_Ref_No.sendKeys(Keys.ENTER);
			} else {
				System.out.println("id is getting from DB:" + Internal_Ref);
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
				Auth_Code_Text.sendKeys(String.valueOf(OTP_Auth));
			} else {
				System.out.println("OTP_Auth is getting from DB:" + OTP_Auth);
				System.out.println("Invalid OTP_Auth. Please enter exactly 6 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript Auth_Code click...");
			js.executeScript("arguments[0].value='" + OTP_Auth + "';", Auth_Code_Text);
		} catch (NoSuchElementException e) {
			System.out.println("Auth_Code_Text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Auth_Code_Text: " + e.getMessage());
		}
		Thread.sleep(1000);
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
			System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
			js.executeScript("arguments[0].click();", Accept_check);
		} catch (NoSuchElementException e) {
			System.out.println("Accept_check not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Accept_check: " + e.getMessage());
		}
		Thread.sleep(3000);
		try {
			submit_btn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			js.executeScript("arguments[0].click();", submit_btn);
			// Wait.until(ExpectedConditions.elementToBeClickable(submit_btn)).click();
		} catch (NoSuchElementException e) {
			System.out.println("submit_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for submit_btn: " + e.getMessage());
		}
		Thread.sleep(4000);
		try {
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code)).click();
			Thread.sleep(3000);
			Wait.until(ExpectedConditions.elementToBeClickable(Variety_Code_Text)).sendKeys(Variety_Code_Value);
			Thread.sleep(3000);
			Variety_Code_Text.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element not clickable at the moment: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}

		Thread.sleep(1000);
		try {
			Select Sa = new Select(assaying_type_Text);
			Sa.selectByContainsVisibleText(assaying_type);
			// assaying_type_Text.sendKeys(assaying_type);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(assaying_type_Text)).sendKeys(assaying_type);
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
			Wait.until(ExpectedConditions.elementToBeClickable(Weight_bridge_text)).sendKeys(Weight_bridge);
		} catch (NoSuchElementException e) {
			System.out.println("Weight_bridge_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Weight_bridge_text: " + e.getMessage());
		}
		try {
			if (Weight_bridge_Receipt.matches("^[a-zA-Z0-9]{0,50}$")) {
				Weight_bridge_Receipt_text.sendKeys(Weight_bridge_Receipt);
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
		try {
			if (Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity.matches("^[0-9]{0,19}$")) {
				web_bridge_Value.sendKeys(Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity);
			} else {
				System.out.println("Invalid WeighbridgeNetWeight. Please enter exactly 19 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].value='" + Exchange_Deposite_Request_Non_Agriculture_Maker.NQuantity + "';",
					web_bridge_Value);
		} catch (NoSuchElementException e) {
			System.out.println("web_bridge not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for web_bridge: " + e.getMessage());
		}
		try {
			EstimatedValue_text.sendKeys(EstimatedValue);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(EstimatedValue_text)).sendKeys(EstimatedValue);
		} catch (NoSuchElementException e) {
			System.out.println("EstimatedValue_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for EstimatedValue_text: " + e.getMessage());

		}

		Wait.until(ExpectedConditions.elementToBeClickable(place_of_origin_txt)).sendKeys(place_of_origin);

		Thread.sleep(1000);
		try {
			Lot_Heat_Cast_Batch_number_text.sendKeys(Lot_Heat_Cast_Batch_number);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Lot_Heat_Cast_Batch_number_text))
					.sendKeys(Lot_Heat_Cast_Batch_number);
		} catch (NoSuchElementException e) {
			System.out.println("Lot_Heat_Cast_Batch_number_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Lot_Heat_Cast_Batch_number_text: " + e.getMessage());
		}
		try {
			Per_Month_text.sendKeys(Per_Month);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(Per_Month_text)).sendKeys(Per_Month);

		} catch (NoSuchElementException e) {
			System.out.println("Per_Month_text not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Per_Month_text: " + e.getMessage());
		}
		try {
			peruom.sendKeys(per_uom);
		} catch (ElementClickInterceptedException e) {
			Wait.until(ExpectedConditions.elementToBeClickable(peruom)).sendKeys(per_uom);
		} catch (NoSuchElementException e) {
			System.out.println("peruom not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for peruom: " + e.getMessage());
		}
		Lot.click();
		WebElement remainingBagsElement = driver.findElement(By.xpath("(//div[@class='col-sm-2'])[7]"));
//		//int remainingBags = Integer.parseInt(remainingBagsElement.getText());
//		WebElement Add_Button = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
//
//		//int maxLoops = Math.min(50, remainingBags);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll Add button into view
		js.executeScript("arguments[0].scrollIntoView()", Add_Button);

		// Read remaining bags
		int remainingBags = Integer.parseInt(remainingBagsElement.getText());
		// int noOfBags = Integer.parseInt(Bag_Total);

		if (remainingBags != Bag_Total) {
			for (int i = 1; i <= remainingBags; i++) {
				System.out.println("Filling data for Row: " + i);

				try {
					driver.findElement(By.xpath("(//input[@name='godown'])[" + i + "]")).sendKeys("Godown " + i);
				} catch (Exception e) {
					System.out.println("Godown error at " + i + ": " + e.getMessage());
				}

				try {
					driver.findElement(By.xpath("(//input[@name='stack_no'])[" + i + "]")).sendKeys("Stack_No" + i);
				} catch (Exception e) {
					System.out.println("Stack_No error at " + i + ": " + e.getMessage());
				}

				try {
					WebElement lot_no = driver.findElement(By.xpath("(//input[@name='lot_no'])[" + i + "]"));
					Wait.until(ExpectedConditions.elementToBeClickable(lot_no)).sendKeys("Lot " + i);
				} catch (Exception e) {
					System.out.println("Lot_No error at " + i + ": " + e.getMessage());
				}

				// Fill no_of_bag at every 3rd index
				// if (i % 3 == 1) {
				int k = i * j;
				// try {
				WebElement NO_Bag = driver.findElement(By.xpath("(//input[@name='no_of_bag'])[" + k + "]"));
				System.out.println("no of bags:" + NO_Bag);
				Wait.until(ExpectedConditions.elementToBeClickable(NO_Bag)).sendKeys(String.valueOf(No_Of_Bundles));
				/*
				 * } catch (Exception e) { System.out.println("No_of_bag error at " + k + ": " +
				 * e.getMessage()); }
				 */
				// }

				// Fill pieces_per_bundles at every 3rd+1 index
				/*
				 * if (i % 3 == 2) { try { WebElement Pieces = Wait.until(ExpectedConditions
				 * .elementToBeClickable(By.xpath("(//input[@name='no_of_bag'])[" + i + "]")));
				 * Pieces.sendKeys(String.valueOf(pieces_per_bundles)); } catch (Exception e) {
				 * System.out.println("Pieces_Per_Bundle error at " + i + ": " +
				 * e.getMessage()); } }
				 */

				/*
				 * try { WebElement Sample =
				 * driver.findElement(By.xpath("(//input[@name='sample_Id'])[" + i + "]"));
				 * Sample.sendKeys("sample_ID" + i); } catch (Exception e) {
				 * System.out.println("Sample ID error at " + i + ": " + e.getMessage()); }
				 */

				try {
					WebElement Quantity_txt = driver.findElement(By.xpath("(//input[@name='QTY'])[" + i + "]"));
					Wait.until(ExpectedConditions.elementToBeClickable(Quantity_txt)).sendKeys(Quantity);
				} catch (Exception e) {
					System.out.println("Quantity error at " + i + ": " + e.getMessage());
				}

				try {
					driver.findElement(By.xpath("(//input[@name='NetWeightPerPackList'])[" + i + "]"))
							.sendKeys(NetWeightPerPackList);
				} catch (Exception e) {
					System.out.println("NetWeightPerPackList error at " + i + ": " + e.getMessage());
				}

				// ✅ Click Add after each row is filled
				try {
					if (Add_Button.isDisplayed() && Add_Button.isEnabled()) {
						js.executeScript("arguments[0].click();", Add_Button); // JS click is safer
						System.out.println("✅ Row " + i + " added successfully");

						// Handle confirmation if appears
						try {
							Wait.until(ExpectedConditions.elementToBeClickable(Lots_Confirmation)).click();
							System.out.println("✅ Confirmation clicked for row " + i);
							js.executeScript("arguments[0].click();", Add_Button); // JS click is safer
						} catch (Exception e) {
							System.out.println("⚠️ Confirmation not found for row " + i);
						}
					}
				} catch (Exception e) {
					System.out.println("Add button click failed at row " + i + ": " + e.getMessage());
				}
			}
		} else {
			System.out.println("No rows to process.");
		}

		try {
			if (Add_Button.isDisplayed() && Add_Button.isEnabled()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Add_Button)).click();
				System.out.println("Add button clicked.");
			}
		} catch (Exception e) {
			System.out.println("Error clicking Add button: " + e.getMessage());
		}

		/*
		 * // Update remainingBags if dynamically changing try { remainingBags =
		 * Integer.parseInt(remainingBag.getText()); } catch (Exception e) {
		 * System.out.println("Error updating remainingBags: " + e.getMessage()); } } }
		 */
		try {
			Depositor_Detail.sendKeys(Keys.ENTER);
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Depositor_Detail);
			Depositor_Detail.click();
		} catch (NoSuchElementException e) {
			System.out.println("Depositor_Detail not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositor_Detail: " + e.getMessage());
		}
		try {
			if (PanCard_No.matches("^[a-zA-Z0-9]{0,10}$")) {
				PAN_No.click();
				PAN_No.sendKeys(PanCard_No);
				PAN_No.sendKeys(Keys.TAB);
			} else {
				System.out.println("Invalid PanCard_No. Please enter exactly 10 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PAN_No);
			PAN_No.sendKeys(PanCard_No);
			PAN_No.sendKeys(Keys.TAB);
		} catch (NoSuchElementException e) {
			System.out.println("PAN_No not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for PAN_No: " + e.getMessage());
		}
		try {
			if (DepositerName.matches("^[a-zA-Z0-9]{0,15}$")) {
				Depositer.click();
				Wait.until(ExpectedConditions.elementToBeClickable(Depositer)).sendKeys(DepositerName);
				Depositer.sendKeys(Keys.ENTER);
			} else {
				System.out.println("Invalid DepositerName. Please enter exactly 15 digits (numbers only):");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Depositer);
			Depositer.sendKeys(DepositerName);
		} catch (NoSuchElementException e) {
			System.out.println("Depositer not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Depositer: " + e.getMessage());
		}
		try {
			if (Verify_btn.isDisplayed()) {
				Wait.until(ExpectedConditions.elementToBeClickable(Verify_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Verify_btn);
			Verify_btn.click();
		} catch (NoSuchElementException e) {
			System.out.println("Verify_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_btn : " + e.getMessage());
		}
		try {
			if (Save_btn.isDisplayed()) {

				Wait.until(ExpectedConditions.elementToBeClickable(Save_btn)).click();
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Save_btn);
			Save_btn.click();
		} catch (NoSuchElementException e) {
			System.out.println("Save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_btn: " + e.getMessage());
		}
	}
}