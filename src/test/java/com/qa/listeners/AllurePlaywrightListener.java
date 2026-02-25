//package com.qa.listeners;
//
//import com.microsoft.playwright.Page;
//import com.qa.factory.PlaywrightFactory;
//import io.qameta.allure.Allure;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.ByteArrayInputStream;
//import java.nio.charset.StandardCharsets;
//
//public class AllurePlaywrightListener implements ITestListener {
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        try {
//            Page page = PlaywrightFactory.getPage();
//            if (page == null) return;
//
//            // URL attachment (handy for debugging)
//            Allure.addAttachment("URL", new ByteArrayInputStream(
//                    page.url().getBytes(StandardCharsets.UTF_8)
//            ));
//
//            // Screenshot attachment
//            byte[] png = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
//            Allure.addAttachment("Screenshot (failure)", "image/png",
//                    new ByteArrayInputStream(png), ".png");
//
//        } catch (Exception ignored) {
//        }
//    }
//}
