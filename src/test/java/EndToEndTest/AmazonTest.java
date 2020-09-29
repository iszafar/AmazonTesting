package EndToEndTest;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import library.AmazonPage;
import utilities.Base;

public class AmazonTest extends Base {
	SoftAssert softAssert = new SoftAssert();
	String copyRightText = "© 1996-2020, Amazon.com, Inc. or its affiliates";
	String item = "SAMSUNG 75-inch Class QLED Q90T Series - 4K UHD Direct Full Array 16X Quantum HDR 16X Smart TV with Alexa Built-in (QN75Q90TAFXZA, 2020 Model)";
	@Test
	public void amazonTesting() {
		driver.get(prop.getProperty("url"));
		AmazonPage amazonTest = new AmazonPage(driver);

		amazonTest.inputSearchBox("qled tv");
		amazonTest.clickSearchBtn();
		
		amazonTest.clickItem();
		String itemName = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
		softAssert.assertEquals(itemName, item, "checking dinamic item name");
		amazonTest.addToCart();
		List<WebElement> protectionPopup = driver.findElements(By.xpath("//button[@id='siAddCoverage-announce']"));
		if (protectionPopup.size() > 0) {
			amazonTest.addNoProtectionPlan();
		}
		amazonTest.inputSearchBox("play station");
		amazonTest.clickSearchBtn();
		amazonTest.clickXbox();
		amazonTest.addToCart();
		List<WebElement> protectionPopup2 = driver.findElements(By.xpath("//button[@id='siAddCoverage-announce']"));
		if (protectionPopup2.size() > 0) {
			amazonTest.addNoProtectionPlan();
		}
		
		amazonTest.checkOut();
		
		amazonTest.inputEmail(prop.getProperty("email"));
		amazonTest.clickContinue();
		List<WebElement> logo = driver.findElements(By.xpath("//i[@class='a-icon a-icon-logo']"));
		boolean isLogo = logo.size() < 0;
		Assert.assertFalse(isLogo);
		String copyright = driver.findElement(By.xpath("//span[@class='a-size-mini a-color-secondary']")).getText();
		Assert.assertEquals(copyright, copyRightText, "compare copyrighttext");
		System.out.println(copyright);
	}

}
