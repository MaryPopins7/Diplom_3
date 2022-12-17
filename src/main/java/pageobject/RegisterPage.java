package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
    private final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By register = By.className("Auth_link__1fOlj");
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    @Step("Клик по кнопке Войти в Аккаунт")
    public void clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
    }
    @Step("Клик по кнопке 'Зарегистрироваться' на странице авторизации")
    public void clickRegisterButtonLink() {
        driver.findElement(register).click();
    }
    @Step("Заполнение поля Имя")
    public void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    @Step("Заполнения поля email")
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Заполнение поля Пароль")
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Клик по кнопке 'Зарегистрироваться' на странице регистрации")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Отображение ошибки Неккоректный Пароль")
    public boolean getPasswordError() {
        return driver.findElement(passwordError).isDisplayed();
    }
    @Step("Отображение кнопки 'Войти' после регистрации")
    public boolean enterButtonIsDisplayed() {
        return driver.findElement(enterButton).isDisplayed();
    }
    @Step("Успешная регистрация")
    public void registration(String name, String email, String password) {
        clickEnterAccountButton();
        clickRegisterButtonLink();
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
        enterButtonIsDisplayed();
    }
    @Step("Ошибка при регистрации")
    public void registrationFailed(String name, String email, String password) {
        clickEnterAccountButton();
        clickRegisterButtonLink();
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
        getPasswordError();
    }
}