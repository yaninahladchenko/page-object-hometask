package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenDressesPage {
    protected WebDriver driver;

    @FindBy(xpath ="//*[@id='categories_block_left']")
    private WebElement dressesCategotiesBlock;

    public WomenDressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return  dressesCategotiesBlock.isDisplayed()
                && driver.getTitle().equals("Dresses - My Store")
                && driver.getCurrentUrl().endsWith("id_category=8&controller=category");
    }


}
