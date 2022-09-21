package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.gb.lesson6.NavigationBlock.forWomanXpath;

public class MainPage extends BaseView{
    public NavigationBlock navigationBlock;
    public MainPage(WebDriver driver) {
        super(driver);
        navigationBlock = new NavigationBlock(driver);
    }
    @FindBy(xpath = "//button[@aria-label='Навигация по сайту']")
    private WebElement navigatonButton;
    public MainPage clickNavigationButton(){
        navigatonButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(forWomanXpath))));
        return this;
    }
}
