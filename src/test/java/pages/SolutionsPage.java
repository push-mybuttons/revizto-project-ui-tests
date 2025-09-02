package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SolutionsPage {

    // Основные элементы страницы Solutions
    private final SelenideElement solutionsMenu = $x("//nav//a[contains(text(), 'Solutions')] | //h1[contains(text(), 'Solutions')]"),
                                  pageTitle = $("h1"),
                                  architectsLink = $x("//a[contains(text(), 'Architects')]"),
                                  engineersLink = $x("//a[contains(text(), 'Engineers')]");

    // URL страницы
    public static final String SOLUTIONS_URL = "https://revizto.com/en/solutions/";

    // Методы для проверок (возвращают элементы для assertions)
    public SelenideElement getSolutionsMenu() { 
        return solutionsMenu; 
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
    public SolutionsPage openPage() {
        open(SOLUTIONS_URL);
        return this;
    }

    public void clickArchitectsLink() { 
        architectsLink.click(); 
    }
    
    public void clickEngineersLink() { 
        engineersLink.click(); 
    }
}
