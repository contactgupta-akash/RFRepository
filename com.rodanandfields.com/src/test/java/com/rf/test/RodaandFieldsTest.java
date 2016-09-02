package com.rf.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rf.base.test.Driver;
import com.rf.page.RFHomePage;

public class RodaandFieldsTest extends Driver {
	
  private RFHomePage rfhomepage;
  
  @Test
  public void rfFunctionalityTest() throws InterruptedException {
	  //Instantiate page class
	  rfhomepage = new RFHomePage(driver);
	  //Navigate to url
	  rfhomepage.navigateToRF();
	  //apply implicit wait
	  rfhomepage.applyImplicitWait();
	  //click All Products Link
	  rfhomepage.clickAllProducta();
	  //validate user is on quick-shop page
	  //Assert.assertTrue(driver.getCurrentUrl().contains("quickShop"),"user is not on quick-shop page!!" );
	  //select 'REDEFINE' & 'REVERSE' from DD
	  rfhomepage.selectRedefineAndReverse();
	  //select price filter
	  rfhomepage.selectPrice();
	  //validate the Redefine and Reverse labels in UI
	  Assert.assertTrue(rfhomepage.validateRedefineReverseLabelsWithCBPresent(), "Redefine and Reverse labels with CB are not present in UI");
	  //pick a product and verify its price is in the selected price-filter
	  Assert.assertTrue(rfhomepage.validateProductPrice(), "price is not in selected price bracket");
	  //close browser
	  rfhomepage.closeBrowser();
	  
  }
}
