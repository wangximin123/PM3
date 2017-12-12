package control;

import dao.ProductDao;
import service.ProductService;

public class ProductManager {
	ProductDao productDao=new ProductDao();
	Object[][] productObj;
	ProductService productService=new ProductService();
	public Object[][] getObjFromList(String[] s){
		productObj=new Object[20][s.length];
		productObj=productService.getObjFromList(s, productDao.getListFromMysql());
		return productObj;
	}
}
