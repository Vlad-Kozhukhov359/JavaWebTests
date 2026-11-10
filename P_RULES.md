# Правила для проекта JavaWebTests

## Язык общения
Всегда отвечать на русском языке.

## Правила разработки

### 1. Структура Page Object
- Все страницы наследуются от `BasePage`
- Локаторы хранятся как `private SelenideElement` поля в начале класса

### 2. Локаторы
Использовать селекторы в стиле проекта:
- CSS селекторы через `$("[attribute='value']")`
- XPath через `$x("//tag[@attribute='value']")`
- `data-l` атрибуты для интерактивных элементов

### 3. Методы страниц
- Все действия с элементами должны быть в `@Step` методах
- Использовать `shouldBe(visible)` перед взаимодействием
- Методы должны быть описательными на русском языке

### 4. Стиль кода
- Импорты статические в конце блока импортов
- Пустые строки между логическими блоками
- Комментарии на русском языке

### 5. Тестируемый сайт
Похоже на OK.ru (социальная сеть). Использовать соответствующие термины и контекст.

### 6. Отчетность
Allure `@Step` аннотации для всех методов с описанием на русском.

## Пример структуры

```java
package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-l='t,sign_in']");

    @Step("Ввод логина")
    public void enterUsername(String username) {
        usernameField.shouldBe(visible).setValue(username);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Нажатие кнопки входа")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }
}
```
