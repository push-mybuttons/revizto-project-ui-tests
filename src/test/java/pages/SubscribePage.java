package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class SubscribePage {

    private static final String EXPECTED_TITLE = "Stay tuned!";
    private static final String THANK_YOU_TITLE = "Thank You for Subscribing";

    private final SelenideElement pageTitle = $("h1"),
                                  subscribeForm = $("form");

    private final SelenideElement emailInput = $("input[type='email']"),
                                  firstNameInput = $("input[name='fname']"),
                                  lastNameInput = $("input[name='lname']"),
                                  countryDropdown = $("#nf-field-382"),
                                  stateDropdown = $("#nf-field-386"),
                                  subscribeButton = $("input[type='submit']");

    private final SelenideElement processingButton = $("input[type='submit'][value='Processing']"),
                                  thankYouPageTitle = $("h1"),
                                  acceptCookiesButton = $("#cookiescript_accept");

    @Step("Открыть страницу подписки")
    public SubscribePage openPage() {
        open("/subscribe-to-revizto-reporter/");
        subscribeForm.shouldBe(visible);
        countryDropdown.shouldBe(visible, enabled);
        return this;
    }

    @Step("Проверить видимость заголовка страницы")
    public SubscribePage verifyPageTitleVisible() {
        pageTitle.shouldBe(visible).shouldHave(text(EXPECTED_TITLE));
        return this;
    }

    @Step("Ввести email: {email}")
    public SubscribePage enterEmail(String email) {
        emailInput.shouldBe(visible, enabled).setValue(email);
        return this;
    }

    @Step("Ввести имя: {firstName}")
    public SubscribePage enterFirstName(String firstName) {
        firstNameInput.shouldBe(visible, enabled).setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию: {lastName}")
    public SubscribePage enterLastName(String lastName) {
        lastNameInput.shouldBe(visible, enabled).setValue(lastName);
        return this;
    }

    @Step("Выбрать страну: {country}")
    public SubscribePage selectCountry(String country) {
        countryDropdown.shouldBe(visible, enabled);
        sleep(2000);
        countryDropdown.selectOption(country);
        return this;
    }

    @Step("Выбрать штат (если доступно): {state}")
    public SubscribePage selectStateIfPresent(String state) {
        if (stateDropdown.isDisplayed()) {
            stateDropdown.shouldBe(visible, enabled).selectOption(state);
        }
        return this;
    }

    @Step("Нажать кнопку подписки")
    public SubscribePage clickSubscribeButton() {
        acceptCookiesIfPresent();
        subscribeButton.shouldBe(visible, enabled).click();
        processingButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить видимость заголовка страницы благодарности")
    public SubscribePage verifyThankYouPageTitle() {
        thankYouPageTitle.shouldBe(visible).shouldHave(text(THANK_YOU_TITLE));
        return this;
    }

    @Step("Ждать страницу благодарности")
    public SubscribePage waitForThankYouPage() {
        thankYouPageTitle.shouldBe(visible);
        return this;
    }

    private void acceptCookiesIfPresent() {
        if (acceptCookiesButton.exists()) {
            acceptCookiesButton.click();
        }
    }
}
