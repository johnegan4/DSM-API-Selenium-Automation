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


public class AdminManageFacilities extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public AdminManageFacilities(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[5]/a")
	private static WebElement Administration_Link;
	
	
		
//	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Facilities')]")
//	private static WebElement Facilities_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[5]/a")
	private static WebElement Facilities_Link;	
		
	@FindBy(how = How.XPATH, using = "//*[@id='create_link']")
	private static WebElement create_link;
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='fac_name']")
	private static WebElement fac_name;
	
	@FindBy(how = How.XPATH, using = "//input[@name='address_line1']")
	private static WebElement address_line1;
	
	@FindBy(how = How.XPATH, using = "//input[@name='address_line2']")
	private static WebElement address_line2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"city-field\"]")
	private static WebElement city_field;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"state-field\"]")
	private static WebElement state_field;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip-field\"]")
	private static WebElement zip_field;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"country-field\"]")
	private static WebElement country_field;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"npi-field\"]")
	private static WebElement npi_field;

	@FindBy(how = How.XPATH, using = "//*[@id=\"visn-field\"]")
	private static WebElement VISN_field;



	@FindBy(how = How.XPATH, using = "//*[@id=\"create\"]/button")
	private static WebElement Submit;

	//*[@id="create"]/button
	
	@FindBy(how = How.XPATH, using = "//*[@id='active']")
	private static WebElement active;	
	

	
	// Test AdminManageFacilities form
	public static void AdminManageFacilities_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** AdminManageFacilities Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		 
		commonpageActions.waitForPageToLoad();
		
				//this method is for to click any link- in this case it is mouseoverelement on Administration link
		//		commonpageActions.mouseOverElement(Administration_Link);
				//this method is for to click any link- in this case it is click on Administration link
//				commonpageActions.click(driver, Administration_Link, 300);
								 	
					//this method is for to click any link- in this case it is clicking on Create Facility link
			  		commonpageActions.click(driver, create_link , 360);			  		
			    			  						
                               //this method will read the data from excel sheet and enter data in a AdminManageFacilities form 
								commonpageActions.AdminManageFacilities(excelFilePath, sheetName, fac_name, address_line1, address_line2, 
										city_field, state_field, zip_field, country_field, npi_field, VISN_field);

								
								//this method is for to click any link- in this case it is clicking on Submit link
					  			commonpageActions.click(driver, Submit , 360);
					 						  			
//		TakeScreenShots.TakesScreenshot(Submit);
				
		System.out.println ("~~~~~~~~~~~~~~~~AdminManageFacilities_test is complete~~~~~~~~~~~~~~~~~");			
			
		}
	}

//```````````````````````Other Methods````````````````````````````````````````````````````````````````````````````````````````````````````

//this method is for to click any link- in this case it is clicking on Facilities link
//commonpageActions.click(driver, Facilities_Link , 360);
