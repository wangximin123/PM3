package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Product;
import model.Table;
import view.AddTableFrame;
import view.BuyFrame;
import view.ProductFrame;
import view.SaleFrame;

public class SetListener implements ActionListener,MouseListener{
	ProductFrame productFrame;
	SaleFrame saleFrame;
	DBManager dm;
	Object[] title={"编号","名称","价格","数量","供应商"};
	Object[] title2={"编号","名称","价格","数量"};
	BuyFrame buyframe;
	AddTableFrame addTableFrame;
	Object[][] obj=new Object[20][5];
	static int saleFrameTable=0;
	int i=0;
	float money=0;
	public SetListener(SaleFrame saleFrame){
		this.saleFrame=saleFrame;
	}
	public SetListener(ProductFrame productFrame){
		this.productFrame=productFrame;		
	}
	public SetListener(BuyFrame buyframe){
		this.buyframe=buyframe;		
	}
	public SetListener(AddTableFrame addTableFrame){
		this.addTableFrame=addTableFrame;
	}
	public SetListener(){
			
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ProductFrameAdd")){
			DBManager dm1=new DBManager("select * from company where cname=?");
			String cid;
			ArrayList<Product> al=productFrame.getMm().getProductList();
			try {
			dm1.getPst().setString(1, productFrame.getCcompany().getSelectedItem().toString());
			ResultSet result=dm1.getPst().executeQuery();
			result.next();
			cid=result.getString(1);
				
			String id=productFrame.getTid().getText();
			String name=productFrame.getTname().getText();
			String price=productFrame.getTprice().getText();
			String quantity=productFrame.getTnum().getText();
			float fprice=Float.valueOf(price);
			int iquantity=Integer.valueOf(quantity);
			
			Product p=new Product();
			p.setId(id);
			p.setCid(cid);
			p.setName(name);
			p.setPrice(fprice);
			p.setQuantity(iquantity);
			al.add(p);
			
			Object[][] obj=productFrame.getOos();
			obj=productFrame.getMm().getFromProductList(productFrame.getProductList());
			dm=new DBManager("insert product(pid,cid,pname,pprice,pquantity,tid) values(?,?,?,?,?,?)");
			
				dm.getPst().setString(1,p.getId());
				dm.getPst().setString(2,p.getCid());
				dm.getPst().setString(3, p.getName());
				dm.getPst().setFloat(4, p.getPrice());
				dm.getPst().setInt(5, p.getQuantity());
				dm.getPst().setString(6, p.getTid());
				dm.getPst().executeUpdate();
				dm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			final DefaultTableModel dtm=new DefaultTableModel();
			dtm.setDataVector(productFrame.getMm().getFromProductList(al), title2);
			productFrame.getTable().setModel(dtm);
			
		}
		else if(e.getActionCommand().equals("ProductFrameDelete")){
			ArrayList<Product> al=productFrame.getMm().getProductList();
			int row=productFrame.getTable().getSelectedRow();
			dm=new DBManager("delete from product where pid=?");
			try {
				dm.getPst().setString(1, al.get(row).getId());
				dm.getPst().executeUpdate();
				dm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			al.remove(row);		
			final DefaultTableModel dtm=new DefaultTableModel();
			dtm.setDataVector(productFrame.getMm().getFromProductList(al), title2);
			productFrame.getTable().setModel(dtm);
			
			
		}
		else if(e.getActionCommand().equals("ProductFrameMonify")){
			int row=productFrame.getTable().getSelectedRow();
			ArrayList<Product> al=productFrame.getMm().getProductList();
			
			String id=productFrame.getTid().getText();
			String name=productFrame.getTname().getText();
			String price=productFrame.getTprice().getText();
			String quantity=productFrame.getTnum().getText();
			float fprice=Float.valueOf(price);
			int iquantity=Integer.valueOf(quantity);
			Product p=new Product();
			p.setId(id);
			p.setName(name);
			p.setPrice(fprice);
			p.setQuantity(iquantity);
			
			
			dm=new DBManager("update product set cid=?,pname=?,pprice=?,pquantity=? where pid=?");
			
			try {
				dm.getPst().setString(1,p.getCid());
				dm.getPst().setString(2, p.getName());
				dm.getPst().setFloat(3, p.getPrice());
				dm.getPst().setInt(4, p.getQuantity());
				dm.getPst().setString(5,p.getId());
				dm.getPst().executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			al.set(row,p);
			final DefaultTableModel dtm=new DefaultTableModel();
			dtm.setDataVector(productFrame.getMm().getFromProductList(al), title);
			productFrame.getTable().setModel(dtm);
		}
		else if(e.getActionCommand().equals("WithoutFrameProductManager")){
			new ProductFrame();
		}
		else if(e.getActionCommand().equals("WithoutFrameBuyManager")){
			new BuyFrame();
		}
		else if(e.getActionCommand().equals("AddTableFrameAdd")){
			dm=new DBManager("select pid,cname from product,company where product.cid=company.cid and pname=?");
			try {
				dm.getPst().setString(1, addTableFrame.getCproduct().getSelectedItem().toString());
				ResultSet result=dm.getPst().executeQuery();
				result.next();
				obj[i][0]=result.getString(1);
				obj[i][1]=addTableFrame.getCproduct().getSelectedItem().toString();
				obj[i][2]=Float.valueOf(addTableFrame.getTprice().getText())*Float.valueOf(addTableFrame.getTquantity().getText());
				obj[i][3]=addTableFrame.getTquantity().getText();
				obj[i][4]=result.getString(2);
				i++;
				final DefaultTableModel dtm=new DefaultTableModel();
				dtm.setDataVector(obj, addTableFrame.getTableTitle());
				addTableFrame.getTable().setModel(dtm);
				dm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getActionCommand().equals("AddTableFrameCproduct")){
			dm=new DBManager("select pprice from product where pname=?");
			try {
				dm.getPst().setString(1, addTableFrame.getCproduct().getSelectedItem().toString());
				ResultSet result=dm.getPst().executeQuery();
				result.next();
				addTableFrame.getTprice().setText(result.getString(1));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				dm.close();
			}
		}
		else if(e.getActionCommand().equals("BuyFrameAdd")){
			new AddTableFrame();
		}
		else if(e.getActionCommand().equals("AddTableFrameBcommit")){
				dm=new DBManager("insert item(pid,tid,iprice,iquantity,cid) values(?,?,?,?,?)");
				int i=0;
				Float price=0f;
				while(obj[i][0]!=null){
				try {
					dm.getPst().setString(1, (String)obj[i][0]);
					dm.getPst().setString(2, addTableFrame.getTtid().getText());
					dm.getPst().setFloat(3, Float.valueOf(addTableFrame.getTprice().getText())*Float.valueOf(addTableFrame.getTquantity().getText()));
					dm.getPst().setInt(4, Integer.valueOf(addTableFrame.getTquantity().getText()));
					dm.getPst().setString(5, (String)obj[i][4]);
					dm.getPst().executeUpdate();
					price=price+Float.valueOf(addTableFrame.getTprice().getText())*Float.valueOf(addTableFrame.getTquantity().getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				i++;
				}
				dm=new DBManager("insert into tables values(?,?,?)");
				try {
					java.util.Date d=new java.util.Date();
					dm.getPst().setString(1, addTableFrame.getTtid().getText());
					dm.getPst().setDate(2, new Date(d.getTime()));
					dm.getPst().setFloat(3, price);
					dm.getPst().executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					dm.close();
				}
			
		}
		else if(e.getActionCommand().equals("BuyFrameDelete")){
			int row=buyframe.getTable().getSelectedRow();
			String tid=buyframe.getTableList().get(row).getId();
			dm=new DBManager("delete from tables where tid=?");
			try {
				dm.getPst().setString(1, tid);
				dm.getPst().executeUpdate();
				ArrayList<Table> al=buyframe.getTableList();
				al.remove(row);
				final DefaultTableModel dtm=new DefaultTableModel();
			dtm.setDataVector(buyframe.getMm().getFromTableList(al), buyframe.getTableTitle());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				dm.close();
			}
			dm=new DBManager("delete from item where tid=?");
			try {
				dm.getPst().setString(1, tid);
				dm.getPst().executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				dm.close();
			}
			
			
			
		}
		else if(e.getActionCommand().equals("BuyFrameReshow")){
			buyframe.initTableFromSql();
		}
		else if(e.getActionCommand().equals("SaleFrameAdd")){
			String quantity=saleFrame.getTquantity().getText();
			dm=new DBManager("select pid,pname,pprice from product where pname=?");
			Object[][] obj=saleFrame.getTableObj();
			
			
			try {
				dm.getPst().setString(1, saleFrame.getCproduct().getSelectedItem().toString());
				ResultSet result=dm.getPst().executeQuery();
				result.next();
				obj[saleFrameTable][0]=result.getString(1);
				obj[saleFrameTable][1]=result.getString(2);
				obj[saleFrameTable][2]=saleFrame.getTquantity().getText();
				obj[saleFrameTable][3]=result.getString(3);
				saleFrameTable++;
				money=money+Integer.valueOf(saleFrame.getTquantity().getText())*result.getFloat(3);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{dm.close();}
				saleFrame.getTyingfu().setText(String.valueOf(money));
			final DefaultTableModel dtm=new DefaultTableModel();
			dtm.setDataVector(obj, saleFrame.getTableTitle());
			saleFrame.getTable().setModel(dtm);
			
			
		}
		else if(e.getActionCommand().equals("SaleFrameCommit")){
			dm=new DBManager("insert product2(pid,pquantity,tid) values(?,?,?)");
			Object[][] obj=saleFrame.getTableObj();
			
			int i=0;
			while(obj[i][0]!=null){
				String pid=(String)obj[i][0];
				float pquantity=Float.valueOf((String)obj[i][2]);
				try {
					dm.getPst().setString(1, pid);
					dm.getPst().setFloat(2, pquantity);
					dm.getPst().setString(3, saleFrame.getTxiaoshou().getText());
					dm.getPst().executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				i++;
			}
			
			DBManager dm2=new DBManager("select sid from saler where sname=?");
			
			String tid=saleFrame.getTxiaoshou().getText();
			java.util.Date date=new java.util.Date();
			java.sql.Date d=new java.sql.Date(date.getTime());
			int tlabel=1;
			String sid=null;
			try {
				dm2.getPst().setString(1, saleFrame.getCid().getSelectedItem().toString());
				ResultSet result=dm2.getPst().executeQuery();
				result.next();
				sid=result.getString(1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{dm2.close();}
			DBManager dm3=new DBManager("insert into tables values(?,?,?,?,?)");
			try {
				dm3.getPst().setString(1, tid);
				dm3.getPst().setDate(2, d);
				dm3.getPst().setFloat(3, money);
				dm3.getPst().setInt(4, tlabel);
				dm3.getPst().setString(5, sid);
				dm3.getPst().executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{dm3.close();}
		}
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(productFrame!=null&&e.getSource()==productFrame.getTable()){
			int row = productFrame.getTable().getSelectedRow();
			Product p=productFrame.getMm().getProductList().get(row);
			productFrame.getTid().setText(p.getId()); 
			productFrame.getTname().setText(p.getName());
			productFrame.getTprice().setText(String.valueOf(p.getPrice()));
			productFrame.getTnum().setText(String.valueOf(p.getQuantity()));
		}
		
		
		else if(buyframe!=null&&e.getSource()==buyframe.getTable()){
			int row = buyframe.getTable().getSelectedRow();
			String tid=buyframe.getTableList().get(row).getId();
			int i=0;
			
			dm=new DBManager("select item.pid,pname,iprice,iquantity,cname from product,company,item,tables where tables.tid=item.tid and product.cid=company.cid and product.pid=item.pid and tables.tid=?");
			try {
				dm.getPst().setString(1, tid);
				ResultSet result=dm.getPst().executeQuery();
				obj=new Object[20][5];
				while(result.next()){
				obj[i][0]=result.getString(1);
				obj[i][1]=result.getString(2);
				obj[i][2]=result.getString(3);
				obj[i][3]=result.getString(4);
				obj[i][4]=result.getString(5);
				i++;
				}
				final DefaultTableModel dtm=new DefaultTableModel();
				dtm.setDataVector(obj, title);
				buyframe.getItem().setModel(dtm);
				dm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
