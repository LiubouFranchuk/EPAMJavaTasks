package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class StartEmailPage extends BasicPage{


    public void startEmail(){

        newEmailButton.click();

        emailTo.sendKeys(emailToText);WebElement emailSubject = driver.findElement(By.name("subjectbox"));
        emailSubject.sendKeys(subjectboxText);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        emailBody.sendKeys(emailBodyText);
        emailClose.click();

    }
}
