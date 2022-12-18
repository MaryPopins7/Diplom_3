package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBurger {
    private final WebDriver driver;
    public HomePageBurger(WebDriver driver) {
        this.driver = driver;
    }
    private final By bunsChapter = By.xpath(".//span[text()='Булки']/..");
    private final By saucesChapter = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingChapter = By.xpath(".//span[text()='Начинки']/..");
    @Step("Проверка активности раздела 'Булки'")
    public String getClassNameBunsChapter() {

        return driver.findElement(bunsChapter).getAttribute("class");
    }
    @Step("Переход на раздел 'Соусы'")
    public void clickSaucesChapter() {
        driver.findElement(saucesChapter).click();
    }
    @Step("Проверка активности раздела 'Соусы'")
    public String getClassNameSaucesChapter() {
        return driver.findElement(saucesChapter).getAttribute("class");
    }
    @Step("Переход на раздел 'Начинки'")
    public void clickFillingChapter() {
        driver.findElement(fillingChapter).click();
    }
    @Step("Проверка активности раздела 'Начинки'")
    public String getClassNameFillingChapter() {
        return driver.findElement(fillingChapter).getAttribute("class");
    }
}