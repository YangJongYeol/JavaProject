package Controller;

import Model.Order;
import View.Start.*;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.LoadURLParams;
import com.teamdev.jxbrowser.chromium.events.ScriptContextAdapter;
import com.teamdev.jxbrowser.chromium.events.ScriptContextEvent;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

//import com.mysql.*;

public class StartController extends JFrame {
    private Order order;
    private StartFrame_setLocation setLocation;
    private StartFrame_chooseStore chooseStore;
    private StartFrame_chooseDelivery chooseDelivery;
    private StartFrame_chooseRecommend chooseRecommend;
//    private Connection connection = null;
//    private Statement statement = null;

    public StartController() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation = new StartFrame_setLocation(this);
        this.chooseStore = new StartFrame_chooseStore(this);
        this.chooseDelivery = new StartFrame_chooseDelivery(this);
        this.chooseRecommend = new StartFrame_chooseRecommend(this);
        this.order = new Order(false, "");

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
            Browser browser = new Browser();
            BrowserView browserView = new BrowserView(browser);
            getContentPane().add(browserView, BorderLayout.CENTER);
//            browser.loadURL("http://localhost:8000/map.html");
            browser.loadURL("http://localhost:8000/map.html?"+order.getAddress());
            getContentPane().add(chooseStore, BorderLayout.EAST);
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
            RecoController recoController = new RecoController(this, order);
            recoController.change("reco");
            dispose();
        } else if (frameName.equals("self")) {
            SelfController selfController = new SelfController(this, order);
            selfController.change("self");
            dispose();
        }
    }

    public void setOrder_address(String orderAddress) {
        this.order.setAddress(orderAddress);
        System.out.println(this.order.getAddress());
    }
}
