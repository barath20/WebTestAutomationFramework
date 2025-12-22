package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.LoginPage;

public class LoginTest extends TestSetup {

    @Test
    public void validLoginTest() {
        // Create Test in Report
        extendTest = extendReport.createTest("Valid Login Test");

        // Initialize Page
        LoginPage loginPage = new LoginPage(webDriver, pageDriver);

        // Actions
        loginPage.enterUsername("admin");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();

        // Verification
        String message = loginPage.getSuccessMessage();

        if ("Login Successful!".equals(message)) {
            extendTest.log(Status.PASS, "Login verified successfully.");
        } else {
            extendTest.log(Status.FAIL, "Login verification failed. Message: " + message);
        }

        Assert.assertEquals(message, "Login Successful!");
    }
}
