package com.pagoda.dto;

public class CartDto {
	
	private int cartno;
	private int classno;
	private int totalprice;
	private int pno;
	private String cartdate;
	private String cartip;
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDto(int cartno, int classno, int totalprice, int pno, String cartdate, String cartip) {
		super();
		this.cartno = cartno;
		this.classno = classno;
		this.totalprice = totalprice;
		this.pno = pno;
		this.cartdate = cartdate;
		this.cartip = cartip;
	}
	@Override
	public String toString() {
		return "CartDto [cartno=" + cartno + ", classno=" + classno + ", totalprice=" + totalprice + ", pno=" + pno
				+ ", cartdate=" + cartdate + ", cartip=" + cartip + "]";
	}
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getCartdate() {
		return cartdate;
	}
	public void setCartdate(String cartdate) {
		this.cartdate = cartdate;
	}
	public String getCartip() {
		return cartip;
	}
	public void setCartip(String cartip) {
		this.cartip = cartip;
	}
	
}
