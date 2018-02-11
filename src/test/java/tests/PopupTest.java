package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.util.Iterator;
import java.util.Set;


public class PopupTest extends BaseTest{

    BasePage basePage;

    @BeforeMethod
    public void initMethod() {
        basePage = PageFactory.initElements(driver, BasePage.class);

    }


    @Test
    public void test1(){

        setDriver();
        initMethod();

        basePage.getPopupButton().click();

        //driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        String MainWindow=driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                driver.findElement(By.name("emailid"))
                        .sendKeys("gaurav.3n@gmail.com");

                driver.findElement(By.name("btnLogin")).click();

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);

        Assert.assertEquals(1,1);
    }




}
