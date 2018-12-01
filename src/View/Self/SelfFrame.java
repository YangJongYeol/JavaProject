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
    	String[] menu= {"햄","참치","로스트 비프","에그마요","비엘티","미트볼","터키","베지"};
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
    		Border border = BorderFactory.createTitledBorder("원하는 샌드위치 메뉴를 선택하세요.");
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
    		btn1=new JButton("다음");
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
    	String[] bread= {"허니오트","하티","위트","파마산","화이트","플랫브래드"};
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
    		Border border = BorderFactory.createTitledBorder("빵 길이와 종류를 각각 선택하세요.");
    		panel1.setBorder(border);
    		this.add(panel1, BorderLayout.NORTH);
    		label1=new JLabel("빵 길이:");
    		panel1.add(label1);
    		for(int i=0;i<size.length;i++) {
    			radio2[i]=new JRadioButton(size[i]);
    			panel1.add(radio2[i]);
    			group1.add(radio2[i]);
    		}
    		tab1=new JLabel("");
    		panel1.add(tab1);
    		label2=new JLabel("빵 종류:");
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
    		btn1=new JButton("다음");
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
    	String[] topping= {"에그마요","오믈렛","아보카도","베이컨","페퍼로니","더블치즈"};
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel033(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(2,3,10,10));
    		Border border = BorderFactory.createTitledBorder("토핑은 복수선택이 가능합니다.");
    		panel1.setBorder(border);
    		this.add(panel1, BorderLayout.NORTH);
    		for(int i=0;i<topping.length;i++) {
    			checkbox[i]=new JCheckBox(topping[i]);
    			panel1.add(checkbox[i]);
    		}
    		this.add(panel2, BorderLayout.CENTER);
    		btn1=new JButton("다음");
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
    	String[] vege= {"양상추","토마토","오이","피망",
    			"양파","피클","올리브","할라피뇨","아메리칸치즈"};
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel044(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		Border border = BorderFactory.createTitledBorder("빼고자 하는 야채의 체크표시를 풀어주세요.");
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
    		btn1=new JButton("다음");
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
    	String[] sauce= {"리치시저","렌치드레싱","마요네즈","스위트어니언",
    			"허니머스타드","스위트칠리","핫칠리","사우스웨스트","홀스래디쉬",
    			"사우전아일랜드","이탈리안드레싱","스모크바비큐"};
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel055(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		Border border = BorderFactory.createTitledBorder("원하는 소스를 골라주세요. 복수선택 가능합니다");
    		panel1.setBorder(border);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(3,4,10,10));
    		this.add(panel1, BorderLayout.NORTH);;
    		for(int i=0;i<sauce.length;i++) {
    			checkbox[i]=new JCheckBox(sauce[i]);
    			panel1.add(checkbox[i]);
    		}
    	this.add(panel2, BorderLayout.CENTER);
    	btn1=new JButton("다음");
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
    	String[] side= {"웨지 포테이토","해쉬브라운"};
    	String[] soup= {"브로콜리 수프","베이컨 수프"};
    	String[] cookie= {"더블 초코칩 쿠키","초코칩 쿠키","오트밀 레이즌",
    			"라즈베리 치즈케익","화이트 초코 마카다미아"};
    	String[] drink= {"콜라","사이다","커피"};
    	JLabel help,label1,label2,label3,label4;
    	JLabel tap1,tap2,tap3,tap4;
    	JPanel panel1=new JPanel();
    	JPanel panel2=new JPanel();
    	JPanel panel3=new JPanel();
    	JButton btn1;
    	
    	JPanel066(){
    		this.setSize(550,700);
    		this.setLayout(new BorderLayout(0,10));
    		Border border = BorderFactory.createTitledBorder("추가 세트 상품을 골라주세요.");
    		panel1.setBorder(border);
    		this.setLayout(new BorderLayout(0,10));
    		panel1.setLayout(new GridLayout(7,3,7,7));
    		tap1=new JLabel("");
    		tap2=new JLabel("");
    		tap3=new JLabel("");
    		tap4=new JLabel("");
    		this.add(panel1, BorderLayout.NORTH);
    		label1=new JLabel("          사이드:");
    		panel1.add(label1);
    		for(int i=0;i<side.length;i++) {
    			checkbox[i]=new JCheckBox(side[i]);
    			panel1.add(checkbox[i]);
    		}
    		label2=new JLabel("              수프:");
    		panel1.add(label2);
    		for(int i=0;i<soup.length;i++) {
    			checkbox[i]=new JCheckBox(soup[i]);
    			panel1.add(checkbox[i]);
    		}
    		label3=new JLabel("              쿠키:");
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
    		label4=new JLabel("              음료:");
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
    		btn1=new JButton("확인");
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
    		
    		jtab.addTab("메뉴", jpanel1);
    		jtab.addTab("빵", jpanel2);
    		jtab.addTab("추가토핑", jpanel3);
    		jtab.addTab("야채", jpanel4);
    		jtab.addTab("소스", jpanel5);
    		jtab.addTab("세트", jpanel6);
    		
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
