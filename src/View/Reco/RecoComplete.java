package View.Reco;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Controller.RecoController;
	
public class RecoComplete extends JPanel	{
	
		private RecoController controller;

	    private JRadioButton Spicy_I, Meat_B;
	    private JRadioButton Chicken_T, Steak_C;
	    private JRadioButton Italian_B, Egg_M, BLT;
	    JPanel panel1, panel2, panel3, panel4, panel5, categoryPanel, botPanel, topPanel;
	    //JTextField result = new JTextField("�޴��� �����ϼ���.", 20);
	    JButton order, cancel;
	    
	    public RecoComplete(RecoController controller) {
	    	this.controller = controller;
	    
	    	panel1 = new BestPanel();
	    	this.add(panel1, BorderLayout.WEST);
	    	panel2 = new MeatPanel();
	    	this.add(panel2, BorderLayout.CENTER);
	    	panel3 = new SpicyPanel();
	    	this.add(panel3,  BorderLayout.EAST);
	    	panel4 = new BotPanel();
	    	this.add(panel4, BorderLayout.SOUTH);
	    	panel5 = new TopPanel();
	    	this.add(panel5, BorderLayout.NORTH);
	    	
	    	//setTitle("�ϼ�ǰ ��õ");
	    	setSize(500, 500);
	    	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setVisible(true);
	    }
	    class SpicyPanel extends JPanel implements ActionListener{
	    	SpicyPanel(){
	        Spicy_I = new JRadioButton("�����̽���Ż����       ", true);
	        Meat_B = new JRadioButton("��Ʈ��");
	        ButtonGroup bg = new ButtonGroup();
	        bg.add(Spicy_I);
	        bg.add(Meat_B);
	        add(Spicy_I);
	        add(Meat_B);
	        bg.clearSelection();
	        Spicy_I.addActionListener(this);
	        Meat_B.addActionListener(this);
	        
	        categoryPanel = new JPanel();
	        categoryPanel.add(Spicy_I);
	        categoryPanel.add(Meat_B);
	        categoryPanel.setLayout(new GridLayout(2, 1));
	        Border border1 = BorderFactory.createTitledBorder("���޽����̽� Menu");
	        categoryPanel.setBorder(border1);
	        add(categoryPanel, BorderLayout.LINE_START);
	        setVisible(true);
	    	}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    }

		class MeatPanel extends JPanel implements ActionListener {
		
		public MeatPanel() { 
		Chicken_T = new JRadioButton("ġŲ�����߳�", true);
		Steak_C = new JRadioButton("������ũ��ġ��        ");
		ButtonGroup bg = new ButtonGroup();
	    bg.add(Chicken_T);
	    bg.add(Steak_C);
	    add(Chicken_T);
	    add(Steak_C);
	    bg.clearSelection();
	    Chicken_T.addActionListener(this);
	    Steak_C.addActionListener(this);
	    categoryPanel = new JPanel();
        categoryPanel.add(Chicken_T);
        categoryPanel.add(Steak_C);
        categoryPanel.setLayout(new GridLayout(2, 1));
        Border border2 = BorderFactory.createTitledBorder("���� Menu");
        categoryPanel.setBorder(border2);
        add(categoryPanel, BorderLayout.CENTER);
	    setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
		
		class BestPanel extends JPanel implements ActionListener {
			
		public BestPanel() { 
		Italian_B = new JRadioButton("��Ż���Ⱥ�Ƽ        ", true); 
		Egg_M = new JRadioButton("���׸���");
		BLT = new JRadioButton("BLT");
		ButtonGroup bg = new ButtonGroup();
	    bg.add(Italian_B);
	    bg.add(Egg_M);
	    bg.add(BLT);
	    add(Italian_B);
	    add(Egg_M);
	    add(BLT);
	    bg.clearSelection();
	    Italian_B.addActionListener(this);
	    Egg_M.addActionListener(this);
	    BLT.addActionListener(this);
	    categoryPanel = new JPanel();
        categoryPanel.add(Italian_B);
        categoryPanel.add(Egg_M);
        categoryPanel.add(BLT);
        categoryPanel.setLayout(new GridLayout(3, 1));
        Border border3 = BorderFactory.createTitledBorder("������� Best Menu");
        categoryPanel.setBorder(border3);
        add(categoryPanel, BorderLayout.LINE_END);
	    setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
		
		class BotPanel extends JPanel implements ActionListener { 
			
			public BotPanel() { 
				botPanel = new JPanel();
//				botPanel.add(result);
//				Border border4 = BorderFactory.createTitledBorder("");
//				result.setBorder(border4);
				
				//botPanel.setLayout(new GridLayout(2, 1));
				ButtonGroup bg = new ButtonGroup();
				order = new JButton("�ֹ��ϱ�");
				order.addActionListener(this);
				
				cancel = new JButton("���");
				cancel.addActionListener(this);
				bg.add(order);
				bg.add(cancel);
				botPanel.add(order);
				botPanel.add(cancel);
				add(botPanel, BorderLayout.SOUTH);
				setVisible(true);
			}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
			}
		
		class TopPanel extends JPanel{
			public TopPanel() {
				topPanel = new JPanel();
				JLabel top = new JLabel("�� ���� �������� �޴��� �����ϼ���");
				topPanel.add(top);
				add(topPanel, BorderLayout.NORTH);
				setVisible(true);
			}
		}
	}

