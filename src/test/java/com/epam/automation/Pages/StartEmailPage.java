package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class StartEmailPage extends BasicPage{


    public void startEmail(){

        WebElement newEmailButtonWe = driver.findElement(newEmailButton);
        newEmailButtonWe.click();

    }

    public void writeEmail(){
        WebElement emailToWe = waitElementVisibility(emailTo);
        emailToWe.sendKeys(emailToText);
        WebElement emailSubject = driver.findElement(By.name("subjectbox"));
        emailSubject.sendKeys(subjectboxText);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement emailBodyWe = driver.findElement(emailBody);
        emailBodyWe.sendKeys(emailBodyText);
    }

    public void closeEmail() {
        WebElement emailCloseWe = driver.findElement(emailClose);
        emailCloseWe.click();

    }

    public void sendEmail(){

        WebElement sendEmailButtonWe = driver.findElement(sendEmailButton);
        sendEmailButtonWe.click();
    }

}
