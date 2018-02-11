package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {

    static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    @FindBy(how = How.XPATH, using="//*[contains(@href,'popup.php')]")
    private WebElement popupButton;

    public WebElement getPopupButton() {
        return popupButton;
    }
}
