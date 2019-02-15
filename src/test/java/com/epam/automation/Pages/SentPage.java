package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SentPage extends BasicPage {



    public void sendEmail(){

        sendEmailButton.click();

        goToDrafts.click();
        assert !driver.getPageSource().contains(emailBodyText);

        goToSent.click();
        assert driver.getPageSource().contains(emailBodyText);


    }
}
