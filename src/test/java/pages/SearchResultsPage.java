package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@data-hveid='CAMQAA' or @data-hveid='CAQQAA']//h3")
    private WebElement resultRow;

    @FindBy(xpath = "//div[@data-hveid='CAMQAA' or @data-hveid='CAQQAA']//h3")
    private List<WebElement> resultRows;


    public void assertThatTopResultContainsCorrectText(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElements(resultRows));
        assertThat(resultRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString().toLowerCase())
                .as("Wrong text has been displayed").contains(text);

    }

    public void assertThatTopResultContainsProperAttributeText(String text) {
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text").contains(text);
    }
}
