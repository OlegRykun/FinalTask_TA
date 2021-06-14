package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageSelectionPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Übersetzung')]")
    private WebElement germanRadioButton;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement saveChangesButton;

    public LanguageSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void isGermanRadioButtonVisible() {
        germanRadioButton.isDisplayed();
    }

    public void clickGermanRadioButton() {
        germanRadioButton.click();
    }

    public void isSaveChangesButtonVisible() {
        saveChangesButton.isDisplayed();
    }

    public void clickSaveChangesButton() {
        saveChangesButton.click();
    }
}
