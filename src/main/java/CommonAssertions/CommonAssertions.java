package CommonAssertions;

import Utilities.Actions;
import org.junit.Assert;
import org.openqa.selenium.By;


public class CommonAssertions {



    public static void assertElementDisplayed(By by) {
        Assert.assertTrue(Actions.elementDisplayed(by));

    }
}
