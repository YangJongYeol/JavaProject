package View.Self;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;


import Controller.SelfController;
import Model.Content;
import Model.Ingredient;

public class SelfFrame extends JPanel {
    private SelfController controller;
    
    public SelfFrame(SelfController controller) {
        this.controller = controller;
        JButton button = new JButton("Button_Self");
        button.setBounds(10,10,10,10);
        button.addActionListener(new MyActionListener());
        add(button);
        
        JButton button1 = new JButton("STEP1");
        button1.setBounds(10,10,10,10);
        button1.addActionListener(new MyActionListener());
        button1.setActionCommand("1");
        add(button1);
        JButton button2 = new JButton("STEP2");
        button2.setBounds(10,10,10,10);
        button2.addActionListener(new MyActionListener());
        button2.setActionCommand("2");
        add(button2);
        JButton button3 = new JButton("STEP3");
        button3.setBounds(10,10,10,10);
        button3.addActionListener(new MyActionListener());
        button3.setActionCommand("3");
        add(button3);
        JButton button4 = new JButton("STEP4");
        button4.setBounds(10,10,10,10);
        button4.addActionListener(new MyActionListener());
        button4.setActionCommand("4");
        add(button4);
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




