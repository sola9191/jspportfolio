package com.pagoda.dto;

public class RBDto {
	private int rno;
	private int pno;
	private int classno;
	private String rstar;
	private String rtitle;
	private String rpass;
	private String rcontent;
	private int rhit;
	private String rfile;
	private String rip;
	private String rdate;
	public RBDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RBDto(int rno, int pno, int classno, String rstar, String rtitle, String rpass, String rcontent, int rhit,
			String rfile, String rip, String rdate) {
		super();
		this.rno = rno;
		this.pno = pno;
		this.classno = classno;
		this.rstar = rstar;
		this.rtitle = rtitle;
		this.rpass = rpass;
		this.rcontent = rcontent;
		this.rhit = rhit;
		this.rfile = rfile;
		this.rip = rip;
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "RBDto [rno=" + rno + ", pno=" + pno + ", classno=" + classno + ", rstar=" + rstar + ", rtitle=" + rtitle
				+ ", rpass=" + rpass + ", rcontent=" + rcontent + ", rhit=" + rhit + ", rfile=" + rfile + ", rip=" + rip
				+ ", rdate=" + rdate + "]";
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public String getRstar() {
		return rstar;
	}
	public void setRstar(String rstar) {
		this.rstar = rstar;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getRpass() {
		return rpass;
	}
	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public int getRhit() {
		return rhit;
	}
	public void setRhit(int rhit) {
		this.rhit = rhit;
	}
	public String getRfile() {
		return rfile;
	}
	public void setRfile(String rfile) {
		this.rfile = rfile;
	}
	public String getRip() {
		return rip;
	}
	public void setRip(String rip) {
		this.rip = rip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
}