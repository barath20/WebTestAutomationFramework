package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import framework.InitialSetup;
import framework.PageDriver;

public class ComprehensivePage extends InitialSetup {

    PageDriver pageDriver;
    WebDriver webDriver;

    // Form Elements
    @FindBy(id = "nameInput")
    private WebElement nameInput;

    @FindBy(id = "clickBtn")
    private WebElement clickBtn;

    @FindBy(id = "clickResult")
    private WebElement clickResult;

    // Dropdown Elements
    @FindBy(id = "fruitSelect")
    private WebElement fruitSelect;

    // List Elements
    @FindBy(id = "itemList")
    private WebElement itemList;

    // Hover Elements
    @FindBy(id = "hoverDiv")
    private WebElement hoverDiv;

    @FindBy(id = "hoverLink")
    private WebElement hoverLink;

    // IFrame Elements (inside iframe_content.html)
    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = "droppable")
    private WebElement droppable;

    @FindBy(id = "slider")
    private WebElement slider; // The main slider div

    public ComprehensivePage(WebDriver webDriver, PageDriver pageDriver) {
        this.webDriver = webDriver;
        this.pageDriver = pageDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void testForm(String name) {
        pageDriver.SendKeys(nameInput, name);
        try {
            pageDriver.Click(clickBtn);
        } catch (Exception e) {
            extendTest.log(Status.FAIL, "Click failed");
        }
    }

    public String getClickResult() {
        return clickResult.getText();
    }

    public void testDropdown(int index) {
        pageDriver.Selects(fruitSelect, index);
    }

    public void testList() {
        // This prints to console in the current PageDriver implementation
        pageDriver.GetAtt(itemList);
    }

    public void testHoverPerform() {
        pageDriver.MoveToElementPerform(hoverDiv);
    }

    public void testHoverClick() {
        pageDriver.MoveToElementClick(hoverLink);
    }

    // Context switching for iframe handled in PageDriver for these specific
    // methods...
    // ideally should be explicit here, but complying with PageDriver's internal
    // logic for now.
    // PageDriver.DragAndDrop does `webDriver.switchTo().frame(0)` internally.
    public void testDragAndDrop() {
        pageDriver.DragAndDrop(draggable, droppable);
        // Switch back usually required, but PageDriver doesn't do it.
        // We might need to handle it in test or here if we perform more actions.
        webDriver.switchTo().defaultContent();
    }

    public void testSlider() {
        pageDriver.Slider(slider);
        webDriver.switchTo().defaultContent();
    }

    public void captureScreenshot(String name) {
        pageDriver.TakeScreenShot(name);
    }
}
