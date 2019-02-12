package cn.juni.pojo;

import java.util.Date;

public class Daily {

	private int did;
	private String title;
	private String context;
	private Date createtime;
	private String records;
	private String pic;
	private int uid;
	
	public Daily() {}

	public Daily(int did, String title, String context, Date createtime,String records, String pic, int uid) {
		this.did = did;
		this.title = title;
		this.context = context;
		this.createtime = createtime;
		this.records = records;
		this.pic = pic;
		this.uid = uid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Daily [did=" + did + ", title=" + title + ", context=" + context + ", createtime=" + createtime
				+ ", pic=" + pic + ", uid=" + uid + "]";
	}
	
}
