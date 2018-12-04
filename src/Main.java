import java.util.ArrayList;
import java.util.Iterator;

import Controller.StartController;
import Model.Content;
import Model.Ingredient;
import Model.Product;

public class Main {
    public static void main(String[] args) {
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
        startController.change("recommend");
    	
    }
}
