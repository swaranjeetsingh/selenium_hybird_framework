package com.inetbanking.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.inetbanking.test_cases.TestHelper;

public class CaptureScreenShot extends TestHelper {

	public static String captureScreenShot(String fileName, String timeStamp) {
		String srcFileString = null;
		try {
			TakesScreenshot srcScreenshot = (TakesScreenshot) driver;
			File srcFile = srcScreenshot.getScreenshotAs(OutputType.FILE);
			srcFileString = "/Users/dhaliwal_mac/Documents/Eclipse_Workspace/Selenium_Hybird_FW/screenshot/" + fileName + timeStamp + ".png";
			File destinationFolder = new File(srcFileString);
			FileUtils.copyFile(srcFile, destinationFolder);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return srcFileString ;
	}

}
