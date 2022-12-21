package GG.HomePageTests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import GG.Utils.Locator;
import GG.Utils.PageFactoryObjects;
import GG.config.BaseClass;
import GG.keywords.UIKeywords;

@Test
public class HomePage extends BaseClass {
	UIKeywords k1 = UIKeywords.getInstance();

	public void VerifyTitleOfHomePage() {
		String expectedTitle = "Guidance Group – Only Guidance Prevails";
		k1.launchURL("http://guidancegroup.co.in/");
		String title = k1.getTitleOfPage();
		Assert.assertEquals(title, expectedTitle);

	}

	public void verifyListOfOptionsonHomePage() {
		k1.hover(Locator.Home);
		k1.hover(Locator.ABOUT_US);
		k1.hover(Locator.OUR_TEAM);
		k1.hover(Locator.BOOKS);
		k1.hover(Locator.COURSES);
		k1.hover(Locator.RESULTS);
		k1.hover(Locator.GALLARY);
		k1.hover(Locator.NOTIFICATION);
		k1.hover(Locator.CURRENT_AFFAIRS);
		k1.hover(Locator.CONTACT_US);

	}

	public void verifyListOfCurrentAffairOptions() {

		k1.dropdown("css", "#nav-menu-item-9410 > a > span > span");
		k1.dropdown("css", "#nav-menu-item-9414 > a > span > span");
	}

	public void verifyLanguageOfCurrentAffairsMarathi() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  k1.hover(Locator.CURRENT_AFFAIRS);  k1.click("css",
	  "#nav-menu-item-9414 > a > span > span"); k1.dropdown("css",
	  "#nav-menu-item-9414 > a"); k1.click("css", "#nav-menu-item-9414 > a");
	  k1.launchURL("http://guidancegroup.co.in/category/current-affairs/marathi/");
	  String actual = k1.getTitleOfPage(); String expected =
	  "Current affairs Marathi – Guidance Group"; Assert.assertEquals(actual,
	  expected);
	  
	  }

	public void courseList() {
		PageFactoryObjects courses = new PageFactoryObjects();

		courses.getAllCoursesLinks();

	}

}
