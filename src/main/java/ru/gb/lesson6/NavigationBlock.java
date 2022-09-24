package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBlock extends BaseView{
    public NavigationBlock(WebDriver driver) {
        super(driver);
    }
    public static final String forWomanXpath = "//a[.='Женщинам']";
    @FindBy(xpath = forWomanXpath)
    private WebElement forWoman;

    private static final String pantsForWomenXpath = "//div[contains(@class,'item--active')]//ul[contains(@class, 'menu-burger__set')]//a[.='Брюки']";
    @FindBy(xpath = pantsForWomenXpath)
    private WebElement pantsForWomen;
  //  @Step("Наведение на категорию женщинам и клик на категорию брюки")
    public PantsPage GoToPantsForWomanPage(){
        webDriverWait.until(ExpectedConditions.visibilityOf(forWoman));
        actions.moveToElement(forWoman)
                .perform();
        //   webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(forWomanXpath))));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(pantsForWomenXpath))));
        pantsForWomen.click();

        return new PantsPage(driver);
    }
}