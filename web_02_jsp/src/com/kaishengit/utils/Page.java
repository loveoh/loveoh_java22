package com.kaishengit.utils;

import java.util.List;

public class Page<T> {

	//�ܵ�ҳ����
	private int totalPage;
	//��ǰҳ��
	private int pagNo;
	//��ǰҳ������
	private List<T> items;
	//���ݵ�������
	private int totals;
	//ÿҳ��ʾ������
	private int pageSize = 5;
	//��ǰҳ����ʼ��
	private int pageStart;
	
	public Page(int totals,int pagNo){
		if(pagNo < 1){
			pagNo = 1;
		}
		
		this.totals = totals;
		//�����ҳ��
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

