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

//
	public class AdminAccountRequests extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public AdminAccountRequests(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(how = How.XPATH, using ="//*[contains(text(),'Administration')]")
	private static WebElement Administration_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Account Requests')]")
 	private static WebElement Requests_Link;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Approved')]")
	private static WebElement approved_link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pending Approval')]")
	private static WebElement pending_link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Denied')]")
	private static WebElement denied_link;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Search']")
	private static WebElement active_account_table_filter;
	
		
	
 	// Test AdminApplicationRequests form
	public static void AdminAccountRequests_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** AdminAccountRequests Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		
		
		//this method is for to click any link- in this case it is click on Administration link
		commonpageActions.click(driver, Administration_Link, 360);
		
		//this method is for to click any link- in this case it is mouse over element on Administration link
//		commonpageActions.mouseOverElement(Administration_Link);
		
		//this method is for to click any link- in this case it is dropDownSelect on Administration link
//		commonpageActions.dropDownSelect(driver, requests_link); 
		
		//this method is for to click any link- in this case it is clicking on Account Requests link
		commonpageActions.click(driver, Requests_Link , 360);
			
			
					//this method is for to click any link- in this case it is clicking on Approved link
					commonpageActions.click(driver, approved_link , 360);
						
					TakeScreenShots.TakesScreenshot(approved_link);
                              
					System.out.println ("~~~~~~~~~~~~~~~~AdminAccountRequests_test is complete~~~~~~~~~~~~~~~~~");			
			
		}
	}

//```````````````````````Other Methods````````````````````````````````````````````````````````````````````````````````````````````````````
				
						
//this method is for to click any link- in this case it is clicking on Requests link
//commonpageActions.click(driver, requests_link , 360);
			 	
//this method is for to click any link- in this case it is clicking on Pending link
//commonpageActions.click(driver, pending_link , 360);		
						
//this method is for to click any link- in this case it is clicking on Denied link
//commonpageActions.click(driver, denied_link, 360);


	
				
