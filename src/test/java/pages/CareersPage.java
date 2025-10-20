package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;   

public class CareersPage {

    private final SelenideElement pageTitle = $("h1");

    @Step("Проверить видимость заголовка страницы")
    public CareersPage verifyPageTitleVisible() {
        pageTitle.shouldBe(visible);
        return this;
    }
}