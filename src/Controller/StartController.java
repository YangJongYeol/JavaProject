package Controller;

import View.Start.StartFrame_chooseDelivery;
import View.Start.StartFrame_chooseRecommend;
import View.Start.StartFrame_chooseStore;
import View.Start.StartFrame_setLocation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController extends JFrame {
    private StartFrame_setLocation setLocation;
    private StartFrame_chooseStore chooseStore;
    private StartFrame_chooseDelivery chooseDelivery;
    private StartFrame_chooseRecommend chooseRecommend;

    public StartController() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation = new StartFrame_setLocation(this);
        this.chooseStore = new StartFrame_chooseStore(this);
        this.chooseDelivery = new StartFrame_chooseDelivery(this);
        this.chooseRecommend = new StartFrame_chooseRecommend(this);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension =  toolkit.getScreenSize(); // screen information
        setBounds(0 , 0 , (int)dimension.getWidth() , (int)dimension.getHeight());

        setVisible(true);
    }

    public void change(String frameName) {
        if (frameName.equals("location")) {
            getContentPane().removeAll();
            getContentPane().add(setLocation);
            revalidate();
            repaint();
        } else if (frameName.equals("store")) {
            getContentPane().removeAll();
            getContentPane().add(chooseStore);
            revalidate();
            repaint();
        } else if (frameName.equals("delivery")) {
            getContentPane().removeAll();
            getContentPane().add(chooseDelivery);
            revalidate();
            repaint();
        } else if (frameName.equals("recommend")) {
            getContentPane().removeAll();
            getContentPane().add(chooseRecommend);
            revalidate();
            repaint();
        } else if (frameName.equals("reco")) {
            RecoController recoController = new RecoController(this);
            recoController.change("reco");
            dispose();
        } else if (frameName.equals("self")) {
            SelfController selfController = new SelfController(this);
            selfController.change("self");
            dispose();
        }
    }
}
