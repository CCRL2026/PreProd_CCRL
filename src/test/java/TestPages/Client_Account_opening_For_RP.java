package TestPages;

import java.time.DayOfWeek;
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

public class Client_Account_opening_For_RP {

	WebDriver driver;
	WebDriverWait Wait;
	// String projectPath = System.getProperty("user.dir");
	static String path = "C:\\Users\\abhishekyt\\git\\repository\\Automation\\Data\\ClientOpening.xlsx";
	static String sheet = "ClientOpening";
	static int dataRow = 3; // second row of data
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static ExcelUtils excel = new ExcelUtils(path, sheet);

	/*
	 * static int clientid_Num = 9090; String FormID = "3214"; static String
	 * Client_holder_Name = "CCRL_HR"; String Client_Type = "Individual"; String
	 * Client_Sub_Type = "Individual"; String Frequency = "Annually"; String
	 * Statement = "Physical"; String Line1 = "Lep Gaulwadi"; String Line2 =
	 * "Mhasala"; String Line3 = "Raigad"; String Line4 = "Lep"; String City =
	 * "Mhasala"; int PinCode = 401202; int mobile_Isd = 91; static long
	 * mobile_NUmber = 9730150615L; String Email_Id = "Abdj@gmail.com"; int
	 * Account_No = 9696696; String IFSC = "HDFC0000002"; String BankAccount =
	 * "Saving Bank Account"; String IncomeRange = "500001-1000000"; String
	 * PanCardNo = "PBTPT5612N"; String POI = "PAN CARD"; String POA =
	 * "AADHAR CARD (POA)"; String Authsignatory_Name = "Abhishek Thasal"; String
	 * Authorized_Representative_Name = "Kalpesh"; String CIN_Number = "4rf4adq";
	 * String GSTIN_Number = "22 AAAAA0000A1Z5"; String SEBI_Registration_Number =
	 * "r35r24";
	 */

	public int clientid_Num = excel.getclientid_Num(dataRow);
	String FormID = excel.getFormID(dataRow);
	static String Client_holder_Name = excel.getClient_holder_Name(dataRow);
	String Client_Type = excel.getClient_Type(dataRow);
	String Client_Sub_Type = excel.getClient_Sub_Type(dataRow);
	String Frequency = excel.getFrequency(dataRow);
	String Statement = excel.getStatement(dataRow);
	String Line1 = excel.getLine1(dataRow);
	String Line2 = excel.getLine2(dataRow);
	String Line3 = excel.getLine3(dataRow);
	String Line4 = excel.getLine4(dataRow);
	String City = excel.getCity(dataRow);
	int PinCode = excel.getPinCode(dataRow);
	int mobile_Isd = excel.getmobile_Isd(dataRow);
	public static long mobile_NUmber = excel.getmobile_NUmber(dataRow);
	String Email_Id = excel.getEmail_Id(dataRow);
	int Account_No = excel.getAccount_No(dataRow);
	String IFSC = excel.getIFSC(dataRow);
	String BankAccount = excel.getBankAccount(dataRow);
	String IncomeRange = excel.getIncomeRange(dataRow);
	String PanCardNo = excel.getPanCardNo(dataRow);
	String POI = excel.getPOI(dataRow);
	String POA = excel.getPOA(dataRow);
	String Authsignatory_Name = excel.getAuthsignatory_Name(dataRow);
	String Authorized_Representative_Name = excel.getAuthorized_Representative_Name(dataRow);
	String CIN_Number = excel.getCIN_Number(dataRow);
	String GSTIN_Number = excel.getGSTIN_Number(dataRow);
	String SEBI_Registration_Number = excel.getSEBI_Registration_Number(dataRow);
	String CM_ID = excel.getCM_ID(dataRow);
	int netWorth = excel.getnetWorth(dataRow);
	String nominee_name = excel.getnominee_name(dataRow);;
	String nominee_pan_no = excel.getnominee_pan_no(dataRow);
	String years = excel.getnominee_years(dataRow);
	int Month = excel.getnominee_Month(dataRow);
	int Date = excel.getnominee_Date(dataRow);
	String nominee_address = excel.getnominee_address(dataRow);;
	String nominee_relation = excel.getnominee_relation(dataRow);;

