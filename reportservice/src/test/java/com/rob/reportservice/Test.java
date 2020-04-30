package com.rob.reportservice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        Path filePath = Paths.get("/Users/robinmathur/Desktop/Workbook1.xlsx");
        Workbook workbook =  new XSSFWorkbook(filePath.toFile());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.rowIterator();
        int sum = 0;
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Cell cell = row.getCell(4);
            if(null!= cell && cell.getCellType().equals(CellType.NUMERIC)){
                sum += cell.getNumericCellValue();
                System.out.println(cell.getAddress()+"-"+cell.getNumericCellValue());
            }
        }
        System.out.println(sum);
    }
}
