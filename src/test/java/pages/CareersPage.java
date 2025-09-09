package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CareersPage {

    public static final String CAREERS_URL = "https://revizto.com/en/careers/";

    private final SelenideElement careersMenu = $x("//nav//a[contains(text(), 'Careers')] | //h1[contains(text(), 'Careers')]"),
                                  pageTitle = $("h1");

    @Step("Открыть страницу карьеры")
    public CareersPage openPage() {
        open(CAREERS_URL);
        pageTitle.shouldBe(visible);
        return this;
    }

    public SelenideElement getCareersMenu() { return careersMenu; }
    public SelenideElement getPageTitle() { return pageTitle; }
}