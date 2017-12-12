package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;

public class ProductDao {
	Connection conn;
	PreparedStatement pst;
	ArrayList<Product> al;
	
	public ArrayList<Product> getListFromMysql(){
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/productdatebase","root","wangximin123");
			pst=conn.prepareStatement("select * from product");
			ResultSet result=pst.executeQuery();
			al=new ArrayList<Product>();
			while(result.next()) {
				Product p=new Product();
				p.setPid(result.getString(1));
				p.setPname(result.getString(2));
				p.setPprice(result.getFloat(3));
				p.setPquantity(result.getInt(4));
				p.setSid(result.getString(5));
				p.setCid(result.getString(6));
				p.setCuid(result.getString(7));
				p.setTid(result.getString(8));
				al.add(p);
			}
			conn.close();
			pst.close();
			result.close();
			Product p1=new Product();
			p1=al.get(1);
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean insert(Product p) {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/productdatebase","root","wangximin123");
			pst=conn.prepareStatement("insert into product values(?,?,?,?,?,?,?,?)");
			pst.setString(1, p.getPid());
			pst.setString(2, p.getPname());
			pst.setFloat(3, p.getPprice());
			pst.setInt(4, p.getPquantity());
			pst.setString(5, p.getSid());
			pst.setString(6, p.getCid());
			pst.setString(7, p.getCuid());
			pst.setString(8, p.getTid());
			pst.executeUpdate();
			conn.close();
			pst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String pid) {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/productdatebase","root","wangximin123");
			pst=conn.prepareStatement("delete from product where pid=?");
			pst.setString(1, pid);
			pst.executeUpdate();
			conn.close();
			pst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean monify(Product p) {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/productdatebase","root","wangximin123");
			pst=conn.prepareStatement("update product set pname=?,pprice=?,pquantity=? where pid=?");
			pst.setString(1, p.getPname());
			pst.setFloat(2, p.getPprice());
			pst.setInt(3, p.getPquantity());
			pst.setString(4, p.getPid());
			pst.executeUpdate();
			conn.close();
			pst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
