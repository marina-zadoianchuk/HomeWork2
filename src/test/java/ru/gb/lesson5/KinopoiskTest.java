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
    //"Переход в раздел сериалы" с главной странице кинопоиска
    //1. Навести кнопку мыши на раздел кинопоиск
    //2. Выбрать сериалы и перейти на страницу
    //3. Убедиться, что верно перешли на раздел сериалы, сравнив url
    @Test
    void goToSerialTest() throws InterruptedException {
        Thread.sleep(25000);
        actions.moveToElement(driver.findElement(By.xpath("//div[contains(@class, 'HeaderNavigationMenu_root')]")))
                .perform();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'HeaderNavigationMenu_dropdown-menu')]//a[.='Сериалы']")));
        driver.findElement(By.xpath("//div[contains(@class, 'HeaderNavigationMenu_dropdown-menu')]//a[.='Сериалы']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("/movies/3/"));
    }
    //"Авторизация на сайте кинопоиска"
    // 1. Нажать на кнопку войти
    // 2. Ввести логин
    // 3. Ввести пароль
    // 4. проверить успешность авторизации по появлению раздела "Мое"
    @Test
    void authTest() throws InterruptedException {
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

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
