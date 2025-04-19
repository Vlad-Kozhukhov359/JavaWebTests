package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public abstract class BasePage {

    // Примеры поиска элементов
    // XPathResult =$("[data-l='t,vk_ecosystem']")
    // XPathResult = $("[name='st.query']")


    // Примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    // можно так $x("//input[@name='st.query']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");


    // Метод для поиска по сайту
    public void search(String query){
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    // Пример общео метода поиска для клика по иконке уведомлений
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    // Клик на логотип ОК
    public void clickLogo () {
        headerLogo.shouldBe(visible).click();
    }

    // Другие общие методы, например, для проверки загрузки страницы, авторизации и т.д

}
