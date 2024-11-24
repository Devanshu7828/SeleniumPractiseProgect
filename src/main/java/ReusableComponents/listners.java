package ReusableComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportsListneres;

public class listners   implements ITestListener {
	WebDriver driver;
	ExtentTest test;
	ExtentReports extent = ExtentReportsListneres.getReportObject();
	// ThreadLocal we use to avoid method duplicasiy

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TestExecution started");
		extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSucess(ITestResult result) {
		test.log(Status.PASS, "Test Passed!");
		extent.flush();
	}

	public void onTestFailure(ITestResult result) {
//		// Give life to driver from @BeforeMethod driver we are running in BaseTest
//		// class
//
//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		extentTest.get().fail(result.getThrowable());
//		test.log(Status.FAIL, "Test Failed ohohohoho");
//		// Screenshot attach to report
//		String filePath = null;
//		try {
////			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onFinish(ITestResult result) {
		extent.flush();

	}

}
