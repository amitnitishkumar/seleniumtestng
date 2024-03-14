package com.automation.core.utils;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public final class CommonUtils {

    private CommonUtils(){};

    public static void deplay(long timeInSeconds){
        Uninterruptibles.sleepUninterruptibly(timeInSeconds, TimeUnit.SECONDS);
    }



}
