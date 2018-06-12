package Entity;

public class FileSub {
	private Integer id;
	private String fileContext;
	public FileSub(Integer id, String fileContext) {
		super();
		this.id = id;
		this.fileContext = fileContext;
	}
	public FileSub() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFileContext() {
		return fileContext;
	}
	public void setFileContext(String fileContext) {
		this.fileContext = fileContext;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileContext == null) ? 0 : fileContext.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FileSub other = (FileSub) obj;
		if (fileContext == null) {
			if (other.fileContext != null)
				return false;
		} else if (!fileContext.equals(other.fileContext))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FileSub [id=" + id + ", fileContext=" + fileContext + "]";
	}
}
