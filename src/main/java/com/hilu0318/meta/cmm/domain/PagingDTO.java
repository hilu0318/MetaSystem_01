package com.hilu0318.meta.cmm.domain;

public class PagingDTO {
	
	private static int maxPageSize = 5;	
	
	private int 	thisPage;			//현재 페이지 
	private int 	totalRowSize;		//전체 게시물건수 
	private int 	totalEndPageNo;		//전체 페이지수 
	private int 	startPageNo;		//시작 페이지번호 
	private int 	endPageNo;			//마지막 페이지번호 
	
	private int 	iqryRowSize;		//페이지에 보여줄 조회 건수
	
	private boolean	prevPageYn = false;			//이전 페이지 유무 
	private boolean	nextPageYn = false;			//다음 페이지 유무 
	
	public PagingDTO(int iThisPageNo, int iTotalRowSize, int iRowSize) {
		this.thisPage = iThisPageNo;
		this.totalRowSize = iTotalRowSize;
		/*
		 * 전체 페이지수.
		 * 전체건수 / 화면에 보여질 게시물 수로 가장 마지막 페이지번호 계산.
		 */
		this.totalEndPageNo = iTotalRowSize / iRowSize;
		if((iTotalRowSize % iRowSize) > 0) {
			this.totalEndPageNo += 1;
		}
		
		/*
		 * 시작페이지.
		 * 현제 페이지 기준으로 화면에 보여질 시작 페이지 계산.
		 */
		this.startPageNo = (iThisPageNo - 1)/this.maxPageSize * this.maxPageSize + 1;
		
		/*
		 * 현재 페이지에 보여줄 마지막 페이지번호 계산.
		 * 일단, 시작페이지 + 4를 세팅해 두고 전체 마지막 페이지번호보다 그 번호가 클 경우 전체 마지막번호를 대입.
		 */
		this.endPageNo = this.endPageNo + 4;
		if(this.endPageNo > this.totalEndPageNo) {
			this.endPageNo = this.totalEndPageNo;
		}
		
		/*
		 * 현재 시작페이지가 노출페이지수보다클 경우에만 직전페이지 유무 세팅.
		 */
		if(this.startPageNo > this.maxPageSize) {
			this.prevPageYn = true;
		}
		
		
		/*
		 * 다음페이지 여부 세팅.
		 */
		if(this.totalEndPageNo > this.endPageNo) {
			this.nextPageYn = true;
		}
		
//		this.iqryRowSize = this.maxPageSize * iMaxRowSize;
	}
	
	public int getStartPage() {
		
		return 0;
	}
	
	public int getEndPage() {
		
		return 0;
	}
	
	public String getPrevYN() {
		
		return "N";
	}
	
	public String getNextYN() {
		
		return "N";
	}
	
	public int getIqryRowSize() {
		return this.iqryRowSize;
	}
	
}
