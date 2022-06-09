package com.irinatest.test.config.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;

@Slf4j
public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test class started: " + result.getTestClass().getName());
        log.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test SUCCESS: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();

//        Allure.getLifecycle().addAttachment("screenshot", "image/png", "png",
//                ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));

//        SelenideLogger.addListener(
//                "AllureSelenide",
//                new AllureSelenide().screenshots(true).savePageSource(false)
//        );

        log.info("Test FAILED: " + result.getName());
        if (result.getThrowable()!= null) {
            result.getThrowable().printStackTrace();
        }
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

//    @AfterMethod
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
////            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
////                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
//        }
//    }
}