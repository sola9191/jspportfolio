package com.pagoda.dto;

public class Cre_Acc_Dto {
	private int pno;
	private String pname;
	private String pbirthDay;
	private String pgender;
	private String plocal;
	private String pphonenumber;
	private String pid;
	private String ppass;
	private String pemail;
	private String pdate;
	private String pip;
	private int shopno;
	
	public Cre_Acc_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cre_Acc_Dto(int pno, String pname, String pbirthDay, String pgender, String plocal, String pphonenumber,
			String pid, String ppass, String pemail, String pdate, String pip, int shopno) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pbirthDay = pbirthDay;
		this.pgender = pgender;
		this.plocal = plocal;
		this.pphonenumber = pphonenumber;
		this.pid = pid;
		this.ppass = ppass;
		this.pemail = pemail;
		this.pdate = pdate;
		this.pip = pip;
		this.shopno = shopno;
	}

	@Override
	public String toString() {
		return "Cre_Acc_Dto [pno=" + pno + ", pname=" + pname + ", pbirthDay=" + pbirthDay + ", pgender=" + pgender
				+ ", plocal=" + plocal + ", pphonenumber=" + pphonenumber + ", pid=" + pid + ", ppass=" + ppass
				+ ", pemail=" + pemail + ", pdate=" + pdate + ", pip=" + pip + ", shopno=" + shopno + "]";
	}

	public int getPno() { return pno; }
	public void setPno(int pno) { this.pno = pno; }  
	public String getPname() { return pname; } 
	public void setPname(String pname) { this.pname = pname; }  
	public String getPbirthDay() { return pbirthDay; }  
	public void setPbirthDay(String pbirthDay) { this.pbirthDay = pbirthDay; }  
	public String getPgender() { return pgender; }  
	public void setPgender(String pgender) { this.pgender = pgender; }  
	public String getPlocal() { return plocal; }  
	public void setPlocal(String plocal) { this.plocal = plocal; }  
	public String getPphonenumber() { return pphonenumber; }  
	public void setPphonenumber(String pphonenumber) { this.pphonenumber = pphonenumber; } 
	public String getPid() { return pid; }  
	public void setPid(String pid) { this.pid = pid; } 
	public String getPpass() { return ppass; }  
	public void setPpass(String ppass) { this.ppass = ppass; }  
	public String getPemail() { return pemail; }  
	public void setPemail(String pemail) { this.pemail = pemail; }  
	public String getPdate() { return pdate; }  
	public void setPdate(String pdate) { this.pdate = pdate; } 
	public String getPip() { return pip; } 
	public void setPip(String pip) { this.pip = pip; } 
	public int getShopno() { return shopno; }  
	public void setShopno(int shopno) { this.shopno = shopno; }   
}
