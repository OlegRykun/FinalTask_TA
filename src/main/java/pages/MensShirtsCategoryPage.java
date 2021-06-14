package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MensShirtsCategoryPage extends BasePage {

    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    private List<WebElement> mensShirtsProducts;

    @FindBy(xpath = "//div[@data-component-type]//span[contains(@class, 'whole')]")
    private List<WebElement> mensShirtsWholePrices;

    public MensShirtsCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void isMensShirtsProductsVisible() {
        for (WebElement mensShirtProduct: mensShirtsProducts) {
            mensShirtProduct.isDisplayed();
        }
    }

    public List<WebElement> getMensShirtsWholePrices() {
        return mensShirtsWholePrices;
    }
}
