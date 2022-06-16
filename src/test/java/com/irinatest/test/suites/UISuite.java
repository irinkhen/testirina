package com.irinatest.test.suites;

import com.codeborne.selenide.Configuration;
import com.irinatest.test.config.selenoid.SelenoidDriverProvider;
import org.testng.annotations.BeforeSuite;

public abstract class UISuite extends BaseSuite{
    @BeforeSuite
    public void setUp() {
        Configuration.baseUrl = "https://user:senlatest@regoffice.senla.eu/";
        Configuration.browser = SelenoidDriverProvider.class.getCanonicalName();
        Configuration.timeout = 10000;
        Configuration.browserSize = "1600x1400";
    }
}
