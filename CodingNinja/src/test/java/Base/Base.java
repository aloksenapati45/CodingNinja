package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Base {

    public static WebDriver driver;
    @Test
    public static void lunchingGoogle() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://google.com");

    }

    @AfterTest
    public static void TearDown(){
        driver.close();
    }

}
