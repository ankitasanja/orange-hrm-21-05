package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends Utility {

    By username = By.name("username");
    By password = By.name("password");
    By loginButton = By.xpath("//button[normalize-space()='Login']");
    By HRLogo = By.xpath("//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']");
    By profileLogo = By.xpath("//p[contains(text(),'Updated Collings')]");
    By logout = By.xpath("//a[contains(text(),'Logout')]");
    By login = By.tagName("h5");


    public void enterUsername(String name) {
        sendTextToElement(username,name);
    }
    public void enterPassword(String passWord) {
        sendTextToElement(password,passWord);
    }
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
    public void verifyLogoIsDisplayed() {
        WebElement logo = driver.findElement(HRLogo);  //By.cssSelector("div#divLogo img")
        if (logo.isDisplayed()) {
            System.out.println("Logo is displayed on the login page");
        } else {
            System.out.println("Logo is not displayed on the login page");
        }
    }
    public void clickOnUserProfileLogo() {
        clickOnElement(profileLogo);
    }
    public void mouseHoverAndClickOnLogout() {
        mouseHoverToElementAndClick(logout);
    }
    public String getLoginText() {
        return getTextFromElement(login);
    }


}
