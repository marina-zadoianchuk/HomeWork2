package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PantsPage extends BaseView {
    private static final String pantsCategoryUrl = "11";
    public PantsPage(WebDriver driver) {
        super(driver);
      //  this.categoryList = categoryList;
    }
    private static final String categoryListXpath = "//fieldset[@class='j-list filter__fieldset list_left_xsubject render_type_1 filter__fieldset--limited']/label";
    @FindBy(xpath = categoryListXpath)
    private List<WebElement> categoryList;

    public PantsPage selectCategory(String category) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(categoryListXpath))));
        categoryList.stream().filter(d -> d.getText().contains(category)).findFirst().get().click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(categoryListXpath))));
        Assertions.assertTrue(driver.getCurrentUrl().contains(pantsCategoryUrl));
        return new PantsPage(driver);
    }

}
