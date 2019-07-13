package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.FilterTest;

public class LandingPage {
    protected WebDriver driver;

    @FindBy(xpath ="//*[@id='block_top_menu']/ul/li[2]")
    private WebElement dressesTopMenuItem;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return  dressesTopMenuItem.isDisplayed()
                && driver.getTitle().equals("My Store")
                && driver.getCurrentUrl().endsWith("/index.php");
    }
    public WomenDressesPage clickDressesTopMenuItem() {
        dressesTopMenuItem.click();
        return new WomenDressesPage(driver);
    }





}
