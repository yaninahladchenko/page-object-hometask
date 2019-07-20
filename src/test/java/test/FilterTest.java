package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LandingPage;
import page.WomenDressesPage;

/**
 * 1. Navigate to http://automationpractice.com/index.php
 * 2. Click tab 'Dresses'.
 * 3. Verify http://automationpractice.com/index.php?id_category=8&controller=category is loaded
 * 4. Verify colors selection panel is displayed
 * 5. Click "Orange" in colors selection panel
 * 6. Check that the number of listed colors (orange) on the selection panel and the number of colors (orange)
 * represented match.
 */


public class FilterTest {
    private WebDriver driver;
    private LandingPage landingPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        landingPage = new LandingPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void verifyFilterByColorTest() {
        Assert.assertTrue(landingPage.isLoaded(), "Landing page is not loaded");
        WomenDressesPage womanDressesPage = landingPage.clickDressesTopMenuItem();
        Assert.assertTrue(womanDressesPage.isLoaded(), "Women Dresses page is not loaded");
        int expectedItemsCount = womanDressesPage.getOrangeFilterItemCount();
        System.out.println(expectedItemsCount);
        womanDressesPage.clickOrangeFilterItem();
        womanDressesPage.waitUntilProductCountIs(expectedItemsCount);
        Assert.assertEquals(womanDressesPage.getProductItemsCount(), expectedItemsCount,
                "Expected and actual number of products do not match.");
    }


}
