package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DraftsPage extends BasicPage{

    private By draftInstance = By.xpath("//span[contains(text(),'Draft')]");
    private By deleteDraft = By.xpath(draftInstance + "/ancestor::td[1]/following-sibling::td[5]/ul/li[2]");


    public void goToDrafts() {

        WebElement goToDraftsWe = driver.findElement(goToDrafts);
        goToDraftsWe.click();
    }

    public void checkDraftPresence(){
        assert driver.getPageSource().contains(emailBodyText);

    }

    public void checkDraftContent(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        /*TODO question - after that I have an error though timeout is added above -
        Element <span> could not be scrolled into view */


        driver.findElement(By.xpath("//*[contains(text(),'" + subjectboxText + "')]")).click();
        //TODO question - I have an error: Element <span> could not be scrolled into view
        assert driver.findElement(By.xpath("//*[@id=':n3'//*[contain(text(),'" + emailToText + "')]")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id=':p7'//*[contain(text(),'" + subjectboxText + "')]")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id=':qm'//*[contain(text(),'" + emailBodyText + "')]")).isDisplayed();
    }


    public void clearOldDrafts(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> draftInstanceWe = driver.findElements(draftInstance);
        for (WebElement el : draftInstanceWe){

            Actions builder = new Actions(driver);
            builder.moveToElement(el).build().perform();
            //TODO question - how do I iterate and delete each element if I can't click it do to invalid xpath then (>1 elements found)
            //NOTE: I commented this method in the test so far

            WebElement deleteDraftWe = driver.findElement(deleteDraft);
            builder.moveToElement(deleteDraftWe).click().build().perform();

        }
    }

    public void checkNoDraft(){
        assert !driver.getPageSource().contains(emailBodyText);

    }


}
