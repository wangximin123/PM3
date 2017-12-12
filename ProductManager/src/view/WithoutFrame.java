package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WithoutFrame extends JFrame{
	JMenuBar menu;
	JMenu base,buy,sale,statistics;
	JMenuItem base_product,base_saler,base_customer,base_company,buy_buy,buy_nobuy,sale_sale,sale_nosale,statistics_company,
			  statistics_customer,statistics_quantity,statistics_buy;
	public WithoutFrame() {
		this.setVisible(true);
		this.setBounds(200, 200, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		validate();
	}
	public void init() {
		menu=new JMenuBar();
		base=new JMenu("��������");
		base_product=new JMenuItem("��Ʒ����");
		base_saler=new JMenuItem("����Ա����");
		base_customer=new JMenuItem("�ͻ�����");
		base_company=new JMenuItem("��Ӧ�̹���");
		base.add(base_product);
		base.add(base_saler);
		base.add(base_customer);
		base.add(base_company);
		buy=new JMenu("�ɹ�����");
		buy_buy=new JMenuItem("�ɹ�����");
		buy_nobuy=new JMenuItem("�ɹ��˻�");
		buy.add(buy_buy);
		buy.add(buy_nobuy);
		sale=new JMenu("���۹���");
		sale_sale=new JMenuItem("���۹���");
		sale_nosale=new JMenuItem("�����˻�");
		sale.add(sale_sale);
		sale.add(sale_nosale);
		statistics=new JMenu("ͳ�ƹ���");
		statistics_company=new JMenuItem("��Ӧ�̽��׼�¼");
		statistics_customer=new JMenuItem("�ͻ�����");
		statistics_quantity=new JMenuItem("����ѯ");
		statistics_buy=new JMenuItem("�ɹ�����");
		statistics.add(statistics_company);
		statistics.add(statistics_customer);
		statistics.add(statistics_quantity);
		statistics.add(statistics_buy);
		menu.add(base);
		menu.add(buy);
		menu.add(sale);
		menu.add(statistics);
		this.setJMenuBar(menu);
	}
	public static void main(String[] args) {
		new WithoutFrame();
	}
	public JMenuBar getMenu() {
		return menu;
	}
	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}
	public JMenu getBase() {
		return base;
	}
	public void setBase(JMenu base) {
		this.base = base;
	}
	public JMenu getBuy() {
		return buy;
	}
	public void setBuy(JMenu buy) {
		this.buy = buy;
	}
	public JMenu getSale() {
		return sale;
	}
	public void setSale(JMenu sale) {
		this.sale = sale;
	}
	public JMenu getStatistics() {
		return statistics;
	}
	public void setStatistics(JMenu statistics) {
		this.statistics = statistics;
	}
	public JMenuItem getBase_product() {
		return base_product;
	}
	public void setBase_product(JMenuItem base_product) {
		this.base_product = base_product;
	}
	public JMenuItem getBase_saler() {
		return base_saler;
	}
	public void setBase_saler(JMenuItem base_saler) {
		this.base_saler = base_saler;
	}
	public JMenuItem getBase_customer() {
		return base_customer;
	}
	public void setBase_customer(JMenuItem base_customer) {
		this.base_customer = base_customer;
	}
	public JMenuItem getBase_company() {
		return base_company;
	}
	public void setBase_company(JMenuItem base_company) {
		this.base_company = base_company;
	}
	public JMenuItem getBuy_buy() {
		return buy_buy;
	}
	public void setBuy_buy(JMenuItem buy_buy) {
		this.buy_buy = buy_buy;
	}
	public JMenuItem getBuy_nobuy() {
		return buy_nobuy;
	}
	public void setBuy_nobuy(JMenuItem buy_nobuy) {
		this.buy_nobuy = buy_nobuy;
	}
	public JMenuItem getSale_sale() {
		return sale_sale;
	}
	public void setSale_sale(JMenuItem sale_sale) {
		this.sale_sale = sale_sale;
	}
	public JMenuItem getSale_nosale() {
		return sale_nosale;
	}
	public void setSale_nosale(JMenuItem sale_nosale) {
		this.sale_nosale = sale_nosale;
	}
	public JMenuItem getStatistics_company() {
		return statistics_company;
	}
	public void setStatistics_company(JMenuItem statistics_company) {
		this.statistics_company = statistics_company;
	}
	public JMenuItem getStatistics_customer() {
		return statistics_customer;
	}
	public void setStatistics_customer(JMenuItem statistics_customer) {
		this.statistics_customer = statistics_customer;
	}
	public JMenuItem getStatistics_quantity() {
		return statistics_quantity;
	}
	public void setStatistics_quantity(JMenuItem statistics_quantity) {
		this.statistics_quantity = statistics_quantity;
	}
	public JMenuItem getStatistics_buy() {
		return statistics_buy;
	}
	public void setStatistics_buy(JMenuItem statistics_buy) {
		this.statistics_buy = statistics_buy;
	}
	
}
