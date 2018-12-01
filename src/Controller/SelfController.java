package Controller;

import Model.Order;
import Model.Content;
import Model.Ingredient;
import View.Self.SelfFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SelfController extends JFrame {
    private Model.Ingredient model;
	private SelfFrame self = null;
    private Order order = null;

 
	public SelfController(JFrame frame, Order order) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.self = new SelfFrame(null);
        this.order = order;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension =  toolkit.getScreenSize(); // screen information
        setBounds(0 , 0 , (int)dimension.getWidth() , (int)dimension.getHeight());

        setVisible(true);
    }

    public void change(String frameName) {
        if (frameName.equals("self")) {
            getContentPane().removeAll();
            getContentPane().add(self);
            revalidate();
            repaint();
        }
    }
    
    public void getList(int level) {
    	ArrayList<Content> arrayList = new ArrayList<Content>();
    	Iterator<Content> Iterator = arrayList.iterator();
    	
    	model.connectDB();
    	arrayList = model.getIngredientByLevel(level);
    	
    	
    	//Iterator<Content> Iterator = arrayList.iterator();
    	//결과 Iterator.next().getImg()로 return
 		while (Iterator.hasNext()) {
 		    System.out.println(Iterator.next().getImg());
 		}
    }
    
    
}
