package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoveryTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void prepare() {
        logger.info("Открываем страницу входа: {}", baseUrl);
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void goToAnonymRecoveryPage() {
        loginPage.enterUsername("incorrectUser");
        loginPage.enterPassword("incorrectPassword");
        loginPage.clickLoginButton();
        for (int i = 0; i < 2; i++) {
            loginPage.enterPassword("incorrectPassword");
            loginPage.clickLoginButton();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
    }
}