package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CareersPage {

    private final SelenideElement careersMenu = $x("//nav//a[contains(text(), 'Solutions')] | //h1[contains(text(), 'Solutions')]"),
                                  pageTitle = $("h1");

    public static final String CAREERS_URL = "https://revizto.com/en/careers/";

    public SelenideElement getCareersMenu() { 
        return careersMenu; 
    }
    
    public SelenideElement getPageTitle() { 
        return pageTitle; 
    } 

    public CareersPage openPage() {
        open(CAREERS_URL);
        return this;
    }
}