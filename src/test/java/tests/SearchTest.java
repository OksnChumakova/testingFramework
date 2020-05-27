package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("sel")
                .verifyThatTopResultContainsProperAttributeText("LC20lb DKV0Md");

    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        steps.openToolTip()
                .verifyThatTooltipContainsProperText("Голосовий пошук");
    }
}
