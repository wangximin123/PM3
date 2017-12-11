package model;

public class Product {
String id;
String cid;
String tid;
String name;
float price;
int quantity;
String company;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid =cid;
}
public boolean equals(Object obj) {
	Product p=(Product)obj;
	if(p.getId()==this.id){
		return true;
	}
	return false;
}

}
