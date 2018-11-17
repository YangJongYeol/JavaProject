package View.Start;

import Controller.StartController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame_setLocation extends JPanel {
    private StartController controller;
    private JButton button;
    private JTextField textField;

    public StartFrame_setLocation(StartController controller) {
        this.controller = controller;
        JLabel label = new JLabel("주소를 입력하세요.");

        textField = new JTextField(20);
        textField.addActionListener(new MyActionListener());

        button = new JButton("Button_location");
        button.setBounds(10,10,10,10);
        button.addActionListener(new MyActionListener());

        add(label);
        add(textField);
        add(button);

        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (textField.getText() != null)
                controller.setOrder_address(textField.getText());
            else
                controller.setOrder_address("empty");
            controller.change("store");
        }
    }
}
