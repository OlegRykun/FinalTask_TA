package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.After;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    LanguageSelectionPage languageSelectionPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    GamingAccessoriesCategoryPage gamingAccessoriesCategoryPage;
    CartPage cartPage;
    PlaystationGroupPage playstationGroupPage;
    MensShirtsCategoryPage mensShirtsCategoryPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks right header visibility")
    public void checkRightHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isRightHeaderVisible();
    }

    @And("User checks account button visibility")
    public void checkAccountButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isAccountButtonVisible();
    }

    @And("User clicks account button")
    public void clickAccountButton() {
        homePage.clickAccountButton();
    }

    @And("User checks sign in field visibility")
    public void checkSignInVisibility() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.isSignInBoxVisible();
    }

    @And("User enters email {string} to email input field")
    public void enterEmailToEmailInputField(final String email) {
        signInPage.waitAndEnterToEmailInput(email);
    }

    @And("User clicks continue button")
    public void clickContinueButton() {
        signInPage.waitAndClickContinueButton();
    }

    @And("User checks {string}")
    public void checkThatThereIsNoAccountWithSuchEmail(final String noAccountMessage) {
        assertEquals(signInPage.getTextNoAccountMessage(), noAccountMessage);
    }

    @And("User checks language menu icon visibility")
    public void checkLanguageDropDownMenuIconVisibility() {
        homePage.isLanguageIconVisible();
    }

    @And("User clicks on language menu icon")
    public void clickLanguageIcon() {
        homePage.clickLanguageMenuIcon();
    }

    @And("User checks radio button visibility")
    public void checkGermanRadioButtonVisibility() {
        languageSelectionPage = pageFactoryManager.getLanguageSelectionPage();
        languageSelectionPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        languageSelectionPage.isGermanRadioButtonVisible();
    }

    @And("User clicks on german radio button")
    public void clickGermanRadioButton() {
        languageSelectionPage.clickGermanRadioButton();
    }

    @And("User checks save changes button")
    public void checkSaveChangesButtonVisibility() {
        languageSelectionPage.isSaveChangesButtonVisible();
    }

    @And("User clicks on save changes button")
    public void clickSaveChangesButton() {
        languageSelectionPage.clickSaveChangesButton();
    }

    @And("User checks that current url contains {string} language")
    public void checkCurrentURLContainsGermanLanguage(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
    }

    @And("User checks navigation footer line visibility")
    public void checkNavigationFooterLineVisibility() {
        homePage.isNavFooterDescLineVisible();
    }

    @And("User clicks some link")
    public void clickSomeLink() {
        homePage.clickComiXologyLink();
    }

    @And("User checks page url equals {string}")
    public void checkPageURLEqualsToString(final String pageURL) {
        assertEquals(driver.getCurrentUrl(), pageURL);
    }

    @And("User checks men`s shirts category visibility")
    public void checkMensShirtsCategoryVisibility() {
        homePage.isMensShirtsCategoryVisible();
    }

    @And("User clicks shop now")
    public void clickShopNowButton() {
        homePage.clickShopNowButton();
    }

    @And("User checks shirts product visibility")
    public void checkShirtsProductVisibility() {
        mensShirtsCategoryPage = pageFactoryManager.getMensShirtsCategoryPage();
        mensShirtsCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        mensShirtsCategoryPage.isMensShirtsProductsVisible();
    }

    @And("User checks that all shirts prices under {int}")
    public void checkAllShirtsPricesUnder30(final int maxPrice) {
        for (WebElement shirtWholePrice: mensShirtsCategoryPage.getMensShirtsWholePrices()) {
            assertTrue(Integer.parseInt(shirtWholePrice.getText()) <= maxPrice);
        }
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User makes search by keyword {string}")
    public void enterTextToSearchField(final String searchText) {
        homePage.enterTextToSearchField(searchText);
    }

    @And("User checks search button visibility")
    public void checkSearchButtonVisibility() {
        homePage.isSearchButtonVisible();
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks wish list on first product")
    public void clickWishListOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickWishListOnFirstProduct();
    }

    @And("User checks add to cart button visibility")
    public void checkAddToCartButtonVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.isAddToCartButtonVisible();
    }

    @And("User clicks add to cart button")
    public void clickAddToCartButton() {
        productPage.clickAddToCartButton();
    }

    @And("User checks that amount of products in cart is {string}")
    public void checkAmountOfProductsInCart(final String expectedCartAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(homePage.getAmountOfProductsInCart(), expectedCartAmount);
    }

    @And("User click cart button")
    public void clickCartButton() {
        homePage.clickCartAmount();
    }

    @And("User checks product visibility in cart page")
    public void checkProductsInCartVisibility() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.isProductInCartVisible();
    }

    @And("User clicks delete button")
    public void clickDeleteProductFromCartButton() {
        cartPage.clickDeleteProductFromCartButton();
    }

    @And("User checks gaming accessories category visibility")
    public void checkGamingAccessoriesCategoryVisibility() {
        homePage.isGamingAccessoriesCategoryVisible();
    }

    @And("User clicks see more")
    public void clickGamingAccessoriesCategorySeeMore() {
        homePage.clickGamingAccessoriesCategory();
    }

    @And("User checks gaming accessories category groups visibility")
    public void checkGamingAccessoriesCategoryGroupsVisibility() {
        gamingAccessoriesCategoryPage = pageFactoryManager.getGamingAccessoriesCategoryPage();
        gamingAccessoriesCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        gamingAccessoriesCategoryPage.isGamingAccessoriesCategoryGroupsVisible();
    }

    @And("User checks {int} groups in gaming accessories category")
    public void checkGamingAccessoriesCategoryGroupsCount(final int expectedGamingAccessoriesCategoryGroupsCount) {
        assertEquals(gamingAccessoriesCategoryPage.getGamingAccessoriesCategoryGroupsCount(), expectedGamingAccessoriesCategoryGroupsCount);
    }

    @And("User clicks on first group")
    public void clickOnFirstGroup() {
        gamingAccessoriesCategoryPage.clickOnFirstGroup();
    }

    @And("User checks that current url contains {string}")
    public void checkCurrentURLContainsGroupTitle(final String groupTitle) {
        assertTrue(driver.getCurrentUrl().contains(groupTitle));
    }

    @And("User clicks on Playstation group")
    public void clickPlaystationGroup() {
        gamingAccessoriesCategoryPage.clickPlaystationGroup();
    }

    @And("User checks Playstation products visibility")
    public void checkPlaystationProductsVisibility() {
        playstationGroupPage = pageFactoryManager.getPlaystationGroupPage();
        playstationGroupPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        playstationGroupPage.isPlaystationProductVisible();
    }

    @And("User checks that all products contains {string} or {string}")
    public void checkAllProductsTitlesContainsGroupTitle(final String shortGroupTitle, final String longGroupTitle) {
        for (String productTitle: playstationGroupPage.getTitleTextForEveryPlaystationProduct()) {
            assertTrue(productTitle.contains(shortGroupTitle) || productTitle.contains(longGroupTitle));
        }
    }

    @And("User checks filter by price visibility")
    public void checkFilterByPriceVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.isFilterByPriceVisible();
    }

    @And("User enters min price {string} and max price {string}")
    public void enterThePriceRange(final String minPrice, final String maxPrice) {
        searchResultsPage.enterMinPrice(minPrice);
        searchResultsPage.enterMaxPrice(maxPrice);
    }

    @And("User clicks go button")
    public void clickGoButton() {
        searchResultsPage.clickGoButton();
    }

    @And("User checks filters by brand visibility")
    public void checkFiltersByBrandVisibility() {
        searchResultsPage.isBrandFiltersVisible();
    }

    @And("User clicks first brand")
    public void clickFirstBrand() {
        searchResultsPage.clickFirstBrandButton();
    }

    @And("User checks that all headphones contains {string}")
    public void checkAllProductsContainsBrand(final String brand) {
        for (String productTitle: searchResultsPage.getTitleTextForEveryProduct()) {
            assertTrue(productTitle.contains(brand));
        }
    }

    @And("User checks that product prices in the price range from {int} to {int}")
    public void checkProductsPricesInThePriceRange(final int minPrice, final int maxPrice) {
        for (WebElement productWholePrice: searchResultsPage.getProductWholePrices()) {
            String wholePrice = productWholePrice.getText();
            assertTrue(minPrice <= Integer.parseInt(wholePrice) && Integer.parseInt(wholePrice) <= maxPrice);
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
