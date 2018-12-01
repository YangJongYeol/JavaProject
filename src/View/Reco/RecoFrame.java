package View.Reco;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.RecoController;

public class RecoFrame extends JPanel{
    private RecoController controller;
    JPanel panel1;
    JPanel panel2;
    JLabel label1;
    JLabel label2;
    
    public RecoFrame(RecoController controller) {
        this.controller = controller;
        
       // Container contentPane = new Container();
        
        panel1 = new JPanel();
        //contentPane.add(panel1);
        JButton button = new JButton("Button_Reco");
        //button.setBounds(10,10,10,10);
        button.addActionListener(new MyActionListener());
        
        panel1.add(button);
        //this.add(panel1, BorderLayout.NORTH);
        //setVisible(true);
        
        panel2 = new JPanel();
        //contentPane.add(panel2);
        JButton button1 = new JButton("Button_complete");
        //button1.setBounds(10, 10, 10, 10);
        button1.addActionListener(new MyActionListener());
        button1.setActionCommand("complete");
        
        label1 = new JLabel("�ϼ�ǰ ��õ?");
        panel2.add(label1);
        panel2.add(button1);
        //setVisible(true);
        

        
        //contentPane.add(panel1, BorderLayout.NORTH);
        //contentPane.add(panel2, BorderLayout.SOUTH);
       	this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        setVisible(true);
    }


	class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(controller ,"click");
            if(e.getActionCommand().equals("complete")){
            	controller.change("complete");
            } else if (e.getActionCommand().equals("reco")) {
            	controller.change("reco");
            }
        }
    }
}
