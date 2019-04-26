package demo;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelOperation {
    public static void main(String[] args) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");
        for(int row =1;row<4;row++) {
            HSSFRow rows = sheet.createRow(row);
            for(int col=2;col<3;col++) {
                rows.createCell(col).setCellValue("123");
            }
        }

        File xlsFile = new File("/Users/adelayang/downloads/花名册信息模板.xls");
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
        System.out.println("ok");

    }
    public static void Read(String[] args) throws EncryptedDocumentException, IOException {
        File xlsFile = new File("poi.xls");
        Workbook workbook = WorkbookFactory.create(xlsFile);
        int sheetCount = workbook.getNumberOfSheets();
        for(int i=0;i<sheetCount;i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int rows = sheet.getLastRowNum()+1;
            //Row tmp = sheet.getRow(0);
            Row tmp = sheet.getRow(0);
            if(tmp==null) {
                continue;
            }
            int cols = tmp.getPhysicalNumberOfCells();
            for(int row =0;row<rows;row++) {
                Row r = sheet.getRow(row);
                for(int col=0;col<cols;col++) {
                    System.out.printf("%10s", r.getCell(col).getStringCellValue());
                }
                System.out.println();
            }
        }
    }
}
