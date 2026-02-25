package com.qa.pages;

import com.microsoft.playwright.Page;

public class GooglePage extends BasePage {

    public GooglePage(Page page) {
        super(page);
    }

    public void open(String url) {
        action.navigate(url);
    }

    public String title() {
        return action.getTitle();
    }
}
