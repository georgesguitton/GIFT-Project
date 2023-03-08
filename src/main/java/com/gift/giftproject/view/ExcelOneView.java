package com.gift.giftproject.view;

import com.gift.giftproject.model.StudentEntity;
import com.gift.giftproject.utils.excel.CellValueFormatter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.util.stream.Stream;

import static com.gift.giftproject.utils.excel.StyleFactory.*;

public class ExcelOneView {
    private final List<StudentEntity> tutorStudents;
    private final XSSFWorkbook workbook = new XSSFWorkbook();
    private final XSSFSheet spreadsheet = workbook.createSheet("Students");

    private static final String[] headerTitles = new String[]{
            "Gr", "NOM",
            "CDC", "FICHE VISITE", "FICHE EVAL ENTR", "SONDAGE WEB", "RAPPORT RENDU", "SOUT.",
            "DEBUT", "FIN", "ENTR.", "MdS", "ADRESSE",
            "VISITE PLANIF", "VISITE FAITE",
            "NOTE TECH", "NOTE COM"
    };

    private static final int[] columnWidths = new int[]{
            7, 30,
            7, 7, 7, 7, 7, 7,
            15, 15, 20, 20, 15,
            7, 7,
            7, 7
    };

    public ExcelOneView(List<StudentEntity> tutorStudents) {
        this.tutorStudents = tutorStudents;
    }

    private void setHeader() {
        final var headerRow = spreadsheet.createRow(0);
        final var headerStyle = createHeaderFormatStyle(workbook);

        int cellIndex = 0;
        for (final var title : headerTitles) {
            final var cell = headerRow.createCell(cellIndex);
            spreadsheet.setColumnWidth(cellIndex, 256 * columnWidths[cellIndex]);
            cell.setCellValue(title);
            cell.setCellStyle(headerStyle);
            cellIndex++;
        }
    }

    private void addStudentRow(StudentEntity student, int rowIndex) {
        final var cellValueFormatter = new CellValueFormatter(workbook);

        final var row = spreadsheet.createRow(rowIndex);
        final var rowContent = new Object[]{
                student.getStudentGroup(),
                student.getFirstname() + " " + student.getLastname(),
                student.getDocumentsByIdDocuments().isSpecsDone(),
                student.getDocumentsByIdDocuments().isVisitFormDone(),
                student.getDocumentsByIdDocuments().isCompanyEvalFormDone(),
                student.getDocumentsByIdDocuments().isWebPollDone(),
                student.getDocumentsByIdDocuments().isReportDone(),
                student.getEvaluationsByIdEvaluations().isOralPresentation(),
                student.getInternshipByIdInternship().getStartDate(),
                student.getInternshipByIdInternship().getEndDate(),
                student.getInternshipByIdInternship().getCompanyName(),
                student.getInternshipByIdInternship().getCompanyTutor(),
                student.getInternshipByIdInternship().getCompanyAddress(),
                student.getInternshipByIdInternship().isVisitPlanified(),
                student.getInternshipByIdInternship().isVisitDone(),
                student.getEvaluationsByIdEvaluations().getTechnicalGrade(),
                student.getEvaluationsByIdEvaluations().getCommunicationGrade()
        };

        int cellIndex = 0;
        for (final var cellContent : rowContent) {
            final var cell = row.createCell(cellIndex++);
            cellValueFormatter.formatCell(cell, cellContent);
        }
    }

    public XSSFWorkbook render() {
        setHeader();

        int rowIndex = 1;
        for (final var student : tutorStudents) {
            addStudentRow(student, rowIndex++);
        }

        if (rowIndex > 1) {
            final var spreadsheetConditionalFormatting = spreadsheet.getSheetConditionalFormatting();
            final var booleanFormattingRules = createBooleanConditionalFormattingRules(spreadsheet);
            spreadsheetConditionalFormatting.addConditionalFormatting(
                    Stream.of("C2:J"+rowIndex, "N2:O"+rowIndex)
                            .map(CellRangeAddress::valueOf)
                            .toList().toArray(new CellRangeAddress[0]),
                    booleanFormattingRules
            );
        }

        return workbook;
    }
}
