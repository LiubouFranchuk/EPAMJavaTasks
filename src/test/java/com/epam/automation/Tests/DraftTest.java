package com.epam.automation.Tests;

import com.epam.automation.Pages.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
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

       /* DraftsPage draftsPage = PageFactory.initElements(driver, DraftsPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        SentPage sentPage = PageFactory.initElements(driver, SentPage.class);
        StartEmailPage startEmailPage = PageFactory.initElements(driver, StartEmailPage.class);*/

//        LoginPage loginPage1 = new LoginPage();
        //TODO page objects - see above


        driver.get("https://mail.google.com/");
        LoginPage loginPage = new LoginPage();
        loginPage.login(user, pass);

        StartEmailPage startEmailPage = new StartEmailPage();
        startEmailPage.startEmail();

        DraftsPage draftsPage = new DraftsPage();
        draftsPage.dealWithDrafts();

        SentPage sentPage = new SentPage();
        sentPage.sendEmail();

        loginPage.signout();

/*        loginPage.login(user, pass);
        startEmailPage.startEmail();
        draftsPage.dealWithDrafts();
        sentPage.sendEmail();
        loginPage.signout();*/


        //TODO more details here (e.g. main page - click button & possibly define which button)

    }



    @DataProvider(name="users")
    public Object[][] getUsers(){
        String[][] credentials = new String[1][2];
        try{
            Object fileObject = new JSONParser().parse(
                    new FileReader(getClass().getClassLoader().getResource("Creds.json").getFile()));
            JSONObject jsonObject = (JSONObject) fileObject;
            String loginName = (String) jsonObject.get("loginName");
            String password = (String) jsonObject.get("password");

            credentials[0][0] = loginName;
            credentials[0][1] = password;

        } catch (Exception e){

            //TODO here should be logger which will log an error - e.printStackTrace();
        }
        return credentials;
    }




}
