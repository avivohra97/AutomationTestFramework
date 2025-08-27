package com.ui.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtility {

    public static Iterator<User> readExcel() throws IOException, InvalidFormatException {
        File file = new File(System.getProperty("user.dir")+"\\testData\\loginData.xlsx");
        Workbook workbook = new XSSFWorkbook(file); // For .xlsx files
        // Workbook workbook = new HSSFWorkbook(excelFile); // For .xls files
        Sheet sheet = workbook.getSheetAt(0);
        List<User> list = new ArrayList<>();
        for(Row row: sheet){
            list.add(new User(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getBooleanCellValue()));
        }

        return list.iterator();
    }
}
