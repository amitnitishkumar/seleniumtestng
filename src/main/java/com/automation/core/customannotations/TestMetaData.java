package com.automation.core.customannotations;
import com.automation.core.enums.CategoryType;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface TestMetaData {
    public String[] author();
    public CategoryType[] category();
}
