package model;

public class Product {
	String pid;
	String pname;
	float pprice;
	int pquantity;
	String sid;
	String cid;
	String cuid;
	String tid;
	@Override
	public boolean equals(Object o) {
		Product p=(Product)o;
		if(p.pid==this.pid) {
			return true;
		}
		return false;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}	
}
