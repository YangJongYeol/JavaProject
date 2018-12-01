package View.Self;

import Controller.SelfController;
import Model.Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class SelfFrame extends JPanel {
    SelfController controller;
    
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
        setVisible(true);
        
    }

    
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	JOptionPane.showMessageDialog(controller ,"click");
            
        	if (e.getActionCommand().equals("1")) {
        		controller.getList(1);
    		}
        }
    }
    
}




