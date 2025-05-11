package codingNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {

    public WebDriver driver;

    @Test
    public void VerifyRegisteringanAccountbyprovidingonlytheMandatoryfields(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.get("http://tutorialsninja.com/demo");

        driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Alok");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Senapati");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(tempEmail());
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("5478965847");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Alok@1234");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Alok@1234");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        String properDetailsOne = "Your Account Has Been Created!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(),properDetailsOne);

        driver.findElement(By.linkText("Continue")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());

    }

    public String tempEmail(){

        Date date = new Date();
        String dateString = date.toString();
        String dateStringWithoutSpaces = dateString.replaceAll(" ","");
        String dateStringWithoutSpacesAndColons = dateStringWithoutSpaces.replaceAll(":","");
        String brandNewEmail = dateStringWithoutSpacesAndColons+"@gmail.com";
        return brandNewEmail;

    }

    @AfterTest
    public void TearDown(){
        driver.close();
    }

}
