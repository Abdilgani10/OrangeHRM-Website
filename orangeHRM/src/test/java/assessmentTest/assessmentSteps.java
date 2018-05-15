package assessmentTest;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class assessmentSteps {
	
	WebDriver driver;
	
	@Before
	public void RunBeforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() {
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")).click();
	}

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() {
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Dorothy");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Jones");
	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() {
		driver.findElement(By.xpath("//*[@id=\"chkLogin\"]")).click();
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() {
		driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("Dorothy");
		driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id=\"re_password\"]")).sendKeys("password");	
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() {
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() {
		WebElement checkDetails = driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1"));
		assertEquals("Personal Details", checkDetails.getText());
	}
}
