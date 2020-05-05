package com.inetbanking.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomListeners extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest testLog;
//	WebDriver driver;
	
	String timeStampString = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	  @Override
	  public void onStart(ITestContext testContext) {
		  String reportName = "test_report" + timeStampString + ".html";
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/" + reportName);
		  extentReports = new ExtentReports();
		  extentReports.attachReporter(htmlReporter);
		  
		  htmlReporter.config().setReportName("Automation Testing");
		  htmlReporter.config().setDocumentTitle("inetbanking testing");
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  extentReports.setSystemInfo("os", "catalina");
		  extentReports.setSystemInfo("hostname", "localhost");
		  extentReports.setSystemInfo("user", "swaran");
		  extentReports.setSystemInfo("environment", "QA");
	  }

	  @Override
	  public void onFinish(ITestContext testContext) {
		  extentReports.flush();
	  }

	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  testLog = extentReports.createTest("Test name: " + tr.getName());
		  testLog.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		  String screenshotPath = CaptureScreenShot.captureScreenShot(tr.getName(), timeStampString);
		  try {
			testLog.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is: " + e.getMessage());
		}
		  
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  testLog = extentReports.createTest("Test name: " + tr.getName());
		  testLog.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  String screenshotPath = CaptureScreenShot.captureScreenShot(tr.getName(), timeStampString);
		  try {
			testLog.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is: " + e.getMessage());
		}
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  testLog = extentReports.createTest("Test name: " + tr.getName());
		  testLog.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		  String screenshotPath = CaptureScreenShot.captureScreenShot(tr.getName(), timeStampString);
		  try {
			testLog.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is: " + e.getMessage());
		}
	  }

	  @Override
	  public void onTestFailedWithTimeout(ITestResult tr) {
	  }

	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
	  }
}
