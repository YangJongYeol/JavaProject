package Controller;

import Model.Order;
import View.Reco.RecoFrame;

import javax.swing.*;
import java.awt.*;


public class RecoController extends JFrame {
    private RecoFrame reco;
    private Order order;

    //Controller 초기화
    public RecoController(JFrame frame, Order order) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(frame.getContentPane());
        this.reco = new RecoFrame(this);
        this.order = order;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension =  toolkit.getScreenSize(); // screen information
        setBounds(0 , 0 , (int)dimension.getWidth() , (int)dimension.getHeight());

        setVisible(true);
    }

    //View 변경하기
    public void change(String frameName) {
        if (frameName.equals("reco")) {
            getContentPane().removeAll();
            getContentPane().add(reco);
            revalidate();
            repaint();
        }
    }
}
