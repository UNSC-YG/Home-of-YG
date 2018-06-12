package Entity;

import java.util.Arrays;

public class FileElement{
	private Integer id;
	private String fileName;
	private String fileFormat;
	private String tableHand;
	private Column[] columns;
	public static final String FILE_FORMAT_EXCEL_XSL="xls";
	public static final String FILE_FORMAT_EXCEL_XSLX="xlsx";
	
	public FileElement(Integer id, String fileName, String fileFormat, String tableHand, Column[] columns) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileFormat = fileFormat;
		this.tableHand = tableHand;
		this.columns = columns;
	}
	
	public FileElement() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getTableHand() {
		return tableHand;
	}

	public void setTableHand(String tableHand) {
		this.tableHand = tableHand;
	}

	public Column[] getColumns() {
		return columns;
	}

	public void setColumns(Column[] columns) {
		this.columns = columns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(columns);
		result = prime * result + ((fileFormat == null) ? 0 : fileFormat.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tableHand == null) ? 0 : tableHand.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileElement other = (FileElement) obj;
		if (!Arrays.equals(columns, other.columns))
			return false;
		if (fileFormat == null) {
			if (other.fileFormat != null)
				return false;
		} else if (!fileFormat.equals(other.fileFormat))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tableHand == null) {
			if (other.tableHand != null)
				return false;
		} else if (!tableHand.equals(other.tableHand))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "FileElement [id=" + id + ", fileName=" + fileName + ", fileFormat=" + fileFormat + ", tableHand="
				+ tableHand + ", columns=" + Arrays.toString(columns) + "]";
	}

	public String writeFile(){
		return "[id:"+this.id+"{ \n FileName:"+this.fileName+"; \n FileFormat:"+this.fileFormat+"; \n TableHand:"+this.tableHand+"; \n TableColumn:{"+this.getColumnsRE()+"} \n "+"} \n"+"]";
	}
	private String getColumnsRE(){
		StringBuffer con=new StringBuffer();
		for(Column c:this.columns){
			con.append(c.writeFile());
		}
		return con.toString();
	}
}
