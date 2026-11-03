package core.base;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Приметы общих элементов которые могут использоваться на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $x("//input[@name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement acceptCookieButton = $(".cb_accept");
    protected SelenideElement acceptPrivacyButton = $(".cmptxt_btn_yes");



    @Step ("Метод для поиска по сайту")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step ("Открываем вк сервисы")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Принять куки")
    public void acceptCookie() {
        acceptCookieButton.shouldBe(visible).click();
    }

    @Step("Принять куки (если элемент присутствует)")
    public void acceptCookieIfPresent() {
        if (acceptCookieButton.is(visible)) {
            logger.info("Кнопка принятия куки найдена, кликаем");
            acceptCookieButton.click();
        } else {
            logger.info("Кнопка принятия куки не найдена, пропускаем");
        }
    }

    @Step("Принять приватность")
    public void acceptPrivacy() {
        acceptPrivacyButton.shouldBe(visible).click();
    }

    @Step("Принять приватность (если элемент присутствует)")
    public void acceptPrivacyIfPresent() {
        if (acceptPrivacyButton.is(visible)) {
            logger.info("Кнопка принятия приватности найдена, кликаем");
            acceptPrivacyButton.click();
        } else {
            logger.info("Кнопка принятия приватности не найдена, пропускаем");
        }
    }

}
