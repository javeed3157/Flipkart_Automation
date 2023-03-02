package testPackage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomationTesting {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\SUSH3001\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
		WebElement login = driver.findElement(By.className("VJZDxU"));
		login.sendKeys("9876543210");
		
		WebElement otp_request = driver.findElement(By.className("_1k3JO2"));
		otp_request.click();
		
		WebElement close_popup = driver.findElement(By.className("_2doB4z"));
		close_popup.click();
		
		String home_page_title = driver.getTitle();
		Assert.assertEquals(home_page_title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		System.out.println("Home page title validation passed");
		
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys("Iphone");
		
		WebElement search_button = driver.findElement(By.className("L0Z3Pu"));
		search_button.click();
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement iphone_selector = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col col-7-12']/child::div[contains(text(),'APPLE iPhone 11 (White, 128 GB)')]")));
		iphone_selector.click();
		
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wid.get(1));
		
		String iphone_page_title = driver.getTitle();
		Assert.assertEquals(iphone_page_title, "APPLE iPhone 11 ( 128 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com");
		System.out.println("Iphone page title validation passed");
		
		Boolean var1 = driver.findElements(By.xpath("//*[@id='swatch-0-storage']")).size() > 0;
		Boolean var2 = driver.findElements(By.xpath("//*[@id='swatch-1-storage']")).size() > 0;
		Assert.assertTrue(var1);
		Assert.assertTrue(var2);
		System.out.println("64GB and 128GB varients validation passed");
		
		Boolean col1 = driver.findElements(By.id("swatch-0-color")).size() > 0;
		Boolean col2 = driver.findElements(By.id("swatch-1-color")).size() > 0;
		Boolean col3 = driver.findElements(By.id("swatch-2-color")).size() > 0;
		Boolean col4 = driver.findElements(By.id("swatch-3-color")).size() > 0;
		Boolean col5 = driver.findElements(By.id("swatch-4-color")).size() > 0;
		Boolean col6 = driver.findElements(By.id("swatch-5-color")).size() > 0;
		Assert.assertTrue(col1);
		Assert.assertTrue(col2);
		Assert.assertTrue(col3);
		Assert.assertTrue(col4);
		Assert.assertTrue(col5);
		Assert.assertTrue(col6);
		System.out.println("All 6 colors validation passed");
		
		WebElement pick_variant = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='swatch-0-storage']")));
		pick_variant.click();
		System.out.println("Selected 64GB varient");
		
		WebElement pick_color = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='swatch-0-color']")));
		pick_color.click();
		System.out.println("Selected Black varient");

		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")));
		WebElement add_to_cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		add_to_cart.click();
		
		WebElement cart = driver.findElement(By.xpath("//a[@class='_3SkBxJ']"));
		cart.click();
		
		String cartTitle = "Shopping Cart | Flipkart.com";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		WebElement ordering = driver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
		Assert.assertEquals(driver.getTitle(), cartTitle);
		System.out.println("Cart page title validation passed");

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div/div[4]/div/form/button/span")));
		WebElement order = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div/div[4]/div/form/button/span"));
		order.click();
		System.out.println(driver.getTitle());
		
		String place_order_title = "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order";
		Assert.assertEquals(driver.getTitle(), place_order_title);
		Thread.sleep(5000);
		System.out.println("Place Order page validation passed");
		
		driver.close();
	}

}