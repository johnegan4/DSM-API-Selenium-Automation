package dsm_automation.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dsm_automation.test.methods.commonpageActions;
import dsm_automation.test.util.LoadDriver;
import dsm_automation.test.util.TakeScreenShots;


public class UserSettingsAppList extends LoadDriver {
	 
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public UserSettingsAppList(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'User Settings')]")
	private static WebElement UserSettings_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[5]/a")
	private static WebElement application_list_Link;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"application_table\"]/tbody/tr[1]/td[2]/div/a")
	private static WebElement Edit_button;
		 
	
		
	@FindBy(how = How.XPATH, using = "//input[@id=\'ws41681\']")
	private static WebElement manage_checkbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id=\'ws41682\']")
	private static WebElement retrieve_checkbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id=\'ws41683\']")
	private static WebElement send_checkbox;
	
	
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"appForm\"]/div[2]/input")
	private static WebElement save_button;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='application_table_filter']")
	private static WebElement application_table_filter;
	
//	@FindBy(how = How.XPATH, using = "//input[@name='app_name']")
//	private static WebElement app_name;
	
	@FindBy(how = How.XPATH, using = "//*[@id='app_name']")
	private static WebElement app_name;
		
	
	// Test User Settings App List form
		public static void UserSettingsAppList_validation(String excelFilePath, String sheetName) throws Exception {
			System.out.println("***************** User Settings App List Test_Validation- in validation *****************");
			Thread.sleep(200);
			
			PageFactory.initElements(driver, commonpageActions.class);
			
				//this will wait for page to load
				commonpageActions.waitForPageToLoad();
			   				
					//this method is for to click any link- in this case it is clicking on User Settings link 
		   			commonpageActions.click(driver, UserSettings_Link , 360);
		   			
		   		    //this method is for to click any link- in this case it is clicking on Edit link
					commonpageActions.click(driver, Edit_button , 360);
					
					//this method is for to click any link- in this case it is clicking on Manage Check box link
					commonpageActions.click(driver, manage_checkbox , 360);
					//this method is for to click any link- in this case it is clicking on Manage Check box link
					commonpageActions.click(driver, retrieve_checkbox , 360);
					//this method is for to click any link- in this case it is clicking on Manage Check box link
					commonpageActions.click(driver, send_checkbox , 360);
					
					//this method is for to click any link- in this case it is clicking on Save button
					commonpageActions.click(driver, save_button , 360);
		   					   			
			        
					TakeScreenShots.TakesScreenshot(save_button);		 
					  
					System.out.println ("~~~~~~~~~~~~~~~~  User Settings App List_test is complete~~~~~~~~~~~~~~~~~");		
					  
   }
        }
//this method is for to click any button in this case it is clicking on Find Application Search Box
//commonpageActions.click(driver, application_table_filter , 360);
//this method is for to click any link- in this case it is clicking on User Settings App List link
//commonpageActions.click(driver, application_list_Link , 360);


