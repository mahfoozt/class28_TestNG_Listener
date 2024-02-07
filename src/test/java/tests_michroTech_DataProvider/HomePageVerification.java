package tests_michroTech_DataProvider;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import base.Base;

public class HomePageVerification extends Base {
	public static SoftAssert softAssert = new SoftAssert();
	@Test(priority = 0)
	public void homePageVerify1() {		//Soft Assertion for pass the Test
		navigate("https://it.microtechlimited.com");
		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");
		assertThat(page).hasTitle("MicroTech NA");
		String name1="Rosy";
		String name2="Rosy";
		softAssert.assertEquals(name1,name2);
		//softAssert.assertAll("------homePageVerify1 Test is Pass--will not print--------------");
		softAssert.assertAll();
	}
	@Test(priority = 1)
	public void homePageVerify2() {		//Soft Assertion for Fail the Test
		navigate("https://it.microtechlimited.com");
		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");
		assertThat(page).hasTitle("MicroTech NA");
		String name1="Rosy";
		String name2="Ayaat";
		softAssert.assertEquals(name1,name2);
		softAssert.assertAll("------homePageVerify2 Test is Fail will print---------------");
	}
	@Test(priority = 2)
	public void homePageVerify3() {		// Fail the Test
		navigate("https://it.microtechlimited.com");
		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");
		assertThat(page).hasTitle("MicroTech NA");
		p("Home Page2 Verification Done");
		// Fail the Test
		Assert.fail("-------------------Home Page3 Test Fail-----------------------");
	}
	@Test(priority = 3)
	public void homePageVerify4() {		// Skip the Test
		navigate("https://it.microtechlimited.com");
		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");
		assertThat(page).hasTitle("MicroTech NA");
		p("Home Page3 Verification Done");
		// Skip the Test
		if (true)
			throw new SkipException("--------Home Page4 Test Skip-------------");
	}
	@Test(priority = 4)
	public void homePageVerify5() {		//Soft Assertion
		navigate("https://it.microtechlimited.com");
		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");
		assertThat(page).hasTitle("MicroTech NA");
		softAssert.assertTrue(false, "---------This stmt will be executed bcoz of Soft Assertion----------");
		p("Home Page4 Verification Done");
		softAssert.assertAll("------------homePageVerify5 Soft Assertion Done-------------");
	}
	@Test(priority = 5)
	public void homePageVerify6() {		//Hard Assertion 
		navigate("https://it.microtechlimited.com");
		assertion("//h1[text()='Welcome to MicroTech NA.']", "Welcome to MicroTech NA.");
		assertThat(page).hasTitle("MicroTech NA");
		System.out.println("------------------------Hard Assertion code is started--------------");
		Assert.assertTrue(false,"-------No further stmt will not be executed bcoz of Hard Assertion----");
		//Assert.assertTrue(false);
		System.out.println("----Test will not executed bcoz of Hard Assertion------");	
	}
	
}
