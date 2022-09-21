package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PantsPage extends BaseView {
    private static final String pantsCategoryUrl = "11";
    public PantsPage(WebDriver driver) {
        super(driver);
      //  this.categoryList = categoryList;
    }
    @FindBy(xpath = "//div[contains(@data-filter-name, 'xsubject')]")
    private List<WebElement> categoryList;

    public PantsPage selectCategory(String category) throws InterruptedException {
        Thread.sleep(15000); //ожидание для дебага
        categoryList.stream().filter(d -> d.getText().contains(category)).findFirst().get().click();
        Thread.sleep(15000); //ожидание для дебага
        Assertions.assertTrue(driver.getCurrentUrl().contains(pantsCategoryUrl));
        return new PantsPage(driver);
    }

}
