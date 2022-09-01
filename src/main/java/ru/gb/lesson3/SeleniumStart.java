package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        /* 1. Запуск развёрнутого на весь экран браузера.
        2. Переход на сайт https://market.yandex.ru/
        3. Перейти к разделу "Компьютеры" и выбрать "Ноутбуки".
        4. Задать параметры поиска:
        - Производитель: Lenovo (с возможностью замены в будущем)
        5. Закрыть браузер.*/
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        chromeDriver.manage().window(). maximize() ;
        chromeDriver.get("https://market.yandex.ru/");
        Thread.sleep(25000);// ожидание для ввода капчи
      //chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriver.findElement(By.xpath("//div[contains(@class, '_10dWC')]")).click();
        WebDriverWait chromeDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Компьютеры']")));
        chromeDriver.findElement(By.xpath("//span[.='Компьютеры']")).click();
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Ноутбуки']")));
        chromeDriver.findElement(By.xpath("//a[.='Ноутбуки']")).click();
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Lenovo']")));
        chromeDriver.findElement(By.xpath("//span[.='Lenovo']")).click();

        Thread.sleep(5000);
        chromeDriver.quit();
    }
}
