package view;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.ProductListener;
import control.ProductManager;

public class ProductFrame extends JFrame{
	JTable table;
	JTextField tid,tname,tprice,tquantity;
	JComboBox ccompany;
	JButton badd,bdelete,bmonify,bout,breshow;
	Object[][] tableObj=new Object[20][4];
	String[] tableTitle= {"编号","名称","价格","数量"};
	Box box;
	ProductManager productManager=new ProductManager();
	ProductListener pl=new ProductListener(this);
	public ProductFrame() {
		this.setVisible(true);
		this.setBounds(200, 200, 900, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tableInit();
		init();
		setListener();
		this.validate();
	}
	public void tableInit() {
		
		String[] s= {"pid","pname","pprice","pquantity"};
		tableObj=new Object[20][s.length];
		tableObj=productManager.getObjFromList(s);
	}
	public void setListener() {
		badd.setActionCommand("badd");
		badd.addActionListener(pl);
		
		table.addMouseListener(pl);
		
		bdelete.setActionCommand("bdelete");
		bdelete.addActionListener(pl);
		
		breshow.setActionCommand("breshow");
		breshow.addActionListener(pl);
		
		bmonify.setActionCommand("bmonify");
		bmonify.addActionListener(pl);
	}
	public void init() {
		box=Box.createVerticalBox();
		table=new JTable(tableObj,tableTitle);
		box.add(new JScrollPane(table));
		
		JLabel lid=new JLabel("商品编号");
		tid=new JTextField(10);
		JLabel lname=new JLabel("商品名称");
		tname=new JTextField(10);
		JLabel lprice=new JLabel("商品价格");
		tprice=new JTextField(10);
		JLabel lquantity=new JLabel("商品数量");
		tquantity=new JTextField(10);
		JPanel p1=new JPanel();
		p1.add(lid);
		p1.add(tid);
		p1.add(lname);
		p1.add(tname);
		p1.add(lprice);
		p1.add(tprice);
		p1.add(lquantity);
		p1.add(tquantity);
		box.add(p1);
		
		JPanel p2=new JPanel();
		badd=new JButton("添加");
		bdelete=new JButton("删除");
		bmonify=new JButton("修改");
		breshow=new JButton("刷新");
		bout=new JButton("退出");
		p2.add(badd);
		p2.add(bdelete);
		p2.add(bmonify);
		p2.add(breshow);
		p2.add(bout);
		box.add(p2);
		this.add(box);
	}
	public static void main(String[] args) {
		new ProductFrame();
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JTextField getTid() {
		return tid;
	}
	public void setTid(JTextField tid) {
		this.tid = tid;
	}
	public JTextField getTname() {
		return tname;
	}
	public void setTname(JTextField tname) {
		this.tname = tname;
	}
	public JTextField getTprice() {
		return tprice;
	}
	public void setTprice(JTextField tprice) {
		this.tprice = tprice;
	}
	public JTextField getTquantity() {
		return tquantity;
	}
	public void setTquantity(JTextField tquantity) {
		this.tquantity = tquantity;
	}
	public JComboBox getCcompany() {
		return ccompany;
	}
	public void setCcompany(JComboBox ccompany) {
		this.ccompany = ccompany;
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
	public JButton getBout() {
		return bout;
	}
	public void setBout(JButton bout) {
		this.bout = bout;
	}
	public Object[][] getTableObj() {
		return tableObj;
	}
	public void setTableObj(Object[][] tableObj) {
		this.tableObj = tableObj;
	}
	public String[] getTableTitle() {
		return tableTitle;
	}
	public void setTableTitle(String[] tableTitle) {
		this.tableTitle = tableTitle;
	}
	public Box getBox() {
		return box;
	}
	public void setBox(Box box) {
		this.box = box;
	}
	
}
