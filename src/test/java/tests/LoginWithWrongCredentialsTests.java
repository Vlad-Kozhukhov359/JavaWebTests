package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredentialsTests extends BaseTest {
    private static LoginPage loginPage;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void prepare() {
        logger.info("Открываем страницу входа: {}", baseUrl);
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookieIfPresent();
        loginPage.acceptPrivacyIfPresent();
        logger.info("Подготовка теста завершена");
    }

    @Test
    public void loginWithWrongCredentials() {
        logger.info("Начало теста: вход с неверными данными");
        loginPage.enterUsernamePassword("incorrectUser", "IncorrectPassword");

        // Проверяем, что сообщение об ошибке отображается
        assertTrue(loginPage.isErrorMessageVisible(),"Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
        logger.info("Тест завершен успешно");
    }
}
