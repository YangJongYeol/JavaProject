package Controller;

import javax.swing.JFrame;

import Model.Order;
import View.Result.ResultFrame;

public class ResultController extends JFrame {
	private ResultFrame result;
	private Order order = null;

	public ResultController(JFrame frame, Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setContentPane(frame.getContentPane());
		this.result = new ResultFrame(this, order);
		this.order = order;
		System.out.println(order);
		//getOrder(order);
	}

	/*
	 * public void change(String frameName) { if (frameName.equals("reco") ||
	 * frameName.equals("complete")) { getContentPane().removeAll();
	 * getContentPane().add(reco); revalidate(); repaint(); } else
	 * if(frameName.equals("result")) { getContentPane().removeAll();
	 * getContentPane().add(result); revalidate(); repaint(); } }
	 */
	
	public Order getOrder() {
		System.out.println(order);
		return order;
	}
	
}
