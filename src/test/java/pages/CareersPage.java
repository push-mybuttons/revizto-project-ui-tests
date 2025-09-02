package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CareersPage {

    // Основные элементы страницы Solutions
    private final SelenideElement careersMenu = $x("//nav//a[contains(text(), 'Solutions')] | //h1[contains(text(), 'Solutions')]"),
                                  pageTitle = $("h1"),
                                  architectsLink = $x("//a[contains(text(), 'Architects')]"),
                                  engineersLink = $x("//a[contains(text(), 'Engineers')]");

    // URL страницы
    public static final String CAREERS_URL = "https://revizto.com/en/careers/";

    // Методы для проверок (возвращают элементы для assertions)
    public SelenideElement getCareersMenu() { 
        return careersMenu; 
    }
    
    public SelenideElement getPageTitle() { 
        return pageTitle; 
    }
    
    public SelenideElement getArchitectsLink() { 
        return architectsLink; 
    }
    
    public SelenideElement getEngineersLink() { 
        return engineersLink; 
    }

    // Методы для взаимодействия со страницей
    public CareersPage openPage() {
        open(CAREERS_URL);
        return this;
    }

    public void clickArchitectsLink() { 
        architectsLink.click(); 
    }
    
    public void clickEngineersLink() { 
        engineersLink.click(); 
    }
}
