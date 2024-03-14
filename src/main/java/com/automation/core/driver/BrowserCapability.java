package com.automation.core.driver;

import com.automation.core.enums.ConfigProperties;
import com.automation.core.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.function.Supplier;

public final class BrowserCapability {

    private BrowserCapability(){};

    static Supplier<ChromeOptions> chromeOptionsSupplier = ()->{
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        if(Boolean.parseBoolean(PropertyUtils.get(ConfigProperties.HEADLESS)))
            options.addArguments("--headless");
        return options;
    };

    static Supplier<FirefoxOptions> fireFoxOptionsSupplier = ()->{
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        if(Boolean.parseBoolean(PropertyUtils.get(ConfigProperties.HEADLESS)))
            options.addArguments("--headless");
        return options;
    };
}
