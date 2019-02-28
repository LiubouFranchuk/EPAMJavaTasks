package com.epam.automation.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver getDriver(String drivertype) {

        if (driver == null){

            switch (drivertype){
                case BrowserType.CHROME:
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                    return driver = new ChromeDriver();
                case BrowserType.FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriverL");
                    return driver = new FirefoxDriver();
                default:
                    throw new Error("Missing or incorrect browser Java Property");
            }
        }
        return driver;
    }
}

