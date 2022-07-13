package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.BackgroundObjects;
import pageObjects.Test1Objects;
import pageObjects.Test2Objects;
import pageObjects.Test3Objects;
import pageObjects.Test4Objects;

public class PageObjectManager {
	private WebDriver driver;
	private BackgroundObjects backgroundObjects;
	private Test1Objects test1Objects;
	private Test2Objects test2Objects;
	private Test3Objects test3Objects;
	private Test4Objects test4Objects;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}	
	
	public BackgroundObjects getBackground() {
		return(backgroundObjects==null) ? backgroundObjects = new BackgroundObjects(driver) : backgroundObjects;
	}
	
	public Test1Objects getTest1() {
		return(test1Objects==null) ? test1Objects = new Test1Objects(driver) : test1Objects;
	}
	
	public Test2Objects getTest2() {
		return(test2Objects==null) ? test2Objects = new Test2Objects(driver) : test2Objects;
	}
	
	public Test3Objects getTest3() {
		return(test3Objects==null) ? test3Objects = new Test3Objects(driver) : test3Objects;
	}
	
	public Test4Objects getTest4() {
		return(test4Objects==null) ? test4Objects = new Test4Objects(driver) : test4Objects;
	}
}
