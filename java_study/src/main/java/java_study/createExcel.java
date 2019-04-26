package java_study;

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

public class createExcel {
    //创建一个文件，里面包含两个sheet，其中sheet2没有创建单元格，sheet3创建单元格
    public void creExcel() throws IOException {

        File xlsfile = new File("new6.xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet2");
        HSSFSheet sheet3 = workbook.createSheet("sheet3");
        for(int row =0;row<10;row++) {
            HSSFRow rows = sheet3.createRow(row);
            for(int col=0;col<10;col++) {
                rows.createCell(col);
            }
        }

        FileOutputStream fos = new FileOutputStream(xlsfile);
        workbook.write(xlsfile);

    }
    //在excel表格没有创建时，往excel表格中写数据，即在写数据时创建单元格
    public void writeExcel() throws EncryptedDocumentException, IOException {
        File xlsfile = new File("/java_study/src/main/new6.xls");
        Workbook workbook = WorkbookFactory.create(xlsfile);
        Sheet sheet = workbook.getSheetAt(0);
        //Row tmp = sheet.getRow(1);
        for(int row =0;row<10;row++) {
            Row tmp = sheet.createRow(row);
            for(int col=0;col<10;col++) {
                tmp.createCell(col).setCellValue("1234");
            }
        }
        FileOutputStream fos  = new FileOutputStream(xlsfile);
        workbook.write(fos);

    }
    //往已创建单元格的excel表格中写数据
    public void writeExcel33() throws EncryptedDocumentException, IOException {
        File xlsfile = new File("new6.xls");
        Workbook workbook = WorkbookFactory.create(xlsfile);
        Sheet sheet = workbook.getSheetAt(1);
        Row tmp = sheet.getRow(9);
        for(int col=0;col<5;col++) {
            tmp.getCell(col).setCellValue("123456");
            //tmp.getCell(9).setCellValue("123456");
        }
        FileOutputStream fos  = new FileOutputStream(xlsfile);
        workbook.write(fos);

    }
    //读excel表格内容
    public void readExcel() throws EncryptedDocumentException, IOException {
        File file = new File("aa.xls");
        Workbook workbook = WorkbookFactory.create(file);
        int sheetcount = workbook.getNumberOfSheets();
        for(int i=0;i<sheetcount;i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int rows = sheet.getLastRowNum()+1;
            Row tmp = sheet.getRow(0);
            if(tmp==null) {
                continue;
            }
            int cols = tmp.getPhysicalNumberOfCells();
            for(int row=0;row<rows;row++) {
                Row r = sheet.getRow(row);
                for(int col=0;col<cols;col++) {
                    r.getCell(col).getStringCellValue();
                }
            }
        }
    }

    public static void main(String[] args) throws EncryptedDocumentException, IOException {
        createExcel ce = new createExcel();
        ce.creExcel();
        ce.writeExcel();
    }

}
