package com.automation.core.utils;

import com.automation.core.enums.DynamicLocatorType;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommonUtils {

    private CommonUtils(){};

    public static void deplay(long timeInSeconds){
        Uninterruptibles.sleepUninterruptibly(timeInSeconds, TimeUnit.SECONDS);
    }

    public static String cleanInput(String input) {
        // Remove escape characters and numbers
        String cleanText = input.replaceAll("[^a-zA-Z\\s]", "");

        // Keep only English words
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher matcher = pattern.matcher(cleanText);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }
        return result.toString().trim();
    }

    public static By modifyDynamicLocator(DynamicLocatorType locatorType, By locator, String... replaceWith){
        String locatorStr = locator.toString();
        locatorStr = String.format(locatorStr,replaceWith);
        if(locatorType==DynamicLocatorType.XPATH)
            return By.xpath(locatorStr.substring(10));
        else
            return By.cssSelector(locatorStr.substring(16));
    }
}
