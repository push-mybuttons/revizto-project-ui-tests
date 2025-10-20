package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class SolutionsPage {

    private final SelenideElement solutionsMenu = $x("//nav//a[contains(text(), 'Solutions')] | //h1[contains(text(), 'Solutions')]");

    @Step("Проверить видимость меню Solutions")
    public SolutionsPage verifySolutionsMenuVisible() {
        solutionsMenu.shouldBe(visible);
        return this;
    }
}
