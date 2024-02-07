package utility;

import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.microsoft.playwright.Page;

import base.Base;

public class SkyITSchool_Listener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart-----------------------------------------------------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess-----------------------------------------------------");
		String filename1 = System.getProperty("user.dir") + "\\target\\pass_screenshot\\" + result.getName()
				+ generateNumber() + ".jpg";
		generateScreenshot(filename1);
	}
	// Again take the Screen Shot
	// Screen Shot
	// page.screenshot(new
	// Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/Create_order.png")));
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("-----------onTestFailure-------------------------------------------");
		String filename2=System.getProperty("user.dir")+"\\target\\fail_screenshot\\"+result.getName()+generateNumber()+".jpg";
		generateScreenshot(filename2);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped-----------------------------------------------------");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// System.out.println("onTestStart-----------------------------------------------------");
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout-----------------------------------------------------");
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart-----------------------------------------------------");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish-----------------------------------------------------");
	}
}
