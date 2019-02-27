package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SentPage extends BasicPage {



    public void sendEmail(){

        WebElement sendEmailButtonWe = driver.findElement(sendEmailButton);
        sendEmailButtonWe.click();

        WebElement goToDraftsWe = driver.findElement(goToDrafts);
        goToDraftsWe.click();
        assert !driver.getPageSource().contains(emailBodyText);

        WebElement goToSentWe = driver.findElement(goToSent);
        goToSentWe.click();
        assert driver.getPageSource().contains(emailBodyText);



    }
}
