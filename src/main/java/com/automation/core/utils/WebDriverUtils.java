package com.automation.core.utils;

import com.automation.core.constants.FrameworkConstants;
import com.automation.core.enums.LogType;
import com.automation.core.enums.WaitStrategy;
import com.automation.core.reports.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public final class WebDriverUtils {

    private WebDriver driver;
    private Actions actions;

    public WebDriverUtils(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
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

    public List<WebElement> getElements(By locator, boolean shouldExist, Integer... timeOut){
        try{
            if (shouldExist){
                return getWebDriverWait(timeOut.length>0?timeOut[0]:FrameworkConstants.getExplicitwait()).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            }else{
                return this.driver.findElements(locator);
            }
        }catch (Exception e){
            FrameworkLogger.log(LogType.INFO, locator.toString()+" not found");
            return new ArrayList<WebElement>();
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

    public void switchInIframe(String nameOrId){
        FrameworkLogger.log(LogType.INFO,"<label style=\"color:#8B8000; font-size: 15px;\">Switching to iFrame with name or id '"+nameOrId+"'</label>");
        driver.switchTo().frame(nameOrId);
    }

    public void switchToDefaultContent(){
        FrameworkLogger.log(LogType.INFO,"<label style=\"color:#8B8000; font-size: 15px;\">Switching to Default content</label>");
        driver.switchTo().defaultContent();
    }

    public void waitUntilLocatorAppear(By locator, int timeOutInSecond){
        getWebDriverWait(timeOutInSecond).until(driver->{
            try{
                int elementCount = getElements(locator,true).size();
                return elementCount > 0;
            }catch (Exception e){
                return false;
            }
        });
    }

    public void waitUntilLocatorDisAppear(By locator, int timeOutInSecond){
        getWebDriverWait(timeOutInSecond).until(driver->{
            try{
                int elementCount = getElements(locator,false,timeOutInSecond).size();
                return elementCount == 0;
            }catch (Exception e){
                return true;
            }
        });
    }

    public void actionClickElement(By locator, WaitStrategy waitStrategy){
        FrameworkLogger.log(LogType.INFO,"<label style=\"color:#8B8000; font-size: 15px;\">Actions-Click on element '"+locator.toString()+"'</label>");
        WebElement element = getElement.apply(waitStrategy,locator);
        actions.click(element).build().perform();
    }

    public void waitUntilLocatorAppearAndDisAppear(By locator, int timeOutInSecond){
        waitUntilLocatorAppear(locator,timeOutInSecond);
        waitUntilLocatorDisAppear(locator,timeOutInSecond);
    }






}
