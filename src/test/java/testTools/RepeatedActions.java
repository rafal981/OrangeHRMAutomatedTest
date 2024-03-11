package testTools;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RepeatedActions {
    public RepeatedActions() {
    }

    public static void deletingAndAddingContentToLabel(WebDriver driver, WebElement webElement, String content) {
        (new Actions(driver)).click(webElement).pause(100L).keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"a"}).keyUp(Keys.CONTROL).pause(100L).sendKeys(new CharSequence[]{Keys.BACK_SPACE}).pause(100L).sendKeys(new CharSequence[]{content}).perform();
    }
}
