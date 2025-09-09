package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
    private static final String DROPDOWN_MENU_SELECTOR = "div[contains(@class, 'sub-menu') or contains(@class, 'dropdown-menu')]";
    
    private final SelenideElement signInButton = $x("//header//a[contains(text(), 'SIGN IN')]"),
                                  headerRequestDemoButton = $x("//header//a[contains(text(), 'Request a Demo')]"),
                                  mainRequestDemoButton = $x("//section[contains(@class, 'hero')]//a[contains(text(), 'Request a Demo')]"),
                                  headerLogo = $("header .logo img, header img[alt*='Revizto']"),
                                  mainTitle = $("section[class*='hero'] h1"),
                                  subscribeButton = $(".newsletter-form a[href*='/subscribe-to-revizto-reporter/']"),
                                  acceptCookiesButton = $("#cookiescript_accept");
                                  
    private final SelenideElement solutionsMenu = $("#menu-item-7298"),
                                  companyMenu = $x("//a[text()='Company']");
    
    private final SelenideElement architectsMenuItem = $x("//" + DROPDOWN_MENU_SELECTOR + "//a[contains(text(), 'Architects')]"),
                                  engineersMenuItem = $x("//" + DROPDOWN_MENU_SELECTOR + "//a[contains(text(), 'Engineers')]"),
                                  contractorsMenuItem = $x("//" + DROPDOWN_MENU_SELECTOR + "//a[contains(text(), 'Contractors')]"),
                                  ownersMenuItem = $x("//" + DROPDOWN_MENU_SELECTOR + "//a[contains(text(), 'Owners')]");
    
    private final SelenideElement aboutMenuItem = $x("//" + DROPDOWN_MENU_SELECTOR + "//a[contains(text(), 'About')]"),
                                  careersMenuItem = $x("//a[text()='Careers']"),
                                  newsroomMenuItem = $x("//" + DROPDOWN_MENU_SELECTOR + "//a[contains(text(), 'Newsroom')]");
    
    private final SelenideElement newsSectionRoot = $("#news-media-section, .news-slider, .slick-slider"),
                                  previousNewsButton = $(".slick-arrow.left");
                                  
    private final By visibleSlides = By.cssSelector(".slick-slide.slick-active[aria-hidden='false']");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Нажать кнопку Sign In")
    public MainPage clickSignInButton() {
        signInButton.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать кнопку Request Demo в заголовке")
    public MainPage clickHeaderRequestDemoButton() {
        headerRequestDemoButton.shouldBe(visible).click();
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

    @Step("Навести курсор на меню Solutions")
    public MainPage hoverSolutionsMenu() {
        solutionsMenu.hover();
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

    @Step("Нажать на меню Company")
    public MainPage clickCompanyMenu() {
        companyMenu.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на пункт Architects")
    public MainPage clickArchitectsMenuItem() {
        architectsMenuItem.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на пункт Engineers")
    public MainPage clickEngineersMenuItem() {
        engineersMenuItem.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на пункт Contractors")
    public MainPage clickContractorsMenuItem() {
        contractorsMenuItem.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на пункт Owners")
    public MainPage clickOwnersMenuItem() {
        ownersMenuItem.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на пункт About")
    public MainPage clickAboutMenuItem() {
        aboutMenuItem.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на пункт Careers")
    public MainPage clickCareersMenuItem() {
        careersMenuItem.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на пункт Newsroom")
    public MainPage clickNewsroomMenuItem() {
        newsroomMenuItem.shouldBe(visible).click();
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

    public SelenideElement getHeaderLogo() { return headerLogo; }
    public SelenideElement getMainTitle() { return mainTitle; }
    public SelenideElement getSignInButton() { return signInButton; }
    public SelenideElement getHeaderRequestDemoButton() { return headerRequestDemoButton; }
    public SelenideElement getMainRequestDemoButton() { return mainRequestDemoButton; }
    public SelenideElement getSolutionsMenu() { return solutionsMenu; }
    public SelenideElement getCompanyMenu() { return companyMenu; }
    public SelenideElement getCareersMenuItem() { return careersMenuItem; }
    public SelenideElement getSubscribeButton() { return subscribeButton; }
    public SelenideElement getPreviousNewsButton() { return previousNewsButton; }
}