package com.qa_course.base;

import com.qa_course.drivers.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class TestUtil {
    public WebDriver driver;
    private String url;
    private int implicitWait;
    private String browser;



    @BeforeMethod
    public void setUp() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setupBrowserDriver();
        loadUrl();
    }

    private void loadUrl() {
        driver.get(url);
    }

    private void setupBrowserDriver() {
        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                driver.manage().window().maximize();
                break;
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalStateException("Browser type not supported");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
