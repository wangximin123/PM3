package view;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
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
import control.modelManager;

public class ProductFrame extends JFrame{
	JTable table;
	JTextField tid;
	JTextField tname;
	JTextField tprice;
	JTextField tnum;
	JComboBox ccompany;
	JButton badd,bdelete,bmonify,bout;
	Box box;
	Object[] title={"编号","名称","单价","数量"};
	Object[][] oos=new Object[10][4];
	Color mycolor=new Color(250,0,0);
	DBManager dm;
	ArrayList<Product> productList=new ArrayList<Product>();
	modelManager mm=new modelManager();
	SetListener sl=new SetListener(this);
	Object[] companyObj;
	public ProductFrame(){
		setBounds(200,200,800,350);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		init();
		validate();
		Listener();
setVisible(true);
	}
	public void Listener(){
		table.addMouseListener(sl);
		
		
		
		badd.setActionCommand("ProductFrameAdd");
		badd.addActionListener(sl);
		
		
		bdelete.setActionCommand("ProductFrameDelete");
		bdelete.addActionListener(sl);
		
		
		bmonify.setActionCommand("ProductFrameMonify");
		bmonify.addActionListener(sl);
	}
	public Object[][] initTableFromSql(){
		Object[][] oos=new Object[10][4];
		dm=new DBManager("select pid,pname,pprice,pquantity from product");
		try {
			ResultSet result=dm.getPst().executeQuery();
			while(result.next()){
				Product p=new Product();
				p.setId(result.getString(1));
				p.setName(result.getString(2));
				p.setPrice(result.getFloat(3));
				p.setQuantity(result.getInt(4));
				productList.add(p);
			}
			oos=mm.getFromProductList(productList);
			dm.close();
			return oos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void init(){
		box=Box.createVerticalBox();
		
		oos=initTableFromSql();
		table=new JTable(oos,title);
		box.add(new JScrollPane(table));
		
		
		JPanel p1=new JPanel();
		JLabel pid=new JLabel("商品编号");
		JLabel pname=new JLabel("商品名称");
		JLabel pprice=new JLabel("商品单价");
		JLabel pnum=new JLabel("商品数量");
		pid.setForeground(mycolor);
		pname.setForeground(mycolor);
		tid=new JTextField(10);
		tname=new JTextField(10);
		tprice=new JTextField(10);
		tnum=new JTextField(10);
		p1.add(pid);
		p1.add(tid);
		p1.add(pname);
		p1.add(tname);
		p1.add(pprice);
		p1.add(tprice);
		p1.add(pnum);
		p1.add(tnum);
		box.add(p1);
		
		JPanel p2=new JPanel();
		JLabel lcompany=new JLabel("请选择供应商");
		dm=new DBManager("select cname from company");
		try {
		ResultSet result=dm.getPst().executeQuery();
		int i=0;
		companyObj=new Object[20];
		while(result.next()){
			
			companyObj[i]=result.getString(1);
			i=i+1;
		}
		System.out.println(i);
		ccompany=new JComboBox(companyObj);
		badd=new JButton("新增");
		bdelete=new JButton("删除");
		bmonify=new JButton("修改");
		bout=new JButton("退出");
		JLabel tishi=new JLabel("红色为必须填");
		tishi.setForeground(mycolor);
		p2.add(lcompany);
		p2.add(ccompany);
		p2.add(tishi);
		p2.add(badd);
		p2.add(bdelete);
		p2.add(bmonify);
		p2.add(bout);
		box.add(p2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		add(box);
		
		
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public JTable getTable() {
		return table;
	}
	public JTextField getTid() {
		return tid;
	}
	public JTextField getTname() {
		return tname;
	}
	public JTextField getTprice() {
		return tprice;
	}
	public JTextField getTnum() {
		return tnum;
	}
	public JButton getBadd() {
		return badd;
	}
	public JButton getBdelete() {
		return bdelete;
	}
	public JButton getBmonify() {
		return bmonify;
	}
	public JButton getBout() {
		return bout;
	}
	public Box getBox() {
		return box;
	}
	
	public Object[][] getOos() {
		return oos;
	}
	public Color getMycolor() {
		return mycolor;
	}
	
	public DBManager getDm() {
		return dm;
	}
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public modelManager getMm() {
		return mm;
	}
	public void setOos(Object[][] oos) {
		this.oos = oos;
	}
	public SetListener getSl() {
		return sl;
	}
	public JComboBox getCcompany() {
		return ccompany;
	}
	
	
	
	
}
