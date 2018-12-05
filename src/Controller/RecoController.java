package Controller;

import Model.Order;
import View.Reco.RecoFrame;
import View.Result.ResultFrame;
import View.Reco.RecoComplete;

import javax.swing.*;

import Model.Content;
import Model.Ingredient;
import Model.Product;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class RecoController extends JFrame {
    private RecoFrame reco;
    private RecoComplete complete;
    private Order order = null;

    public RecoController(JFrame frame, Order order) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setContentPane(frame.getContentPane());
        this.reco = new RecoFrame(this);
        this.complete = new RecoComplete(this);
        this.order = order;

        System.out.println(order);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension =  toolkit.getScreenSize(); // screen information
        setBounds(0 , 0 , (int)dimension.getWidth() , (int)dimension.getHeight());

        setVisible(true);
    }

    public void change(String frameName) {
        if (frameName.equals("reco")) {
            getContentPane().removeAll();
            getContentPane().add(reco);
            revalidate();
            repaint();
        } else if(frameName.equals("complete")) {
            getContentPane().removeAll();
            getContentPane().add(complete);
            revalidate();
            repaint();
        } else if(frameName.equals("result")) {
            getContentPane().removeAll();
            getContentPane().add(result);
            revalidate();
            repaint();
        }
    }
    
    public Product getRandomList() {
    	Product product = new Product();
    	Ingredient IngredientModel = new Ingredient();
    	
    	product = IngredientModel.getRandomIngredientId();
    	//Iterator<Content> Iterator = product.iterator();
  
 		return product;
    }
    
    public ArrayList<Content> getIngredientById(int id) {
    	ArrayList<Content> list = new ArrayList<Content>();
    	Ingredient IngredientModel = new Ingredient();
    	list = IngredientModel.getIngredientById(id);
    
    	return list;
    }
}