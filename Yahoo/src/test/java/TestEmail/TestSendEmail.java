package TestEmail;

import Ui.ComposePage.UiCompose;
import Models.Email;
import methods.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.DriverFactory;

import java.io.IOException;

/**
 * Created by izran on 1/9/2017.
 */
public class TestSendEmail extends CommonMethods {
    public UiCompose getPage(WebDriver driver) throws InterruptedException, IOException {
        LogIn(driver);
        return PageFactory.initElements(driver, UiCompose.class);
    }

    @Test(dataProvider = "getDataXLS")
    public void SendEmailTestXLS(String toEmail, String subject, String body) throws InterruptedException, IOException {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        UiCompose uiCompose = getPage(driver);

        Email oEmail =new Email();
        oEmail.toEmail(toEmail);
        oEmail.subject(subject);
        oEmail.body(body);
        uiCompose.SendEmails(oEmail);
     }

    @DataProvider
    public Object[][] getDataXLS() throws IOException {

        //0: xls , 1: mysql , 2: mongodb
      return   Email.getData(0);
    }

    @Test(dataProvider = "getDataMySql")
    public void SendEmailTestMySql(String toEmail, String subject, String body) throws InterruptedException, IOException {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        UiCompose uiCompose = getPage(driver);

        Email oEmail =new Email();
        oEmail.toEmail(toEmail);
        oEmail.subject(subject);
        oEmail.body(body);
        uiCompose.SendEmails(oEmail);
    }

    @DataProvider
    public Object[][] getDataMySql() throws IOException {

        //0: xls , 1: mysql , 2: mongodb
        return   Email.getData(1);
    }


    @Test(dataProvider = "getDataMongoDb")
    public void SendEmailTestMongoDb(String toEmail, String subject, String body) throws InterruptedException, IOException {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        UiCompose uiCompose = getPage(driver);

        Email oEmail =new Email();
        oEmail.toEmail(toEmail);
        oEmail.subject(subject);
        oEmail.body(body);
        uiCompose.SendEmails(oEmail);
    }

    @DataProvider
    public Object[][] getDataMongoDb() throws IOException {

        //0: xls , 1: mysql , 2: mongodb
        return   Email.getData(2);
    }
}