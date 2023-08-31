package dsm_automation.test.methods;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsm_automation.test.util.LoadDriver;
import dsm_automation.test.util.ReadExcelData;
import dsm_automation.test.util.TakeScreenShots;

import static dsm_automation.test.pages.ReportUserSummary.User_Summary_Link;


public class commonpageActions extends LoadDriver {
    public static JavascriptExecutor js = (JavascriptExecutor) driver;
    public static final Logger logger = LogManager.getLogger(commonpageActions.class);

    public commonpageActions(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    public static class Assert {

        public Assert(WebDriver driver, WebElement user_summary_link, int i) {

        }
    }

    public static void click(WebDriver driver, WebElement link, int Timeouts) throws Exception {
        waitForPageToLoad();
        System.out.println("Link ->" + link.toString());
        new WebDriverWait(driver, Timeouts).
                until(ExpectedConditions.elementToBeClickable
                        (link));
        js.executeScript("arguments[0].click()", link);
        Thread.sleep(5000);
    }

    @SuppressWarnings("deprecation")
    public static void waitforelementToBeClickable(WebElement element) throws Exception {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(2000, TimeUnit.SECONDS)
                .pollingEvery(1000, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @SuppressWarnings("deprecation")
    public static void waitToVerifyPageTitle(String element) throws Exception {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(1000, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.titleContains(element));
    }

    public static void zoomInZoomOut() throws Exception {
        String zoomLevelReduced = "50%";
        js.executeScript("document.body.style.zoom='" + zoomLevelReduced + "'");

    }

    public static void waitForPageToLoad() throws InterruptedException {
        int i = 0;
        while (i != 10) {
            String state = (String) js.executeScript("return document.readyState;");
            System.out.println(state);
            if (state.equals("complete"))
                break;
            else
                Thread.sleep(5000);
            i++;
        }

    }

    //  MOUSE OVER
    public static void mouseOverElement(WebElement element) throws Exception {
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .build();
        Thread.sleep(100);
        mouseOverHome.perform();
        Thread.sleep(5000);
    }

    //  DROPDOWN SELECT
    public static void dropDownSelect(WebElement element) throws Exception {
        Actions builder = new Actions(driver);
        Action dropDownSelect = builder
                .moveToElement(element)
                .build();
        dropDownSelect.perform();
        Thread.sleep(1000);
    }

    public static void dropDownSelect(WebDriver driver, WebElement administration_Link, int i) {

    }


//    ~~~~~~~~~~~~~~~~~~~~~  ADDED BUTTONS  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @FindBy(how = How.XPATH, using = "//*[@id='clear_button']")
    private static WebElement clear_button;

    @FindBy(how = How.XPATH, using = "//*[@id='filter_button']")
    private static WebElement filter_button;


//--- Report Events ====================================================THE START===========================================================================-

    public static void ReportEvents(String excelFilePath, String sheetName, WebElement successful, WebElement event_ID,
                                    WebElement action_ID, WebElement target, WebElement target_type, WebElement acting_user, WebElement acting_type,
                                    WebElement start_date, WebElement end_date) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Get Success
                    successful.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Success"));
                    waitForPageToLoad();


                    System.out.println("After Success");
                }

                // Validate for ID
                if (DSMExcelData.get(String.valueOf(k)).get("ID") != null) {
                    waitForPageToLoad();
                    System.out.println("ID is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("ID"));

                    // Get ID
                    event_ID.sendKeys(DSMExcelData.get(String.valueOf(k)).get("ID"));
                    waitForPageToLoad();

                    System.out.println("After ID");
                }

                // Validate for Action
                if (DSMExcelData.get(String.valueOf(k)).get("Action") != null) {
                    waitForPageToLoad();
                    System.out.println("Action-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Action"));

                    // Get Action
                    action_ID.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Action"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Action");
                }

                // Validate for Target
                if (DSMExcelData.get(String.valueOf(k)).get("Target") != null) {
                    waitForPageToLoad();
                    System.out.println("Target -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Target"));

                    // Get Target
                    target.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Target"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Target ");
                }

                // Validate for Target Type
                if (DSMExcelData.get(String.valueOf(k)).get("Target Type") != null) {
                    waitForPageToLoad();
                    System.out.println("Target Type-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Target Type"));

                    // Get Target Type
                    target_type.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Target Type"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Target Type ");
                }
                // Validate for Actor
                if (DSMExcelData.get(String.valueOf(k)).get("Actor") != null) {
                    waitForPageToLoad();
                    System.out.println("Actor-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Actor"));

                    // Get Actor
                    acting_user.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Actor"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Actor ");
                }
                // Validate for Acting_Type
                if (DSMExcelData.get(String.valueOf(k)).get("Acting Type") != null) {
                    waitForPageToLoad();
                    System.out.println("Acting Type-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Acting Type"));

                    // Get Acting_Type
                    acting_type.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Acting Type"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Acting Type ");
                }
                // Validate for start_date
                if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                    waitForPageToLoad();
                    System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                    // Get start_date
                    start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After start_date ");
                }
                // Validate for end_date
                if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                    waitForPageToLoad();
                    System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                    // Get end_date
                    end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After end_date ");


                    commonpageActions.click(driver, filter_button, 360);

                    TakeScreenShots.TakesScreenshot(filter_button);

                    commonpageActions.click(driver, clear_button, 360);

                }
            }
        }
    }

