package base;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.assertions.LocatorAssertions;

import utility.SkyITSchool_Listener;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
@Listeners (SkyITSchool_Listener.class)
//@Parameters({"url","uname","pwd"})
public class Base {
		public static Page page;	//declares a Static variable named page of type Page
		public static Browser browser;	//declares a Static variable named browser of type Browser
		public static Playwright playwright; // Declares a Static variable named playwright of type Playwright.
		@BeforeSuite
		public void startUp() {
			System.out.println("---------------@BeforeSuite--------------------------------");
			String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
			// Declares a variable named playwright of type Playwright.
			//Playwright playwright; 
			// Initializes the playwright variable by creating a new instance of the Playwright class.
			playwright = Playwright.create();
			// Creates an ArrayList named arguments to store command-line arguments for browser launch.
			ArrayList<String> arguments = new ArrayList<>();
			// Adds the argument "--start-maximized" to the list of arguments, 
			//which indicates that the browser should start in a maximized window.
			arguments.add("--start-maximized");
			//Declares a variable named launchOptions of type LaunchOptions.
			LaunchOptions launchOptions;
			//initializes the launchOptions variable using the LaunchOptions class, 
			//configuring various options for browser launch.
			//Sets the browser to launch in non-headless mode (visible mode).
			//Sets the command-line arguments for the browser launch using the arguments ArrayList.
			// Sets the path to the Chrome executable using the provided chromePath.
			launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments).setExecutablePath(Paths.get(chromePath));

			//Browser browser;//declares a variable named browser of type Browser
			//This line launches a new instance of the Chromium browser. 
			
			browser = playwright.chromium().launch(launchOptions);

			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			
			page = context.newPage();
		}
			public static void fill(String locator, String value) {
				page.locator(locator).fill(value);
			}		
			public static void navigate(String url) {
				page.navigate(url);
			}			
			public static void click(String locator) {
				page.locator(locator).click();
			}
			public static String innerText(String locator) {
				String s = page.locator(locator).innerText();
				return s;
			}
			public static void assertion(String xpath, String text) {
				assertThat(page.locator(xpath)).hasText(text);
			}
			public static void p(String s) {
				System.out.println(s);
			}
			public static void Selection(String path, String value) {
				page.selectOption(path,value);
			}
//			private static LocatorAssertions asserThat(Locator first) {
//				
//				return null;
//			}
//			private static String assertion1(Locator locator) {
//				assertThat(locator);00
//				return null;
//			}
			public static int generateNumber() {
				return (int) (Math.random()*10000);
			}
			//Again take the Screen Shot
//			//Screen Shot
//			Thread.sleep(1000);
//			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/Create_order.png")));
//			Thread.sleep(1000);
			public static void generateScreenshot(String filename) {
				ScreenshotOptions ssOptions= new ScreenshotOptions();
				page.screenshot(ssOptions.setPath(Paths.get(filename)));						
			}
			private static APIResponse title() {		
				return null;
			}
			
			@AfterSuite 
			public void Close_All() {
				System.out.println("-------------------@AfterSuite--------------------- ");
				page.close();
				browser.close();
				playwright.close();	
			}
			
}
