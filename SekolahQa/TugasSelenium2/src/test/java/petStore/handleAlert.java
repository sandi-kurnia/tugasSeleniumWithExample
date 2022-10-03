package petStore;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleAlert {

    //Halo bang, karena aku terlanjur ngetest di web yang aku test, jd aku ga nemu Function Alert di web JPetStore
    //Alhasil aku bikin disini aja sebagai latihan.

    @Test
    public void test1() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");//chromedriver tidak menggunakkan .exe karena testing di macbook jd file .exe tidak terbaca
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        driver.findElement(By.id("alertButton")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test2() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();


        driver.findElement(By.id("timerAlertButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test3() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        driver.findElement(By.id("confirmButton")).click();
        Alert confirmationAlert = driver.switchTo().alert();

        confirmationAlert.accept();
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test4() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        Thread.sleep(3000);
        driver.close();
    }

}