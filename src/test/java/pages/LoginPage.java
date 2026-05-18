package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class LoginPage extends BasePage {

    // XPath locators
    private By usernameInput =
            By.xpath("//input[@name='username']");

    private By passwordInput =
            By.xpath("//input[@name='password']");

    private By loginButton =
            By.xpath("//button[@type='submit']");

    private By errorMessage =
            By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public void openPage() {

        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    public void enterUsername(String username) {

        type(usernameInput, username);
    }

    public void enterPassword(String password) {

        type(passwordInput, password);
    }

    public void clickLogin() {

        click(loginButton);
    }

    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {

        return getText(errorMessage);
    }
}