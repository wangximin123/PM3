package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import service.ProductService;
import view.ProductFrame;

public class ProductListener implements ActionListener,MouseListener{
	ProductFrame productFrame;
	ProductService productService=new ProductService();
	public ProductListener(ProductFrame productFrame) {
		this.productFrame=productFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("badd")) {
			productService.add(productFrame);
		}
		else if(e.getActionCommand().equals("bdelete")) {
			productService.delete(productFrame);
		}
		else if(e.getActionCommand().equals("breshow")) {
			productService.reshow(productFrame);
		}
		else if(e.getActionCommand().equals("bmonify")) {
			productService.monify(productFrame);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==productFrame.getTable()) {
			productService.tableMouse(productFrame);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
