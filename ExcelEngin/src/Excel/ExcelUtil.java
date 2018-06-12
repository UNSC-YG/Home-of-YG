package Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtil {
	public static String getFileApName(String name) {
		return name.substring(name.lastIndexOf(".") + 1, name.length());
	}

	public static Object getCellFormatValue(Cell cell) {
		Object cellValue = null;
		if (cell != null) {
			switch (cell.getCellTypeEnum()) {
			case STRING: {
				cellValue = cell.getRichStringCellValue().getString();
				break;
			}
			case NUMERIC: {
				cellValue = String.valueOf(Math.round(cell.getNumericCellValue() * 10));
				break;
			}
			case FORMULA: {
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = cell.getDateCellValue();
				} else {
					cellValue = String.valueOf(cell.getNumericCellValue());
				}
			}
			default: {
				cellValue = "";
			}
			}

		} else {
			return cellValue = "";
		}

		return cellValue;
	}
}
