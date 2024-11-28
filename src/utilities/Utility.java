package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on given locator path
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }
    /**
     * This method will select dropdown
     */
    public void selectFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will compare actual result and expected result
     */
    public void assertVerifyText(String expectedText, By by) {
        Assert.assertEquals(expectedText, driver.findElement(by).getText());
    }
    /**
     * This method is for mouse hover and click on element
     */
    public void mouseHoverAndClick(By by) {
        WebElement element = driver.findElement(by);
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).click().perform();
    }
    /**
     * This method is for mouse hover
     */
    public void mouseToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).perform();
    }
}
