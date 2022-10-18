package org.skan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LabelsTest {

    private static final String REPOSITORY="eroshenkoam/allure-example";
    private static final int ISSUE=81;


    @Test
    @Feature("Issues в репозитории")
    @Story("Создание Issues")
    @Owner("serhiikan")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issues для авторизованного пользователя")
    public void testStaticLabels(){
    }

    @Test
    public void testDynamicLabels(){
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issues для авторизованного пользователя")
        );
        Allure.feature("Issues в репозитории");
        Allure.story("Создание Issues");
        Allure.label("owner", "serhiikan");
        Allure.label("severity",SeverityLevel.BLOCKER.value());
        Allure.link("Testing","https://testing.github.com");


    }
}
