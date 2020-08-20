package StepDefitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Search {
    WebDriver driver;
    @Given("^Navigate to website$")
    public void navigateToWebsite() {
        driver = Driver.getDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
    }

    @When("^Open the website close popup$")
    public void openTheWebsiteClosePopup() {
       try{
           WebElement closePopUp = driver.findElement(By.cssSelector("button[class='c-close-icon  c-modal-close-icon']"));
           closePopUp.click();
       }catch (Exception e){
           System.out.println("No pop up close");
       }
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gh-search-input")));
    }

    @Then("^I search for products I expect number of results to be:$")
    public void searchAndClickSearch(DataTable table) throws InterruptedException {
        List<Map<String, String>> mapList = table.asMaps(String.class, String.class);
        for ( Map<String, String> row: mapList) {
            Thread.sleep(300);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //  WebDriverWait wait = new WebDriverWait(driver, 10);
       //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gh-search-input")));
         //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-search-input")));
            WebElement search = driver.findElement(By.cssSelector("input.search-input"));
            search.sendKeys(row.get("product"));
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class='header-search-button']")));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='header-search-button']")));
            driver.findElement(By.cssSelector("button[class='header-search-button']")).click();
            Thread.sleep(3000);
            int results = driver.findElements(By.cssSelector("li.sku-item")).size();
             Thread.sleep(3000);
            System.out.println(results);
            Assert.assertEquals(results, Integer.parseInt(row.get("results")));
            driver.findElement(By.cssSelector(".bby-logo-lv")).click();
        }


    }

}