	public Client_Account_opening_For_RP(WebDriver driver, WebDriverWait Wait) {

		this.driver = driver;
		this.Wait = Wait;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//body/div[@class='page-container']/div[@class='page-sidebar-wrapper ng-scope']/div[@class='page-sidebar navbar-collapse collapse ng-scope']/ul[@class='page-sidebar-menu ng-scope']/li[2]/a[1]")
	WebElement Client;

	@FindBy(xpath = "//span[normalize-space()='Account Opening']")
	WebElement Account_Opening;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New;

	@FindBy(xpath = "(//span[@class='box'])[1]")
	WebElement Choice;

	@FindBy(xpath = "//input[@name='clientid']")
	WebElement clientid;

	@FindBy(xpath = "//input[@id='formNo']")
	WebElement formNo;

	@FindBy(xpath = "//input[@name='holder_Name']")
	WebElement Client_Name;

	@FindBy(xpath = "//button[@data-id='ClientSubTypeSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement Client_Sub_Type_checkBox;

	@FindBy(xpath = "//select[@id='ClientStatusSelectionCombobox']")
	WebElement Client_Type_btn;

	@FindBy(xpath = "//div[@class='tab-content']//li[2]//a[1]")
	WebElement Individual_Sub_Type;

	@FindBy(xpath = "//div[@class='tab-content']//li[3]//a[1]")
	WebElement Eligible_Foreign_Entities_Sub_Type;

	@FindBy(xpath = "//div[@class='tab-content']//li[4]//a[1]")
	WebElement Private_Trust_Sub_Type;

	@FindBy(xpath = "//div[@class='tab-content']//li[5]//a[1]")
	WebElement FARMER_Sub_Type;

	@FindBy(xpath = "//select[@ng-model='vm.CreateClientMaster.stmt_frq' and contains(@class, 'form-control') and @ng-disabled='vm.CanAuthorise']")
	WebElement Statement_Frequency;

	@FindBy(xpath = "//select[contains(@class, 'form-control') and contains(@class, 'ng-pristine') and @ng-model='vm.CreateClientMaster.statementtyp']")
	WebElement Statement_Type;

	@FindBy(xpath = "//input[@name='cinorllpin']")
	WebElement CIN_Number_Txt;

	@FindBy(xpath = "//input[@name='gstnNo']")
	WebElement GSTN_GSTIN_Number_txt;
//input[@name='sebiRegNo']
	// label[normalize-space()='SEBI Registration Number']
	@FindBy(xpath = "//input[@name='sebiRegNo']")
	WebElement SEBI_Registration_Number_txt;

	@FindBy(xpath = "//input[@name='sebiregdate']")
	WebElement sebiregdate;

	@FindBy(xpath = "//td[@class='today active start-date active end-date available']")
	WebElement sebiregdate_Present;

	@FindBy(xpath = "//button[@id='openPick']")
	WebElement openPick;

	@FindBy(xpath = "//div[contains(@class,'modal-body')]//input[contains(@placeholder,'Search...')]")
	WebElement Search_txt;

	@FindBy(xpath = "//button[contains(@ng-click,'vm.GetDetails()')]")
	WebElement Search_bttn;

	@FindBy(xpath = "(//button[contains(@ng-click,'grid.appScope.selectItem(row.entity)')][normalize-space()='Select'])[1]")
	WebElement Select_bttn;

	@FindBy(xpath = "(//a[normalize-space()='Address'])[1]")
	WebElement Address;

	@FindBy(xpath = "(//input[@id='Address1'])[1]")
	WebElement Address1;

	@FindBy(xpath = "(//input[@name='address2'])[1]")
	WebElement address2;

	@FindBy(xpath = "(//input[@name='address3'])[1]")
	WebElement address3;
	@FindBy(xpath = "(//input[@name='address4'])[1]")
	WebElement address4;
	@FindBy(xpath = "(//input[@name='address5'])[1]")
	WebElement City_Text;

	@FindBy(xpath = " (//input[@name='PerPIN'])[1]")
	WebElement PinCode_Text;

	@FindBy(xpath = "(//input[@name='mobile1_Isd'])[1]")
	WebElement mobile1_Isd;
	@FindBy(xpath = "(//input[@name='mobile_1'])[1]")
	WebElement mobile_No;
	@FindBy(xpath = "(//input[@name='email1'])[1]")
	WebElement Email;

	@FindBy(xpath = "(//a[normalize-space()='Bank Details'])[1]")
	WebElement Bank_Details;

	@FindBy(xpath = "(//a[normalize-space()='Correspondence Address'])[1]")
	WebElement Correspondence;

	@FindBy(xpath = "//label[@for='EditClient_SameAddress']//span[@class='box']")
	WebElement Same_as_Permanent_Address;

	@FindBy(xpath = "(//input[@id='bank_Account_No'])[1]")
	WebElement bank_Account_No;

	@FindBy(xpath = "(//input[@name='ifsc'])[1]")
	WebElement ifsc_No;
	//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']
	//button[@data-id='MicrSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']
	@FindBy(xpath = "//button[@data-id='MicrSelectionCombobox']//span[@class='filter-option pull-left'][normalize-space()='NOTHING SELECTED']")
	WebElement MICR;

	@FindBy(xpath = "//div[@class='tab-pane ng-scope active']//li[2]//a[1]")
	WebElement MICR_Code;

	@FindBy(xpath = " (//select[@id='BankAccTypeSelectionCombobox'])[1]")
	WebElement BankAccType;

	@FindBy(xpath = "(//select[@id='IncomeRangeSelectionCombobox'])[1]")
	WebElement IncomeRangeSelection;

	@FindBy(xpath = "//input[@name='netWorth']")
	WebElement netWorth_txt;

	@FindBy(xpath = "//a[normalize-space()='Documents']")
	WebElement Documents;

	@FindBy(xpath = "(//input[@id='PanNo'])[1]")
	WebElement PanNo;

	@FindBy(xpath = "//input[@id='Holder_Dob']")
	WebElement Incorporation_Date;

	@FindBy(xpath = "//td[@class='today active start-date active end-date available']")
	WebElement Today_dates;
	// (//td[@class='today weekend active start-date active end-date available'])[1]
	// td[@class='today weekend active start-date active end-date available']
	@FindBy(xpath = "//td[@class='today weekend active start-date active end-date available']")
	WebElement WeekEnd_Date;

	@FindBy(xpath = "(//select[@id='POASelectionCombobox'])[1]")
	WebElement POI_Documents;

	@FindBy(xpath = "(//select[@id='POISelectionCombobox'])[1]")
	WebElement POASelection;

	@FindBy(xpath = "//input[@id='tick_Checked']")
	WebElement Authorized_Signatory_Check_box;

	@FindBy(xpath = "(//a[normalize-space()='Authorized Signatory'])[1]")
	WebElement Authorized_Signatory;

	@FindBy(xpath = "(//input[@name='authsignatoryname'])[1]")
	WebElement authsignatoryname;

	@FindBy(xpath = "//a[normalize-space()='Authorized Representative']")
	WebElement Representative;

	@FindBy(xpath = "//input[@name='authrepresentname']")
	WebElement Authorized_Representative;

	@FindBy(xpath = "//a[normalize-space()='Nominee Detail']")
	WebElement Nominee_Detail_Tab;

	@FindBy(xpath = "//input[@name='nominee_name']")
	WebElement nominee_name_txt;

	@FindBy(xpath = "//input[@name='nominee_pan_no']")
	WebElement nominee_pan_no_txt;

	@FindBy(xpath = "//input[@id='nominee_dobBirth']")
	WebElement nominee_dobBirth_txt;

	@FindBy(xpath = "//div[@class='calendar left single']//select[@class='yearselect']")
	WebElement yearselect;
	// div[@class='calendar left single']//select[@class='monthselect']
	// (//select[@class='monthselect'])[1]
	@FindBy(xpath = "(//select[@class='monthselect'])[1]")
	WebElement monthselect;

	@FindBy(xpath = "//input[@id='nominee_address']")
	WebElement nominee_address_txt;

	@FindBy(xpath = "//input[@name='nominee_relation']")
	WebElement nominee_relation_txt;

	@FindBy(xpath = "(//button[@ng-show='!ClientForm.$invalid'])[1]")
	WebElement Verify_Button;

	@FindBy(xpath = "(//i[@class='fa fa-save'])[1]")
	WebElement Save_Button;

	public void Client_Account_opening() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Client)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Account_Opening)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(New)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Choice)).click();

		clientid.click();
		Wait.until(ExpectedConditions.elementToBeClickable(clientid)).sendKeys(String.valueOf(clientid_Num));

		formNo.sendKeys(Keys.ENTER);
		Wait.until(ExpectedConditions.elementToBeClickable(formNo)).sendKeys(FormID);
		formNo.click();

		Client_Name.sendKeys(Keys.ENTER);
		Client_Name.sendKeys(Client_holder_Name);

		Select Sa = new Select(Client_Type_btn);
		Sa.selectByContainsVisibleText(Client_Type);

		Wait.until(ExpectedConditions.elementToBeClickable(Client_Sub_Type_checkBox)).click();

		if (Client_Sub_Type.equals("Individual")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Individual_Sub_Type)).sendKeys(Keys.ENTER);
		} else if (Client_Sub_Type.equals("Eligible Foreign Entities (EFEs)")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Eligible_Foreign_Entities_Sub_Type))
					.sendKeys(Keys.ENTER);
		} else if (Client_Sub_Type.equals("Private Trust / Trustee")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Private_Trust_Sub_Type)).sendKeys(Keys.ENTER);
		} else if (Client_Sub_Type.equals("FARMER")) {
			Wait.until(ExpectedConditions.elementToBeClickable(FARMER_Sub_Type)).sendKeys(Keys.ENTER);
		} else {
			System.out.println("Client_Sub_Type is not valid");
		}

		Select Statet = new Select(Statement_Frequency);
		Statet.selectByContainsVisibleText(Frequency);

		Select D = new Select(Statement_Type);
		D.selectByContainsVisibleText(Statement);

		Address.click();

		Address1.sendKeys(Line1);
		address2.sendKeys(Line2);
		address3.sendKeys(Line3);
		address4.sendKeys(Line4);
		City_Text.sendKeys(City);
		PinCode_Text.sendKeys(String.valueOf(PinCode));

		mobile1_Isd.sendKeys(String.valueOf(mobile_Isd));

		mobile_No.sendKeys(String.valueOf(mobile_NUmber));
		Email.sendKeys(Email_Id);

		Correspondence.click();

		Same_as_Permanent_Address.click();

		Bank_Details.click();

		bank_Account_No.sendKeys(String.valueOf(Account_No));

		ifsc_No.click();
		ifsc_No.sendKeys(String.valueOf(IFSC));
		ifsc_No.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(MICR)).click();
		Wait.until(ExpectedConditions.elementToBeClickable(MICR_Code)).click();

		Select S = new Select(BankAccType);
		S.selectByContainsVisibleText(BankAccount);

		Select A = new Select(IncomeRangeSelection);
		A.selectByContainsVisibleText(IncomeRange);

		Documents.click();

		Wait.until(ExpectedConditions.elementToBeClickable(PanNo)).click();
		Wait.until(ExpectedConditions.elementToBeClickable(PanNo)).sendKeys(PanCardNo);

		Select B = new Select(POI_Documents);
		B.selectByContainsVisibleText(POI);

		Select C = new Select(POASelection);
		C.selectByContainsVisibleText(POA);

		Authorized_Signatory.click();

		authsignatoryname.sendKeys(Authsignatory_Name);

		Representative.click();

		Authorized_Representative.sendKeys(Authorized_Representative_Name);

		Nominee_Detail_Tab.click();

		if (Client_Sub_Type.equals("Individual") || Client_Sub_Type.equals("FARMER")) {
			nominee_name_txt.sendKeys(nominee_name);

			nominee_pan_no_txt.sendKeys(nominee_pan_no);

			nominee_dobBirth_txt.click();

			Select y = new Select(yearselect);
			y.selectByValue(years);
			Thread.sleep(2000);

			Select M = new Select(monthselect);
			Thread.sleep(2000);
			M.selectByIndex(Month);
			// M.selectByIndex(10);

			/*
			 * Select select = new Select(monthselect); List<WebElement> options =
			 * select.getOptions();
			 * 
			 * for (WebElement option : options) { System.out.println("Value: " +
			 * option.getAttribute("value") + " | Text: " + option.getText()); //
			 * option.sendKeys(Month);
			 * 
			 * if (option.getText() == Month) {
			 * 
			 * } else { System.out.println("Month is not available"); }
			 * 
			 * }
			 */

			WebElement DOB = driver.findElement(By.xpath("(//td[contains(text(),'" + Date + "')])[1]"));
			// td[@class='available'][normalize-space()='" + Date + "'])
			List<WebElement> nominee_dobBirth = driver
					.findElements(By.xpath("(//td[contains(text(),'" + Date + "')])[1]"));
			try {
				if (nominee_dobBirth.contains(DOB)) {
					// if (valueElements.size()> 0)
					Thread.sleep(2000);
					Wait.until(ExpectedConditions.elementToBeClickable(DOB)).click();
				} else {
					System.out.println("provided DOB is not available");
				}
			} catch (NoSuchElementException e) {
				System.out.println("DOB not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for DOB: " + e.getMessage());
			}

			nominee_address_txt.sendKeys(nominee_address);

			nominee_relation_txt.sendKeys(nominee_relation);
		} else {
			System.out.println("Client_Sub_Type is not mandetary");
		}
		try {
		if (Verify_Button.isEnabled()) {
			Verify_Button.click();
		} else {
			System.out.println("Verify_Button is not enable");
		}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Verify_Button click...");
			js.executeScript("arguments[0].click();", Verify_Button);
		} catch (NoSuchElementException e) {
			System.out.println("Verify_Button not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Verify_Button: " + e.getMessage());
		}
		try {
		if (Save_Button.isDisplayed()) {
			Save_Button.click();
		} else {
			System.out.println("Save_Button is not Visible ");
		}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying Save_Button click...");
			js.executeScript("arguments[0].click();", Save_Button);
		} catch (NoSuchElementException e) {
			System.out.println("Save_Button not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for Save_Button: " + e.getMessage());
		}

	}

	public void Account_opening_for_CM() throws InterruptedException {
		Wait.until(ExpectedConditions.elementToBeClickable(Client)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Account_Opening)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(New)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Choice)).click();

		clientid.click();
		Wait.until(ExpectedConditions.elementToBeClickable(clientid)).sendKeys(String.valueOf(clientid_Num));

		formNo.sendKeys(Keys.ENTER);
		Wait.until(ExpectedConditions.elementToBeClickable(formNo)).sendKeys(FormID);
		formNo.click();

		Client_Name.sendKeys(Keys.ENTER);
		Client_Name.sendKeys(Client_holder_Name);

		Select Sa = new Select(Client_Type_btn);
		Sa.selectByContainsVisibleText(Client_Type);

		Wait.until(ExpectedConditions.elementToBeClickable(Client_Sub_Type_checkBox)).click();
		Thread.sleep(3000);
		if (Client_Sub_Type.equals("Clearing Member")) {
			try {
				Wait.until(ExpectedConditions.elementToBeClickable(Individual_Sub_Type)).sendKeys(Keys.ENTER);
			} catch (ElementClickInterceptedException e) {
				System.out.println("Normal click failed, trying JavaScript Transaction_btn click...");
				js.executeScript("arguments[0].click();", Individual_Sub_Type);
			} catch (NoSuchElementException e) {
				System.out.println("Transaction_Btn not found: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error for Transaction_Btn: " + e.getMessage());
			}

		} else if (Client_Sub_Type.equals("CM – Client Margin Pledge Account")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Eligible_Foreign_Entities_Sub_Type))
					.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Client_Sub_Type is not valid");
		}

		Select Statet = new Select(Statement_Frequency);
		Statet.selectByContainsVisibleText(Frequency);

		Select D = new Select(Statement_Type);
		D.selectByContainsVisibleText(Statement);

		CIN_Number_Txt.click();
		CIN_Number_Txt.sendKeys(CIN_Number);

		GSTN_GSTIN_Number_txt.click();
		GSTN_GSTIN_Number_txt.sendKeys(GSTIN_Number);

		SEBI_Registration_Number_txt.click();
		SEBI_Registration_Number_txt.sendKeys(SEBI_Registration_Number);

		sebiregdate.click();

		sebiregdate_Present.click();

		openPick.click();

		Search_txt.sendKeys(CM_ID);

		Search_bttn.click();

		Select_bttn.click();

		Address.click();

		Address1.sendKeys(Line1);
		address2.sendKeys(Line2);
		address3.sendKeys(Line3);
		address4.sendKeys(Line4);
		City_Text.sendKeys(City);
		PinCode_Text.sendKeys(String.valueOf(PinCode));

		mobile1_Isd.sendKeys(String.valueOf(mobile_Isd));

		mobile_No.click();
		mobile_No.sendKeys(String.valueOf(mobile_NUmber));

		Email.sendKeys(Email_Id);

		Correspondence.click();

		Same_as_Permanent_Address.click();

		Bank_Details.click();

		bank_Account_No.sendKeys(String.valueOf(Account_No));

		ifsc_No.click();
		ifsc_No.sendKeys(String.valueOf(IFSC));
		ifsc_No.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		ifsc_No.clear();
		ifsc_No.click();
		ifsc_No.sendKeys(String.valueOf(IFSC));
		ifsc_No.sendKeys(Keys.TAB);

		Wait.until(ExpectedConditions.elementToBeClickable(MICR)).click();
		MICR_Code.click();
		// Wait.until(ExpectedConditions.elementToBeClickable(MICR_Code)).click();

		Select S = new Select(BankAccType);
		S.selectByContainsVisibleText(BankAccount);

		/*
		 * Select A = new Select(IncomeRangeSelection);
		 * A.selectByContainsVisibleText(IncomeRange);
		 */

		// netWorth_txt.click();
		netWorth_txt.sendKeys(String.valueOf(netWorth));

		Documents.click();

		Wait.until(ExpectedConditions.elementToBeClickable(PanNo)).click();
		Wait.until(ExpectedConditions.elementToBeClickable(PanNo)).sendKeys(PanCardNo);

		Incorporation_Date.click();

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

		Select B = new Select(POI_Documents);
		B.selectByContainsVisibleText(POI);

		Select C = new Select(POASelection);
		C.selectByContainsVisibleText(POA);

		Authorized_Signatory.click();
		Authorized_Signatory_Check_box.click();
		authsignatoryname.sendKeys(Authsignatory_Name);

		Representative.click();

		Authorized_Representative.sendKeys(Authorized_Representative_Name);

		try {
			if (Verify_Button.isEnabled()) {
				Verify_Button.click();
			} else {
				System.out.println("Verify_Button is not enable");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Verify_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

		try {
			if (Save_Button.isDisplayed()) {
				Save_Button.click();
			} else {
				System.out.println("Save_Button is not Visible ");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}
	}

	public void Account_opening_for_TM() throws InterruptedException {

		Wait.until(ExpectedConditions.elementToBeClickable(Client)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Account_Opening)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(New)).click();

		Wait.until(ExpectedConditions.elementToBeClickable(Choice)).click();

		clientid.click();
		Wait.until(ExpectedConditions.elementToBeClickable(clientid)).sendKeys(String.valueOf(clientid_Num));

		formNo.sendKeys(Keys.ENTER);
		Wait.until(ExpectedConditions.elementToBeClickable(formNo)).sendKeys(FormID);
		formNo.click();

		Client_Name.sendKeys(Keys.ENTER);
		Client_Name.sendKeys(Client_holder_Name);

		Select Sa = new Select(Client_Type_btn);
		Sa.selectByContainsVisibleText(Client_Type);

		Wait.until(ExpectedConditions.elementToBeClickable(Client_Sub_Type_checkBox)).click();
		Thread.sleep(3000);
		if (Client_Sub_Type.equals("Trading Member")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Individual_Sub_Type)).sendKeys(Keys.ENTER);
		} else if (Client_Sub_Type.equals("TM – Client Margin Pledge Account")) {
			Wait.until(ExpectedConditions.elementToBeClickable(Eligible_Foreign_Entities_Sub_Type))
					.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Client_Sub_Type is not valid");
		}

		Select Statet = new Select(Statement_Frequency);
		Statet.selectByContainsVisibleText(Frequency);

		Select D = new Select(Statement_Type);
		D.selectByContainsVisibleText(Statement);

		/*
		 * CIN_Number_Txt.click(); CIN_Number_Txt.sendKeys(CIN_Number);
		 */

		GSTN_GSTIN_Number_txt.click();
		GSTN_GSTIN_Number_txt.sendKeys(GSTIN_Number);

		/*
		 * SEBI_Registration_Number_txt.click();
		 * SEBI_Registration_Number_txt.sendKeys(SEBI_Registration_Number);
		 * 
		 * sebiregdate.click();
		 * 
		 * sebiregdate_Present.click();
		 * 
		 * openPick.click();
		 * 
		 * Search_txt.sendKeys("scscv");
		 * 
		 * Search_bttn.click();
		 * 
		 * Select_bttn.click();
		 */

		Address.click();

		Address1.sendKeys(Line1);
		address2.sendKeys(Line2);
		address3.sendKeys(Line3);
		address4.sendKeys(Line4);
		City_Text.sendKeys(City);
		PinCode_Text.sendKeys(String.valueOf(PinCode));

		mobile1_Isd.sendKeys(String.valueOf(mobile_Isd));

		mobile_No.sendKeys(String.valueOf(mobile_NUmber));
		Email.sendKeys(Email_Id);

		Correspondence.click();

		Same_as_Permanent_Address.click();

		Bank_Details.click();

		bank_Account_No.sendKeys(String.valueOf(Account_No));

		ifsc_No.click();
		ifsc_No.sendKeys(String.valueOf(IFSC));
		ifsc_No.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		ifsc_No.clear();
		ifsc_No.click();
		ifsc_No.sendKeys(String.valueOf(IFSC));
		ifsc_No.sendKeys(Keys.TAB);

		Wait.until(ExpectedConditions.elementToBeClickable(MICR)).click();
		Wait.until(ExpectedConditions.elementToBeClickable(MICR_Code)).click();

		Select S = new Select(BankAccType);
		S.selectByContainsVisibleText(BankAccount);

		netWorth_txt.sendKeys(String.valueOf(netWorth));
		/*
		 * Select A = new Select(IncomeRangeSelection);
		 * A.selectByContainsVisibleText(IncomeRange);
		 */

		Documents.click();

		Wait.until(ExpectedConditions.elementToBeClickable(PanNo)).click();
		Wait.until(ExpectedConditions.elementToBeClickable(PanNo)).sendKeys(PanCardNo);

		Incorporation_Date.click();

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

		Select B = new Select(POI_Documents);
		B.selectByContainsVisibleText(POI);

		Select C = new Select(POASelection);
		C.selectByContainsVisibleText(POA);

		Authorized_Signatory.click();
		Authorized_Signatory_Check_box.click();
		authsignatoryname.sendKeys(Authsignatory_Name);

		Representative.click();

		Authorized_Representative.sendKeys(Authorized_Representative_Name);
		try {
			if (Verify_Button.isEnabled()) {
				Verify_Button.click();
			} else {
				System.out.println("Verify_Button is not enable");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Verify_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

		try {
			if (Save_Button.isDisplayed()) {
				Save_Button.click();
			} else {
				System.out.println("Save_Button is not Visible ");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Normal click failed, trying JavaScript save_btn click...");
			js.executeScript("arguments[0].click();", Save_Button);
		} catch (NoSuchElementException e) {
			System.out.println("save_btn not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error for save_btn: " + e.getMessage());
		}

	}
}
