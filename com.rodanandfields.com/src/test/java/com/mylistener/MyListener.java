package com.mylistener;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rf.base.test.Driver;

public class MyListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult arg0) {

		File scrFile = ((TakesScreenshot) Driver.driver)
				.getScreenshotAs(OutputType.FILE);
		String sFilename = null;
		sFilename = "Screenshot-"+".png";
		String FullSnapShotFilePath = System.getProperty("user.dir")
				+ "\\output\\ScreenShots\\" + sFilename;
		try {
			FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}





}
