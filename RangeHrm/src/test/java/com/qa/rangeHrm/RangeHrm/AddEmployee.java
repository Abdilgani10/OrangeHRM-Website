package com.qa.rangeHrm.RangeHrm;

import static junit.framework.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
//
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployee {

	
	WebDriver driver;
	
	@Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
	}
        
	
	@Given("^the Add Employee Tab")
	public void website() {
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		driver.findElement(By
				.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
		
		
		driver.findElement(By
				.xpath("//*[@id=\"txtPassword\"]")).sendKeys("admin");
		
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	}

	@When("^I fill out the Employee Details correctly")
	public void I_fill_employee_details() {
		WebElement inputFullName = driver.findElement(By.xpath ("//*[@id=\"firstName\"]"));
		inputFullName.sendKeys("Mike");
		
		WebElement inputMiddelName = driver.findElement(By.xpath ("//*[@id=\"middleName\"]"));
		inputMiddelName.sendKeys("somthing");
		
		WebElement inputLastName = driver.findElement(By.xpath ("//*[@id=\"lastName\"]"));
		inputLastName.sendKeys("somthingelse");
		
		
	}

	@And("I choose to create Login Details")
	public void I_click_create_login() {
		WebElement clickCreateLogin = driver.findElement(By.xpath("//*[@id=\"chkLogin\"]"));
		clickCreateLogin.click();
	}
		
	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() {
		WebElement checkDetails = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1"));
		assertEquals("Personal Details", checkDetails.getText());
	}

}

