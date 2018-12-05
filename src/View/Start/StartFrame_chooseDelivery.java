package View.Start;

import Controller.StartController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame_chooseDelivery extends JPanel {
    StartController controller;
    public StartFrame_chooseDelivery(StartController controller) {
        this.controller = controller;

        JLabel label = new JLabel("딜리버리를 이용하실건가요?");

        JButton button_yes = new JButton("YES");
        button_yes.setBounds(10,10,10,10);
        button_yes.setActionCommand("yes");
        button_yes.addActionListener(new MyActionListener());

        JButton button_no = new JButton("NO");
        button_no.setBounds(10,10,10,10);
        button_no.setActionCommand("no");
        button_no.addActionListener(new MyActionListener());

        add(label);
        add(button_yes);
        add(button_no);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("yes")) {
                controller.setOrder_delivery(true);
            } else {
                controller.setOrder_delivery(false);
            }

            controller.change("recommend");
        }
    }
}
