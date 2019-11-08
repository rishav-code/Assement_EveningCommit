package com.atmecs.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.constant.Findloc;
import com.atmecs.constant.TimeOut;
import com.atmecs.helper.CommonUtlity;
import com.atmecs.reports.LogReport;

import net.sf.json.util.WebUtils;

public class MenuTravel{
	WebDriver driver;
	CommonUtlity WebUtlity;
	Actions action;
	
	 
	Findloc loc;
	LogReport log;
	int index=1;

	public MenuTravel(WebDriver driver) {
		this.driver = driver;
		WebUtlity = new CommonUtlity(driver);
		loc = new Findloc();
	}
	
public void menu() {
	
	
	WebUtlity.clickElement(loc.getlocator("loc.menucommon.php").replace("xxx", index + ""));
	
	
	
	index++;
	
	
	
	
}

public void clickOnMerchindiseMen(String mensMerchandiseData) {
	log=new LogReport();
	System.out.println(mensMerchandiseData);
	
		 action = new Actions(driver);
		WebElement wb = WebUtlity.getElement(loc.getlocator("loc.merchindisemo.click"));
		Action mouseover = action.moveToElement(wb).build();
		mouseover.perform();
		WebUtlity.clickElement(loc.getlocator("loc.men.click"));
		String menMerchandiseText=WebUtlity.getElement(loc.getlocator("loc.getmenspagetitle.text")).getText();
		System.out.println(menMerchandiseText);
        assertEquals(menMerchandiseText,mensMerchandiseData,"Assertion is failed");
        System.out.println("assertion passed");
        log.info("Assertion for mensmarchandise done");

	}
public void selectShirt(String name) {
	WebUtlity.clickElement(loc.getlocator("loc.mensshirtbyenow.select"));
	
	WebUtlity.clickElement(loc.getlocator("loc.clickonred.select"));
	WebUtlity.clickElement(loc.getlocator("loc.select.red"));
	WebUtlity.clickElement(loc.getlocator("loc.personilizename.click"));
	WebUtlity.clickAndSendText(loc.getlocator("loc.personilizename.click"), TimeOut.TIMEOUT_INSECONDS, name);
	WebUtlity.clickElement(loc.getlocator("loc.byenowpopup.click"));
}
public void validateCart(String expectedShirtname,String expectedShirtSize,String expectedNameInCart,String expectedShirtColour) {
	action = new Actions(driver);
	WebUtlity.clickElement(loc.getlocator("loc.clickoncart.click"));
	String shirtName=WebUtlity.getElement(loc.getlocator("loc.cartitemname.text")).getText();
	 assertEquals(shirtName,expectedShirtname,"Assertion is failed for product name");
     log.info("assertion passed product name");
     String shirtSize=WebUtlity.getElement(loc.getlocator("loc.shirtsizevalidate.text")).getText();
	 assertEquals(shirtSize,expectedShirtSize,"Assertion is failed for shirt size");
	 log.info("Assertion passed for shirt size");
	 String nameInCart=WebUtlity.getElement(loc.getlocator("loc.personalizednamecart.text")).getText();
	 assertEquals(nameInCart,expectedNameInCart,"Assertion is failed for nameInCart");
	 log.info("Assertion passed for nameInCart");
	 String shirtColour=WebUtlity.getElement(loc.getlocator("loc.personalizednamecart.text")).getText();
	 assertEquals(shirtColour,expectedShirtColour,"Assertion is failed for shirtColour");
	 log.info("Assertion passed for shirtColour");

}

public void increaseQuantity(String quantity,String expectedtotalupdatedprice) {
	WebUtlity.clickElement(loc.getlocator("loc.increaseQuantity.button"));
	WebUtlity.clickAndSendText(loc.getlocator("loc.increaseQuantity.button"), TimeOut.TIMEOUT_INSECONDS, quantity);
	WebUtlity.clickElement(loc.getlocator("loc.clickonupdate.click"));
	String totalPrice= WebUtlity.getElement(loc.getlocator("loc.totalprice.validate")).getText();
	assertEquals(totalPrice,"$" +expectedtotalupdatedprice,"Assertion is failed for totalupdatedprice");
	log.info("Assertion passed for updated price");
	
}
public void validatePrice(String pricebexpected,String totalbexpected){
	String price=WebUtlity.getElement(loc.getlocator("loc.price.cart")).getText();
	assertEquals(price,"$" +pricebexpected,"Assertion is failed for before totalupdatedprice");
	log.info("Assertion passed for before updated price");
	String total=WebUtlity.getElement(loc.getlocator("loc.total.cart")).getText();
	assertEquals(total,"$" +totalbexpected,"Assertion is failed for before totalupdatedprice");
	log.info("Assertion passed for before updated price");
	
}
}
