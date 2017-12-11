package control;
import java.util.ArrayList;

import model.*;
public class modelManager {
ArrayList<Product> productList;
ArrayList<Table> tableList;
Object[][] productGroup=new Object[20][4];
Object[][] tableGroup=new Object[20][2];
	
	public ArrayList<Product> getProductList(){
		return productList;
	}
	public ArrayList<Table> getTableList(){
		return tableList;
	}
	public Object[][] getFromProductList(ArrayList<Product> al){
		productList=al;
		productGroup=new Object[20][4];
		Object[] obj=productList.toArray();
		for(int i=0;i<obj.length;i++){
			Product p=(Product)obj[i];
			productGroup[i][0]=p.getId();
			productGroup[i][1]=p.getName();
			productGroup[i][2]=p.getPrice();
			productGroup[i][3]=p.getQuantity();
		}
		
		return productGroup;
	}
	public Object[][] getFromTableList(ArrayList<Table> al){
		tableList=al;
		Object[] obj=tableList.toArray();
		tableGroup=new Object[20][2];
		for(int i=0;i<obj.length;i++){
			Table p=(Table)obj[i];
			tableGroup[i][0]=p.getDate();
			tableGroup[i][1]=p.getMoney();	
		}
		return tableGroup;
	}
//	public Object[][] getFromItemList(ArrayList<Item> al){
//		Object[][] result=new Object[20][];
//		Object[] obj=al.toArray();
//		for(int i=0;i<obj.length;i++){
//			Item item=(Item)obj[i];
//			reslut[i][0]=item.g
//		}
//		return result;
//		
//	}
	
}
