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

public class EnterPasswordOnlyTests extends BaseTest {
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
    public void enterPasswordOnly() {
        logger.info("Начало теста: ввод только пароля");
        loginPage.enterPassword("testPassword");
        loginPage.clickLoginButton();

        // Ждем появления сообщения об ошибке
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("Ошибка при ожидании", e);
        }

        // Проверяем, что сообщение об ошибке отображается
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getErrorMessageText();
        logger.info("Ожидаемый текст ошибки: '{}'", expectedErrorMessage);
        logger.info("Фактический текст ошибки: '{}'", actualErrorMessage);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
        logger.info("Тест завершен успешно");
    }
}
