package tests;

import org.junit.jupiter.api.Test;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminTest extends BaseTest {

    @Test
    public void searchRandomUsername() {

        LoginPage loginPage = new LoginPage(driver);

        AdminPage adminPage = new AdminPage(driver);

        loginPage.openPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        adminPage.openAdminPage();

        String randomUsername =
                "user" + System.currentTimeMillis();

        adminPage.searchUser(randomUsername);
    }

    @Test
    public void selectDropdownOptionAfterLogin() {

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage = new DashboardPage(driver);

        AdminPage adminPage = new AdminPage(driver);

        loginPage.openPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        assertTrue(dashboardPage.isDashboardDisplayed());

        adminPage.openAdminPage();

        adminPage.selectAdminRole();
    }
}