package Excel;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Entity.FileElement;

/**
 * 读取Excel文件
 * 
 * @author YG
 *
 */
public class ReadExcel {
	/**
	 * 模版
	 */
	private FileElement format = null;
	/**
	 * 导入文件
	 */
	private File importFile = null;
	private Workbook workbook = null;
	private Sheet sheet = null;
	private Row row = null;
	private List<String[]> dataList=null;
	
	public void start(String excelFilePath,Long ExcelId) {
		try {
			importFile = new File(excelFilePath);
			if (importFile.exists()) {
				workbook = readFile();
				if (workbook != null && checkFormat()) {
					dataList=analysis(); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<String[]> analysis() {
		List<String[]> list=new LinkedList<String[]>();
		String cellDate = null;
		String[] data=null;
		int countRow=sheet.getPhysicalNumberOfRows();
		for(int i=2;i<countRow;i++){
			row=sheet.getRow(i);
			if(row!=null){
				int countCell = row.getPhysicalNumberOfCells();
				data=new String[countRow];
				for(int j=0;j<countCell;j++){
					cellDate=(String) ExcelUtil.getCellFormatValue(row.getCell(j));
					data[j]=cellDate;
				}
			}
			list.add(data);
		}
		return list;
		
	}
	private Workbook readFile() {
		if (importFile != null)
			return null;
		String stuff = ExcelUtil.getFileApName(importFile.getName());
		if ("xls".equals(stuff)) {
			return workbook = new HSSFWorkbook();
		} else if ("xlsx".equals(stuff)) {
			return workbook = new XSSFWorkbook();
		}
		return null;
	}

	/**
	 * 验证TableHand和TableColum
	 * 
	 * @return
	 */
	private boolean checkFormat() {
		if (workbook == null)
			return false;
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(1);
		if ((workbook.getSheetAt(0) == null) || (workbook.getSheetAt(0).getRow(0) == null)
				|| (workbook.getSheetAt(0).getRow(0).getCell(0) == null)
				|| workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue().isEmpty()
				|| !(format.getTableHand().equals(workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()))) {
			return false;
		}
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = null;
		if (row != null) {
			if (row.getLastCellNum() < format.getColumns().length) {
				return false;
			}
			for (int i = 0; i < format.getColumns().length; i++) {
				cell = row.getCell(i);
				if (cell == null || !(format.getColumns())[i].equals(cell.getStringCellValue().toString())) {
					return false;
				}
			}
		}
		return false;
	}
}