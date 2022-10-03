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

import static org.junit.Assert.assertTrue;

public class registerPetStore {
    static WebDriver driver;
    static String URL = "https://petstore.octoperf.com/";
    static String UserID, Password, RepeatPassword, FirstName, LastName, Email, Phone, FirstAddress, SecondAddress, City, State, Zip, Country, LanguagePrefences, Category;
    WebDriverWait wait = new WebDriverWait(driver, 3000);



    @Given("User at Sign Pages")
    public static void userAtSignPages() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(URL + "actions/Account.action?signonForm=");
        driver.manage().window().maximize();

        String getUrl1 = driver.getCurrentUrl();
        String getTittle1 = driver.getTitle();
        System.out.println("1.1 Url anda adalah " + getUrl1);
        System.out.println("1.2 Tittle anda adalah " + getTittle1);

    }

    @When("User click Register buttons")
    public void userClickRegisterButtons() throws Exception {
        WebElement bClick = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Catalog']/a")));
        bClick.isEnabled();
        bClick.click();
    }

    @And("User input User ID {string}")
    public void userInput(String UserID) {
        this.UserID = UserID;
        WebElement userID = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='username']")));
        userID.sendKeys("" + UserID);
    }

    @And("User input Password {string}")
    public void userInputPassword(String Password) {
        this.Password = Password;
        WebElement newPass = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td>input[name=\"password\"]")));
        newPass.sendKeys("" + Password);
    }

    @And("User input Repeat Password {string}")
    public void userInputRepeatPassword(String RepeatPassword) {
        this.RepeatPassword = RepeatPassword;
        WebElement newRePass = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td>input[name=\"repeatedPassword\"]")));
        newRePass.sendKeys("" + RepeatPassword);
    }

    @And("User input First Name {string}")
    public void userInputFirstName(String FirstName) {
        this.FirstName = FirstName;
        WebElement fName = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.firstName")));
        fName.sendKeys("" + FirstName);
    }

    @And("User input Last Name {string}")
    public void userInputLastName(String LastName) {
        this.LastName = LastName;
        WebElement lName = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.lastName")));
        lName.sendKeys("" + LastName);
    }

    @And("User input Email {string}")
    public void userInputEmail(String Email) {
        this.Email = Email;
        WebElement uEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.email")));
        uEmail.sendKeys("" + Email);
    }

    @And("User input Phone {string}")
    public void userInputPhone(String Phone) {
        this.Phone = Phone;
        WebElement uPhone = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.phone")));
        uPhone.sendKeys("" + Phone);
    }

    @And("User input First Address {string}")
    public void userInputFirstAddress(String FirstAddress) {
        this.FirstAddress = FirstAddress;
        WebElement address1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.address1")));
        address1.sendKeys("" + FirstAddress);
    }

    @And("User input Second Address  {string}")
    public void userInputSecondAddress(String SecondAddress) {
        this.SecondAddress = SecondAddress;
        WebElement address2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.address2")));
        address2.sendKeys("" + SecondAddress);
    }

    @And("User input City {string}")
    public void userInputCity(String City) {
        this.City = City;
        WebElement uCity = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.city")));
        uCity.sendKeys("" + City);
    }

    @And("User input State {string}")
    public void userInputState(String State) {
        this.State = State;
        WebElement uState = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.state")));
        uState.sendKeys("" + State);
    }

    @And("User input Zip {string}")
    public void userInputZip(String Zip) {
        this.Zip = Zip;
        WebElement uZip = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.zip")));
        uZip.sendKeys("" + Zip);
    }

    @And("User input Country {string}")
    public void userInputCountry(String Country) {
        this.Country = Country;
        WebElement uCountry = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.country")));
        uCountry.sendKeys("" + Country);
    }

    @And("User select Language Preferences {string}")
    public void userSelectLanguagePreferences(String LanguagePrefences) throws Exception {
        this.LanguagePrefences = LanguagePrefences;
//DropDown
        WebElement uLanguage = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.languagePreference")));
        uLanguage.findElement(By.xpath("//option[. = 'japanese']")).click();
        Thread.sleep(4000);
//Select By Value
        Select ouSelect = new Select(driver.findElement(By.name("account.languagePreference")));
        ouSelect.selectByValue("" + LanguagePrefences);
        Thread.sleep(3000);
    }

    @And("User select Favourite Categories {string}")
    public void userSelectFavouriteCategories(String Category) throws Exception {
        this.Category = Category;
        //DropDown
        WebElement uFavourite = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.favouriteCategoryId")));
        uFavourite.findElement(By.xpath("//option[. = 'FISH']")).click();
        Thread.sleep(3000);
        Select uSelect = new Select(driver.findElement(By.name("account.favouriteCategoryId")));
//Select By Index
        uSelect.selectByIndex(2);
        Thread.sleep(3000);
//Select By Text
        uSelect.selectByVisibleText("" + Category);
        Thread.sleep(3000);


    }

    @And("User select Enable MyLists")
    public void userSelectEnableMyLists() {
//Checkbox
        WebElement uEnableList = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.listOption")));
        uEnableList.click();
    }

    @And("User select Enable MyBanners")
    public void userSelectEnableMyBanners() {
//Checkbox
        WebElement uEnableBanner = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("account.bannerOption")));
        uEnableBanner.click();
    }

    @And("User click User Account Informations Button to Register")
    public void userClickUserAccountInformations() {
        WebElement submitAcc = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("newAccount")));
        submitAcc.isEnabled();
        submitAcc.click();
    }

    @Then("Direct user to MainPages")
    public static void directUserToMainPages() {
        driver.navigate().to(URL + "actions/Account.action");
        driver.quit();
    }
}


