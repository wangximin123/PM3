package service;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import control.ProductManager;
import dao.ProductDao;
import model.Product;
import view.ProductFrame;

public class ProductService {
	Object[][] productObj;
	ProductDao productDao=new ProductDao();
	public Object[][] getObjFromList(String[] s,ArrayList<Product> al){
		productObj=new Object[20][s.length];
		for(int i=0;i<al.size();i++) {
			Product p=al.get(i);
			int j=0;
			while(j<s.length) {
				if(s[j].equals("pid")) {
					productObj[i][j]=p.getPid();
				}
				else if(s[j].equals("pname")) {
					productObj[i][j]=p.getPname();
				}
				else if(s[j].equals("pprice")) {
					productObj[i][j]=p.getPprice();
				}
				else if(s[j].equals("pquantity")) {
					productObj[i][j]=p.getPquantity();
				}
				else if(s[j].equals("sid")) {
					productObj[i][j]=p.getSid();
				}
				else if(s[j].equals("cid")) {
					productObj[i][j]=p.getCid();
				}
				else if(s[j].equals("cuid")) {
					productObj[i][j]=p.getCuid();
				}
				else if(s[j].equals("tid")) {
					productObj[i][j]=p.getPname();
				}
				j++;
			}
		}
		return productObj;
	}
	public void tableMouse(ProductFrame productFrame) {
		int row=productFrame.getTable().getSelectedRow();
		String pid,pname;
		float pprice;
		int pquantity;
		pid=(String)productFrame.getTableObj()[row][0];
		pname=(String)productFrame.getTableObj()[row][1];
		pprice=(Float)productFrame.getTableObj()[row][2];
		pquantity=(Integer)productFrame.getTableObj()[row][3];
		productFrame.getTid().setText(pid);
		productFrame.getTname().setText(pname);
		productFrame.getTprice().setText(String.valueOf(pprice));
		productFrame.getTquantity().setText(String.valueOf(pquantity));
	}
	public void add(ProductFrame productFrame) {
		Product p=new Product();
		p.setPid(productFrame.getTid().getText());
		p.setPname(productFrame.getTname().getText());
		p.setPprice(Float.valueOf(productFrame.getTprice().getText()));
		p.setPquantity(Integer.valueOf(productFrame.getTquantity().getText()));
		productDao.insert(p);
	}
	public void delete(ProductFrame productFrame) {
		int row=productFrame.getTable().getSelectedRow();
		String pid=(String)productFrame.getTable().getValueAt(row, 0);
		productDao.delete(pid);
	}
	public void reshow(ProductFrame productFrame) {
		productFrame.tableInit();
		final DefaultTableModel dtm=new DefaultTableModel();
		dtm.setDataVector(productFrame.getTableObj(), productFrame.getTableTitle());
		productFrame.getTable().setModel(dtm);
	}
	public void monify(ProductFrame productFrame) {
		int row=productFrame.getTable().getSelectedRow();
		String pid=(String) productFrame.getTable().getValueAt(row, 0);
		Product p=new Product();
		p.setPid(pid);
		p.setPname(productFrame.getTname().getText());
		p.setPprice(Float.valueOf(productFrame.getTprice().getText()));
		p.setPquantity(Integer.valueOf(productFrame.getTquantity().getText()));
		productDao.monify(p);
	}
}
