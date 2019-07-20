package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WomenDressesPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[@id='categories_block_left']")
    private WebElement dressesCategotiesBlock;

    @FindBy(xpath = "//ul[@id='ul_layered_id_attribute_group_3']/li[4]")
    private WebElement orangeFilterItem;

    @FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_3']/li[4]/label/a/span")
    private WebElement orangeFilterItemCount;

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> productItems;


    public WomenDressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return dressesCategotiesBlock.isDisplayed()
                && driver.getTitle().equals("Dresses - My Store")
                && driver.getCurrentUrl().endsWith("id_category=8&controller=category");
    }

    public void waitUntilProductCountIs(int expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='product-container']"), expectedCount));
    }

    public void clickOrangeFilterItem() {
        orangeFilterItem.click();
    }

    public int getProductItemsCount() {
        return productItems.size();
    }

    public int getOrangeFilterItemCount() {
        return Integer.parseInt(orangeFilterItemCount.getText()
                .replace("(", "")
                .replace(")", ""));
    }


}
