package com.automation.core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.automation.core.constants.FrameworkConstants;
import com.automation.core.exceptions.FrameworkException;
import com.automation.core.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {
	private ExcelUtils() {}

	public static List<Map<String,String>> getTestDetails(String sheetname){
		List<Map<String,String>> list = null;

		try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {

			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String,String> map =null;
			list = new ArrayList<>();

			for(int i=1; i<=lastrownum;i++) { 
				map = new HashMap<>(); 
				for(int j=0;j<lastcolnum;j++) {
					String key= sheet.getRow(0).getCell(j).getStringCellValue();
					String value = Objects.nonNull(sheet.getRow(i).getCell(j))?sheet.getRow(i).getCell(j).getStringCellValue():"";
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			throw new InvalidPathForExcelException("Excel File you trying to read is not found");
		} catch (IOException e) {
			throw new FrameworkException("Some io exception happened  while reading excel file");
		}
		System.out.println(list);
		return list;
	}
	
	

}
