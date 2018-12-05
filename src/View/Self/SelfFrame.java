package View.Self;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Controller.SelfController;
import Model.Content;
import Model.Ingredient;

public class SelfFrame extends JPanel {
//    public SelfFrame(SelfController controller) {
	public SelfController controller;
	JTabbedPane jtab;

	// 1. Panel
	class JPanel011 extends JPanel {

		JRadioButton[] radio = new JRadioButton[8];
		ButtonGroup group = new ButtonGroup();
		String[] menu = { "햄", "참치", "로스트 비프", "에그마요", "비엘티", "미트볼", "터키", "베지" };
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel[] picturePanel = new JPanel[8];
		JLabel[] pictureLabel = new JLabel[8];
		JButton btn1;
		CardLayout card = new CardLayout();
		ImageIcon[] icon = new ImageIcon[8];

		// JPanel 실행
		JPanel011() {
			// 1. VIEW
			this.setSize(550, 700);
			this.setLayout(new BorderLayout(0, 10));
			panel1.setLayout(new GridLayout(3, 4, 20, 10));
			Border border = BorderFactory.createTitledBorder("원하는 샌드위치 메뉴를 선택하세요.");
			panel1.setBorder(border);
			this.add(panel1, BorderLayout.NORTH);

			// 2. VIEW - CONTROLLER
			ArrayList<Content> arrayList = new ArrayList<Content>();
			arrayList = controller.getList(1);
			Iterator<Content> Iterator = arrayList.iterator();
			Content menuContent = new Content();

			for (int i = 0; i < arrayList.size(); i++) {
				menuContent = Iterator.next();
				radio[i] = new JRadioButton(menuContent.getTitle());
				panel1.add(radio[i]);
				group.add(radio[i]);

				radio[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {

						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED) {
							System.out.println("a");
							return;
						}
						for (int i = 0; i < pictureLabel.length; i++) {
							if (radio[i].isSelected()) {
								System.out.println("b");
								System.out.println(icon[i]);
								pictureLabel[i].setIcon(icon[i]);
								break;
							} else {
								System.out.println("c");
								pictureLabel[i].setIcon(null);
							}
						}
					}
				});

				Path currentRelativePath = Paths.get("");
				String s = currentRelativePath.toAbsolutePath().toString();
				System.out.println("Current relative path is: " + s);
				
				icon[i] = new ImageIcon("image/" + menu[i] + ".jpg"); // 이미지 파일 이름
				pictureLabel[i] = new JLabel("");
				panel3.add(pictureLabel[i]);
			}
			this.add(panel2, BorderLayout.SOUTH);

