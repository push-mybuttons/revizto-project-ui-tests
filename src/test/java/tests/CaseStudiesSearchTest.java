package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CaseStudiesPage;
import helpers.TestData;

@Epic("Case Studies Functionality")
@Feature("Case Studies Search")
public class CaseStudiesSearchTest extends BaseTest {

    private final CaseStudiesPage caseStudiesPage = new CaseStudiesPage();

    @ParameterizedTest(name = "Search by query: {0}")
    @Story("Parametrized search functionality") 
    @DisplayName("Search with different queries")
    @Owner("MariiaP")
    @Severity(SeverityLevel.NORMAL)
    @Tag("ParametrizedSearchTest")
    @CsvSource({
        "kiwi, 'Search by partial company name'",
        "construction, 'Search by construction'", 
        "architecture, 'Search by architecture'"
    })
    void searchWithDifferentQueries(String searchQuery, String description) {
        caseStudiesPage.openPage()
                      .enterSearchQuery(searchQuery)
                      .clickSearchButton()
                      .verifySearchResultsForQuery(searchQuery)
                      .verifySearchResultsVisible();
    }

    @Test
    @Story("Negative search functionality")
    @DisplayName("Search with negative query should return no results message")
    @Owner("MariiaP")
    @Severity(SeverityLevel.NORMAL)
    @Tag("NegativeSearchTest")
    void searchWithNegativeQueryShouldReturnNoResults() {
        String searchQuery = TestData.getNegativeSearchQuery();
        
        caseStudiesPage.openPage()
                      .enterSearchQuery(searchQuery)
                      .clickSearchButton();
        
        caseStudiesPage.verifyNoSearchResults(searchQuery);
    }
}