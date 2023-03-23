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

public class ReportHISP extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportHISP(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//~~~~~Elements defined~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'HISP')]")
	private static WebElement HISP_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id='selected_domain']")
	private static WebElement HISP;
	
	@FindBy(how = How.XPATH, using = "//input[@name='start_date']")
	private static WebElement start_date;
	
	@FindBy(how = How.XPATH, using = "//input[@name='end_date']")
	private static WebElement end_date;
	
	@FindBy(how = How.XPATH, using = "//*[@id='filter_button']")
	private static WebElement filter_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id='clear_button']")
	private static WebElement clear_button;
	
	 
	
	 	
// ~~~~~~~~~~Test Report HISP form~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void ReportHISP_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** HISP Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		
		
			//this method is for to click any link- in this case it is clicking on Reports link 
			commonpageActions.click(driver, Reports_Link , 360);
   		
			//this method is for to click any link- in this case it is clicking on HISP link
			commonpageActions.click(driver, HISP_Link , 360);	
								
					//this method is for to read the data from excel sheet and enter data in a HISP form 
			commonpageActions.ReportHISP(excelFilePath, sheetName, HISP, start_date, end_date );						
				
			System.out.println ("~~~~~~~~~~~~~~~~Reports HISP_test is complete~~~~~~~~~~~~~~~~~");
   } 
        }
//~~~~~~~~~~~More methods, commands...  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//this method is for to click any button in this case it is clicking on Filter button
//commonpageActions.click(driver, filter_button , 360);					

//this method is to take a screenshot of expected results
//TakeScreenShots.TakesScreenshot(filter_button);

//this method is for to click any button in this case it is clicking on Save Report button
//commonpageActions.click(driver, details_link , 360);

//this method is for to click any button in this case it is clicking on Clear button
//commonpageActions.click(driver, clear_button , 360);
				
//Assert.assertEquals("106220",event_ID);

//SoftAssertion.assertAll();

// Verify "User successfully created."				
			
      