package View.Self;

import Controller.SelfController;
import SelfView.JPanel011;
import SelfView.JPanel022;
import SelfView.JPanel033;
import SelfView.JPanel044;
import SelfView.JPanel055;
import SelfView.JPanel066;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;

public class SelfFrame extends JPanel implements ActionListener{
    private SelfController controller;

    public SelfFrame(SelfController controller) {
        this.controller = controller;
        JButton button = new JButton("Button_Self");
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
    
    class JPanel011 extends JPanel{
    	JRadioButton [] radio=new JRadioButton[8];
    	ButtonGroup group=new ButtonGroup();
    	String[] menu= {"��","��ġ","�ν�Ʈ ����","���׸���","��Ƽ","��Ʈ��","��Ű","����"};
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JPanel[] picturePanel=new JPanel[8];
    	JButton btn1;
    	CardLayout card=new CardLayout();
    	JLabel[] pictureLabel=new JLabel[8];
    	ImageIcon[] icon=new ImageIcon[8];
    	
    	JPanel011(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(3,4,20,10));
    		Border border = BorderFactory.createTitledBorder("���ϴ� ������ġ �޴��� �����ϼ���.");
    		panel1.setBorder(border);
    		this.add(panel1,BorderLayout.NORTH);
    		for(int i=0;i<menu.length;i++) {
    			radio[i]=new JRadioButton(menu[i]);
    			panel1.add(radio[i]);
    			group.add(radio[i]);
    			icon[i]=new ImageIcon("image/"+menu[i]+".jpg");
    			pictureLabel[i]=new JLabel("image/"+menu[i]+".jpg");
    		}		
    		this.add(panel2,BorderLayout.CENTER);
    		btn1=new JButton("����");
    		btn1.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				// TODO Auto-generated method stub
    					jtab.setSelectedIndex(1);
    					jtab.setEnabledAt(0,true);
    					jtab.setEnabledAt(1,true);
    			}
    			
    		});
    		panel2.add(btn1);
    		this.add(panel3,BorderLayout.SOUTH);
    	}

    	public void itemStateChanged(ItemEvent e) {
    		ImageIcon image=null;
    		Object source=e.getItemSelectable();
    		for(int i=0;i<icon.length;i++) {
    			if(source==radio[i]) {
    				if(e.getStateChange()==ItemEvent.DESELECTED)
    					pictureLabel[i].setIcon(null);
    				else
    					pictureLabel[i].setIcon(icon[i]);
    			}
    		}
    	}
    	
    }

    class JPanel022 extends JPanel{
    	String[] bread= {"��Ͽ�Ʈ","��Ƽ","��Ʈ","�ĸ���","ȭ��Ʈ","�÷��귡��"};
    	String[] size= {"15cm","30cm"};
    	JRadioButton[] radio1=new JRadioButton[6];
    	JRadioButton[] radio2=new JRadioButton[2];
    	ButtonGroup group1=new ButtonGroup();
    	ButtonGroup group2=new ButtonGroup();
    	JLabel label1;
    	JLabel tab1, tab2;
    	JLabel label2, help;
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel022(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(3,3,10,10));
    		Border border = BorderFactory.createTitledBorder("�� ���̿� ������ ���� �����ϼ���.");
    		panel1.setBorder(border);
    		this.add(panel1, BorderLayout.NORTH);
    		label1=new JLabel("�� ����:");
    		panel1.add(label1);
    		for(int i=0;i<size.length;i++) {
    			radio2[i]=new JRadioButton(size[i]);
    			panel1.add(radio2[i]);
    			group1.add(radio2[i]);
    		}
    		tab1=new JLabel("");
    		panel1.add(tab1);
    		label2=new JLabel("�� ����:");
    		panel1.add(label2);
    		int i;
    		for(i=0;i<3;i++) {
    			radio1[i]=new JRadioButton(bread[i]);
    			panel1.add(radio1[i]);
    			group2.add(radio1[i]);
    		}
    		tab2=new JLabel("");
    		panel1.add(tab2);
    		for(;i<bread.length;i++) {
    			radio1[i]=new JRadioButton(bread[i]);
    			panel1.add(radio1[i]);
    			group2.add(radio1[i]);
    		}
    		this.add(panel2,BorderLayout.CENTER);
    		btn1=new JButton("����");
    		btn1.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				// TODO Auto-generated method stub
    				jtab.setSelectedIndex(2);
    				jtab.setEnabledAt(0,true);
    				jtab.setEnabledAt(1,true);
    				jtab.setEnabledAt(2,true);
    			}
    			
    		});
    		panel2.add(btn1);
    		this.add(panel3,BorderLayout.SOUTH);
    	}
    }

    class JPanel033 extends JPanel{
    	JCheckBox [] checkbox=new JCheckBox[6];
    	String[] topping= {"���׸���","���ɷ�","�ƺ�ī��","������","���۷δ�","����ġ��"};
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel033(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(2,3,10,10));
    		Border border = BorderFactory.createTitledBorder("������ ���������� �����մϴ�.");
    		panel1.setBorder(border);
    		this.add(panel1, BorderLayout.NORTH);
    		for(int i=0;i<topping.length;i++) {
    			checkbox[i]=new JCheckBox(topping[i]);
    			panel1.add(checkbox[i]);
    		}
    		this.add(panel2, BorderLayout.CENTER);
    		btn1=new JButton("����");
    		btn1.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				// TODO Auto-generated method stub
    				jtab.setSelectedIndex(3);
    				jtab.setEnabledAt(0,true);
    				jtab.setEnabledAt(1,true);
    				jtab.setEnabledAt(2,true);
    				jtab.setEnabledAt(3,true);
    			}
    			
    		});
    		panel2.add(btn1);
    		this.add(panel3,BorderLayout.SOUTH);
    	}

    }

    class JPanel044 extends JPanel{
    	JCheckBox [] checkbox1=new JCheckBox[9];
    	String[] vege= {"�����","�丶��","����","�Ǹ�",
    			"����","��Ŭ","�ø���","�Ҷ��Ǵ�","�Ƹ޸�ĭġ��"};
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel044(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		Border border = BorderFactory.createTitledBorder("������ �ϴ� ��ä�� üũǥ�ø� Ǯ���ּ���.");
    		panel1.setBorder(border);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(3,3,10,10));
    		this.add(panel1,BorderLayout.NORTH);
    		for(int i=0;i<vege.length;i++) {
    			checkbox1[i]=new JCheckBox(vege[i]);
    			checkbox1[i].setSelected(true);
    			panel1.add(checkbox1[i]);
    		}
    		this.add(panel2, BorderLayout.CENTER);
    		btn1=new JButton("����");
    		btn1.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				// TODO Auto-generated method stub
    				jtab.setSelectedIndex(4);
    				jtab.setEnabledAt(0,true);
    				jtab.setEnabledAt(1,true);
    				jtab.setEnabledAt(2,true);
    				jtab.setEnabledAt(3,true);
    				jtab.setEnabledAt(4,true);
    			}
    			
    		});
    		panel2.add(btn1);
    		this.add(panel3,BorderLayout.SOUTH);
    	}

    }

    class JPanel055 extends JPanel{
    	JCheckBox[] checkbox=new JCheckBox[12];
    	String[] sauce= {"��ġ����","��ġ�巹��","�������","����Ʈ��Ͼ�",
    			"��ϸӽ�Ÿ��","����Ʈĥ��","��ĥ��","��콺����Ʈ","Ȧ������",
    			"��������Ϸ���","��Ż���ȵ巹��","����ũ�ٺ�ť"};
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel055(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		Border border = BorderFactory.createTitledBorder("���ϴ� �ҽ��� ����ּ���. �������� �����մϴ�");
    		panel1.setBorder(border);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(3,4,10,10));
    		this.add(panel1, BorderLayout.NORTH);;
    		for(int i=0;i<sauce.length;i++) {
    			checkbox[i]=new JCheckBox(sauce[i]);
    			panel1.add(checkbox[i]);
    		}
    	this.add(panel2, BorderLayout.CENTER);
    	btn1=new JButton("����");
    	btn1.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO Auto-generated method stub
    			jtab.setSelectedIndex(5);
    			jtab.setEnabledAt(0,true);
    			jtab.setEnabledAt(1,true);
    			jtab.setEnabledAt(2,true);
    			jtab.setEnabledAt(3,true);
    			jtab.setEnabledAt(4,true);
    			jtab.setEnabledAt(5,true);
    		}
    		
    	});
    	panel2.add(btn1);
    	this.add(panel3,BorderLayout.SOUTH);
    	}

    }

    class JPanel066 extends JPanel{
    	JCheckBox [] checkbox=new JCheckBox[6];
    	String[] side= {"���� ��������","�ؽ�����"};
    	String[] soup= {"����ݸ� ����","������ ����"};
    	String[] cookie= {"���� ����Ĩ ��Ű","����Ĩ ��Ű","��Ʈ�� ������",
    			"����� ġ������","ȭ��Ʈ ���� ��ī�ٹ̾�"};
    	String[] drink= {"�ݶ�","���̴�","Ŀ��"};
    	JLabel help,label1,label2,label3,label4;
    	JLabel tap1,tap2,tap3,tap4;
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel066(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		Border border = BorderFactory.createTitledBorder("�߰� ��Ʈ ��ǰ�� ����ּ���.");
    		panel1.setBorder(border);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(7,3,7,7));
    		tap1=new JLabel("");
    		tap2=new JLabel("");
    		tap3=new JLabel("");
    		tap4=new JLabel("");
    		this.add(panel1, BorderLayout.NORTH);
    		label1=new JLabel("          ���̵�:");
    		panel1.add(label1);
    		for(int i=0;i<side.length;i++) {
    			checkbox[i]=new JCheckBox(side[i]);
    			panel1.add(checkbox[i]);
    		}
    		label2=new JLabel("              ����:");
    		panel1.add(label2);
    		for(int i=0;i<soup.length;i++) {
    			checkbox[i]=new JCheckBox(soup[i]);
    			panel1.add(checkbox[i]);
    		}
    		label3=new JLabel("              ��Ű:");
    		panel1.add(label3);
    		for(int i=0;i<2;i++) {
    			checkbox[i]=new JCheckBox(cookie[i]);
    			panel1.add(checkbox[i]);
    		}
    		panel1.add(tap1);
    		for(int i=2;i<4;i++) {
    			checkbox[i]=new JCheckBox(cookie[i]);
    			panel1.add(checkbox[i]);
    		}
    		panel1.add(tap2);
    		for(int i=4;i<cookie.length;i++) {
    			checkbox[i]=new JCheckBox(cookie[i]);
    			panel1.add(checkbox[i]);
    		}
    		panel1.add(tap4);
    		label4=new JLabel("              ����:");
    		panel1.add(label4);
    		for(int i=0;i<2;i++) {
    			checkbox[i]=new JCheckBox(drink[i]);
    			panel1.add(checkbox[i]);
    		}
    		panel1.add(tap3);
    		for(int i=2;i<drink.length;i++) {
    			checkbox[i]=new JCheckBox(drink[i]);
    			panel1.add(checkbox[i]);
    		}
    		this.add(panel2, BorderLayout.CENTER);
    		btn1=new JButton("Ȯ��");
    		btn1.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				// TODO Auto-generated method stub
    				jtab.setSelectedIndex(6);
    				jtab.setEnabledAt(0,true);
    				jtab.setEnabledAt(1,true);
    				jtab.setEnabledAt(2,true);
    				jtab.setEnabledAt(3,true);
    				jtab.setEnabledAt(4,true);
    				jtab.setEnabledAt(5,true);
    				jtab.setEnabledAt(6,true);
    			}
    			
    		});
    		panel2.add(btn1);
    		this.add(panel3,BorderLayout.SOUTH);
    	}

    }
    	
    	JPanel011 jpanel1=null;
    	JPanel022 jpanel2=null;
    	JPanel033 jpanel3=null;
    	JPanel044 jpanel4=null;
    	JPanel055 jpanel5=null;
    	JPanel066 jpanel6=null;

    	JTabbedPane jtab=new JTabbedPane();
    	
    	public SelfView() {
    		setTitle("Which Sandwich?");

    		jpanel1=new JPanel011();
    		jpanel2=new JPanel022();
    		jpanel3=new JPanel033();
    		jpanel4=new JPanel044();
    		jpanel5=new JPanel055();
    		jpanel6=new JPanel066();
    		
    		jtab.addTab("�޴�", jpanel1);
    		jtab.addTab("��", jpanel2);
    		jtab.addTab("�߰�����", jpanel3);
    		jtab.addTab("��ä", jpanel4);
    		jtab.addTab("�ҽ�", jpanel5);
    		jtab.addTab("��Ʈ", jpanel6);
    		
    		for(int i=1;i<jtab.getTabCount();i++)
    			jtab.setEnabledAt(i, false);
    		
    		add(jtab);
    		
    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		setSize(550,700);
    		setVisible(true);
    	}
    	
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
    		
    	}

    	@Override
    	public void itemStateChanged(ItemEvent arg0) {
    		// TODO Auto-generated method stub
    		
    	}
}
