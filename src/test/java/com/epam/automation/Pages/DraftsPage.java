package com.epam.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DraftsPage extends BasicPage{


    public void dealWithDrafts() {

        WebElement goToDraftsWe = driver.findElement(goToDrafts);
        goToDraftsWe.click();
        assert driver.getPageSource().contains(emailBodyText);
        driver.findElement(By.xpath("//*[contains(text(),'" + subjectboxText + "')]")).click();
        assert driver.findElement(By.xpath("//*[@id=':n3'//*[contain(text(),'" + emailToText + "')]")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id=':p7'//*[contain(text(),'" + subjectboxText + "')]")).isDisplayed();
        assert driver.findElement(By.xpath("//*[@id=':qm'//*[contain(text(),'" + emailBodyText + "')]")).isDisplayed();

    }
}
