package tests_michroTech_Parameter_DataProvider.copy;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import base.Base;

public class Test_Create_Order extends Base{
	//public static Page page;
	//Create Order page
	@Test (priority = 0)
	public static void test_Create_Order() throws InterruptedException {	
		navigate("https://it.microtechlimited.com");
		System.out.println( "Title page of  :-"+ page.title() );
		//assertion("x path","value");
		Thread.sleep(2000);
		click("//a[@href='elogin.php']");
		fill("//input[@name='mailuid']", "testpilot@gmail.com");	
		fill("//input[@name='pwd']","1234");		
		click("//input[@name='login-submit']");
		//verification of employee login
		assertion("//h2[2]", "Welcome Test");
		String welcomeMessage = innerText("//h2[2]");	
		System.out.println("Employee Login Landing message :-" + welcomeMessage);
		p("Employee Login Page Verification Done");
		Thread.sleep(1000);
		//Product order 
		click("//a[text()='Product Order']");
		Thread.sleep(1000);
		page.selectOption("//select[@name='prodId']", "Camera");
		Thread.sleep(1000);
		fill("//input[@name='ordDate']","12/20/2023");
		Thread.sleep(1000);
		click("//button[@type='submit']");	
		System.out.println("Order Done");		
		//Again take the Screen Shot
		//Screen Shot
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/Create_order.png")));
		Thread.sleep(1000);
		// Input File
		// Used X-path
		//File Upload
		//page.setInputFiles("//input[@id='input__file']", Paths.get("./src/test/resources/files/rosylogo.png"));
		

	}

}
