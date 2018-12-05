import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import Controller.StartController;
import Model.Content;
import Model.Ingredient;
import Model.Product;

import javax.swing.UIManager;



public class Main {
	
	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
	    java.util.Enumeration keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	        Object key = keys.nextElement();
	        Object value = UIManager.get(key);
	        if (value instanceof javax.swing.plaf.FontUIResource)
	            UIManager.put(key, f);
	    }
	}




	public static void main(String[] args) {
		setUIFont (new javax.swing.plaf.FontUIResource("NanumGothicBold", Font.PLAIN, 30));
		// write your code here
        System.out.println("java project");
        
        //ArrayList<Content> arrayList = new ArrayList<Content>();
//        Product product = new Product();
//        Ingredient IngredientModel = new Ingredient();
//        IngredientModel.connectDB();
//        product = IngredientModel.getRandomIngredientId();
//        System.out.println(product.toString());
        //arrayList = IngredientModel.getIngredientByLevel(1);
        //arrayList = IngredientModel.getIngredientById(1);
        //Iterator<Content> empIterator = arrayList.iterator();

		//while (empIterator.hasNext()) {
		//    System.out.println(empIterator.next().getImg());
		//}


        
        StartController startController = new StartController();
        //startController.change("location");
        startController.change("recommend");
    	
    }
}
