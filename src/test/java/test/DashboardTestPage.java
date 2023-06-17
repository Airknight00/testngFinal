package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashboardPage;
import util.BrowserFactory;

public class DashboardTestPage {

	
	WebDriver driver; 
	DashboardPage dashboardPage;
	String categoryName;
	@BeforeMethod
	public void initalizeBrowser() {
		driver = BrowserFactory.init();
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	}
	
	//Validate user is able to add a category and once category is added it should display
	@Test
	public void addCategoryAndValidate() {
	categoryName = dashboardPage.insertIntoCategoryField("Garfieldtheorange");
	dashboardPage.selectFromColorDropDown("Burnt Orange");
	dashboardPage.clickonAddCategoryButton();
	dashboardPage.clickOnConfirmColorChange();
	}
	//Test2 and a meow
	@Test
    public void userShouldNotBeAbleToAddDuplicateCategory() {
        String constantCategory = "MagentusTheCreamy";
        dashboardPage.insertIntoCategoryFieldConstantValue(constantCategory);
        dashboardPage.clickonAddCategoryButton();
        dashboardPage.validateIfCategoryAlreadyExists(constantCategory);
}
	
	@Test
    public void validateMonthDropDown() {
        dashboardPage.validateMonths();
    }
}



