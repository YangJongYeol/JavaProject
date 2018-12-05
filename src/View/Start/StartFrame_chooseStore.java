package View.Start;

import Controller.StartController;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame_chooseStore extends JPanel {
    StartController controller;
    public StartFrame_chooseStore(StartController controller) {
        System.setProperty("teamdev.license.info", "true");
        this.controller = controller;

//        JButton button = new JButton("Button_store");
//        button.setBounds(10,10,10,10);
//        button.addActionListener(new MyActionListener());

        JPanel panel = new JPanel(new GridLayout(3,1));

        JButton button_konkuk = new JButton("건대입구점");
        button_konkuk.addActionListener(new MyActionListener());
        JButton button_rodeo = new JButton("건대로데오점");
        button_rodeo.addActionListener(new MyActionListener());
        JButton button_sejong = new JButton("세종대점");
        button_sejong.addActionListener(new MyActionListener());

        panel.add(button_konkuk);
        panel.add(button_rodeo);
        panel.add(button_sejong);

        add(panel, BorderLayout.CENTER);
//        add(button, BorderLayout.EAST);

        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            controller.change("delivery");
            controller.setOrder_market(e.getActionCommand());
        }
    }
}
