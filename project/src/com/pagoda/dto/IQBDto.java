package com.pagoda.dto;

public class IQBDto {
	
	private int ino;
	private int pno;
	private String ititle;
	private String icontent;
	private String ifile;
	private int iread;
	private int igroup;
	private int istep;
	private int iindent;
	private String iemail;
	private String idate;
	private String iip;
	
	public IQBDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IQBDto(int ino, int pno, String ititle, String icontent, String ifile, int iread, int igroup, int istep,
			int iindent, String iemail, String idate, String iip) {
		super();
		this.ino = ino;
		this.pno = pno;
		this.ititle = ititle;
		this.icontent = icontent;
		this.ifile = ifile;
		this.iread = iread;
		this.igroup = igroup;
		this.istep = istep;
		this.iindent = iindent;
		this.iemail = iemail;
		this.idate = idate;
		this.iip = iip;
	}

	@Override
	public String toString() {
		return "IQBDto [ino=" + ino + ", pno=" + pno + ", ititle=" + ititle + ", icontent=" + icontent + ", ifile="
				+ ifile + ", iread=" + iread + ", igroup=" + igroup + ", istep=" + istep + ", iindent=" + iindent
				+ ", iemail=" + iemail + ", idate=" + idate + ", iip=" + iip + "]";
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getItitle() {
		return ititle;
	}

	public void setItitle(String ititle) {
		this.ititle = ititle;
	}

	public String getIcontent() {
		return icontent;
	}

	public void setIcontent(String icontent) {
		this.icontent = icontent;
	}

	public String getIfile() {
		return ifile;
	}

	public void setIfile(String ifile) {
		this.ifile = ifile;
	}

	public int getIread() {
		return iread;
	}

	public void setIread(int iread) {
		this.iread = iread;
	}

	public int getIgroup() {
		return igroup;
	}

	public void setIgroup(int igroup) {
		this.igroup = igroup;
	}

	public int getIstep() {
		return istep;
	}

	public void setIstep(int istep) {
		this.istep = istep;
	}

	public int getIindent() {
		return iindent;
	}

	public void setIindent(int iindent) {
		this.iindent = iindent;
	}

	public String getIemail() {
		return iemail;
	}

	public void setIemail(String iemail) {
		this.iemail = iemail;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getIip() {
		return iip;
	}

	public void setIip(String iip) {
		this.iip = iip;
	}

	
}