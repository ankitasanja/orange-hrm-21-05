package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddUserPage extends Utility {

    By userRoleAdmin = By.xpath("//div[contains(text(),'Admin')]");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By lisa = By.xpath("//span[contains(text(),'Lisa')]");
    By username = By.cssSelector("div[class='oxd-form-row'] div[class='oxd-grid-2 orangehrm-full-width-grid'] div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']");
    By searchText = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By disable = By.xpath("(//span[normalize-space()='Disabled'])[1]");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    By saveButton = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]");
    By enable = By.xpath("//span[contains(text(),'Enabled')]");
    By successfullySaved = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");

    public void selectUserRoleAdmin(String text) {
        selectByContainsTextFromDropDown(userRoleAdmin, text);
    }

    public void enterEmployeeName(String name) {
        sendTextToElement(employeeName, name);
        List<WebElement> suggList = driver.findElements(lisa);
        for (WebElement element : suggList) {
            System.out.println(element.getText());
        }
        mouseHoverToElementAndClick(lisa);
    }

    public void enterUsername(String userName) {
        sendTextToElement(username, userName);
    }

    public void clickOnStatusSelect() {
        clickOnElement(searchText);
    }

    public void clickOnDisable() {
        clickOnElement(disable);
    }

    public void enterPassword(String passWord) {
        sendTextToElement(password, passWord);
    }

    public void enterConfirmPassword(String conPassword) {
        sendTextToElement(confirmPassword, conPassword);
    }

    public void clickOnSave() {
        clickOnElement(saveButton);
    }

    public void clickOnEnable() {
        clickOnElement(enable);
    }

    public String getSuccessfullySavedText() {
        return getTextFromElement(successfullySaved);
    }


}
