package com.automation.core.utils;

import com.automation.core.constants.FrameworkConstants;
import com.automation.core.enums.LogType;
import com.automation.core.enums.WaitStrategy;
import com.automation.core.reports.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.BiFunction;

public final class WebDriverUtils {

    private WebDriver driver;

    public WebDriverUtils(WebDriver driver){
        this.driver = driver;
    }

    private WebDriverWait getWebDriverWait(int timeOutInSeconds){
        return new WebDriverWait(this.driver, Duration.ofSeconds(timeOutInSeconds));
    }

    private WebElement explicitlyWaitForElementPresence(By locator, int timeOutInSeconds){
        return getWebDriverWait(timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private WebElement explicitlyWaitForElementVisibile(By locator, int timeOutInSeconds){
        return getWebDriverWait(timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement explicitlyWaitForElementClickable(By locator, int timeOutInSeconds){
        return getWebDriverWait(timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public BiFunction<WaitStrategy, By, WebElement> getElement = ((waitStrategy, by) -> {
        WebElement element = null;
        if(waitStrategy == WaitStrategy.CLICKABLE){
            element = explicitlyWaitForElementClickable(by, FrameworkConstants.getExplicitwait());
        } else if (waitStrategy==WaitStrategy.VISIBLE) {
            element = explicitlyWaitForElementVisibile(by,FrameworkConstants.getExplicitwait());
        } else if (waitStrategy==WaitStrategy.PRESENCE) {
            element = explicitlyWaitForElementPresence(by,FrameworkConstants.getExplicitwait());
        } else {
            element = this.driver.findElement(by);
        }
        return element;
    });

    public List<WebElement> getElements(By locator, boolean shouldExist){
        if (shouldExist){
           return getWebDriverWait(FrameworkConstants.getExplicitwait()).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }else{
            return this.driver.findElements(locator);
        }
    }

    public void click(By locator, WaitStrategy waitStrategy){
        FrameworkLogger.log(LogType.INFO,"<label style=\"color:#8B8000; font-size: 15px;\">Click on element '"+locator.toString()+"'</label>");
        getElement.apply(waitStrategy,locator).click();
    }

    public void sendKey(By locator, String value, WaitStrategy waitStrategy){
        FrameworkLogger.log(LogType.INFO,"<label style=\"color:#8B8000; font-size: 15px;\">Set value '"+value+"' to field "+locator.toString()+"</label>");
        getElement.apply(waitStrategy,locator).sendKeys(value);
    }

    public void navigateTo(String url){
        FrameworkLogger.log(LogType.INFO,"<label style=\"color:#8B8000; font-size: 15px;\">Navigate to url '"+url+"'</label>");
        this.driver.navigate().to(url);
    }






}
