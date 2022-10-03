package petStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;

import static org.junit.Assert.assertTrue;

public class addProductToCartPetStore{
    static WebDriver driver;
    static String URL = "https://petstore.octoperf.com/";

    static String qty ;
    WebDriverWait wait = new WebDriverWait(driver, 3000);

    @Given("User at catalog page jPetStore")
    public static void userAtCatalogPageJPetStore() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(URL + "actions/Catalog.action");
        driver.manage().window().maximize();
    }

    @And("User click fish product menu")
    public void userClickFishProductMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        WebElement bFish = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"SidebarContent\"]/a[1]")));
        bFish.click();
    }

    @Then("Direct user to product of fish page")
    public static void directUserToProductOfFishPage() {
        driver.navigate().to(URL+"actions/Catalog.action?viewCategory=&categoryId=FISH");
    }

    @And("User can view some of product fish by species")
    public void userCanViewSomeOfProductFishBySpecies() throws Exception{
        WebElement fProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[1]/th[1]")));
        assertTrue(fProduct.isDisplayed());
        //Thread.sleep(3000);
        WebElement f01 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")));
        assertTrue(f01.isDisplayed());
        //Thread.sleep(3000);
        WebElement f02 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]")));
        assertTrue(f02.isDisplayed());
        //Thread.sleep(3000);
        WebElement f03 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[4]/td[1]/a")));
        assertTrue(f03.isDisplayed());
        //Thread.sleep(3000);
        WebElement f04 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[5]/td[1]/a")));
        assertTrue(f04.isDisplayed());
        //Thread.sleep(3000);

        WebElement fName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[1]/th[2]")));
        assertTrue(fName.isDisplayed());
        //Thread.sleep(3000);
        WebElement s01 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[2]")));
        assertTrue(s01.isDisplayed());
        //Thread.sleep(3000);
        WebElement s02 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[2]")));
        assertTrue(s02.isDisplayed());
        //Thread.sleep(3000);
        WebElement s03 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[4]/td[2]")));
        assertTrue(s03.isDisplayed());
        //Thread.sleep(3000);
        WebElement s04 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[5]/td[2]")));
        assertTrue(s04.isDisplayed());
        Thread.sleep(3000);
    }

    @And("User click fish products By Id")
    public void userClickFishProductsById() {
        WebElement id1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")));
        id1.click();

    }

    @Then("Direct user to species of fish page by id")
    public static void directUserToSpeciesOfFishPageById() {
        driver.navigate().to(URL+"actions/Catalog.action?viewProduct=&productId=FI-SW-01");
    }

    @And("User view some species of fish by id")
    public void userViewSomeSpeciesOfFishById() {
        driver.findElement(By.xpath("//*[@id=\"Catalog\"]/h2")).isDisplayed();
    }

    @And("User click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
    }

    @Then("Direct user to shopping cart page")
    public void directUserToShoppingCartPage() {
        driver.navigate().to(URL+"actions/Cart.action?addItemToCart=&workingItemId=EST-1");
    }
    @And("user view shopping cart page")
    public void userViewShoppingCartPage() {

        driver.findElement(By.xpath("//*[@id='Cart']/h2")).isDisplayed();
    }
    @And("user input fish quantity {string}")
    public void userInputFishQuantity(String qty) throws Exception{
        this.qty = qty;

        WebElement qtY = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@size='3']")));
        qtY.clear();
        qtY.sendKeys(""+qty);
        Thread.sleep(3000);
    }


    @And("user click update cart button")
    public void userClickUpdateCartButton() throws Exception{

        driver.findElement(By.xpath("//*[@name='updateCartQuantities']")).click();
            Thread.sleep(3000);
    }

    @And("user click cart button")
    public void userClickCartButton() throws Exception {


        driver.navigate().refresh();
            Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@name='img_cart']")).click();

    }

    @Then("User can see product that have been added")
    public void userCanSeeProductThatHaveBeenAdded(){

        WebElement carts = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Cart']/h2")));
        carts.isDisplayed();
        driver.quit();
    }

}
