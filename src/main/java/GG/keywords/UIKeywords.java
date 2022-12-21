package GG.keywords;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {
	public RemoteWebDriver driver = null;
	/**
	 * This class contains UI keywords which are applicable for webelements and
	 * general actions. This is Single tone class. To create object of this class
	 * use {@code getInstance method}
	 * 
	 * @author Pritam Bopalkar
	 *
	 */
	
	

	private static final UIKeywords uikeywords;

	static {
		uikeywords = new UIKeywords();
	}

	public static UIKeywords getInstance() {
		return uikeywords;

	}

	
	  @author PritamBopalkar This keyword is used to launch the browser.
	  @param browserName must be one of the following
	                     <ul>
	                     <li>Chrome</li>
	                     <li>Egde</li>
	 

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.err.println("Invalid Browser Name: " + browserName);
		}
	}

	public void launchURL(String url) {
		driver.get(url);
	}

	@Deprecated
	public void click(WebElement element) {
		element.click();

	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("tag")) {
			element = driver.findElement(By.tagName(locatorValue));
		}
		return element;
	}

	
	 * In the next version of framework, this method will be deleted. Instead you
	  can use enterText(String Object, String textToEnter)
	  
	  @param locatorType
	  @param locatorValue
	  @param textToEnter
	 

	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public void switchToFrameAt(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public void enterText(String Object, String textToEnter) {
		String[] parts = Object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
	}
	
	
	public void dropdown(String locatorType, String locatorValue) {
		Actions action = new Actions(driver);
		WebElement ele = getWebElement(locatorType, locatorValue);
		action.moveToElement(ele).perform();
		System.out.println(ele.getText());
	}

	public void hover(String object) {
		String[] parts = object.split("%");
		Actions action = new Actions(driver);
		WebElement ele = getWebElement(parts[0], parts[1]);
		action.moveToElement(ele).perform();
		System.out.println(ele.getText());
	}
	
	
	
	
		
	

	
	

}