			btn1 = new JButton("다음");
			btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtab.setSelectedIndex(1);
					jtab.setEnabledAt(0, true);
					jtab.setEnabledAt(1, true);
				}
			});
			panel2.add(btn1);
			this.add(panel3, BorderLayout.CENTER);
			panel3.setLayout(card);

		}

	}

	class JPanel022 extends JPanel {
		String[] bread = {"허니오트", "하티", "위트", "파마산", "화이트", "플랫브래드"};
		String[] size = {"15cm", "30cm"};
		JRadioButton[] radio1 = new JRadioButton[6];
		JRadioButton[] radio2 = new JRadioButton[2];
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		JLabel label1;
		JLabel tab1, tab2;
		JLabel label2, help;
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JButton btn1;
		JLabel[] pictureLabel = new JLabel[6];
		ImageIcon[] icon = new ImageIcon[6];
		CardLayout card = new CardLayout();

		JPanel022() {
			this.setSize(550, 700);
			this.setLayout(new BorderLayout(0, 10));
			panel1.setLayout(new GridLayout(3, 3, 10, 10));
			Border border = BorderFactory.createTitledBorder("빵 길이와 종류를 각각 선택하세요.");
			panel1.setBorder(border);
			this.add(panel1, BorderLayout.NORTH);
			label1 = new JLabel("빵 길이:");
			panel1.add(label1);
			for (int i = 0; i < size.length; i++) {
				radio2[i] = new JRadioButton(size[i]);
				panel1.add(radio2[i]);
				group1.add(radio2[i]);
			}
			tab1 = new JLabel("");
			panel1.add(tab1);
			label2 = new JLabel("빵 종류:");
			panel1.add(label2);
			int i;
			for (i = 0; i < 3; i++) {
				radio1[i] = new JRadioButton(bread[i]);
				panel1.add(radio1[i]);
				group2.add(radio1[i]);
			}
			tab2 = new JLabel("");
			panel1.add(tab2);
			for (; i < bread.length; i++) {
				radio1[i] = new JRadioButton(bread[i]);
				panel1.add(radio1[i]);
				group2.add(radio1[i]);
			}
			this.add(panel2, BorderLayout.CENTER);
			for (int j = 0; j < bread.length; j++) {
				radio1[j].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int u = 0; u < pictureLabel.length; u++) {
							if (radio1[u].isSelected()) {
								pictureLabel[u].setIcon(icon[u]);
							} else
								pictureLabel[u].setIcon(null);
						}
					}
				});
				icon[j] = new ImageIcon("image/" + bread[j] + ".jpg"); // 이미지 파일 이름(빵 이미지)
				pictureLabel[j] = new JLabel("");
				panel2.add(pictureLabel[j]);
			}
			btn1 = new JButton("다음");
			btn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtab.setSelectedIndex(2);
					jtab.setEnabledAt(0, true);
					jtab.setEnabledAt(1, true);
					jtab.setEnabledAt(2, true);
				}

			});
			panel3.add(btn1);
			this.add(panel3, BorderLayout.SOUTH);
			panel3.setLayout(card);
		}
	}

	class JPanel033 extends JPanel {
		JCheckBox[] checkbox = new JCheckBox[6];
		String[] topping = { "에그마요", "오믈렛", "아보카도", "베이컨", "페퍼로니", "더블치즈" };
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JButton btn1;
		JLabel[] pictureLabel = new JLabel[6];
		ImageIcon[] icon = new ImageIcon[6];
		CardLayout card = new CardLayout();

		JPanel033() {
			this.setSize(550, 700);
			this.setLayout(new BorderLayout(0, 10));
			panel1.setLayout(new GridLayout(2, 3, 10, 10));
			Border border = BorderFactory.createTitledBorder("토핑은 복수선택이 가능합니다.");
			panel1.setBorder(border);
			this.add(panel1, BorderLayout.NORTH);
			for (int i = 0; i < topping.length; i++) {
				checkbox[i] = new JCheckBox(topping[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + topping[i] + ".jpg"); // 이미지 파일 이름(토핑 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			this.add(panel2, BorderLayout.CENTER);
			btn1 = new JButton("다음");
			btn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtab.setSelectedIndex(3);
					jtab.setEnabledAt(0, true);
					jtab.setEnabledAt(1, true);
					jtab.setEnabledAt(2, true);
					jtab.setEnabledAt(3, true);
				}

			});
			panel3.add(btn1);
			this.add(panel3, BorderLayout.SOUTH);
			panel3.setLayout(card);
		}

	}

	class JPanel044 extends JPanel {
		JCheckBox[] checkbox1 = new JCheckBox[9];
		String[] vege = { "양상추", "토마토", "오이", "피망", "양파", "피클", "올리브", "할라피뇨", "아메리칸치즈" };
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JButton btn1;
		JLabel[] pictureLabel = new JLabel[9];
		ImageIcon[] icon = new ImageIcon[9];
		CardLayout card = new CardLayout();

		JPanel044() {
			this.setSize(550, 700);
			this.setLayout(new BorderLayout(0, 10));
			Border border = BorderFactory.createTitledBorder("빼고자 하는 야채의 체크표시를 풀어주세요.");
			panel1.setBorder(border);
			this.setLayout(new BorderLayout(0, 10));
			panel1.setLayout(new GridLayout(3, 3, 10, 10));
			this.add(panel1, BorderLayout.NORTH);
			for (int i = 0; i < vege.length; i++) {
				checkbox1[i] = new JCheckBox(vege[i]);
				checkbox1[i].setSelected(true);
				panel1.add(checkbox1[i]);
				checkbox1[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox1[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + vege[i] + ".jpg"); // 이미지 파일 이름(야채 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			this.add(panel2, BorderLayout.CENTER);
			btn1 = new JButton("다음");
			btn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtab.setSelectedIndex(4);
					jtab.setEnabledAt(0, true);
					jtab.setEnabledAt(1, true);
					jtab.setEnabledAt(2, true);
					jtab.setEnabledAt(3, true);
					jtab.setEnabledAt(4, true);
				}

			});
			panel3.add(btn1);
			this.add(panel3, BorderLayout.SOUTH);
			panel3.setLayout(card);
		}

	}

	class JPanel055 extends JPanel {
		JCheckBox[] checkbox = new JCheckBox[12];
		String[] sauce = { "리치시저", "렌치드레싱", "마요네즈", "스위트어니언", "허니머스타드", "스위트칠리", "핫칠리", "사우스웨스트", "홀스래디쉬", "사우전아일랜드",
				"이탈리안드레싱", "스모크바비큐" };
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JButton btn1;
		JLabel[] pictureLabel = new JLabel[12];
		ImageIcon[] icon = new ImageIcon[12];
		CardLayout card = new CardLayout();

		JPanel055() {
			this.setSize(550, 700);
			this.setLayout(new BorderLayout(0, 10));
			Border border = BorderFactory.createTitledBorder("원하는 소스를 골라주세요. 복수선택 가능합니다");
			panel1.setBorder(border);
			this.setLayout(new BorderLayout(0, 10));
			panel1.setLayout(new GridLayout(3, 4, 10, 10));
			this.add(panel1, BorderLayout.NORTH);
			;
			for (int i = 0; i < sauce.length; i++) {
				checkbox[i] = new JCheckBox(sauce[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + sauce[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			this.add(panel2, BorderLayout.CENTER);
			btn1 = new JButton("다음");
			btn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtab.setSelectedIndex(5);
					jtab.setEnabledAt(0, true);
					jtab.setEnabledAt(1, true);
					jtab.setEnabledAt(2, true);
					jtab.setEnabledAt(3, true);
					jtab.setEnabledAt(4, true);
					jtab.setEnabledAt(5, true);
				}

			});
			panel3.add(btn1);
			this.add(panel3, BorderLayout.SOUTH);
			panel3.setLayout(card);
		}

	}

	class JPanel066 extends JPanel {
		JCheckBox[] checkbox = new JCheckBox[6];
		String[] side = { "웨지 포테이토", "해쉬브라운" };
		String[] soup = { "브로콜리 수프", "베이컨 수프" };
		String[] cookie = { "더블 초코칩 쿠키", "초코칩 쿠키", "오트밀 레이즌", "라즈베리 치즈케익", "화이트 초코 마카다미아" };
		String[] drink = { "콜라", "사이다", "커피" };
		JLabel help, label1, label2, label3, label4;
		JLabel tap1, tap2, tap3, tap4;
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JButton btn1;
		JLabel[] pictureLabel = new JLabel[12];
		ImageIcon[] icon = new ImageIcon[12];
		CardLayout card = new CardLayout();

		JPanel066() {
			this.setSize(550, 700);
			this.setLayout(new BorderLayout(0, 10));
			Border border = BorderFactory.createTitledBorder("추가 세트 상품을 골라주세요.");
			panel1.setBorder(border);
			this.setLayout(new BorderLayout(0, 10));
			panel1.setLayout(new GridLayout(7, 3, 7, 7));
			tap1 = new JLabel("");
			tap2 = new JLabel("");
			tap3 = new JLabel("");
			tap4 = new JLabel("");
			this.add(panel1, BorderLayout.NORTH);
			label1 = new JLabel("          사이드:");
			panel1.add(label1);
			for (int i = 0; i < side.length; i++) {
				checkbox[i] = new JCheckBox(side[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + side[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			label2 = new JLabel("              수프:");
			panel1.add(label2);
			for (int i = 0; i < soup.length; i++) {
				checkbox[i] = new JCheckBox(soup[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + soup[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			label3 = new JLabel("              쿠키:");
			panel1.add(label3);
			for (int i = 0; i < 2; i++) {
				checkbox[i] = new JCheckBox(cookie[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + cookie[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			panel1.add(tap1);
			for (int i = 2; i < 4; i++) {
				checkbox[i] = new JCheckBox(cookie[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + cookie[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			panel1.add(tap2);
			for (int i = 4; i < cookie.length; i++) {
				checkbox[i] = new JCheckBox(cookie[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + cookie[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			panel1.add(tap4);
			label4 = new JLabel("              음료:");
			panel1.add(label4);
			for (int i = 0; i < 2; i++) {
				checkbox[i] = new JCheckBox(drink[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + drink[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			panel1.add(tap3);
			for (int i = 2; i < drink.length; i++) {
				checkbox[i] = new JCheckBox(drink[i]);
				panel1.add(checkbox[i]);
				checkbox[i].addItemListener(new ItemListener() { // 사진 출력

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.DESELECTED)
							return;
						for (int i = 0; i < pictureLabel.length; i++) {
							if (checkbox[i].isSelected()) {
								pictureLabel[i].setIcon(icon[i]);
							} else
								pictureLabel[i].setIcon(null);
						}
					}
				});
				icon[i] = new ImageIcon("image/" + drink[i] + ".jpg"); // 이미지 파일 이름(소스 이미지)
				pictureLabel[i] = new JLabel("");
				panel2.add(pictureLabel[i]);
			}
			this.add(panel2, BorderLayout.CENTER);
			btn1 = new JButton("확인");
			btn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtab.setSelectedIndex(6);
					jtab.setEnabledAt(0, true);
					jtab.setEnabledAt(1, true);
					jtab.setEnabledAt(2, true);
					jtab.setEnabledAt(3, true);
					jtab.setEnabledAt(4, true);
					jtab.setEnabledAt(5, true);
					jtab.setEnabledAt(6, true);
				}

			});
			panel3.add(btn1);
			this.add(panel3, BorderLayout.SOUTH);
			panel3.setLayout(card);
		}

	}

	public SelfFrame(SelfController controller) {
		this.controller = controller;

		jtab = new JTabbedPane();
		JPanel011 jpanel1 = new JPanel011();
		JPanel022 jpanel2 = new JPanel022();
		JPanel033 jpanel3 = new JPanel033();
		JPanel044 jpanel4 = new JPanel044();
		JPanel055 jpanel5 = new JPanel055();
		JPanel066 jpanel6 = new JPanel066();

		// setTitle("Which Sandwich?");

		// 1. jtab 세팅
		jtab.addTab("메뉴", jpanel1);
		jtab.addTab("빵", jpanel2);
		jtab.addTab("추가토핑", jpanel3);
		jtab.addTab("야채", jpanel4);
		jtab.addTab("소스", jpanel5);
		jtab.addTab("세트", jpanel6);
		for (int i = 1; i < jtab.getTabCount(); i++)
			jtab.setEnabledAt(i, false);
		add(jtab);

		// 2. (기존)버튼
		/*
		 * JButton button = new JButton("Button_Self"); button.setBounds(10,10,10,10);
		 * button.addActionListener(new MyActionListener()); add(button); JButton
		 * button1 = new JButton("STEP1"); button1.setBounds(10,10,10,10);
		 * button1.addActionListener(new MyActionListener());
		 * button1.setActionCommand("1"); add(button1); JButton button2 = new
		 * JButton("STEP2"); button2.setBounds(10,10,10,10);
		 * button2.addActionListener(new MyActionListener());
		 * button2.setActionCommand("2"); add(button2); JButton button3 = new
		 * JButton("STEP3"); button3.setBounds(10,10,10,10);
		 * button3.addActionListener(new MyActionListener());
		 * button3.setActionCommand("3"); add(button3); JButton button4 = new
		 * JButton("STEP4"); button4.setBounds(10,10,10,10);
		 * button4.addActionListener(new MyActionListener());
		 * button4.setActionCommand("4"); add(button4);
		 */
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 700);
		setVisible(true);

	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(controller, "click");

			// step의 입력값(setActionCommand로 입력한 값)에 따라서 다른 데이터 출력)
			String command = e.getActionCommand();
			if (e.getActionCommand().equals(command)) {
				int step = Integer.parseInt(command);
				ArrayList<Content> arrayList = new ArrayList<Content>();
				arrayList = controller.getList(step);
				Iterator<Content> Iterator = arrayList.iterator();
				// Iterator를 통해 값 반환
				while (Iterator.hasNext()) {
					// System.out.println(Iterator.next().getId());
					System.out.println(Iterator.next().getTitle());
					// System.out.println(Iterator.next().getImg());
				}
			}
		}

	}

}
