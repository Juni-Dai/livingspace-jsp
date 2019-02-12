package cn.juni.pojo;

import java.util.List;

public class DailyCustom {

	private int pageIndex;
	private int pageSize;
	private int count;
	private int pageTotal;
	private List<Daily> dailyList;
	
	public DailyCustom() {}

	public DailyCustom(int pageIndex, int pageSize, int count,int pageTotal, List<Daily> dailyList) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.count = count;
		this.pageTotal = pageTotal;
		this.dailyList = dailyList;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		setPageTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List<Daily> getDailyList() {
		return dailyList;
	}

	public void setDailyList(List<Daily> dailyList) {
		this.dailyList = dailyList;
	}

	@Override
	public String toString() {
		return "DailyCustom [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", count=" + count + ", dailyList="
				+ dailyList + "]";
	}
	
}
