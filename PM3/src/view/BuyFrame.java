package view;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.DBManager;
import control.SetListener;
import control.modelManager;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class BuyFrame extends JFrame{
JTable table,item;
JButton badd,bdelete,bmonify,breshow;
Object[][] tableObj=new Object[10][2];
Object[][] itemObj=new Object[10][5];
Object[] tableTitle={"日期","总价"};
Object[] itemTitle={"商品编号","商品名称","商品总价","商品数量","供应商"};
ArrayList<Table> tableList=new ArrayList<Table>();
ArrayList<Product> itemList=new ArrayList<Product>();
Box box;
SetListener sl=new SetListener(this);
DBManager dm;
modelManager mm=new modelManager();
public BuyFrame(){
	
	this.setBounds(200, 200, 700, 500);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	init();
	listener();
	initTableFromSql();
	this.setVisible(true);
	validate();
	
}
public void listener(){
	table.addMouseListener(sl);
	
	badd.setActionCommand("BuyFrameAdd");
	badd.addActionListener(sl);
	
	bdelete.setActionCommand("BuyFrameDelete");
	bdelete.addActionListener(sl);
	
	breshow.setActionCommand("BuyFrameReshow");
	breshow.addActionListener(sl);
}


public void init(){
	table=new JTable(tableObj,tableTitle);
	item=new JTable(itemObj,itemTitle);
	
	box=Box.createVerticalBox();
	box.add(new JScrollPane(table));
	box.add(new JScrollPane(item));
	
	JPanel p1=new JPanel();
	badd=new JButton("新增采购单");
	bdelete=new JButton("删除采购单");
	bmonify=new JButton("修改采购单");
	breshow=new JButton("刷新");
	p1.add(badd);
	p1.add(bdelete);
	p1.add(bmonify);
	p1.add(breshow);
	box.add(p1);
	
	
	this.add(box);	
}
public void initTableFromSql(){
	dm=new DBManager("select * from tables");
	ResultSet result;
	tableList=new ArrayList<Table>();
	try {
		result=dm.getPst().executeQuery();
		while(result.next()){
			Table t=new Table();
			t.setId(result.getString(1));
			t.setDate(result.getDate(2));
			t.setMoney(result.getFloat(3));	
			tableList.add(t);	
		}
		tableObj=mm.getFromTableList(tableList);
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setDataVector(tableObj,tableTitle);
		table.setModel(dtm);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dm.close();
	}
	
}

public JTable getTable() {
	return table;
}
public void setTable(JTable table) {
	this.table = table;
}
public JTable getItem() {
	return item;
}
public void setItem(JTable item) {
	this.item = item;
}
public JButton getBadd() {
	return badd;
}
public void setBadd(JButton badd) {
	this.badd = badd;
}
public JButton getBdelete() {
	return bdelete;
}
public void setBdelete(JButton bdelete) {
	this.bdelete = bdelete;
}
public JButton getBmonify() {
	return bmonify;
}
public void setBmonify(JButton bmonify) {
	this.bmonify = bmonify;
}
public Object[][] getTableObj() {
	return tableObj;
}
public void setTableObj(Object[][] tableObj) {
	this.tableObj = tableObj;
}
public Object[][] getItemObj() {
	return itemObj;
}
public void setItemObj(Object[][] itemObj) {
	this.itemObj = itemObj;
}
public Object[] getTableTitle() {
	return tableTitle;
}
public void setTableTitle(Object[] tableTitle) {
	this.tableTitle = tableTitle;
}
public Object[] getItemTitle() {
	return itemTitle;
}
public void setItemTitle(Object[] itemTitle) {
	this.itemTitle = itemTitle;
}
public ArrayList<Table> getTableList() {
	return tableList;
}
public void setTableList(ArrayList<Table> tableList) {
	this.tableList = tableList;
}
public ArrayList<Product> getItemList() {
	return itemList;
}
public void setItemList(ArrayList<Product> itemList) {
	this.itemList = itemList;
}
public Box getBox() {
	return box;
}
public void setBox(Box box) {
	this.box = box;
}
public SetListener getSl() {
	return sl;
}
public void setSl(SetListener sl) {
	this.sl = sl;
}
public DBManager getDm() {
	return dm;
}
public void setDm(DBManager dm) {
	this.dm = dm;
}
public modelManager getMm() {
	return mm;
}
public void setMm(modelManager mm) {
	this.mm = mm;
}
public JButton getBreshow() {
	return breshow;
}
public void setBreshow(JButton breshow) {
	this.breshow = breshow;
}

}
