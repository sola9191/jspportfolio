package com.pagoda.dto;

public class NTBDto {
	private int nno;
	private String nname;
	private String ntitle;
	private String npass;
	private String ncontent;
	private String nip;
	private String ndate;
	private String ncate;
	public NTBDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NTBDto(int nno, String nname, String ntitle, String npass, String ncontent, String nip, String ndate,
			String ncate) {
		super();
		this.nno = nno;
		this.nname = nname;
		this.ntitle = ntitle;
		this.npass = npass;
		this.ncontent = ncontent;
		this.nip = nip;
		this.ndate = ndate;
		this.ncate = ncate;
	}
	@Override
	public String toString() {
		return "NTBDto [nno=" + nno + ", nname=" + nname + ", ntitle=" + ntitle + ", npass=" + npass + ", ncontent="
				+ ncontent + ", nip=" + nip + ", ndate=" + ndate + ", ncate=" + ncate + "]";
	}
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNpass() {
		return npass;
	}
	public void setNpass(String npass) {
		this.npass = npass;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getNcate() {
		return ncate;
	}
	public void setNcate(String ncate) {
		this.ncate = ncate;
	}
}
