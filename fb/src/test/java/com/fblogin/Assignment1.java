package com.fblogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	// Creating an instance of Firefox Browser
	FirefoxDriver driver;
	String qatechhubUrl = "http://qatechhub.com";
	String facebookUrl = "https://www.facebook.com";

	@Test(priority=0)
	public void invokeBrowser() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get(qatechhubUrl);

		String titleOfThePage = driver.getTitle();
		
		Assert.assertEquals(titleOfThePage, "QA Automation Tools Trainings and Tutorials | QA Tech Hub");

	}

	@Test(priority= 1)
	public void navigateCommands() {
		driver.navigate().to(facebookUrl);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL :: " + currentUrl);
		driver.navigate().back();

		driver.navigate().forward();

		driver.navigate().refresh();

                driver.quit();
	}

}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("9182654587");
		driver.findElement(By.name("pass")).sendKeys("944081084");
		
		
		// for buttons we use name
		driver.findElement(By.name("login")).click();
		
		// for anchor tags we use linkText and we give the text inside anchor tag
		driver.findElement(By.linkText("Forgotten password?")).click();
		
		//Using partialLinkText for anchor tags instead of giving full text we can give partial text in anchor tag
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		
//		Thread.sleep(5000);
//		
//		driver.quit();
	}

}
