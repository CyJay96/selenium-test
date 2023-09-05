package com.aqa;

import com.aqa.page.LoginPage;
import com.aqa.page.MainPage;
import com.aqa.util.ApplicationProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {

    private static WebDriver driver;
    private static MainPage mainPage;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        final String driverName = "webdriver.chrome.driver";
        final String chromedriver = "chromedriver";
        final String page = "page";
        final int duration = 10;

        System.setProperty(driverName, ApplicationProperties.getProperty(chromedriver));

        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
        driver.get(ApplicationProperties.getProperty(page));
    }

    @Test
    public void loginTest() {
        final String username = "username";
        final String password = "password";
        final String loginResult = "loginResult";

        mainPage.clickLoginFormButton();

        loginPage.inputUsername(ApplicationProperties.getProperty(username));
        loginPage.inputPassword(ApplicationProperties.getProperty(password));
        loginPage.clickLoginButton();

        String actualResult = loginPage.getLoginResultText();

        Assertions.assertEquals(ApplicationProperties.getProperty(loginResult), actualResult);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
