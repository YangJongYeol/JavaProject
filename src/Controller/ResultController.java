package Controller;

import javax.swing.JFrame;

import Model.Order;
import View.Result.ResultFrame;
import View.Start.StartFrame_chooseRecommend;

public class ResultController extends JFrame {
	private ResultFrame result;
	private Order order = null;
	private StartController startController = new StartController();
	private StartFrame_chooseRecommend recommend = new StartFrame_chooseRecommend();

	public ResultController(JFrame frame, Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setContentPane(frame.getContentPane());
		this.result = new ResultFrame(this, order);
		System.out.println(order);

	}

	public void change(String frameName) {
		if (frameName.equals("change")) {
			getContentPane().removeAll();
			getContentPane().add(recommend);
			revalidate();
			repaint();
		}
	}

	public Order getOrder() {
		System.out.println(order);
		return order;
	}

}
