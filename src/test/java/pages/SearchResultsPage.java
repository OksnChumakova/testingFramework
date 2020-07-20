package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(css = "h3[class='LC20lb DKV0Md']")
    private List<WebElement> resultRows;


    public void assertThatResultsContainCorrectText(String text) {

        resultRows = resultRows.stream().filter(e-> !e.getText().isEmpty()).collect(Collectors.toList());
        assertThat(resultRows
                .stream()
                .filter(e -> e.getText().toLowerCase().contains(text.toLowerCase()))
                .count())
                .as("Wrong text has been displayed").isEqualTo(resultRows.size());

    }

    public void assertThatTopResultTagContainsProperText(String text) {
        assertThat(resultRows.get(0).getText()).as("Wrong tag text").contains(text);
    }
}
