package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       ChromeOptions opt = new ChromeOptions();
       opt.addArguments("guest");
       
       ChromeDriver driver = new ChromeDriver(opt);
       driver.get("https://www.saucedemo.com/v1/");
       
       
       driver.manage().window().maximize();
       
       driver.findElement(By.id("user-name")).sendKeys("standard_user");
       
       driver.findElement(By.id("password")).sendKeys("secret_sauce");
       
       driver.findElement(By.id("login-button")).click();
       
       Thread.sleep(3000);
       
       driver.quit();
       
      
	}

}
