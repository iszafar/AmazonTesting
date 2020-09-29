package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonPage {
	WebDriver driver;
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchBtn = By.xpath("//input[@value='Go']");
	By imgItem = By.xpath("(//img[@class='s-image'])[2]");
	By noProtecction = By.xpath("//button[@id='siNoCoverage-announce']");
	By cart = By.xpath("//input[@id='add-to-cart-button']");
	By protection = By.xpath("//button[@id='siNoCoverage-announce']");
	By proceed = By.xpath("//a[@id='hlb-ptc-btn-native']");
	By inputEmail = By.xpath("//input[@id='ap_email']");
	By continueBtn = By.xpath("//input[@id='continue']");
	By xboxItem = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	public AmazonPage(WebDriver driver) {
		this.driver=driver;
	}
	public void inputSearchBox(String searchString) {
		driver.findElement(searchBox).sendKeys(searchString);
		
	}
	public void clickSearchBtn () {
		driver.findElement(searchBtn).click();
	}
	public void clickItem() {
		driver.findElement(imgItem).click();
	}
	public void addToCart() {
		driver.findElement(cart).click();
	}
	public void addNoProtectionPlan() {
		driver.findElement(protection).click();
	}
	public void checkOut() {
		driver.findElement(proceed).click();
	}
	public void inputEmail(String emailString) {
		driver.findElement(inputEmail).sendKeys(emailString);;
	}
	public void clickContinue() {
		driver.findElement(continueBtn).click();
	}
	public void clickXbox() {
		driver.findElement(xboxItem).click();
	}
	
}
