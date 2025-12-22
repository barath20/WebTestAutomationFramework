package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.ComprehensivePage;

public class ComprehensiveTests extends TestSetup {

    @Test(priority = 1)
    public void testFormInteractions() {
        extendTest = extendReport.createTest("Form Interactions Test");

        // Navigate to the correct page
        String localPagePath = System.getProperty("user.dir")
                + "/src/test/resources/test_pages/comprehensive_test.html";
        webDriver.get("file://" + localPagePath);

        ComprehensivePage cp = new ComprehensivePage(webDriver, pageDriver);

        cp.testForm("Test User");
        String result = cp.getClickResult();

        if ("Clicked!".equals(result)) {
            extendTest.log(Status.PASS, "Button click verified.");
        } else {
            extendTest.log(Status.FAIL, "Button click verification failed.");
        }
        Assert.assertEquals(result, "Clicked!");
    }

    @Test(priority = 2)
    public void testDropdown() {
        extendTest = extendReport.createTest("Dropdown Test");
        ComprehensivePage cp = new ComprehensivePage(webDriver, pageDriver);

        // Select index 1 (Banana)
        cp.testDropdown(1);
        extendTest.log(Status.INFO, "Selected index 1");
    }

    @Test(priority = 3)
    public void testListRetrieval() {
        extendTest = extendReport.createTest("List Retrieval Test");
        ComprehensivePage cp = new ComprehensivePage(webDriver, pageDriver);

        cp.testList();
        extendTest.log(Status.INFO, "List items printed to console (check logs).");
    }

    @Test(priority = 4)
    public void testHover() throws InterruptedException {
        extendTest = extendReport.createTest("Hover Test");
        ComprehensivePage cp = new ComprehensivePage(webDriver, pageDriver);

        cp.testHoverPerform();
        extendTest.log(Status.INFO, "Performed Mouse Hover");

        // Handling alert from click
        try {
            cp.testHoverClick();
            Thread.sleep(1000); // Wait for alert
            webDriver.switchTo().alert().accept();
            extendTest.log(Status.PASS, "Hover Click and Alert accepted");
        } catch (Exception e) {
            extendTest.log(Status.FAIL, "Alert handling failed: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void testFrameInteractions() {
        extendTest = extendReport.createTest("Frame Interactions (DragDrop/Slider)");
        ComprehensivePage cp = new ComprehensivePage(webDriver, pageDriver);

        // Drag and Drop
        cp.testDragAndDrop();
        extendTest.log(Status.INFO, "Performed Drag and Drop");

        // Slider
        cp.testSlider();
        extendTest.log(Status.INFO, "Performed Slider movement");

        // Screenshot
        cp.captureScreenshot("ComprehensiveTest_End");
        extendTest.log(Status.INFO, "Captured Screenshot");
    }

    @Test(priority = 6)
    public void testIntentionalFailure() {
        extendTest = extendReport.createTest("Intentional Failure Test");
        extendTest.log(Status.INFO, "This test is designed to fail to verify screenshot capture.");
        Assert.fail("Intentional failure for screenshot verification.");
    }
}
