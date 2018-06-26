package step_definitions;

public class ExcelTestCaseSelector {
	String path[] = null;
	String singlepath = null;
	Boolean numberofsheets = false;
	String sheetname = null;
	

	public void ExcelTestSelector(String path[], String singlepath, Boolean numberofsheets, String sheetname){
		this.path = path;
		this.numberofsheets = numberofsheets;
		this.sheetname = sheetname;
		this.singlepath = singlepath;
	}
	public ExcelTestCaseSelector(String singlepath) {
		// TODO Auto-generated constructor stub
		this.singlepath = singlepath;
		this.numberofsheets = true;
	}
	public ExcelTestCaseSelector(String path[], Boolean numberofsheets){
		this.path = path;
		this.numberofsheets = numberofsheets;
		this.sheetname = null;
		this.singlepath = null;
	}
	public ExcelTestCaseSelector(String singlepath, String sheetname) {
		this.singlepath = singlepath;
		this.sheetname = sheetname;
		path = null;
		numberofsheets = false;
	}
}
