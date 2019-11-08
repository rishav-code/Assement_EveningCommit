package com.atmecs.validation;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.constant.FilePath;
import com.atmecs.helper.CommonUtlity;
import com.atmecs.reports.LogReport;
import com.atmecs.util.ReadProp;

public class Validation {
	WebDriver driver;
	Properties loc;
	CommonUtlity WebUtility;
	LogReport log;

	public Validation(WebDriver driver) {
		this.driver = driver;
		loc = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
		WebUtility = new CommonUtlity(driver);

	}

	public void homePageValidation(String expectedTitle) {
		log = new LogReport();

		String webPageTitle = WebUtility.getElement(loc.getProperty("loc.homepagetitle.text")).getText();
		assertEquals(webPageTitle, expectedTitle, "Assertion for landing on webpage failed");
		log.info("Assertion for home page landing passed");
	}

	public void productAvailableValidation(String iPhoneAvaibality) {
//		boolean  addtocart=WebUtility.isDisplayed(loc.getProperty("loc.addtocart.visible"));
//		Assert.assertEquals(addtocart, true,"product Not available" );
//		log.info("product available and added to cart");
		String productQuantity = WebUtility.getElement(loc.getProperty("loc.clickonaddcart.click")).getText();
		assertEquals(productQuantity, iPhoneAvaibality, "product Not available");
		log.info("product available and added to cart");
	}

	public void priceInDollarValidation(String Totalprice) {
		WebUtility.clickElement(loc.getProperty("loc.clickonviewcart.click"));
		String productPrice = WebUtility.getElement(loc.getProperty("loc.getprice.text")).getText();

		if (productPrice.startsWith("$")) {
			log.info("The price is in $");

			Assert.assertEquals(productPrice, Totalprice, "Assertion failed for total amount");
			log.info("Assertion passed for total amount");

		}

	}

	public void iPhoneproductDescription(String iPhoneDesscriptionText) {
		WebUtility.clickElement(loc.getProperty("loc.clickoniphoneimage.cick"));
		String iphonedescription = WebUtility.getElement(loc.getProperty("loc.iphonedescription.text")).getText();

		Assert.assertTrue(iphonedescription.contains(iPhoneDesscriptionText),
				"Assertion for iPhone product description failed ");
		log.info("Assertion for product description passed");
	}

	public void macBookairProductDescription(String macBookDescriptionText) {
		WebUtility.clickElement(loc.getProperty("loc.maccbookairimage.click"));
		String macBookairdescription = WebUtility.getElement(loc.getProperty("loc.macbookdescription.click")).getText();

		Assert.assertTrue(macBookairdescription.contains(macBookDescriptionText),
				"Assertion for macBook air product description failed ");
		log.info("Assertion for product description passed");

	}

	public void productAdded(String expectediphonecount, String expectedMacCount) {
		String countOfIphone = WebUtility.getElement(loc.getProperty("loc.iphonedescription.text")).getText();
		assertEquals(countOfIphone, expectediphonecount, "product Not added");
		log.info("product  iPhone added to cart");
		String countOfmac = WebUtility.getElement(loc.getProperty("loc.iphonedescription.text")).getText();
		assertEquals(countOfmac, expectedMacCount, "product Not added");
		log.info("product mac  added to cart");

	}

	public void totalprice(String expecteammount) {
		String totalamount = WebUtility.getElement(loc.getProperty("loc.gettotal.amount")).getText();
		assertEquals(totalamount, "$" + expecteammount, "product Not added");

	}

}
