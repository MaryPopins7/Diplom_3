package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPageBurger {
    private final WebDriver driver;
    public LoginPageBurger(WebDriver driver) {
        this.driver = driver;
    }
    public By privateAreaLink = By.xpath(".//p[text()='Личный Кабинет']");
    public By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    public By enterButton = By.xpath(".//button[text()='Войти']");
    public By emailField = By.xpath(".//fieldset[1]/div/div/input");
    public By passwordField = By.xpath(".//fieldset[2]/div/div/input");
    public By enterAuthButton = By.xpath(".//button[text()='Войти']");
    public By orderSubmitButton = By.xpath(".//button[text()='Оформить заказ']");
    public By forgotPassword = By.xpath(".//a[@href='/forgot-password']");
    public By rememberPassword = By.xpath(".//a[@href='/login']");

    @Step("Клик по кнопке 'Личный Кабинет'")
    public void clickPrivateAreaLink() {
        driver.findElement(privateAreaLink).click();
    }
    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
    }
    @Step("Заполняем поле email")
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Заполняем поле password")
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Клик по кнопке Войти в форме авторизации через 'Личный кабинет'")
    public void clickEnterLoginButton() {
        driver.findElement(enterAuthButton).click();
    }
    @Step("Клик по кнопке 'Войти' через форму 'Войти в аккаунт'")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    @Step("Отображение кнопки 'Оформить Заказ' после успешной авторизации")
    public boolean orderSubmitButtonIsDisplayed() {
        return driver.findElement(orderSubmitButton).isDisplayed();
    }
    @Step("Клик по кнопке 'Восстановить пароль'")
    public void clickForgotPassword() {
        driver.findElement(forgotPassword).click();
    }
    @Step("Клик по кнопке 'Войти' на странице восстановления пароля")
    public void clickRememberPassword() {
        driver.findElement(rememberPassword).click();
    }
    @Step("Авторизация через кнопку 'Войти в аккаунт'")
    public void loginByEnterAccountButton(String email, String password) {
        clickEnterAccountButton();
        fillEmail(email);
        fillPassword(password);
        clickEnterButton();
        orderSubmitButtonIsDisplayed();
    }
    @Step("Авторизация через кнопку 'Личный Кабинет'")
    public void loginByPrivateArea(String email, String password) {
        clickPrivateAreaLink();
        fillEmail(email);
        fillPassword(password);
        clickEnterLoginButton();
        orderSubmitButtonIsDisplayed();
    }
    @Step("Авторизация через форму восстановления пароля")
    public void loginByChangePassword(String emailAuth, String password) {
        clickEnterAccountButton();
        clickForgotPassword();
        clickRememberPassword();
        fillEmail(emailAuth);
        fillPassword(password);
        clickEnterLoginButton();
        orderSubmitButtonIsDisplayed();
    }
}

