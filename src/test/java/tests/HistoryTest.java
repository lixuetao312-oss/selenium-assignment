package tests;

import org.junit.jupiter.api.Test;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HistoryTest extends BaseTest {

    @Test
    public void browserHistoryNavigationWorks() {

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage = new DashboardPage(driver);

        AdminPage adminPage = new AdminPage(driver);

        loginPage.openPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        assertTrue(dashboardPage.isDashboardDisplayed());

        String dashboardUrl = driver.getCurrentUrl();

        adminPage.openAdminPage();

        assertTrue(driver.getCurrentUrl().contains("admin"));

        driver.navigate().back();

        assertTrue(driver.getCurrentUrl().equals(dashboardUrl));

        driver.navigate().forward();

        assertTrue(driver.getCurrentUrl().contains("admin"));
    }
}