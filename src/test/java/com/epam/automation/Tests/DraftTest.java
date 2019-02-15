package com.epam.automation.Tests;

import com.epam.automation.Pages.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.support.PageFactory;

public class DraftTest  extends  BasicTest{

    @Test (dataProvider = "users")
    public void DraftTest(String user, String pass) {

        DraftsPage draftsPage = PageFactory.initElements(driver, DraftsPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        SentPage sentPage = PageFactory.initElements(driver, SentPage.class);
        StartEmailPage startEmailPage = PageFactory.initElements(driver, StartEmailPage.class);

//        LoginPage loginPage1 = new LoginPage();
        //TODO page objects - see above


        driver.get("https://mail.google.com/");
        loginPage.login(user, pass);
        startEmailPage.startEmail();
        draftsPage.dealWithDrafts();
        sentPage.sendEmail();
        loginPage.signout();


        //TODO more details here (e.g. main page - click button & possibly define which button)

    }



    @DataProvider(name="users")
    public Object [][] getUsers() throws FileNotFoundException {


        Object obj = new JSONParser().parse(new FileReader("/Users/mac/IdeaProjects/EPAMJavaTasks/src/test/resources/Creds.json"));
        //TODO question 8 - what's wrong with the parser?

        //TODO fetch a file from resources this class - class loader - get resource

        JSONObject jo = (JSONObject) obj;
        //added an external library for JSON
        String loginName =  (String) jo.get("loginName");
        String password = (String) jo.get("password");

        return new Object[][]{
              {loginName, password}
        };
    }




}
