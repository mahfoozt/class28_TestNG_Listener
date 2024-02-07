package tests_dataTables;

import base.Base;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

class HomePageVerification extends Base {

	// public static void main(String[] args) throws InterruptedException {
	@Test
	public static void homePageVerification() throws InterruptedException {
		// startUp();
		navigate("https://datatables.net");
		// Get page title
		System.out.println(page.title());
		// title page verification
		assertThat(page).hasTitle("DataTables | Table plug-in for jQuery");
		Thread.sleep(5000);
		// Manual button Verification
		assertion("(//a[text()='Manual'])[1]", "Manual");
		p("Home Page Verification Done");
		// close the browser
		// Close_All();

		// Thread.sleep(5000);
		// assertThat(page.getByText("Welcome")).isVisible();
		// A specific element is visible.
		// (page.getByText("Manual")).isVisible();
		// Thread.sleep(5000);
		// At least one item in the list is visible.
		// asserThat(page.getByTestId("hero-item").first()).isVisible();

//				p("Home Page Verification Done");
//				//close the browser
//				Close_All();
//				
	}

}
