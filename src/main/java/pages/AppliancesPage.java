package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class AppliancesPage {

    private WebDriver driver;

    @FindBy(linkText = "Стиральные машины")
    private WebElement washingMachinesButton;

    public AppliancesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WashingMachinesTypesPage goToWashingMachinesTypesSection(){
        washingMachinesButton.click();
        return new WashingMachinesTypesPage(driver);
    }
}
