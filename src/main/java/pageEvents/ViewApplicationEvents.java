package pageEvents;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.ViewApplicationElements;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class ViewApplicationEvents {
    ElementFetch ele = new ElementFetch();

     // Define enum for element keys
    public static enum ElementKey {
        APPLICATION_NAME,
        APPLICATION_STATUS,
        APPLICATION_DATE,
        APPLICATION_CREATED_BY,
        APPLICATION_REQ_START_DATE,
        APPLICATION_REQ_END_DATE,
        APPLICATION_SITE_ADDRESS,
        APPLICATION_LOCATION_DESCRIPTION,
        ABOUT_THE_WORK_DESCRIPTION,
        TYPE_OF_WORK,
        REQUIRED_ROAD_CLOSURE,
        TRAFFIC_MANAGEMENT_DESCRIPTION,
        SUPERVISOR_NAME,
        SUPERVISOR_TELEPHONE,
        SUPERVISOR_NRWSA_NUMBER,
        OPERATOR_NAME,
        OPERATOR_TELEPHONE,
        OPERATOR_NRWSA_NUMBER,
        ERROR
    }

    public Map<ElementKey, String> verifyApplicationDetails(WebDriver driver) {
        Map<ElementKey, String> result = new LinkedHashMap<>();

        try {
            SeleniumUtils.scrollToElement(driver, "xpath", ViewApplicationElements.applicationSection);
            SeleniumUtils.someDelay(3000);

            // Define array for element XPaths
            String[] elementXPaths = {
                ViewApplicationElements.applicationName,
                ViewApplicationElements.applicationStatus,
                ViewApplicationElements.applicationDate,
                ViewApplicationElements.applicationCreatedBy,
                ViewApplicationElements.applicationReqStartDate,
                ViewApplicationElements.applicationReqEndDate,
                ViewApplicationElements.applicationSiteAddress,
                ViewApplicationElements.applicationLocationDescription,
                ViewApplicationElements.applicationAboutTheWorkDescription,
                ViewApplicationElements.applicationTypeOfWork,
                ViewApplicationElements.applicationRequiredRoadClosure,
                ViewApplicationElements.applicationDescriptionTrafficMgmnt,
                ViewApplicationElements.applicationSupervisorName,
                ViewApplicationElements.applicationSupervisorTelephone,
                ViewApplicationElements.applicationSupervisorNRWSANumber,
                ViewApplicationElements.applicationOperatorName,
                ViewApplicationElements.applicationOperatorTelephone,
                ViewApplicationElements.applicationOperatorNRWSANumber
            };

            // Iterate over elements
            for (int i = 0; i < elementXPaths.length; i++) {
                WebElement element = ele.getWebElement("XPATH", elementXPaths[i]);
                String text = element.getText();
                result.put(ElementKey.values()[i], text);
            }
        } catch (Exception e) {
            result.put(ElementKey.ERROR, e.getMessage());
        }

        return result;
    }
}
