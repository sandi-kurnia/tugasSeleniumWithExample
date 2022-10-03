package petStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class loginPetStore {
    static WebDriver driver;
    static String URL = "https://petstore.octoperf.com/";
    static String UserID, Password;
    String textError = "Invalid username or password.  Signon failed.";
    WebDriverWait wait = new WebDriverWait(driver, 3000);

    @Given("User at Login Page")
    public static void userAtLoginPage() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(URL + "actions/Account.action?signonForm=");
        driver.manage().window().maximize();

//Interaction
        String getUrl1 = driver.getCurrentUrl();
                System.out.println("1.1 Url anda adalah "+getUrl1);
        String getTittle1 = driver.getTitle();
                System.out.println("1.2 Tittle anda adalah "+getTittle1);

    }

    @And("User enter User ID {string}")
    public void userEnterUserID(String UserID) {
        this.UserID = UserID;
        WebElement userID = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='username']")));
        userID.sendKeys("" + UserID);

    }

    @And("User enter Valid Password {string}")
    public void userEnterValidPassword(String Password) {
        this.Password = Password;
        WebElement uInputPass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        uInputPass.clear();
        uInputPass.sendKeys(""+Password);
    }

    @When("User click login button to login")
    public void userClickLoginButtonToLogin() {
        WebElement uButtonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("signon")));
        uButtonLogin.isEnabled();
        uButtonLogin.click();
        //driver.findElement(By.name("signon")).click();
    }

    @Then("User get Alert in home page")
    public void userGetAlertInHomePage() throws Exception {
        WebElement uWelcome = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"WelcomeContent\"]")));
        assertTrue(uWelcome.isDisplayed());


//Interaction
        String getUrl2 =driver.getCurrentUrl();
                System.out.println("2.1 Url anda adalah "+getUrl2);
        String getTittle2= driver.getTitle();
                System.out.println("2.2 Tittle anda adalah "+getTittle2);
        String getText = driver.findElement(By.xpath("//*[@id=\"WelcomeContent\"]")).getText();
                System.out.println("3.1 Textnya adalah "+getText);
        String getAtribut1 = driver.findElement(By.xpath("//*[@id=\"WelcomeContent\"]")).getAttribute("id");
                System.out.println("4.1 Atributnya adalah "+getAtribut1);
        WebElement getSize1 = driver.findElement(By.xpath("//*[@id=\"WelcomeContent\"]"));
        Dimension ugetSize = getSize1.getSize();
                System.out.println("5.1 Size nya adalah "+ugetSize);
        WebElement ugetLoc = driver.findElement(By.xpath("//*[@id=\"WelcomeContent\"]"));
        Point uPoin = ugetLoc.getLocation();
                System.out.println("6.1 lokasi X = "+uPoin.x+" dan Y ="+uPoin.y);
                        Thread.sleep(4000);
//Behavior
        driver.navigate().back();
                        Thread.sleep(4000);
        driver.navigate().forward();
                        Thread.sleep(4000);
        driver.navigate().refresh();
                        Thread.sleep(4000);

        driver.quit();
    }

    @Then("User get Alert \"Invalid username or password. Signon failed.\"")
    public void userGetAlertCanTLogin() throws Exception {
        assertEquals("Invalid username or password.  Signon failed.", textError.substring(textError.length()-"Invalid username or password.  Signon failed.".length()));
    Thread.sleep(3000);

//Interaction
        String getUrl2 =driver.getCurrentUrl();
                System.out.println("2.1 Url anda adalah "+getUrl2);
        String getTittle2= driver.getTitle();
                System.out.println("2.2 Tittle anda adalah "+getTittle2);
        String getText = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/p[1]")).getText();
                System.out.println("3.1 Textnya adalah "+getText);
        String getAtribut1 = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form")).getAttribute("method");
                System.out.println("4.1 Atributnya adalah "+getAtribut1);
        WebElement getSize1 = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/p[1]"));
        Dimension ugetSize = getSize1.getSize();
                System.out.println("5.1 Size nya adalah "+ugetSize);
        WebElement ugetLoc = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/p[1]"));
        Point uPoin = ugetLoc.getLocation();
                System.out.println("6.1 lokasi X = "+uPoin.x+" dan Y ="+uPoin.y);
        Thread.sleep(4000);

    driver.quit();
    }

}
