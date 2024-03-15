package com.automation.core.constants;

import com.automation.core.enums.ConfigProperties;
import com.automation.core.utils.PropertyUtils;

import java.io.File;

public class FrameworkConstants {
    private FrameworkConstants() {
    }
    public static final String SLASH = File.separator;
    private static final int EXPLICITWAIT = 10;
    private static final String RESOURCESPATH = System.getProperty("user.dir") + SLASH+ "src"+SLASH+"test"+SLASH+"resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH + SLASH+ "config"+SLASH+"config.properties";
    private static final String EXCELPATH = RESOURCESPATH + SLASH +"excel"+SLASH+"testdata.xlsx";
    private static final String RUNMANGERSHEET = "RUNMANAGER";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentReportFilePath = "";


    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+SLASH + "index.html";
        } else {
            return EXTENTREPORTFOLDERPATH +SLASH+ "index.html";
        }
    }
    public static String getExcelpath() {
        return EXCELPATH;
    }
    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }
    public static String getRunmangerDatasheet() {
        return RUNMANGERSHEET;
    }
    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
}
