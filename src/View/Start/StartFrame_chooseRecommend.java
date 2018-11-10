package View.Start;

import Controller.StartController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame_chooseRecommend extends JPanel {
    StartController controller;
    public StartFrame_chooseRecommend(StartController controller) {
        this.controller = controller;
        JButton button_yes = new JButton("Button_recommend_yes");
        button_yes.setBounds(10,10,10,10);
        button_yes.setActionCommand("yes");
        button_yes.addActionListener(new MyActionListener());

        JButton button_no = new JButton("Button_recommend_no");
        button_no.setBounds(10,10,10,10);
        button_no.setActionCommand("no");
        button_no.addActionListener(new MyActionListener());

        add(button_yes);
        add(button_no);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("yes")) {
                controller.change("reco");
            } else {
                controller.change("self");
            }
        }
    }
}
