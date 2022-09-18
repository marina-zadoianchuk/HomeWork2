package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KinopoiskTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.manage().window(). maximize() ;
        driver.get("https://hd.kinopoisk.ru/");
    }
    @Test
    void authTest() throws InterruptedException {
        driver.get("https://hd.kinopoisk.ru/");
        Thread.sleep(15000); //ожидание для прохождения капчи, в случае ее возникновения
        driver.findElement(By.xpath("//a[.='Войти']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("passp-field-login")));
        driver.findElement(By.id("passp-field-login")).sendKeys("wewicon674@dineroa.com");
        driver.findElement(By.id("passp:sign-in")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys("Test4test_678");
        driver.findElement(By.id("passp:sign-in")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Моё']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[.='Моё']")).isDisplayed());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
