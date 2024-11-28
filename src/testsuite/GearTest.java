package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        // Accept Consent
        clickOnElement(By.xpath("//p[normalize-space()='Consent']"));

        //Mouse Hover on the ‘Gear’Menu
        mouseToElement(By.xpath("(//span[contains(text(),'Gear')])[1]"));

        // Click on the ‘Bags’
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));

        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.linkText("Overnight Duffle"));

        // Verify the text ‘Overnight Duffle’
        assertVerifyText("Overnight Duffle", By.xpath("//span[@class='base']"));

        // Change the Qty 3
        WebElement quantityField = driver.findElement(By.id("qty"));
        quantityField.clear();
        quantityField.sendKeys("3");

        // Click on the ‘Add to Cart’Button
        clickOnElement(By.id("product-addtocart-button"));

        // Verify the text‘You added Overnight Duffle to your shopping cart.’
        assertVerifyText("You added Overnight Duffle to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        // Click on the ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // Verify the product name ‘Overnight Duffle’
        assertVerifyText("Overnight Duffle", By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));

        // Verify the Qty is ‘3’
        assertVerifyText("3", By.cssSelector("#cart-432079-qty"));

        // Verify the product price ‘$135.00’
        assertVerifyText("$135.00", By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));

        // Change the Qty to ‘5’
        WebElement quantityDuffle = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        quantityDuffle.clear();
        quantityDuffle.sendKeys("5");

        // Click on the ‘Update Shopping Cart’ button
        clickOnElement(By.cssSelector("button[title='Update Shopping Cart'] span"));

        // Verify the product price ‘$225.00’
        assertVerifyText("$225.00", By.cssSelector("td[class='col subtotal'] span[class='price']"));

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
