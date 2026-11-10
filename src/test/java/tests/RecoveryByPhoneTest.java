package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryByPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;

public class RecoveryByPhoneTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhonePage recoveryByPhonePage;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void prepare() {
        logger.info("Открываем страницу входа: {}", baseUrl);
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Проверка выбора страны при восстановлении по номеру телефона")
    public void selectCountryForRecoveryByPhone() {
        loginPage.enterUsername("incorrectUser");
        loginPage.enterPassword("incorrectPassword");
        loginPage.clickLoginButton();
        for (int i = 0; i < 2; i++) {
            loginPage.enterPassword("incorrectPassword");
            loginPage.clickLoginButton();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        recoveryByPhonePage = new RecoveryByPhonePage();
        
        String countryCode = recoveryByPhonePage.selectCountryByName("Россия");
        logger.info("Выбрана страна с кодом: {}", countryCode);
    }
}
