package tests_michroTech_Parameter_DataProvider.copy;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.lang.reflect.Method;

import base.Base;

public class homePage_data_Provider2 extends Base {
	@Test(dataProvider = "passData")
	public void receiveData(String nameid, String password) {
		System.out.println("Received data id :- " +nameid );
		System.out.println("Received data password :- " +password );		
	}
	@DataProvider 		//(name = "alldata")
	public Object[][] passData() {
		Object[][] data = null;
			data = new Object[2][2];
			data[0][0] = "testpilot@gmail.com";
			data[0][1] = "1234";
		
			data[1][0] = "david@gmail.com";
			data[1][1] = "1234";
	
		return data;
	}
//		navigate("https://it.microtechlimited.com");
//		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");
//		assertThat(page).hasTitle("MicroTech NA");
//		String name1="Rosy";
//		String name2="Rosy";
//		softAssert.assertEquals(name1,name2);
//		//softAssert.assertAll("------homePageVerify1 Test is Pass--will not print--------------");
//		softAssert.assertAll();

}
