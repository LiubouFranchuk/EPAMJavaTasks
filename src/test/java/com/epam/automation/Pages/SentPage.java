package com.epam.automation.Pages;

import org.openqa.selenium.WebElement;

public class SentPage extends BasicPage {

    public void goToSent(){
        WebElement goToSentWe = driver.findElement(goToSent);
        goToSentWe.click();

    }

    public void checkEmailIsSent(){
        assert driver.getPageSource().contains(emailBodyText);

    }




}
