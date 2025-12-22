package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import framework.InitialSetup; // Or wherever InitialSetup is
import framework.PageDriver;

public class LoginPage extends InitialSetup {

    PageDriver pageDriver;
    WebDriver webDriver;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "loginBtn")
    private WebElement loginButton;

    @FindBy(id = "message")
    private WebElement messageLabel;

    public LoginPage(WebDriver webDriver, PageDriver pageDriver) {
        this.webDriver = webDriver;
        this.pageDriver = pageDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterUsername(String username) {
        try {
            pageDriver.SendKeys(usernameInput, username);
            extendTest.log(Status.INFO, "Entered username: " + username);
        } catch (Exception e) {
            extendTest.log(Status.FAIL, "Failed to enter username");
        }
    }

    public void enterPassword(String password) {
        try {
            pageDriver.SendKeys(passwordInput, password);
            extendTest.log(Status.INFO, "Entered password");
        } catch (Exception e) {
            extendTest.log(Status.FAIL, "Failed to enter password");
        }
    }

    public void clickLogin() {
        try {
            pageDriver.Click(loginButton);
            extendTest.log(Status.INFO, "Clicked Login button");
        } catch (Exception e) {
            extendTest.log(Status.FAIL, "Failed to click Login button");
        }
    }

    public String getSuccessMessage() {
        return messageLabel.getText();
    }
}
