package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;

public class RozetkaHomePage {

    private WebDriver driver;

    @FindBy(css = "#m-main-ul>li")
    private List<WebElement> goodsMenu;

    public RozetkaHomePage(WebDriver driver){
        driver.get("http://rozetka.com.ua/ ");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AppliancesPage goToAppliancesSection(){
        goodsMenu.get(2).click();
        return new AppliancesPage(driver);
    }
}
