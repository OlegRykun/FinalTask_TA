package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GamingAccessoriesCategoryPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'bxc-grid__image bxc')]")
    private List<WebElement> gamingAccessoriesCategoryGroups;

    public GamingAccessoriesCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void isGamingAccessoriesCategoryGroupsVisible() {
        for (WebElement group : gamingAccessoriesCategoryGroups) {
            group.isDisplayed();
        }
    }

    public int getGamingAccessoriesCategoryGroupsCount() {
        return gamingAccessoriesCategoryGroups.size();
    }

    public void clickOnFirstGroup() {
        gamingAccessoriesCategoryGroups.get(0).click();
    }

    public void clickPlaystationGroup() {
       gamingAccessoriesCategoryGroups.get(5).click();
    }
}
