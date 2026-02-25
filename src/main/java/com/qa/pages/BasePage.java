package com.qa.pages;

import com.microsoft.playwright.Page;
import com.qa.utils.PWActions;

public class BasePage {

    protected Page page;
    protected PWActions action;

    public BasePage(Page page) {
        this.page = page;
        this.action = new PWActions(page);
    }
}
