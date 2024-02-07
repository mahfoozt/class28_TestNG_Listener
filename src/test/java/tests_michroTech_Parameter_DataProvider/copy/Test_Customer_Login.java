package tests_michroTech_Parameter_DataProvider.copy;

import org.testng.annotations.Test;

import base.Base;

public class Test_Customer_Login extends Base {
	//Login as Customer
	@Test(dataProviderClass=homePage_data_Provider.class, dataProvider= "alldata") 
	public void test_Customer_Login(String nameid, String password,String url) throws InterruptedException {
		navigate("https://it.microtechlimited.com");
		System.out.println( page.title() );
		Thread.sleep(2000);
		click("//a[@href='elogin.php']"); 
		click("//a[@href='clogin.php']");
		Thread.sleep(1000);
		fill("//input[@name='mailuid']", nameid);
		Thread.sleep(1000);
		fill("//input[@name='pwd']", password);
		Thread.sleep(1000);
		click("//input[@name='login-submit']");
		
		String welcomeMessage = innerText("//h2[1]");	
		System.out.println(welcomeMessage);
		
		String welcomeMessage1 =innerText("//h2[2]");		
		System.out.println(welcomeMessage1 );
	}

}