//-- Report Facility -----------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void ReportFacility(String excelFilePath, String sheetName, WebElement whichfacility,
                                      WebElement start_date, WebElement end_date) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for ReportFacility
                    if (DSMExcelData.get(String.valueOf(k)).get("ReportFacility") != null) {
                        waitForPageToLoad();
                        System.out.println("ReportFacility -Inside->" + DSMExcelData.get(String.valueOf(k)).get("ReportFacility"));


                        // Get ReportFacility
                        whichfacility.sendKeys(DSMExcelData.get(String.valueOf(k)).get("ReportFacility"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After ReportFacility");
                    }
                    // Validate for start_date
                    if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                        waitForPageToLoad();
                        System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                        // Get start_date
                        start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After start_date ");
                    }
                    // Validate for end_date
                    if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                        waitForPageToLoad();
                        System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                        // Get end_date
                        end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After end_date ");


                        commonpageActions.click(driver, filter_button, 360);

                        TakeScreenShots.TakesScreenshot(filter_button);

                        commonpageActions.click(driver, clear_button, 360);

                    }
                }
            }
        }
    }

    //-- Report HISP -----------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void ReportHISP(String excelFilePath, String sheetName, WebElement HISP,
                                  WebElement start_date, WebElement end_date) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for ReportHISP
                    if (DSMExcelData.get(String.valueOf(k)).get("ReportHISP") != null) {
                        waitForPageToLoad();
                        System.out.println("ReportHISP -Inside->" + DSMExcelData.get(String.valueOf(k)).get("ReportHISP"));


                        // Get ReportHISP
                        HISP.sendKeys(DSMExcelData.get(String.valueOf(k)).get("ReportHISP"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After ReportHISP");
                    }
                    // Validate for start_date
                    if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                        waitForPageToLoad();
                        System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                        // Get start_date
                        start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After start_date ");
                    }
                    // Validate for end_date
                    if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                        waitForPageToLoad();
                        System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                        // Get end_date
                        end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After end_date ");


                        commonpageActions.click(driver, filter_button, 360);

                        TakeScreenShots.TakesScreenshot(filter_button);

                        commonpageActions.click(driver, clear_button, 360);

                    }
                }
            }
        }
    }

//-- Report PointsofOrigin ---------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void ReportPointsofOrigin(String excelFilePath, String sheetName, WebElement application_ID,
                                            WebElement start_date, WebElement end_date) throws Exception {

        waitForPageToLoad();

        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for application_ID
                    if (DSMExcelData.get(String.valueOf(k)).get("application_ID") != null) {
                        waitForPageToLoad();
                        System.out.println("application_ID -Inside->" + DSMExcelData.get(String.valueOf(k)).get("application_ID"));

                        // Get application_ID
                        application_ID.sendKeys(DSMExcelData.get(String.valueOf(k)).get("application_ID"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After application_ID ");
                    }
                    // Validate for start_date
                    if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                        waitForPageToLoad();
                        System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                        // Get start_date
                        start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After start_date ");
                    }
                    // Validate for end_date
                    if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                        waitForPageToLoad();
                        System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                        // Get end_date
                        end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After end_date ");


                        commonpageActions.click(driver, filter_button, 360);

                        TakeScreenShots.TakesScreenshot(filter_button);

                        commonpageActions.click(driver, clear_button, 360);

                    }
                }
            }
        }
    }

//--- Report Group Summary ---------------------------------------------------------------------------------------------------------------------------------------------------

    public static void ReportGroupSummary(String excelFilePath, String sheetName, WebElement whichfacility, WebElement group_status_type,
                                          WebElement text_group_name, WebElement txtDirectAddress, WebElement start_date, WebElement end_date) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for whichfacility
                    if (DSMExcelData.get(String.valueOf(k)).get("whichfacility") != null) {
                        waitForPageToLoad();
                        System.out.println("whichfacility -Inside->" + DSMExcelData.get(String.valueOf(k)).get("whichfacility"));


                        // Get whichfacility
                        whichfacility.sendKeys(DSMExcelData.get(String.valueOf(k)).get("whichfacility"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After whichfacility");
                    }

                    // Validate for Group Status
                    if (DSMExcelData.get(String.valueOf(k)).get("Group Status") != null) {
                        waitForPageToLoad();
                        System.out.println("Group Status is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Group Status"));

                        // Get Group Status
                        group_status_type.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Group Status"));
                        waitForPageToLoad();

                        System.out.println("After Group Status");
                    }

                    // Validate for Group Name
                    if (DSMExcelData.get(String.valueOf(k)).get("Group Name") != null) {
                        waitForPageToLoad();
                        System.out.println("Group Name-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Group Name"));

                        // Get Group Name
                        text_group_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Group Name"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Group Name");
                    }

                    // Validate for Direct Address
                    if (DSMExcelData.get(String.valueOf(k)).get("Direct Address") != null) {
                        waitForPageToLoad();
                        System.out.println("Direct Address-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Direct Address"));

                        // Get Direct Address
                        txtDirectAddress.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Direct Address"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Direct Address ");
                    }


                    // Validate for start_date
                    if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                        waitForPageToLoad();
                        System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                        // Get start_date
                        start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After start_date ");
                    }
                    // Validate for end_date
                    if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                        waitForPageToLoad();
                        System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                        // Get end_date
                        end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After end_date ");


                        commonpageActions.click(driver, filter_button, 360);

                        TakeScreenShots.TakesScreenshot(filter_button);

                        commonpageActions.click(driver, clear_button, 360);

                    }
                }
            }
        }
    }

