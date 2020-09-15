package com.pagoda.dto;

public class ClassDto {
	private int classno;
	private String classname;
	private int classcateno;
	private String classcategory;
	private int classprice;
	private String classdetail;
	private String classcompo;
	private String classstart;
	private String classend;
	private int teacherno;
	private String classpostdate;
	private String classip;
	private String classcreator;
	public ClassDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassDto(int classno, String classname, int classcateno, String classcategory, int classprice,
			String classdetail, String classcompo, String classstart, String classend, int teacherno,
			String classpostdate, String classip, String classcreator) {
		super();
		this.classno = classno;
		this.classname = classname;
		this.classcateno = classcateno;
		this.classcategory = classcategory;
		this.classprice = classprice;
		this.classdetail = classdetail;
		this.classcompo = classcompo;
		this.classstart = classstart;
		this.classend = classend;
		this.teacherno = teacherno;
		this.classpostdate = classpostdate;
		this.classip = classip;
		this.classcreator = classcreator;
	}
	@Override
	public String toString() {
		return "ClassDto [classno=" + classno + ", classname=" + classname + ", classcateno=" + classcateno
				+ ", classcategory=" + classcategory + ", classprice=" + classprice + ", classdetail=" + classdetail
				+ ", classcompo=" + classcompo + ", classstart=" + classstart + ", classend=" + classend
				+ ", teacherno=" + teacherno + ", classpostdate=" + classpostdate + ", classip=" + classip
				+ ", classcreator=" + classcreator + "]";
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getClasscateno() {
		return classcateno;
	}
	public void setClasscateno(int classcateno) {
		this.classcateno = classcateno;
	}
	public String getClasscategory() {
		return classcategory;
	}
	public void setClasscategory(String classcategory) {
		this.classcategory = classcategory;
	}
	public int getClassprice() {
		return classprice;
	}
	public void setClassprice(int classprice) {
		this.classprice = classprice;
	}
	public String getClassdetail() {
		return classdetail;
	}
	public void setClassdetail(String classdetail) {
		this.classdetail = classdetail;
	}
	public String getClasscompo() {
		return classcompo;
	}
	public void setClasscompo(String classcompo) {
		this.classcompo = classcompo;
	}
	public String getClassstart() {
		return classstart;
	}
	public void setClassstart(String classstart) {
		this.classstart = classstart;
	}
	public String getClassend() {
		return classend;
	}
	public void setClassend(String classend) {
		this.classend = classend;
	}
	public int getTeacherno() {
		return teacherno;
	}
	public void setTeacherno(int teacherno) {
		this.teacherno = teacherno;
	}
	public String getClasspostdate() {
		return classpostdate;
	}
	public void setClasspostdate(String classpostdate) {
		this.classpostdate = classpostdate;
	}
	public String getClassip() {
		return classip;
	}
	public void setClassip(String classip) {
		this.classip = classip;
	}
	public String getClasscreator() {
		return classcreator;
	}
	public void setClasscreator(String classcreator) {
		this.classcreator = classcreator;
	}
	
}
