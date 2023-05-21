package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class AdminPage extends Utility {

    By systemUser = By.xpath("//h5[normalize-space()='System Users']");
    By add = By.xpath("//button[normalize-space()='Add']");
    By addUser = By.xpath("//h6[normalize-space()='Add User']");

    public String getSystemUserText() {
        return getTextFromElement(systemUser);
    }
    public void clickOnAddButton() {
        clickOnElement(add);
    }
    public String getAddUserText() {
        return getTextFromElement(addUser);
    }





}
