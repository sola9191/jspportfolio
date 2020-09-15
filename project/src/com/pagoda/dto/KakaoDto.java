package com.pagoda.dto;

public class KakaoDto {
	private int kno;
	private String kid;
	private int pno;
	public KakaoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KakaoDto(int kno, String kid, int pno) {
		super();
		this.kno = kno;
		this.kid = kid;
		this.pno = pno;
	}
	@Override
	public String toString() {
		return "KakaoDto [kno=" + kno + ", kid=" + kid + ", pno=" + pno + "]";
	}
	public int getKno() {
		return kno;
	}
	public void setKno(int kno) {
		this.kno = kno;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
}
