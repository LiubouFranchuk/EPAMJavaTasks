package com.epam.automation.Pages;

import com.epam.automation.Helpers.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BasicPage {

    protected WebDriver driver;
    //private or protected


    By sendEmailButton = By.id(":ow");
    By goToDrafts = By.xpath("//a[@title='Drafts']");
    By goToSent = By.xpath("//a[@title='Sent']");
    By newEmailButton = By.xpath("//div[contains(text(),'Compose')]");
    By emailTo = By.name("to");
    By emailBody = By.xpath("//div[@aria-label='Message Body']");
    By emailClose = By.xpath("//img[@aria-label='Save & close']");
    By signoutButton = By.xpath("//a[contains(text(),'Sign out')]");



    protected String emailToText = "prablgaivblshe@gmail.com";
    protected String subjectboxText = "Java Test";
    protected String emailBodyText = "This is a test email created by Liubou Franchuk with the help of Selenium.";





    //NOTE - these elements are declared in the Basic page since they can be accessed from any page



}

//TODO page objects + page factory

/*
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
new WebDriverWait(driver, 10).until(CONDITIONS);
 */

//TODO gradle

//TODO logger +inherit it

