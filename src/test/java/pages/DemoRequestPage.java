package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class DemoRequestPage {
    private final SelenideElement formBox = $(".form_box");

    @Step("Проверить видимость формы запроса демо")
    public DemoRequestPage verifyFormBoxVisible() {
        formBox.shouldBe(visible);
        return this;
    }
}
