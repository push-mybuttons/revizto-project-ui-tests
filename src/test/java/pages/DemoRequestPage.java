package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DemoRequestPage {

    // Основные элементы страницы запроса демо
    private final SelenideElement formBox = $(".form_box"),
                                  pageTitle = $("h1"),
                                  demoForm = $("form"),
                                  submitButton = $("form button[type='submit'], form input[type='submit']");

    // URL страницы
    public static final String DEMO_REQUEST_URL = "https://revizto.com/en/demo-request/";

    // Методы для проверок (возвращают элементы для assertions)
    public SelenideElement getFormBox() { 
        return formBox; 
    }
    
    public SelenideElement getPageTitle() { 
        return pageTitle; 
    }
    
    public SelenideElement getDemoForm() { 
        return demoForm; 
    }
    
    public SelenideElement getSubmitButton() { 
        return submitButton; 
    }

    // Методы для взаимодействия со страницей
    public DemoRequestPage openPage() {
        open(DEMO_REQUEST_URL);
        return this;
    }

    // Методы для проверки состояния страницы
    public boolean isFormBoxVisible() {
        return formBox.isDisplayed();
    }

    public boolean isOnDemoRequestPage() {
        return webdriver().driver().url().contains("/demo-request/");
    }

    // Приватные методы
    private void waitForPageLoad() { 
        formBox.shouldBe(visible); 
    }
}
