package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginBrowser {

	public static void main(String[] args) throws InterruptedException {

		// open the guest account
       ChromeOptions opt = new ChromeOptions();
       opt.addArguments("guest");

	// create the object for ChromeDriver
       ChromeDriver driver = new ChromeDriver(opt);
		
		// Launch the Browser
       driver.get("https://www.saucedemo.com/v1/");
       
       // maximize the screen
       driver.manage().window().maximize();

		//send the Username
       driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// send the Password
       driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
       //click the login button
       driver.findElement(By.id("login-button")).click();
       
       Thread.sleep(3000);

		// close the window
       driver.quit();
       
      
	}

}
