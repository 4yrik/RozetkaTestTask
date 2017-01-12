package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;

public class AllWashingMachinesPage {

    private WebDriver driver;

    @FindBy(css = "li.paginator-catalog-l-i")
    private List<WebElement> catalogPagesButtons;

    @FindBy(css = "div.g-i-tile-catalog")
    private List<WebElement> washingMachinesCatalog;

    public AllWashingMachinesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void nextCatalogPage(){
        for(int i = 0; i < catalogPagesButtons.size(); i++){
            if(catalogPagesButtons.get(i).getAttribute("class").endsWith("active")){
                catalogPagesButtons.get(i + 1).click();
                PageFactory.initElements(driver, this);
                break;
            }
        }
    }

    public String getTopSalesNamesAndPrices(int pagesCount){
        StringBuilder result = new StringBuilder();
        String separator = "------------------------------------------------------------";
        result.append("Топ продаж стиральных машин:\n").append(separator).append("\n");
        for(int i = 0; i < pagesCount; i++){
            for(WebElement catalogItem: washingMachinesCatalog){
                try {
                    WebElement label = catalogItem.findElement(By.name("prices_active_element_original"));
                    if (label.getAttribute("class").contains("g-tag-icon-middle-popularity")) {
                        String name = catalogItem.findElement(By.cssSelector("div.g-i-tile-i-title")).getText();
                        String price = catalogItem.findElement(By.name("price")).getText();
                        result.append("Название: ").append(name).append("\n").append("Цена: ").append(price).append("\n").append(separator).append("\n");
                    }
                }catch (NoSuchElementException e){}
            }
            if(!(i == pagesCount - 1)) {
                nextCatalogPage();
            }
        }
        return result.toString();
    }
}
