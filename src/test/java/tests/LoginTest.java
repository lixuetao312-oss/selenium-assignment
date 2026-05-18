package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test
    public void invalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));

        loginPage.login("Admin", "wrongpassword");

        assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"));
    }

    @Test
    public void emptyUsernameLogin() {

        LoginPage loginPage = new LoginPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));

        loginPage.login("", "admin123");

        assertTrue(driver.getPageSource().contains("Required"));
    }

    @Test
    public void logoutSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        dashboardPage.logout();

        assertTrue(driver.getCurrentUrl().contains("login"));
    }

}