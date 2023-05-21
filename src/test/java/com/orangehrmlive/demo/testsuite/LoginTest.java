package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void verifyUserShouldLoginSuccessFully() {
        // Enter username
        loginPage.enterUsername("Admin");

        // Enter password
        loginPage.enterPassword("admin123");

        // Click on Login Button
        loginPage.clickOnLoginButton();

        // Verify "Dashboard" Message
        String expectedMessage = "Dashboard";
        String actualMessage = dashboardPage.getDashboardText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message found");
    }

    @Test
    public void VerifyThatTheLogoDisplayOnLoginPage() {

        // Verify Logo is Displayed
        loginPage.verifyLogoIsDisplayed();
    }

    @Test
    public void VerifyUserShouldLogOutSuccessFully() {
        // Enter username
        loginPage.enterUsername("Admin");

        // Enter password
        loginPage.enterPassword("admin123");

        // Click on Login Button
        loginPage.clickOnLoginButton();

        //  Click on User Profile logo
        loginPage.clickOnUserProfileLogo();

        // Mouse hover on "Logout" and click
        loginPage.mouseHoverAndClickOnLogout();

        // Verify the text "Login Panel" is displayed
        String expectedMessage = "Login";
        String actualMessage = loginPage.getLoginText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message displayed");

    }
}
