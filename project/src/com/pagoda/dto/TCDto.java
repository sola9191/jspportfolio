package com.pagoda.dto;

public class TCDto {
	private int teacherno;
	private String teachername;
	private String teacherinfo;
	private String teacherimg;
	private String teacherpostdate;
	private String teacherpostip;
	private String teachercreator;
	public TCDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TCDto(int teacherno, String teachername, String teacherinfo, String teacherimg, String teacherpostdate,
			String teacherpostip, String teachercreator) {
		super();
		this.teacherno = teacherno;
		this.teachername = teachername;
		this.teacherinfo = teacherinfo;
		this.teacherimg = teacherimg;
		this.teacherpostdate = teacherpostdate;
		this.teacherpostip = teacherpostip;
		this.teachercreator = teachercreator;
	}
	@Override
	public String toString() {
		return "TCDto [teacherno=" + teacherno + ", teachername=" + teachername + ", teacherinfo=" + teacherinfo
				+ ", teacherimg=" + teacherimg + ", teacherpostdate=" + teacherpostdate + ", teacherpostip="
				+ teacherpostip + ", teachercreator=" + teachercreator + "]";
	}
	public int getTeacherno() {
		return teacherno;
	}
	public void setTeacherno(int teacherno) {
		this.teacherno = teacherno;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeacherinfo() {
		return teacherinfo;
	}
	public void setTeacherinfo(String teacherinfo) {
		this.teacherinfo = teacherinfo;
	}
	public String getTeacherimg() {
		return teacherimg;
	}
	public void setTeacherimg(String teacherimg) {
		this.teacherimg = teacherimg;
	}
	public String getTeacherpostdate() {
		return teacherpostdate;
	}
	public void setTeacherpostdate(String teacherpostdate) {
		this.teacherpostdate = teacherpostdate;
	}
	public String getTeacherpostip() {
		return teacherpostip;
	}
	public void setTeacherpostip(String teacherpostip) {
		this.teacherpostip = teacherpostip;
	}
	public String getTeachercreator() {
		return teachercreator;
	}
	public void setTeachercreator(String teachercreator) {
		this.teachercreator = teachercreator;
	}
	
	
}
