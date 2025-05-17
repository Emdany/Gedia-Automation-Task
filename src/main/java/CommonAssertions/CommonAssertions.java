package CommonAssertions;

import Utilities.DriverManager;
import Utilities.Actions;
import org.junit.Assert;
import org.openqa.selenium.By;
//import org.assertj.core.api.Assertions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class CommonAssertions {
    public static void assertTwoStrings(String first, String second) {
        Assert.assertEquals(first.replaceAll("\\s+",""), second.replaceAll("\\s+",""));
    }

    public static void stringMatching(String string){
        assertTrue(Pattern.matches("^[a-zA-Z]+$",string));

    }

    public static void assertTwoIntegers(int first, int second) {
        Assert.assertEquals(first, second);
    }

    public static void assertElementDisplayed(By by) {
        Assert.assertTrue(Actions.elementDisplayed(by));

    }

    public static void assertElementNotDisplayed(By by) {
        Assert.assertTrue(Actions.elementNotExists(by));
    }
    public static void assertElementText(String expectedText,By by){
        Assert.assertEquals(Actions.getElementText((by)).replaceAll("\\s+",""),expectedText.replaceAll("\\s+",""));
    }

    public static void assertElementExists(By by) {
        Assert.assertTrue(Actions.elementExist(by));
    }


    public static boolean assertContains(String fullString, String actualtext) {
        return fullString.replaceAll("\\s+","").contains(actualtext.replaceAll("\\s+",""));
    }

    public static void assertTrue(Boolean condition) {
        Assert.assertTrue(condition);
    }

    public static void assertFalse(Boolean condition) {
        Assert.assertFalse(condition);

    }

    public static boolean isNumber(String number) {
        try {
            Double.parseDouble(number.replaceAll("\\s", ""));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isValidCardNumber(String number) {
        String[] groups = number.split(" ");
        if (groups.length == 4) {
            for (String group : groups) {
                if (group.length() != 4 || !group.matches("\\d{4}")) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void isValidCVV(String number) {
        CommonAssertions.assertTrue(number.length() == 3 && isNumber(number));
    }

    public static void validateCardExpiryDate(String expiryDate) {
        CommonAssertions.assertTrue(expiryDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}"));
    }

    public static boolean validateOpeningDate(String date) {
        DateFormat df = new SimpleDateFormat("dd MMM yyyy");
        try {
            df.parse(date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void elementEnabled(By by) {
        CommonAssertions.assertTrue(Actions.elementIsEnabled(by));
    }

    public static void elementDisabled(By by) {
        CommonAssertions.assertFalse(Actions.elementIsEnabled(by));
    }

    public static void elementNotChecked(By by) {
        CommonAssertions.assertFalse(Actions.elementIsChecked(by));
    }

    public static boolean hasCommaSeparator(String number) {
        return number.matches("(\\d{1,3},)*\\d{1,3}(\\.\\d+)?");
    }

    public static boolean isTwoDecimalValues(String number) {
        return number.matches("(\\d+,)*\\d*(\\.\\d{2})");
    }
    public static void firstAndLast(){

    }

    public static void assertElementEditable(By by) {
        CommonAssertions.assertTrue(Actions.elementIsFocusable(by));
    }
    public static void assertTwoDoubles(double first, double second) {
        Assert.assertEquals(first, second);
    }




}
