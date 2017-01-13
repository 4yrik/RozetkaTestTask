import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RozetkaHomePage;
import util.Utils;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/user/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String report = new RozetkaHomePage(driver).goToAppliancesSection()
                                                   .goToWashingMachinesTypesSection()
                                                   .goToAllWashingMachinesSection()
                                                   .getTopSalesNamesAndPrices(3);
        Utils.sendEmail("churilov1991e@ukr.net", "Топ продаж стиральных машин", report);

        driver.quit();
    }
}
