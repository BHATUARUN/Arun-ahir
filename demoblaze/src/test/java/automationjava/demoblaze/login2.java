package automationjava.demoblaze;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class login2 {
    
    private static Workbook workbook;
    private static Sheet sheet;
    
    // Read data from Excel
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        
        Object[][] data = new Object[rowCount - 1][colCount];
        
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    data[i-1][j] = "";
                } else {
                    cell.setCellType(CellType.STRING);
                    data[i-1][j] = cell.getStringCellValue();
                }
            }
        }
        
        workbook.close();
        fis.close();
        return data;
    }
    
    // Get row count
    public static int getRowCount(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        int rows = sheet.getPhysicalNumberOfRows();
        workbook.close();
        return rows;
    }
    
    // Get column count
    public static int getColCount(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();
        workbook.close();
        return cols;
    }
}