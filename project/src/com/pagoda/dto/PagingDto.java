package com.pagoda.dto;

import java.util.ArrayList;

public class PagingDto {
	private int pageTotal;// 전체 게시판의 갯수 (글의 갯수) 12개
	private int onepageLimit;// 한페이지당 보여줄 레코드수(글) 10
	private int pageall;// 하단 index의 갯수 12/10 :  2
	private int pstartno;// db에서 가져올 번호(1번버튼시 0, 2번버튼 10)
	private int bottomlist;// 하단 페이지 네비 이전, 다음, 숫자
	private int bottom_current;// 하단페이지네비 - 현재페이지번호
	private int bottom_start;// 하단페이지네비 - 현재페이지 기준 - 시작페이지 네비번호
	private int bottom_end;// 하단페이지네비 - 현재페이지 기준 - 끝페이지    네비번호
	ArrayList<RBDto>test;
	
	public PagingDto() {  }
	public PagingDto(int pageTotal, int onepageLimit, int pageall, int pstartno, int bottomlist, int bottom_current,
			int bottom_start, int bottom_end, ArrayList<RBDto> test) {
		super();
		this.pageTotal = pageTotal;
		this.onepageLimit = onepageLimit;
		this.pageall = pageall;
		this.pstartno = pstartno;
		this.bottomlist = bottomlist;
		this.bottom_current = bottom_current;
		this.bottom_start = bottom_start;
		this.bottom_end = bottom_end;
		this.test = test;
	}
	@Override
	public String toString() {
		return "PagingDto [pageTotal=" + pageTotal + ", onepageLimit=" + onepageLimit + ", pageall=" + pageall
				+ ", pstartno=" + pstartno + ", bottomlist=" + bottomlist + ", bottom_current=" + bottom_current
				+ ", bottom_start=" + bottom_start + ", bottom_end=" + bottom_end + ", test=" + test + "]";
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getOnepageLimit() {
		return onepageLimit;
	}
	public void setOnepageLimit(int onepageLimit) {
		this.onepageLimit = onepageLimit;
	}
	public int getPageall() {
		return pageall;
	}
	public void setPageall(int pageall) {
		this.pageall = pageall;
	}
	public int getPstartno() {
		return pstartno;
	}
	public void setPstartno(int pstartno) {
		this.pstartno = pstartno;
	}
	public int getBottomlist() {
		return bottomlist;
	}
	public void setBottomlist(int bottomlist) {
		this.bottomlist = bottomlist;
	}
	public int getBottom_current() {
		return bottom_current;
	}
	public void setBottom_current(int bottom_current) {
		this.bottom_current = bottom_current;
	}
	public int getBottom_start() {
		return bottom_start;
	}
	public void setBottom_start(int bottom_start) {
		this.bottom_start = bottom_start;
	}
	public int getBottom_end() {
		return bottom_end;
	}
	public void setBottom_end(int bottom_end) {
		this.bottom_end = bottom_end;
	}
	public ArrayList<RBDto> getTest() {
		return test;
	}
	public void setTest(ArrayList<RBDto> test) {
		this.test = test;
	}
	
}
