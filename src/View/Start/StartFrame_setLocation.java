package View.Start;

import Controller.StartController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame_setLocation extends JPanel {
    private StartController controller;
    private JTextField textField;
    JLabel img;
    ImageIcon[] i = {
          new ImageIcon("image2/subway.jpg")
    };
    
    
    public StartFrame_setLocation(StartController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        JLabel label = new JLabel("주소를 입력하세요.");
        img = new JLabel();
        img.setIcon(i[0]);
        this.add(img);
        
        textField = new JTextField(20);
        textField.setSize(500, 20);
        textField.addActionListener(new MyActionListener());
        
        panel1.add(img);
        panel2.add(label);
        panel2.add(textField);
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);

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