//--- Report Requests -------------------------------------------------------------------------------------------------------------------------------------------------------------							

    public static void ReportRequests(String excelFilePath, String sheetName, WebElement whichapp, WebElement request_ID,
                                      WebElement request_call, WebElement request_code, WebElement request_response,
                                      WebElement start_date, WebElement end_date) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for whichapp
                    if (DSMExcelData.get(String.valueOf(k)).get("whichapp") != null) {
                        waitForPageToLoad();
                        System.out.println("whichapp -Inside->" + DSMExcelData.get(String.valueOf(k)).get("whichapp"));

                        // Get whichapp
                        whichapp.sendKeys(DSMExcelData.get(String.valueOf(k)).get("whichapp"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After whichapp ");
                    }

                    // Validate for request_ID
                    if (DSMExcelData.get(String.valueOf(k)).get("request_ID") != null) {
                        //waitForPageToLoad();
                        System.out.println("request_ID is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("request_ID"));

                        // Get request_ID
                        request_ID.sendKeys(DSMExcelData.get(String.valueOf(k)).get("request_ID"));
                        waitForPageToLoad();

                        System.out.println("After request_ID");
                    }

                    // Validate for request_call
                    if (DSMExcelData.get(String.valueOf(k)).get("request_call") != null) {
                        waitForPageToLoad();
                        System.out.println("request_call -Inside->" + DSMExcelData.get(String.valueOf(k)).get("request_call"));

                        // Get request_call
                        request_call.sendKeys(DSMExcelData.get(String.valueOf(k)).get("request_call"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After request_call");
                    }

                    // Validate for request_code
                    if (DSMExcelData.get(String.valueOf(k)).get("request_code") != null) {
                        waitForPageToLoad();
                        System.out.println("request_code -Inside->" + DSMExcelData.get(String.valueOf(k)).get("request_code"));

                        // Get request_code
                        request_code.sendKeys(DSMExcelData.get(String.valueOf(k)).get("request_code"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After request_code ");
                    }

                    // Validate for request_response
                    if (DSMExcelData.get(String.valueOf(k)).get("request_response") != null) {
                        waitForPageToLoad();
                        System.out.println("request_response -Inside->" + DSMExcelData.get(String.valueOf(k)).get("request_response_type"));

                        // Get request_response
                        request_response.sendKeys(DSMExcelData.get(String.valueOf(k)).get("request_response"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After request_response ");
                    }

                    // Validate for start_date
                    if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                        waitForPageToLoad();
                        System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                        // Get start_date
                        start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After start_date ");
                    }
                    // Validate for end_date
                    if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                        waitForPageToLoad();
                        System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                        // Get end_date
                        end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);


                        System.out.println("After end_date ");


                        commonpageActions.click(driver, filter_button, 360);

                        TakeScreenShots.TakesScreenshot(filter_button);

                        commonpageActions.click(driver, clear_button, 360);

                    }
                }
            }
        }
    }

//--- Global Search -------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void GlobalSearch(String excelFilePath, String sheetName, WebElement Message_Sender, WebElement Message_Recipients,
                                    WebElement Message_Subject, WebElement Message_Plain, WebElement Message_Attachments, WebElement mbxDropdown, WebElement Folder,
                                    WebElement start_date, WebElement end_date) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {
                System.out.println("In For loop");

                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for Message_Sender
                    if (DSMExcelData.get(String.valueOf(k)).get("From") != null) {
                        waitForPageToLoad();
                        System.out.println("From -Inside->" + DSMExcelData.get(String.valueOf(k)).get("From"));


                        // Get Message_Sender
                        Message_Sender.sendKeys(DSMExcelData.get(String.valueOf(k)).get("From"));
                        waitForPageToLoad();


                        System.out.println("After From");
                    }

                    // Validate for Message_Recipients
                    if (DSMExcelData.get(String.valueOf(k)).get("To") != null) {
                        waitForPageToLoad();
                        System.out.println("To is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("To"));

                        // Get Message_Recipients
                        Message_Recipients.sendKeys(DSMExcelData.get(String.valueOf(k)).get("To"));
                        waitForPageToLoad();

                        System.out.println("After To");
                    }

                    // Validate for Message_Subject
                    if (DSMExcelData.get(String.valueOf(k)).get("Subject") != null) {
                        waitForPageToLoad();
                        System.out.println("Subject-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Subject"));

                        // Get Message_Subject
                        Message_Subject.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Subject"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Subject");
                    }

                    // Validate for Message_Plain
                    if (DSMExcelData.get(String.valueOf(k)).get("Body") != null) {
                        waitForPageToLoad();
                        System.out.println("Body -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Body"));

                        // Get Message_Plain
                        Message_Plain.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Body"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Body ");
                    }

                    // Validate for Message_Attachments
                    if (DSMExcelData.get(String.valueOf(k)).get("Attachments") != null) {
                        waitForPageToLoad();
                        System.out.println("Attachments-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Attachments"));

                        // Get Message_Attachments
                        Message_Attachments.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Attachments"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Attachments ");
                    }

                    // Validate for Folder
                   if (DSMExcelData.get(String.valueOf(k)).get("Folder") != null) {
                       waitForPageToLoad();
                       System.out.println("Folder -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Folder"));

                    // Get Folder
                    Folder.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Folder"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("Folder ");
                    }

                    // Validate for mbxDropdown
                    if (DSMExcelData.get(String.valueOf(k)).get("mbxDropdown") != null) {
                        waitForPageToLoad();
                        System.out.println("mbxDropdown -Inside->" + DSMExcelData.get(String.valueOf(k)).get("mbxDropdown"));

                        // Get mbxDropdown
                        mbxDropdown.sendKeys(DSMExcelData.get(String.valueOf(k)).get("mbxDropdown"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After mbxDropdown ");
                    }

                    // Validate for start_date
                    if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                        waitForPageToLoad();
                        System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                        // Get start_date
                        start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After start_date ");
                    }
                    // Validate for end_date
                    if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                        waitForPageToLoad();
                        System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                        // Get end_date
                        end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After end_date ");


                        commonpageActions.click(driver, filter_button, 360);

                        TakeScreenShots.TakesScreenshot(filter_button);

                        commonpageActions.click(driver, clear_button, 360);

                    }
                }
            }
        }
    }

