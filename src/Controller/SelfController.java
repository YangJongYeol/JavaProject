package Controller;

import Model.Order;
import Model.Content;
import Model.Ingredient;
import View.Result.ResultFrame;
import View.Self.SelfFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SelfController extends JFrame {
	private Model.Ingredient model;
	private SelfFrame self = null;
	private Order order = null;
	private ResultFrame result = null;

	public SelfController(JFrame frame, Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.self = new SelfFrame(this);
		this.order = order;
		this.result = new ResultFrame(new ResultController(frame, order), order);

		System.out.println(order);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize(); // screen information
		setBounds(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight());

		setVisible(true);
	}

	public void change(String frameName) {
		if (frameName.equals("self")) {
			getContentPane().removeAll();
			getContentPane().add(self);
			revalidate();
			repaint();
		} else if (frameName.equals("result")) {
			getContentPane().removeAll();
			getContentPane().add(result);
			revalidate();
			repaint();
		}
	}

	public ArrayList<Content> getList(int level) {
		ArrayList<Content> arrayList = new ArrayList<Content>();
		Iterator<Content> Iterator = arrayList.iterator();
		Ingredient IngredientModel = new Ingredient();

		arrayList = IngredientModel.getIngredientByLevel(level);

		return arrayList;
	}

}