package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest extends BaseTest {

    @Test
    public void pageTitleIsCorrect() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage();

        assertTrue(driver.getTitle().contains("OrangeHRM"));
    }

    @Test
    public void multiplePagesHaveCorrectTitle() {

        String[] urls = {
                "https://opensource-demo.orangehrmlive.com/",
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        };

        for (String url : urls) {

            driver.get(url);

            assertTrue(driver.getTitle().contains("OrangeHRM"));
        }
    }
}