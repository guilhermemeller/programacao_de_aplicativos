package utils;
import javax.swing.JTable;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExportarXls {
	
	public static void exportToExcel(JTable table, String filePath) {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Cria o cabeçalho
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < table.getColumnCount(); i++) {
                String columnName = table.getColumnName(i);
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnName);
            }

            // Preenche os dados
            for (int i = 0; i < table.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object value = table.getValueAt(i, j);
                    Cell cell = row.createCell(j);
                    cell.setCellValue(value.toString());
                }
            }

            // Autoajusta as colunas
            for (int i = 0; i < table.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            // Salva o arquivo Excel
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
