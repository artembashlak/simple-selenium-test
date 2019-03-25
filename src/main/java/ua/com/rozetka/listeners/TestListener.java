package ua.com.rozetka.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static ua.com.rozetka.core.BaseTest.getDriver;

/**
 * Test listener. We are using it in testng.xml for methods, tests logging.
 */

public class TestListener implements ITestListener {
    private final Logger log = LoggerFactory.getLogger(TestListener.class);
    @Override
    public void onTestStart(final ITestResult result) {
        log.info(getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        log.info(getTestMethodName(result) + " success");
        takeScreenShot();
    }

    @Override
    public void onTestFailure(final ITestResult result) {
        log.info(getTestMethodName(result) + " failure");
        takeScreenShot();
    }

    @Override
    public void onTestSkipped(final ITestResult result) {
        log.info("test method " + getTestMethodName(result) + " skipped");
        takeScreenShot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
        log.info("test failed but within success % " + getTestMethodName(result));
    }

    @Override
    public void onStart(final ITestContext context) {
        log.info("on start of test " + context.getName());
    }

    @Override
    public void onFinish(final ITestContext context) {
        log.info("on finish of test " + context.getName());
    }

    private static String getTestMethodName(final ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }


    @Attachment(value = "Screenshot {name}", type = "image/png")
    private byte[] takeScreenShot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
