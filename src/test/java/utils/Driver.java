package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver(){

//        if the driver is == null then create a driver if not then give me current driver
        if(driver==null){
            WebDriverManager.chromedriver().setup(); // this line is for System.setproperty
            driver = new ChromeDriver();
        }

        return driver;

    }

}
