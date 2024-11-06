package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ContactUsPageTests {

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://www.kreditz.com";
        open("/contact-us");
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void verifyContactSalesHeadingIsVisible() {
        $(By.xpath("//h1[contains(., 'Contact') and contains(., 'sales')]"))
                .shouldBe(Condition.visible);
    }
}
