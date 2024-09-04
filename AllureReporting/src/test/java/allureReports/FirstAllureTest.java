package allureReports;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class FirstAllureTest {

	ChromeDriver driver ;


	@BeforeClass
	public void setup()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		driver = new ChromeDriver (options);
		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=1 , description = "Verify Logo Presence in home page")
	@Epic("EP001")
	@Feature("Feature1 : Logo")
	@Story("Story: Verify Logo Presence")
	@Step("Verify Logo")
	@Severity(SeverityLevel.MINOR)
	public void logopresence()
	{
		boolean disstatus = driver.findElement(By.id("nava")).isDisplayed();
		Assert.assertEquals(disstatus, true);
	}

	@Test(priority=3 , description ="Verify Login fonctionnality")
	@Epic("Ep002")
	@Feature("Feature2 : Verify Login Fonctionnality")
	@Story("Story: Login")
	@Step("Verify Login")
	@Severity(SeverityLevel.BLOCKER)
	
	public void loginTest() throws InterruptedException
	{
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("dodi100");
		driver.findElement(By.id("loginpassword")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(5000);
		boolean disstatuts =driver.findElement(By.id("logout2")).isDisplayed();
		Assert.assertEquals(disstatuts, true);
	}

	@Test(priority=2 , description = "Verify Registration fonctionnality")
	@Epic("Ep003")
	@Feature("Feature2: Verify Register Fonctionnality")
	@Story("Story: Verify Registering")
	@Step("Verify Register User")
	@Severity(SeverityLevel.BLOCKER)
	
	public void  registrationTest() throws InterruptedException
	{
		driver.findElement( By.id("signin2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("dodi100");
		driver.findElement(By.id("sign-password")).sendKeys("12345678");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();;		
		alert.accept();
		driver.findElement(By.id("login2")).isDisplayed();

	}	

	@AfterClass()
	@Description("Close  Application")
	public void tearDown()
	{
		driver.quit();
	}


}
