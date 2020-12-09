package estrutural_selenium;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriver {
	protected WebDriver drive;
	
	@BeforeClass
	public static void configuraDrive() {
		System.setProperty("webdriver.gecko.drive","D:\\libs//geckodriver.exe");
	}
	@Before
	public void createDrive() {
		drive = new ChromeDriver();
		drive.get("https://localhost:5000");		
	}
	
	@Test
	public void testaTituloPagina() {
		//
	}
}
