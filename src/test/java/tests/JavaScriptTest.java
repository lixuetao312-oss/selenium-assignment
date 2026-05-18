package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptTest extends BaseTest {

    @Test
    public void scrollWithJavaScriptExecutor() {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");
    }
}