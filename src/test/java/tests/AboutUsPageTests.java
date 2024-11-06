package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AboutUsPageTests {

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://www.kreditz.com";
        open("/about");
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void verifyMissionStatementHeadingIsVisible() {
        $(By.xpath("//h1[contains(text(),'Our mission statement')]"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void verifyStaffMembersHeadingIsVisible() {
        $(By.xpath("//p[.='Staff members']")).shouldBe(Condition.visible);
    }

    @Test
    public void verifyBoardMembersHeadingIsVisible() {
        $(By.xpath("//p[.='Board members']")).shouldBe(Condition.visible);
    }

    @Test
    public void verifyInvestorsHeadingIsVisible() {
        $(By.xpath("//p[.='Some of our investors']")).shouldBe(Condition.visible);
    }
}
