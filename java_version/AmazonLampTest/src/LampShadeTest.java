import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Scott Minter
 * 10/28/2017
 */
public class LampShadeTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String URL = "https://www.amazon.com/";
    private static String lampShadePrice;
    private static String subTotalPrice;

    @BeforeClass
    public static void goToAmazon() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get(URL);
    }

    @Test
    public void lampShadePriceTest() {
        // enter lamp shades in the search box
        wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox"))).sendKeys("lamp shades");

        // click the search icon
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();

        // select the 3 result
        wait.until(ExpectedConditions.elementToBeClickable(By.id("result_3"))).click();

        // store the price
        lampShadePrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priceblock_ourprice"))).getText();

        // add the item to the cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();

        // get the cart sub total
        subTotalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]"))).getText();

        // assert that the prices match
        Assert.assertEquals(lampShadePrice, subTotalPrice);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
