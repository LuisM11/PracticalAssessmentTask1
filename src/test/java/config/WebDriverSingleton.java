package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverSingleton {

    private static final Logger logger = LogManager.getLogger(WebDriverSingleton.class);
    private static WebDriver driver;
    private WebDriverSingleton() {}
    public static WebDriver createDriver() {
        if(driver == null){
            String browser = System.getProperty("browser");
            switch (browser) {
                case "firefox":
                    logger.info("Setting browser: Firefox");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    logger.info("Setting browser: Edge");
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                default:
                    logger.info("Setting browser: Chrome");
                    driver = new ChromeDriver();

            }
            driver.manage().window().maximize();
        }
        logger.info("Driver was created and set up");
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
