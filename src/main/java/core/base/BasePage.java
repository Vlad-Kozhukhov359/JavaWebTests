package core.base;


import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    // Приметы общих элементов которые могут использоваться на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $x("//input[@name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    // Метод для поиска по сайту
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    // Пример общего метода для клика по иконке уведомлений
    public void openNotifications() {
        vkServices.click();
    }

    public void clickOnLogo() {
        headerLogo.shouldBe(visible).click();
    }

}
