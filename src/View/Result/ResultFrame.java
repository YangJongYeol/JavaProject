package View.Result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import Controller.ResultController;
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
        backButton.addActionListener(new MyActionListener());
        
        JLabel orderLabel = new JLabel("");
        orderLabel.setText("매장: " + order.getMarket() + "주소" + order.getAddress());
        add(titleLabel);
        add(backButton);
        add(orderLabel);
        setVisible(true);
	}
	
	class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	/*
        	JOptionPane.showMessageDialog(controller ,"click");
        	
        	//step의 입력값(setActionCommand로 입력한 값)에 따라서 다른 데이터 출력)
        	String command = e.getActionCommand();
        	if (e.getActionCommand().equals(command)) {
        		int step = Integer.parseInt(command);
        		ArrayList<Content> arrayList = new ArrayList<Content>();
        		arrayList = controller.getList(step);
        		Iterator<Content> Iterator = arrayList.iterator();
        		//Iterator를 통해 값 반환
        		while (Iterator.hasNext()) {
        			//System.out.println(Iterator.next().getId());
        			System.out.println(Iterator.next().getTitle());
        			//System.out.println(Iterator.next().getImg());
         		}
    		}
    		*/
        }
        
    }
    
}
