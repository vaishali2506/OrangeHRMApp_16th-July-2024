package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

protected static WebDriver driver;
	
	public static void initialization() {
		
		//Connect to actual browser
		//Upcasting
		driver = new EdgeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Pageload Timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		//Delete allcookies
		driver.manage().deleteAllCookies();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Open URL
		driver.get("https://www.facebook.com/signup");
		
	}
}
