package assignment;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import jdk.javadoc.internal.doclets.toolkit.taglets.InheritableTaglet.Output;

public class LoginApp {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//open the guest mode
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		
		//launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
	       
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       
	       //full screen of the window
	       driver.manage().window().maximize();
	       
	       //enter the username
	       driver.findElement(By.xpath("//input[@type='text']")).sendKeys("standard_user");
	       
	       //enter the password
	       driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
	       
	       //click the login button
	       driver.findElement(By.xpath("//input[@type='submit']")).click();
	       	
	       
	     // using dropdown method filter the first product 
	       Select slt = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
	       slt.selectByVisibleText("Name (A to Z)");
	       
	       //click the product
	       driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
	       
	       //capure the product name
	       WebElement element = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
	       File source = element.getScreenshotAs(OutputType.FILE);
	       File dest = new File("./images/productname.png");
	       FileUtils.copyFile(source,dest);
	       
	       
	       //print the product name
	       String First_productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
	       System.out.println(First_productName);
	       
	       
	       	//capture the product price
	       WebElement price = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
	       File sour = price.getScreenshotAs(OutputType.FILE);
	       File des = new File("./images/price.png");
	       FileUtils.copyFile(sour,des);
	       
	       //print the productprice
	       String First_productPrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();
	       System.out.println(First_productPrice);
	       
	       //click the add to card
	       driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();
	       
	       
	       //click the card igon
	       driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
	       
	    
	       //verify the product price in cart match the inventory price
	       String match = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
	       
	       if(First_productPrice.contains(match))
	       {
	    	   System.out.println("Price Match");
	       }
	       
	       //click on checkout
	       driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
	       
	    //enter first name,last name,and postal code
	       driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Jeyamuthu");
	       
	       driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("G");
	       
	       driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("600119");
	       
	       // click continue
	       driver.findElement(By.xpath("//input[@type='submit']")).click();
	       
	       //store the all price
	       
	       int arr[] = new int[3];
	    
	    String sub_total = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
	    String subTotalValue = sub_total.replaceAll("[^\\d.]", ""); 
	    System.out.println(subTotalValue);
	    double val1 = Double.parseDouble(subTotalValue);
	    arr[0] = (int) val1; 

	    
	    String tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
	    String taxValue = tax.replaceAll("[^\\d.]", "");
	    double val2 = Double.parseDouble(taxValue);
	    arr[1] = (int) val2;

	    String total = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
	    String totalValue = total.replaceAll("[^\\d.]", "");
	    double val3 = Double.parseDouble(totalValue);
	    arr[2] = (int) val3;

	    Arrays.sort(arr);
	    
	    // print the second heighest price
	       System.out.println(arr[1]);
	       
	       
	       
	       //click finish
	       driver.findElement(By.xpath("//a[@class='btn_action cart_button']")).click();
	       
	       //take a screenshot of the confirmation page 
	       File source1 = driver.getScreenshotAs(OutputType.FILE);
	       File dest1 = new File("./images/finish.png");
	       FileUtils.copyFile(source1,dest1);
	       
	       
	       //close the browser
	       driver.quit();
	       
	}
}
