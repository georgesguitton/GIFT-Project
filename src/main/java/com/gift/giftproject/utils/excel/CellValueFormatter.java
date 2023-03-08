package com.gift.giftproject.utils.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.Date;

import static com.gift.giftproject.utils.excel.StyleFactory.*;

public class CellValueFormatter {
    private final XSSFCellStyle dateFormatStyle;
    private final XSSFCellStyle booleanFormatStyle;
    private final XSSFCellStyle defaultCellStyle;

    public CellValueFormatter(XSSFWorkbook workbook) {
        dateFormatStyle = createDateFormatStyle(workbook);
        booleanFormatStyle = createBooleanCellStyle(workbook);
        defaultCellStyle = createDefaultCellStyle(workbook);
    }

    public void formatCell(XSSFCell cell, Object value) {
        if (value instanceof Date) formatDateCell(cell, (Date) value);
        else if (value instanceof Boolean) formatBooleanCell(cell, (boolean) value);
        else if (value instanceof Double) formatDoubleCell(cell, (double) value);
        else formatStringCell(cell, value.toString());
    }

    private void formatDateCell(XSSFCell cell, Date value) {
        cell.setCellValue(value);
        cell.setCellStyle(dateFormatStyle);
    }

    private void formatBooleanCell(XSSFCell cell, boolean value) {
        cell.setCellValue(value ? 1 : 0);
        cell.setCellStyle(booleanFormatStyle);
    }

    private void formatDoubleCell(XSSFCell cell, double value) {
        cell.setCellValue(value);
        cell.setCellStyle(defaultCellStyle);
    }

    private void formatStringCell(XSSFCell cell, String value) {
        cell.setCellValue(value);
        cell.setCellStyle(defaultCellStyle);
    }
}
