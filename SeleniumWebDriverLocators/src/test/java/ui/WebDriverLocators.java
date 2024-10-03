package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverLocators {
	public static String browser = "firefox";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://www.saucedemo.com/v1/");
		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.className("btn_action")).click();

		driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
		Thread.sleep(Duration.ofMillis(2000));

		driver.findElement(By.cssSelector("#inventory_sidebar_link")).click();
		Thread.sleep(Duration.ofMillis(2000));

		driver.findElement(By.xpath("//*[@id=\"item_4_img_link\"]/img")).click();
		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.cssSelector("#inventory_item_container > div > div > div > button")).click();
		Thread.sleep(Duration.ofMillis(2000));

		driver.findElement(By.tagName("path")).click();
		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.linkText("CHECKOUT")).click();
		Thread.sleep(Duration.ofMillis(2000));

		driver.findElement(By.id("first-name")).sendKeys("Mehedi");
		driver.findElement(By.id("last-name")).sendKeys("Hasan");
		driver.findElement(By.id("postal-code")).sendKeys("1347");

		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();

		Thread.sleep(Duration.ofMillis(2000));
		WebElement Element = driver.findElement(By.linkText("FINISH"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.partialLinkText("FINI")).click();

		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.cssSelector("#menu_button_container > div > div:nth-child(3) > div > button")).click();

		Thread.sleep(Duration.ofMillis(2000));
		driver.findElement(By.partialLinkText("Logou")).click();
		
		Thread.sleep(Duration.ofMillis(2000));
		driver.close();

	}

}
