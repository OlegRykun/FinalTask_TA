package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void isAddToCartButtonVisible() {
        addToCartButton.isDisplayed();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
