package week5.day1.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {

		public  ChromeDriver driver;

		@BeforeMethod
		public void preCondition() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://dev67185.service-now.com");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
			driver.switchTo().frame(frame1);
			driver.findElement(By.id("user_name")).sendKeys("admin");
			Thread.sleep(1000);
			driver.findElement(By.id("user_password")).sendKeys("Bvcxz@12345");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			Thread.sleep(1000);
			WebElement inputIncident = driver.findElement(By.xpath("//input[@id='filter']"));
			inputIncident.sendKeys("incident");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[text()='Incidents']")).click();
			Thread.sleep(2000);

		}

		@AfterMethod
		public void postCondition() {
			driver.close();

		}

	}


