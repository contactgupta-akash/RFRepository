package com.rf.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RFHomePage {


	WebDriver driver;
	public RFHomePage(WebDriver driver) {
		this.driver=driver;
	}

	public void applyExplicitWait(By by){
		WebDriverWait wait =new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void navigateToRF(){
		driver.get("https://www.rodanandfields.com/ca/");
	}

	public void applyImplicitWait(){
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	}

	public void clickAllProducta(){
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav pull-right']/following-sibling::ul//a[contains(text(),'SHOP')]"))).build().perform();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav pull-right']/following-sibling::ul/li[1]//a[contains(text(),'All')]")).click();
	}

	public void refreshPage(){
		driver.navigate().refresh();
	}

	public void closeBrowser(){
		driver.close();
	}

	public void selectRedefineAndReverse() throws InterruptedException{
		driver.findElement(By.xpath("//input[@class='refine-products-button' and @value='- Product(s) -']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'REDEFINE')]/following-sibling::div/div")).click();
		refreshPage();
		driver.findElement(By.xpath("//input[@class='refine-products-button' and @value='- Product(s) -']")).click();
		applyExplicitWait(By.xpath("//div[contains(text(),'REVERSE')]/following-sibling::div/div"));
		driver.findElement(By.xpath("//div[contains(text(),'REVERSE')]/following-sibling::div/div")).click();
	}

	public void selectPrice(){
		driver.findElement(By.xpath("//input[@class='refine-products-button' and @value='- Price -']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'CAD$50 TO CAD$199.99')]/following-sibling::div/div")).click();
	}

	public boolean validateRedefineReverseLabelsWithCBPresent(){
		List<WebElement> lst=driver.findElements(By.xpath(".//div[@id='quick-filtered']/ul[2]/li"));
		if(lst.size()==2){
			return true;
		}else{
			return false;
		}

	}

	public boolean validateProductPrice(){
		String productPrice=driver.findElement(By.xpath("//span[text()='CAD$ 71.00']")).getText();
		String proprice[]=productPrice.split("\\s+");
		Double amt=Double.parseDouble(proprice[1]);
		double startPrice=50.00;
		double endPrice=199.99;
		if(startPrice<amt && amt<endPrice){
			return true;
		}else{
			return false;
		}
	}
}
