package Controller;

import View.Reco.RecoFrame;
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

    public RecoController(JFrame frame) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setContentPane(frame.getContentPane());
        this.reco = new RecoFrame(this);
        this.complete = new RecoComplete(this);

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
        }
    }
    
    public Product getRandomList() {
    	Product product = new Product();
    	Ingredient IngredientModel = new Ingredient();
    	
    	product = IngredientModel.getRandomIngredientId();
    	//Iterator<Content> Iterator = product.iterator();
  
 		return product;
    }
}