//--- Report Mail ----------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void ReportMail(String excelFilePath, String sheetName, WebElement successful, WebElement id,
                                  WebElement mdn, WebElement bound, WebElement sender, WebElement recipient, WebElement file_size,
                                  WebElement attachment_type, WebElement protected_data, WebElement start_date, WebElement end_date) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Get Success
                    successful.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Success"));
                    waitForPageToLoad();


                    System.out.println("After Success");
                }

                // Validate for ID
                if (DSMExcelData.get(String.valueOf(k)).get("ID") != null) {
                    waitForPageToLoad();
                    System.out.println("ID is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("ID"));

                    // Get ID
                    id.sendKeys(DSMExcelData.get(String.valueOf(k)).get("ID"));
                    waitForPageToLoad();

                    System.out.println("After ID");
                }

                // Validate for MDN
                if (DSMExcelData.get(String.valueOf(k)).get("MDN") != null) {
                    waitForPageToLoad();
                    System.out.println("MDN-Inside->" + DSMExcelData.get(String.valueOf(k)).get("MDN"));

                    // Get MDN
                    mdn.sendKeys(DSMExcelData.get(String.valueOf(k)).get("MDN"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After MDN");
                }

                // Validate for Direction
                if (DSMExcelData.get(String.valueOf(k)).get("Direction") != null) {
                    waitForPageToLoad();
                    System.out.println("Direction -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Direction"));

                    // Get Direction
                    bound.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Direction"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Direction ");
                }

                // Validate for Sender
                if (DSMExcelData.get(String.valueOf(k)).get("Sender") != null) {
                    waitForPageToLoad();
                    System.out.println("Sender-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Sender"));

                    // Get Sender
                    sender.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Sender"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Sender ");
                }
                // Validate for Recipient
                if (DSMExcelData.get(String.valueOf(k)).get("Recipient") != null) {
                    waitForPageToLoad();
                    System.out.println("Recipient -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Recipient"));

                    // Get Recipient
                    recipient.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Recipient"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("Recipient ");
                }
                // Validate for Size
                if (DSMExcelData.get(String.valueOf(k)).get("Size") != null) {
                    waitForPageToLoad();
                    System.out.println("Size -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Size"));

                    // Get Size
                    file_size.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Size"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Size ");
                }
                // Validate for Attachment Type
                if (DSMExcelData.get(String.valueOf(k)).get("Attachment Type") != null) {
                    waitForPageToLoad();
                    System.out.println("Attachment Type -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Attachment Type"));

                    // Get Attachment Type
                    attachment_type.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Attachment Type"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Attachment Type ");
                }
                // Validate for 7332
                if (DSMExcelData.get(String.valueOf(k)).get("7332") != null) {
                    waitForPageToLoad();
                    System.out.println("7332 -Inside->" + DSMExcelData.get(String.valueOf(k)).get("7332"));

                    // Get 7332
                    protected_data.sendKeys(DSMExcelData.get(String.valueOf(k)).get("7332"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After 7332 ");
                }
                // Validate for start_date
                if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                    waitForPageToLoad();
                    System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                    // Get start_date
                    start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After start_date ");
                }
                // Validate for end_date
                if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                    waitForPageToLoad();
                    System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                    // Get end_date
                    end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                    waitForPageToLoad();
                    Thread.sleep(1000);


                    System.out.println("After end_date ");


                    commonpageActions.click(driver, filter_button, 360);

                    TakeScreenShots.TakesScreenshot(filter_button);

                    commonpageActions.click(driver, clear_button, 360);

                }
            }
        }
    }

//--- Report User Summary --------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void ReportUserSummary(String excelFilePath, String sheetName, WebElement whichfacility, WebElement txtGivenname,
                                         WebElement txtSN, WebElement txtVAEmailAddress, WebElement txtDirectAddress, WebElement txtUserName, WebElement user_status_type,
                                         WebElement start_date, WebElement end_date) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for whichfacility
                    if (DSMExcelData.get(String.valueOf(k)).get("whichfacility") != null) {
                        waitForPageToLoad();
                        System.out.println("whichfacility  -Inside->" + DSMExcelData.get(String.valueOf(k)).get("whichfacility"));


                        // Get whichfacility
                        whichfacility.sendKeys(DSMExcelData.get(String.valueOf(k)).get("whichfacility"));
                        waitForPageToLoad();


                        System.out.println("After whichfacility");
                    }

                    // Validate for VA Email Address
                    if (DSMExcelData.get(String.valueOf(k)).get("VA Email Address") != null) {
                        waitForPageToLoad();
                        System.out.println("VA Email Address is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("VA Email Address"));

                        // Get VA Email Address
                        txtVAEmailAddress.sendKeys(DSMExcelData.get(String.valueOf(k)).get("VA Email Address"));
                        waitForPageToLoad();

                        System.out.println("After VA Email Address");
                    }

                    // Validate for First Name
                    if (DSMExcelData.get(String.valueOf(k)).get("First Name") != null) {
                        waitForPageToLoad();
                        System.out.println("First Name-Inside->" + DSMExcelData.get(String.valueOf(k)).get("First Name"));

                        // Get First Name
                        txtGivenname.sendKeys(DSMExcelData.get(String.valueOf(k)).get("First Name"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("First Name");
                    }

                    // Validate for Last Name
                    if (DSMExcelData.get(String.valueOf(k)).get("Last Name") != null) {
                        waitForPageToLoad();
                        System.out.println("Last Name -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Last Name"));

                        // Get Last Name
                        txtSN.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Last Name"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("Last Name Target ");
                    }

                    // Validate for Direct Address
                    if (DSMExcelData.get(String.valueOf(k)).get("Direct Address") != null) {
                        waitForPageToLoad();
                        System.out.println("Direct Address-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Direct Address"));

                        // Get Direct Address
                        txtDirectAddress.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Direct Address"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("WAYYYYYYYYYYYY After Direct Address ");
                    }
                    // Validate for User Status
                    if (DSMExcelData.get(String.valueOf(k)).get("User Status") != null) {
                        waitForPageToLoad();
                        System.out.println("User Status-Inside->" + DSMExcelData.get(String.valueOf(k)).get("User Status"));

                        // Get User Status
                        user_status_type.sendKeys(DSMExcelData.get(String.valueOf(k)).get("User Status"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After User Status ");
                    }
                    // Validate for User Name
                    if (DSMExcelData.get(String.valueOf(k)).get("User Name") != null) {
                        waitForPageToLoad();
                        System.out.println("User Name-Inside->" + DSMExcelData.get(String.valueOf(k)).get("User Name"));

                        // Get User Name
                        txtUserName.sendKeys(DSMExcelData.get(String.valueOf(k)).get("User Name"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After User Name ");
                    }
                    // Validate for start_date
                    if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                        waitForPageToLoad();
                        System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                        // Get start_date
                        start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After start_date ");
                    }
                    // Validate for end_date
                    if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                        waitForPageToLoad();
                        System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                        // Get end_date
                        end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After end_date ");


                        commonpageActions.click(driver, filter_button, 360);

 //                       commonActions.waitToVerifyText();
  //                              (driver, filter_button, 360);

                        TakeScreenShots.TakesScreenshot(filter_button);

                        new commonpageActions.Assert(driver, txtUserName , 360);

                        commonpageActions.click(driver, clear_button, 360);

                    }
                }
            }
        }
    }

