package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SanityTest extends BaseTest {



    @Parameters({"url"})
    @Test
    public void openGoogle(String url) {
        GooglePage gp = new GooglePage(page);
        gp.open(url);
        System.out.println("Title: " + gp.title());
        Assert.assertTrue(gp.title().toLowerCase().contains("yahoo"));
    }
}
