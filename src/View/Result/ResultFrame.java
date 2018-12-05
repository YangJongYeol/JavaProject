package View.Result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import Controller.ResultController;
import Controller.StartController;
import Model.Content;
import Model.Order;

public class ResultFrame extends JPanel {
	private ResultController controller;
	private Order order;
	
	public ResultFrame(ResultController controller, Order order) {
		this.controller = controller;
		this.order = order;
		
		
		
		//Field
		JLabel titleLabel = new JLabel("<html>주문을 완료하였습니다!!<br></html>");
		
		JButton backButton = new JButton("뒤로");
		backButton.setBounds(10,10,10,10);
		backButton.setActionCommand("back");
        backButton.addActionListener(new MyActionListener());
        
        JLabel orderLabel = new JLabel("");
        orderLabel.setText("매장: " + order.getMarket() + "  　주소" + order.getAddress());
        add(titleLabel);
        add(backButton);
        add(orderLabel);
        setVisible(true);
	}
	
	class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (e.getActionCommand().equals("back")) {
        		StartController startController = new StartController();
        		startController.change("recommend");
            } 
    		
        }
        
    }
    
}