//--- Report Logins----------------------------------------  TAKES 3 MIN TO LOAD after click on link   TIMEOUT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-----------------------------------------

    public static void ReportLogins(String excelFilePath, String sheetName, WebElement successful, WebElement id,
                                    WebElement username, WebElement session_id, WebElement ip_address, WebElement message, WebElement org_id,
                                    WebElement start_date, WebElement end_date) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Get Success
                    successful.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Success"));
                    waitForPageToLoad();


                    System.out.println("After Success");
                }

                // Validate for ID
                if (DSMExcelData.get(String.valueOf(k)).get("ID") != null) {
                    waitForPageToLoad();
                    System.out.println("ID is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("ID"));

                    // Get ID
                    id.sendKeys(DSMExcelData.get(String.valueOf(k)).get("ID"));
                    waitForPageToLoad();

                    System.out.println("After ID");
                }

                // Validate for Username
                if (DSMExcelData.get(String.valueOf(k)).get("Username") != null) {
                    waitForPageToLoad();
                    System.out.println("Username-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Username"));

                    // Get Username
                    username.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Username"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Username");
                }

                // Validate for Session ID
                if (DSMExcelData.get(String.valueOf(k)).get("Session ID") != null) {
                    waitForPageToLoad();
                    System.out.println("Session ID -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Session ID"));

                    // Get Session ID
                    session_id.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Session ID"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("Session ID ");
                }

                // Validate for IP Address
                if (DSMExcelData.get(String.valueOf(k)).get("IP Address ") != null) {
                    waitForPageToLoad();
                    System.out.println("IP Address-Inside->" + DSMExcelData.get(String.valueOf(k)).get("IP Address"));

                    // Get IP Address
                    ip_address.sendKeys(DSMExcelData.get(String.valueOf(k)).get("IP Address "));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After IP Address ");
                }
                // Validate for Message
                if (DSMExcelData.get(String.valueOf(k)).get("Message") != null) {
                    waitForPageToLoad();
                    System.out.println("Message-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Message"));

                    // Get Message
                    message.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Message"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("Message ");
                }
                // Validate for Org ID
                if (DSMExcelData.get(String.valueOf(k)).get("Org ID") != null) {
                    waitForPageToLoad();
                    System.out.println("Org ID -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Org ID"));

                    // Get Org ID
                    org_id.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Org ID"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Org ID ");
                }

                // Validate for start_date
                if (DSMExcelData.get(String.valueOf(k)).get("start_date") != null) {
                    waitForPageToLoad();
                    System.out.println("start_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("start_date"));

                    // Get start_date
                    start_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("start_date"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After start_date ");
                }
                // Validate for end_date
                if (DSMExcelData.get(String.valueOf(k)).get("end_date") != null) {
                    waitForPageToLoad();
                    System.out.println("end_date -Inside->" + DSMExcelData.get(String.valueOf(k)).get("end_date"));

                    // Get end_date
                    end_date.sendKeys(DSMExcelData.get(String.valueOf(k)).get("end_date"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After end_date ");


                    commonpageActions.click(driver, filter_button, 360);

                    TakeScreenShots.TakesScreenshot(filter_button);

                    commonpageActions.click(driver, clear_button, 360);

                }
            }
        }
    }

//--- User Settings AppList --------------------------------------------------------------------------------------------

    public static void UserSettingsAppList(String excelFilePath, String sheetName, WebElement app_name) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

// Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
// Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                }

                // Validate for app_name
                if (DSMExcelData.get(String.valueOf(k)).get("app_name") != null) {
                    waitForPageToLoad();
                    System.out.println("app_name is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("app_name"));

                    // Get app_name
                    app_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("app_name"));
                    waitForPageToLoad();

                    System.out.println("After app_name");

                }
            }
        }
    }

//--- User Settings --------------------------------------------------------------------------------------------------------------------------------------------------

    public static void UserSettings(String excelFilePath, String sheetName, WebElement first_name, WebElement middle_name,
                                    WebElement last_name, WebElement ext_mail, WebElement title, WebElement department, WebElement organization, WebElement telephone, WebElement mobile,
                                    WebElement location, WebElement facility_select) throws Exception {


        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for First Name
                    if (DSMExcelData.get(String.valueOf(k)).get("First Name") != null) {
                        waitForPageToLoad();
                        System.out.println("First Name is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("First Name"));

                        // Get First Name
                        first_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("First Name"));
                        waitForPageToLoad();

                        System.out.println("After First Name");
                    }

                    // Validate for Middle Name
                    if (DSMExcelData.get(String.valueOf(k)).get("Middle Name") != null) {
                        waitForPageToLoad();
                        System.out.println("Middle Name -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Middle Name"));

                        // Get Middle Name
                        middle_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Middle Name"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Middle Name");
                    }

                    // Validate for Last Name
                    if (DSMExcelData.get(String.valueOf(k)).get("Last Name") != null) {
                        waitForPageToLoad();
                        System.out.println("Last Name -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Last Name"));

                        // Get Last Name
                        last_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Last Name"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Last Name ");
                    }

                    // Validate for VA Email Address
                    if (DSMExcelData.get(String.valueOf(k)).get("VA Email Address") != null) {
                        waitForPageToLoad();
                        System.out.println("VA Email Address  -Inside->" + DSMExcelData.get(String.valueOf(k)).get("VA Email Address"));

                        // Get VA Email Address
                        ext_mail.sendKeys(DSMExcelData.get(String.valueOf(k)).get("VA Email Address"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After VA Email Address ");
                    }
                    // Validate for Title
                    if (DSMExcelData.get(String.valueOf(k)).get("Title") != null) {
                        waitForPageToLoad();
                        System.out.println("Title -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Title"));

                        // Get Title
                        title.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Title"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Title ");
                    }
                    // Validate for Department
                    if (DSMExcelData.get(String.valueOf(k)).get("Department") != null) {
                        waitForPageToLoad();
                        System.out.println("Acting Type-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Department"));

                        // Get Department
                        department.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Department"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Department ");

                    }

                    // Validate for Organization
                    if (DSMExcelData.get(String.valueOf(k)).get("Organization") != null) {
                        waitForPageToLoad();
                        System.out.println("Organizatione -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Organization"));

                        // Get Organization
                        organization.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Organization"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Organization ");

                    }

                    // Validate for Telephone
                    if (DSMExcelData.get(String.valueOf(k)).get("Telephone") != null) {
                        waitForPageToLoad();
                        System.out.println("Telephone  -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Telephone"));

                        // Get Telephone
                        telephone.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Telephone"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Telephone ");

                    }
                    // Validate for Mobile
                    if (DSMExcelData.get(String.valueOf(k)).get("Mobile") != null) {
                        waitForPageToLoad();
                        System.out.println("Mobile -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Mobile"));

                        // Get Mobile
                        mobile.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Mobile"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Mobile ");

                    }
                    // Validate for Location
                    if (DSMExcelData.get(String.valueOf(k)).get("Location") != null) {
                        waitForPageToLoad();
                        System.out.println("Location  -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Location"));

                        // Get Location
                        location.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Location"));
                        waitForPageToLoad();
                        Thread.sleep(1000);

                        System.out.println("After Location ");


                    }
