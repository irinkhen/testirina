package com.irinatest.test.config.selenoid;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static org.openqa.selenium.Platform.LINUX;

public class SelenoidDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserName", "chrome");
        desiredCapabilities.setCapability("browserVersion", "101.0");
        desiredCapabilities.setPlatform(LINUX);
        desiredCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true
        ));
        try {
            return new RemoteWebDriver(
                    URI.create("http://127.0.1.1:4444/wd/hub").toURL(),
                    desiredCapabilities
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
