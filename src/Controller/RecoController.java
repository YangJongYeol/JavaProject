package Controller;

import View.Reco.RecoFrame;

import javax.swing.*;
import java.awt.*;

public class RecoController extends JFrame {
    private RecoFrame reco;

    public RecoController(JFrame frame) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(frame.getContentPane());
        this.reco = new RecoFrame(this);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension =  toolkit.getScreenSize(); // screen information
        setBounds(0 , 0 , (int)dimension.getWidth() , (int)dimension.getHeight());
        
        System.out.println("");

        setVisible(true);
    }

    public void change(String frameName) {
        if (frameName.equals("reco")) {
            getContentPane().removeAll();
            getContentPane().add(reco);
            revalidate();
            repaint();
        }
    }
}
