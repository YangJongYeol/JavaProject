package View.Reco;

import Controller.RecoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecoFrame extends JPanel {
    private RecoController controller;

    public RecoFrame(RecoController controller) {
        this.controller = controller;
        JButton button = new JButton("Button_Reco");
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
