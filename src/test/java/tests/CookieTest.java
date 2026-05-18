package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CookieTest extends BaseTest {

    @Test
    public void manipulateCookies() {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        Cookie testCookie =
                new Cookie("testCookie", "12345");

        driver.manage().addCookie(testCookie);

        Cookie addedCookie =
                driver.manage().getCookieNamed("testCookie");

        assertNotNull(addedCookie);

        driver.manage().deleteCookieNamed("testCookie");
    }
}