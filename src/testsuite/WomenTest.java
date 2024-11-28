package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        // Accept Consent
        clickOnElement(By.xpath("//p[normalize-space()='Consent']"));

        // Mouse Hover on the ‘Women’ Menu
        mouseToElement(By.linkText("Women"));

        // Mouse Hover on the ‘Tops’
        mouseToElement(By.linkText("Tops"));

        // Click on the ‘Jackets’
        clickOnElement(By.linkText("Jackets"));

        // Select Sort By filter “Product Name”
        selectFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");

        // Verify the product price displayed in Low to High
        // List<WebElement> prices = driver.findElements(By.cssSelector(".price-wrapper .price"));

        // Find the elements containing the text to check for alphabetical order
        List<WebElement> textList = driver.findElements(By.cssSelector(".product-item-info .product-name a"));
        List<String> actualTextList = new ArrayList<>();
        for (WebElement e : textList) {
            String text = e.getText().trim();
            actualTextList.add(text);
        }

        System.out.println("Actual Text List: " + actualTextList);

        // Create a copy of the list and sort it alphabetically
        List<String> expectedTextList = new ArrayList<>(actualTextList);
        Collections.sort(expectedTextList);

        System.out.println("Expected Text List (sorted alphabetically): " + expectedTextList);

        Assert.assertEquals(expectedTextList, actualTextList);

    }

    @Test
    public void verifyTheSortByPriceFilter() {

        // Accept Consent
        clickOnElement(By.xpath("//p[normalize-space()='Consent']"));

        // Mouse Hover on the ‘Women’ Menu
        mouseToElement(By.linkText("Women"));

        // Mouse Hover on the ‘Tops’
        mouseToElement(By.linkText("Tops"));

        // Click on the ‘Jackets’
        clickOnElement(By.linkText("Jackets"));

        // Select Sort By filter “Price”
        selectFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Price");

        // Verify the product price displayed in Low to High
        List<WebElement> prices = driver.findElements(By.cssSelector(".price"));
        List<Double> priceValues = new ArrayList<>();
        for (WebElement price : prices) {
            String priceText = price.getText().replace("$", "").replace(",", "").trim();

            System.out.println(priceText);
        }
    }


    @After
    public void tearDown() {
        closeBrowser();
    }


}


