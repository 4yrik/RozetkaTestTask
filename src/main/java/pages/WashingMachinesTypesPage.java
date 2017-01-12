package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class WashingMachinesTypesPage {

    private WebDriver driver;

    @FindBy(linkText = "Все стиральные машины →")
    private WebElement allWashingMachinesButton;

    public WashingMachinesTypesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AllWashingMachinesPage goToAllWashingMachinesSection(){
        allWashingMachinesButton.click();
        return new AllWashingMachinesPage(driver);
    }
}
