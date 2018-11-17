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

        setBounds(10,10,10,10);
        JButton button = new JButton("Button_store");
        button.setBounds(10,10,10,10);
        button.addActionListener(new MyActionListener());
        add(button);

        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.change("delivery");
        }
    }
}
