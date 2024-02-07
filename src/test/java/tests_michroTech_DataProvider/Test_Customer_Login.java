package tests_michroTech_DataProvider;

import org.testng.annotations.Test;

import base.Base;

public class Test_Customer_Login extends Base {
	@Test (priority = 3)
	//Login as Customer 
	public static void test_Customer_Login() throws InterruptedException {
		p("MMM");
		navigate("https://it.microtechlimited.com");
		System.out.println( page.title() );
		Thread.sleep(2000);

		click("//a[@href='elogin.php']"); 
		click("//a[@href='clogin.php']");
		Thread.sleep(1000);
		fill("//input[@name='mailuid']", "david@gmail.com");
		Thread.sleep(1000);
		fill("//input[@name='pwd']", "1234");
		Thread.sleep(1000);
		click("//input[@name='login-submit']");
		
		String welcomeMessage = innerText("//h2[1]");	
		System.out.println(welcomeMessage);
		
		String welcomeMessage1 =innerText("//h2[2]");		
		System.out.println(welcomeMessage1 );
	}

}
