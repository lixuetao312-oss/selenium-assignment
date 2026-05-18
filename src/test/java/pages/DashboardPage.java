package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private By dashboardHeader =
            By.xpath("//h6[text()='Dashboard']");

    private By userDropdown =
            By.xpath("//span[@class='oxd-userdropdown-tab']");

    private By logoutButton =
            By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {

        super(driver);
    }

    public boolean isDashboardDisplayed() {

        return waitForElement(dashboardHeader).isDisplayed();
    }

    public void openUserMenu() {

        click(userDropdown);
    }

    public void logout() {

        openUserMenu();

        click(logoutButton);
    }
}