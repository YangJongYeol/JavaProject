package View.Result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import Controller.ResultController;
import Model.Content;

public class ResultFrame extends JPanel {
	private ResultController controller;
	public ResultFrame(ResultController controller) {
		this.controller = controller;
		
		//Field
		JLabel TitleLabel = new JLabel("결과");
		JButton backButton = new JButton("뒤로");
		
		backButton.setBounds(10,10,10,10);
        backButton.addActionListener(new MyActionListener());
        add(backButton);
        setVisible(true);
        
	}

	class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
        }
        
    }
}
