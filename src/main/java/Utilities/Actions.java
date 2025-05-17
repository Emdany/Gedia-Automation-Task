package Utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Actions extends DriverManager{
    private static final Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(35);

    public List<WebElement> listOfElements(By element)
    {
        return DriverManager.getDriver().findElements(element);
    }
    public static WebElement waitForElementReadiness(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForInvisibilityOfElementLocatedBy(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    //    public static void waitForElementInvisibilityOrNonClickability(By by) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME);
//
//        // Try waiting for invisibility first (preferred if element should disappear)
//        try {
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
//            return; // If element becomes invisible, exit the function
//        } catch (TimeoutException e) {
//            // If invisibility wait times out, proceed to check non-clickability
//        }
//
//        // If invisibility wait times out, wait for non-clickability as a fallback
//        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
//    }
    public static void waitForElementDisappearance(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME); // Change timeout to your desired seconds
//        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));

    }
    public static void selectFromListByText(String textToBeSelected) {
        click(By.xpath("//android.widget.TextView[contains(@text,'" + textToBeSelected + "')]"));
    }

    public static WebElement waitForElementToContainText(By by, String awaitedText) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.textToBePresentInElementValue(by, awaitedText));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void click(By by) {
        try {
            waitForElementReadiness(by);

            WebElement element = waitForElementClickable(by);
            element.click();
        } catch (Exception e) {
        }
    }



    public static void doubleClick(By by) {
        try {
            waitForElementReadiness(by);

            WebElement element = waitForElementClickable(by);
            element.click();
            element.click();
        } catch (Exception e) {
        }
    }

    public static boolean elementExists(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            return false;
        }
        if (by != null) {
            return true;
        }
        return false;
    }

    public static boolean elementNotExists(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_TIME);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            return true;
        }
        if (by != null) {
            return false;
        }
        return false;
    }

    public static void type(String text, By by) {
        waitForElementReadiness(by);
        WebElement element = waitForElementClickable(by);
        element.click();
        element.clear();
        element.sendKeys(text);
        element.submit();
    }

    public static String getElementText(By by) {
        WebElement element = waitForElementReadiness(by);
        return element.getText();
    }

    public static boolean verifyElementTextEquals(By by, String text) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getText().equals(text);
    }

    public static boolean isElementNotVisible(By by) {
        return DriverManager.getDriver().findElements(by).size() == 0;
    }

    public static void elementIsDisplayed(By by) {
        DriverManager.getDriver().findElement(by).isDisplayed();
    }

    public static String getElementAttribute(By by, String Attribute) {
        WebElement element = waitForElementReadiness(by);
        return element.getAttribute(Attribute);

    }

    public static boolean elementDisplayed(By by) {
        waitForElementReadiness(by);
        return driver.findElement(by).isDisplayed();
    }

    //    public static boolean elementEnabled(By by){
//        waitForElementReadiness(by);
//        return DriverManager.getDriver().findElement(by).isEnabled();
//    }
    public static boolean elementExist(By by) {
        if (waitForElementReadiness(by).isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }

    public static void waitUntilLoadingFinish(By loadingIcon) {
        while (true) {
            try {
                DriverManager.getDriver().findElement(loadingIcon).isDisplayed();
            } catch (Exception e) {
                break;


            }
        }
    }

    public static void wait(int timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    //TODO: implement later as touch action class is deprecated
    public static void doubleTap(By by) {
    }

    public static void scrollToElement(By by) {
    }

    public static void longClickElement(By by) {

    }

    public static void dragElement(By by) {

    }

    public static boolean elementIsEnabled(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).isEnabled();
    }

    public static boolean elementIsChecked(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getAttribute("checked").equals("true");
    }
    public static boolean elementIsNotChecked(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getAttribute("checked").equals("false");
    }

    public static boolean elementIsClickable(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getAttribute("clickable").equals("true");
    }
    public static boolean elementIsNotEnabled(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getAttribute("enabled").equals("false");
    }

    public static boolean elementIsScrollable(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getAttribute("scrollable").equals("true");
    }

    public static boolean elementIsNotClickable(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getAttribute("clickable").equals("false");
    }

    public static void clear(By by) {
        DriverManager.getDriver().findElement(by).clear();
    }

    public static int getSize(By by) {
        waitForElementReadiness(by);
        List<WebElement> elementSize = DriverManager.getDriver().findElements(by);
        return elementSize.size();
    }

    public static boolean elementIsFocusable(By by) {
        waitForElementReadiness(by);
        return DriverManager.getDriver().findElement(by).getAttribute("focusable").equals("true");
    }

    public void fillElement(By element,String value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(value);
    }
    public void clickButton(By button)
    { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        driver.findElement(button).click();
    }
    public void selectElement(By element,int index)
    {
        WebElement Lists= driver.findElement(element);
        Select selectFromTitles = new Select(Lists);
        selectFromTitles.selectByIndex(index);
    }
    public String printText(By element)
    {
        return driver.findElement(element).getText();
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void scrollToEachElement(List<WebElement> elements) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        for (WebElement el : elements) {
            js.executeScript("arguments[0].scrollIntoView(true);", el);
            try {
                Thread.sleep(300); // small pause to allow content load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
