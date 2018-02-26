package excelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static String User;
	public static String Password;

	public static String Username() throws IOException {
		// TODO Auto-generated method stub
 System.out.println("Enterd_Check01");
		File src=new File("C:\\Users\\praveen kumar J\\Documents\\test01.xlsx");
		
		FileInputStream fls=new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fls);
		
		XSSFSheet sh1=wb.getSheetAt(0);
		
	    User=sh1.getRow(1).getCell(0).getStringCellValue();
		//System.out.println("The User name of Guru99 Bank is: "+User);
		
		Password=sh1.getRow(1).getCell(1).getStringCellValue();
		//System.out.println("The Password of the User is : "+Password);
		
		sh1.getRow(0).createCell(2).setCellValue("Results");
		sh1.getRow(1).createCell(2).setCellValue("Passed");
		
		FileOutputStream fout=new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
		
		return User;
	}

}
