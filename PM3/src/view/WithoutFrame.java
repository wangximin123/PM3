package view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.SetListener;

public class WithoutFrame extends JFrame{
	JMenu jiben,caigou,xiaoshou,tongji;
	JMenuBar Bar;
	JMenuItem productManager,buyManager,xiaoshouyuanziliao,kehuziliao,gongyingshangziliao,caigoutuihuo,
			xiaoshouguanli,xiaoshoutuihuo,gongyingshangjiaoyi,kehujiaoyi,kucunchaxun,caigouhuizong;
	SetListener sl=new SetListener();
	public WithoutFrame(){
		this.setLayout(new FlowLayout());
		this.setBounds(200, 200, 700, 450);
				
		this.setTitle("商品管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		this.setVisible(true);
		this.validate();
	}
	public void init(){
		jiben=new JMenu("基本资料");
		caigou=new JMenu("采购管理");
		xiaoshou=new JMenu("销售管理");
		tongji=new JMenu("统计管理");
		xiaoshouyuanziliao=new JMenuItem("销售员资料",new ImageIcon("display2.png"));
		productManager=new JMenuItem("商品资料",new ImageIcon("pen.jpg"));
		kehuziliao=new JMenuItem("客户资料",new ImageIcon("doc.png"));
		gongyingshangziliao=new JMenuItem("供应商资料",new ImageIcon("download.png"));
		caigoutuihuo=new JMenuItem("采购退货",new ImageIcon("download2.png"));
		xiaoshouguanli=new JMenuItem("销售管理",new ImageIcon("dvd.png"));
		xiaoshoutuihuo=new JMenuItem("销售退货管理",new ImageIcon("earth.png"));
		gongyingshangjiaoyi=new JMenuItem("供应商交易记录",new ImageIcon("edit.png"));
		kehujiaoyi=new JMenuItem("客户交易",new ImageIcon("finder.png"));
		kucunchaxun=new JMenuItem("库存查询",new ImageIcon("flower.png"));
		caigouhuizong=new JMenuItem("采购汇总",new ImageIcon("envelope.png"));
		buyManager=new JMenuItem("采购管理",new ImageIcon("app.png"));
		Bar=new JMenuBar();
		jiben.add(productManager);
		jiben.add(xiaoshouyuanziliao);
		jiben.add(kehuziliao);
		jiben.add(gongyingshangziliao);
		
		caigou.add(buyManager);
		caigou.add(caigoutuihuo);
		
		xiaoshou.add(xiaoshouguanli);
		xiaoshou.add(xiaoshoutuihuo);
		
		tongji.add(gongyingshangjiaoyi);
		tongji.add(kehujiaoyi);
		tongji.add(kucunchaxun);
		tongji.add(caigouhuizong);
		
		productManager.setActionCommand("WithoutFrameProductManager");
		productManager.addActionListener(sl);
		
		
		
		ImageIcon background=new ImageIcon("ProductGUI.jpg");
		JLabel label=new JLabel(background);
		label.setSize(700,450);
		this.add(label);
		
		
		
		buyManager.setActionCommand("WithoutFrameBuyManager");
		buyManager.addActionListener(sl);
		
		Bar.add(jiben);
		Bar.add(caigou);
		Bar.add(xiaoshou);
		Bar.add(tongji);
		this.setJMenuBar(Bar);
		
		
		
		
	}
	public static void main(String[] args) {
		new WithoutFrame();
	}
}
