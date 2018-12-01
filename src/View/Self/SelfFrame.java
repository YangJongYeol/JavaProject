package View.Self;

import Controller.SelfController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelfFrame extends JPanel {
    private SelfController controller;

    public SelfFrame(SelfController controller) {
        this.controller = controller;
        JButton button = new JButton("Button_Self");
        button.setBounds(10,10,10,10);
        button.addActionListener(new MyActionListener());

        add(button);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(controller ,"click");
        }
    }
}




