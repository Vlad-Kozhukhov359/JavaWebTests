package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-test-id='enter-action']");
    private SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private SelenideElement registrationButton = $x("//div[@class='external-oauth-login-footer']/a[@data-l='t,register']");

    // Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement googleButton = $("[data-l='t,google']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");

    // Локатор для элемента с сообщением об ошибке входа
    private SelenideElement errorMessage = $("[data-test-id='login-form-error']");

    @Step("Проверка видимости всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        googleButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
    }

    @Step("Проверка видимости сообщения об ошибке")
    public boolean isErrorMessageVisible() {
        boolean isVisible = errorMessage.shouldBe(visible).exists();
        logger.info("Сообщение об ошибке видимо: {}", isVisible);
        return isVisible;
    }

    @Step("Получение текста сообщения об ошибке")
    public String getErrorMessageText() {
        String errorText = errorMessage.shouldBe(visible).getText();
        logger.info("Текст сообщения об ошибке: {}", errorText);
        return errorText;
    }

    @Step("Ввод логина")
    public void enterUsername(String username) {
        logger.info("Ввод логина: {}", username);
        logger.info("Проверка видимости поля логина");
        usernameField.shouldBe(visible).click();
        logger.info("Поле логина кликнуто, вводим значение");
        usernameField.setValue(username);
        logger.info("Логин введен");
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        logger.info("Ввод пароля");
        logger.info("Проверка видимости поля пароля");
        passwordField.shouldBe(visible).click();
        logger.info("Поле пароля кликнуто, вводим значение");
        passwordField.setValue(password);
        logger.info("Пароль введен");
    }

    @Step("Нажатие кнопки входа")
    public void clickLoginButton() {
        logger.info("Проверка видимости кнопки входа");
        loginButton.shouldBe(visible).click();
        logger.info("Нажата кнопка входа");
    }

    @Step("Ввод логина и пароля")
    public void enterUsernamePassword(String username, String password) {
        logger.info("Попытка входа с логином: {}", username);
        logger.info("Проверка видимости поля логина");
        usernameField.shouldBe(visible).click();
        logger.info("Поле логина кликнуто, вводим значение");
        usernameField.setValue(username);
        logger.info("Логин введен, проверка видимости поля пароля");
        passwordField.shouldBe(visible).click();
        logger.info("Поле пароля кликнуто, вводим значение");
        passwordField.setValue(password);
        logger.info("Пароль введен, проверка видимости кнопки входа");
        loginButton.shouldBe(visible).click();
        logger.info("Нажата кнопка входа");
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    // Методы для перехода на страницы авторизации через соцсети
    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Google")
    public void loginWithGoogle() {
        googleButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    public void loginWithMailRu() {
        mailRuButton.shouldBe(visible).click();
    }
}
