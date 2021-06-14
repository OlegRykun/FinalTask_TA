package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PlaystationGroupPage extends BasePage {

    @FindBy(xpath = "//h2[contains(@class, 'a-size-mini')]")
    private List<WebElement> playstationProductTitles;

    public PlaystationGroupPage(WebDriver driver) {
        super(driver);
    }

    public void isPlaystationProductVisible() {
        for (WebElement productTitle: playstationProductTitles) {
            productTitle.isDisplayed();
        }
    }

    public ArrayList<String> getTitleTextForEveryPlaystationProduct() {
        ArrayList<String> titlesText = new ArrayList<String>();
        for (WebElement product: playstationProductTitles) {
            titlesText.add(product.getText().toLowerCase());
        }

        return titlesText;
    }
}
