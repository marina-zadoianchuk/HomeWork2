package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PantsTest {
    WebDriver driver;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {

        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("https://www.wildberries.ru/");
    }
    //Открыть главную страницу сайта https://www.wildberries.ru/
    //Нажать на главное меню -> Навести курсор мыши на раздел "Женщинам" -> кликнуть на раздел "Брюки"
    // Выбрать в списке чекбокс "брюки"
    // Проверить срабатывания фильтра с помощью добавления в url номера подраздела (для брюк 11)

    @Test
    void PantsTest() throws InterruptedException {
        mainPage.clickNavigationButton().navigationBlock.GoToPantsForWomanPage()
                .selectCategory("Брюки");

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
