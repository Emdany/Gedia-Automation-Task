package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.IOException;

public class DriverManager {
    public static WebDriver driver;
    public void CloseDriver(){driver.close();}
    public static void openBrowser() throws IOException {

        ConfigurationProperties.initializePropertyFile();
        String browserType = ConfigurationProperties.property.getProperty("browser");
        switch (browserType.toLowerCase()) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browserType);
        }
        driver.get(ConfigurationProperties.property.getProperty("url"));
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call openBrowser() first.");
        }
        return driver;
    }
}


