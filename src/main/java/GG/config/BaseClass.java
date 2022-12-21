package GG.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import GG.keywords.UIKeywords;

public class BaseClass {
	UIKeywords keyword = UIKeywords.getInstance();
	public RemoteWebDriver driver = null;

	@BeforeMethod
	public void setup() {
		
		keyword.openBrowser("chrome");
		this.driver = keyword.getDriver();
		keyword.launchURL("http://guidancegroup.co.in");

	}

	

}
