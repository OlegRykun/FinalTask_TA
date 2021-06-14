package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@aria-Label='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='nav-belt']/div[@class='nav-right']")
    private WebElement rightHeader;

    @FindBy(xpath = "//div[contains(@class, 'navFooterDescLine')]")
    private WebElement navFooterDescLine;

    @FindBy(xpath = "//a[contains(text(), 'ComiXology')]")
    private WebElement comixologyLink;

    @FindBy(xpath = "//div[@id='desktop-6']/div[contains(@class, 'ameyal-product-shoveler')]")
    private WebElement mensShirtsCategory;

    @FindBy(xpath = "//div[@id='desktop-6']//a[contains(text(), 'Shop now')]")
    private WebElement shopNowButton;

    @FindBy(xpath = "//span[text()='Account & Lists']")
    private WebElement accountButton;

    @FindBy(xpath = "//a[contains(@aria-Label, 'Choose a language')]")
    private WebElement languageDropDownMenuIcon;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartAmount;

    @FindBy(xpath = "//a[contains(@aria-label, 'Gaming accessories')]")
    private WebElement gamingAccessoriesCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isRightHeaderVisible() {
        rightHeader.isDisplayed();
    }

    public void isNavFooterDescLineVisible() {
        navFooterDescLine.isDisplayed();
    }

    public void clickComiXologyLink() {
        comixologyLink.click();
    }

    public void isMensShirtsCategoryVisible() {
        mensShirtsCategory.isDisplayed();
    }

    public void clickShopNowButton() {
        shopNowButton.click();
    }

    public void isAccountButtonVisible() {
        accountButton.isDisplayed();
    }

    public void clickAccountButton() {
        accountButton.click();
    }

    public void isLanguageIconVisible() {
        languageDropDownMenuIcon.isDisplayed();
    }

    public void clickLanguageMenuIcon() {
        languageDropDownMenuIcon.click();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void isSearchButtonVisible() {
        searchButton.isDisplayed();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getAmountOfProductsInCart() {
        return cartAmount.getText();
    }

    public void clickCartAmount() {
        cartAmount.click();
    }

    public void isGamingAccessoriesCategoryVisible() {
        gamingAccessoriesCategory.isDisplayed();
    }

    public void clickGamingAccessoriesCategory() {
        gamingAccessoriesCategory.click();
    }
}
