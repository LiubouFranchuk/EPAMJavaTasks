package com.epam.automation.Tests;

import com.epam.automation.Helpers.DriverProvider;
import com.epam.automation.Pages.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasicTest {
    private WebDriver driver;

    @BeforeTest
    public void setupBrowser(){
        driver = DriverProvider.getDriver(BrowserType.CHROME);
        driver.manage().deleteAllCookies();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
