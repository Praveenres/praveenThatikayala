package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Base_Page {
	
	protected static By  navigation =By.xpath("//div[contains(@class,'navigation')]/a");
	protected static By  pageHeader=By.xpath("//div[@class='page-body']//h1");
	protected static By  tableDataButton =By.xpath("//*[text()='Table Data']");
	protected static By  textArea=By.xpath("//textarea[@id='jsondata']");
	protected static By RefreshTableButtton=By.xpath("//button[@id='refreshtable']");
	protected static By tableId=By.id("dynamictable");
	
	public static List<String> GetPageNavigationHeaders()
	{
		List<WebElement> elements=driver.findElements(navigation);
		List<String> rowData = new ArrayList<String>();
		
		for (WebElement element : elements) {
            String elementText = element.getText();
            rowData.add(elementText);
        }
		return rowData;
	}
	
	public static String GetHeaderName()
	{
		String HeaderName=driver.findElement(pageHeader).getText();
		return HeaderName;
	}
	
	public  static List<List<String>> GetDynamicTableData()
	{
		List<List<String>> tableData = new ArrayList<List<String>>();
        WebElement table = driver.findElement(tableId);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<String> rowData = new ArrayList<String>();
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                rowData.add(column.getText());
            }
            tableData.add(rowData);
        }
        return tableData;
	}

	public static void ClickOntableDataButton()
	{
		driver.findElement(tableDataButton).click();
	}
	
	public static void EnterTextInInputTextBox(String Text) throws InterruptedException
	{
		driver.findElement(textArea).clear();
		Thread.sleep(5000);
		driver.findElement(textArea).sendKeys(Text);
	}
	
	public static Boolean IsTextAreaDisplayed()
	{
		Boolean IsDisplayed=driver.findElement(textArea).isDisplayed();
		return IsDisplayed;
	}
	
	public static void ClickRefreshTableButtton()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(RefreshTableButtton)).click().perform();
		
	}
}
