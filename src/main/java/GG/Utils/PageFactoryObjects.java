package GG.Utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GG.keywords.UIKeywords;

public class PageFactoryObjects {
	String str = null;

	UIKeywords k1 = UIKeywords.getInstance();

	@FindBy(css = "ul#menu-courses >li")
	public List<WebElement> courseLinks;

	public boolean getAllCoursesLinks() {
		
		java.util.Iterator<WebElement> itr = courseLinks.iterator();
		while (itr.hasNext()) {
			
			 str =  itr.next().getText();
		}
		String[] s1 = {"MPSC CLASSROOM PROGRAM",
				"UPSC CLASSROOM PROGRAM",
					"BANKING & SSC",
				"SMILE – FOUNDATION COURSE"};
		
		int count = 0;
		for(int i=0;i<s1.length;i++) {
			System.out.println("Expected "+s1[i]);
			if(s1[i].equalsIgnoreCase(str)) {
				
				System.out.println(str);
				count++;
				
			}
	}
		return true;
	}

	public PageFactoryObjects() {

		PageFactory.initElements(k1.getDriver(), this);
	}
}
