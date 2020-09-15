package com.pagoda.dto;

public class ClassCateDto {
	private int classcateno;
	private String classcatename;
	public ClassCateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassCateDto(int classcateno, String classcatename) {
		super();
		this.classcateno = classcateno;
		this.classcatename = classcatename;
	}
	@Override
	public String toString() {
		return "ClassCateDto [classcateno=" + classcateno + ", classcatename=" + classcatename + "]";
	}
	public int getClasscateno() {
		return classcateno;
	}
	public void setClasscateno(int classcateno) {
		this.classcateno = classcateno;
	}
	public String getClasscatename() {
		return classcatename;
	}
	public void setClasscatename(String classcatename) {
		this.classcatename = classcatename;
	}
	
}
