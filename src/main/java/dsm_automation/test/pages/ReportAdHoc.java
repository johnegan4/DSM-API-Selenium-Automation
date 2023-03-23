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

public class ReportAdHoc extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportAdHoc(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//~~~~~Elements defined~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Ad-hoc Reports')]")
	private static WebElement ReportAdHoc_Link;
	
	
	
	 	
// ~~~~~~~~~~Test Report AdHoc form~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void ReportAdHoc_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** AdHoc Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
				//this method is for to click any link- in this case it is clicking on Reports link 
				commonpageActions.click(driver, Reports_Link , 360);
   		
   				//this method is for to click any link- in this case it is clicking on AdHoc link
				commonpageActions.click(driver, ReportAdHoc_Link , 360);
								
				TakeScreenShots.TakesScreenshot(ReportAdHoc_Link);			
				
				System.out.println ("~~~~~~~~~~~~~~~~Reports AdHoc_test is complete~~~~~~~~~~~~~~~~~");
				
	} 
	   } 