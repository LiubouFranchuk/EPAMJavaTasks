package com.epam.automation.Tests;

import com.epam.automation.Helpers.DriverProvider;
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
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown(){
//        driver.close();

        //QUIT doesn't remove the instance of the browser, CLOSE - does.
    }



}
