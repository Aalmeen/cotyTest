package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	FileInputStream fstream = null;
	List<String> list = new ArrayList<String>();

	public List<String> readUrl() throws IOException {
		try {

			File inFile = new File(System.getProperty("user.dir") + "\\resources\\CotyURL.xlsx");
			fstream = new FileInputStream(inFile);
			XSSFWorkbook wb = new XSSFWorkbook(fstream);
			XSSFSheet sh = wb.getSheet("urlDetails");
			XSSFRow row = sh.getRow(0);

			int col_num = -1;

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals("url"))
					col_num = i;
			}
			

			for (int j = 1; j < row.getRowNum() ; j++) {
				row = sh.getRow(j);
				XSSFCell cell = row.getCell(col_num);
				String value = cell.getStringCellValue();
				list.add(value);
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.ERROR, null, ex);
		} finally {
			fstream.close();
		}
		System.out.println(list);
		return list;
	}

	
	public int getRowCountOfCSVFile() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\Test_coty_location.csv"));
	     String input;
	     int count = -1;
	     while((input = bufferedReader.readLine()) != null)
	     {
	         count++;
	     }

	     System.out.println("Count : "+count);

		return count;
		
	}
}
