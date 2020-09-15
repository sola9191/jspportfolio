package com.pagoda.dto;

public class CSBDto {
	private int cno;
	private String cname;
	private String ctitle;
	private String ccontent;
	private String cpass;
	private String cdate;
	private String cip;
	private int ccategorynum;	
	
	public CSBDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CSBDto(int cno, String cname, String ctitle, String ccontent, String cpass, String cdate, String cip,
			int ccategorynum) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.ctitle = ctitle;
		this.ccontent = ccontent;
		this.cpass = cpass;
		this.cdate = cdate;
		this.cip = cip;
		this.ccategorynum = ccategorynum;
	}


	@Override
	public String toString() {
		return "CSBDto [cno=" + cno + ", cname=" + cname + ", ctitle=" + ctitle + ", ccontent=" + ccontent + ", cpass="
				+ cpass + ", cdate=" + cdate + ", cip=" + cip + ", ccategorynum=" + ccategorynum + "]";
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCtitle() {
		return ctitle;
	}


	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}


	public String getCcontent() {
		return ccontent;
	}


	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}


	public String getCpass() {
		return cpass;
	}


	public void setCpass(String cpass) {
		this.cpass = cpass;
	}


	public String getCdate() {
		return cdate;
	}


	public void setCdate(String cdate) {
		this.cdate = cdate;
	}


	public String getCip() {
		return cip;
	}


	public void setCip(String cip) {
		this.cip = cip;
	}


	public int getCcategorynum() {
		return ccategorynum;
	}


	public void setCcategorynum(int ccategorynum) {
		this.ccategorynum = ccategorynum;
	}


}
