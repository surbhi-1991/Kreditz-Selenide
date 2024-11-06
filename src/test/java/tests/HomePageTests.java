package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePageTests {

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://www.kreditz.com";
        open("/");
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void mainHeadingShouldBeVisible() {
        SelenideElement mainHeading = $(byXpath("//h1[.='Intelligent credit- & risk decisions made easy']"));
        mainHeading.shouldBe(visible);
    }

    @Test
    public void linkedinLinkWorksFine() {
        $(byCssSelector(".socialIcons ul li:nth-child(1) a")).click();
        String currentUrl = WebDriverRunner.url();
        Assert.assertEquals(currentUrl, "https://www.linkedin.com/company/kreditz/");
    }

    @Test
    public void instagramLinkWorksFine() {
        $(byCssSelector(".socialIcons ul li:nth-child(2) a")).click();
        String currentUrl = WebDriverRunner.url();
        Assert.assertEquals(currentUrl, "https://www.instagram.com/getkreditz/");
    }

    @Test
    public void twitterLinkWorksFine() {
        $(byCssSelector(".socialIcons ul li:nth-child(3) a")).click();
        String currentUrl = WebDriverRunner.url();
        Assert.assertEquals(currentUrl, "https://x.com/getkreditz");
    }

}
