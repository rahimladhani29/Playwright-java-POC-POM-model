package com.qa.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PWActions {

    private final Page page;

    public PWActions(Page page) {
        this.page = page;
    }

    public void click(Locator locator) {
        locator.click();
    }

    public void fill(Locator locator, String value) {
        locator.fill(value);
    }

    public String getText(Locator locator) {
        return locator.textContent();
    }

    public boolean isVisible(Locator locator) {
        return locator.isVisible();
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public String getTitle() {
        return page.title();
    }
}
