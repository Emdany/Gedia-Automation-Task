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


    public static boolean elementDisplayed(By by) {
        waitForElementReadiness(by);
        return driver.findElement(by).isDisplayed();
    }


    public static boolean elementExist(By by) {
        if (waitForElementReadiness(by).isDisplayed()) {
            return true;
        } else {
            return false;
        }

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
