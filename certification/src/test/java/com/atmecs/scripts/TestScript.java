package com.atmecs.scripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.constant.FilePath;
import com.atmecs.constant.TimeOut;
import com.atmecs.dataprovider.Dataprovide;
import com.atmecs.pages.SearchProduct;
import com.atmecs.testbase.TestBase;
import com.atmecs.util.ReadProp;
import com.atmecs.validation.Validation;

public class TestScript extends TestBase {
	Properties baseClass;
	//PhpFlow flow;
	ReadProp property ;
	SearchProduct Search;
	String url;
	Validation validate;
	@BeforeClass
	public void urlqw() {
		baseClass=ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url=baseClass.getProperty("url1");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.TIMEOUT_INSECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_TIMEOUT_INSECONDS, TimeUnit.SECONDS);

}
	@Test(priority = 1, dataProvider = "SearchData", dataProviderClass = Dataprovide.class)
	public void searchTest(String iPhone ,String macBookAir,String homePagetitle,String iPhoneAvablity,String Totalprice,String iPhoneDesscriptionText ,String macBookDescriptionText,String expectediphonecount, String expectedMacCount,String expecteammount) {
		Search= new SearchProduct(driver);
		validate= new Validation(driver);
		validate.homePageValidation(homePagetitle);
		Search.Search(iPhone);
		validate.iPhoneproductDescription(iPhoneDesscriptionText);
		validate.priceInDollarValidation(Totalprice);
		validate.macBookairProductDescription(macBookDescriptionText);
		validate.productAvailableValidation(iPhoneAvablity);
		
		Search.SearchMacBookPro(macBookAir);
		validate.macBookairProductDescription(macBookDescriptionText);
		validate.productAdded(expectediphonecount, expectedMacCount);
		validate.totalprice(expecteammount);
		
		
	}
}