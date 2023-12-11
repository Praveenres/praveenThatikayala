package Tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.Region;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Common_Methods.CommonMethods;
import Pages.Base_Page;
import Pages.Constants;
import Pages.HomePage;


public class HomePageTest 
{

	@Test(priority=0)
	public void Validate_HomePageOpenSuccessfully()
	{

		List<String> ExpectedHeaders = Arrays.asList("Index", "Page", "About");
		Base_Page.getdriver();
		String CurrentUrl=CommonMethods.CurrentUrl();
		Assert.assertEquals(CurrentUrl, Constants.HomePageUrl,"The Url Is Not As Expected");
		List<String> PageNavigationHeaders=HomePage.GetPageNavigationHeaders();
		Assert.assertEquals(PageNavigationHeaders, ExpectedHeaders, "Expected Headers are not equal");
		String TableHeader=HomePage.GetHeaderName();
		Assert.assertEquals(TableHeader,"Dynamic HTML TABLE Tag","Table Header Is Not As expected"); 
		
	}
	@Test(priority=1)
	public void UpdatingDataInTable() throws InterruptedException
	{
		Base_Page.getdriver();
		String CurrentUrl=CommonMethods.CurrentUrl();
		Assert.assertEquals(CurrentUrl, Constants.HomePageUrl,"The Url Is Not As Expected");
		HomePage.ClickOntableDataButton();
		Assert.assertTrue(HomePage.IsTextAreaDisplayed(),"The  Text Filed Area is not Dispalyed ");
		HomePage.EnterTextInInputTextBox("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");
		HomePage.ClickRefreshTableButtton();
		
	}

	@AfterMethod
	public void DriverQuit()
	{
		Base_Page.Clase_FlushDRiver();
	}

}
