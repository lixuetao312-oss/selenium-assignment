package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTest extends BaseTest {

    @Test
    public void hoverOverUserMenu() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        By userMenu =
                By.xpath("//span[@class='oxd-userdropdown-tab']");

        WebElement menu =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(userMenu)
                );

        Actions actions = new Actions(driver);

        actions.moveToElement(menu).perform();

        assertTrue(menu.isDisplayed());
    }
}
