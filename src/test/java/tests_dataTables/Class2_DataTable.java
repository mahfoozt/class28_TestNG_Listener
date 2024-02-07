package tests_dataTables;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import base.Base;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Class2_DataTable extends Base{

	//public static void main(String[] args) throws InterruptedException {
	@Test 
	public static void class2_DataTable() throws InterruptedException {
		//page.navigate("https://datatables.net");
		page.navigate("https://datatables.net/examples/advanced_init/dt_events.html");
		//Get page title
		System.out.println(page.title());
		
		Thread.sleep(2000);
		for (int i = 0; i < 1; i++) {
			//page.press("//*[@id=\"input__text2\"]", "ArrowUp");
			page.press("//select[@name='example_length']", "ArrowDown");
		}
		
		Thread.sleep(1000);
		//page.locator("//td[text()='Ashton Cox']").click();
		//page.locator("//input[@type='search']").fill("Bradley Greer");
		

		// Web Table Handling
		// Total Row count
		System.out.println("Total Row "+page.locator("#example>tbody>tr").count());
		
		// First-child column count
		System.out.println("First Child Column "+page.locator("tr:first-child").locator("td").count());
		
		// Total column count
		System.out.println("Column count of Heading "+ page.locator(".dataTable>thead>tr>th").count());
		System.out.println("Total Column "+page.locator("tr:nth-child(2)").locator("td").count());
		
		//Total Cell count
		System.out.println("Total Cell  "+page.locator("td").count());
		//find text in 10th Row and 2 col
		System.out.println( page.locator("//tr[10]/td[2]").innerText() );
		//find text in 3th Row and 2 col
		System.out.println( page.locator("//tr[3]/td[2]").innerText() );
		
		// Verify column Text
		//System.out.println("cell text:-- "+page.locator("tr:first-child").locator("td:nth-child(8)").innerText());

		assertThat(page.locator("tr:nth-child(10)").locator("td:nth-child(2)")).hasText("Senior Javascript Developer");
		
		// Total table Text print(used lambda)
		//page.locator("td").allInnerTexts().forEach(text -> System.out.println(text));		
		//Print Table Header
		System.out.println("----------------------Table Caption-----------------------------------------");
		//System.out.print(page.locator("#th").innerText());
		//Total Table Header print
		page.locator("#example>thead").allInnerTexts().forEach( text  -> System.out.print("\t"+text ));
		 
		//Total Table text print
		page.locator("#example>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		//Total Table Footer print
		page.locator(".dataTable>tfoot").allInnerTexts().forEach(text -> System.out.print("\t" +text));
		
		//close the browser
		//Close_All();
		
		// Verify Pre-formatted text //h2[text()='Welcome Test ']//#text__code > div > h2
//		String welcomeMsg = page.textContent("//h2[text()='Welcome Test ']");
//		if (welcomeMsg.contains("Welcome Test "))
//			System.out.println("Test2 is Pass");
//		else
//			System.out.println("Test2 is Fail");

	}

}
