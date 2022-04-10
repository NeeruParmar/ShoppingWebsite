package com.automationWesiteBasePackage;

import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.automationLogger.WebdriverEvents;
import com.automationWebsite.Utils.Utilis;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	public static Properties prop;
	public FileInputStream file;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebdriverEvents eventListner;
	public static JavascriptExecutor jse;

	public TestBase() {

		try {
			prop = new Properties();
			file = new FileInputStream(
					"C:\\Users\\16474\\OneDrive\\ShoppingWebsiteFramework\\src\\main\\java\\configuration\\propertiesPackage\\websiteconfiguration.properties");
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);

	}

	public void initialization() {
		WebDriverManager.chromiumdriver().setup();

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			wd = new EdgeDriver();
			break;

		default:
			System.out.println("You are not passing the correct browser name");
			break;
		}

		// Intialising Webdriver Event Listener
		e_driver = new EventFiringWebDriver(wd);
		eventListner = new WebdriverEvents();
		e_driver.register(eventListner);
		wd = e_driver;

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Utilis.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(Utilis.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		// Load the Page
		wd.get(prop.getProperty("URL"));

	}

	public void tearDown() {
		wd.quit();
	}

	public void waitForDocumentCompleteState(int timeOutInSeconds) {
		new WebDriverWait(wd, 15).until((ExpectedCondition<Boolean>) v -> {
			logger.info("Verifying page has loaded......");
			jse = (JavascriptExecutor) wd;
			String documentIsReady = jse.executeScript("return document.readyState").toString();
			while (true) {
				if (documentIsReady.equalsIgnoreCase("complete")) {
					logger.info("Page has loaded completely......");
					return true;
				} else {
					return false;
				}
			}
		});
	}

}
