package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Page {
	
	public static WebDriver driver;
	
	
	
	public static void getdriver()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(Constants.HomePageUrl);
		//Thread.sleep(3000);
		driver.manage().window().maximize();
		
	}
	
	public static void Clase_FlushDRiver()
	{
		driver.quit();
	}
	
}
