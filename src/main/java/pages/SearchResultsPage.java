package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-fixed-height']")
    private List<WebElement> wishListImages;

    @FindBy(xpath = "//div[@class='a-section a-spacing-medium']//span[@class='a-price-whole']")
    private List<WebElement> productWholePrices;

    @FindBy(xpath = "//span[contains(@class, 'a-size-base-plus')]")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//span/form[@method='get']")
    private WebElement filterByPrice;

    @FindBy(xpath = "//input[@id='low-price']")
    private WebElement minPriceInputField;

    @FindBy(xpath = "//input[@id='high-price']")
    private WebElement maxPriceInputField;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement goButton;

    @FindBy(xpath = "//div[@id='brandsRefinements']//span[contains(text(), 'Marshall')]")
    private WebElement firstBrandFilterButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWishListOnFirstProduct() {
        wishListImages.get(0).click();
    }

    public void isFilterByPriceVisible() {
        filterByPrice.isDisplayed();
    }

    public void enterMinPrice(final String minPrice) {
        minPriceInputField.clear();
        minPriceInputField.sendKeys(minPrice);
    }

    public void enterMaxPrice(final String maxPrice) {
        maxPriceInputField.clear();
        maxPriceInputField.sendKeys(maxPrice);
    }

    public void clickGoButton() {
        goButton.click();
    }

    public void isBrandFiltersVisible() {
        firstBrandFilterButton.isDisplayed();
    }

    public void clickFirstBrandButton() {
        firstBrandFilterButton.click();
    }

    public ArrayList<String> getTitleTextForEveryProduct() {
        ArrayList<String> titlesText = new ArrayList<String>();
        for (WebElement product: productTitles) {
            titlesText.add(product.getText().toLowerCase());
        }

        return titlesText;
    }

    public List<WebElement> getProductWholePrices() {
        return productWholePrices;
    }
}
