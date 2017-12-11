package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.DBManager;
import control.SetListener;

public class SaleFrame extends JFrame{
JTextField tquantity,tyingfu,txiaoshou,tzhaoling;
JButton badd,bcommit;
JComboBox cid,cproduct;
JTable table;
Box box;
String[] products=new String[20];
String[] salers=new String[20];
Object[] tableTitle={"商品编号","商品名称","数量","价格"};
Object[][] tableObj=new Object[20][4];
DBManager dm;
SetListener sl=new SetListener(this);
public SaleFrame(){
	this.setVisible(true);
	this.setBounds(200, 200, 600, 400);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setProductsContent();
	this.setSalersContent();
	init();
	this.setListener();
	this.validate();
}
public void init(){
	box=Box.createVerticalBox();
	JPanel p1=new JPanel();
	JLabel lid=new JLabel("请选择员工姓名");
	cid=new JComboBox(salers);
	JLabel lproduct=new JLabel("请选择销售的产品");
	cproduct=new JComboBox(products);
	p1.add(lid);
	p1.add(cid);
	p1.add(lproduct);
	p1.add(cproduct);
	
	
	JPanel p2=new JPanel();
	JLabel lquantity=new JLabel("请输入数量");
	tquantity=new JTextField(10);
	badd=new JButton("添加");
	p2.add(lquantity);
	p2.add(tquantity);
	p2.add(badd);
	
	
	table=new JTable(tableObj,tableTitle);
	
	
	JPanel p3=new JPanel();
	JLabel lyingfu=new JLabel("应付");
	tyingfu=new JTextField(10);
	JLabel lxiaoshou=new JLabel("请输入销售单号");
	txiaoshou=new JTextField(10);
	JLabel lzhaoling=new JLabel("找零");
	tzhaoling=new JTextField(10);
	bcommit=new JButton("确认");
	p3.add(lyingfu);
	p3.add(tyingfu);
	p3.add(lxiaoshou);
	p3.add(txiaoshou);
	p3.add(bcommit);
	
	
	box.add(p1);
	box.add(p2);
	box.add(new JScrollPane(table));
	box.add(p3);
	this.add(box);
}
public void setListener(){
	badd.setActionCommand("SaleFrameAdd");
	badd.addActionListener(sl);
	
	bcommit.setActionCommand("SaleFrameCommit");
	bcommit.addActionListener(sl);
}
public void setProductsContent(){
	dm=new DBManager("select pname from product");
	try {
		ResultSet result=dm.getPst().executeQuery();
		int i=0;
		while(result.next()){
			products[i]=result.getString(1);
			i++;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dm.close();
	
}
public void setSalersContent(){
	dm=new DBManager("select sname from saler");
	try {
		ResultSet result=dm.getPst().executeQuery();
		int i=0;
		while(result.next()){
			salers[i]=result.getString(1);
			i++;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void main(String[] args) {
	new SaleFrame();
}

public JTextField getTquantity() {
	return tquantity;
}
public void setTquantity(JTextField tquantity) {
	this.tquantity = tquantity;
}
public JTextField getTyingfu() {
	return tyingfu;
}
public void setTyingfu(JTextField tyingfu) {
	this.tyingfu = tyingfu;
}
public JTextField getTxiaoshou() {
	return txiaoshou;
}
public void setTshoukuan(JTextField tshoukuan) {
	this.txiaoshou = tshoukuan;
}
public JTextField getTzhaoling() {
	return tzhaoling;
}
public void setTzhaoling(JTextField tzhaoling) {
	this.tzhaoling = tzhaoling;
}
public JButton getBadd() {
	return badd;
}
public void setBadd(JButton badd) {
	this.badd = badd;
}
public JButton getBcommit() {
	return bcommit;
}
public void setBcommit(JButton bcommit) {
	this.bcommit = bcommit;
}
public JComboBox getCid() {
	return cid;
}
public void setCid(JComboBox cid) {
	this.cid = cid;
}
public JComboBox getCproduct() {
	return cproduct;
}
public void setCproduct(JComboBox cproduct) {
	this.cproduct = cproduct;
}
public JTable getTable() {
	return table;
}
public void setTable(JTable table) {
	this.table = table;
}
public Box getBox() {
	return box;
}
public void setBox(Box box) {
	this.box = box;
}
public String[] getProducts() {
	return products;
}
public void setProducts(String[] products) {
	this.products = products;
}
public String[] getSalers() {
	return salers;
}
public void setSalers(String[] salers) {
	this.salers = salers;
}
public Object[] getTableTitle() {
	return tableTitle;
}
public void setTableTitle(Object[] tableTitle) {
	this.tableTitle = tableTitle;
}
public Object[][] getTableObj() {
	return tableObj;
}
public void setTableObj(Object[][] tableObj) {
	this.tableObj = tableObj;
}
public DBManager getDm() {
	return dm;
}
public void setDm(DBManager dm) {
	this.dm = dm;
}
public SetListener getSl() {
	return sl;
}
public void setSl(SetListener sl) {
	this.sl = sl;
}

}
