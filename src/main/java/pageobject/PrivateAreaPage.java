package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivateAreaPage {
    private final WebDriver driver;
    public PrivateAreaPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By privateAreaButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By privateAreaDescription = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private final By constructor = By.xpath(".//p[text()='Конструктор']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By loginText = By.xpath(".//h2[text()='Вход']");
    @Step("Клик по кнопке Личный Кабинет")
    public void clickPrivateAreaButton() {
        driver.findElement(privateAreaButton).click();
    }
    @Step("Отображение описания Личного Кабинета")
    public boolean privateAreaDescriptionIsDisplayed() {
        return driver.findElement(privateAreaDescription).isDisplayed();
    }
    @Step("Клик по кнопке Конструктор из личного кабинета")
    public void clickConstructor() {
        driver.findElement(constructor).click();
    }
    @Step("Клик по Лого из личного кабинета")
    public void clickLogo() {
        driver.findElement(logo).click();
    }
    @Step("Клик по кнопке Выйти")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
    @Step("Отображение кнопки Войти на странице авторизации")
    public boolean loginTextIsDisplayed() {
        return driver.findElement(loginText).isDisplayed();
    }
    @Step("Выход из Личного Кабинета")
    public void logoutFromPrivateArea() {
        clickPrivateAreaButton();
        clickLogoutButton();
        loginTextIsDisplayed();
    }
}