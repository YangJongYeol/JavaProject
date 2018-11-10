package View.Start;

import Controller.StartController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame_setLocation extends JPanel {
    StartController controller;
    public StartFrame_setLocation(StartController controller) {
        this.controller = controller;
        JButton button = new JButton("Button_location");
        button.setBounds(10,10,10,10);
        button.addActionListener(new MyActionListener());

        add(button);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.change("store");
        }
    }
}
