package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    private By adminMenu =
            By.xpath("//span[text()='Admin']");

    private By usernameInput =
            By.xpath("(//input[contains(@class,'oxd-input')])[2]");

    private By searchButton =
            By.xpath("//button[@type='submit']");

    private By roleDropdown =
            By.xpath("(//div[contains(@class,'oxd-select-text')])[1]");

    private By adminOption =
            By.xpath("//span[text()='Admin']");

    public AdminPage(WebDriver driver) {

        super(driver);
    }

    public void openAdminPage() {

        click(adminMenu);
    }

    public void searchUser(String username) {

        type(usernameInput, username);

        click(searchButton);
    }

    public void selectAdminRole() {

        click(roleDropdown);

        click(adminOption);
    }
}