package CreatePage;

import Homepage.UiMenuBar;
import Homepage.UiYourAccountMenuTab;
import methods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Bilal on 19-01-2017.
 */
public class UiCreatePage extends UiYourAccountMenuTab{
    @FindBy(how = How.XPATH,using = "html/body/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/h2")
    public WebElement pageHeading;
    public String pageHeadingText = "Create a Page";

    public void assertPage(){
        Assert.assertTrue(pageHeading.getText().contains(pageHeadingText));
    }

    public void getPage() throws InterruptedException {
        UiMenuBar uiMenuBar = PageFactory.initElements(driver, UiMenuBar.class);
        uiMenuBar.getYourAccountMenuTab();
        UiYourAccountMenuTab uiYourAccountMenuTab = PageFactory.initElements(driver,UiYourAccountMenuTab.class);
        uiYourAccountMenuTab.getCreatePage();
    }
}