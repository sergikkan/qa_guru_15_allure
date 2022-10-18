package org.skan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY="eroshenkoam/allure-example";
    private static final int ISSUE=81;
    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий "+REPOSITORY, () ->{
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Кликаем по ссылке репозитория " +REPOSITORY, ()->{
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () ->{
            $("#issues-tab").click();
        });
        step("Проверяем наличие issue с номером " +ISSUE, ()->{
            $(withText("#"+ISSUE)).shouldBe(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps step = new WebSteps();
        step.openMainPage();
        step.searchForRepository(REPOSITORY);
        step.clickOnRepository(REPOSITORY);
        step.openIssuesTab();
        step.shouldSeeIssueWithNumber(ISSUE);
    }
}
