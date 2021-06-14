package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-box']")
    private WebElement signInBox;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailInput;

    @FindBy(xpath = "//span[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[contains(text(), 'We cannot')]")
    private WebElement thereIsNoAccountWithSuchEmailMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void isSignInBoxVisible() {
        signInBox.isDisplayed();
    }

    public void waitAndEnterToEmailInput(final String email) {
        emailInput.isDisplayed();
        emailInput.sendKeys(email);
    }

    public void waitAndClickContinueButton() {
        continueButton.isDisplayed();
        continueButton.click();
    }

    public String getTextNoAccountMessage() {
        return thereIsNoAccountWithSuchEmailMessage.getText();
    }
}
