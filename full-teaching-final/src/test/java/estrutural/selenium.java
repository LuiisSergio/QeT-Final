package estrutural;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class selenium {

	private WebDriver driver;
	
	@BeforeClass
	public static void configuraDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\luiis\\git\\repository\\QeT\\full-teaching-final\\chromedriver.exe");
	}
	
	@Before
	public void createDriver() throws Exception{
		driver =  new ChromeDriver();
		driver.get("https://localhost:5000//");
	} 
	
	@Test
	public void testeTitulo() throws InterruptedException {
		assertTrue(driver.getTitle().contentEquals("FullTeaching"));
	}

}
