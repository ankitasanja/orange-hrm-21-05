package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    AdminPage adminPage = new AdminPage();
    AddUserPage userPage = new AddUserPage();
    ViewSystemUsersPage systemUsersPage = new ViewSystemUsersPage();

    @Test
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        // Login to Application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

        // click On "Admin" Tab
        homePage.clickOnAdminTab();

        // Verify "System Users" Text
        String expectedText = "System Users";
        String actualText = adminPage.getSystemUserText();
        Assert.assertEquals(actualText, expectedText, "Error message found");

        // click On "Add" button
        adminPage.clickOnAddButton();

        // Verify "Add User" Text
        String expectedMessage = "Add User";
        String actualMessage = adminPage.getAddUserText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message found");

        // Select User Role "Admin"
        systemUsersPage.selectUserRoleFromDropDown();

        // enter Employee Name "Ananya Dash"
        userPage.enterEmployeeName("Lisa");

        // enter Username
        userPage.enterUsername("Lauris");

        // Select status "Disable"

        userPage.clickOnStatusSelect();
        userPage.clickOnDisable();

        // enter password
        userPage.enterPassword("Smith@123456");

        // enter Confirm Password
        userPage.enterConfirmPassword("Smith@123456");

        // click On "Save" Button
        Thread.sleep(2000);
        userPage.clickOnSave();

        // verify message "Successfully Saved"
        String expectedSaved = "Successfully Saved";
        String actualSaved = userPage.getSuccessfullySavedText();
        Assert.assertEquals(actualSaved, expectedSaved, "Error message found");

    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        // Login to Application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

        // click On "Admin" Tab
        homePage.clickOnAdminTab();

        // Verify "System Users" Text
        String expectedMessage = "System Users";
        String actualMessage = adminPage.getSystemUserText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message found");

        // enter Username
        systemUsersPage.enterUsername("Lauris");

        // Select User Role
        systemUsersPage.selectUserRoleFromDropDown();

        // Click on "Search" Button
        Thread.sleep(2000);
        systemUsersPage.clickOnSearchButton();

        // Verify the User should be in Result list
        String expectedList = "Lauris";
        String actualList = systemUsersPage.getUserShouldBeInListText();
        Assert.assertEquals(actualList, expectedList, "Error message displayed");

    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        // Login to Application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

        // click On "Admin" Tab
        homePage.clickOnAdminTab();

        // Verify "System Users" Text
        String expectedMessage = "System Users";
        String actualMessage = adminPage.getSystemUserText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message found");

        // enter Username
        systemUsersPage.enterUsername("Lauris");

        // Select User Role
        systemUsersPage.selectUserRoleFromDropDown();

        // Click on "Search" Button
        systemUsersPage.clickOnSearchButton();

        // Verify the User should be in Result list
        String expectedList = "Lauris";
        String actualList = systemUsersPage.getUserShouldBeInListText();
        Assert.assertEquals(actualList, expectedList, "Error message displayed");

        // Click on Check box
        systemUsersPage.clickOnCheckBox();

        // Click on Delete Button
        systemUsersPage.clickOnDeleteButton();

        // Popup will display
        //	Click on Ok Button on Popup
        systemUsersPage.clickOnYesDeleteButton();

        // verify message "Successfully Deleted"
        String expectedText = "Successfully Deleted";
        String actualText = systemUsersPage.getSuccessfullyDeletedText();
        Assert.assertEquals(actualText, expectedText, "Error message displayed");


    }

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        // Login to Application
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

        // click On "Admin" Tab
        homePage.clickOnAdminTab();

        // Verify "System Users" Text
        String expectedMessage = "System Users";
        String actualMessage = adminPage.getSystemUserText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message found");

        // enter Username
        systemUsersPage.enterUsername("Lauris");

        // Select User Role
        systemUsersPage.selectUserRoleFromDropDown();

        // Click on "Search" Button
        systemUsersPage.clickOnSearchButton();

        // verify message "No Records Found"
        String expectedText = "No Records Found";
        String actualText = systemUsersPage.getNoRecordFoundText();
        Assert.assertEquals(actualText, expectedText, "Error message displayed");

    }
}
