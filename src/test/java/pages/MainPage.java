package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
    private final SelenideElement mainRequestDemoButton = $("#dr_box a[href*='/demo-request/']"),
                                  subscribeButton = $(".newsletter-form a[href*='/subscribe-to-revizto-reporter/']"),
                                  acceptCookiesButton = $("#cookiescript_accept");
                                  
    private final SelenideElement solutionsMenu = $("#menu-item-7298"),
                                  companyMenu = $x("//a[text()='Company']");
    
    private final SelenideElement careersMenuItem = $x("//a[text()='Careers']");
    
    private final SelenideElement newsSectionRoot = $("#news-media-section, .news-slider, .slick-slider"),
                                  previousNewsButton = $(".slick-arrow.left");
                                  
    private final By visibleSlides = By.cssSelector(".slick-slide.slick-active[aria-hidden='false']");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Нажать главную кнопку Request Demo")
    public MainPage clickMainRequestDemoButton() {
        mainRequestDemoButton.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать кнопку подписки")
    public MainPage clickSubscribeButton() {
        acceptCookiesIfPresent();
        subscribeButton.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на меню Solutions")
    public MainPage clickSolutionsMenu() {
        solutionsMenu.shouldBe(visible).click();
        return this;
    }

    @Step("Навести курсор на меню Company")
    public MainPage hoverCompanyMenu() {
        companyMenu.hover();
        return this;
    }

    @Step("Нажать на пункт Careers")
    public MainPage clickCareersMenuItem() {
        careersMenuItem.shouldBe(visible).click();
        return this;
    }

    @Step("Прокрутить к секции новостей")
    public MainPage scrollToNewsMediaSection() {
        executeJavaScript(
            "arguments[0].scrollIntoView({block:'center', inline:'nearest', behavior:'instant'})",
            newsSectionRoot
        );
        return this;
    }

    @Step("Нажать кнопку Previous в новостях")
    public MainPage clickPreviousNewsButton() {
        previousNewsButton.shouldBe(enabled).click();
        return this;
    }

    @Step("Получить ключ первой видимой карточки новостей")
    public String getFirstVisibleCardKey() {
        SelenideElement first = newsSectionRoot.$$(visibleSlides).first();
        return first.$("a.post-box-area").getAttribute("href");
    }

    private void acceptCookiesIfPresent() {
        if (acceptCookiesButton.exists()) {
            acceptCookiesButton.click();
        }
    }
}