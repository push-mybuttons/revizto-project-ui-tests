package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CareersPage {

    // Основные элементы страницы Solutions
    private final SelenideElement careersMenu = $x("//nav//a[contains(text(), 'Solutions')] | //h1[contains(text(), 'Solutions')]"),
                                  pageTitle = $("h1");

    // URL страницы
    public static final String CAREERS_URL = "https://revizto.com/en/careers/";

    // Методы для проверок (возвращают элементы для assertions)
    public SelenideElement getCareersMenu() { 
        return careersMenu; 
    }
    
    public SelenideElement getPageTitle() { 
        return pageTitle; 
    } 

    // Методы для взаимодействия со страницей
    public CareersPage openPage() {
        open(CAREERS_URL);
        return this;
    }
}