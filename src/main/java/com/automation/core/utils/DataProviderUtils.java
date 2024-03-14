package com.automation.core.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.testng.annotations.DataProvider;

import com.automation.core.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {}
	public static Object[] getData(Method m) {
		List<Map<String, String>> list =	new ArrayList<>();
		String testname = m.getName();

		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails("DATA");
			System.out.println(list);
		}
		List<Map<String, String>> dataFound = new ArrayList<>(list);

		Predicate<Map<String,String>> isTestNameNotMatching = map ->!map.get("testname").equalsIgnoreCase(testname);
		Predicate<Map<String,String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");

		dataFound.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
		Object[] testData = new Object[dataFound.size()];
		for(int i=0;i<dataFound.size();i++)
			testData[i] = dataFound.get(i);
		return testData;
		
	}
	@DataProvider(parallel=false)
	public static Object[] serial(Method m) {
		return getData(m);
	}

	@DataProvider(parallel=true)
	public static Object[] parallel(Method m) {
		return getData(m);
	}



	
}
