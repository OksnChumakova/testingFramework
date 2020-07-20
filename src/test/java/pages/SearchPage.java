package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "btnk")
    private WebElement searchButton;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(css = "div.hpuQDe")
    private WebElement searchByVoiceButton;

    public void fillSearchPage(String text) {
        searchField.click();
        searchField.sendKeys(text);
    }

    public void pressEnter() throws InterruptedException {
        searchField.sendKeys(Keys.RETURN);
    }

    public void pressSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnk"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//            searchButton.click();
            clickWithJavascript(searchButton);
        } else {
            pressEnter();
        }
    }

    public void pasteToSearchField(String text) {
        pasteTextToElementFromClipBoard(searchField, text);
    }

    public void moveToSearchVoiceButton() {
        builder.moveToElement(searchByVoiceButton).build().perform();
    }

    public void assertThatVoiceTooltipContainsText(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip " + text + "was not found").isNotZero();
    }
}
