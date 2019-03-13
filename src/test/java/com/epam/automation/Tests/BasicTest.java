package com.epam.automation.Tests;

import com.epam.automation.Helpers.DriverProvider;
import com.epam.automation.Pages.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BasicTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupBrowser(){
        driver = DriverProvider.getDriver(BrowserType.FIREFOX);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterTest
    public void tearDown(){
//        driver.close();

        //QUITE doesn't remove the intance of the browser, CLOSE - does.
    }

    //TODO try quite / close / kill - to get rid of FF opened instances

}
