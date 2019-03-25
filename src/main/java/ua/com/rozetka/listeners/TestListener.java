package ua.com.rozetka.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static ua.com.rozetka.core.BaseTest.getDriver;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " success");
        takeScreenShot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " failure");
        takeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test method " + getTestMethodName(result) + " skipped");
        takeScreenShot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("test failed but within success % " + getTestMethodName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("on start of test " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("on finish of test " + context.getName());
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }


    @Attachment(value = "Screenshot {name}", type = "image/png")
    private byte[] takeScreenShot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