//  		// Validate for SettingsFacility
// 		  						if (DSMExcelData.get(String.valueOf(k)).get("SettingsFacility") != null ) {
// 		  							waitForPageToLoad();
// 		  							System.out.println("SettingsFacility  -Inside->"+DSMExcelData.get(String.valueOf(k)).get("SettingsFacility"));
//  		  									
//  			// Get SettingsFacility
// 		  							facility_select.sendKeys(DSMExcelData.get(String.valueOf(k)).get("SettingsFacility"));
// 		  							waitForPageToLoad();
// 		  								Thread.sleep(1000);
//		  										
// 		  								System.out.println("After SettingsFacility");	    						  			 

                }
            }
        }
    }

//--- Administration Manage Accounts --------------------------------------------------------------------------------------------

    public static void AdminManageAccounts(String excelFilePath, String sheetName, WebElement user_name,
                                           WebElement org_id, WebElement first_name, WebElement middle_name, WebElement last_name, WebElement ext_mail,
                                           WebElement account_title, WebElement department, WebElement telephone,
                                           WebElement mobile, WebElement domain_select, WebElement chosen_search_input) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Get user_name
                    user_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("user_name"));
                    waitForPageToLoad();


                    System.out.println("After user_name");
                }

                // Validate for org_id
                if (DSMExcelData.get(String.valueOf(k)).get("org_id") != null) {
                    waitForPageToLoad();
                    System.out.println("org_id is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("org_id"));

                    // Get org_id
                    org_id.sendKeys(DSMExcelData.get(String.valueOf(k)).get("org_id"));
                    waitForPageToLoad();

                    System.out.println("After org_id");
                }

                // Validate for First Name
                if (DSMExcelData.get(String.valueOf(k)).get("First Name") != null) {
                    waitForPageToLoad();
                    System.out.println("First Name is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("First Name"));

                    // Get First Name
                    first_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("First Name"));
                    waitForPageToLoad();

                    System.out.println("After First Name");
                }

                // Validate for Middle Name
                if (DSMExcelData.get(String.valueOf(k)).get("Middle Name") != null) {
                    waitForPageToLoad();
                    System.out.println("Middle Name -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Middle Name"));

                    // Get Middle Name
                    middle_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Middle Name"));
                    waitForPageToLoad();


                    System.out.println("After Middle Name");
                }

                // Validate for Last Name
                if (DSMExcelData.get(String.valueOf(k)).get("Last Name") != null) {
                    waitForPageToLoad();
                    System.out.println("Last Name -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Last Name"));

                    // Get Last Name
                    last_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Last Name"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Last Name ");
                }

                // Validate for VA Email Address
                if (DSMExcelData.get(String.valueOf(k)).get("VA Email Address") != null) {
                    waitForPageToLoad();
                    System.out.println("TVA Email Address  -Inside->" + DSMExcelData.get(String.valueOf(k)).get("TVA Email Address"));

                    // Get VA Email Address
                    ext_mail.sendKeys(DSMExcelData.get(String.valueOf(k)).get("VA Email Address"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After VA Email Address ");
                }
                // Validate for Title
                if (DSMExcelData.get(String.valueOf(k)).get("Title") != null) {
                    waitForPageToLoad();
                    System.out.println("Title -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Title"));

                    // Get Title
                    account_title.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Title"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Title ");
                }
                // Validate for Department
                if (DSMExcelData.get(String.valueOf(k)).get("Department") != null) {
                    waitForPageToLoad();
                    System.out.println("Acting Type-Inside->" + DSMExcelData.get(String.valueOf(k)).get("Department"));

                    // Get Department
                    department.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Department"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Department ");
                }
                // Validate for Telephone
                if (DSMExcelData.get(String.valueOf(k)).get("Telephone") != null) {
                    waitForPageToLoad();
                    System.out.println("Telephone  -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Telephone"));

                    // Get Telephone
                    telephone.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Telephone"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Telephone ");
                }
                // Validate for Mobile
                if (DSMExcelData.get(String.valueOf(k)).get("Mobile") != null) {
                    waitForPageToLoad();
                    System.out.println("Mobile -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Mobile"));

                    // Get Mobile
                    mobile.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Mobile"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Mobile ");

                }
                // Validate for Domain
                if (DSMExcelData.get(String.valueOf(k)).get("Domain") != null) {
                    waitForPageToLoad();
                    System.out.println("Domain -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Domain"));

                    // Get Domain
                    domain_select.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Domain"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Domain ");
                }

                //  this method is for to click any link- in this case it is clicking on Facility dropdown link
                commonpageActions.click(driver, chosen_search_input, 360);
                Select select = new Select(chosen_search_input);
                select.selectByIndex(01);


                // Validate for AccountFacility
                if (DSMExcelData.get(String.valueOf(k)).get("AccountFacility") != null) {
                    waitForPageToLoad();
                    System.out.println("AccountFacility -Inside->" + DSMExcelData.get(String.valueOf(k)).get("AccountFacility"));

                    // Get AccountFacility
                    chosen_search_input.sendKeys(DSMExcelData.get(String.valueOf(k)).get("AccountFacility"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After AccountFacility");

                }
            }
        }
    }

//--- Administration Application Request --------------------------------------------------------------------------------------------

    public static void AdminApplicationRequests(String excelFilePath, String sheetName, WebElement approved_table_filter) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                }

                // Validate for approved_table_filter
                if (DSMExcelData.get(String.valueOf(k)).get("Search") != null) {
                    waitForPageToLoad();
                    System.out.println("Search is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Search"));

                    // Get approved_table_filter
                    approved_table_filter.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Search"));
                    waitForPageToLoad();

                    System.out.println("After Search");
                }
            }
        }
    }

