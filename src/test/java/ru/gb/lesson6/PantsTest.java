package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import ru.gb.lesson7.AdditionalLogger;
import ru.gb.lesson7.JunitExtension;

import java.io.ByteArrayInputStream;

@Story("Выбор подраздела")
public class PantsTest {
    WebDriver driver;
    MainPage mainPage;

    @RegisterExtension
    JunitExtension testWatcher = new JunitExtension();
    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        mainPage = new MainPage(driver);

        driver.get("https://www.wildberries.ru/");
    }
    //Открыть главную страницу сайта https://www.wildberries.ru/
    //Нажать на главное меню -> Навести курсор мыши на раздел "Женщинам" -> кликнуть на раздел "Брюки"
    // Выбрать в списке чекбокс "брюки"
    // Проверить срабатывания фильтра с помощью добавления в url номера подраздела (для брюк 11)
    @Feature("Выбор категори  брюки из списка чекбоксов")
    @Test
    void PantsTest() throws InterruptedException  {
        mainPage.clickNavigationButton()
                .navigationBlock
                .GoToPantsForWomanPage()
                .selectCategory("Брюки");

    }
    @AfterEach
    void tearDown(){
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: logs) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }

        testWatcher.setScreenshot(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }
}
