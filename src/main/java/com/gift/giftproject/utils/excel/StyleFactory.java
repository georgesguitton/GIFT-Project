package com.gift.giftproject.utils.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormattingRule;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StyleFactory {
    private StyleFactory() {}

    public static XSSFCellStyle createDateFormatStyle(XSSFWorkbook workbook) {
        final var createHelper = workbook.getCreationHelper();
        final var cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));

        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        return cellStyle;
    }

    public static XSSFCellStyle createBooleanCellStyle(XSSFWorkbook workbook) {
        final var createHelper = workbook.getCreationHelper();
        final var cellStyle = workbook.createCellStyle();

        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("\"OUI\";;\"NON\";"));

        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        return cellStyle;
    }

    public static XSSFCellStyle createDefaultCellStyle(XSSFWorkbook workbook) {
        final var cellStyle = workbook.createCellStyle();

        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        return cellStyle;
    }

    public static ConditionalFormattingRule[] createBooleanConditionalFormattingRules(XSSFSheet sheet) {
        final var sheetConditionalFormatting = sheet.getSheetConditionalFormatting();

        final var trueRule = sheetConditionalFormatting.createConditionalFormattingRule(ComparisonOperator.EQUAL, "1");
        final var falseRule = sheetConditionalFormatting.createConditionalFormattingRule(ComparisonOperator.EQUAL, "0");

        final var fillTrueFontFormatting = trueRule.createFontFormatting();
        fillTrueFontFormatting.setFontColorIndex(IndexedColors.GREEN.index);
        final var fillTruePatternFormatting = trueRule.createPatternFormatting();
        fillTruePatternFormatting.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);

        final var fillFalseFontFormatting = falseRule.createFontFormatting();
        fillFalseFontFormatting.setFontColorIndex(IndexedColors.ORANGE.index);
        final var fillFalsePatternFormatting = falseRule.createPatternFormatting();
        fillFalsePatternFormatting.setFillBackgroundColor(IndexedColors.LIGHT_YELLOW.index);

        return new XSSFConditionalFormattingRule[]{trueRule, falseRule};
    }

    public static XSSFCellStyle createHeaderFormatStyle(XSSFWorkbook workbook) {
        final var cellStyle = workbook.createCellStyle();

        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBottomBorderColor(IndexedColors.GREY_80_PERCENT.getIndex());

        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        return cellStyle;
    }
}
