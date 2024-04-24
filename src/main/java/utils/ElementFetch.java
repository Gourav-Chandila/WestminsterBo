package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

//Handling for fetch elements from pages by all type of selectors 
public class ElementFetch {
	public WebElement getWebElement(String identifierType, String identifierValue) {
	    if (identifierType == null || identifierValue == null) {
	        throw new IllegalArgumentException("Identifier type and value cannot be null");
	    }
	    By locator = null;
	    switch (identifierType.toUpperCase()) {
	        case "XPATH":
	            locator = By.xpath(identifierValue);
	            break;
	        case "CSS":
	            locator = By.cssSelector(identifierValue);
	            break;
	        case "ID":
	            locator = By.id(identifierValue);
	            break;
	        case "NAME":
	            locator = By.name(identifierValue);
	            break;
	        case "TAGNAME":
	            locator = By.tagName(identifierValue);
	            break;
	        case "LINKTEXT":
	            locator = By.linkText(identifierValue);
	            break;
	        case "CLASSNAME":
	            locator = By.className(identifierValue);
	            break;
	        default:
	            throw new IllegalArgumentException("Unsupported identifier type: " + identifierType);
	    }
	    return BaseTest.driver.findElement(locator);
	}


	// it give list of elements that found
	public List<WebElement> getWebElements(String identifierType, String identifierValue) {
	    if (identifierType == null || identifierValue == null) {
	        throw new IllegalArgumentException("Identifier type and value cannot be null");
	    }
	    By locator = null;
	    switch (identifierType.toUpperCase()) {
	        case "XPATH":
	            locator = By.xpath(identifierValue);
	            break;
	        case "CSS":
	            locator = By.cssSelector(identifierValue);
	            break;
	        case "ID":
	            locator = By.id(identifierValue);
	            break;
	        case "NAME":
	            locator = By.name(identifierValue);
	            break;
	        case "TAGNAME":
	            locator = By.tagName(identifierValue);
	            break;
	        default:
	            throw new IllegalArgumentException("Unsupported identifier type: " + identifierType);
	    }
	    return BaseTest.driver.findElements(locator);
	}

}
