package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasicPage{

   /* By arg = By.id("identifierId");
    WebElement argElement = driver.findElement(arg);*/

    WebElement loginInput = driver.findElement(By.id("identifierId"));
    WebElement nextButton = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
    WebElement passInput = driver.findElement(By.name("password"));
    WebElement nextButton2 = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));
    WebElement googleAcc = driver.findElement(By.xpath("//div[contains(text(),'Google Account')]/following-sibling::div[2]"));

    //TODO question 5 - is it sensible to put web elements and methods together in Pages? [DONE]




    public void login(String userAbstr, String passAbstr) {

        loginInput.sendKeys(userAbstr);
        nextButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        passInput.sendKeys(passAbstr);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //TODO question 2 - why did using the same button 2 times didn't work? JS issue?
        nextButton2.click();

//        assert googleAcc.getText().equals(userAbstr);
        System.out.println("Logged in as " + googleAcc.getText();
        //TODO question 3 - can't get text at this point. NOTE - this is working with assertText in Katalon




//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement passInput = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
//
//        passInput.sendKeys(passAbstr);
//        nextButton.click();

        //TODO question 1 - how do I get rid of the method errors with WebDriverWait

        //TODO waiter as a method +pass xpath only

    }

    public void signout() {
        signoutButton.click();
    }



}
