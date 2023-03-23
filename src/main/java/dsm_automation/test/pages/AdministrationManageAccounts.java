package dsm_automation.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dsm_automation.test.methods.commonpageActions;
import dsm_automation.test.util.LoadDriver;
import dsm_automation.test.util.TakeScreenShots;


public class AdministrationManageAccounts extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public AdministrationManageAccounts(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(how = How.XPATH, using = "//a[contains(text(),'Administration')]")
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/a")	
	private static WebElement Administration_Link;
	
//	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Accounts')]")
//	private static WebElement Manage_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[3]/a")
	private static WebElement Manage_Link;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-id-1\"]")
	private static WebElement Accounts_Link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='user_name']")
	private static WebElement user_name;
	
	@FindBy(how = How.XPATH, using = "//input[@name='org_id']")
	private static WebElement org_id;
	
	@FindBy(how = How.XPATH, using = "//input[@name='first_name']")
	private static WebElement first_name;
	
	@FindBy(how = How.XPATH, using = "//input[@name='middle_name']")
	private static WebElement middle_name;
	
	@FindBy(how = How.XPATH, using = "//input[@name='last_name']")
	private static WebElement last_name;
	
	@FindBy(how = How.XPATH, using = "//input[@name='ext_mail']")
	private static WebElement ext_mail;
	
	@FindBy(how = How.XPATH, using = "//input[@name='account_title']")
	private static WebElement account_title;
	
	@FindBy(how = How.XPATH, using = "//input[@name='department']")
	private static WebElement department;
	
	@FindBy(how = How.XPATH, using = "//input[@name='telephone']")
	private static WebElement telephone;
	
	@FindBy(how = How.XPATH, using = "//input[@name='mobile']")
	private static WebElement mobile;
	
	@FindBy(how = How.XPATH, using = "//select[@id='domain_select']")
	private static WebElement domain_select;
	
	@FindBy(how = How.XPATH, using = "//select[@id='facility_select']")
	private static WebElement facility_select;
	
	
	// Test AdministrationManageAccounts form
	public static void AdministrationManageAccounts_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Administration Manage Accounts Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		System.out.println ("Before Admin link Click");
		Actions actions = new Actions(driver);
		actions.moveToElement(Administration_Link);		
		
  		//this method is for to click any link- in this case it is clicking on Administration link
   		commonpageActions.click(driver, Administration_Link , 360);
   		System.out.println ("After Admin link Click");
   		  
   		//this method is for to click any link- in this case it is clicking on Administration link
 		 // commonpageActions.dropDownSelect(driver, Administration_Link , 360);
 		  
 		//this method is for to click any link- in this case it is clicking on Administration link
 		 // commonpageActions.mouseOverElement(driver, Administration_Link , 360);
			 	
 		  System.out.println ("Before Manage Click");
				//this method is for to click any link- in this case it is clicking on Manage link				
 		  		//actions.moveToElement(Manage_Link);	
 		  		//actions.click().build().perform();
 		  		commonpageActions.click(driver, Manage_Link , 360);
				System.out.println ("After Manage Click");
				
					//this method is for to click any link- in this case it is clicking on Accounts link
			  		commonpageActions.click(driver, Accounts_Link , 360);
				
				
                               //this method will read the data from excel sheet and enter data in a AdministrationManageAccounts form 
								commonpageActions.AdminManageAccounts(excelFilePath, sheetName, user_name, org_id, first_name, middle_name, last_name, 
										ext_mail, account_title, department, telephone, mobile, domain_select, facility_select );
								
					TakeScreenShots.TakesScreenshot(facility_select);
//					
				
				System.out.println ("~~~~~~~~~~~~~~~~Administration Manage Accounts_test is complete~~~~~~~~~~~~~~~~~");			
			
		}
	
	}
