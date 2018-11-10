package Controller;

import View.Self.SelfFrame;

import javax.swing.*;
import java.awt.*;

public class SelfController extends JFrame {
    private SelfFrame self;

    public SelfController(JFrame frame) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.self = new SelfFrame(this);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension =  toolkit.getScreenSize(); // screen information
        setBounds(0 , 0 , (int)dimension.getWidth() , (int)dimension.getHeight());

        setVisible(true);
    }

    public void change(String frameName) {
        if (frameName.equals("self")) {
            getContentPane().removeAll();
            getContentPane().add(self);
            revalidate();
            repaint();
        }
    }
}
