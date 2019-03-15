package com.epam.automation.Tests;

import com.epam.automation.Helpers.LogToFile;
import com.epam.automation.Pages.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;


public class DraftTest  extends  BasicTest{

    @Test (dataProvider = "users")
    public void DraftTest(String user, String pass) {

       /* DraftsPage draftsPage = PageFactory.initElements(driver, DraftsPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        SentPage sentPage = PageFactory.initElements(driver, SentPage.class);
        StartEmailPage startEmailPage = PageFactory.initElements(driver, StartEmailPage.class);*/


        driver.get("https://mail.google.com/");
        LoginPage loginPage = new LoginPage();
        loginPage.login(user, pass);
        loginPage.checkAcc(user);

        DraftsPage draftsPage = new DraftsPage();
        draftsPage.goToDrafts();
        draftsPage.goToDrafts();
        //TODO question - user isn't redirected to Drafts though the same step works in line 38
        // Current workaround is to duplicate the step

//        draftsPage.clearOldDrafts();

        StartEmailPage startEmailPage = new StartEmailPage();
        startEmailPage.startEmail();
        startEmailPage.writeEmail();
        startEmailPage.closeEmail();

        draftsPage.goToDrafts();
        draftsPage.checkDraftPresence();
        draftsPage.checkDraftContent();

        startEmailPage.sendEmail();
        draftsPage.goToDrafts();
        draftsPage.checkNoDraft();

        SentPage sentPage = new SentPage();
        sentPage.goToSent();
        sentPage.checkEmailIsSent();

        loginPage.signout();

/*        loginPage.login(user, pass);
        startEmailPage.startEmail();
        draftsPage.dealWithDrafts();
        sentPage.sendEmail();
        loginPage.signout();*/

    }

//    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


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
//            logger.log(Level.SEVERE, "Login failure: ", e);
            LogToFile.logToFile(e);

        }
        return credentials;
    }




}
