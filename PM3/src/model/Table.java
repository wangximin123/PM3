package model;

import java.sql.Date;
import java.util.ArrayList;

public class Table {
String id;
Date date;
float money;
ArrayList<Product> products;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public float getMoney() {
	return money;
}
public void setMoney(float money) {
	this.money = money;
}
public ArrayList<Product> getProducts() {
	return products;
}
public void setProducts(ArrayList<Product> products) {
	this.products = products;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

}
