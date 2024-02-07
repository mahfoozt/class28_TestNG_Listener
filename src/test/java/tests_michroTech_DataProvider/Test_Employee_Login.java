package tests_michroTech_DataProvider;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Base;

public class Test_Employee_Login extends Base{
	@Test (priority = 2)
	//Login as Employee 
	public static void test_Employee_Login() throws InterruptedException {
	
		//go to Micro tech home page
		navigate("https://it.microtechlimited.com");
		//print title	
		System.out.println( page.title() );
		Thread.sleep(2000);
		//click employee login
		click("//a[@href='elogin.php']");
		//enter user id
		fill("//input[@name='mailuid']", "testpilot@gmail.com");
		//enter password
		fill("//input[@name='pwd']","1234");
		//click login button
		click("//input[@name='login-submit']");
		//verification of employee login
		assertion("//h2[2]", "Welcome Test");
		String welcomeMessage = innerText("//h2[2]");	
		System.out.println(welcomeMessage);
		p("Employee Login Page Verification Done");
		assertion("//h2[1]", "Employee Id: 102");
		String employeeId = innerText("//h2[1]");
		System.out.println( employeeId );
		assertion("//h2[1]","Employee Id: 102");
		p("Employee Id Verification Done");
		if(true)
		throw new SkipException("-----Skipping this Test---");
		
		String actualTitle="Rosy";
		String expectedTitle="Rosy";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(true,"title matched");
		//Assert.fail("Failing the test as the condition is not match");
		String actualEmployeeId = page.locator("//h2[1]").innerText();
		//System.out.println(employeeId);
		String expectedEmployeeId ="Employee Id: 102";
		assertEquals(actualEmployeeId,expectedEmployeeId );//If we want to fail any test by intentionally we have to use line 24 or line 25(last 2 line)
		//Assert.assertTrue(true,"ExpectedId Don't match");
		Assert.fail("---Expected not Match-----");
		
		
		
		
	}

}
