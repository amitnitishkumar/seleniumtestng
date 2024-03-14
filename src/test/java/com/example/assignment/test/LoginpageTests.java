package com.example.assignment.test;

import com.automation.core.customannotations.TestMetaData;
import com.automation.core.driver.DriverManager;
import com.automation.core.enums.CategoryType;
import com.automation.core.testbase.BaseTest;
import com.example.assignment.page.AmazonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Map;


public final class LoginpageTests extends BaseTest {
	
	private LoginpageTests(){}

	@Test(dataProvider = "serial")
	@TestMetaData(author = "Nitish",category = CategoryType.REGRESSION)
	public void loginLogoutTest(Map<String,String> testData) {
		AmazonPage.getInstance()
				.setsSearchProduct(testData.get("product"))
				.clickSearchBtn();
	}

}
