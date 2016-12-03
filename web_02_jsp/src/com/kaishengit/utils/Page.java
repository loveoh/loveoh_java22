package com.kaishengit.utils;

import java.util.List;

public class Page<T> {

	//总的页面数
	private int totalPage;
	//当前页码
	private int pagNo;
	//当前页的内容
	private List<T> items;
	//数据的总条数
	private int totals;
	//每页显示的数量
	private int pageSize = 5;
	//当前页的起始行
	private int pageStart;
	
	public Page(int totals,int pagNo){
		if(pagNo < 1){
			pagNo = 1;
		}
		
		this.totals = totals;
		//获得总页数
		totalPage = totals / pageSize ;
		if(totals % pageSize != 0){
			totalPage++;
		}
		
		if(pagNo > totalPage){
			pagNo = totalPage;
		}
		this.pagNo = pagNo;
	}
	
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getpagNo() {
		return pagNo;
	}
	public void setpagNo(int pagNo) {
		pagNo = pagNo;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	public int getTotals() {
		return totals;
	}
	public void setTotals(int totals) {
		this.totals = totals;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	
	
	
}

