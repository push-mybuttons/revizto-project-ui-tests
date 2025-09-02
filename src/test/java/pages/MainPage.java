package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    // Основные элементы главной страницы
    private final SelenideElement signInButton = $x("//header//a[contains(text(), 'SIGN IN')]"),
                                  headerRequestDemoButton = $x("//header//a[contains(text(), 'Request a Demo')]"),
                                  mainRequestDemoButton = $x("//section[contains(@class, 'hero')]//a[contains(text(), 'Request a Demo')]"),
                                  headerLogo = $("header .logo img, header img[alt*='Revizto']"),
                                  mainTitle = $("section[class*='hero'] h1");
    
    // Навигационное меню
    private final SelenideElement solutionsMenu = $("#menu-item-7298"),
                                  workflowsMenu = $x("//header//nav//a[contains(text(), 'Workflows')]"),
                                  companyMenu = $x("//a[text()='Company']"),
                                  eventsMenu = $x("//header//nav//a[contains(text(), 'Events')]"),
                                  resourcesMenu = $x("//header//nav//a[contains(text(), 'Resources')]");
    
    // Выпадающие меню Solutions
    private final SelenideElement architectsMenuItem = $x("//div[contains(@class, 'sub-menu') or contains(@class, 'dropdown-menu')]//a[contains(text(), 'Architects')]"),
                                  engineersMenuItem = $x("//div[contains(@class, 'sub-menu') or contains(@class, 'dropdown-menu')]//a[contains(text(), 'Engineers')]"),
                                  contractorsMenuItem = $x("//div[contains(@class, 'sub-menu') or contains(@class, 'dropdown-menu')]//a[contains(text(), 'Contractors')]"),
                                  ownersMenuItem = $x("//div[contains(@class, 'sub-menu') or contains(@class, 'dropdown-menu')]//a[contains(text(), 'Owners')]");
    
    // Выпадающее меню Company
    private final SelenideElement aboutMenuItem = $x("//div[contains(@class, 'sub-menu') or contains(@class, 'dropdown-menu')]//a[contains(text(), 'About')]"),
                                  careersMenuItem = $x("//a[text()='Careers']"),
                                  newsroomMenuItem = $x("//div[contains(@class, 'sub-menu') or contains(@class, 'dropdown-menu')]//a[contains(text(), 'Newsroom')]");
    
    // News and Media секция
    private final SelenideElement newsMediaSection = $x("//section[contains(text(), 'News and Media')] | //div[contains(@class, 'news')]"),
                                  previousNewsButton = $x("//section[contains(text(), 'News')]//.carousel-control-prev | //section[contains(text(), 'News')]//button[contains(text(), 'Previous')]"),
                                  nextNewsButton = $x("//section[contains(text(), 'News')]//.carousel-control-next | //section[contains(text(), 'News')]//button[contains(text(), 'Next')]");
    private final ElementsCollection newsArticles = $$x("//section[contains(text(), 'News')]//.carousel-item | //section[contains(text(), 'News')]//article");
    
    // Newsletter форма
    private final SelenideElement newsletterSection = $x("//section[contains(text(), 'Subscribe')] | //footer[contains(text(), 'Subscribe')]"),
                                  newsletterEmailInput = $x("//section[contains(text(), 'Subscribe')]//input[@type='email'] | //footer//input[@type='email']"),
                                  newsletterSubmitButton = $x("//section[contains(text(), 'Subscribe')]//button[@type='submit'] | //footer//button[@type='submit']");

    // Публичные методы для взаимодействия со страницей
    public MainPage openPage() {
        open("");
        return this;
    }

    // Основные действия
    public void clickSignInButton() { signInButton.click(); }
    public void clickHeaderRequestDemoButton() { headerRequestDemoButton.click(); }
    public void clickMainRequestDemoButton() { mainRequestDemoButton.click(); }

    // Навигация по главному меню
    public void hoverSolutionsMenu() { solutionsMenu.hover(); }
    public void clickSolutionsMenu() { solutionsMenu.click(); }
    public void hoverCompanyMenu() { companyMenu.hover(); }
    public void clickCompanyMenu() { companyMenu.click(); }

    // Выпадающие меню Solutions
    public void clickArchitectsMenuItem() { architectsMenuItem.click(); }
    public void clickEngineersMenuItem() { engineersMenuItem.click(); }
    public void clickContractorsMenuItem() { contractorsMenuItem.click(); }
    public void clickOwnersMenuItem() { ownersMenuItem.click(); }

    // Выпадающее меню Company
    public void clickAboutMenuItem() { aboutMenuItem.click(); }
    public void clickCareersMenuItem() { careersMenuItem.click(); }
    public void clickNewsroomMenuItem() { newsroomMenuItem.click(); }

    // News and Media функциональность
    public void scrollToNewsMediaSection() { newsMediaSection.scrollTo(); }
    public void clickPreviousNewsButton() { previousNewsButton.click(); }
    public void clickNextNewsButton() { nextNewsButton.click(); }

    // Newsletter форма
    public void scrollToNewsletterSection() { newsletterSection.scrollTo(); }
    public void clickNewsletterSubmitButton() { newsletterSubmitButton.click(); }
    public MainPage enterNewsletterEmail(String email) {
        newsletterEmailInput.setValue(email);
        return this;
    }

    // Методы для проверок (возвращают элементы для assertions)
    public SelenideElement getHeaderLogo() { return headerLogo; }
    public SelenideElement getMainTitle() { return mainTitle; }
    public SelenideElement getSignInButton() { return signInButton; }
    public SelenideElement getHeaderRequestDemoButton() { return headerRequestDemoButton; }
    public SelenideElement getMainRequestDemoButton() { return mainRequestDemoButton; }
    public SelenideElement getSolutionsMenu() { return solutionsMenu; }
    public SelenideElement getCompanyMenu() { return companyMenu; }
    public SelenideElement getCareersMenuItem() { return careersMenuItem; }
    public ElementsCollection getNewsArticles() { return newsArticles; }
    public SelenideElement getNewsletterEmailInput() { return newsletterEmailInput; }
    public SelenideElement getNewsletterSubmitButton() { return newsletterSubmitButton; }

    // Приватные методы (используются только внутри класса)
    private void waitForPageLoad() { headerLogo.shouldBe(visible); }
    private boolean isDropdownMenuVisible(SelenideElement menu) { return menu.isDisplayed(); }
}