//--- Administration Account Request --------------------------------------------------------------------------------------------

    public static void AdminAccountRequests(String excelFilePath, String sheetName, WebElement active_account_table_filter) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                }

                // Validate for active_account_table_filter
                if (DSMExcelData.get(String.valueOf(k)).get("Search") != null) {
                    waitForPageToLoad();
                    System.out.println("Search is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Search"));

                    // Get active_account_table_filter
                    active_account_table_filter.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Search"));
                    waitForPageToLoad();

                    System.out.println("After Search");
                }
            }
        }
    }

//--- Administration Manage Facilities--------------------------------------------------------------------------------------------

    public static void AdminManageFacilities(String excelFilePath, String sheetName, WebElement fac_name,
                                             WebElement address_Line1, WebElement address_Line2, WebElement city_field, WebElement state_field,
                                             WebElement zip_field, WebElement country_field, WebElement npi_field, WebElement VISN_field) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Validate for Facility Name

                    if (DSMExcelData.get(String.valueOf(k)).get("fac_name") != null) {
                        waitForPageToLoad();
                        System.out.println("fac_name is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("fac_name"));

                        // Get Facility Name
                        fac_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("fac_name"));
                        waitForPageToLoad();

                        System.out.println("After fac_name");

                    }
                    // Validate for address_Line1

                    if (DSMExcelData.get(String.valueOf(k)).get("address_Line1") != null) {
                        waitForPageToLoad();
                        System.out.println("address_Line1 is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("address_Line1"));

                        // Get address_Line1
                        address_Line1.sendKeys(DSMExcelData.get(String.valueOf(k)).get("address_Line1"));
                        waitForPageToLoad();

                        System.out.println("After address_Line1");

                    }
                    // Validate for address_Line2
                    if (DSMExcelData.get(String.valueOf(k)).get("address_Line2") != null) {
                        waitForPageToLoad();
                        System.out.println("address_Line2 is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("address_Line2"));

                        // Get address_Line2
                        address_Line2.sendKeys(DSMExcelData.get(String.valueOf(k)).get("address_Line2"));
                        waitForPageToLoad();

                        System.out.println("After address_Line2");

                    }
                    // Validate for city_field
                    if (DSMExcelData.get(String.valueOf(k)).get("city_field") != null) {
                        waitForPageToLoad();
                        System.out.println("city_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("city_field"));

                        // Get city_field
                        city_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("city_field"));
                        waitForPageToLoad();

                        System.out.println("After city_field");
                    }
                    // Validate for state_field
                    if (DSMExcelData.get(String.valueOf(k)).get("state_field") != null) {
                        waitForPageToLoad();
                        System.out.println("state_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("state_field"));

                        // Get state_field
                        state_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("state_field"));
                        waitForPageToLoad();

                        System.out.println("After state_field");
                    }
                    // Validate for zip_field
                    if (DSMExcelData.get(String.valueOf(k)).get("zip_field") != null) {
                        waitForPageToLoad();
                        System.out.println("zip_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("zip_field"));

                        // Get zip_field
                        zip_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("zip_field"));
                        waitForPageToLoad();

                        System.out.println("After zip_field");
                    }
                    // Validate for country_field
                    if (DSMExcelData.get(String.valueOf(k)).get("country_field") != null) {
                        waitForPageToLoad();
                        System.out.println("country_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("country_field"));

                        // Get country_field
                        country_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("country_field"));
                        waitForPageToLoad();

                        System.out.println("After country_field");
                    }
                    // Validate for npi_field
                    if (DSMExcelData.get(String.valueOf(k)).get("npi_field") != null) {
                        waitForPageToLoad();
                        System.out.println("npi_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("npi_field"));

                        // Get npi_field
                        npi_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("npi_field"));
                        waitForPageToLoad();

                        TakeScreenShots.TakesScreenshot(npi_field);

                        System.out.println("After npi_field");
                    }
                    // Validate for VISN_field
                    if (DSMExcelData.get(String.valueOf(k)).get("VISN_field") != null) {
                        waitForPageToLoad();
                        System.out.println("VISN_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("VISN_field"));

                        // Get VISN_field
                        VISN_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("VISN_field"));
                        waitForPageToLoad();

                        TakeScreenShots.TakesScreenshot(VISN_field);

                        System.out.println("After VISN_field");

                    }
                }
            }
        }
    }

