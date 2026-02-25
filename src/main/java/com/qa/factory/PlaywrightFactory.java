package com.qa.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();

    public Page initBrowser(String browserName, boolean headless) {
        tlPlaywright.set(Playwright.create());

        BrowserType browserType;
        if ("firefox".equalsIgnoreCase(browserName)) {
            browserType = tlPlaywright.get().firefox();
        } else if ("webkit".equalsIgnoreCase(browserName)) {
            browserType = tlPlaywright.get().webkit();
        } else {
            browserType = tlPlaywright.get().chromium(); // default
        }

        tlBrowser.set(browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless)));

        tlContext.set(tlBrowser.get().newContext(new Browser.NewContextOptions()
                .setViewportSize(1366, 768)));

        tlPage.set(tlContext.get().newPage());
        return tlPage.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public void closeAll() {
        // close in reverse order
        try {
            if (tlContext.get() != null) tlContext.get().close();
        } catch (Exception ignored) {}

        try {
            if (tlBrowser.get() != null) tlBrowser.get().close();
        } catch (Exception ignored) {}

        try {
            if (tlPlaywright.get() != null) tlPlaywright.get().close();
        } catch (Exception ignored) {}

        tlPage.remove();
        tlContext.remove();
        tlBrowser.remove();
        tlPlaywright.remove();
    }
}

