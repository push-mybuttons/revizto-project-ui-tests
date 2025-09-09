package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CaseStudiesPage {
    
    public static final String CASE_STUDIES_URL = "https://revizto.com/en/resources/case-studies/";

    private final SelenideElement caseStudiesPageTitle = $("h1.section-title"),
                                  searchInput = $("input.resources-search"),
                                  searchButton = $("button[aria-label='Start search']"),
                                  searchResults = $(".item-area"),
                                  searchResultsTitle = $("h1.section-title"),
                                  noSearchResultsTitle = $x("//h3[contains(text(), 'Sorry, we couldn')]");

    @Step("Открыть страницу Case Studies")
    public CaseStudiesPage openPage() {
        open(CASE_STUDIES_URL);
        caseStudiesPageTitle.shouldBe(visible);
        return this;
    }

    @Step("Ввести поисковый запрос: {searchQuery}")
    public CaseStudiesPage enterSearchQuery(String searchQuery) {
        searchInput.shouldBe(visible, enabled)
                   .setValue(searchQuery);
        return this;
    }

    @Step("Нажать кнопку поиска")
    public CaseStudiesPage clickSearchButton() {
        searchButton.shouldBe(visible, enabled)
                    .click();
        return this;
    }
    
    @Step("Получить результаты поиска")
    public SelenideElement getSearchResults() {
        searchResultsTitle.shouldBe(visible);
        searchResults.shouldBe(visible);
        return searchResults;
    }

    @Step("Проверить результаты поиска для запроса: {expectedQuery}")
    public CaseStudiesPage verifySearchResultsForQuery(String expectedQuery) {
        searchResultsTitle.shouldHave(text("Search Results for: " + expectedQuery));
        searchResults.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что результаты поиска не найдены")
    public CaseStudiesPage verifyNoSearchResults(String expectedQuery) {
        noSearchResultsTitle.shouldBe(visible);
        return this;
    }
}
