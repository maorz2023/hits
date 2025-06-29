package stepdefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Base;

public class StepDefinition {

	 WebDriver driver = Base.driver;
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    @Given("the user opens the website")
	    public void the_user_opens_the_website() {
	        driver.manage().window().maximize();
	        driver.get("https://www.mercadolibre.com/");
	    }

	    @And("selects {string} as the country")
	    public void selects_country(String country) throws InterruptedException {
	    	Thread.sleep(3000);
	        WebElement countryBtn = driver.findElement(By.xpath("//a[contains(text(),'xico')]"));
	        countryBtn.click();
	    }

	    @When("the user searches for {string}")
	    public void the_user_searches_for(String term) {
	        WebElement searchBox = driver.findElement(By.name("as_word"));
	        searchBox.sendKeys(term);
	        searchBox.sendKeys(Keys.ENTER);
	    }

	    @And("filters by condition {string}")
	    public void filters_by_condition(String condition) throws InterruptedException {
		    Thread.sleep(2000);
	        WebElement filter = driver.findElement(By.partialLinkText(condition));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", filter);
	    }

	    @And("filters by location {string}")
	    public void filters_by_location(String location) throws InterruptedException {
	    	Thread.sleep(2000);
	        WebElement locFilter = driver.findElement(By.partialLinkText(location));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locFilter);
	    }

	    @And("orders results from {string}")
	    public void orders_results(String order) throws InterruptedException {
	    	Thread.sleep(2000);
	        WebElement sortDropdown = driver.findElement(By.className("andes-dropdown__trigger"));
	        sortDropdown.click();
	        Thread.sleep(1000);
	        WebElement option = driver.findElement(By.cssSelector("#\\3AR1b55ie\\3A-menu-list-option-price_desc .andes-list__item-primary"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
	        option.click();
	        Thread.sleep(3000);
	    }

	    @Then("the user gets the name and price of the first 5 products")
	    public void get_product_info() {
	    	List<WebElement> results = driver.findElements(By.className("ui-search-layout__item"));
	        

	        System.out.println("\nTop 5 Products:");
	        
	        for (int i = 0; i < 5 && i < results.size() && i < results.size(); i++) {
	        	WebElement title = results.get(i).findElement(By.className("poly-component__title-wrapper"));
		        WebElement price = results.get(i).findElement(By.className	("poly-price__current"));
		        System.out.println("Title is :- " + title.getText() + " and Price is :- " + price.getText());
	        }
	    }

	    @And("prints the product details in the console")
	    public void done() {
	       
	    }

}
