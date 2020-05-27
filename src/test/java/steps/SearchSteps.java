package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {

        searchPage.pasteToSearchField((keyword));
        searchPage.pressSearchButtonOrPressEnter();
        return new SearchResultsSteps();
    }

    public SearchSteps openToolTip() {
        searchPage.moveToSearchVoiceButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsProperText(String text) {
        searchPage.assertThatVoiceTooltipContainsText(text);
        return this;
    }
}
