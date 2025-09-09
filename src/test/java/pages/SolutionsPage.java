package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SolutionsPage {

    public static final String SOLUTIONS_URL = "https://revizto.com/en/solutions/";

    private final SelenideElement solutionsMenu = $x("//nav//a[contains(text(), 'Solutions')] | //h1[contains(text(), 'Solutions')]"),
                                  pageTitle = $("h1"),
                                  architectsLink = $x("//a[contains(text(), 'Architects')]"),
                                  engineersLink = $x("//a[contains(text(), 'Engineers')]");

    @Step("Открыть страницу решений")
    public SolutionsPage openPage() {
        open(SOLUTIONS_URL);
        pageTitle.shouldBe(visible);
        return this;
    }

    @Step("Нажать на ссылку Architects")
    public SolutionsPage clickArchitectsLink() {
        architectsLink.shouldBe(visible).click();
        return this;
    }

    @Step("Нажать на ссылку Engineers")
    public SolutionsPage clickEngineersLink() {
        engineersLink.shouldBe(visible).click();
        return this;
    }

    public SelenideElement getSolutionsMenu() { return solutionsMenu; }
    public SelenideElement getPageTitle() { return pageTitle; }
    public SelenideElement getArchitectsLink() { return architectsLink; }
    public SelenideElement getEngineersLink() { return engineersLink; }
}
