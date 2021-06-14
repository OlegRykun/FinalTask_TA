package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public LanguageSelectionPage getLanguageSelectionPage() { return new LanguageSelectionPage(driver); }

    public SearchResultsPage getSearchResultsPage() { return new SearchResultsPage(driver); }

    public ProductPage getProductPage() { return new ProductPage(driver); }

    public GamingAccessoriesCategoryPage getGamingAccessoriesCategoryPage() { return new GamingAccessoriesCategoryPage(driver); }

    public CartPage getCartPage() { return new CartPage(driver); }

    public PlaystationGroupPage getPlaystationGroupPage() { return new PlaystationGroupPage(driver); }

    public MensShirtsCategoryPage getMensShirtsCategoryPage() { return new MensShirtsCategoryPage(driver); }
}
