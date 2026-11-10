package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByPhonePage extends BasePage {

    private SelenideElement countryDropdown = $("[data-l='t,country']");
    private SelenideElement phoneInputField = $("[data-l='t,phone']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления по телефону")
    private void verifyPageElements() {
        countryDropdown.shouldBe(visible);
        phoneInputField.shouldBe(visible);
    }

    @Step("Выбираем страну по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.shouldBe(visible).click();
        // Логика выбора страны из выпадающего списка
        // Возвращаем код выбранной страны
        return countryName;
    }

    @Step("Вводим номер телефона: {phoneNumber}")
    public void enterPhoneNumber(String phoneNumber) {
        phoneInputField.shouldBe(visible).setValue(phoneNumber);
    }
}
