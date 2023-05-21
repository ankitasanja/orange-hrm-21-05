package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class DashboardPage extends Utility {

    By dashboard = By.xpath("//h6[normalize-space()='Dashboard']");

    public String getDashboardText() {
        return getTextFromElement(dashboard);
    }

}
