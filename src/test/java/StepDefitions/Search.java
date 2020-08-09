package StepDefitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

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

    }

    @Then("^Search \"([^\"]*)\" and click search$")
    public void searchAndClickSearch(String product) throws InterruptedException {
        Thread.sleep(1000);
//        //search Ipad
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[class='search-input']"))));
        WebElement search=driver.findElement(By.cssSelector("input[class='search-input']"));
//        //WebElement search=driver.findElement(By.xpath("//input[@class='search-input']"));
        search.sendKeys(product);
        Thread.sleep(1000);
        //        //click search button
        WebElement clickSearchButton=driver.findElement(By.cssSelector("button[class='header-search-button']"));
//       // WebElement clickSearchButton=driver.findElement(By.xpath("//button[@class='header-search-button']"));
        clickSearchButton.click();

    }

}
