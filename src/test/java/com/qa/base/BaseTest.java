package com.qa.base;

import com.microsoft.playwright.Page;
import com.qa.config.ConfigLoader;
import com.qa.factory.PlaywrightFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    protected PlaywrightFactory pf;
    protected Page page;
    protected Properties prop;

    @BeforeMethod
    public void setUp() {
        prop = new ConfigLoader().initProperties();

        String browser = prop.getProperty("browser", "chromium");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "true"));

        pf = new PlaywrightFactory();
        page = pf.initBrowser(browser, headless);

        String baseUrl = prop.getProperty("baseUrl");
        if (baseUrl != null && !baseUrl.trim().isEmpty()) {
            page.navigate(baseUrl);
        }
    }

    @AfterMethod
    public void tearDown() {
        pf.closeAll();
    }
}