//--- Administration Manage Groups --------------------------------------------------------------------------------------------

    public static void AdminManageGroups(String excelFilePath, String sheetName, WebElement Group_Name,
                                         WebElement Domain, WebElement Display_Name, WebElement Description,
                                         WebElement address_Line1, WebElement address_Line2, WebElement city_field, WebElement state_field,
                                         WebElement zip_field, WebElement country_field, WebElement facility_field) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Get Group_Name
                    Group_Name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Group_Name"));
                    waitForPageToLoad();

                    System.out.println("After Group_Name");
                }

                // Validate for Domain
                if (DSMExcelData.get(String.valueOf(k)).get("Domain") != null) {
                    waitForPageToLoad();
                    System.out.println("Domain is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Domain"));

                    // Get Domain
                    Domain.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Domain"));
                    waitForPageToLoad();

                    System.out.println("After Domain");
                }


                // Validate for Display_Name
                if (DSMExcelData.get(String.valueOf(k)).get("Display_Name") != null) {
                    waitForPageToLoad();
                    System.out.println("Display_Name is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Display_Name"));

                    // Get Display_Name
                    Display_Name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Display_Name"));
                    waitForPageToLoad();

                    System.out.println("After Display_Name");
                }

                // Validate for Description
                if (DSMExcelData.get(String.valueOf(k)).get("Description") != null) {
                    waitForPageToLoad();
                    System.out.println("Description -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Description"));

                    // Get Description
                    Description.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Description"));
                    waitForPageToLoad();

                    System.out.println("After Description");
                }

                // Validate for address_Line1

                if (DSMExcelData.get(String.valueOf(k)).get("address_Line1") != null) {
                    waitForPageToLoad();
                    System.out.println("address_Line1 is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("address_Line1"));

                    // Get address_Line1
                    address_Line1.sendKeys(DSMExcelData.get(String.valueOf(k)).get("address_Line1"));
                    waitForPageToLoad();

                    System.out.println("After address_Line1");

                }
                // Validate for address_Line2
                if (DSMExcelData.get(String.valueOf(k)).get("address_Line2") != null) {
                    waitForPageToLoad();
                    System.out.println("address_Line2 is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("address_Line2"));

                    // Get address_Line2
                    address_Line2.sendKeys(DSMExcelData.get(String.valueOf(k)).get("address_Line2"));
                    waitForPageToLoad();

                    System.out.println("After address_Line2");

                }
                // Validate for city_field
                if (DSMExcelData.get(String.valueOf(k)).get("city_field") != null) {
                    waitForPageToLoad();
                    System.out.println("city_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("city_field"));

                    // Get city_field
                    city_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("city_field"));
                    waitForPageToLoad();

                    System.out.println("After city_field");
                }
                // Validate for state_field
                if (DSMExcelData.get(String.valueOf(k)).get("state_field") != null) {
                    waitForPageToLoad();
                    System.out.println("state_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("state_field"));

                    // Get state_field
                    state_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("state_field"));
                    waitForPageToLoad();

                    System.out.println("After state_field");
                }
                // Validate for zip_field
                if (DSMExcelData.get(String.valueOf(k)).get("zip_field") != null) {
                    waitForPageToLoad();
                    System.out.println("zip_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("zip_field"));

                    // Get zip_field
                    zip_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("zip_field"));
                    waitForPageToLoad();

                    System.out.println("After zip_field");
                }
                // Validate for country_field
                if (DSMExcelData.get(String.valueOf(k)).get("country_field") != null) {
                    waitForPageToLoad();
                    System.out.println("country_field is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("country_field"));

                    // Get country_field
                    country_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("country_field"));
                    waitForPageToLoad();

                    System.out.println("After country_field");

                    // Validate for facility_field
                    if (DSMExcelData.get(String.valueOf(k)).get("facility_field") != null) {
                        waitForPageToLoad();
                        System.out.println("facility_field  -Inside->" + DSMExcelData.get(String.valueOf(k)).get("facility_field"));

                        // Get facility_field
                        facility_field.sendKeys(DSMExcelData.get(String.valueOf(k)).get("facility_field"));
                        waitForPageToLoad();

                        System.out.println("After facility_field");

                    }
                }
            }
        }
    }

//--- Applications --------------------------------------------------------------------------------------------

    public static void Applications(String excelFilePath, String sheetName) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
                }
            }
        }
    }

//--- Onboarding Request -------------------------------------------------------------------------------------

    public static void OnboardingRequest(String excelFilePath, String sheetName, WebElement app_name, WebElement app_url,
                                         WebElement app_desc, WebElement app_just, WebElement app_poc_name, WebElement app_poc_email, WebElement app_poc_phone) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {


                    // Get Application Name
                    app_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Application Name"));
                    waitForPageToLoad();


                    System.out.println("Application Name");
                }

                // Validate for Application URL
                if (DSMExcelData.get(String.valueOf(k)).get("Application URL") != null) {
                    waitForPageToLoad();
                    System.out.println("Application URL is -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Application URL"));

                    // Get Application URL
                    app_url.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Application URL"));
                    waitForPageToLoad();

                    System.out.println("After Application URL");
                }

                // Validate for Application Description
                if (DSMExcelData.get(String.valueOf(k)).get("Application Description") != null) {
                    waitForPageToLoad();
                    System.out.println("Application Description -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Application Description"));

                    // Get Application Description
                    app_desc.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Application Description"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("Application Description");
                }

                // Validate for Justification
                if (DSMExcelData.get(String.valueOf(k)).get("Justification") != null) {
                    waitForPageToLoad();
                    System.out.println("Justification -Inside->" + DSMExcelData.get(String.valueOf(k)).get("Justification"));

                    // Get Justification
                    app_just.sendKeys(DSMExcelData.get(String.valueOf(k)).get("Justification"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After Justification ");
                }

                // Validate for POC Name
                if (DSMExcelData.get(String.valueOf(k)).get("POC Name") != null) {
                    waitForPageToLoad();
                    System.out.println("POC Name -Inside->" + DSMExcelData.get(String.valueOf(k)).get("POC Name"));

                    // Get POC Name
                    app_poc_name.sendKeys(DSMExcelData.get(String.valueOf(k)).get("POC Name"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After POC Name ");
                }
                // Validate for POC External Email
                if (DSMExcelData.get(String.valueOf(k)).get("POC External Email") != null) {
                    waitForPageToLoad();
                    System.out.println("POC External Email -Inside->" + DSMExcelData.get(String.valueOf(k)).get("POC External Email"));

                    // Get APOC External Email
                    app_poc_email.sendKeys(DSMExcelData.get(String.valueOf(k)).get("POC External Email"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After POC External Email ");
                }
                // Validate for POC Phone
                if (DSMExcelData.get(String.valueOf(k)).get("POC Phone") != null) {
                    waitForPageToLoad();
                    System.out.println("POC Phone -Inside->" + DSMExcelData.get(String.valueOf(k)).get("POC Phone"));

                    // Get POC Phone
                    app_poc_phone.sendKeys(DSMExcelData.get(String.valueOf(k)).get("POC Phone"));
                    waitForPageToLoad();
                    Thread.sleep(1000);

                    System.out.println("After POC Phone ");
                }
            }
        }
    }

//--- Onboarding Documentation --------------------------------------------------------------------------------------------

    public static void OnboardingDocumentation(String excelFilePath, String sheetName) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
                }
            }
        }
    }

//--- Onboarding PDF --------------------------------------------------------------------------------------------

    public static void OnboardingPDF(String excelFilePath, String sheetName) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
                }
            }
        }
    }

//--- Ad-hoc Report --------------------------------------------------------------------------------------------

    public static void ReportAdHoc(String excelFilePath, String sheetName) throws Exception {

        waitForPageToLoad();


        Map<String, Map<String, String>> DSMExcelData = ReadExcelData.readExcelFile(excelFilePath, sheetName);

        System.out.println("Before excel loop");

        // Loop through the map object
        if (DSMExcelData != null) {
            for (int k = 1; k < DSMExcelData.size() + 1; k++) {

                System.out.println("In For loop");
                // Execute the script only if Run Script is set to Yes
                if (DSMExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
                }
            }
        }
    }

}

