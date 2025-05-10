package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Config {
    public WebDriver driver;

    @Test
    public void Connect(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @AfterTest
    public void TearDown(){
        driver.close();
    }
}
