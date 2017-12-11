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
				
		this.setTitle("��Ʒ����ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		this.setVisible(true);
		this.validate();
	}
	public void init(){
		jiben=new JMenu("��������");
		caigou=new JMenu("�ɹ�����");
		xiaoshou=new JMenu("���۹���");
		tongji=new JMenu("ͳ�ƹ���");
		xiaoshouyuanziliao=new JMenuItem("����Ա����",new ImageIcon("display2.png"));
		productManager=new JMenuItem("��Ʒ����",new ImageIcon("pen.jpg"));
		kehuziliao=new JMenuItem("�ͻ�����",new ImageIcon("doc.png"));
		gongyingshangziliao=new JMenuItem("��Ӧ������",new ImageIcon("download.png"));
		caigoutuihuo=new JMenuItem("�ɹ��˻�",new ImageIcon("download2.png"));
		xiaoshouguanli=new JMenuItem("���۹���",new ImageIcon("dvd.png"));
		xiaoshoutuihuo=new JMenuItem("�����˻�����",new ImageIcon("earth.png"));
		gongyingshangjiaoyi=new JMenuItem("��Ӧ�̽��׼�¼",new ImageIcon("edit.png"));
		kehujiaoyi=new JMenuItem("�ͻ�����",new ImageIcon("finder.png"));
		kucunchaxun=new JMenuItem("����ѯ",new ImageIcon("flower.png"));
		caigouhuizong=new JMenuItem("�ɹ�����",new ImageIcon("envelope.png"));
		buyManager=new JMenuItem("�ɹ�����",new ImageIcon("app.png"));
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
