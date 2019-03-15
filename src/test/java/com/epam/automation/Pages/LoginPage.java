package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasicPage{


    private By loginInput = By.id("identifierId");
    private By nextButton = By.xpath("//span[@class='RveJvd snByac']");
    private By passInput = By.name("password");
    private By nextButton2 = By.xpath("//*[@id='passwordNext']/content/span");
    private By googleAcc = By.xpath("//*[contains(text(),'Privacy')]/../../div[2]");
    private By accIcon = By.xpath("//span[@class='gb_ya gbii']");




    public void login(String userAbstr, String passAbstr) {

        WebElement loginInputWe = driver.findElement(loginInput);
        loginInputWe.sendKeys(userAbstr);

        WebElement nextButtonWe = driver.findElement(nextButton);
        nextButtonWe.click();

        WebElement passInputWe = waitElementVisibility(passInput);
//        WebElement passInputWe = driver.findElement(passInput);
        passInputWe.sendKeys(passAbstr);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // using the same button 2 times didn't work - JS issue?
        WebElement nextButton2we = waitElementVisibility(nextButton2);
        nextButton2we.click();

        /*TODO question - sometimes I have an error here which is reproducible randomly:
        Element <span class="RveJvd snByac"> is not clickable at point (780,396)
        because another element <div class="ANuIbb IdAqtf"> obscures it
        */
    }

    public void checkAcc(String userAbstr){
        WebElement accIconWe = waitElementVisibility(accIcon);
        accIconWe.click();

        WebElement googleAccWe = waitElementVisibility(googleAcc);
        System.out.println("Logged in as " + googleAccWe.getText());
        assert googleAccWe.getText().equals(userAbstr);

    }

    public void signout() {
        WebElement signoutButtonWe = driver.findElement(signoutButton);
        signoutButtonWe.click();
    }



}
