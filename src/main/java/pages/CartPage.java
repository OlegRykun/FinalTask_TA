package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'sc-item')]")
    private WebElement productInCart;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteProductFromCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void isProductInCartVisible() {
        productInCart.isDisplayed();
    }

    public void clickDeleteProductFromCartButton() {
        deleteProductFromCartButton.click();
    }
}
