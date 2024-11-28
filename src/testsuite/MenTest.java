package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {

        // Accept Consent
        clickOnElement(By.xpath("//p[normalize-space()='Consent']"));

        // Mouse Hover on the ‘Men’ Menu
        mouseToElement(By.linkText("Men"));

        // Mouse Hover on the ‘Bottoms’
        mouseToElement(By.linkText("Bottoms"));

        // Click on the ‘Pants’
        clickOnElement(By.linkText("Pants"));

        // Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the size 32.
        mouseToElement(By.linkText("Cronus Yoga Pant"));
        clickOnElement(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));

        // Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the Color Black.
        mouseToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]"));

        // Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the ‘Add To Cart’ Button.
        mouseToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]"));

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        assertVerifyText("You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        // Click on the ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // Verify the text ‘Shopping Cart.’
        assertVerifyText("Shopping Cart", By.xpath("//span[@class='base']"));

        // Verify the product name ‘Cronus Yoga Pant’
        assertVerifyText("Cronus Yoga Pant", By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));

        // Verify the product size ‘32’
        assertVerifyText("32", By.xpath("//dd[contains(text(),'32')]"));

        // Verify the product color ‘Black’
        assertVerifyText("Black", By.xpath("//dd[contains(text(),'Black')]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

