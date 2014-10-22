package org.my.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestScripts {
	VerifyConditions verfi;
	private static final String INPUT_USERNAME = "Email";
	private static final String INPUT_PASS = "Passwd";
	private static final String BUTTON_LOGIN = "signIn";

	private static final String USERNAME = "pal17584@gmail.com";
	private static final String PASS = "hoatrinhnu";
	private WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void beforeTest() {
		driver.get("http://gmail.com");
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() {
	System.out.println("BeforeMethod\n");
	verfi = new VerifyConditions();
	verfi.clearVerificationErrors();
	}


	@Test
	public void validLogin() throws InterruptedException {

		 //wait for loading page
		Thread.sleep(2000);

		// identify control
		WebElement userid = driver.findElement(By.id(INPUT_USERNAME));
		WebElement pass = driver.findElement(By.id(INPUT_PASS));
		WebElement login = driver.findElement(By.id(BUTTON_LOGIN));

		// enter data
		userid.sendKeys(USERNAME);
		pass.sendKeys(PASS);
		login.click();

		// wait for loading page
		Thread.sleep(5000);
		///driver.findElement(By.xpath(".//*[@id=':fg']/div/div[1]/span/a")).getText()
		// verify login successfully as dashboard page is displayed
		verfi.verifyEquals("Cannot found the element",driver.findElement(By.xpath(".//*[@id=':fg']/div/div[1]/span/a")).getText(),
				driver.findElement(By.xpath(".//*[@id=':fg']/div/div[1]/span/a")).getText());
        System.out.print("Test is at the end\n");
        verfi.checkForVerificationErrors();
	}

}