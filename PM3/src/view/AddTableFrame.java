package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.*;
import control.*;
public class AddTableFrame extends JFrame{
	JButton bcommit,bmonify,badd;
	JTextField tquantity,tprice,ttid;
	JComboBox cproduct;
	JTable table;
	ArrayList<Product> productList=new ArrayList<Product>();
	Object[] tableTitle={"商品编号","商品名称","商品总价","商品数量","供应商"};
	Object[] products,companys;
	Object[][] productObj=new Object[10][5];
	Box box;
	DBManager dm;
	SetListener sl=new SetListener(this);
	public AddTableFrame(){
		this.setBounds(200,200,700,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setProducts();
		this.setCompanys();
		this.init();
		Listener();
		validate();
	}
	public void Listener(){
		badd.setActionCommand("AddTableFrameAdd");
		badd.addActionListener(sl);
		
		cproduct.setActionCommand("AddTableFrameCproduct");
		cproduct.addActionListener(sl);
		
		bcommit.setActionCommand("AddTableFrameBcommit");
		bcommit.addActionListener(sl);
	}
	public void init(){
		box=Box.createVerticalBox();
		
		
		JPanel p1=new JPanel();
		JLabel lproduct=new JLabel("请选择商品");
		cproduct=new JComboBox(products);
		JLabel lquantity=new JLabel("采购数量");
		tquantity=new JTextField(10);
		JLabel lprice=new JLabel("商品单价");
		tprice=new JTextField(10);
		p1.add(lproduct);
		p1.add(cproduct);
		p1.add(lquantity);
		p1.add(tquantity);
		p1.add(lprice);
		p1.add(tprice);
		box.add(p1);
		
		
		
		JPanel p2=new JPanel();
		table=new JTable(productObj,tableTitle);
		p2.add(new JScrollPane(table));
		box.add(p2);
		
		
		JPanel p3=new JPanel();
		JLabel ltid=new JLabel("请输入产品单号");
		ttid=new JTextField(10);
		badd=new JButton("添加");
		bcommit=new JButton("提交");
		bmonify=new JButton("修改");
		
		p3.add(ltid);
		p3.add(ttid);
		p3.add(badd);
		
		
		p3.add(bcommit);
		p3.add(bmonify);
		box.add(p3);
		
		
		this.add(box);
	}
	public void setProducts(){
		dm=new DBManager("select * from product");
		try {
			ResultSet result=dm.getPst().executeQuery();
			int i=0;
			products=new Object[20];
			while(result.next()){
				String s=result.getString(3);
				products[i++]=s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setCompanys(){
		dm=new DBManager("select * from company");
		try {
			ResultSet result=dm.getPst().executeQuery();
			int i=0;
			companys=new Object[20];
			while(result.next()){
				String s=result.getString(2);
				companys[i++]=s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public JButton getBcommit() {
		return bcommit;
	}
	public void setBcommit(JButton bcommit) {
		this.bcommit = bcommit;
	}
	public JButton getBmonify() {
		return bmonify;
	}
	public void setBmonify(JButton bmonify) {
		this.bmonify = bmonify;
	}
	public JButton getBadd() {
		return badd;
	}
	public void setBadd(JButton badd) {
		this.badd = badd;
	}
	public JTextField getTquantity() {
		return tquantity;
	}
	public void setTquantity(JTextField tquantity) {
		this.tquantity = tquantity;
	}
	public JTextField getTprice() {
		return tprice;
	}
	public void setTprice(JTextField tprice) {
		this.tprice = tprice;
	}
	public JTextField getTtid() {
		return ttid;
	}
	public void setTtid(JTextField ttid) {
		this.ttid = ttid;
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
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	public Object[] getTableTitle() {
		return tableTitle;
	}
	public void setTableTitle(Object[] tableTitle) {
		this.tableTitle = tableTitle;
	}
	public Object[] getProducts() {
		return products;
	}
	public void setProducts(Object[] products) {
		this.products = products;
	}
	public Object[] getCompanys() {
		return companys;
	}
	public void setCompanys(Object[] companys) {
		this.companys = companys;
	}
	public Object[][] getProductObj() {
		return productObj;
	}
	public void setProductObj(Object[][] productObj) {
		this.productObj = productObj;
	}
	public Box getBox() {
		return box;
	}
	public void setBox(Box box) {
		this.box = box;
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
