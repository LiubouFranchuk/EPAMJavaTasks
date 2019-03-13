package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasicPage{

   /* By arg = By.id("identifierId");
    WebElement argElement = driver.findElement(arg);*/

    private By loginInput = By.id("identifierId");
    private By nextButton = By.xpath("//span[@class='RveJvd snByac']");
    private By passInput = By.name("password");
//    private By nextButton2 = By.xpath("//*[@id=\"passwordNext\"]/content/span");
    private By googleAcc = By.xpath("//div[contains(text(),'Google Account')]/following-sibling::div[2]");

    //TODO question 5 - is it sensible to put web elements and methods together in Pages? [DONE]




    public void login(String userAbstr, String passAbstr) {

        WebElement loginInputWe = driver.findElement(loginInput);
        loginInputWe.sendKeys(userAbstr);

        WebElement nextButtonWe = driver.findElement(nextButton);
        nextButtonWe.click();

        WebElement passInputWe = waitElementVisibility(passInput);
        passInputWe.sendKeys(passAbstr);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //TODO question 2 - why did using the same button 2 times didn't work? JS issue?
        WebElement nextButton2we = driver.findElement(nextButton);

        //TODO remove the 2nd next btn

        nextButton2we.click();

//        assert googleAcc.getText().equals(userAbstr);
        WebElement googleAccWe = driver.findElement(googleAcc);
        System.out.println("Logged in as " + googleAccWe.getText());
        //TODO question 3 - can't get text at this point. NOTE - this is working with assertText in Katalon
        //TODO add 2 clicks to get CSS display






        //TODO question 1 - how do I get rid of the method errors with WebDriverWait

        //TODO waiter as a method +pass xpath only

    }

    public void signout() {
        WebElement signoutButtonWe = driver.findElement(signoutButton);
        signoutButtonWe.click();
    }



}
