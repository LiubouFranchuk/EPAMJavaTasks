package com.epam.automation.Pages;

import com.epam.automation.Helpers.DriverProvider;
import com.epam.automation.Helpers.Randomizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicPage {

    protected WebDriver driver;
    //private or protected


    protected By sendEmailButton = By.id(":ow");
    protected By goToDrafts = By.xpath("//a[@title='Drafts']");
    protected By goToSent = By.xpath("//a[@title='Sent']");
    protected By newEmailButton = By.xpath("//div[contains(text(),'Compose')]");
    protected By emailTo = By.name("to");
    protected By emailBody = By.xpath("//div[@aria-label='Message Body']");
    protected By emailClose = By.xpath("//img[@aria-label='Save & close']");
    protected By signoutButton = By.xpath("//a[contains(text(),'Sign out')]");



    protected String emailToText = "prablgaivblshe@gmail.com";
    private static int randNum = Randomizer.getRandomNumber();
    protected String subjectboxText = "Java Test " + randNum;
    protected String emailBodyText = "This is a test email created by Liubou Franchuk with the help of Selenium.";

    public BasicPage() {
        this.driver = DriverProvider.getDriver(BrowserType.FIREFOX);
    }

    //this constructor is the main purpose of the BasicPage

    public WebElement waitElementVisibility(By elm){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(elm));

        return webElement;
    }
}


/*
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
new WebDriverWait(driver, 10).until(CONDITIONS);
 */




