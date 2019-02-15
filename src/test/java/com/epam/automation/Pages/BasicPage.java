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


    protected String emailToText = "prablgaivblshe@gmail.com";
    protected String subjectboxText = "Java Test";
    protected String emailBodyText = "This is a test email created by Liubou Franchuk with the help of Selenium.";


    WebElement sendEmailButton = driver.findElement(By.id(":ow"));
    WebElement goToDrafts = driver.findElement(By.xpath("//a[@title='Drafts']"));
    WebElement goToSent = driver.findElement(By.xpath("//a[@title='Sent']"));

    WebElement newEmailButton = driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
    WebElement emailTo = driver.findElement(By.name("to"));
    WebElement emailBody = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
    WebElement emailClose = driver.findElement(By.xpath("//img[@aria-label='Save & close']"));

    WebElement signoutButton = driver.findElement(By.xpath("//a[contains(text(),'Sign out')]"));


    //NOTE - these elements are declared in the Basic page since they can be accessed from any page



}

//TODO page objects + page factory

/*
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
new WebDriverWait(driver, 10).until(CONDITIONS);
 */

//TODO gradle

//TODO logger +inherit it

