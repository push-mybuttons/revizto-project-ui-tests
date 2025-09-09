package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoRequestPage {

    public static final String DEMO_REQUEST_URL = "https://revizto.com/en/demo-request/";

    private final SelenideElement formBox = $(".form_box"),
                                  pageTitle = $("h1"),
                                  demoForm = $("form"),
                                  submitButton = $("form button[type='submit'], form input[type='submit']");

    @Step("Открыть страницу запроса демо")
    public DemoRequestPage openPage() {
        open(DEMO_REQUEST_URL);
        formBox.shouldBe(visible);
        return this;
    }

    @Step("Нажать кнопку отправки формы")
    public DemoRequestPage clickSubmitButton() {
        submitButton.shouldBe(visible, enabled).click();
        return this;
    }

    public SelenideElement getFormBox() { return formBox; }
    public SelenideElement getPageTitle() { return pageTitle; }
    public SelenideElement getDemoForm() { return demoForm; }
    public SelenideElement getSubmitButton() { return submitButton; }
}
