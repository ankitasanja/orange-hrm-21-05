package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewSystemUsersPage extends Utility {

    By username = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    By admin = By.xpath("(//span[contains(text(),'Admin')])[1]");
    By searchText = By.xpath("(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]");
    By searchButton = By.xpath("(//button[normalize-space()='Search'])[1]");
    By lauris = By.xpath("//div[contains(text(),'Lauris')]");
    By checkBox = By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]");
    By deleteButton = By.xpath("(//button[normalize-space()='Delete Selected'])[1]");
    By yesDelete = By.xpath("(//button[normalize-space()='Yes, Delete'])[1]");
    By deleted = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
    By noRecordFound = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");

    public void enterUsername(String name) {
        sendTextToElement(username, name);
    }

    public void selectUserRoleFromDropDown() {
        sendTextToElement(searchText, "Admin");

        List<WebElement> suggList = driver.findElements(admin);
        for (WebElement element : suggList) {
            System.out.println(element.getText());
        }
        mouseHoverToElementAndClick(admin);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public String getUserShouldBeInListText() {
        return getTextFromElement(lauris);
    }

    public void clickOnCheckBox() {
        clickOnElement(checkBox);
    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteButton);
    }

    public void clickOnYesDeleteButton() {
        clickOnElement(yesDelete);
    }

    public String getSuccessfullyDeletedText() {
        return getTextFromElement(deleted);
    }

    public String getNoRecordFoundText() {
        return getTextFromElement(noRecordFound);
    }
}
