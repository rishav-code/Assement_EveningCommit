package com.atmecs.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.constant.Findloc;
import com.atmecs.constant.TimeOut;
import com.atmecs.helper.CommonUtlity;

public class SearchProduct{
	WebDriver driver;
	CommonUtlity WebUtlity;
	 
	Findloc loc;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
		WebUtlity = new CommonUtlity(driver);
		loc = new Findloc();
	}
	public void Search(String iPhone) {
		WebUtlity.clickElement(loc.getlocator("loc.homepagetitle.text"));
		WebUtlity.clickElement(loc.getlocator("loc.search.text"));
		WebUtlity.clickAndSendText(loc.getlocator("loc.search.text"), TimeOut.TIMEOUT_INSECONDS, iPhone);
		//WebUtlity.scrollDownPage(300);
		//WebUtlity.clickElement(loc.getlocator("loc.clickonaddcart.click"));
		WebUtlity.clickElement(loc.getlocator("loc.iphoneaddtocart2.click"));
		WebUtlity.clickElement(loc.getlocator("loc.iphoneaddtocart2.click"));
	}
	public void SearchMacBookPro(String macBookAir) {

		WebUtlity.clickElement(loc.getlocator("loc.homepagetitle.text"));
		WebUtlity.clickElement(loc.getlocator("loc.search.text"));
		WebUtlity.clickAndSendText(loc.getlocator("loc.search.text"), TimeOut.TIMEOUT_INSECONDS,  macBookAir);
		WebUtlity.clickElement(loc.getlocator("loc.SearchButtom.click"));
		WebUtlity.clickElement(loc.getlocator("loc.clickonaddcart.click"));
		WebUtlity.clickElement(loc.getlocator("loc.clickonaddcart.click"));
		WebUtlity.clickElement(loc.getlocator("loc.clickonaddcart.click"));
		
	}

}
